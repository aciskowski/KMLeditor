package Main;

import java.awt.EventQueue;
import java.io.File;
import java.io.FileNotFoundException;

import Controller.CheckPanelControl;
import Controller.DownloadPanelControl;
import Controller.EditPanelControl;
import Controller.GeneratePanelControl;
import Controller.MainPanelControl;
import Controller.MainViewControl;
import Model.CSVModel;
import Model.DownloadModel;
import Model.KMLFile;
import Model.KMLModel;
import Model.Model;
import View.CheckPanel;
import View.DownloadPanel;
import View.EditPanel;
import View.GeneratePanel;
import View.MainPanel;
import View.MainView;
import View.OptionPane;


public class Main {
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				
				Model m = new Model();
				KMLModel kmlM = new KMLModel();
				CSVModel csvM = new CSVModel();
				DownloadModel dm = new DownloadModel();
				

				MainPanel mp = new MainPanel();
				DownloadPanel dp = new DownloadPanel();
				EditPanel ep = new EditPanel();
				GeneratePanel gp = new GeneratePanel();
				CheckPanel cp = new CheckPanel();
				MainView mv = new MainView(mp, gp, ep, dp,cp);
				
				OptionPane op = new OptionPane();
				
				MainPanelControl mpc = new MainPanelControl(mp, m);
				DownloadPanelControl dpc = new DownloadPanelControl(dp, m, dm, kmlM);
				EditPanelControl epc = new EditPanelControl(ep, op, m, kmlM);
				GeneratePanelControl gpc = new GeneratePanelControl(gp, op, m, kmlM, csvM);
				CheckPanelControl cpc = new CheckPanelControl(cp, m, kmlM);
				MainViewControl mvc = new MainViewControl(mv, m);
				
			}
		});

		
		
//		CSVModel csvM = new CSVModel();
//		csvM.readCSV("C:\\Users\\a.ciskowski\\Desktop\\LM_driven.csv");
////		System.out.println(csvM.getCoordinates().get(1).getMsgTime());
//		double dis;
//		dis = csvM.distance(csvM.getCoordinates().get(0).getLatDouble(), csvM.getCoordinates().get(1).getLatDouble(), csvM.getCoordinates().get(0).getLonDouble(), csvM.getCoordinates().get(1).getLonDouble(), 0, 0);
//		System.out.println(dis);
		
		
//		KMLFile kmlF = new KMLFile();
//		kmlF.setDocumentName("dupa");
//		kmlF.addLineStyle("ff000000",25);
//		kmlF.addPoligonStyle("ff000000", 25, "ff000000", true, true);
//		kmlF.addLineMap();
//		kmlF.addFolder("dupa");
//		kmlF.addFolder("dupa1");
//		try {
//			kmlF.getKml().marshal(System.out);
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		

		
//		kmlM.readKML("C:\\Users\\a.ciskowski\\Desktop\\Sachsen_test\\C1.kml");
////		kmlM.namePoints();		
////		kmlM.splitKml();
////		kmlM.saveKmlList("C:\\Users\\a.ciskowski\\Desktop\\Sachsen_test");
//		kmlM.changeAllLines(25, "ff0051e6");
//		kmlM.saveKml("C:\\Users\\a.ciskowski\\Desktop\\Sachsen_test");
	}

}
