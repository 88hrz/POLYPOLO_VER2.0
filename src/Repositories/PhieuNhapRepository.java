/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories;

import Models.MyPurchase;
import Models.PhieuNhap;
import Models.PhieuNhapChiTiet;
import ViewModels.PN_PhieuNhapViewModel;
import ViewModels.PN_SanPhamViewModel;
import ViewModels.PhieuNhapViewModel;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author X1
 */

public class PhieuNhapRepository {
    DbConnection dbConnection;
    
    //PRINT
    public ArrayList<MyPurchase> getListSupplierById(Integer id){
        String sql = "SELECT TOP 1 ncc.NhaCungCapID, ncc.TenNhaCungCap, ncc.SoDT, ncc.Email, ncc.DiaChi, pnct.PhuongThucNhap FROM PhieuNhapKho pn \n" +
"					INNER JOIN NhaCungCap ncc ON pn.NhaCungCapID = ncc.NhaCungCapID\n" +
"					INNER JOIN ChiTietPhieuNhap pnct ON pn.PhieuNhapID = pnct.PhieuNhapID\n" +
"						WHERE ncc.Deleted!=1 AND pn.PhieuNhapID = ?";
        ArrayList<MyPurchase> ls = new ArrayList<>();
        
        try (Connection conn = dbConnection.getConnection();
                PreparedStatement ps = conn.prepareCall(sql)){
            ps.setObject(1, id);
            
             ResultSet rs = ps.executeQuery();
             while (rs.next()) {                
                Integer idNCC = rs.getInt("NhaCungCapID");
                String tenNCC = rs.getString("TenNhaCungCap");
                String soDT = rs.getString("SoDT");
                String email = rs.getString("Email");
                String diaC = rs.getString("DiaChi");
                String phuongT = rs.getString("PhuongThucNhap");
                
                MyPurchase mp = new MyPurchase(idNCC, tenNCC, email, soDT, diaC, phuongT);
                ls.add(mp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ls;
    }
    
    public Boolean checkExists(Integer idPhieu, Integer idSP){
        String sql = "SELECT COUNT(*) FROM ChiTietPhieuNhap WHERE Deleted!=1 AND PhieuNhapID = ? AND MaSanPhamChiTiet = ?";
        
        try (Connection conn = dbConnection.getConnection();
                PreparedStatement ps = conn.prepareCall(sql)){
            ps.setObject(1, idPhieu);
            ps.setObject(2, idSP);
            
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;     
    }
    
    public Boolean mergeSP(Integer idSP, Integer soL, Integer idPhieu){
        String sql = "UPDATE ChiTietPhieuNhap \n" +
                    "SET SoLuong = ? \n" +
                    "WHERE Deleted!=1 AND MaSanPhamChiTiet = ? AND PhieuNhapID = ?";
        
        try (Connection conn = dbConnection.getConnection();
                PreparedStatement ps = conn.prepareCall(sql)){
            ps.setObject(1, soL);
            ps.setObject(2, idSP);
            ps.setObject(3, idPhieu);

            int check = ps.executeUpdate();
            if (check > 0) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public Boolean addPhieu(PhieuNhap pn){
        String sql = "INSERT INTO PhieuNhapKho (NhaCungCapID, NhanVienID, ThoiGianNhap, TongDon, Deleted) \n" +
"			VALUES (?, ?, ?, ?, 0) ;";
        
        try (Connection conn = dbConnection.getConnection(); PreparedStatement ps = conn.prepareCall(sql)) {
            ps.setInt(1, pn.getIdNCC());
            ps.setInt(2, pn.getIdNV());

            java.sql.Date sqlDate = new java.sql.Date(pn.getNgayN().getTime());
            ps.setDate(3, sqlDate);
            
            ps.setDouble(4, pn.getTongD());

            int check = ps.executeUpdate();
            if (check > 0) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public Boolean addPNCT(PhieuNhapChiTiet pn){
        String sql = "INSERT INTO ChiTietPhieuNhap (PhieuNhapID, MaSanPhamChiTiet, SoLuong, DonGia, PhuongThucNhap, MoTa, PhanTramThue, Deleted) VALUES\n" +
"			(?, ?, ?, ?, ?, ?, ?, 0);";
        try (Connection conn = dbConnection.getConnection();
                PreparedStatement ps = conn.prepareCall(sql)){
            ps.setInt(1, pn.getMaP());
            ps.setInt(2, pn.getMaSPCT());
            ps.setInt(3, pn.getSoL());
            ps.setDouble(4, pn.getDonG());
            ps.setString(5, pn.getPhuongThuc());
            ps.setString(6, pn.getMoTa());
            ps.setObject(7, pn.getThue());
            
            int check = ps.executeUpdate();
            if (check>0) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public Boolean updateSP(int soL, int id) {
        String sql = " UPDATE SanPhamChiTiet SET SoLuongTon = ?"
                + "WHERE MaSanPhamChiTiet =?";

        try (Connection conn = dbConnection.getConnection();
                PreparedStatement ps = conn.prepareCall(sql)) {
            ps.setObject(1, soL);
            ps.setObject(2, id);

            int check = ps.executeUpdate();
            if (check > 0) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public PhieuNhapChiTiet getTaxById(Integer idP){
        String sql = "SELECT SUM((pn.DonGia * pn.SoLuong) * (CAST(pn.PhanTramThue AS FLOAT) / 100.0)) AS 'TaxTotal'\n" +
"			FROM ChiTietPhieuNhap pn INNER JOIN PhieuNhapKho pnk ON pn.PhieuNhapID = pnk.PhieuNhapID\n" +
"                           WHERE pnk.PhieuNhapID = ?";
        PhieuNhapChiTiet pn = new PhieuNhapChiTiet();
        
        try (Connection conn = dbConnection.getConnection();
                PreparedStatement ps = conn.prepareCall(sql)){
            ps.setObject(1, idP);
            
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                
                pn = new PhieuNhapChiTiet(rs.getInt(1));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pn;
    }
    
    public PhieuNhap getTotalByID(Integer idP){
        String sql = "SELECT SUM(pn.DonGia * pn.SoLuong + (pn.DonGia * pn.SoLuong) * (CAST(pn.PhanTramThue AS FLOAT) / 100.0)) AS 'TOTAL'\n" +
"				FROM ChiTietPhieuNhap pn INNER JOIN PhieuNhapKho pnk ON pn.PhieuNhapID = pnk.PhieuNhapID\n" +
"						      WHERE pnk.PhieuNhapID = ?";
        PhieuNhap pn = new PhieuNhap();
        
        try (Connection conn = dbConnection.getConnection();
                PreparedStatement ps = conn.prepareCall(sql)){
            ps.setObject(1, idP);
            
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                
                pn = new PhieuNhap(rs.getDouble(1));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pn;
    }
    
    public Boolean updateSPDetails(PhieuNhapChiTiet pn) {
        String sql = "UPDATE ChiTietPhieuNhap\n" +
"				SET SoLuong = ?, DonGia = ?, PhanTramThue = ?, PhuongThucNhap = ?, MoTa = ? \n" +
"					WHERE Deleted!=1 AND MaSanPhamChiTiet = ? AND PhieuNhapID = ?";
        try (Connection conn = dbConnection.getConnection();
                PreparedStatement ps = conn.prepareCall(sql) ){
            ps.setObject(1, pn.getSoL());
            ps.setObject(2, pn.getDonG());
            ps.setObject(3, pn.getThue());
            ps.setObject(4, pn.getPhuongThuc());
            ps.setObject(5, pn.getMoTa());
            ps.setObject(6, pn.getMaSPCT());
            ps.setObject(7, pn.getMaP());
            
            int check = ps.executeUpdate();
            if (check>0) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public Boolean deleteSP(Integer idSP, Integer idP){
        String sql = "DELETE FROM ChiTietPhieuNhap WHERE MaSanPhamChiTiet = ? AND PhieuNhapID = ?";
        
        try (Connection conn = dbConnection.getConnection();
                PreparedStatement ps = conn.prepareCall(sql)){
            ps.setObject(1, idSP);
            ps.setObject(2, idP);
            
            int check = ps.executeUpdate();
            if (check>0) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
   
    //GETLIST
    public PhieuNhap getModel(){
        String sql = "SELECT TOP 1 * FROM PhieuNhapKho ORDER BY PhieuNhapID DESC;";
        PhieuNhap pn = new PhieuNhap();
        
        try (Connection conn = dbConnection.getConnection();
                PreparedStatement ps = conn.prepareCall(sql)){
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                
                Integer id = rs.getInt("PhieuNhapID");
                Integer idNCC = rs.getInt("NhaCungCapID");
                Integer idNV = rs.getInt("NhanVienID");
                Date ngayL = rs.getDate("ThoiGianNhap");
                Double tongD = rs.getDouble("TongDon");
                
                pn = new PhieuNhap(id, idNCC, idNV, ngayL, tongD);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pn;
    }
    
    public ArrayList<PN_PhieuNhapViewModel> getListPhieuById(Integer id){
        String sql = "SELECT pn.PhieuNhapID, spct.MaSanPhamChiTiet, spct.TenSanPhamChiTiet, dm.TenDanhMuc\n" +
"				, pn.DonGia, pn.SoLuong, pn.PhanTramThue\n" +
"				, pn.DonGia * pn.SoLuong + (pn.DonGia * pn.SoLuong) * (CAST(pn.PhanTramThue AS FLOAT) / 100.0) AS 'TOTAL' FROM ChiTietPhieuNhap pn \n" +
"				INNER JOIN SanPhamChiTiet spct ON pn.MaSanPhamChiTiet = spct.MaSanPhamChiTiet\n" +
"				INNER JOIN SanPham sp ON spct.MaSanPham = sp.MaSanPham\n" +
"				INNER JOIN DanhMuc dm ON sp.MaDanhMuc = dm.MaDanhMuc\n" +
"				INNER JOIN PhieuNhapKho pnk ON pn.PhieuNhapID = pnk.PhieuNhapID\n" +
"						WHERE pnk.Deleted!=1 AND pnk.PhieuNhapID = ?";
        ArrayList<PN_PhieuNhapViewModel> ls = new ArrayList<>();
        
        try (Connection conn = dbConnection.getConnection();
                PreparedStatement ps = conn.prepareCall(sql)){
            ps.setObject(1, id);
            
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                
                Integer idP = rs.getInt("PhieuNhapID");
                Integer idSP = rs.getInt("MaSanPhamChiTiet");
                String tenSP = rs.getString("TenSanPhamChiTiet");
                String tenDM = rs.getString("TenDanhMuc");
                Double donG = rs.getDouble("DonGia");
                Integer soL = rs.getInt("SoLuong");
                Integer thue = rs.getInt("PhanTramThue");
                Double tongD = rs.getDouble("TOTAL");
                
                PN_PhieuNhapViewModel pn = new PN_PhieuNhapViewModel(idP, idSP, soL, thue, tenSP, tenDM, donG, tongD);
                ls.add(pn);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ls;
    } 
    
    public PN_PhieuNhapViewModel getDataToLoad(Integer id, Integer idPhieu){
        String sql = "SELECT pn.PhieuNhapID, spct.MaSanPhamChiTiet, spct.TenSanPhamChiTiet, dm.TenDanhMuc\n" +
"				, pn.DonGia, pn.SoLuong, pn.PhanTramThue\n" +
"				, pn.DonGia * pn.SoLuong + (pn.DonGia * pn.SoLuong) * (CAST(pn.PhanTramThue AS FLOAT) / 100.0) AS 'TOTAL' FROM ChiTietPhieuNhap pn \n" +
"				INNER JOIN SanPhamChiTiet spct ON pn.MaSanPhamChiTiet = spct.MaSanPhamChiTiet\n" +
"				INNER JOIN SanPham sp ON spct.MaSanPham = sp.MaSanPham\n" +
"				INNER JOIN DanhMuc dm ON sp.MaDanhMuc = dm.MaDanhMuc\n" +
"				INNER JOIN PhieuNhapKho pnk ON pn.PhieuNhapID = pnk.PhieuNhapID\n" +
"						WHERE pnk.Deleted!=1 "
                + "                                         AND spct.MaSanPhamChiTiet = ?  AND pnk.PhieuNhapID = ?";
        PN_PhieuNhapViewModel pn= new PN_PhieuNhapViewModel();
        
        try (Connection conn = dbConnection.getConnection();
                PreparedStatement ps = conn.prepareCall(sql)){
            ps.setObject(1, id);
            ps.setObject(2, idPhieu);
            
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                
                Integer idP = rs.getInt("PhieuNhapID");
                Integer idSP = rs.getInt("MaSanPhamChiTiet");
                String tenSP = rs.getString("TenSanPhamChiTiet");
                String tenDM = rs.getString("TenDanhMuc");
                Double donG = rs.getDouble("DonGia");
                Integer soL = rs.getInt("SoLuong");
                Integer thue = rs.getInt("PhanTramThue");
                Double tongD = rs.getDouble("TOTAL");
                
                pn = new PN_PhieuNhapViewModel(idP, idSP, soL, thue, tenSP, tenDM, donG, tongD);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pn;
    } 
    
    public ArrayList<PhieuNhapViewModel> getListPN(){
        String sql = "SELECT pn.PhieuNhapID, ncc.TenNhaCungCap, nv.TenNhanVien, pn.ThoiGianNhap, pn.TongDon \n" +
"			FROM PhieuNhapKho pn INNER JOIN NhaCungCap ncc ON pn.NhaCungCapID = ncc.NhaCungCapID\n" +
"								INNER JOIN NhanVien nv ON pn.NhanVienID = nv.MaNhanVien\n" +
"									WHERE pn.Deleted!=1";
        ArrayList<PhieuNhapViewModel> ls = new ArrayList<>();
        
        try (Connection conn = dbConnection.getConnection();
                PreparedStatement ps = conn.prepareCall(sql)){
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                
                Integer maP = rs.getInt("PhieuNhapID");
                String tenNCC = rs.getString("TenNhaCungCap");
                String tenNV = rs.getString("TenNhanVien");
                Date ngayL = rs.getDate("ThoiGianNhap");
                Double total = rs.getDouble("TongDon");
                
                PhieuNhapViewModel pn = new PhieuNhapViewModel(maP, tenNCC, tenNV, ngayL, total);
                ls.add(pn);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ls;
    }
    
    public ArrayList<PhieuNhapChiTiet> getListPNCT(){
        String sql = "SELECT * FROM ChiTietPhieuNhap WHERE Deleted !=1";
        ArrayList<PhieuNhapChiTiet> ls = new ArrayList<>();
        
        try (Connection conn = dbConnection.getConnection();
                PreparedStatement ps = conn.prepareCall(sql)){
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {            
                Integer maP = rs.getInt("PhieuNhapID");
                Integer maSPCT = rs.getInt("MaSanPhamChiTiet");
                Integer soL = rs.getInt("SoLuong");
                Double donG = rs.getDouble("DonGia");
                String phuongT = rs.getString("PhuongThucNhap");
                String moTa = rs.getString("MoTa");
                Integer thue = rs.getInt("PhanTramThue");
                
                PhieuNhapChiTiet pn = new PhieuNhapChiTiet(maP, maSPCT, soL, thue, donG, phuongT, moTa);
                ls.add(pn);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ls;
    }
    
    public ArrayList<PN_SanPhamViewModel> getListSPViewModel(){
        String sql = "SELECT * FROM SanPhamChiTiet WHERE Deleted!=1 ";
        ArrayList<PN_SanPhamViewModel> ls = new ArrayList<>();
        
        try (Connection conn = dbConnection.getConnection();
                PreparedStatement ps = conn.prepareCall(sql)){
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                
                Integer maSPCT = rs.getInt("MaSanPhamChiTiet");
                String tenSP = rs.getString("TenSanPhamChiTiet");
                Integer soL = rs.getInt("SoLuongTon");
                
                PN_SanPhamViewModel sp = new PN_SanPhamViewModel(maSPCT, soL, tenSP);
                ls.add(sp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ls;
    }
    
    public PhieuNhapChiTiet checkPN(Integer idSP, Integer idP){
        String sql = "SELECT * FROM ChiTietPhieuNhap WHERE Deleted !=1 "
                + "AND MaSanPhamChiTiet = ? AND PhieuNhapID = ?";
        PhieuNhapChiTiet pn = new PhieuNhapChiTiet();
        
        try (Connection conn = dbConnection.getConnection();
                PreparedStatement ps = conn.prepareCall(sql)){
            ps.setObject(1, idSP);
            ps.setObject(2, idP);
            
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {            
                Integer maP = rs.getInt("PhieuNhapID");
                Integer maSPCT = rs.getInt("MaSanPhamChiTiet");
                Integer soL = rs.getInt("SoLuong");
                Double donG = rs.getDouble("DonGia");
                String phuongT = rs.getString("PhuongThucNhap");
                String moTa = rs.getString("MoTa");
                Integer thue = rs.getInt("PhanTramThue");
                
                pn = new PhieuNhapChiTiet(maP, maSPCT, soL, thue, donG, phuongT, moTa);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pn;
    }

}
