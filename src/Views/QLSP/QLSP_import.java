/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Views.QLSP;

import Models.SanPham;
import Services.SanPhamService;
import Utils.SVGImage;
import com.formdev.flatlaf.themes.FlatMacLightLaf;
import java.awt.Color;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.text.DecimalFormat;
import java.util.Date;
import javax.swing.BorderFactory;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author X1
 */
public class QLSP_import extends javax.swing.JFrame {
    SVGImage svgSet = new SVGImage();
    SanPhamService spService = new SanPhamService();
    DecimalFormat formatter = new DecimalFormat("#,###");
    
    /**
     * Creates new form QLSP_import
     */
    
    public QLSP_import() {
        initComponents();
        setLocationRelativeTo(null);
        btnImport.setIcon(svgSet.createSVGIcon("Images/SVG/g-excel.svg", 20, 20));
        btnClose.setIcon(svgSet.createSVGIcon("Images/SVG/close.svg", 15, 15));
        btnClose.setBorderPainted(false);
        getRootPane().setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY,2, true));
    }

    public boolean validateData() {
        int pos = tblImportSP.getSelectedRow();
        Integer excelMaSP = (Integer) tblImportSP.getValueAt(pos, 0);
        Integer excelMaDM = (Integer) tblImportSP.getValueAt(pos, 1);
        Integer excelMaBrand = (Integer) tblImportSP.getValueAt(pos, 2);
        Integer excelMaMau = (Integer) tblImportSP.getValueAt(pos, 3);
        Integer excelMaSize = (Integer) tblImportSP.getValueAt(pos, 4);
        Integer excelMaChatL = (Integer) tblImportSP.getValueAt(pos, 5);
        Integer excelMaKho = (Integer) tblImportSP.getValueAt(pos, 6);
        Double excelGiaNhap = Double.parseDouble(tblImportSP.getValueAt(pos, 7).toString());
        Double excelGiaBan = Double.parseDouble(tblImportSP.getValueAt(pos, 8).toString());
        String excelTrangThai = (String) tblImportSP.getValueAt(pos, 9);
        String excelTenSP = (String) tblImportSP.getValueAt(pos, 10);
        Integer excelSLT = (Integer) tblImportSP.getValueAt(pos, 11);
        String excelImg = (String) tblImportSP.getValueAt(pos, 12);
        Date excelNgayN = (Date) tblImportSP.getValueAt(pos, 13);

        if (spService.checkId(excelMaSP)) {
            JOptionPane.showMessageDialog(this, "Id sản phẩm bị trùng, không thể thêm!", "POLYPOLO thông báo", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (!(excelMaSP instanceof Integer) || excelMaSP <= 0) {
            JOptionPane.showMessageDialog(this, "Sai định dạng, Id phải là số nguyên dương!", "POLYPOLO thông báo", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (!spService.checkName(excelTenSP)) {
            JOptionPane.showMessageDialog(this, "Tên sản phẩm bị trùng, không thể thêm!", "POLYPOLO thông báo", 0);
            return false;
        }

        if (!spService.checkIdCat(excelMaDM)) {
            JOptionPane.showMessageDialog(this, "Mã danh mục không tồn tại, không thể thêm!", "POLYPOLO thông báo", 0);
            return false;
        }
        if (!(excelMaDM instanceof Integer) || excelMaDM <= 0) {
            JOptionPane.showMessageDialog(this, "Sai định dạng, mã danh mục phải là số nguyên dương!", "POLYPOLO thông báo", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (!spService.checkIdBrand(excelMaBrand)) {
            JOptionPane.showMessageDialog(this, "Mã thương hiệu không tồn tại, không thể thêm!", "POLYPOLO thông báo", 0);
            return false;
        }
        if (!(excelMaBrand instanceof Integer) || excelMaBrand <= 0) {
            JOptionPane.showMessageDialog(this, "Sai định dạng, mã thương hiệu phải là số nguyên dương!", "POLYPOLO thông báo", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (!spService.checkIdColor(excelMaMau)) {
            JOptionPane.showMessageDialog(this, "Mã màu không tồn tại, không thể thêm!", "POLYPOLO thông báo", 0);
            return false;
        }
        if (!(excelMaMau instanceof Integer) || excelMaMau <= 0) {
            JOptionPane.showMessageDialog(this, "Sai định dạng, mã màu phải là số nguyên dương!", "POLYPOLO thông báo", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (!spService.checkIdSz(excelMaSize)) {
            JOptionPane.showMessageDialog(this, "Mã size không tồn tại, không thể thêm!", "POLYPOLO thông báo", 0);
            return false;
        }
        if (!(excelMaSize instanceof Integer) || excelMaSize <= 0) {
            JOptionPane.showMessageDialog(this, "Sai định dạng, mã size phải là số nguyên dương!", "POLYPOLO thông báo", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        if (!spService.checkIdChatL(excelMaChatL)) {
            JOptionPane.showMessageDialog(this, "Mã chất liệu không tồn tại, không thể thêm!", "POLYPOLO thông báo", 0);
            return false;
        }
        if (!(excelMaChatL instanceof Integer) || excelMaChatL <= 0) {
            JOptionPane.showMessageDialog(this, "Sai định dạng, mã chất liệu phải là số nguyên dương!", "POLYPOLO thông báo", JOptionPane.ERROR_MESSAGE);
            return false;
        }
      
        if (!spService.checkIdKho(excelMaKho)) {
            JOptionPane.showMessageDialog(this, "Mã kho hàng không tồn tại, không thể thêm!", "POLYPOLO thông báo", 0);
            return false;
        }
        if (!(excelMaKho instanceof Integer) || excelMaKho <= 0) {
            JOptionPane.showMessageDialog(this, "Sai định dạng, mã kho hàng phải là số nguyên dương!", "POLYPOLO thông báo", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        if (!(excelGiaNhap instanceof Double) || excelGiaNhap <= 0) {
            JOptionPane.showMessageDialog(this, "Giá nhập phải là số và lớn hơn 0!", "POLYPOLO thông báo", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (!(excelGiaBan instanceof Double) || excelGiaBan <= 0) {
            JOptionPane.showMessageDialog(this, "Giá bán phải là số và lớn hơn 0!", "POLYPOLO thông báo", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        if (!(excelTrangThai instanceof String)) {
            JOptionPane.showMessageDialog(this, "Trạng thái phải là chuỗi ký tự!", "POLYPOLO thông báo", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (!(excelSLT instanceof Integer) || (Integer) excelSLT < 0) {
            JOptionPane.showMessageDialog(this, "Sai định dạng, số lượng phải là số nguyên không âm!", "POLYPOLO thông báo", JOptionPane.ERROR_MESSAGE);
            return false;
        } 
        if (!(excelImg instanceof String)) {
            JOptionPane.showMessageDialog(this, "Đường dẫn ảnh phải là chuỗi ký tự!", "POLYPOLO thông báo", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (excelNgayN == null) {
            JOptionPane.showMessageDialog(this, "Ngày nhập không hợp lệ hoặc sau ngày hiện tại!", "POLYPOLO thông báo", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        else {
            return true;
        }
    }
    
    void importExcelToTable() {
        DefaultTableModel model = (DefaultTableModel) tblImportSP.getModel();
        model.setRowCount(0);

        File excelFile;
        FileInputStream fis = null;
        BufferedInputStream excelBIS = null;
        XSSFWorkbook excelImportToJTable = null;
        String defaultCurrentDirectoryPath = "C:\\Users\\X1\\OneDrive\\Documents\\Custom Office Templates";
        JFileChooser excelFileChooser = new JFileChooser(defaultCurrentDirectoryPath);
        excelFileChooser.setDialogTitle("Lựa File Excel");
        FileNameExtensionFilter fnef = new FileNameExtensionFilter("EXCEL FILES", "xls", "xlsx", "xlsm");
        excelFileChooser.setFileFilter(fnef);
        int excelChooser = excelFileChooser.showOpenDialog(null);

        if (excelChooser == JFileChooser.APPROVE_OPTION) {
            try {
                excelFile = excelFileChooser.getSelectedFile();
                txtFilePath.setText(excelFile.toString());
                fis = new FileInputStream(excelFile);
                excelBIS = new BufferedInputStream(fis);
                excelImportToJTable = new XSSFWorkbook(excelBIS);
                XSSFSheet excelSheet = excelImportToJTable.getSheetAt(0);

                for (int row = 1; row <= excelSheet.getLastRowNum(); row++) { //START FROM ROW 2
                    XSSFRow excelRow = excelSheet.getRow(row);

                    if (excelRow != null) {
                        boolean isEmptyRow = true;

                        for (int cellNum = 0; cellNum < excelRow.getLastCellNum(); cellNum++) {
                            XSSFCell cell = excelRow.getCell(cellNum, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                            if (cell != null && cell.getCellType() != CellType.BLANK) {
                                isEmptyRow = false;
                                break;
                            }
                        }

                        if (!isEmptyRow) {
                            Integer excelMaSP = (int) excelRow.getCell(0, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).getNumericCellValue();
                            Integer excelMaDM = (int) excelRow.getCell(1, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).getNumericCellValue();
                            Integer excelMaBrand = (int) excelRow.getCell(2, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).getNumericCellValue();
                            Integer excelMaMau = (int) excelRow.getCell(3, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).getNumericCellValue();
                            Integer excelMaSize = (int) excelRow.getCell(4, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).getNumericCellValue();
                            Integer excelMaChatL = (int) excelRow.getCell(5, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).getNumericCellValue();
                            Integer excelMaKho = (int) excelRow.getCell(6, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).getNumericCellValue();
                            Double excelGiaNhap = excelRow.getCell(7, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).getNumericCellValue();
                            Double excelGiaBan = excelRow.getCell(8, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).getNumericCellValue();         
                            String excelTrangThai = excelRow.getCell(9, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).getStringCellValue();
                            String excelTenSP = excelRow.getCell(10, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).getStringCellValue();
                            Integer excelSLT = (int) excelRow.getCell(11, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).getNumericCellValue();
                            String excelImg = excelRow.getCell(12, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).getStringCellValue();
                            Date excelNgayN = excelRow.getCell(13, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).getDateCellValue();
                            
                            String giaN = formatter.format(excelGiaNhap);
                            String giaB = formatter.format(excelGiaBan);
                            model.addRow(new Object[]{excelMaSP, excelMaDM, excelMaBrand, excelMaMau, excelMaSize, excelMaChatL, excelMaKho, giaN, giaB, excelTrangThai, excelTenSP, excelSLT, excelImg, excelNgayN});
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    if (fis != null) {
                        fis.close();
                    }
                    if (excelBIS != null) {
                        excelBIS.close();
                    }
                    if (excelImportToJTable != null) {
                        excelImportToJTable.close();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
    
    //GETMODEL
    public SanPham getModelSP() {
        int pos = tblImportSP.getSelectedRow();

        if (pos < 0) {
            JOptionPane.showMessageDialog(this, "Lỗi thao tác, bấm vào bảng để import!", "POLYPOLO thông báo", JOptionPane.ERROR_MESSAGE);
            return null;
        }
        return new SanPham(
                (Integer) tblImportSP.getValueAt(pos, 0), // MaSP
                (String) tblImportSP.getValueAt(pos, 10), // TenSP
                (Integer) tblImportSP.getValueAt(pos, 1), // MaDM
                (String) tblImportSP.getValueAt(pos, 9), // TrangThai
                (Double) tblImportSP.getValueAt(pos, 7), // giaN
                (Double) tblImportSP.getValueAt(pos, 8), // giaB
                (Integer) tblImportSP.getValueAt(pos, 4), // MaSize
                (Integer) tblImportSP.getValueAt(pos, 3), // MaMau
                (Integer) tblImportSP.getValueAt(pos, 11), // SoLuong
                (Integer) tblImportSP.getValueAt(pos, 2), // MaBrand
                (Integer) tblImportSP.getValueAt(pos, 5), // MaChatL
                (Integer) tblImportSP.getValueAt(pos, 6), // MaKho,
                (Date) tblImportSP.getValueAt(pos, 13) // NgayNhap 
        );
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtFilePath = new javax.swing.JTextField();
        btnChooseFile = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblImportSP = new javax.swing.JTable();
        btnImport = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        btnClose = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(846, 505));
        setUndecorated(true);

        btnChooseFile.setText("Choose File");
        btnChooseFile.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnChooseFileMouseClicked(evt);
            }
        });

        tblImportSP.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "idSP", "idDM", "idBrand", "idMau", "idSize", "idChatLieu", "idKho", "giaN", "giaB", "trangT", "tenSP", "soL", "img", "ngayN"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, true, true, true, true, true, true, true, true, false, true, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblImportSP);

        btnImport.setText("IMPORT");
        btnImport.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnImportMouseClicked(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(0, 102, 204));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Montserrat", 1, 26)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("IMPORT SẢN PHẨM");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(397, 50, 280, -1));

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
                .addGap(0, 1154, Short.MAX_VALUE)
                .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnClose, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(-190, 0, 1210, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnImport, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtFilePath, javax.swing.GroupLayout.PREFERRED_SIZE, 439, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addComponent(btnChooseFile))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 961, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFilePath, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnChooseFile))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnImport, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnChooseFileMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnChooseFileMouseClicked
        // IMPORT
        importExcelToTable();
    }//GEN-LAST:event_btnChooseFileMouseClicked

    private void btnImportMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnImportMouseClicked
        // ADD
        try {
            int pos = tblImportSP.getSelectedRow();
            if (pos == -1) {
                JOptionPane.showMessageDialog(this, "Lỗi thao tác, bấm vào bảng để import!", "POLYPOLO thông báo", JOptionPane.WARNING_MESSAGE);
                return;
            }
            if (validateData()) {
                JOptionPane.showMessageDialog(this, spService.addImport(getModelSP()),"POLYPOLO thông báo" ,JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Import thất bại!", "POLYPOLO thông báo", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnImportMouseClicked

    private void btnCloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCloseMouseClicked
        // CLOSE
        this.dispose();
    }//GEN-LAST:event_btnCloseMouseClicked

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCloseActionPerformed

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
                new QLSP_import().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnChooseFile;
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnImport;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblImportSP;
    private javax.swing.JTextField txtFilePath;
    // End of variables declaration//GEN-END:variables
}
