 package Controller;


import java.util.List;

import javax.swing.SwingWorker;

import Model.DownloadModel;
import Model.KMLModel;
import Model.Model;
import Model.Model.STATE;
import View.DownloadPanel;
import View.OptionPane;

public class DownloadPanelControl {

	
	private DownloadPanel downloadPanel;
	private Model model;
	private DownloadModel downloadModel;
	private KMLModel kmlModel;
	
	public DownloadPanelControl(DownloadPanel downloadPanel, Model model, DownloadModel downloadModel, KMLModel kmlModel) {
		this.downloadPanel = downloadPanel;
		this.model = model;
		this.downloadModel = downloadModel;
		this.kmlModel = kmlModel;
		
		downloadPanel.addBackListener(e -> goBack());
		downloadPanel.addBrowseListener(e -> browse());
		downloadPanel.addBrowseLayersListener(e -> browseSplited());
		downloadPanel.addDownloadListener(e -> download());
		downloadPanel.addClearListener(e -> clear());
				
	}
	
	private void goBack() {
		model.setActive(STATE.main);
	}
	
	private void browse() {
		downloadPanel.getSaveField().setText(downloadPanel.getChoosenPath("Choose path")); 
		downloadModel.setSavePath(downloadPanel.getSaveField().getText());	
	}
	
	private void browseSplited() {
		downloadPanel.getSaveLayersField().setText(downloadPanel.getChoosenPath("Choose path for Layers"));
	}
	
	private void clear() {
		downloadPanel.getLinkField().setText("");
		downloadPanel.getNameField().setText("");
		downloadPanel.getSaveField().setText("");
		downloadPanel.getSaveLayersField().setText("");
		downloadPanel.getLogText().setText("");
		downloadPanel.getSplitRadioBtn().setSelected(false);
		downloadPanel.getProgressBar().setValue(0);
	}
	
	private void download() {
		
		SwingWorker<Void, String> worker = new SwingWorker<Void, String>(){

			@Override
			protected Void doInBackground() throws Exception {
				// TODO Auto-generated method stub
				setProgress(0);
				downloadModel.setKMLname(downloadPanel.getNameField().getText());
				downloadModel.setMapLink(downloadPanel.getLinkField().getText());
				publish("Downloading KML file...");
				downloadModel.createDownloadLink();
				downloadModel.downloadKML();
				publish("KML file download finished...");
				
				if (downloadPanel.getSplitRadioBtn().isSelected()) {
					kmlModel.readKML(downloadModel.getKMLPath());
					publish("Spliting KML...");
					kmlModel.splitKml();
					setProgress(50);
					kmlModel.saveKmlList(downloadModel.getSavePath());
					publish("KML splited...");
				}
				
				return null;
			}						
			
			@Override
			protected void process(List<String> chunks) {
				// TODO Auto-generated method stub
				
				for(String string:chunks) {
					downloadPanel.getLogText().setText(downloadPanel.getLogText().getText() + "\n"+string);
				}
				
				downloadPanel.getProgressBar().setValue(getProgress());

				
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
}
