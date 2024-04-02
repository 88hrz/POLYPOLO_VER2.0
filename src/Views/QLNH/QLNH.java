/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package Views.QLNH;

import Models.NCC;
import Services.NCCService;
import Services.PhieuNhapService;
import Services.UserService;
import Utils.SVGImage;
import ViewModels.PhieuNhapViewModel;
import Views.Login;
import java.awt.Component;
import java.io.File;
import java.io.FileOutputStream;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author X1
 */
public class QLNH extends javax.swing.JInternalFrame {
    NCCService nccService = new NCCService();
    SVGImage svgSet = new SVGImage();
    UserService uService = new UserService();
    PhieuNhapService pnService = new PhieuNhapService();
    DecimalFormat formatter = new DecimalFormat("#,###");
    
    /**
     * Creates new form A_NHAPHANG
     */
    
    public QLNH() {
        initComponents();
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0,0,0,0));
        BasicInternalFrameUI ui = (BasicInternalFrameUI) this.getUI();
        ui.setNorthPane(null);
        setButtonIcon();
        loadTable(nccService.getList());
        adjustWidths(tblNCC);
        loadTableNhapHang(pnService.getListPN());
    }
    
    void setButtonIcon() {
        btnAdd.setIcon(svgSet.createSVGIcon("Images/SVG/add.svg", 19, 19));
        btnUpdate.setIcon(svgSet.createSVGIcon("Images/SVG/update.svg", 19, 19));
        btnLoad.setIcon(svgSet.createSVGIcon("Images/SVG/reload.svg", 18, 18));
        btnHide.setIcon(svgSet.createSVGIcon("Images/SVG/delete.svg", 18, 18));
        btnExport.setIcon(svgSet.createSVGIcon("Images/SVG/pdf-color.svg", 19, 19));
        
        btnAddNCC.setIcon(svgSet.createSVGIcon("Images/SVG/add.svg", 19, 19));
        btnUpdateNCC.setIcon(svgSet.createSVGIcon("Images/SVG/update.svg", 19, 19));
        btnLoadNCC.setIcon(svgSet.createSVGIcon("Images/SVG/reload.svg", 18, 18));
        btnHideNCC.setIcon(svgSet.createSVGIcon("Images/SVG/delete.svg", 18, 18));
        btnExportNCC.setIcon(svgSet.createSVGIcon("Images/SVG/pdf-color.svg", 19, 19));
    }
    
    //LOADTABLE
    void loadTable(ArrayList<NCC> ls){
        DefaultTableModel model = (DefaultTableModel) tblNCC.getModel();
        model.setRowCount(0);
        for (NCC ncc : ls) {
            model.addRow(new Object[]{
                ncc.getMaNCC(), ncc.getTenNCC(), ncc.getDiaChi(), ncc.getEmail(), ncc.getSdt()
            });
        }
        
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
        TableColumnModel columnModel = tblNCC.getColumnModel();
        for (int i = 0; i < columnModel.getColumnCount(); i++) {
            columnModel.getColumn(i).setCellRenderer(centerRenderer);
        }
    }
    
    void loadTableNhapHang(ArrayList<PhieuNhapViewModel> ls) {
        DefaultTableModel model = (DefaultTableModel) tblNhapHang.getModel();
        model.setRowCount(0);
        for (PhieuNhapViewModel pn : ls) {
            String formatTotal = formatter.format(pn.getTongDon());
            model.addRow(new Object[]{
                pn.getMaPhieu(), pn.getTenNCC(), pn.getTenNV(), pn.getNgayL(), formatTotal
            });
            DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
            centerRenderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
            TableColumnModel columnModel = tblNhapHang.getColumnModel();
            for (int i = 0; i < columnModel.getColumnCount(); i++) {
                columnModel.getColumn(i).setCellRenderer(centerRenderer);
            }
        }
    }
    
    void adjustWidths(JTable table) {
        for (int column = 0; column < table.getColumnCount(); column++) {
            TableColumn tableColumn = table.getColumnModel().getColumn(column);

            int preferredWidth = tableColumn.getMinWidth();
            int maxWidth = tableColumn.getMaxWidth();

            for (int row = 0; row < table.getRowCount(); row++) {
                TableCellRenderer cellRenderer = table.getCellRenderer(row, column);
                Component c = table.prepareRenderer(cellRenderer, row, column);
                int width = c.getPreferredSize().width + table.getIntercellSpacing().width;
                preferredWidth = Math.max(preferredWidth, width);

                if (preferredWidth >= maxWidth) {
                    preferredWidth = maxWidth;
                    break;
                }
            }
            tableColumn.setPreferredWidth(preferredWidth);
        }
    }
    
    //GETMODEL
    public NCC getModel(){
        int pos = tblNCC.getSelectedRow();
        Integer id = (Integer) tblNCC.getValueAt(pos, 0);
        
        String tenNCC = nccService.getListById(id).getTenNCC();
        String diaC = nccService.getListById(id).getDiaChi();
        String email = nccService.getListById(id).getEmail();
        String soDT = nccService.getListById(id).getSdt();
        
        NCC ncc = new NCC(id, tenNCC, diaC, email, soDT);
        return ncc;
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
        jPanel3 = new javax.swing.JPanel();
        btnAdd = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnHide = new javax.swing.JButton();
        btnExport = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        btnLoad = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblNhapHang = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        btnAddNCC = new javax.swing.JButton();
        btnUpdateNCC = new javax.swing.JButton();
        btnHideNCC = new javax.swing.JButton();
        btnLoadNCC = new javax.swing.JButton();
        btnExportNCC = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        txtSearchNCC = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblNCC = new javax.swing.JTable();

        setMaximumSize(new java.awt.Dimension(1090, 630));
        setMinimumSize(new java.awt.Dimension(1090, 630));
        setPreferredSize(new java.awt.Dimension(1090, 630));

        jTabbedPane1.setMaximumSize(new java.awt.Dimension(1090, 630));
        jTabbedPane1.setMinimumSize(new java.awt.Dimension(1090, 630));
        jTabbedPane1.setPreferredSize(new java.awt.Dimension(1090, 630));

        jPanel1.setMaximumSize(new java.awt.Dimension(1090, 630));
        jPanel1.setMinimumSize(new java.awt.Dimension(1090, 630));
        jPanel1.setPreferredSize(new java.awt.Dimension(1090, 630));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));
        jPanel3.setAlignmentX(1.0F);
        jPanel3.setAlignmentY(1.0F);

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

        btnHide.setText("XÓA");

        btnExport.setText("EXPORT");
        btnExport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportActionPerformed(evt);
            }
        });

        jButton2.setText("SEARCH");

        btnLoad.setText("LOAD");
        btnLoad.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLoadMouseClicked(evt);
            }
        });
        btnLoad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoadActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnHide, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnLoad, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnExport, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 135, Short.MAX_VALUE)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnExport, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextField1)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnLoad, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnHide, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnUpdate, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAdd, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(9, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 10, 1060, 60));

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tìm Kiếm Nâng Cao", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 3, 14))); // NOI18N

        jLabel1.setText("Nhà Cung Cấp:");

        jLabel2.setText("Nhân Viên:");

        jLabel3.setText("Khoảng Giá (VND):");

        jLabel4.setText("Đến Ngày:");

        jLabel5.setText("Từ Ngày:");

        jLabel6.setText("-");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBox2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBox3, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, 257, Short.MAX_VALUE)
                            .addComponent(jDateChooser2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(24, 24, 24))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(16, 16, 16)
                .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addContainerGap(105, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 94, -1, 460));

        tblNhapHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Mã Phiếu", "Nhà Cung Cấp", "Nhân Viên", "Ngày Lập", "Tổng Tiền"
            }
        ));
        jScrollPane1.setViewportView(tblNhapHang);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(422, 103, 650, 450));

        jTabbedPane1.addTab("Quản Lý Nhập Hàng", jPanel1);

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel5.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));
        jPanel5.setAlignmentX(1.0F);
        jPanel5.setAlignmentY(1.0F);

        btnAddNCC.setText("THÊM");
        btnAddNCC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAddNCCMouseClicked(evt);
            }
        });

        btnUpdateNCC.setText("SỬA");
        btnUpdateNCC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnUpdateNCCMouseClicked(evt);
            }
        });

        btnHideNCC.setText("XÓA");
        btnHideNCC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnHideNCCMouseClicked(evt);
            }
        });

        btnLoadNCC.setText("LOAD");
        btnLoadNCC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLoadNCCMouseClicked(evt);
            }
        });
        btnLoadNCC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoadNCCActionPerformed(evt);
            }
        });

        btnExportNCC.setText("EXPORT");
        btnExportNCC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnExportNCCMouseClicked(evt);
            }
        });
        btnExportNCC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportNCCActionPerformed(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất Cả" }));

        jButton4.setText("SEARCH");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnAddNCC, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnUpdateNCC, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnHideNCC, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnLoadNCC, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnExportNCC, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 81, Short.MAX_VALUE)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(txtSearchNCC, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton4)
                .addGap(21, 21, 21))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSearchNCC, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(10, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnLoadNCC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnExportNCC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAddNCC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnUpdateNCC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnHideNCC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel2.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 1030, 60));

        tblNCC.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Mã NCC", "Nhà Cung Cấp", "Địa Chỉ", "Email", "Số Điện Thoại"
            }
        ));
        jScrollPane2.setViewportView(tblNCC);

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 1030, 430));

        jTabbedPane1.addTab("Nhà Cung Cấp", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1084, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddMouseClicked
        // ADD
        QLNH_add nh = new QLNH_add();
        nh.setVisible(true);
    }//GEN-LAST:event_btnAddMouseClicked

    private void btnUpdateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUpdateMouseClicked
        // CHECK DETAILS
        QLNH_details nh = new QLNH_details();
        nh.setVisible(true);
    }//GEN-LAST:event_btnUpdateMouseClicked

    private void btnExportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnExportActionPerformed

    private void btnAddNCCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddNCCMouseClicked
        // ADD NCC
        QLNH_NCC_add ncc = new QLNH_NCC_add();
        ncc.setVisible(true);
    }//GEN-LAST:event_btnAddNCCMouseClicked

    private void btnUpdateNCCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUpdateNCCMouseClicked
       // UPDATE
        int pos = tblNCC.getSelectedRow();
        if (pos == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn nhà cung cấp muốn cập nhật!", "POLYPOLO thông báo", JOptionPane.WARNING_MESSAGE);
            return;
        } else {
            QLNH_NCC_update nccUpdate = new QLNH_NCC_update();
            nccUpdate.setVisible(true);
            nccUpdate.pack();

            Integer maNcc = (Integer) tblNCC.getValueAt(pos, 0);
            nccUpdate.txtId.setText(maNcc.toString());
            nccUpdate.txtNCC.setText((String) tblNCC.getValueAt(pos, 1));
            nccUpdate.txtDiaChi.setText((String) tblNCC.getValueAt(pos, 2));
            nccUpdate.txtEmail.setText((String) tblNCC.getValueAt(pos, 3));
            nccUpdate.txtSDT.setText((String) tblNCC.getValueAt(pos, 4));
        }
    }//GEN-LAST:event_btnUpdateNCCMouseClicked

    private void btnLoadNCCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoadNCCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnLoadNCCActionPerformed

    private void btnExportNCCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportNCCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnExportNCCActionPerformed

    private void btnHideNCCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHideNCCMouseClicked
        // DELETE
        int pos = tblNCC.getSelectedRow();
        if (pos >= 0) {
            int result = JOptionPane.showConfirmDialog(this, "Bạn muốn xóa nhà cung cấp không?", "POLYPOLO xác nhận", JOptionPane.YES_NO_OPTION);
            if (result == JOptionPane.YES_OPTION) {
                nccService.hideNCC(getModel());
                JOptionPane.showMessageDialog(this, "Xóa nhà cung cấp thành công!", "POLYPOLO thông báo", 0);
                loadTable(nccService.getList());
            } else if (result == JOptionPane.NO_OPTION) {
                JOptionPane.showMessageDialog(this, "Đã hủy thao tác xóa nhà cung cấp!", "POLYPOLO thông báo", 0);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn nhà cung cấp trên bảng để xóa!", "POLYPOLO thông báo", 0);
        }
    }//GEN-LAST:event_btnHideNCCMouseClicked

    private void btnLoadNCCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLoadNCCMouseClicked
        // LOAD
        loadTable(nccService.getList());
    }//GEN-LAST:event_btnLoadNCCMouseClicked

    private void btnExportNCCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExportNCCMouseClicked
        // EXPORT
        try {
            XSSFWorkbook workBook = new XSSFWorkbook();
            XSSFSheet sheet = workBook.createSheet("Danh Sách Nhà Cung Cấp");
            
            //STYLE TITLE
            XSSFRow titleRow = sheet.createRow(0);
            Cell titleCell = titleRow.createCell(0);
            titleCell.setCellValue("Danh Sách Nhà Cung Cấp POLYPOLO"); 
            sheet.addMergedRegion(new org.apache.poi.ss.util.CellRangeAddress(0,0,0,5)); 
            XSSFFont font = workBook.createFont();
            font.setFontHeightInPoints((short) 19);
            font.setBold(true);
            XSSFCellStyle style = workBook.createCellStyle();
            style.setFont(font);
            style.setAlignment(HorizontalAlignment.CENTER);
            style.setVerticalAlignment(org.apache.poi.ss.usermodel.VerticalAlignment.CENTER);
            titleCell.setCellStyle(style);
           
            //DATE
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            String currentDate = sdf.format(new Date());
            
            SimpleDateFormat sdfHrs = new SimpleDateFormat("HH:mm:ss");
            String currentTime = sdfHrs.format(new Date());
            
            XSSFRow dateRow = sheet.createRow(1);
            org.apache.poi.ss.usermodel.Cell dateCell = dateRow.createCell(0);
            dateCell.setCellValue("Ngày: " + currentDate + " | Giờ: " +currentTime);
            sheet.addMergedRegion(new org.apache.poi.ss.util.CellRangeAddress(1, 1, 0, 5)); // Merge từ cột 0 đến 9
            XSSFCellStyle dateStyle = workBook.createCellStyle();
            dateStyle.setAlignment(HorizontalAlignment.RIGHT);
            dateCell.setCellStyle(dateStyle);
            
            //STYLE FONT
            Font headerFont = workBook.createFont();
            headerFont.setBold(true);
            headerFont.setFontHeightInPoints((short) 11);
            
            CellStyle headerStyle = workBook.createCellStyle();
            headerStyle.setFont(headerFont);
            headerStyle.setAlignment(HorizontalAlignment.CENTER);

            //ADD
            XSSFRow row = null;
            Cell cell = null;
            row = sheet.createRow(3);

            cell = row.createCell(0, org.apache.poi.ss.usermodel.CellType.STRING);
            cell.setCellValue("STT");

            cell = row.createCell(1, org.apache.poi.ss.usermodel.CellType.STRING);
            Sheet s = cell.getSheet();
            cell.setCellValue("Mã Nhà Cung Cấp");
            s.autoSizeColumn(1);

            cell = row.createCell(2, org.apache.poi.ss.usermodel.CellType.STRING);
            cell.setCellValue("Tên Nhà Cung Cấp");
            s.autoSizeColumn(2);
            
            cell = row.createCell(3, org.apache.poi.ss.usermodel.CellType.STRING);
            cell.setCellValue("Địa Chỉ");
            s.autoSizeColumn(3);
            
            cell = row.createCell(4, org.apache.poi.ss.usermodel.CellType.STRING);
            cell.setCellValue("Email");
            s.autoSizeColumn(4);
            
            cell = row.createCell(5, org.apache.poi.ss.usermodel.CellType.STRING);
            cell.setCellValue("Số Điện Thoại");
            s.autoSizeColumn(5);

            for (int i = 0; i < 6; i++) {
                cell = row.getCell(i);
                cell.setCellStyle(headerStyle);
            }

            ArrayList<NCC> ls = nccService.getList();
            for (int i = 0; i < ls.size(); i++) {
                row = sheet.createRow(4 + i);

                //STYLE FONT
                CellStyle docuStyle = workBook.createCellStyle();
                docuStyle.setAlignment(HorizontalAlignment.CENTER);

                cell = row.createCell(0, org.apache.poi.ss.usermodel.CellType.NUMERIC);
                cell.setCellValue(i + 1);
                cell.setCellStyle(docuStyle);

                cell = row.createCell(1, org.apache.poi.ss.usermodel.CellType.NUMERIC);
                cell.setCellValue("NCC " + ls.get(i).getMaNCC());
                cell.setCellStyle(docuStyle);

                cell = row.createCell(2, org.apache.poi.ss.usermodel.CellType.STRING);
                cell.setCellValue(ls.get(i).getTenNCC());
                s.autoSizeColumn(2);

                cell = row.createCell(3, org.apache.poi.ss.usermodel.CellType.STRING);
                cell.setCellValue(ls.get(i).getDiaChi());
                s.autoSizeColumn(3);

                cell = row.createCell(4, org.apache.poi.ss.usermodel.CellType.STRING);
                cell.setCellValue(ls.get(i).getEmail());
                s.autoSizeColumn(4);

                cell = row.createCell(5, org.apache.poi.ss.usermodel.CellType.STRING);
                cell.setCellValue(ls.get(i).getSdt());
                s.autoSizeColumn(5);
                cell.setCellStyle(docuStyle);
            }
            
            //STYLE
            CellStyle footerStyle = workBook.createCellStyle();
            footerStyle.setFont(headerFont);
            footerStyle.setAlignment(HorizontalAlignment.LEFT);
            
            //ROW CUỐI
            int rowS = 5 + ls.size();

            XSSFRow tongSPRow = sheet.createRow(rowS);
            org.apache.poi.ss.usermodel.Cell tongSPCell = tongSPRow.createCell(1);

            tongSPCell.setCellValue("Tổng Nhà Cung Cấp:");
            tongSPCell.setCellStyle(footerStyle);
            org.apache.poi.ss.usermodel.Cell tongSPCelll = tongSPRow.createCell(2);
            tongSPCelll.setCellValue(ls.size());
            sheet.autoSizeColumn(1);
            sheet.autoSizeColumn(2);

            org.apache.poi.ss.usermodel.Cell ngX = tongSPRow.createCell(4);
            ngX.setCellValue("Người Xuất:");
            ngX.setCellStyle(footerStyle);
            org.apache.poi.ss.usermodel.Cell thongT = tongSPRow.createCell(5);
            thongT.setCellValue(uService.getName(Login.dataStatic));
            sheet.autoSizeColumn(4);
            sheet.autoSizeColumn(5);
            
            String defaultCurrentDirectoryPath = "C:\\Users\\X1\\OneDrive\\Documents\\Custom Office Templates";
            JFileChooser fileChooser = new JFileChooser(defaultCurrentDirectoryPath);
            fileChooser.setDialogTitle("Chọn nơi lưu file");
            fileChooser.setAcceptAllFileFilterUsed(false);
            FileNameExtensionFilter filter = new FileNameExtensionFilter("Excel Files", "xlsx", "xls");
            fileChooser.addChoosableFileFilter(filter);

            int userSelection = fileChooser.showSaveDialog(null);

            if (userSelection == JFileChooser.APPROVE_OPTION) {
                File fileToSave = fileChooser.getSelectedFile();
                String filePath = fileToSave.getAbsolutePath();
                if (!filePath.endsWith(".xlsx")) {
                    filePath += ".xlsx";
                }

                FileOutputStream outputStream = new FileOutputStream(filePath);
                workBook.write(outputStream);
                workBook.close();
                outputStream.close();

                File file = new File(filePath);
                try {
                    FileOutputStream fis = new FileOutputStream(file);
                    workBook.write(fis);
                    fis.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Thao tác đã bị hủy!", "POLYPOLO thông báo", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        JOptionPane.showInternalMessageDialog(this, "Đã xuất danh sách thành công!", "POLYPOLO thông báo", 0);
    }//GEN-LAST:event_btnExportNCCMouseClicked

    private void btnLoadMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLoadMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnLoadMouseClicked

    private void btnLoadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnLoadActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnAddNCC;
    private javax.swing.JButton btnExport;
    private javax.swing.JButton btnExportNCC;
    private javax.swing.JButton btnHide;
    private javax.swing.JButton btnHideNCC;
    private javax.swing.JButton btnLoad;
    private javax.swing.JButton btnLoadNCC;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JButton btnUpdateNCC;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTable tblNCC;
    private javax.swing.JTable tblNhapHang;
    private javax.swing.JTextField txtSearchNCC;
    // End of variables declaration//GEN-END:variables
}
