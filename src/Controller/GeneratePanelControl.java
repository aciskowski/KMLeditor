package Controller;

import java.io.File;
import java.util.List;

import javax.swing.SwingWorker;

import Model.CSVModel;
import Model.Coor;
import Model.KMLFile;
import Model.KMLModel;
import Model.Model;
import Model.Model.STATE;
import View.GeneratePanel;
import View.OptionPane;

public class GeneratePanelControl {

	private GeneratePanel generatePanel;
	private OptionPane optionPane;
	private Model model;
	private KMLModel kmlModel;
	private CSVModel csvModel;
	
	public GeneratePanelControl(GeneratePanel generatePanel, OptionPane optionPane, Model model, KMLModel kmlModel, CSVModel csvModel) {
		
		this.generatePanel = generatePanel;
		this.optionPane = optionPane;
		this.model = model;
		this.kmlModel = kmlModel;
		this.csvModel = csvModel;
		
		generatePanel.addBackListener(e -> goBack());
		generatePanel.addAddListener(e -> addFiles());
		generatePanel.addClearListener(e ->clear());
		generatePanel.addBrowseListener(e -> browse());
		generatePanel.addGenerateListener(e -> generate());

	}
	
	
	private void goBack() {
		model.setActive(STATE.main);
	}
	
	private void addFiles() {
		File[] files = generatePanel.getFiles("Choose CSV files");
//		editPanel.getKMLList().setListData(files);
		
		for(int i = 0;i<files.length;i++){
			generatePanel.getListModel().add(i, files[i]);
		}
	}
	
	private void clear() {
		generatePanel.getListModel().clear();
		generatePanel.getSaveTextField().setText("");
		generatePanel.getTextPane().setText("");
		generatePanel.getProgressBar().setValue(0);
	}
	
	private void browse() {
		generatePanel.getSaveTextField().setText(generatePanel.getChossenPath("Choose path to safe KML files"));
	}
	
	private void generate() {
		
		SwingWorker<Void, String> worker = new SwingWorker<Void, String>(){
			
			File file;
			Coor coor;
			String name;
			
			@Override
			protected Void doInBackground() throws Exception {
				// TODO Auto-generated method stub

				int indexPLacemark=1;
				
				setProgress(0);
				
				for(int i =0;i<generatePanel.getListModel().size();i++) {
					KMLFile kmlFile = new KMLFile();
					file = (File) generatePanel.getListModel().get(i);
					name = file.getName().replaceFirst("[.][^.]+$", "");
					publish("Processing "+ file.getName() +"...");
					
	//				setProgress(i*100/generatePanel.getListModel().size());
					
					csvModel.readCSV(file);
						// wersja dla jednego pliku kml, rozbudowac
					kmlFile.setDocumentName(name);
					kmlFile.addLineStyle("ff000000", 25);
					kmlFile.addLineMap();
					kmlFile.addFolder(name);
					kmlFile.addPlacemarkWithLineString(name +"_road" + indexPLacemark);
					
					for(int j=1; j<csvModel.getCoordinates().size();j++) {
						
						coor = csvModel.getCoordinates().get(j);
						
						if(model.distance(csvModel.getCoordinates().get(j).getLat(), csvModel.getCoordinates().get(j-1).getLat(), csvModel.getCoordinates().get(j).getLon(), csvModel.getCoordinates().get(j-1).getLon(), 0, 0)>5000) {
							indexPLacemark++;
							kmlFile.addPlacemarkWithLineString(name +"_road" + indexPLacemark);
						}
						setProgress(((j*100)/csvModel.getCoordinates().size()));
						
						kmlFile.addCoordinate(coor.getLon(), coor.getLat());
//						setProgress((j/csvModel.getCoordinates().size())*(i+1)*100);
					}
					
					indexPLacemark =1;
					
					kmlModel.readKML(kmlFile.getKml());
					kmlModel.saveKml(generatePanel.getSaveTextField().getText());
					csvModel.clearCSV();
					kmlFile = null;
					

					publish(file.getName() + " PROCESSED\n");
				}
				
				return null;
			}
			
			@Override
			protected void process(List<String> chunks) {
				// TODO Auto-generated method stub
				for(String string:chunks) {
					generatePanel.getTextPane().setText(generatePanel.getTextPane().getText() + string + "\n");
				}
				
				generatePanel.getProgressBar().setValue(getProgress());
			}
			
			@Override
			protected void done() {
				// TODO Auto-generated method stub
				try {
					Thread.sleep(5);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				publish("DONE.\n");
				setProgress(100);
				
			}
			
		};
		
		worker.execute();
		

	}
	
	
}
