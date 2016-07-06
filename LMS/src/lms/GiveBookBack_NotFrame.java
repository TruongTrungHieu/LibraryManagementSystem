/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lms;

import AbstractTable.FineCellEditor;
import AbstractTable.FineCellRenderer;
import AbstractTable.GiveBookBackTableModel;
import DatabaseWorker.ExecuteQuery;
import Objects.Fine;
import Objects.Issue;
import Objects.IssueDetail;
import Support.DatetimeUtils;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

/**
 *
 * @author
 */
public class GiveBookBack_NotFrame extends JFrame {

    private Issue issue;
    private ArrayList<IssueDetail> listIssueDetails;
    private ArrayList<Fine> listFine;
    private ExecuteQuery exeQ;

    private final JTable table = new JTable();
    private GiveBookBackTableModel tableModel;

    private final Label lb_readername = new Label();
    private final Label lb_phonenumber = new Label();
    private final Label lb_duedate = new Label();
    private final Label lb_issuedate = new Label();
    private final Label lb_returndate = new Label();

    private final JButton btn_trasach = new JButton();

    public void setIssue(Issue i) {
        this.setTitle("Quản lý trả sách");
        this.setPreferredSize(new Dimension(620, 450));
        this.setLayout(new FlowLayout((int) CENTER_ALIGNMENT));

        issue = i;

        exeQ = ExecuteQuery.getInstance();

        listIssueDetails = new ArrayList<>();
        listIssueDetails = exeQ.getAllIssueDetail(issue.getIssueID());

        listFine = new ArrayList<>();
        listFine = exeQ.getAllFine();

        if (issue != null) {
            lb_readername.setText(issue.getReader().getReaderName());
            lb_phonenumber.setText(issue.getReader().getPhoneNumber());
            lb_duedate.setText(DatetimeUtils.convertDateToString(issue.getDueDate(), DatetimeUtils.DATE_FORMAT_ISSUE));
            lb_issuedate.setText(DatetimeUtils.convertDateToString(issue.getIssueDate(), DatetimeUtils.DATE_FORMAT_ISSUE));
            lb_returndate.setText(DatetimeUtils.convertDateToString(new Date(), DatetimeUtils.DATE_FORMAT_ISSUE));
        }

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        panel.add(lb_readername);
        panel.add(lb_phonenumber);
        panel.add(lb_duedate);
        panel.add(lb_issuedate);
        panel.add(lb_returndate);

        tableModel = new GiveBookBackTableModel(listIssueDetails);
        table.setModel(tableModel);
        table.setDefaultRenderer(Fine.class, new FineCellRenderer());
        table.setDefaultEditor(Fine.class, new FineCellEditor(listFine));
        table.setRowHeight(25);

        JScrollPane scrollpane = new JScrollPane(table);
        scrollpane.setPreferredSize(new Dimension(400, 200));

        panel.add(scrollpane, BorderLayout.CENTER);

        btn_trasach.setText("Trả sách");
        btn_trasach.setAlignmentX(CENTER_ALIGNMENT);
        btn_trasach.addActionListener((ActionEvent e) -> {
             System.out.println("" + listIssueDetails.get(0).getFine().getFineName());
        });
        panel.add(btn_trasach);

        add(panel);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public GiveBookBack_NotFrame() {
        super();
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                new GiveBookBack_NotFrame();
            }
        });
    }
}
