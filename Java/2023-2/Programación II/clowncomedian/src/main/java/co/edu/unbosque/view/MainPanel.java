package co.edu.unbosque.view;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class MainPanel extends JPanel {

	private JTable pTable, clownsTable, comediansTable;
	private DefaultTableModel pTableModel, clownsTableModel, comediansTableModel;
	private JScrollPane pScroll, clownsScroll, comediansScroll;
	private JPanel editPanel;
	private JPanel idPanel, fullnamePanel, ccPanel, edLevelPanel, sidekickNumPanel, visitedOpenMicPanel;
	private JTextField idField, fullnameField, ccField, edLevelField, sidekickNumField, visitedOpenMicField;
	private JComboBox CRUDbox;
	private JButton confirmButton, resetButton;

	public MainPanel() {
		setSize(920, 480);
		setLayout(null);
		setBackground(Color.gray);

		// --->Constants<---//
		String[] pColumnNames = { "ID", "Fullname", "CC", "Education Level" };
		String[] clownsColumnNames = { "ID", "Fullname", "CC", "Education Level", "No. Sidekicks" };
		String[] comediansColumnNames = { "ID", "Fullname", "CC", "Education Level", "Open Mic Visited" };

		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(JLabel.CENTER);

		Border colorBorder = new LineBorder(Color.black);
		Border inputBorder = BorderFactory.createEtchedBorder(EtchedBorder.RAISED);

		// --->Edit Panel<---//

		Border editBorder = new TitledBorder(colorBorder, "Edit Table");
		Border idBorder = new TitledBorder("ID");
		Border fullnameBorder = new TitledBorder("Full Name");
		Border ccBorder = new TitledBorder("CC");
		Border edLevelBorder = new TitledBorder("Education Level");
		Border sidekickNumBorder = new TitledBorder("No. of Sidekicks");
		Border visitedOpenMicBorder = new TitledBorder("No. of Open Mic Visited");

		editPanel = new JPanel();
		editPanel.setBounds(620, 0, 284, 418);
		editPanel.setLayout(null);
		editPanel.setBorder(editBorder);
		editPanel.setBackground(Color.LIGHT_GRAY);

		idPanel = new JPanel();
		idPanel.setLayout(null);
		idPanel.setBorder(idBorder);
		idPanel.setBounds(10, 15, 264, 60);
		idField = new JTextField();
		idField.setToolTipText("Do not repeat. INTEGER");
		idField.setBounds(10, 25, 245, 21);
		idField.setBorder(inputBorder);
		idPanel.add(idField);
		idPanel.setEnabled(false);
		idPanel.setVisible(false);
		editPanel.add(idPanel);

		fullnamePanel = new JPanel();
		fullnamePanel.setLayout(null);
		fullnamePanel.setBorder(fullnameBorder);
		fullnamePanel.setBounds(10, 75, 264, 60);
		fullnameField = new JTextField();
		fullnameField.setToolTipText("STRING");
		fullnameField.setBounds(10, 25, 245, 21);
		fullnameField.setBorder(inputBorder);
		fullnamePanel.add(fullnameField);
		fullnamePanel.setEnabled(false);
		fullnamePanel.setVisible(false);
		editPanel.add(fullnamePanel);

		ccPanel = new JPanel();
		ccPanel.setLayout(null);
		ccPanel.setBorder(ccBorder);
		ccPanel.setBounds(10, 135, 264, 60);
		ccField = new JTextField();
		ccField.setToolTipText("Do not repeat. INTEGER");
		ccField.setBounds(10, 25, 245, 21);
		ccField.setBorder(inputBorder);
		ccPanel.add(ccField);
		ccPanel.setEnabled(false);
		ccPanel.setVisible(false);
		editPanel.add(ccPanel);

		edLevelPanel = new JPanel();
		edLevelPanel.setLayout(null);
		edLevelPanel.setBorder(edLevelBorder);
		edLevelPanel.setBounds(10, 195, 264, 60);
		edLevelField = new JTextField();
		edLevelField.setToolTipText("INTEGER");
		edLevelField.setBounds(10, 25, 245, 21);
		edLevelField.setBorder(inputBorder);
		edLevelPanel.add(edLevelField);
		edLevelPanel.setEnabled(false);
		edLevelPanel.setVisible(false);
		editPanel.add(edLevelPanel);

		sidekickNumPanel = new JPanel();
		sidekickNumPanel.setLayout(null);
		sidekickNumPanel.setBorder(sidekickNumBorder);
		sidekickNumPanel.setBounds(10, 255, 264, 60);
		sidekickNumField = new JTextField();
		sidekickNumField.setToolTipText("INTEGER");
		sidekickNumField.setBounds(10, 25, 245, 21);
		sidekickNumField.setBorder(inputBorder);
		sidekickNumPanel.add(sidekickNumField);
		sidekickNumPanel.setVisible(false);
		sidekickNumPanel.setEnabled(false);
		editPanel.add(sidekickNumPanel);

		visitedOpenMicPanel = new JPanel();
		visitedOpenMicPanel.setLayout(null);
		visitedOpenMicPanel.setBorder(visitedOpenMicBorder);
		visitedOpenMicPanel.setBounds(10, 255, 264, 60);
		visitedOpenMicField = new JTextField();
		visitedOpenMicField.setToolTipText("INTEGER");
		visitedOpenMicField.setBounds(10, 25, 245, 21);
		visitedOpenMicField.setBorder(inputBorder);
		visitedOpenMicPanel.add(visitedOpenMicField);
		visitedOpenMicPanel.setVisible(false);
		visitedOpenMicPanel.setEnabled(false);
		editPanel.add(visitedOpenMicPanel);

		String[] CRUDop = { "Add", "Delete", "Update" };
		CRUDbox = new JComboBox(CRUDop);
		CRUDbox.setBounds(106, 330, 70, 21);
		CRUDbox.setBorder(inputBorder);
		CRUDbox.setEnabled(false);
		CRUDbox.setVisible(false);
		editPanel.add(CRUDbox);

		confirmButton = new JButton("CONFIRM");
		confirmButton.setBounds(30, 370, 90, 21);
		confirmButton.setBorder(BorderFactory.createRaisedBevelBorder());
		confirmButton.setBackground(Color.LIGHT_GRAY);
		confirmButton.setEnabled(false);
		confirmButton.setVisible(false);
		editPanel.add(confirmButton);

		resetButton = new JButton("RESET");
		resetButton.setBounds(165, 370, 80, 21);
		resetButton.setBorder(BorderFactory.createRaisedBevelBorder());
		resetButton.setBackground(Color.LIGHT_GRAY);
		resetButton.setEnabled(false);
		resetButton.setVisible(false);
		editPanel.add(resetButton);

		// --->Tables<---//
		pTableModel = new DefaultTableModel(new Object[][] {}, pColumnNames);
		clownsTableModel = new DefaultTableModel(new Object[][] {}, clownsColumnNames);
		comediansTableModel = new DefaultTableModel(new Object[][] {}, comediansColumnNames);

		pScroll = new JScrollPane();
		pScroll.setBounds(0, 0, 620, 420);

		clownsScroll = new JScrollPane();
		clownsScroll.setBounds(0, 0, 620, 420);

		comediansScroll = new JScrollPane();
		comediansScroll.setBounds(0, 0, 620, 420);

		pTable = new JTable(pTableModel) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			};
		};
		pTable.getTableHeader().setBackground(Color.lightGray);
		pTable.getColumnModel().getColumn(0).setMaxWidth(30);
		pTable.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
		pTable.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
		pTable.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
		pTable.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
		pScroll.setViewportView(pTable);

		pScroll.setEnabled(true);
		pScroll.setVisible(true);

		clownsTable = new JTable(clownsTableModel) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			};
		};
		clownsTable.getTableHeader().setBackground(Color.lightGray);
		clownsTable.getColumnModel().getColumn(0).setMaxWidth(30);
		clownsTable.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
		clownsTable.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
		clownsTable.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
		clownsTable.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
		clownsTable.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);
		clownsScroll.setViewportView(clownsTable);

		clownsScroll.setEnabled(false);
		clownsScroll.setVisible(false);

		comediansTable = new JTable(comediansTableModel) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			};
		};
		comediansTable.getTableHeader().setBackground(Color.lightGray);
		comediansTable.getColumnModel().getColumn(0).setMaxWidth(30);
		comediansTable.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
		comediansTable.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
		comediansTable.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
		comediansTable.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
		comediansTable.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);
		comediansScroll.setViewportView(comediansTable);

		comediansScroll.setEnabled(false);
		comediansScroll.setVisible(false);

		add(pScroll);
		add(clownsScroll);
		add(comediansScroll);
		add(editPanel);
		setVisible(true);
	}

	public DefaultTableModel getpTableModel() {
		return pTableModel;
	}

	public void setpTableModel(DefaultTableModel pTableModel) {
		this.pTableModel = pTableModel;
	}

	public DefaultTableModel getClownsTableModel() {
		return clownsTableModel;
	}

	public void setClownsTableModel(DefaultTableModel clownsTableModel) {
		this.clownsTableModel = clownsTableModel;
	}

	public DefaultTableModel getComediansTableModel() {
		return comediansTableModel;
	}

	public void setComediansTableModel(DefaultTableModel comediansTableModel) {
		this.comediansTableModel = comediansTableModel;
	}

	public JTable getpTable() {
		return pTable;
	}

	public void setpTable(JTable pTable) {
		this.pTable = pTable;
	}

	public JTable getClownsTable() {
		return clownsTable;
	}

	public void setClownsTable(JTable clownsTable) {
		this.clownsTable = clownsTable;
	}

	public JTable getComediansTable() {
		return comediansTable;
	}

	public void setComediansTable(JTable comediansTable) {
		this.comediansTable = comediansTable;
	}

	public JScrollPane getpScroll() {
		return pScroll;
	}

	public void setpScroll(JScrollPane pScroll) {
		this.pScroll = pScroll;
	}

	public JScrollPane getClownsScroll() {
		return clownsScroll;
	}

	public void setClownsScroll(JScrollPane clownsScroll) {
		this.clownsScroll = clownsScroll;
	}

	public JScrollPane getComediansScroll() {
		return comediansScroll;
	}

	public void setComediansScroll(JScrollPane comediansScroll) {
		this.comediansScroll = comediansScroll;
	}

	public JPanel getEditPanel() {
		return editPanel;
	}

	public void setEditPanel(JPanel editPanel) {
		this.editPanel = editPanel;
	}

	public JPanel getIdPanel() {
		return idPanel;
	}

	public void setIdPanel(JPanel idPanel) {
		this.idPanel = idPanel;
	}

	public JPanel getFullnamePanel() {
		return fullnamePanel;
	}

	public void setFullnamePanel(JPanel fullnamePanel) {
		this.fullnamePanel = fullnamePanel;
	}

	public JPanel getCcPanel() {
		return ccPanel;
	}

	public void setCcPanel(JPanel ccPanel) {
		this.ccPanel = ccPanel;
	}

	public JPanel getEdLevelPanel() {
		return edLevelPanel;
	}

	public void setEdLevelPanel(JPanel edLevelPanel) {
		this.edLevelPanel = edLevelPanel;
	}

	public JPanel getSidekickNumPanel() {
		return sidekickNumPanel;
	}

	public void setSidekickNumPanel(JPanel sidekickNumPanel) {
		this.sidekickNumPanel = sidekickNumPanel;
	}

	public JPanel getVisitedOpenMicPanel() {
		return visitedOpenMicPanel;
	}

	public void setVisitedOpenMicPanel(JPanel visitedOpenMicPanel) {
		this.visitedOpenMicPanel = visitedOpenMicPanel;
	}

	public JTextField getIdField() {
		return idField;
	}

	public void setIdField(JTextField idField) {
		this.idField = idField;
	}

	public JTextField getFullnameField() {
		return fullnameField;
	}

	public void setFullnameField(JTextField fullnameField) {
		this.fullnameField = fullnameField;
	}

	public JTextField getCcField() {
		return ccField;
	}

	public void setCcField(JTextField ccField) {
		this.ccField = ccField;
	}

	public JTextField getEdLevelField() {
		return edLevelField;
	}

	public void setEdLevelField(JTextField edLevelField) {
		this.edLevelField = edLevelField;
	}

	public JTextField getSidekickNumField() {
		return sidekickNumField;
	}

	public void setSidekickNumField(JTextField sidekickNumField) {
		this.sidekickNumField = sidekickNumField;
	}

	public JTextField getVisitedOpenMicField() {
		return visitedOpenMicField;
	}

	public void setVisitedOpenMicField(JTextField visitedOpenMicField) {
		this.visitedOpenMicField = visitedOpenMicField;
	}

	public JComboBox getCRUDbox() {
		return CRUDbox;
	}

	public void setCRUDbox(JComboBox cRUDbox) {
		CRUDbox = cRUDbox;
	}

	public JButton getConfirmButton() {
		return confirmButton;
	}

	public void setConfirmButton(JButton confirmButton) {
		this.confirmButton = confirmButton;
	}

	public JButton getResetButton() {
		return resetButton;
	}

	public void setResetButton(JButton resetButton) {
		this.resetButton = resetButton;
	}

}
