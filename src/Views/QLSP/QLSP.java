/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package Views.QLSP;

import Services.SanPhamService;
import Utils.SVGImage;
import ViewModels.SanPhamViewModel;
import java.awt.Color;
import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author X1
 */
public class QLSP extends javax.swing.JInternalFrame {
    SVGImage svgSet = new SVGImage();
    SanPhamService spService = new SanPhamService();
    DecimalFormat format = new DecimalFormat("#,###");
    /**
     * Creates new form QLSANPHAM
     */
    public QLSP() {
        initComponents();
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0,0,0,0));
        BasicInternalFrameUI ui = (BasicInternalFrameUI) this.getUI();
        ui.setNorthPane(null);
        setButtonIcon();
        loadTable(spService.getListSPVM());
        
    }

    void setButtonIcon() {
        btnAdd.setIcon(svgSet.createSVGIcon("Images/SVG/add.svg", 20, 20));
        btnUpdate.setIcon(svgSet.createSVGIcon("Images/SVG/update.svg", 20, 20));
        btnHidden.setIcon(svgSet.createSVGIcon("Images/SVG/w-view-fill.svg", 15, 15));
        btnImport.setIcon(svgSet.createSVGIcon("Images/SVG/g-excel.svg", 20, 20));
        btnExport.setIcon(svgSet.createSVGIcon("Images/SVG/pdf-color.svg", 20, 20));
        btnHidden.setIcon(svgSet.createSVGIcon("Images/SVG/hide-regular.svg", 20, 20));
        btnViewHide.setIcon(svgSet.createSVGIcon("Images/SVG/b-hidels.svg", 20, 20));
    }
    
    void loadTable(ArrayList<SanPhamViewModel> ls){
        DefaultTableModel model = (DefaultTableModel) tblSP.getModel();
        model.setRowCount(0);
        for (SanPhamViewModel sp : ls) {
            String giaN = format.format(sp.getGiaN());
            String giaB = format.format(sp.getGiaB());
            
            model.addRow(new Object[]{
                sp.getIdSP(), sp.getTenSP(), sp.getDanhMuc(), sp.getNhanHang()
                    , sp.getMauSac(), sp.getKichCo(), sp.getChatLieu()
                    , giaN, giaB, sp.getTrangT(), sp.getSoL(), sp.getKhoHang()
            });
        }
        
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
        TableColumnModel columnModel = tblSP.getColumnModel();
        for (int i = 0; i < columnModel.getColumnCount(); i++) {
            columnModel.getColumn(i).setCellRenderer(centerRenderer);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        btnImport = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblSP = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        btnAdd = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnHidden = new javax.swing.JButton();
        btnViewHide = new javax.swing.JButton();
        cboSearch = new javax.swing.JComboBox<>();
        txtSearch = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        btnDetails = new javax.swing.JButton();
        btnExport = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        txtMaDanhMuc = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        btnThemDM = new javax.swing.JButton();
        btnSuaDM = new javax.swing.JButton();
        btnClearDM = new javax.swing.JButton();
        jLabel26 = new javax.swing.JLabel();
        txtTenDanhMuc = new javax.swing.JTextField();
        btnAnDM = new javax.swing.JButton();
        jLabel28 = new javax.swing.JLabel();
        rdoDMConHang = new javax.swing.JRadioButton();
        rdoDMHethang = new javax.swing.JRadioButton();
        jPanel15 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblDanhMuc = new javax.swing.JTable();
        jLabel27 = new javax.swing.JLabel();
        txtSearchDM = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setBackground(new java.awt.Color(227, 241, 254));
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1090, 630));
        setMinimumSize(new java.awt.Dimension(1090, 630));
        setPreferredSize(new java.awt.Dimension(1090, 630));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTabbedPane1.setMaximumSize(new java.awt.Dimension(1090, 630));
        jTabbedPane1.setMinimumSize(new java.awt.Dimension(1090, 630));
        jTabbedPane1.setPreferredSize(new java.awt.Dimension(1090, 630));

        jPanel1.setMaximumSize(new java.awt.Dimension(1090, 630));
        jPanel1.setMinimumSize(new java.awt.Dimension(1090, 630));
        jPanel1.setPreferredSize(new java.awt.Dimension(1090, 630));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnImport.setText("IMPORT");
        btnImport.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnImportMouseClicked(evt);
            }
        });
        jPanel1.add(btnImport, new org.netbeans.lib.awtextra.AbsoluteConstraints(774, 480, 120, 40));

        tblSP.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID SP", "Tên SP", "Danh Mục", "Nhãn Hàng", "Màu Sắc", "Kích Cỡ", "Chất Liệu", "Giá Nhập", "Giá Bán", "Trạng Thái", "Số Lượng", "Kho Hàng"
            }
        ));
        tblSP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSPMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tblSP);

        jPanel1.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(7, 85, 1040, 380));

        jPanel5.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));
        jPanel5.setAlignmentX(1.0F);
        jPanel5.setAlignmentY(1.0F);

        btnAdd.setText("THÊM");
        btnAdd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAddMouseClicked(evt);
            }
        });

        btnUpdate.setText("SỬA");
        btnUpdate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnUpdateMouseClicked(evt);
            }
        });

        btnHidden.setText("ẨN");
        btnHidden.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHiddenActionPerformed(evt);
            }
        });

        btnViewHide.setText("DS ẨN");
        btnViewHide.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewHideActionPerformed(evt);
            }
        });

        cboSearch.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất Cả", " " }));

        btnSearch.setText("SEARCH");

        btnDetails.setText("XEM");
        btnDetails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDetailsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnDetails, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnHidden, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnViewHide, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
                .addComponent(cboSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(10, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnViewHide, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAdd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnHidden, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnDetails, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        cboSearch.getAccessibleContext().setAccessibleName("Tất Cả\n");

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 1040, 60));

        btnExport.setText("EXPORT");
        jPanel1.add(btnExport, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 480, 130, 40));

        jTabbedPane1.addTab("Thông Tin Sản Phẩm", jPanel1);

        jPanel14.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP)), "Thông tin Danh Mục", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI", 3, 14))); // NOI18N

        txtMaDanhMuc.setEnabled(false);

        jLabel25.setText("Trạng Thái:");

        btnThemDM.setText("THÊM");
        btnThemDM.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnThemDMMouseClicked(evt);
            }
        });

        btnSuaDM.setText("SỬA");
        btnSuaDM.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSuaDMMouseClicked(evt);
            }
        });

        btnClearDM.setText("MỚI");
        btnClearDM.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnClearDMMouseClicked(evt);
            }
        });

        jLabel26.setText("Mã Danh Mục:");

        btnAnDM.setText("XÓA");
        btnAnDM.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAnDMMouseClicked(evt);
            }
        });
        btnAnDM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnDMActionPerformed(evt);
            }
        });

        jLabel28.setText("Tên Danh Mục:");

        rdoDMConHang.setText("Còn hàng");
        rdoDMConHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoDMConHangActionPerformed(evt);
            }
        });

        rdoDMHethang.setText("Hết hàng");

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThemDM)
                    .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTenDanhMuc, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel14Layout.createSequentialGroup()
                                .addComponent(txtMaDanhMuc, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(162, 162, 162)
                                .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(38, 38, 38)
                                .addComponent(rdoDMConHang)
                                .addGap(66, 66, 66)
                                .addComponent(rdoDMHethang))))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(btnSuaDM)
                        .addGap(49, 49, 49)
                        .addComponent(btnClearDM)
                        .addGap(54, 54, 54)
                        .addComponent(btnAnDM)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel26)
                            .addComponent(txtMaDanhMuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTenDanhMuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel28))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnThemDM)
                            .addComponent(btnSuaDM)
                            .addComponent(btnClearDM)
                            .addComponent(btnAnDM)))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel25)
                            .addComponent(rdoDMConHang)
                            .addComponent(rdoDMHethang))))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        jPanel15.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP)), "Chi Tiết Danh Mục", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI", 3, 14))); // NOI18N

        tblDanhMuc.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Mã Danh Mục", "Tên Danh Mục", "Trạng Thái"
            }
        ));
        tblDanhMuc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDanhMucMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tblDanhMuc);

        jLabel27.setText("Tìm kiếm danh mục:");

        jButton1.setText("SEARCH");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel27)
                        .addGap(18, 18, 18)
                        .addComponent(txtSearchDM, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(jButton1))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel15Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 949, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearchDM, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1)
                    .addComponent(jLabel27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Danh Mục", jPanel2);

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 1050, 570));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblSPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSPMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tblSPMouseClicked

    private void btnThemDMMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnThemDMMouseClicked
        //ADD DM
//        int result = JOptionPane.showConfirmDialog(this, "Bạn muốn thêm mới danh mục?", "POLYPOLO xác nhận", JOptionPane.YES_NO_OPTION);
//        if (result == JOptionPane.YES_OPTION && validateDanhMuc()) {
//            JOptionPane.showMessageDialog(this, spService.addDanhMuc(getModelDM()));
//            loadTableDanhMuc(spService.getList());
//        }else{
//            JOptionPane.showMessageDialog(this, "Đã hủy thao tác thêm mới danh mục!", "POLYPOLO thông báo", 0);
//        }
    }//GEN-LAST:event_btnThemDMMouseClicked

    private void btnSuaDMMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSuaDMMouseClicked
        // UPDATE
//        int result = JOptionPane.showConfirmDialog(this, "Bạn muốn cập nhật danh mục?", "POLYPOLO xác nhận", JOptionPane.YES_NO_OPTION);
//        if (result == JOptionPane.YES_OPTION && validateDanhMuc()) {
//            JOptionPane.showMessageDialog(this, spService.updateDanhMuc(getModelDM()));
//            loadTableDanhMuc(spService.getList());
//        } else {
//            JOptionPane.showMessageDialog(this, "Đã hủy thao tác cập nhật danh mục!", "POLYPOLO thông báo", 0);
//        }
    }//GEN-LAST:event_btnSuaDMMouseClicked

    private void btnClearDMMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnClearDMMouseClicked
        // CLEAR
        txtMaDanhMuc.setText("");
        txtTenDanhMuc.setText("");
        txtTenDanhMuc.setBackground(Color.white);
    }//GEN-LAST:event_btnClearDMMouseClicked

    private void btnAnDMMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAnDMMouseClicked
        // HIDE
//        JOptionPane.showMessageDialog(this, spService.anDanhMuc(getModelDM()));
//        loadTableDanhMuc(spService.getList());
    }//GEN-LAST:event_btnAnDMMouseClicked

    private void btnAnDMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnDMActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAnDMActionPerformed

    private void rdoDMConHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoDMConHangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdoDMConHangActionPerformed

    private void tblDanhMucMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDanhMucMouseClicked
        // DANHMUC
//        int pos = tblDanhMuc.getSelectedRow();
//        Integer id = (Integer) tblDanhMuc.getValueAt(pos, 0);
//        DanhMuc dm = spService.getListDMById(id);
//        txtMaDanhMuc.setText(dm.getMaDM().toString());
//        txtTenDanhMuc.setText(dm.getTenDM());
    }//GEN-LAST:event_tblDanhMucMouseClicked

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        // SEARCH DM
//        String name = txtSearchDM.getText();
//        txtSearchDM.setText("");
//        ArrayList<DanhMuc> ls = spService.getListDMByName(name);
//        loadTableDanhMuc(ls);
    }//GEN-LAST:event_jButton1MouseClicked

    private void btnAddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddMouseClicked
        // ADD
        QLSP_add sp = new QLSP_add();
        sp.setVisible(true);
    }//GEN-LAST:event_btnAddMouseClicked

    private void btnUpdateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUpdateMouseClicked
        // UPDATE
        QLSP_update sp = new QLSP_update();
        sp.setVisible(true);
    }//GEN-LAST:event_btnUpdateMouseClicked

    private void btnViewHideActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewHideActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnViewHideActionPerformed

    private void btnImportMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnImportMouseClicked
        // IMPORT
        QLSP_import sp = new QLSP_import();
        sp.setVisible(true);
    }//GEN-LAST:event_btnImportMouseClicked

    private void btnHiddenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHiddenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnHiddenActionPerformed

    private void btnDetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDetailsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDetailsActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnAnDM;
    private javax.swing.JButton btnClearDM;
    private javax.swing.JButton btnDetails;
    private javax.swing.JButton btnExport;
    private javax.swing.JButton btnHidden;
    private javax.swing.JButton btnImport;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnSuaDM;
    private javax.swing.JButton btnThemDM;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JButton btnViewHide;
    private javax.swing.JComboBox<String> cboSearch;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JRadioButton rdoDMConHang;
    private javax.swing.JRadioButton rdoDMHethang;
    private javax.swing.JTable tblDanhMuc;
    private javax.swing.JTable tblSP;
    private javax.swing.JTextField txtMaDanhMuc;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtSearchDM;
    private javax.swing.JTextField txtTenDanhMuc;
    // End of variables declaration//GEN-END:variables
}