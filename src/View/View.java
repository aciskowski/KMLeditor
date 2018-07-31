package View;

import java.awt.CardLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import net.miginfocom.swing.MigLayout;

public class View {
	
	private static final long serialVersionUID = 1L;
	private JFrame frame;
	private CardLayout cl;
	
	private JPanel mainPanel;
	private JPanel generatePanel;
	private JPanel editPanel;
	private JPanel downloadPanel;
	
	private JButton generateBtn;
	private JButton editBtn;
	private JButton downloadBtn;
	
	private JLabel titleLabel;
	private JLabel signLabel;

	private JLabel downloadTitle;
	private JLabel linkLbl;
	private JTextField linkField;
	private JLabel nameLbl;
	private JTextField nameField;
	private JLabel savePathLbl;
	private JTextField saveField;
	private JButton browseButton;
	private JLabel optionLbl;
	private JRadioButton splitRadioBtn;
	private JTextField saveLayersField;
	private JButton browseLayersBtn;
	private JRadioButton editRadioBtn;
	private JCheckBox letterCheckbox;
	private JCheckBox numCheckbox;
	private JRadioButton lineThickLbl;
	private JSlider lineThickSlider;
	private JLabel logLbl;
	private JTextPane logText;
	private JLabel progressLbl;
	private JProgressBar progressBar;
	private JButton generateButton;
	
	private JLabel editTitleLbl;
	private JLabel fileListLbl;
	private JLabel lblOptions;
	private JTextPane KMLlistText;
	private JLabel lblPointsNaming;
	private JCheckBox chckbxABC;
	private JLabel lblColor;
	private JComboBox comboBox;
	private JLabel lblLineThickness;
	private JSlider slider;
	private JButton AddFilesBtn;
	private JButton ClearBtn; 
	private JCheckBox checkBox;
	private JButton EditexecBtn;
	private JLabel lblProgress;
	private JProgressBar progressBar_1;
	
	
	
	public View(String title) {
		frame = new JFrame(title);
		frame.getContentPane().setLayout(cl);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(715,624);
		frame.setResizable(false);
		frame.setVisible(true);
		cl = new CardLayout();
		frame.getContentPane().setLayout(cl);

		
		mainPanel = generateMainPanel(mainPanel);
		frame.getContentPane().add(mainPanel, "main");
		
		downloadPanel = generateDownloadPanel(downloadPanel);
		frame.getContentPane().add(downloadPanel, "download");
		
		editPanel = generateEditPanel(editPanel);
		frame.getContentPane().add(editPanel, "edit");
		
						
		
	}
	
	private JPanel generateMainPanel (JPanel panel) {
		panel = new JPanel();
		panel.setLayout(new MigLayout("", "[81.00][580.00,grow][80.00]", "[]50[grow][grow][grow]50[]"));
		
		generateBtn = new JButton("Create from CSV");
		generateBtn.setFont(new Font("Tahoma", Font.BOLD, 14));
//		generateBtn.setSize(286, 110);
		panel.add(generateBtn, "cell 1 1,grow");
		
		editBtn = new JButton("Change properties");
		editBtn.setFont(new Font("Tahoma", Font.BOLD, 14));
//		editBtn.setSize(286, 110);
		panel.add(editBtn, "cell 1 2,grow");
		
		downloadBtn = new JButton("Download from link");
		downloadBtn.setFont(new Font("Tahoma", Font.BOLD, 14));
//		downloadBtn.setSize(286, 110);
		panel.add(downloadBtn, "cell 1 3,grow");
		
		titleLabel = new JLabel("Choose action");
		titleLabel.setFont(new Font("Tahoma", Font.BOLD, 23));
//		title.setBounds(48, 23, 370, 53);
		panel.add(titleLabel, "cell 1 0,alignx center,growy");
		
		signLabel = new JLabel("Artur Ciskowski");
		signLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		panel.add(signLabel, "cell 1 4, alignx right, growy");
		
		return panel;
				
	}
	private JPanel generateDownloadPanel (JPanel panel) {
		panel = new JPanel();
		panel.setLayout(new MigLayout("", "[132.00,grow][84.00px,grow]50[134.00px,grow][18.00,grow][48.00,grow]", "[60.00px]30[30.00][30.00][30.00]30[34.00][26.00][26.00][26][26][26][51.00]20[66.00]30[26.00][26.00]"));
		
		downloadTitle = new JLabel("Download KML file from link");
		downloadTitle.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel.add(downloadTitle, "cell 0 0 5 1,alignx center,aligny center");
		
		linkLbl = new JLabel("Link:");
		linkLbl.setFont(new Font("Tahoma", Font.BOLD, 12));
		panel.add(linkLbl, "cell 0 1,alignx center,aligny center");
		
		linkField = new JTextField();
		panel.add(linkField, "cell 1 1 3 1,growx,aligny center");
		linkField.setColumns(10);
		
		nameLbl = new JLabel("Name:");
		nameLbl.setFont(new Font("Tahoma", Font.BOLD, 12));
		panel.add(nameLbl, "cell 0 2,alignx center,aligny center");
		
		nameField = new JTextField();
		panel.add(nameField, "cell 1 2 2 1,growx,aligny center");
		nameField.setColumns(10);
		
		savePathLbl = new JLabel("Save path:");
		savePathLbl.setFont(new Font("Tahoma", Font.BOLD, 12));
		panel.add(savePathLbl, "cell 0 3,alignx center,aligny center");
		
		saveField = new JTextField();
		panel.add(saveField, "cell 1 3 2 1,growx,aligny center");
		saveField.setColumns(10);
		
		browseButton = new JButton("Browse");
		panel.add(browseButton, "cell 3 3,alignx left,aligny center");
		
		optionLbl = new JLabel("OPTIONS");
		optionLbl.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel.add(optionLbl, "cell 0 4,aligny center");
		
		logLbl = new JLabel("Log change:");
		logLbl.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel.add(logLbl, "cell 2 4,alignx left,aligny center");
		
		splitRadioBtn = new JRadioButton("Split to layers and save to:");
		splitRadioBtn.setFont(new Font("Tahoma", Font.ITALIC, 13));
		panel.add(splitRadioBtn, "cell 0 5 2 1,alignx left,aligny center");
		
		logText = new JTextPane();
		logText.setFont(new Font("Tahoma", Font.PLAIN, 10));
		panel.add(logText, "cell 2 5 3 7,grow");
		
		saveLayersField = new JTextField();
		panel.add(saveLayersField, "cell 0 6,growx,aligny center");
		saveLayersField.setColumns(10);
		
		browseLayersBtn = new JButton("Browse");
		panel.add(browseLayersBtn, "cell 1 6,alignx left,aligny center");
		
		editRadioBtn = new JRadioButton("Points:");
		editRadioBtn.setFont(new Font("Tahoma", Font.ITALIC, 13));
		panel.add(editRadioBtn, "cell 0 7,alignx left,aligny center");
		
		letterCheckbox = new JCheckBox("A, B, C...");
		panel.add(letterCheckbox, "flowx,cell 0 8,alignx left,aligny center");
		
		numCheckbox = new JCheckBox("1, 2, 3...");
		panel.add(numCheckbox, "cell 0 8,alignx left,aligny center");
		
		lineThickLbl = new JRadioButton("Line thickness:");
		lineThickLbl.setFont(new Font("Tahoma", Font.ITALIC, 13));
		panel.add(lineThickLbl, "cell 0 9");
		
		lineThickSlider = new JSlider();
		lineThickSlider.setValue(25);
		lineThickSlider.setMajorTickSpacing(5);
		lineThickSlider.setPaintLabels(true);
		lineThickSlider.setPaintTicks(true);
		lineThickSlider.setMinorTickSpacing(1);
		lineThickSlider.setMaximum(50);
		panel.add(lineThickSlider, "cell 0 10 2 1");
		
		generateButton = new JButton("Download!");
		panel.add(generateButton, "cell 0 11 2 1,grow");
		
		progressLbl = new JLabel("Progress bar");
		progressLbl.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel.add(progressLbl, "cell 0 12");
		
		progressBar = new JProgressBar();
		panel.add(progressBar, "cell 0 13 5 1,grow");
		
		return panel;		
		
	}
	private JPanel generateEditPanel (JPanel panel) {
		
		panel = new JPanel();
		panel.setLayout(new MigLayout("", "[262.00,grow][157.00,grow]50[79.00][]", "[60.00]40[57.00][56.00][58.00][57.00][49.00][48.00][53.00][42.00][34.00][26]"));
		
		editTitleLbl = new JLabel("Edit KML");
		editTitleLbl.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel.add(editTitleLbl, "cell 0 0 4 1,alignx center,aligny center");
		
		fileListLbl = new JLabel("List of files:");
		fileListLbl.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel.add(fileListLbl, "cell 0 1");
		
		lblOptions = new JLabel("OPTIONS:");
		lblOptions.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel.add(lblOptions, "cell 2 1");
		
		KMLlistText = new JTextPane();
		panel.add(KMLlistText, "cell 0 2 2 4,grow");
		
		lblPointsNaming = new JLabel("Points naming:");
		lblPointsNaming.setFont(new Font("Tahoma", Font.ITALIC, 14));
		panel.add(lblPointsNaming, "cell 2 2,alignx right,aligny center");
		
		chckbxABC = new JCheckBox("A, B, C...");
		panel.add(chckbxABC, "flowx,cell 3 2,growx,aligny center");
		
		lblColor = new JLabel("Color:");
		lblColor.setFont(new Font("Tahoma", Font.ITALIC, 14));
		panel.add(lblColor, "cell 2 3,alignx right,aligny center");
		
		comboBox = new JComboBox();
		panel.add(comboBox, "flowy,cell 3 3,growx,aligny center");
		
		lblLineThickness = new JLabel("Line thickness:");
		lblLineThickness.setFont(new Font("Tahoma", Font.ITALIC, 14));
		panel.add(lblLineThickness, "cell 2 4,alignx right,aligny center");
		
		slider = new JSlider();
		panel.add(slider, "cell 3 4,growx,aligny center");
		
		AddFilesBtn = new JButton("Add KML files");
		panel.add(AddFilesBtn, "cell 0 6,grow");
		
		ClearBtn = new JButton("Clear");
		panel.add(ClearBtn, "cell 1 6,grow");
		
		checkBox = new JCheckBox("1, 2, 3...");
		panel.add(checkBox, "cell 3 2,growx,aligny center");
		
		EditexecBtn = new JButton("Edit!");
		panel.add(EditexecBtn, "cell 2 7 2 2,grow");
		
		lblProgress = new JLabel("Progress:");
		lblProgress.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel.add(lblProgress, "cell 0 9,growx,aligny center");
		
		progressBar_1 = new JProgressBar();
		panel.add(progressBar_1, "cell 0 10 4 1,grow");
		
		return panel;				
		
	}
	
	
}


