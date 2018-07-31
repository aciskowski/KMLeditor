package View;

import java.awt.CardLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.JSlider;
import javax.swing.JTextPane;
import javax.swing.JProgressBar;
import javax.swing.JEditorPane;
import javax.swing.JComboBox;
import javax.swing.JSeparator;

public class View3 {
	
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
	
	
	
	public View3(String title) {
		frame = new JFrame(title);
		frame.getContentPane().setLayout(cl);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(715,624);
//		frame.setResizable(false);
		frame.setVisible(true);
		frame.getContentPane().setLayout(cl);
		frame.getContentPane().setLayout(new CardLayout(0, 0));
		
//		generateMainPanel(mainPanel);
//		frame.getContentPane().add(mainPanel, "main");
		
		editPanel = new JPanel();
		frame.getContentPane().add(editPanel);
		editPanel.setLayout(new MigLayout("", "[262.00,grow][157.00,grow]50[79.00][]", "[60.00]40[57.00][56.00][58.00][57.00][49.00][48.00][53.00][42.00][34.00][26]"));
		
		JLabel editTitleLbl = new JLabel("Edit KML");
		editTitleLbl.setFont(new Font("Tahoma", Font.BOLD, 16));
		editPanel.add(editTitleLbl, "cell 0 0 4 1,alignx center,aligny center");
		
		JLabel fileListLbl = new JLabel("List of files:");
		fileListLbl.setFont(new Font("Tahoma", Font.BOLD, 14));
		editPanel.add(fileListLbl, "cell 0 1");
		
		JLabel lblOptions = new JLabel("OPTIONS:");
		lblOptions.setFont(new Font("Tahoma", Font.BOLD, 14));
		editPanel.add(lblOptions, "cell 2 1");
		
		JTextPane KMLlistText = new JTextPane();
		editPanel.add(KMLlistText, "cell 0 2 2 4,grow");
		
		JLabel lblPointsNaming = new JLabel("Points naming:");
		lblPointsNaming.setFont(new Font("Tahoma", Font.ITALIC, 14));
		editPanel.add(lblPointsNaming, "cell 2 2,alignx right,aligny center");
		
		JCheckBox chckbxABC = new JCheckBox("A, B, C...");
		editPanel.add(chckbxABC, "flowx,cell 3 2,growx,aligny center");
		
		JLabel lblColor = new JLabel("Color:");
		lblColor.setFont(new Font("Tahoma", Font.ITALIC, 14));
		editPanel.add(lblColor, "cell 2 3,alignx right,aligny center");
		
		JComboBox comboBox = new JComboBox();
		editPanel.add(comboBox, "flowy,cell 3 3,growx,aligny center");
		
		JLabel lblLineThickness = new JLabel("Line thickness:");
		lblLineThickness.setFont(new Font("Tahoma", Font.ITALIC, 14));
		editPanel.add(lblLineThickness, "cell 2 4,alignx right,aligny center");
		
		JSlider slider = new JSlider();
		editPanel.add(slider, "cell 3 4,growx,aligny center");
		
		JButton AddFilesBtn = new JButton("Add KML files");
		editPanel.add(AddFilesBtn, "cell 0 6,grow");
		
		JButton ClearBtn = new JButton("Clear");
		editPanel.add(ClearBtn, "cell 1 6,grow");
		
		JCheckBox checkBox = new JCheckBox("1, 2, 3...");
		editPanel.add(checkBox, "cell 3 2,growx,aligny center");
		
		JButton EditexecBtn = new JButton("Edit!");
		editPanel.add(EditexecBtn, "cell 2 7 2 2,grow");
		
		JLabel lblProgress = new JLabel("Progress:");
		lblProgress.setFont(new Font("Tahoma", Font.BOLD, 14));
		editPanel.add(lblProgress, "cell 0 9,growx,aligny center");
		
		JProgressBar progressBar_1 = new JProgressBar();
		editPanel.add(progressBar_1, "cell 0 10 4 1,grow");
		
						
		
	}
	
//	private void generateMainPanel (JPanel panel) {
//		panel = new JPanel();
//		panel.setLayout(new MigLayout("", "[][grow][]", "50[]50[grow][grow][grow]50[]"));
//		
//		generateBtn = new JButton("Create from CSV");
//		generateBtn.setFont(new Font("Tahoma", Font.BOLD, 14));
////		generateBtn.setSize(286, 110);
//		panel.add(generateBtn, "cell 1 1,grow");
//		
//		editBtn = new JButton("Change properties");
//		editBtn.setFont(new Font("Tahoma", Font.BOLD, 14));
////		editBtn.setSize(286, 110);
//		panel.add(editBtn, "cell 1 2,grow");
//		
//		downloadBtn = new JButton("Download from link");
//		downloadBtn.setFont(new Font("Tahoma", Font.BOLD, 14));
////		downloadBtn.setSize(286, 110);
//		panel.add(downloadBtn, "cell 1 3,grow");
//		
//		titleLabel = new JLabel("Choose action");
//		titleLabel.setFont(new Font("Tahoma", Font.BOLD, 23));
////		title.setBounds(48, 23, 370, 53);
//		panel.add(titleLabel, "cell 1 0,alignx center,growy");
//		
//		signLabel = new JLabel("Artur Ciskowski");
//		signLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
//		panel.add(signLabel, "cell 1 4, alignx right, growy");
//				
//	}
	private void generateDownloadPanel (JPanel panel) {

	}
	
	
}


