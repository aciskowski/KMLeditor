package View;

import java.awt.CardLayout;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainView {
	

	private JFrame frame;
	private CardLayout cl;
	
//	private JFileChooser fc;
	
	private MainPanel main;
	private GeneratePanel generate;
	private EditPanel edit;
	private DownloadPanel download;
	private CheckPanel check;
	
	public MainView(MainPanel main, GeneratePanel generate, EditPanel edit, DownloadPanel download, CheckPanel check) {
		
		this.main = main;
		this.generate = generate;
		this.edit = edit;
		this.download = download;
		this.check = check;
		
		frame = new JFrame("KML");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(583,752);
		frame.setResizable(false);
		frame.setVisible(true);
		cl = new CardLayout();
		frame.getContentPane().setLayout(cl);
		
		
		frame.getContentPane().add(main.getMainPanel(), "main");
		frame.getContentPane().add(download.getDownloadPanel(), "download");
		frame.getContentPane().add(edit.getEditPanel(), "edit");
		frame.getContentPane().add(generate.getGeneratePanel(), "generate");
		frame.getContentPane().add(check.getCheckPanel(), "check");
		
	}
	
	
	public MainPanel getMain() {
		return main;
	}

	public GeneratePanel getGenerate() {
		return generate;
	}

	public EditPanel getEdit() {
		return edit;
	}

	public DownloadPanel getDownload() {
		return download;
	}

	public JFrame getFrame() {
		return frame;
	}
	
	public CardLayout getCL() {
		return cl;
	}
	
	public void showPanel(String panelName) {
		cl.show(frame.getContentPane(), panelName);
	}
	
	

}
