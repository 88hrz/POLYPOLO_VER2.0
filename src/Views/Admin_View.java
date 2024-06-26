/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Views;

import Views.KHOHANG.QuanLyKhoHang;
import Views.QLNH.QLNH;
import Views.QLKH.QLKHACHHANG;
import Views.QLNS.QLNS;
import Views.QLTT.QLTT;
import Views.QLTK.QLTK;
import Views.QLSP.QLSP;
import Models.User;
import Utils.SVGImage;
import Views.QLBH.QLBH;
import com.formdev.flatlaf.themes.FlatMacLightLaf;
import java.awt.Color;
import javax.swing.BorderFactory;

/**
 *
 * @author X1
 */
public class Admin_View extends javax.swing.JFrame {
    Color DefaultColor, ClickedColor;
    SVGImage svgSet = new SVGImage();
    
    public Admin_View(User u){
        initComponents();
        setLocationRelativeTo(null);
        DefaultColor = new Color(13, 36, 51);
        ClickedColor = new Color(170,117,10);
        btnClose.setIcon(svgSet.createSVGIcon("Images/SVG/close.svg", 15, 15));
        btnClose.setBorderPainted(false);
        getRootPane().setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY,2, true));
        dashBoard();
        
        lbl_UserID.setText(u.getUserName());  
        menuName.setText("| Trang Chủ");
        
//        QuanLyKhoHang qlkh = new QuanLyKhoHang();
//        jGUIForms.removeAll();
//        jGUIForms.add(qlkh).setVisible(true);

//        QLSP sp = new QLSP();
//        jGUIForms.removeAll();
//        jGUIForms.add(sp).setVisible(true);

//        QLBH bh = new QLBH();
//        jGUIForms.removeAll();
//        jGUIForms.add(bh).setVisible(true);

        TrangChu tc = new TrangChu();
        jGUIForms.removeAll();
        jGUIForms.add(tc).setVisible(true);
    }

    
    void dashBoard(){
        trangChu.setBackground(DefaultColor);
        banHang.setBackground(DefaultColor);
        sanPham.setBackground(DefaultColor);
        thuocTinh.setBackground(DefaultColor);
        khoHang.setBackground(DefaultColor);
        nhanSu.setBackground(DefaultColor);
        khachHang.setBackground(DefaultColor);
        taiKhoan.setBackground(DefaultColor);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JPanel();
        verticalLayout = new javax.swing.JPanel();
        menuName = new javax.swing.JLabel();
        logo = new javax.swing.JLabel();
        lbl_UserID = new javax.swing.JLabel();
        txtUser_ID = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btnClose = new javax.swing.JButton();
        horizontalMenu = new javax.swing.JPanel();
        trangChu = new javax.swing.JPanel();
        lblTrangChu = new javax.swing.JLabel();
        banHang = new javax.swing.JPanel();
        lblBanHang = new javax.swing.JLabel();
        sanPham = new javax.swing.JPanel();
        lblSanPham = new javax.swing.JLabel();
        nhanSu = new javax.swing.JPanel();
        lblNhanSu = new javax.swing.JLabel();
        khachHang = new javax.swing.JPanel();
        lblKhachHang = new javax.swing.JLabel();
        taiKhoan = new javax.swing.JPanel();
        lblTaiKhoan = new javax.swing.JLabel();
        thongKe = new javax.swing.JPanel();
        lblExit = new javax.swing.JLabel();
        thuocTinh = new javax.swing.JPanel();
        lblThuocTinh = new javax.swing.JLabel();
        khoHang = new javax.swing.JPanel();
        lblSanPham2 = new javax.swing.JLabel();
        nhapHang = new javax.swing.JPanel();
        lblSanPham3 = new javax.swing.JLabel();
        jGUIForms = new javax.swing.JDesktopPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1100, 690));
        setUndecorated(true);

        bg.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        verticalLayout.setBackground(new java.awt.Color(220, 117, 28));
        verticalLayout.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        menuName.setFont(new java.awt.Font("Montserrat", 3, 12)); // NOI18N
        menuName.setForeground(new java.awt.Color(255, 255, 255));
        menuName.setText("mono");
        verticalLayout.add(menuName, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 30, -1, 30));

        logo.setFont(new java.awt.Font("Montserrat ExtraBold", 3, 20)); // NOI18N
        logo.setForeground(new java.awt.Color(255, 255, 255));
        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/PNG/user-polo.png"))); // NOI18N
        logo.setText("PolyPolo");
        verticalLayout.add(logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 150, 50));

        lbl_UserID.setFont(new java.awt.Font("Montserrat Medium", 1, 12)); // NOI18N
        lbl_UserID.setText("stallion");
        verticalLayout.add(lbl_UserID, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 20, 60, 20));

        txtUser_ID.setBackground(new java.awt.Color(224, 224, 224));
        txtUser_ID.setEnabled(false);
        verticalLayout.add(txtUser_ID, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 20, 120, 20));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/PNG/user-icon20.png"))); // NOI18N
        verticalLayout.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 10, 40, 40));

        btnClose.setText("EXIT");
        btnClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCloseMouseClicked(evt);
            }
        });
        verticalLayout.add(btnClose, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 0, -1, 29));

        bg.add(verticalLayout, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1240, 60));

        horizontalMenu.setBackground(new java.awt.Color(13, 36, 51));
        horizontalMenu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        trangChu.setBackground(new java.awt.Color(13, 36, 51));
        trangChu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                trangChuMouseClicked(evt);
            }
        });

        lblTrangChu.setFont(new java.awt.Font("Montserrat", 1, 13)); // NOI18N
        lblTrangChu.setForeground(new java.awt.Color(255, 255, 255));
        lblTrangChu.setText("Trang Chủ");

        javax.swing.GroupLayout trangChuLayout = new javax.swing.GroupLayout(trangChu);
        trangChu.setLayout(trangChuLayout);
        trangChuLayout.setHorizontalGroup(
            trangChuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(trangChuLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(lblTrangChu)
                .addContainerGap(46, Short.MAX_VALUE))
        );
        trangChuLayout.setVerticalGroup(
            trangChuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, trangChuLayout.createSequentialGroup()
                .addContainerGap(7, Short.MAX_VALUE)
                .addComponent(lblTrangChu)
                .addContainerGap())
        );

        horizontalMenu.add(trangChu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 140, 30));

        banHang.setBackground(new java.awt.Color(13, 36, 51));
        banHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                banHangMouseClicked(evt);
            }
        });

        lblBanHang.setFont(new java.awt.Font("Montserrat", 1, 13)); // NOI18N
        lblBanHang.setForeground(new java.awt.Color(255, 255, 255));
        lblBanHang.setText("Bán Hàng");

        javax.swing.GroupLayout banHangLayout = new javax.swing.GroupLayout(banHang);
        banHang.setLayout(banHangLayout);
        banHangLayout.setHorizontalGroup(
            banHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(banHangLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(lblBanHang)
                .addContainerGap(49, Short.MAX_VALUE))
        );
        banHangLayout.setVerticalGroup(
            banHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(banHangLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblBanHang)
                .addContainerGap(7, Short.MAX_VALUE))
        );

        horizontalMenu.add(banHang, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 140, 30));

        sanPham.setBackground(new java.awt.Color(13, 36, 51));
        sanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sanPhamMouseClicked(evt);
            }
        });

        lblSanPham.setFont(new java.awt.Font("Montserrat", 1, 13)); // NOI18N
        lblSanPham.setForeground(new java.awt.Color(255, 255, 255));
        lblSanPham.setText("Sản Phẩm");

        javax.swing.GroupLayout sanPhamLayout = new javax.swing.GroupLayout(sanPham);
        sanPham.setLayout(sanPhamLayout);
        sanPhamLayout.setHorizontalGroup(
            sanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sanPhamLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(lblSanPham)
                .addContainerGap(47, Short.MAX_VALUE))
        );
        sanPhamLayout.setVerticalGroup(
            sanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sanPhamLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblSanPham)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        horizontalMenu.add(sanPham, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 220, 140, -1));

        nhanSu.setBackground(new java.awt.Color(13, 36, 51));
        nhanSu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nhanSuMouseClicked(evt);
            }
        });

        lblNhanSu.setFont(new java.awt.Font("Montserrat", 1, 13)); // NOI18N
        lblNhanSu.setForeground(new java.awt.Color(255, 255, 255));
        lblNhanSu.setText("Nhân Sự");

        javax.swing.GroupLayout nhanSuLayout = new javax.swing.GroupLayout(nhanSu);
        nhanSu.setLayout(nhanSuLayout);
        nhanSuLayout.setHorizontalGroup(
            nhanSuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(nhanSuLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(lblNhanSu)
                .addContainerGap(58, Short.MAX_VALUE))
        );
        nhanSuLayout.setVerticalGroup(
            nhanSuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(nhanSuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblNhanSu)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        horizontalMenu.add(nhanSu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 370, 140, -1));

        khachHang.setBackground(new java.awt.Color(13, 36, 51));
        khachHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                khachHangMouseClicked(evt);
            }
        });

        lblKhachHang.setFont(new java.awt.Font("Montserrat", 1, 13)); // NOI18N
        lblKhachHang.setForeground(new java.awt.Color(255, 255, 255));
        lblKhachHang.setText("Khách Hàng");

        javax.swing.GroupLayout khachHangLayout = new javax.swing.GroupLayout(khachHang);
        khachHang.setLayout(khachHangLayout);
        khachHangLayout.setHorizontalGroup(
            khachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(khachHangLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(lblKhachHang)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        khachHangLayout.setVerticalGroup(
            khachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(khachHangLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblKhachHang)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        horizontalMenu.add(khachHang, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 420, 140, -1));

        taiKhoan.setBackground(new java.awt.Color(13, 36, 51));
        taiKhoan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                taiKhoanMouseClicked(evt);
            }
        });

        lblTaiKhoan.setFont(new java.awt.Font("Montserrat", 1, 13)); // NOI18N
        lblTaiKhoan.setForeground(new java.awt.Color(255, 255, 255));
        lblTaiKhoan.setText("Tài Khoản");

        javax.swing.GroupLayout taiKhoanLayout = new javax.swing.GroupLayout(taiKhoan);
        taiKhoan.setLayout(taiKhoanLayout);
        taiKhoanLayout.setHorizontalGroup(
            taiKhoanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(taiKhoanLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(lblTaiKhoan)
                .addContainerGap(48, Short.MAX_VALUE))
        );
        taiKhoanLayout.setVerticalGroup(
            taiKhoanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(taiKhoanLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTaiKhoan)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        horizontalMenu.add(taiKhoan, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 470, 140, -1));

        thongKe.setBackground(new java.awt.Color(13, 36, 51));
        thongKe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                thongKeMouseClicked(evt);
            }
        });

        lblExit.setFont(new java.awt.Font("Montserrat", 1, 13)); // NOI18N
        lblExit.setForeground(new java.awt.Color(255, 255, 255));
        lblExit.setText("Thống Kê");

        javax.swing.GroupLayout thongKeLayout = new javax.swing.GroupLayout(thongKe);
        thongKe.setLayout(thongKeLayout);
        thongKeLayout.setHorizontalGroup(
            thongKeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(thongKeLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(lblExit)
                .addContainerGap(51, Short.MAX_VALUE))
        );
        thongKeLayout.setVerticalGroup(
            thongKeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(thongKeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblExit)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        horizontalMenu.add(thongKe, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 520, 140, -1));

        thuocTinh.setBackground(new java.awt.Color(13, 36, 51));
        thuocTinh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                thuocTinhMouseClicked(evt);
            }
        });

        lblThuocTinh.setFont(new java.awt.Font("Montserrat", 1, 13)); // NOI18N
        lblThuocTinh.setForeground(new java.awt.Color(255, 255, 255));
        lblThuocTinh.setText("Thuộc Tính");

        javax.swing.GroupLayout thuocTinhLayout = new javax.swing.GroupLayout(thuocTinh);
        thuocTinh.setLayout(thuocTinhLayout);
        thuocTinhLayout.setHorizontalGroup(
            thuocTinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(thuocTinhLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(lblThuocTinh)
                .addContainerGap(40, Short.MAX_VALUE))
        );
        thuocTinhLayout.setVerticalGroup(
            thuocTinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(thuocTinhLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblThuocTinh)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        horizontalMenu.add(thuocTinh, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 270, 140, -1));

        khoHang.setBackground(new java.awt.Color(13, 36, 51));
        khoHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                khoHangMouseClicked(evt);
            }
        });

        lblSanPham2.setFont(new java.awt.Font("Montserrat", 1, 13)); // NOI18N
        lblSanPham2.setForeground(new java.awt.Color(255, 255, 255));
        lblSanPham2.setText("Kho Hàng");

        javax.swing.GroupLayout khoHangLayout = new javax.swing.GroupLayout(khoHang);
        khoHang.setLayout(khoHangLayout);
        khoHangLayout.setHorizontalGroup(
            khoHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(khoHangLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(lblSanPham2)
                .addContainerGap(49, Short.MAX_VALUE))
        );
        khoHangLayout.setVerticalGroup(
            khoHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(khoHangLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblSanPham2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        horizontalMenu.add(khoHang, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 320, 140, -1));

        nhapHang.setBackground(new java.awt.Color(13, 36, 51));
        nhapHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nhapHangMouseClicked(evt);
            }
        });

        lblSanPham3.setFont(new java.awt.Font("Montserrat", 1, 13)); // NOI18N
        lblSanPham3.setForeground(new java.awt.Color(255, 255, 255));
        lblSanPham3.setText("Nhập Hàng");

        javax.swing.GroupLayout nhapHangLayout = new javax.swing.GroupLayout(nhapHang);
        nhapHang.setLayout(nhapHangLayout);
        nhapHangLayout.setHorizontalGroup(
            nhapHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(nhapHangLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(lblSanPham3)
                .addContainerGap(39, Short.MAX_VALUE))
        );
        nhapHangLayout.setVerticalGroup(
            nhapHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(nhapHangLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblSanPham3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        horizontalMenu.add(nhapHang, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, 140, 30));

        bg.add(horizontalMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 140, 650));

        jGUIForms.setBackground(new java.awt.Color(255, 255, 255));
        jGUIForms.setMaximumSize(new java.awt.Dimension(1100, 680));
        jGUIForms.setMinimumSize(new java.awt.Dimension(1100, 680));
        jGUIForms.setRequestFocusEnabled(false);

        javax.swing.GroupLayout jGUIFormsLayout = new javax.swing.GroupLayout(jGUIForms);
        jGUIForms.setLayout(jGUIFormsLayout);
        jGUIFormsLayout.setHorizontalGroup(
            jGUIFormsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1100, Short.MAX_VALUE)
        );
        jGUIFormsLayout.setVerticalGroup(
            jGUIFormsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 680, Short.MAX_VALUE)
        );

        bg.add(jGUIForms, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 60, 1100, 650));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(bg, javax.swing.GroupLayout.PREFERRED_SIZE, 705, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void trangChuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_trangChuMouseClicked
        // TODO add your handling code here:
        trangChu.setBackground(ClickedColor);
        banHang.setBackground(DefaultColor);
        sanPham.setBackground(DefaultColor);
        thuocTinh.setBackground(DefaultColor);
        khoHang.setBackground(DefaultColor);
        nhapHang.setBackground(DefaultColor);
        nhanSu.setBackground(DefaultColor);
        khachHang.setBackground(DefaultColor);
        taiKhoan.setBackground(DefaultColor);
        
//        menuName.setText("| Trang Chủ");
//        TrangChu trangChu = new TrangChu();
//        jGUIForms.removeAll();
//        jGUIForms.add(trangChu).setVisible(true);
        
    }//GEN-LAST:event_trangChuMouseClicked

    private void banHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_banHangMouseClicked
        // TODO add your handling code here:
        trangChu.setBackground(DefaultColor);
        banHang.setBackground(ClickedColor);
        sanPham.setBackground(DefaultColor);
        thuocTinh.setBackground(DefaultColor);
        khoHang.setBackground(DefaultColor);
        nhapHang.setBackground(DefaultColor);
        nhanSu.setBackground(DefaultColor);
        khachHang.setBackground(DefaultColor);
        taiKhoan.setBackground(DefaultColor);
        
        menuName.setText("| Bán Hàng");
        
        QLBH banHang = new QLBH();
        jGUIForms.removeAll();
        jGUIForms.add(banHang).setVisible(true);
    }//GEN-LAST:event_banHangMouseClicked

    private void sanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sanPhamMouseClicked
        // TODO add your handling code here:
        trangChu.setBackground(DefaultColor);
        banHang.setBackground(DefaultColor);
        sanPham.setBackground(ClickedColor);
        thuocTinh.setBackground(DefaultColor);
        khoHang.setBackground(DefaultColor);
        nhapHang.setBackground(DefaultColor);
        nhanSu.setBackground(DefaultColor);
        khachHang.setBackground(DefaultColor);
        taiKhoan.setBackground(DefaultColor);
        
        menuName.setText("| Sản Phẩm");
        
        QLSP qlsp = new QLSP();
        jGUIForms.removeAll();
        jGUIForms.add(qlsp).setVisible(true);
    }//GEN-LAST:event_sanPhamMouseClicked

    private void nhanSuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nhanSuMouseClicked
        // TODO add your handling code here:
        trangChu.setBackground(DefaultColor);
        banHang.setBackground(DefaultColor);
        sanPham.setBackground(DefaultColor);
        thuocTinh.setBackground(DefaultColor);
        khoHang.setBackground(DefaultColor);
        nhapHang.setBackground(DefaultColor);
        nhanSu.setBackground(ClickedColor);
        khachHang.setBackground(DefaultColor);
        taiKhoan.setBackground(DefaultColor);
        
        menuName.setText("| Nhân Sự");
        
        QLNS ns = new QLNS();
        jGUIForms.removeAll();
        jGUIForms.add(ns).setVisible(true);
    }//GEN-LAST:event_nhanSuMouseClicked

    private void khachHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_khachHangMouseClicked
        // TODO add your handling code here:
        trangChu.setBackground(DefaultColor);
        banHang.setBackground(DefaultColor);
        sanPham.setBackground(DefaultColor);
        nhanSu.setBackground(DefaultColor);
        thuocTinh.setBackground(DefaultColor);
        khoHang.setBackground(DefaultColor);
        nhapHang.setBackground(DefaultColor);
        khachHang.setBackground(ClickedColor);
        taiKhoan.setBackground(DefaultColor);
        
        menuName.setText("| Khách Hàng");

        QLKHACHHANG khachHang = new QLKHACHHANG();
        jGUIForms.removeAll();
        jGUIForms.add(khachHang).setVisible(true);
    }//GEN-LAST:event_khachHangMouseClicked

    private void taiKhoanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_taiKhoanMouseClicked
        // TODO add your handling code here:
        trangChu.setBackground(DefaultColor);
        banHang.setBackground(DefaultColor);
        sanPham.setBackground(DefaultColor);
        thuocTinh.setBackground(DefaultColor);
        khoHang.setBackground(DefaultColor);
        nhapHang.setBackground(DefaultColor);
        nhanSu.setBackground(DefaultColor);
        khachHang.setBackground(DefaultColor);
        taiKhoan.setBackground(ClickedColor);
        
        menuName.setText("| Tài Khoản");

        QLTK taiKhoan = new QLTK();
        jGUIForms.removeAll();
        jGUIForms.add(taiKhoan).setVisible(true);
    }//GEN-LAST:event_taiKhoanMouseClicked

    private void thongKeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_thongKeMouseClicked
        // TODO add your handling code here:
        trangChu.setBackground(DefaultColor);
        banHang.setBackground(DefaultColor);
        sanPham.setBackground(DefaultColor);
        thuocTinh.setBackground(DefaultColor);
        khoHang.setBackground(DefaultColor);
        nhapHang.setBackground(DefaultColor);
        nhanSu.setBackground(DefaultColor);
        khachHang.setBackground(DefaultColor);
        taiKhoan.setBackground(DefaultColor);
        
        QuanLyThongKe tk = new QuanLyThongKe();
        jGUIForms.removeAll();
        jGUIForms.add(tk).setVisible(true);
    }//GEN-LAST:event_thongKeMouseClicked

    private void thuocTinhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_thuocTinhMouseClicked
        // TODO add your handling code here:
        trangChu.setBackground(DefaultColor);
        banHang.setBackground(DefaultColor);
        sanPham.setBackground(DefaultColor);
        thuocTinh.setBackground(ClickedColor);
        khoHang.setBackground(DefaultColor);
        nhapHang.setBackground(DefaultColor);
        nhanSu.setBackground(DefaultColor);
        khachHang.setBackground(DefaultColor);
        taiKhoan.setBackground(DefaultColor);
        
        QLTT thuocTinh = new QLTT();
        jGUIForms.removeAll();
        jGUIForms.add(thuocTinh).setVisible(true);
    }//GEN-LAST:event_thuocTinhMouseClicked

    private void khoHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_khoHangMouseClicked
        // KHOO
        trangChu.setBackground(DefaultColor);
        banHang.setBackground(DefaultColor);
        sanPham.setBackground(DefaultColor);
        thuocTinh.setBackground(DefaultColor);
        khoHang.setBackground(ClickedColor);
        nhapHang.setBackground(DefaultColor);
        nhanSu.setBackground(DefaultColor);
        khachHang.setBackground(DefaultColor);
        taiKhoan.setBackground(DefaultColor);
        
        QuanLyKhoHang khoHang = new QuanLyKhoHang();
        jGUIForms.removeAll();
        jGUIForms.add(khoHang).setVisible(true);
    }//GEN-LAST:event_khoHangMouseClicked

    private void nhapHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nhapHangMouseClicked
        // NHAP/ XUAT
        trangChu.setBackground(DefaultColor);
        banHang.setBackground(DefaultColor);
        sanPham.setBackground(DefaultColor);
        thuocTinh.setBackground(DefaultColor);
        khoHang.setBackground(DefaultColor);
        nhapHang.setBackground(ClickedColor);
        nhanSu.setBackground(DefaultColor);
        khachHang.setBackground(DefaultColor);
        taiKhoan.setBackground(DefaultColor);
        
        QLNH nhapXuat = new QLNH();
        jGUIForms.removeAll();
        jGUIForms.add(nhapXuat).setVisible(true);
    }//GEN-LAST:event_nhapHangMouseClicked

    private void btnCloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCloseMouseClicked
        // EXIT
        System.exit(0);
    }//GEN-LAST:event_btnCloseMouseClicked

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
//                new Admin_View().setVisible(true);
                User user = new User();
                user.setUserName("junggo");
                user.setRole("vjp");

                new Admin_View(user).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel banHang;
    private javax.swing.JPanel bg;
    private javax.swing.JButton btnClose;
    private javax.swing.JPanel horizontalMenu;
    private javax.swing.JDesktopPane jGUIForms;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel khachHang;
    private javax.swing.JPanel khoHang;
    private javax.swing.JLabel lblBanHang;
    private javax.swing.JLabel lblExit;
    private javax.swing.JLabel lblKhachHang;
    private javax.swing.JLabel lblNhanSu;
    private javax.swing.JLabel lblSanPham;
    private javax.swing.JLabel lblSanPham2;
    private javax.swing.JLabel lblSanPham3;
    private javax.swing.JLabel lblTaiKhoan;
    private javax.swing.JLabel lblThuocTinh;
    private javax.swing.JLabel lblTrangChu;
    private javax.swing.JLabel lbl_UserID;
    private javax.swing.JLabel logo;
    private javax.swing.JLabel menuName;
    private javax.swing.JPanel nhanSu;
    private javax.swing.JPanel nhapHang;
    private javax.swing.JPanel sanPham;
    private javax.swing.JPanel taiKhoan;
    private javax.swing.JPanel thongKe;
    private javax.swing.JPanel thuocTinh;
    private javax.swing.JPanel trangChu;
    private javax.swing.JTextField txtUser_ID;
    private javax.swing.JPanel verticalLayout;
    // End of variables declaration//GEN-END:variables
}
