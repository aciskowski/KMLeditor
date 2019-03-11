package Controller;

import Model.KMLFile;
import Model.Model;
import Model.Model.STATE;
import View.MainPanel;
import View.MainView;

public class MainPanelControl {

	private MainPanel mainPanel;
	private Model model;
	
	public MainPanelControl(MainPanel mainPanel, Model model) {
		
		this.mainPanel = mainPanel;
		this.model = model;;
						
		
		mainPanel.addDownloadListener(e->changePanelToDownload());
		mainPanel.addEditListener(e -> changePanelToEdit());
		mainPanel.addGenerateListener(e-> changePanelToGenerate());
		mainPanel.addCheckListener(e -> changePanelToCheck());
	}
	
	private void changePanelToDownload() {
		model.setActive(STATE.download);
	}
	
	private void changePanelToEdit() {
		
		model.setActive(STATE.edit);
	}
	
	private void changePanelToGenerate() {
		model.setActive(STATE.generate);
	}
	
	private void changePanelToCheck() {
		model.setActive(STATE.check);
	}
	
	
}
