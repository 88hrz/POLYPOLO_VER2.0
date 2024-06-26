/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Views.QLTT;

import Models.SP_KichCo;
import Services.SanPhamService;
import Utils.SVGImage;
import Validator.MyValidate;
import com.formdev.flatlaf.themes.FlatMacLightLaf;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author X1
 */
public class QLTT_Sz extends javax.swing.JFrame {
    SVGImage svgSet = new SVGImage();
    SanPhamService spService = new SanPhamService();
    /**
     * Creates new form QLTT_Brand
     */
    public QLTT_Sz() {
        initComponents();
        setLocationRelativeTo(null);
        setIcon();
        loadTable(spService.getListSz());
    }
    
    void setIcon(){
        btnAdd_B.setIcon(svgSet.createSVGIcon("Images/SVG/w-add.svg", 15, 15));
        btnUpdate_B.setIcon(svgSet.createSVGIcon("Images/SVG/w-edit.svg", 15, 15));
        btnHide_B.setIcon(svgSet.createSVGIcon("Images/SVG/w-hide.svg", 15, 15));
        btnCancel_B.setIcon(svgSet.createSVGIcon("Images/SVG/w-cancel.svg", 15, 15));
        btnUnhide_B.setIcon(svgSet.createSVGIcon("Images/SVG/b-view.svg", 18, 18));
        btnShow_B.setIcon(svgSet.createSVGIcon("Images/SVG/b-hidels.svg", 15, 15));
        btnClose.setIcon(svgSet.createSVGIcon("Images/SVG/close.svg", 15, 15));
    }
    
    //LOAD
    void loadTable(ArrayList<SP_KichCo> ls) {
        DefaultTableModel model = (DefaultTableModel) tblSize.getModel();
        model.setRowCount(0);
        for (SP_KichCo nh : ls) {
            model.addRow(new Object[]{
                nh.getIdSz(), nh.getTenSz()
            });
        }
    }
    
    //GETMODEL
    public SP_KichCo getModel(){
        int pos = tblSize.getSelectedRow();
        
        SP_KichCo sz = new SP_KichCo();
        sz.setIdSz((Integer) tblSize.getValueAt(pos, 0));
        sz.setTenSz(txtTenTT.getText().trim());
        return sz;
    }
    public SP_KichCo getUpdate(){
        SP_KichCo sz = new SP_KichCo();
        
        sz.setIdSz(Integer.valueOf(txtMaTT.getText()));
        sz.setTenSz(txtTenTT.getText().trim());
        return sz;
    }
    
    //VALIDATE
    public Boolean validateThuocTinh(){
        StringBuilder stb = new  StringBuilder();
        MyValidate v = new MyValidate();
        
        v.isEmpty(txtTenTT, stb, "Tên size bị trống!");
        if (stb.length()>0) {
            JOptionPane.showMessageDialog(this, stb);
            return false;
        }else{
            return true;
        }
    }
    
    //CLEAR
    void clearForm(){
        txtMaTT.setText("");
        txtTenTT.setText("");
        txtTenTT.setBackground(Color.white);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtSearch = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSize = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        btnClose = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        btnAdd_B = new javax.swing.JButton();
        btnUpdate_B = new javax.swing.JButton();
        btnHide_B = new javax.swing.JButton();
        btnCancel_B = new javax.swing.JButton();
        btnUnhide_B = new javax.swing.JButton();
        btnShow_B = new javax.swing.JButton();
        jLabel25 = new javax.swing.JLabel();
        txtMaTT = new javax.swing.JTextField();
        txtTenTT = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        btnSearchBrand = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(txtSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 220, 231, -1));

        tblSize.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Mã Size", "Tên Size"
            }
        ));
        tblSize.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSizeMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblSize);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 260, 634, 239));

        jPanel2.setBackground(new java.awt.Color(0, 102, 204));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Montserrat", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("THÔNG TIN KÍCH CỠ");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 50, -1, -1));

        btnClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCloseMouseClicked(evt);
            }
        });
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 642, Short.MAX_VALUE)
                .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnClose, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, 30));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 100));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));

        btnAdd_B.setBackground(new java.awt.Color(51, 153, 255));
        btnAdd_B.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        btnAdd_B.setForeground(new java.awt.Color(255, 255, 255));
        btnAdd_B.setText("TẠO");
        btnAdd_B.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAdd_BMouseClicked(evt);
            }
        });

        btnUpdate_B.setBackground(new java.awt.Color(255, 183, 9));
        btnUpdate_B.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        btnUpdate_B.setForeground(new java.awt.Color(255, 255, 255));
        btnUpdate_B.setText("SỬA");
        btnUpdate_B.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnUpdate_BMouseClicked(evt);
            }
        });

        btnHide_B.setBackground(new java.awt.Color(102, 204, 0));
        btnHide_B.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        btnHide_B.setForeground(new java.awt.Color(255, 255, 255));
        btnHide_B.setText("ẨN");
        btnHide_B.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnHide_BMouseClicked(evt);
            }
        });

        btnCancel_B.setBackground(new java.awt.Color(204, 0, 51));
        btnCancel_B.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        btnCancel_B.setForeground(new java.awt.Color(255, 255, 255));
        btnCancel_B.setText("LOAD");
        btnCancel_B.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCancel_BMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnAdd_B, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnUpdate_B, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnHide_B, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnCancel_B, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnUpdate_B, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                    .addComponent(btnAdd_B, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnHide_B, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCancel_B, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        getContentPane().add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 550, -1, -1));

        btnUnhide_B.setForeground(new java.awt.Color(255, 255, 255));
        btnUnhide_B.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnUnhide_BMouseClicked(evt);
            }
        });
        getContentPane().add(btnUnhide_B, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 510, 48, 30));

        btnShow_B.setForeground(new java.awt.Color(255, 255, 255));
        btnShow_B.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnShow_BMouseClicked(evt);
            }
        });
        getContentPane().add(btnShow_B, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 510, 48, 30));

        jLabel25.setText("Mã Thuộc Tính:");
        getContentPane().add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, 88, -1));

        txtMaTT.setEnabled(false);
        getContentPane().add(txtMaTT, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 120, 190, -1));
        getContentPane().add(txtTenTT, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 160, 262, -1));

        jLabel26.setText("Tên Thuộc Tính:");
        getContentPane().add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, 88, -1));

        btnSearchBrand.setText("SEARCH");
        btnSearchBrand.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSearchBrandMouseClicked(evt);
            }
        });
        getContentPane().add(btnSearchBrand, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 220, 83, -1));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, 630, 20));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCloseMouseClicked
        // CLOSE
        this.dispose();
    }//GEN-LAST:event_btnCloseMouseClicked

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCloseActionPerformed

    private void btnAdd_BMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAdd_BMouseClicked
        //ADD 
        int result = JOptionPane.showConfirmDialog(this, "Bạn muốn thêm mới size?", "POLYPOLO xác nhận", JOptionPane.YES_NO_OPTION);   
        if (result == JOptionPane.YES_OPTION && validateThuocTinh()) {
            JOptionPane.showMessageDialog(this, spService.addSz(getModel()));
            loadTable(spService.getListSz());
        }else{
            JOptionPane.showMessageDialog(this, "Đã hủy thao tác thêm mới size!", "POLYPOLO thông báo", 0);
        }
    }//GEN-LAST:event_btnAdd_BMouseClicked

    private void btnUpdate_BMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUpdate_BMouseClicked
        // UPDATE
        int selectedRow = tblSize.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn size bạn muốn cập nhật!", "POLYPOLO thông báo", JOptionPane.WARNING_MESSAGE);
        } else {
            int result = JOptionPane.showConfirmDialog(this, "Bạn muốn cập nhật thuộc tính?", "POLYPOLO xác nhận", JOptionPane.YES_NO_OPTION);
            if (result == JOptionPane.YES_OPTION && validateThuocTinh()) {
                JOptionPane.showMessageDialog(this, spService.updateSize(getUpdate()));
                loadTable(spService.getListSz());
            } else {
                JOptionPane.showMessageDialog(this, "Đã hủy thao tác cập nhật thuộc tính!", "POLYPOLO thông báo", 0);
            }
        }
    }//GEN-LAST:event_btnUpdate_BMouseClicked

    private void btnHide_BMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHide_BMouseClicked
        // HIDE
        int selectedRow = tblSize.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn size bạn muốn ẩn!", "POLYPOLO thông báo", JOptionPane.WARNING_MESSAGE);
        } else {
            int result = JOptionPane.showConfirmDialog(this, "Bạn muốn ẩn thuộc tính?", "POLYPOLO xác nhận", JOptionPane.YES_NO_OPTION);
            if (result == JOptionPane.YES_OPTION) {
                spService.hideSize(getModel());
                JOptionPane.showMessageDialog(this, "Ẩn thuộc tính thành công!", "POLYPOLO thông báo", JOptionPane.INFORMATION_MESSAGE);
                clearForm();
            } else {
                JOptionPane.showMessageDialog(this, "Đã hủy thao tác ẩn thuộc tính", "POLYPOLO thông báo", JOptionPane.INFORMATION_MESSAGE);
            }
            loadTable(spService.getListSz());
        }
    }//GEN-LAST:event_btnHide_BMouseClicked

    private void btnCancel_BMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancel_BMouseClicked
        // CANCEL
        clearForm();
        loadTable(spService.getListSz());
    }//GEN-LAST:event_btnCancel_BMouseClicked

    private void btnShow_BMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnShow_BMouseClicked
        // HIDDEN LIST
        loadTable(spService.getSzHide());
    }//GEN-LAST:event_btnShow_BMouseClicked

    private void btnUnhide_BMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUnhide_BMouseClicked
        // UNHIDE
        int selectedRow = tblSize.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn size bạn muốn bỏ ẩn!", "POLYPOLO thông báo", JOptionPane.WARNING_MESSAGE);
        } else {
            int result = JOptionPane.showConfirmDialog(this, "Bạn muốn bỏ ẩn thuộc tính?", "POLYPOLO xác nhận", JOptionPane.YES_NO_OPTION);
            if (result == JOptionPane.YES_OPTION) {
                spService.unhideSize(getModel());
                loadTable(spService.getListSz());
                JOptionPane.showMessageDialog(this, "Bỏ ẩn thuộc tính thành công!", "POLYPOLO thông báo", JOptionPane.INFORMATION_MESSAGE);
                txtTenTT.setText("");
            } else {
                JOptionPane.showMessageDialog(this, "Đã hủy thao tác bỏ ẩn!", "POLYPOLO thông báo", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnUnhide_BMouseClicked

    private void tblSizeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSizeMouseClicked
        // CLICK
        int selectedRow = tblSize.getSelectedRow();        
        if (selectedRow != -1) {
            Integer idBrand = Integer.valueOf(tblSize.getValueAt(selectedRow, 0).toString());
            String szName = tblSize.getValueAt(selectedRow,1).toString();
            txtMaTT.setText(idBrand.toString());
            txtTenTT.setText(szName);
        }
    }//GEN-LAST:event_tblSizeMouseClicked

    private void btnSearchBrandMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSearchBrandMouseClicked
        // SEARCH
        String name = txtSearch.getText().trim();
        ArrayList<SP_KichCo> ls = spService.searchByNameSz(name);
        loadTable(ls);
        txtSearch.setText("");
    }//GEN-LAST:event_btnSearchBrandMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        FlatMacLightLaf.setup();
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QLTT_Sz().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd_B;
    private javax.swing.JButton btnCancel_B;
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnHide_B;
    private javax.swing.JButton btnSearchBrand;
    private javax.swing.JButton btnShow_B;
    private javax.swing.JButton btnUnhide_B;
    private javax.swing.JButton btnUpdate_B;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable tblSize;
    private javax.swing.JTextField txtMaTT;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtTenTT;
    // End of variables declaration//GEN-END:variables
}
