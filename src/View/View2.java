package View;

import java.awt.CardLayout;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.Box;
import javax.swing.BoxLayout;
import java.awt.Component;
import javax.swing.JRadioButton;
import javax.swing.JPasswordField;
import javax.swing.JTree;
import javax.swing.JLayeredPane;
import java.awt.BorderLayout;
import javax.swing.JMenuBar;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.SwingConstants;
import net.miginfocom.swing.MigLayout;
import javax.swing.JTextField;
import javax.swing.JSlider;
import javax.swing.JToggleButton;
import javax.swing.JCheckBox;
import javax.swing.JProgressBar;
import javax.swing.JTextPane;

public class View2 {
	
	private static final long serialVersionUID = 1L;
	private JFrame frame;
	private CardLayout cl;
	
	private JPanel mainPanel;
	private JPanel generatePanel;
	private JPanel editPanel;
	private JPanel loadPanel;
	private JLabel lblNewLabel_1;
	private JLabel label;
	private JLabel label_1;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JButton btnNewButton;
	private JLabel lblNewLabel_2;
	private JRadioButton rdbtnNewRadioButton;
	private JRadioButton rdbtnNewRadioButton_1;
	private JSlider slider;
	private JCheckBox chckbxNewCheckBox;
	private JButton btnNewButton_1;
	private JProgressBar progressBar;
	private JLabel lblNewLabel_3;
	private JTextPane textPane;
	
	
	public View2(String title) {
		frame = new JFrame(title);
		frame.getContentPane().setLayout(cl);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(481,624);
//		frame.setResizable(false);
		frame.setVisible(true);
		frame.getContentPane().setLayout(new CardLayout(0, 0));
		
		
		mainPanel = new JPanel();
		frame.getContentPane().add(mainPanel, "main");
		mainPanel.setLayout(new MigLayout("", "[grow][grow][grow][grow]", "[grow][grow][grow][grow][grow][grow][grow][grow][grow][grow][grow][grow]"));
		
		JLabel lblNewLabel = new JLabel("New label");
		mainPanel.add(lblNewLabel, "cell 1 0 2 1,growx");
		
		lblNewLabel_1 = new JLabel("New label");
		mainPanel.add(lblNewLabel_1, "cell 0 1 2 1");
		
		textField = new JTextField();
		mainPanel.add(textField, "cell 2 1 2 1,growx");
		textField.setColumns(10);
		
		label = new JLabel("New label");
		mainPanel.add(label, "cell 0 2 2 1");
		
		textField_1 = new JTextField();
		mainPanel.add(textField_1, "cell 2 2 2 1,growx");
		textField_1.setColumns(10);
		
		label_1 = new JLabel("New label");
		mainPanel.add(label_1, "cell 0 3 2 1");
		
		textField_2 = new JTextField();
		mainPanel.add(textField_2, "cell 2 3 2 1,growx");
		textField_2.setColumns(10);
		
		btnNewButton = new JButton("New button");
		mainPanel.add(btnNewButton, "cell 3 4");
		
		lblNewLabel_2 = new JLabel("New label");
		mainPanel.add(lblNewLabel_2, "cell 0 5");
		
		rdbtnNewRadioButton = new JRadioButton("New radio button");
		mainPanel.add(rdbtnNewRadioButton, "cell 0 6");
		
		rdbtnNewRadioButton_1 = new JRadioButton("New radio button");
		mainPanel.add(rdbtnNewRadioButton_1, "cell 2 6");
		
		chckbxNewCheckBox = new JCheckBox("New check box");
		mainPanel.add(chckbxNewCheckBox, "cell 2 7");
		
		slider = new JSlider();
		mainPanel.add(slider, "cell 3 7");
		
		btnNewButton_1 = new JButton("New button");
		mainPanel.add(btnNewButton_1, "cell 2 8 2 1,grow");
		
		lblNewLabel_3 = new JLabel("New label");
		mainPanel.add(lblNewLabel_3, "cell 0 10");
		
		progressBar = new JProgressBar();
		mainPanel.add(progressBar, "cell 1 10 3 1,growx");
		
		textPane = new JTextPane();
		mainPanel.add(textPane, "cell 1 11 3 1,grow");
		

		
				
		
		
		
		
	}
	
	
}

	