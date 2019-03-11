package View;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import net.miginfocom.swing.MigLayout;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class DownloadPanel {

	private JPanel downloadPanel;
	
	private JLabel downloadTitle;
	private JLabel linkLbl;
	private JLabel nameLbl;
	private JLabel savePathLbl;
	private JLabel logLbl;
	private JLabel progressLbl;
	
	private JTextField linkField;
	private JTextField nameField;
	private JTextField saveField;
	private JTextField saveLayersField;	
	
	private JButton browseButton;
	private JButton browseLayersBtn;
	private JButton downloadButton;
	private JButton btnBack;
	
	private JRadioButton splitRadioBtn;
	private JTextPane logText;
	private JScrollPane scrollPane;
	private JProgressBar progressBar;
	private JFileChooser fc;
	private JButton clearBtn;
	
	private Random random = new Random();
	
	public DownloadPanel() {
		downloadPanel = new JPanel();
		downloadPanel.setBackground(new Color(random.nextInt(255),random.nextInt(255),random.nextInt(255)));
		downloadPanel.setLayout(new MigLayout("", "[132.00,grow][grow][84.00px,grow]50[134.00px,grow][18.00,grow]", "[60.00px]30[30.00,grow][30.00,grow][30.00,grow][grow]30[34.00][64.00]20[27.00][34.00,grow]30[52.00]30[54.00]"));
		
		downloadTitle = new JLabel("Download KML file from link");
		downloadTitle.setFont(new Font("Tahoma", Font.BOLD, 16));
		downloadPanel.add(downloadTitle, "cell 0 0 6 1,alignx center,aligny center");
		
		linkLbl = new JLabel("Link:");
		linkLbl.setFont(new Font("Tahoma", Font.BOLD, 12));
		downloadPanel.add(linkLbl, "cell 0 1,alignx center,aligny center");
		
		linkField = new JTextField();
		downloadPanel.add(linkField, "cell 2 1 3 1,growx,aligny center");
		linkField.setColumns(10);
		
		nameLbl = new JLabel("Name:");
		nameLbl.setFont(new Font("Tahoma", Font.BOLD, 12));
		downloadPanel.add(nameLbl, "cell 0 2,alignx center,aligny center");
		
		nameField = new JTextField();
		downloadPanel.add(nameField, "cell 2 2 2 1,growx,aligny center");
		nameField.setColumns(10);
		
		savePathLbl = new JLabel("Save path:");
		savePathLbl.setFont(new Font("Tahoma", Font.BOLD, 12));
		downloadPanel.add(savePathLbl, "cell 0 3,alignx center,aligny center");
		
		saveField = new JTextField();
		downloadPanel.add(saveField, "cell 2 3 2 1,growx,aligny center");
		saveField.setColumns(10);
		
		browseButton = new JButton("Browse");
		downloadPanel.add(browseButton, "cell 4 3,alignx left,aligny center");
		
		splitRadioBtn = new JRadioButton("Split to layers and save to:");
		splitRadioBtn.setFont(new Font("Tahoma", Font.ITALIC, 13));
		downloadPanel.add(splitRadioBtn, "cell 0 4,alignx left,aligny center");
		
		saveLayersField = new JTextField();
		downloadPanel.add(saveLayersField, "cell 2 4 2 1,growx,aligny center");
		saveLayersField.setColumns(10);
		
		browseLayersBtn = new JButton("Browse");
		downloadPanel.add(browseLayersBtn, "cell 4 4,alignx left,aligny center");
		
		logLbl = new JLabel("Log change:");
		logLbl.setFont(new Font("Tahoma", Font.BOLD, 14));
		downloadPanel.add(logLbl, "cell 0 5,alignx left,aligny center");
		
		logText = new JTextPane();
		logText.setFont(new Font("Tahoma", Font.PLAIN, 10));
		logText.setEditable(false);
		scrollPane = new JScrollPane(logText);
		downloadPanel.add(scrollPane, "cell 0 6 6 1,grow");
		
		progressLbl = new JLabel("Progress bar");
		progressLbl.setFont(new Font("Tahoma", Font.BOLD, 14));
		downloadPanel.add(progressLbl, "cell 0 7");
		
		progressBar = new JProgressBar();
//		progressBar.setIndeterminate(true);
		downloadPanel.add(progressBar, "cell 0 8 6 1,grow");
		
		clearBtn = new JButton("Clear everything!");
		downloadPanel.add(clearBtn, "cell 0 9,grow");
		
		btnBack = new JButton("Back");
		downloadPanel.add(btnBack, "cell 0 10,grow");
		
		downloadButton = new JButton("Download!");
		downloadPanel.add(downloadButton, "cell 3 10 3 1,grow");
		
		fc = new JFileChooser();
			
	}

	public JProgressBar getProgressBar() {
		return progressBar;
	}

	public JRadioButton getSplitRadioBtn() {
		return splitRadioBtn;
	}
	
	public JTextField getNameField() {
		return nameField;
	}

	public JPanel getDownloadPanel() {
		return downloadPanel;
	}
		
	public JTextField getSaveField() {
		return saveField;
	}
	
	public JTextField getSaveLayersField() {
		return saveLayersField;
	}	

	public JTextField getLinkField() {
		return linkField;
	}

	
	public JTextPane getLogText() {
		return logText;
	}

	public String getChoosenPath(String title) {
		fc.setDialogTitle(title);
		fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		fc.setAcceptAllFileFilterUsed(false);
		
		int i = fc.showOpenDialog(downloadPanel);
		
		if(i == JFileChooser.APPROVE_OPTION) {
			return fc.getSelectedFile().getPath();
		}else {
			return "";
		}
		
	}

	public void addBackListener(ActionListener listenBack) {
		btnBack.addActionListener(listenBack);
	}
	
	public void addBrowseListener (ActionListener listenBrowse) {
		browseButton.addActionListener(listenBrowse);
	}
	
	public void addBrowseLayersListener (ActionListener listenBrowseLayers) {
		browseLayersBtn.addActionListener(listenBrowseLayers);
	}
	
	public void addDownloadListener (ActionListener listenDownload) {
		downloadButton.addActionListener(listenDownload);
	}
	
	public void addClearListener (ActionListener listenClear) {
		clearBtn.addActionListener(listenClear);
	}
	

}
