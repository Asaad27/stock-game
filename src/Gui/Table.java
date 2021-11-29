package Gui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Table {

    private int tableHeight = 16, tableWidth = 367;
    private JTable table;
    private DefaultTableModel model;
    private Object[][] rowData;
    private Object[] tableColumns;
    private JPanel panel;



    public Table(Object[] tableColumns, JPanel panel) {
        this.rowData = rowData;
        this.tableColumns = tableColumns;
        this.panel = panel;
    }

    public Table(Object[] tableColumns, JPanel panel, int tableHeight, int tableWidth) {
        this.rowData = rowData;
        this.tableColumns = tableColumns;
        this.panel = panel;
        this.tableHeight = tableHeight;
        this.tableWidth = tableWidth;
    }

    public void removeAllRowsFromJTable() {
            this.model.getDataVector().removeAllElements();
            this.model.fireTableDataChanged();
    }

    public void updateJTable(Object[][] rowData){
        removeAllRowsFromJTable();
        for (Object[] rowDatum : rowData)
            model.addRow(rowDatum);

        model.fireTableDataChanged();
    }

    public void initJTable(Object[][] rowData){

        this.table = new JTable();
        this.table.setBounds(16, 203, tableWidth, tableHeight);
        this.table.setShowHorizontalLines(true);
        this.table.setShowVerticalLines(true);
        this.table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        this.model = new DefaultTableModel(rowData, this.tableColumns);
        this.table.setModel(this.model);

        this.panel.add(new JScrollPane(table));
        this.table.setFillsViewportHeight(true);

        this.table.setVisible(true);
    }

    public JTable getTable() {
        return table;
    }

    public void setTable(JTable table) {
        this.table = table;
    }

    public DefaultTableModel getModel() {
        return model;
    }

    public void setModel(DefaultTableModel model) {
        this.model = model;
    }

    public Object[][] getRowData() {
        return rowData;
    }

    public void setRowData(Object[][] rowData) {
        this.rowData = rowData;
    }

    public Object[] getTableColumns() {
        return tableColumns;
    }

    public void setTableColumns(Object[] tableColumns) {
        this.tableColumns = tableColumns;
    }

    public JPanel getPanel() {
        return panel;
    }

    public void setPanel(JPanel panel) {
        this.panel = panel;
    }
}
