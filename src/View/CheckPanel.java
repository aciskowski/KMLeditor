package View;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Random;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.RowSorter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.text.MaskFormatter;
import javax.swing.text.NumberFormatter;
import javax.swing.JList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFormattedTextField;
import javax.swing.border.LineBorder;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.Color;
import javax.swing.JTextField;

public class CheckPanel {

	private JPanel checkPanel;
	private JTable table;
	private JLabel lblCheckKmlStats;
	private DefaultTableModel tableModel;
	private JScrollPane scrollPane;
	private JScrollPane scrollPane1;
	private String[] columnHeaders = {"KML name", "Placemarks", "Type",  "Distance [km]"};


	private JList list;
	private DefaultListModel listModel;
	private JLabel lblDetails;
	private JButton btnAddFiles;
	private JButton btnBack;
	private JFileChooser fc;
	private JButton btnClear;
	
	private Random random = new Random();
	
	private JLabel lblSum;
	private JTextField sumTextField;
	private JLabel lblTimeTotal;
	private JTextField TimeTextField;
	private JLabel lblAvarageSpeed;
	private JTextField avarageTextField;
//	private NumberFormatter formatter;
	private MaskFormatter maskformatter;
	private NumberFormatter nf;
	
	
	public CheckPanel() {
		checkPanel = new JPanel();
		checkPanel.setBackground(new Color(random.nextInt(255),random.nextInt(255),random.nextInt(255)));
		checkPanel.setLayout(new MigLayout("", "[209.00,grow][grow]", "[]30[91.00,grow][38.00]30[36.00][90.00,grow][5.00][5.00][39.00]"));
		
		lblCheckKmlStats = new JLabel("Check KML Stats");
		lblCheckKmlStats.setFont(new Font("Tahoma", Font.BOLD, 20));
		checkPanel.add(lblCheckKmlStats, "cell 0 0 2 1,alignx center,growy");
		
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.BOLD, 12));
		table.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		table.setColumnSelectionAllowed(true);
		table.setCellSelectionEnabled(true);
		table.setShowHorizontalLines(true);
		table.setShowVerticalLines(true);
		table.getTableHeader().setReorderingAllowed(false);
		table.setAutoCreateRowSorter(true);
//		table.setAutoCreateRowSorter(true)		
		
		tableModel = new DefaultTableModel(columnHeaders,0) {
			@Override
			public boolean isCellEditable(int row, int column) {
				// TODO Auto-generated method stub
				return false;
			}
			
		};
		
		table.setModel(tableModel);
		table.getRowSorter().toggleSortOrder(2);
		table.getTableHeader().setEnabled(false);
		
		btnClear = new JButton("Clear!");
		checkPanel.add(btnClear, "cell 1 2,growx");
		
		lblAvarageSpeed = new JLabel("AVARAGE SPEED [km/h]:");
		lblAvarageSpeed.setFont(new Font("Tahoma", Font.BOLD, 12));
		checkPanel.add(lblAvarageSpeed, "flowx,cell 1 3,growx");
	
		scrollPane = new JScrollPane(table);
		checkPanel.add(scrollPane, "cell 0 4 2 1,grow");
		
		list = new JList();
		list.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		listModel = new DefaultListModel();
		list.setModel(listModel);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane1 = new JScrollPane(list);
		checkPanel.add(scrollPane1, "cell 0 1 2 1,grow");
		
		btnAddFiles = new JButton("Add files");
		checkPanel.add(btnAddFiles, "cell 0 2,growx");
		
		lblDetails = new JLabel("Details:");
		lblDetails.setFont(new Font("Tahoma", Font.BOLD, 14));
		checkPanel.add(lblDetails, "cell 0 3,alignx left,growy");
		
		lblSum = new JLabel("DISTANCE SUM [km]:");
		lblSum.setFont(new Font("Tahoma", Font.BOLD, 12));
		checkPanel.add(lblSum, "flowx,cell 1 5,growx");
		
		sumTextField = new JTextField();
		sumTextField.setFont(new Font("Tahoma", Font.BOLD, 12));
		sumTextField.setEditable(false);
		checkPanel.add(sumTextField, "cell 1 5,growx");
		sumTextField.setColumns(10);
		
		lblTimeTotal = new JLabel("TIME TOTAL:");
		lblTimeTotal.setFont(new Font("Tahoma", Font.BOLD, 12));
		checkPanel.add(lblTimeTotal, "flowx,cell 1 6,growx");
		
		TimeTextField = new JTextField();
		TimeTextField.setFont(new Font("Tahoma", Font.BOLD, 12));
		TimeTextField.setEditable(false);
		checkPanel.add(TimeTextField, "cell 1 6,growx");
		TimeTextField.setColumns(10);
		
		btnBack = new JButton("Back");
		checkPanel.add(btnBack, "cell 0 7,grow");
				
//		formatter = new NumberFormatter(NumberFormat.getNumberInstance());
//		formatter.setValueClass(Double.class);
////		formatter.setMinimum(new Double(0));
////		formatter.setMaximum(new Double(150));
//		formatter.setAllowsInvalid(false);
//		formatter.setCommitsOnValidEdit(true);
		
//		try {
//			maskformatter = new MaskFormatter("###");
//			maskformatter.setValidCharacters("0123456789.");
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		nf = new NumberFormatter();
		nf.setMaximum(new Double(1));
		nf.setMaximum(new Double(200));
		
		
		avarageTextField = new JFormattedTextField(nf);
		avarageTextField.setFont(new Font("Tahoma", Font.BOLD, 11));
		checkPanel.add(avarageTextField, "cell 1 3,growx");
		avarageTextField.setColumns(3);
		
		fc = new JFileChooser();
	}

	public JPanel getPanel() {
		return checkPanel;
	}
	public JTable getTable() {
		return table;
	}

	public DefaultTableModel getTableModel() {
		return tableModel;
	}

	public JList getList() {
		return list;
	}

	public DefaultListModel getListModel() {
		return listModel;
	}
	

	public JButton getBtnAddFiles() {
		return btnAddFiles;
	}

	public JButton getBtnBack() {
		return btnBack;
	}

	public JPanel getCheckPanel() {
		return checkPanel;
	}
	
	public JTextField getAvarageTextField() {
		return avarageTextField;
	}

	public File[] getFiles(String title) {
		fc.setDialogTitle(title);
		fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
		fc.setAcceptAllFileFilterUsed(false);
		fc.setMultiSelectionEnabled(true);
		FileNameExtensionFilter filter = new FileNameExtensionFilter("KML files", "kml");
		fc.addChoosableFileFilter(filter);	
		
		int i = fc.showOpenDialog(checkPanel);
		
		if(i == JFileChooser.APPROVE_OPTION) {
			return fc.getSelectedFiles();
		}else{
			return new File[0];
		}
	}
	
	public JTextField getSumTextField() {
		return sumTextField;
	}

	public JTextField getTimeTextField() {
		return TimeTextField;
	}

	public void addBackListener(ActionListener listenBack) {
		btnBack.addActionListener(listenBack);
	}
	
	public void addAddListener (ActionListener listenAdd) {
		btnAddFiles.addActionListener(listenAdd);
	}
		
	public void addChangeListListener(ListSelectionListener listenList) {
		list.addListSelectionListener(listenList);
	}
	
	public void addChangeTableListener(ListSelectionListener listenTable) {
		table.getSelectionModel().addListSelectionListener(listenTable);
	}
	
	public void addClearListener(ActionListener listenClear) {
		btnClear.addActionListener(listenClear);
	}
	
//	public void addAvarageChangeListener(DocumentListener listenAvarage) {
//		avarageTextField.getDocument().addDocumentListener(listenAvarage);;
//	}
	
//	public void addAvarageChangeListener(PropertyChangeListener listenAvarage) {
//		avarageTextField.addPropertyChangeListener(listenAvarage);
//	}
}
