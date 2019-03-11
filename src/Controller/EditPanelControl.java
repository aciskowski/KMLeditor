package Controller;

import java.io.File;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.SwingWorker;

import Model.KMLModel;
import Model.Model;
import Model.Model.STATE;
import View.EditPanel;
import View.OptionPane;
import de.micromata.opengis.kml.v_2_2_0.Kml;

public class EditPanelControl {

	private EditPanel editPanel;
	private OptionPane optionPane;
	private Model model;
	private KMLModel kmlModel;
	
	public EditPanelControl(EditPanel editPanel, OptionPane optionPane, Model model, KMLModel kmlModel) {
		
		this.editPanel = editPanel;
		this.optionPane = optionPane;
		this.model = model;
		this.kmlModel = kmlModel;
		
		editPanel.addBackListener(e -> goBack());
		editPanel.addClearListener(e -> clear());
		editPanel.addAddListener(e -> addFiles());
		editPanel.addEditListener(e -> edit());
		editPanel.addPropertiesListener(e -> changeProperties());
		
	}
	
	private String colorBoxRecal(int i) {
		
		switch(i) {
		case 0: return "ff0051e6"; 
		case 1: return "ffd18802";
		case 2: return "ff2f8b55";
		case 3: return "ff000000";
		case 4: return "ff7f0000";
		
		default: return "ffd18802";
		
		}
	}
	
	private void goBack() {
		model.setActive(STATE.main);
	}
	
	private void clear() {
		editPanel.getListModel().clear();;
		editPanel.getLogTxt().setText("");	
		editPanel.getProgressBar_1().setValue(0);
	}
	
	private void addFiles() {
		File[] files = editPanel.getFiles("Choose KML files for edit");
//		editPanel.getKMLList().setListData(files);
		
		for(int i = 0;i<files.length;i++){
			editPanel.getListModel().add(i, files[i]);
		}		
	}
	
	private void edit() {
		
		SwingWorker<Void, String> worker = new SwingWorker<Void, String>(){

			@Override
			protected Void doInBackground() throws Exception {
				// TODO Auto-generated method stub
				File file;
				setProgress(0);
				for(int i =0;i<editPanel.getListModel().size();i++) {
					file = (File) editPanel.getListModel().get(i);
					publish("Processing " + file.getName() +"...");
					kmlModel.readKML(file);
					kmlModel.changeAllLines(optionPane.getSlider().getValue(), colorBoxRecal(optionPane.getComboBox().getSelectedIndex()));	
					
					if(optionPane.getRadioABC().isSelected()) {
						kmlModel.namePoints(true);
					}else if(optionPane.getRadio123().isSelected()){
						kmlModel.namePoints(false);
					}
					
					kmlModel.saveKml(file);
					publish(file.getName() + " PROCESSED\n");
					setProgress(i/editPanel.getListModel().size()*100);
				}
				return null;
			}
			
			@Override
			protected void process(List<String> chunks) {
				// TODO Auto-generated method stub
				for(String string:chunks) {
					editPanel.getLogTxt().setText(editPanel.getLogTxt().getText()  +string+ "\n");
				}
				
				editPanel.getProgressBar_1().setValue(getProgress());
//				super.process(chunks);
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
				
//				super.done();
			}	
		};
		
		worker.execute();

		
	}
	
	private void changeProperties() {
		int i = optionPane.optionPicked();	
	}
	
		
}
