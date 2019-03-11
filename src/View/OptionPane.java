package View;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JSlider;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import java.awt.Color;
import java.util.Random;

public class OptionPane {
	
	private JPanel optionPanel;
	private int option;
	private JLabel lblThickness;
	private JComboBox comboBox;
	private JLabel lblColor;
	private JSlider slider;
	private JLabel lblPointsNaming;
	
	private ButtonGroup radioGroup;
	private JRadioButton radioABC;
	private JRadioButton radio123;
	
	private Random random = new Random();
	
	public OptionPane() {
		optionPanel = new JPanel();
		optionPanel.setBackground(new Color(random.nextInt(255),random.nextInt(255),random.nextInt(255)));
		optionPanel.setLayout(new MigLayout("", "[grow][grow]", "[grow][grow][grow]"));
		
		lblColor = new JLabel("Color");
		optionPanel.add(lblColor, "cell 0 0,alignx center");
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "Red", "Blue", "Green", "Black", "Dark blue (recommended)" }));
		comboBox.setSelectedIndex(4);
		optionPanel.add(comboBox, "cell 1 0,growx");
		
		lblThickness = new JLabel("Thickness");
		optionPanel.add(lblThickness, "cell 0 1,alignx center");
		
		slider = new JSlider();
		slider.setValue(25);
		slider.setMaximum(50);
		slider.setMajorTickSpacing(5);
		slider.setMinorTickSpacing(1);
		slider.setPaintLabels(true);
		slider.setPaintTicks(true);
		optionPanel.add(slider, "cell 1 1,growx");
		
		lblPointsNaming = new JLabel("Points naming");
		optionPanel.add(lblPointsNaming, "flowx,cell 0 2,alignx center");
		
		radioGroup = new ButtonGroup();
		radioABC = new JRadioButton("A, B, C...");
		optionPanel.add(radioABC, "flowx,cell 1 2,growx");

		
		radio123 = new JRadioButton("1, 2, 3...");
		optionPanel.add(radio123, "cell 1 2,growx,aligny center");
		
		radioGroup.add(radioABC);
		radioGroup.add(radio123);
		
	}
	


	public JRadioButton getRadioABC() {
		return radioABC;
	}



	public JRadioButton getRadio123() {
		return radio123;
	}



	public JComboBox getComboBox() {
		return comboBox;
	}


	public JSlider getSlider() {
		return slider;
	}



	public int optionPicked() {
		option = JOptionPane.showConfirmDialog(null, optionPanel, "Choose properties of KML file", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
		return option;
	}
	
	
	
	

}
