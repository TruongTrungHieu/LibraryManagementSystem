/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AbstractTable;

import Objects.Fine;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.AbstractCellEditor;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;

/**
 *
 * @author
 */
public class FineCellEditor extends AbstractCellEditor
        implements TableCellEditor, ActionListener {

    private Fine fine;
    private List<Fine> listFine;

    public FineCellEditor(List<Fine> listFine) {
        this.listFine = listFine;
    }

    @Override
    public Object getCellEditorValue() {
        return this.fine;
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value,
            boolean isSelected, int row, int column) {
        if (value instanceof Fine) {
            this.fine = (Fine) value;
        }

        JComboBox<Fine> comboFine = new JComboBox<Fine>();

        for (Fine f : listFine) {
            comboFine.addItem(f);
        }

        comboFine.setSelectedItem(fine);
        comboFine.addActionListener(this);

        comboFine.setBackground(Color.WHITE);

        return comboFine;
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        JComboBox<Fine> comboFine = (JComboBox<Fine>) event.getSource();
        this.fine = (Fine) comboFine.getSelectedItem();
    }

}
