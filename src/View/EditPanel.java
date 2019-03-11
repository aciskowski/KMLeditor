package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.List;
import java.util.Random;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import net.miginfocom.swing.MigLayout;
import javax.swing.JTextPane;

public class EditPanel {
	
	private JPanel editPanel;
	
	private JLabel editTitleLbl;
	private JLabel fileListLbl;
	private JButton AddFilesBtn;
	private JButton ClearBtn; 
	private JButton EditexecBtn;
	private JLabel lblProgress;
	private JProgressBar progressBar_1;
	private JList KMLList;
	private DefaultListModel listModel;
	private JButton backBtn;
	private JButton btnProperties;
	private JTextPane logTxt;
	private JLabel lblLogChange;
	
	private JScrollPane scrollPane1;
	private JScrollPane scrollPane2;
	
	private JFileChooser fc;
	
	private Random random = new Random();
	
	public EditPanel() {
		editPanel = new JPanel();
		editPanel.setBackground(new Color(random.nextInt(255),random.nextInt(255),random.nextInt(255)));
		editPanel.setLayout(new MigLayout("", "[167.00]40[51.00][grow]", "[60.00]40[57.00][56.00,grow][58.00][57.00][49.00][48.00]30[][91.00,grow]10[53.00][57.00]10[81.00]30[78.00]"));
		
		editTitleLbl = new JLabel("Edit KML");
		editTitleLbl.setFont(new Font("Tahoma", Font.BOLD, 16));
		editPanel.add(editTitleLbl, "cell 0 0 3 1,alignx center,aligny center");
		
		fileListLbl = new JLabel("List of files:");
		fileListLbl.setFont(new Font("Tahoma", Font.BOLD, 14));
		editPanel.add(fileListLbl, "cell 0 1");
		
		listModel = new DefaultListModel();
		KMLList = new JList(listModel);
		KMLList.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		scrollPane1 = new JScrollPane(KMLList);
		editPanel.add(scrollPane1, "cell 0 2 3 4,grow");
		
		AddFilesBtn = new JButton("Add KML files");
		editPanel.add(AddFilesBtn, "cell 0 6 2 1,grow");
		
		btnProperties = new JButton("PROPERTIES");
		editPanel.add(btnProperties, "cell 2 6,grow");
		
		lblLogChange = new JLabel("Log change:");
		lblLogChange.setFont(new Font("Tahoma", Font.BOLD, 14));
		editPanel.add(lblLogChange, "cell 0 7");
		
		logTxt = new JTextPane();
		logTxt.setEditable(false);
		logTxt.setFont(new Font("Tahoma", Font.PLAIN, 8));
		scrollPane2 = new JScrollPane(logTxt);
		editPanel.add(scrollPane2, "cell 0 8 3 1,grow");
		
		lblProgress = new JLabel("Progress:");
		lblProgress.setFont(new Font("Tahoma", Font.BOLD, 14));
		editPanel.add(lblProgress, "cell 0 9,growx,aligny center");
		
		progressBar_1 = new JProgressBar();
		editPanel.add(progressBar_1, "cell 0 10 3 1,grow");
		
		ClearBtn = new JButton("Clear everything!");
		editPanel.add(ClearBtn, "cell 0 11,grow");
		
		backBtn = new JButton("Back");
		editPanel.add(backBtn, "cell 0 12,grow");
		
		EditexecBtn = new JButton("Edit!");
		editPanel.add(EditexecBtn, "cell 2 12,grow");
		
		fc = new JFileChooser();
		
	}
	
	public DefaultListModel getListModel() {
		return listModel;
	}

	public JPanel getEditPanel() {
		return editPanel;
	}

	public JButton getAddFilesBtn() {
		return AddFilesBtn;
	}

	public JButton getClearBtn() {
		return ClearBtn;
	}

	public JButton getEditexecBtn() {
		return EditexecBtn;
	}

	public JProgressBar getProgressBar_1() {
		return progressBar_1;
	}

	public JList getKMLList() {
		return KMLList;
	}

	public JButton getBackBtn() {
		return backBtn;
	}

	public JButton getBtnProperties() {
		return btnProperties;
	}

	public JTextPane getLogTxt() {
		return logTxt;
	}

	public JLabel getLblLogChange() {
		return lblLogChange;
	}
	
//	public void showDialog(String title) {
//		fc.setDialogTitle(title);
//		fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
//		fc.setAcceptAllFileFilterUsed(false);
//		fc.setMultiSelectionEnabled(true);
//		FileNameExtensionFilter filter = new FileNameExtensionFilter("KML files", "kml");
//		fc.addChoosableFileFilter(filter);	
//		
//		int i = fc.showOpenDialog(editPanel);
//	}                       
	
	public File[] getFiles(String title) {
		fc.setDialogTitle(title);
		fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
		fc.setAcceptAllFileFilterUsed(false);
		fc.setMultiSelectionEnabled(true);
		FileNameExtensionFilter filter = new FileNameExtensionFilter("KML files", "kml");
		fc.addChoosableFileFilter(filter);	
		
		int i = fc.showOpenDialog(editPanel);
		
		if(i == JFileChooser.APPROVE_OPTION) {
			return fc.getSelectedFiles();
		}else{
			return null;
		}
	}
	
	public void addBackListener(ActionListener listenBack) {
		backBtn.addActionListener(listenBack);
	}
	
	public void addEditListener(ActionListener listenEdit) {
		EditexecBtn.addActionListener(listenEdit);
	}
	
	public void addClearListener(ActionListener listenClear) {
		ClearBtn.addActionListener(listenClear);
	}
	
	public void addAddListener(ActionListener listenAdd) {
		AddFilesBtn.addActionListener(listenAdd);
	}
	
	public void addPropertiesListener(ActionListener listenProperties) {
		btnProperties.addActionListener(listenProperties);
	}
	
}
