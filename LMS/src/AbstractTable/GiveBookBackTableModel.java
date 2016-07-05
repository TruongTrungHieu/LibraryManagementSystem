/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AbstractTable;

import Objects.Books;
import Objects.Fine;
import Objects.IssueDetail;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author
 */
public class GiveBookBackTableModel extends AbstractTableModel {

    private final String[] columnNames = {"No.", "Title", "Number", "Status"};
    private ArrayList<IssueDetail> listIssueDetail = new ArrayList<>();

    public GiveBookBackTableModel(ArrayList<IssueDetail> list) {
        this.listIssueDetail = list;
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    @Override
    public Class getColumnClass(int column) {
        return getValueAt(0, column).getClass();
    }

    @Override
    public int getRowCount() {
        return listIssueDetail.size();
    }

    @Override
    public void setValueAt(Object value, int rowIndex, int columnIndex) {
        IssueDetail issueDetail = listIssueDetail.get(rowIndex);

        switch (columnIndex) {
            case 1:
                issueDetail.getBook().setTitle((String) value);
                break;
            case 2:
                issueDetail.setNumber((int) value);
                break;
            case 3:
                issueDetail.getFine().setFineName((String) value);
                break;
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Object returnValue = null;
        IssueDetail issueDetail = listIssueDetail.get(rowIndex);

        switch (columnIndex) {
            case 0:
                returnValue = rowIndex + 1;
                break;
            case 1:
                returnValue = issueDetail.getBook().getTitle();
                break;
            case 2:
                returnValue = issueDetail.getNumber();
                break;
            case 3:
                returnValue = issueDetail.getFine().getFineName();
                break;
        }

        return returnValue;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return columnIndex > 0;
    }
}
