package Controller;

import java.awt.Color;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import Model.Coor;
import Model.KMLModel;
import Model.Model;
import Model.Model.STATE;
import View.CheckPanel;
import de.micromata.opengis.kml.v_2_2_0.Kml;

public class CheckPanelControl {

	private CheckPanel checkPanel;
	private Model model;
	private KMLModel kmlModel;
	
	public CheckPanelControl(CheckPanel checkPanel, Model model, KMLModel kmlModel){
		this.checkPanel = checkPanel;
		this.model = model;
		this.kmlModel = kmlModel;
		
		checkPanel.addBackListener(e -> goBack());
		checkPanel.addAddListener(e -> addFiles());
		checkPanel.addClearListener(e -> clear());
		checkPanel.addChangeListListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {	
				if(e.getValueIsAdjusting() == false && checkPanel.getList().getSelectedIndex() >-1) {
					readKmlDetails();
				}
			}
			
		});
		
		checkPanel.addChangeTableListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
				if(e.getValueIsAdjusting() == false) {
					calculateSum();
					calculateTime();
				}
				
			}
		});
		
//		checkPanel.addAvarageChangeListener(new DocumentListener() {
//			
//			@Override
//			public void removeUpdate(DocumentEvent e) {
//				// TODO Auto-generated method stub
////				calculateTime();
//			}
//			
//			@Override
//			public void insertUpdate(DocumentEvent e) {
//				// TODO Auto-generated method stub
//				calculateTime();
//			}
//			
//			@Override
//			public void changedUpdate(DocumentEvent e) {
//				// TODO Auto-generated method stub
//				calculateTime();
//			}
//		});
		
//		checkPanel.addAvarageChangeListener(new PropertyChangeListener() {
//			
//			@Override
//			public void propertyChange(PropertyChangeEvent evt) {
//				// TODO Auto-generated method stub
//				calculateTime();
//				
//			}
//		});
	}
	
	private void goBack() {
		model.setActive(STATE.main);
	}
	
	private void addFiles() {
		File[] files = checkPanel.getFiles("Choose KML files");
//		editPanel.getKMLList().setListData(files);
		
		for(int i = 0;i<files.length;i++){
			checkPanel.getListModel().add(i, files[i]);
		}
		
		checkPanel.getAvarageTextField().setText("40");
	}
	
	private void readKmlDetails() {
		File file = (File) checkPanel.getList().getSelectedValue();
		kmlModel.readKML(file);
		kmlModel.createPlacemarksList();
		
		String[] fileName = {file.getName(),"","",""};
		clearTable();
		
		checkPanel.getTableModel().addRow(fileName);
		for(int i=0; i<kmlModel.getPlacemarks().size();i++) {
			
			double distance = 0;
			kmlModel.createLinesListForPlacemark(kmlModel.getPlacemarks().get(i));
			
			for (int j=0;j<kmlModel.getLineStrings().size();j++) {
				List<Coor> coors = kmlModel.getCoordinatesLineString(kmlModel.getLineStrings().get(j));
				for(int k =1;k<coors.size();k++) {
					distance = distance + model.distance(coors.get(k).getLat(), coors.get(k-1).getLat(), coors.get(k).getLon(), coors.get(k-1).getLon(), 0, 0);
				}
			}
			
			String data[] = {"", kmlModel.getPlacemarks().get(i).getName(), kmlModel.getGeometryName(kmlModel.getPlacemarks().get(i)), Double.toString(Math.round(distance/1000))};
			checkPanel.getTableModel().addRow(data);
		}
		
	}

	
	private void calculateSum() {
//		int[] cols = checkPanel.getTable().getSelectedColumns();
		int[] rows = checkPanel.getTable().getSelectedRows();
		double sum =0;
		
		for(int i=0;i<rows.length;i++) {
			if (checkPanel.getTable().getSelectedColumn() == 3 && checkPanel.getTable().getSelectedRow() != 0) {
				sum = sum + Double.parseDouble((String) checkPanel.getTable().getValueAt(rows[i], 3));
			}
		}
		checkPanel.getSumTextField().setText(Double.toString(sum));

	}
	
	private void calculateTime() {
		
		double km = Double.parseDouble(checkPanel.getSumTextField().getText());
		double avarage = 1;
		double time =0;
		int hh;
		int mm;
		
		if(!checkPanel.getAvarageTextField().getText().isEmpty()) {
			avarage = Double.parseDouble(checkPanel.getAvarageTextField().getText());
			time = km/avarage;
			
			hh = (int) time;
			mm = (int) ((time - hh)*60);
			System.out.println(hh);
			System.out.println(mm);
			checkPanel.getTimeTextField().setText(Integer.toString(hh)+":"+Integer.toString(mm));
		}else {
			checkPanel.getTimeTextField().setText("0");
		}
			
//		if(){
			
//			System.out.println(checkPanel.getAvarageTextField().getText());
//		}
	}
	
	private void clearTable() {
		for(int i = checkPanel.getTableModel().getRowCount()-1; i>=0; i--) {
			checkPanel.getTableModel().removeRow(i);
		}
	}
	
	private void clear() {
		clearTable();
//		checkPanel.getList().clearSelection();
		checkPanel.getListModel().clear();
	}
}
