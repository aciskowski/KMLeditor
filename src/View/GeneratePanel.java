package View;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Random;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;
import javax.swing.JTextPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import java.awt.Color;

public class GeneratePanel {
	
	private JPanel generatePanel;
	
	private JLabel generateLbl;
	private JLabel lblCsvFilesList;
	private JList CSVlist;
	private JButton btnAddCsvFiles;
	private JButton btnClear;
	private JLabel lblSavePath;
	private JTextField saveTextField;
	private JButton browseBtn;
	private JButton BackBtn;
	private JButton btnGenerate;
	private JTextPane textPane;
	private JLabel lblChangeLog;
	private JProgressBar progressBar;
	private JLabel lblProgress;
	private JScrollPane scroll1;
	private JScrollPane scroll2;
	
	private DefaultListModel listModel;
	
	private JFileChooser fc;
	
	private Random random = new Random();
	
	public GeneratePanel() {
		generatePanel = new JPanel();
		generatePanel.setBackground(new Color(random.nextInt(255),random.nextInt(255),random.nextInt(255)));
		generatePanel.setLayout(new MigLayout("", "[grow][grow]", "[]40[]10[grow][41.00]30[][74.00]40[][44.00,grow][][26.00]40[70.00]"));
		
		generateLbl = new JLabel("Generate KML from CSV");
		generateLbl.setFont(new Font("Tahoma", Font.BOLD, 20));
		generatePanel.add(generateLbl, "cell 0 0 2 1,alignx center,growy");
		
		lblCsvFilesList = new JLabel("CSV files list");
		lblCsvFilesList.setFont(new Font("Tahoma", Font.BOLD, 14));
		generatePanel.add(lblCsvFilesList, "cell 0 1");
		
		listModel = new DefaultListModel();
		CSVlist = new JList(listModel);
		scroll1 = new JScrollPane(CSVlist);
		generatePanel.add(scroll1, "cell 0 2 2 1,grow");
		
		btnAddCsvFiles = new JButton("Add CSV files");
		generatePanel.add(btnAddCsvFiles, "cell 0 3,grow");
		
		btnClear = new JButton("Clear");
		generatePanel.add(btnClear, "cell 1 3,grow");
		
		lblSavePath= new JLabel("Save path:");
		lblSavePath.setFont(new Font("Tahoma", Font.BOLD, 14));
		generatePanel.add(lblSavePath, "cell 0 4");
		
		saveTextField = new JTextField();
		generatePanel.add(saveTextField, "cell 0 5,growx,aligny center");
		saveTextField.setColumns(10);
		
		browseBtn = new JButton("Browse");
		generatePanel.add(browseBtn, "cell 1 5,alignx left,aligny center");
		
		
		lblChangeLog = new JLabel("Change log:");
		lblChangeLog.setFont(new Font("Tahoma", Font.BOLD, 14));
		generatePanel.add(lblChangeLog, "cell 0 6");
		
		textPane = new JTextPane();
		textPane.setEditable(false);
		scroll2 = new JScrollPane(textPane);
		generatePanel.add(scroll2, "cell 0 7 2 1,grow");
		
		lblProgress = new JLabel("Progress:");
		lblProgress.setFont(new Font("Tahoma", Font.BOLD, 14));
		generatePanel.add(lblProgress, "cell 0 8");
		
		progressBar = new JProgressBar();
		generatePanel.add(progressBar, "cell 0 9 2 1,grow");
		
		BackBtn = new JButton("Back");
		generatePanel.add(BackBtn, "cell 0 10,grow");
		
		btnGenerate = new JButton("Generate");
		generatePanel.add(btnGenerate, "cell 1 10,grow");
		
		fc = new JFileChooser();

	}
	
	public JLabel getLblCsvFilesList() {
		return lblCsvFilesList;
	}

	public JList getCSVlist() {
		return CSVlist;
	}

	public JButton getBtnAddCsvFiles() {
		return btnAddCsvFiles;
	}

	public JButton getBtnClear() {
		return btnClear;
	}

	public JTextField getSaveTextField() {
		return saveTextField;
	}

	public JButton getBrowseBtn() {
		return browseBtn;
	}

	public JButton getBackBtn() {
		return BackBtn;
	}

	public JButton getBtnGenerate() {
		return btnGenerate;
	}

	public JTextPane getTextPane() {
		return textPane;
	}

	public JLabel getLblChangeLog() {
		return lblChangeLog;
	}

	public JProgressBar getProgressBar() {
		return progressBar;
	}

	public JFileChooser getFc() {
		return fc;
	}

	public DefaultListModel getListModel() {
		return listModel;
	}

	public JPanel getGeneratePanel() {
		return generatePanel;
	}
	
	public File[] getFiles(String title) {
		fc.setDialogTitle(title);
		fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
		fc.setAcceptAllFileFilterUsed(false);
		fc.setMultiSelectionEnabled(true);
		FileNameExtensionFilter filter = new FileNameExtensionFilter("CSV files", "csv");
		fc.addChoosableFileFilter(filter);	
		
		int i = fc.showOpenDialog(generatePanel);
		
		if(i == JFileChooser.APPROVE_OPTION) {
			return fc.getSelectedFiles();
		}else{
			return new File[0];
		}
	}
	
	public String getChossenPath(String title) {
		fc.setDialogTitle(title);
		fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		fc.setAcceptAllFileFilterUsed(false);
		
		int i = fc.showOpenDialog(generatePanel);
		
		if (i == JFileChooser.APPROVE_OPTION) {
			return fc.getSelectedFile().getPath();
		}else {
			return "";
		}
		
	}
	
	public void addBackListener(ActionListener listenBack) {
		BackBtn.addActionListener(listenBack);
	}
	
	public void addAddListener(ActionListener listenAdd) {
		btnAddCsvFiles.addActionListener(listenAdd);
	}
	
	public void addClearListener(ActionListener listeanClear) {
		btnClear.addActionListener(listeanClear);
	}
	
	public void addBrowseListener(ActionListener listenBrowse) {
		browseBtn.addActionListener(listenBrowse);
	}
	
	public void addGenerateListener(ActionListener listenGenerate) {
		btnGenerate.addActionListener(listenGenerate);
	}
	
	
}
