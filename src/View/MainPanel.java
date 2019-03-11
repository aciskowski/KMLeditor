package View;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;
import java.awt.Color;

public class MainPanel {

	private JPanel mainPanel;
	private JButton generateBtn;
	private JButton editBtn;
	private JButton downloadBtn;
	
	private JLabel titleLabel;
	private JLabel signLabel;
	private JButton CheckStatsButton;
	
	private Random random = new Random();
	
	
	public MainPanel() {
		mainPanel = new JPanel();
		mainPanel.setBackground(new Color(random.nextInt(255),random.nextInt(255),random.nextInt(255)));
		mainPanel.setLayout(new MigLayout("", "50[405.00,grow]50", "[]50[grow]30[grow]30[grow]30[grow]50[]"));
		
//		img = new ImageIcon("res/img_back.jpg").getImage();
		
		generateBtn = new JButton("Create from CSV");
		generateBtn.setBackground(new Color(0, 255, 255));
		generateBtn.setFont(new Font("Tahoma", Font.BOLD, 14));
//		generateBtn.setSize(286, 110);
		mainPanel.add(generateBtn, "cell 0 1,grow");
		
		editBtn = new JButton("Change properties");
		editBtn.setBackground(Color.ORANGE);
		editBtn.setFont(new Font("Tahoma", Font.BOLD, 14));
//		editBtn.setSize(286, 110);
		mainPanel.add(editBtn, "cell 0 2,grow");
		
		downloadBtn = new JButton("Download from link");
		downloadBtn.setBackground(Color.YELLOW);
		downloadBtn.setFont(new Font("Tahoma", Font.BOLD, 14));
//		downloadBtn.setSize(286, 110);
		mainPanel.add(downloadBtn, "cell 0 3,grow");
		
		titleLabel = new JLabel("Choose action for KML files");
		titleLabel.setFont(new Font("Tahoma", Font.BOLD, 23));
//		title.setBounds(48, 23, 370, 53);
		mainPanel.add(titleLabel, "cell 0 0,alignx center,growy");
		
		CheckStatsButton = new JButton("Check KML stats");
		CheckStatsButton.setBackground(Color.GREEN);
		CheckStatsButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		mainPanel.add(CheckStatsButton, "cell 0 4,grow");
		
		signLabel = new JLabel("Artur Ciskowski");
		signLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		mainPanel.add(signLabel, "cell 0 5,alignx right,growy");						
	}
	
	public JPanel getMainPanel() {
		return mainPanel;
	}

	public JButton getGenerateBtn() {
		return generateBtn;
	}
	

	public JButton getEditBtn() {
		return editBtn;
	}


	public JButton getDownloadBtn() {
		return downloadBtn;
	}
	
	
	public void addGenerateListener (ActionListener listenGenerateBtn) {
		generateBtn.addActionListener(listenGenerateBtn);
	}

	public void addEditListener (ActionListener listenEditBtn) {
		editBtn.addActionListener(listenEditBtn);
	}
	
	public void addDownloadListener (ActionListener listenDownloadBtn) {
		downloadBtn.addActionListener(listenDownloadBtn);
	}
	
	public void addCheckListener (ActionListener listenCheckBtn) {
		CheckStatsButton.addActionListener(listenCheckBtn);
	}


	
}
