/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lms;

import DatabaseWorker.ExecuteQuery;
import Objects.Books;
import Objects.Categories;
import Objects.Publishers;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author TriDung
 */
public class ManagerBook extends javax.swing.JFrame {

    private Books book;
    private ArrayList<Publishers> listPublisher;
    private ArrayList<Categories> listCategorieses;
    private ArrayList<Books> listBook;
    private ExecuteQuery exeQ;
    private DefaultTableModel model;
    private Books bookUpdate;

    public ManagerBook() {
        initComponents();
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        Dimension ds = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation((ds.width - this.getWidth()) / 2, (ds.height - this.getHeight()) / 2);
        initData();
        loadView();
    }

    private void refresh() {
        edt_title.setText("");
        edt_author.setText("");
        edt_description.setText("");
        edt_nocopies.setText("0");
        edt_description.setText("");
        cb_category.setSelectedIndex(0);
        cb_publisher.setSelectedIndex(0);
        bookUpdate = new Books();
        btn_update.setEnabled(false);
    }

    private boolean checkValidate() {
        book = new Books();
        book.setBookID(Calendar.getInstance().getTimeInMillis() + "");

        if (edt_title.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Title can't be empty !");
            return false;
        } else {
            book.setTitle(edt_title.getText().trim());
        }

        if (edt_author.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Author can't be empty !");
            return false;
        } else {
            book.setAuthorName(edt_author.getText().trim());
        }

        if (edt_description.getText().trim().isEmpty()) {
            book.setDescription("");
        } else {
            book.setDescription(edt_description.getText());
        }

        try {
            int no = Integer.parseInt(edt_nocopies.getText());
            book.setNumberOfCopy(no);
        } catch (NumberFormatException ne) {
            JOptionPane.showMessageDialog(this, "Number of copies must be a Integer!");
            return false;
        }

        book.setCategory(listCategorieses.get(cb_category.getSelectedIndex()));
        book.setPublisher(listPublisher.get(cb_publisher.getSelectedIndex()));

        return true;
    }

    private boolean checkValidateUpdate() {
        if (edt_title.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Title can't be empty !");
            return false;
        } else {
            bookUpdate.setTitle(edt_title.getText().trim());
        }

        if (edt_author.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Author can't be empty !");
            return false;
        } else {
            bookUpdate.setAuthorName(edt_author.getText().trim());
        }

        if (edt_description.getText().trim().isEmpty()) {
            book.setDescription("");
        } else {
            bookUpdate.setDescription(edt_description.getText());
        }

        try {
            int no = Integer.parseInt(edt_nocopies.getText());
            bookUpdate.setNumberOfCopy(no);
        } catch (NumberFormatException ne) {
            JOptionPane.showMessageDialog(this, "Number of copies must be a Integer!");
            return false;
        }

        bookUpdate.setCategory(listCategorieses.get(cb_category.getSelectedIndex()));
        bookUpdate.setPublisher(listPublisher.get(cb_publisher.getSelectedIndex()));

        return true;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        edt_title = new javax.swing.JTextField();
        edt_author = new javax.swing.JTextField();
        edt_description = new javax.swing.JTextField();
        edt_nocopies = new javax.swing.JTextField();
        cb_publisher = new javax.swing.JComboBox<>();
        cb_category = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_books = new javax.swing.JTable();
        btn_refresh = new javax.swing.JButton();
        bt_add = new javax.swing.JButton();
        btn_update = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Quản lý sách");

        cb_publisher.setToolTipText("Catelogy");

        tb_books.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title", "Author Name", "Catelogy", "Publisher", "Number"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tb_books.setToolTipText("");
        tb_books.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_booksMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tb_books);

        btn_refresh.setText("Refresh");
        btn_refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_refreshActionPerformed(evt);
            }
        });

        bt_add.setText("Add");
        bt_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_addActionPerformed(evt);
            }
        });

        btn_update.setText("Update");
        btn_update.setEnabled(false);
        btn_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_updateActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Title");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Author");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Number of copies");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Publisher");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Category");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("Description");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(btn_update, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(bt_add, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(btn_refresh, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 520, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(edt_title, javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel2)
                                        .addComponent(edt_author, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(18, 18, 18)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(edt_nocopies)))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(cb_publisher, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addGap(18, 18, 18))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel4)
                                            .addGap(176, 176, 176)))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel5)
                                        .addComponent(cb_category, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addComponent(edt_description, javax.swing.GroupLayout.PREFERRED_SIZE, 520, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(edt_title, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(edt_author, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(edt_nocopies, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cb_publisher, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cb_category, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(edt_description, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_refresh, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_add, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_update, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_refreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_refreshActionPerformed
        refresh();
    }//GEN-LAST:event_btn_refreshActionPerformed

    private void bt_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_addActionPerformed
        // TODO add your handling code here:
        if (checkValidate()) {
            if (exeQ.insertBook(book)) {
                JOptionPane.showMessageDialog(this, book.getTitle() + " inserted successfully !");
                listBook.add(book);

                model.setRowCount(0);
                listBook.stream().forEach((b) -> {
                    model.addRow(new Object[]{b.getTitle(), b.getAuthorName(), b.getCategory().getCateName(), b.getPublisher().getPubName(), b.getNumberOfCopy()});
                });
                tb_books = new JTable(model);

                refresh();
            } else {
                JOptionPane.showMessageDialog(this, "Something wrong, please try again !");
            }
        }
    }//GEN-LAST:event_bt_addActionPerformed

    private void tb_booksMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_booksMouseClicked
        int row = tb_books.rowAtPoint(evt.getPoint());
        int col = tb_books.columnAtPoint(evt.getPoint());
        if (row >= 0 && col >= 0) {
            btn_update.setEnabled(true);
            bookUpdate = listBook.get(row);

            edt_title.setText(bookUpdate.getTitle());
            edt_author.setText(bookUpdate.getAuthorName());
            edt_description.setText(bookUpdate.getDescription());
            edt_nocopies.setText(bookUpdate.getNumberOfCopy() + "");

            for (int i = 0; i < listCategorieses.size(); ++i) {
                if (listCategorieses.get(i).getCateID().equals(bookUpdate.getCategory().getCateID())) {
                    cb_category.setSelectedIndex(i);
                    break;
                }
            }
            for (int i = 0; i < listPublisher.size(); ++i) {
                if (listPublisher.get(i).getPubID().equals(bookUpdate.getPublisher().getPubID())) {
                    cb_publisher.setSelectedIndex(i);
                    break;
                }
            }
        }
    }//GEN-LAST:event_tb_booksMouseClicked

    private void btn_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_updateActionPerformed
        // TODO add your handling code here:
        if (checkValidateUpdate()) {
            if (exeQ.updateBook(bookUpdate)) {
                JOptionPane.showMessageDialog(this, bookUpdate.getTitle() + " updated successfully !");

                listBook = new ArrayList<>();
                listBook = exeQ.getAllBooks();
                DefaultTableModel model1;
                model1 = (DefaultTableModel) this.tb_books.getModel();
                model1.setRowCount(0);
                listBook.stream().forEach((b) -> {
                    model1.addRow(new Object[]{b.getTitle(), b.getAuthorName(), b.getCategory().getCateName(), b.getPublisher().getPubName(), b.getNumberOfCopy()});
                });
                tb_books = new JTable(model1);

                refresh();
            }
        }
    }//GEN-LAST:event_btn_updateActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ManagerBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManagerBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManagerBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManagerBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManagerBook().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_add;
    private javax.swing.JButton btn_refresh;
    private javax.swing.JButton btn_update;
    private javax.swing.JComboBox<String> cb_category;
    private javax.swing.JComboBox<String> cb_publisher;
    private javax.swing.JTextField edt_author;
    private javax.swing.JTextField edt_description;
    private javax.swing.JTextField edt_nocopies;
    private javax.swing.JTextField edt_title;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tb_books;
    // End of variables declaration//GEN-END:variables

    private void initData() {
        exeQ = ExecuteQuery.getInstance();

        listBook = new ArrayList<>();
        listBook = exeQ.getAllBooks();

        listCategorieses = new ArrayList<>();
        listCategorieses = exeQ.getAllCategories();

        listPublisher = new ArrayList<>();
        listPublisher = exeQ.getAllPublisher();

        model = (DefaultTableModel) this.tb_books.getModel();
    }

    private void loadView() {
        if (listBook != null) {
            DefaultTableModel model;
            model = (DefaultTableModel) this.tb_books.getModel();
            listBook.stream().forEach((b) -> {
                model.addRow(new Object[]{b.getTitle(), b.getAuthorName(), b.getCategory().getCateName(), b.getPublisher().getPubName(), b.getNumberOfCopy()});
            });
            tb_books = new JTable(model);
        }

        if (listCategorieses != null) {
            listCategorieses.stream().forEach((c) -> {
                cb_category.addItem(c.getCateName());
            });
        }

        if (listPublisher != null) {
            listPublisher.stream().forEach((p) -> {
                cb_publisher.addItem(p.getPubName());
            });
        }
    }

}