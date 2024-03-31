/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories;

import Models.SanPham;
import ViewModels.SanPhamViewModel;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author X1
 */
public class SanPhamRepository {
    DbConnection dbConnection;
    
    //GETLIST
    public ArrayList<SanPham> getListSP(){
        String sql = "SELECT * FROM SanPham WHERE Deleted!=1";
        ArrayList<SanPham> ls = new ArrayList<>();
        
        try (Connection conn = dbConnection.getConnection();
                PreparedStatement ps = conn.prepareCall(sql)){
            ResultSet rs = ps.executeQuery();
            while (rs.next()) { 
                Integer maSP = rs.getInt("MaSanPham");
                Integer maDM = rs.getInt("MaDanhMuc");
                String trangThai = rs.getString("TrangThai");
                Double giaB = rs.getDouble("GiaNhap");
                Double giaN = rs.getDouble("GiaBan");
                Integer khoId = rs.getInt("KhuVucID");
                
                SanPham sp = new SanPham(maSP, maDM, khoId, trangThai, giaN, giaB);
                ls.add(sp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ls;
    }
    
    public ArrayList<SanPhamViewModel> getListSPVM(){
        String sql = "SELECT sp.MaSanPham, spct.TenSanPhamChiTiet, dm.TenDanhMuc, nh.TenNhanHang, ms.TenMau, sz.TenSize, cl.TenChatLieu\n" +
"			, sp.GiaNhap, sp.GiaBan, sp.TrangThai, spct.SoLuongTon, kh.TenKhuVuc FROM SanPham sp \n" +
"										INNER JOIN SanPhamChiTiet spct ON sp.MaSanPham = spct.MaSanPham\n" +
"										INNER JOIN DanhMuc dm ON sp.MaDanhMuc = dm.MaDanhMuc\n" +
"										INNER JOIN NhanHang nh ON spct.NhanHangID = nh.NhanHangID\n" +
"										INNER JOIN MauSac ms ON spct.MaMau = ms.MaMau\n" +
"										INNER JOIN Size sz ON spct.MaSize = sz.MaSize\n" +
"										INNER JOIN ChatLieu cl ON spct.MaChatLieu = cl.MaChatLieu\n" +
"										INNER JOIN KhuVucKho kh ON sp.KhuVucID = kh.KhuVucID"
                + "                                                                     WHERE sp.Deleted != 1";
        ArrayList<SanPhamViewModel> ls = new ArrayList<>();
        
        try (Connection conn = dbConnection.getConnection();
                PreparedStatement ps = conn.prepareCall(sql)){
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                
                Integer idSP = rs.getInt("MaSanPham");
                String tenSP = rs.getString("TenSanPhamChiTiet");
                String danhM = rs.getString("TenDanhMuc");
                String brand = rs.getString("TenNhanHang");
                String color = rs.getString("TenMau");
                String sz = rs.getString("TenSize");
                String material = rs.getString("TenChatLieu");
                Double giaN = rs.getDouble("GiaNhap");
                Double giaB = rs.getDouble("GiaBan");
                String status = rs.getString("TrangThai");
                Integer soL = rs.getInt("SoLuongTon");
                String area = rs.getString("TenKhuVuc");
                
                SanPhamViewModel sp = new SanPhamViewModel(idSP, soL, tenSP, danhM, brand, color, sz, material, status, area, giaN, giaB);
                ls.add(sp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ls;
    }
    
    public ArrayList<SanPhamViewModel> getListViewModelById(Integer id) {
        String sql = "SELECT sp.MaSanPham, spct.TenSanPhamChiTiet, dm.TenDanhMuc, nh.TenNhanHang, ms.TenMau, sz.TenSize, cl.TenChatLieu\n"
                + "			, sp.GiaNhap, sp.GiaBan, sp.TrangThai, spct.SoLuongTon, kh.TenKhuVuc\n"
                + "							,spct.HinhAnh, spct.NgayNhapKho FROM SanPham sp \n"
                + "										INNER JOIN SanPhamChiTiet spct ON sp.MaSanPham = spct.MaSanPham\n"
                + "										INNER JOIN DanhMuc dm ON sp.MaDanhMuc = dm.MaDanhMuc\n"
                + "										INNER JOIN NhanHang nh ON spct.NhanHangID = nh.NhanHangID\n"
                + "										INNER JOIN MauSac ms ON spct.MaMau = ms.MaMau\n"
                + "										INNER JOIN Size sz ON spct.MaSize = sz.MaSize\n"
                + "										INNER JOIN ChatLieu cl ON spct.MaChatLieu = cl.MaChatLieu\n"
                + "										INNER JOIN KhuVucKho kh ON sp.KhuVucID = kh.KhuVucID\n"
                + "											WHERE sp.Deleted!=1 AND sp.MaSanPham = ?";
        ArrayList<SanPhamViewModel> ls = new ArrayList<>();

        try (Connection conn = dbConnection.getConnection(); 
                PreparedStatement ps = conn.prepareCall(sql)) {
            ps.setObject(1, id);
            
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Integer idSP = rs.getInt("MaSanPham");
                String tenSP = rs.getString("TenSanPhamChiTiet");
                String danhM = rs.getString("TenDanhMuc");
                String brand = rs.getString("TenNhanHang");
                String color = rs.getString("TenMau");
                String sz = rs.getString("TenSize");
                String material = rs.getString("TenChatLieu");
                Double giaN = rs.getDouble("GiaNhap");
                Double giaB = rs.getDouble("GiaBan");
                String status = rs.getString("TrangThai");
                Integer soL = rs.getInt("SoLuongTon");
                String area = rs.getString("TenKhuVuc");
                String img = rs.getString("HinhAnh");
                Date ngayN = rs.getDate("NgayNhapKho");

                SanPhamViewModel sp = new SanPhamViewModel(idSP, soL, tenSP, danhM, brand, color, sz, material, status, area, giaN, giaB, img, ngayN);
                ls.add(sp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ls;
    }
    
    public SanPhamViewModel getListViewModelByIdSP(Integer id) {
        String sql = "SELECT sp.MaSanPham, spct.TenSanPhamChiTiet, dm.TenDanhMuc, nh.TenNhanHang, ms.TenMau, sz.TenSize, cl.TenChatLieu\n"
                + "			, sp.GiaNhap, sp.GiaBan, sp.TrangThai, spct.SoLuongTon, kh.TenKhuVuc\n"
                + "							,spct.HinhAnh, spct.NgayNhapKho FROM SanPham sp \n"
                + "										INNER JOIN SanPhamChiTiet spct ON sp.MaSanPham = spct.MaSanPham\n"
                + "										INNER JOIN DanhMuc dm ON sp.MaDanhMuc = dm.MaDanhMuc\n"
                + "										INNER JOIN NhanHang nh ON spct.NhanHangID = nh.NhanHangID\n"
                + "										INNER JOIN MauSac ms ON spct.MaMau = ms.MaMau\n"
                + "										INNER JOIN Size sz ON spct.MaSize = sz.MaSize\n"
                + "										INNER JOIN ChatLieu cl ON spct.MaChatLieu = cl.MaChatLieu\n"
                + "										INNER JOIN KhuVucKho kh ON sp.KhuVucID = kh.KhuVucID\n"
                + "											WHERE sp.Deleted!=1 AND sp.MaSanPham = ?";
        SanPhamViewModel sp = new SanPhamViewModel();

        try (Connection conn = dbConnection.getConnection(); 
                PreparedStatement ps = conn.prepareCall(sql)) {
            ps.setObject(1, id);
            
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Integer idSP = rs.getInt("MaSanPham");
                String tenSP = rs.getString("TenSanPhamChiTiet");
                String danhM = rs.getString("TenDanhMuc");
                String brand = rs.getString("TenNhanHang");
                String color = rs.getString("TenMau");
                String sz = rs.getString("TenSize");
                String material = rs.getString("TenChatLieu");
                Double giaN = rs.getDouble("GiaNhap");
                Double giaB = rs.getDouble("GiaBan");
                String status = rs.getString("TrangThai");
                Integer soL = rs.getInt("SoLuongTon");
                String area = rs.getString("TenKhuVuc");
                String img = rs.getString("HinhAnh");
                Date ngayN = rs.getDate("NgayNhapKho");

                sp = new SanPhamViewModel(idSP, soL, tenSP, danhM, brand, color, sz, material, status, area, giaN, giaB, img, ngayN);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sp;
    }
    
    //HIDE - UNHIDE
    public Boolean hideSP(SanPham sp){
        String sql = "UPDATE SanPham SET Deleted = 1 WHERE MaSanPham = ?";
        try (Connection conn = dbConnection.getConnection();
                PreparedStatement ps = conn.prepareCall(sql)){
            ps.setObject(1, sp.getMaSP());
            
            int check = ps.executeUpdate();
            if (check>0) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public Boolean unhideSP(SanPham sp){
        String sql = "UPDATE SanPham SET Deleted = 0 WHERE MaSanPham = ?";
        try (Connection conn = dbConnection.getConnection();
                PreparedStatement ps = conn.prepareCall(sql)){
            ps.setObject(1, sp.getMaSP());
            
            int check = ps.executeUpdate();
            if (check>0) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public ArrayList<SanPhamViewModel> getListHide(){
        String sql = "SELECT sp.MaSanPham, spct.TenSanPhamChiTiet, dm.TenDanhMuc, nh.TenNhanHang, ms.TenMau, sz.TenSize, cl.TenChatLieu\n" +
"			, sp.GiaNhap, sp.GiaBan, sp.TrangThai, spct.SoLuongTon, kh.TenKhuVuc FROM SanPham sp \n" +
"										INNER JOIN SanPhamChiTiet spct ON sp.MaSanPham = spct.MaSanPham\n" +
"										INNER JOIN DanhMuc dm ON sp.MaDanhMuc = dm.MaDanhMuc\n" +
"										INNER JOIN NhanHang nh ON spct.NhanHangID = nh.NhanHangID\n" +
"										INNER JOIN MauSac ms ON spct.MaMau = ms.MaMau\n" +
"										INNER JOIN Size sz ON spct.MaSize = sz.MaSize\n" +
"										INNER JOIN ChatLieu cl ON spct.MaChatLieu = cl.MaChatLieu\n" +
"										INNER JOIN KhuVucKho kh ON sp.KhuVucID = kh.KhuVucID\n" +
"													WHERE sp.Deleted != 0;";
        ArrayList<SanPhamViewModel> ls = new ArrayList<>();
        
        try (Connection conn = dbConnection.getConnection();
                PreparedStatement ps = conn.prepareCall(sql)){
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                
                Integer idSP = rs.getInt("MaSanPham");
                String tenSP = rs.getString("TenSanPhamChiTiet");
                String danhM = rs.getString("TenDanhMuc");
                String brand = rs.getString("TenNhanHang");
                String color = rs.getString("TenMau");
                String sz = rs.getString("TenSize");
                String material = rs.getString("TenChatLieu");
                Double giaN = rs.getDouble("GiaNhap");
                Double giaB = rs.getDouble("GiaBan");
                String status = rs.getString("TrangThai");
                Integer soL = rs.getInt("SoLuongTon");
                String area = rs.getString("TenKhuVuc");
                
                SanPhamViewModel sp = new SanPhamViewModel(idSP, soL, tenSP, danhM, brand, color, sz, material, status, area, giaN, giaB);
                ls.add(sp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ls;        
    }
    
    //CHECK ID
    public boolean checkId(Integer id) {
        String sql = "SELECT COUNT(*) FROM SanPhamChiTiet WHERE Deleted!=1 AND MaSanPham = ?";
        
        try (Connection conn = dbConnection.getConnection(); 
                PreparedStatement ps = conn.prepareCall(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1) > 0;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    //CHECK NAME
    public boolean checkName(String name) {
        String sql = "SELECT COUNT(*) FROM SanPhamChiTiet WHERE Deleted!=1 AND TenSanPhamChiTiet = ?";
        
        try (Connection conn = dbConnection.getConnection(); 
                PreparedStatement ps = conn.prepareCall(sql)) {
            ps.setString(1, name);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1) > 0;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    //CRUD
    public Boolean addSP(SanPham sp){
        String sql = "INSERT INTO SanPham(MaDanhMuc, TrangThai, GiaNhap, GiaBan, KhuVucID, Deleted) \n" +
"				VALUES (?, ?, ?, ?, ?, 0);"
                + "INSERT INTO SanPhamChiTiet (MaSanPham, TenSanPhamChiTiet, HinhAnh, MaSize, MaMau, MaChatLieu, TrangThai, SoLuongTon, NgayNhapKho, NhanHangID, Deleted) VALUES \n" +
"							(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, 0);";
        
        try (Connection conn = dbConnection.getConnection();
                PreparedStatement ps =conn.prepareCall(sql)) {
            ps.setInt(1, sp.getMaDM());
            ps.setString(2, sp.getTrangT());
            ps.setDouble(3, sp.getGiaN());
            ps.setDouble(4, sp.getGiaB());
            ps.setInt(5, sp.getMaKho());
            
            ps.setInt(6, sp.getMaSP());
            ps.setString(7, sp.getTenSP());
            ps.setString(8, sp.getImg());
            ps.setInt(9, sp.getMaSz());
            ps.setInt(10, sp.getMaMau());
            ps.setInt(11, sp.getMaChatL());
            ps.setString(12, sp.getTrangT());
            ps.setInt(13, sp.getSoL());
            ps.setInt(15, sp.getMaBrand());
            
            java.util.Date utilDate = sp.getNgayNhap();
            java.sql.Date sqlDate = new java.sql.Date(utilDate.getDate());
            ps.setDate(14, sqlDate);
            
            int check = ps.executeUpdate();
            if (check > 0) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public Boolean updateSP(SanPham sp){
        String sql = "UPDATE SanPhamChiTiet SET TenSanPhamChiTiet = ?, HinhAnh = ?, MaSize = ?, MaMau = ?, MaChatLieu = ?, TrangThai = ?,SoLuongTon = ?\n" +
"						, NgayNhapKho = ?, NhanHangID = ? \n" +
"								WHERE Deleted!=1 AND MaSanPham = ?;\n" +
                    "UPDATE SanPham SET MaDanhMuc = ?, TrangThai = ?, GiaNhap = ?, GiaBan = ?, KhuVucID = ? \n" +
                    "					WHERE Deleted !=1 AND MaSanPham = ?;";
        try (Connection conn = dbConnection.getConnection();
                PreparedStatement ps = conn.prepareCall(sql)){
            
            ps.setObject(1, sp.getTenSP());
            ps.setObject(2, sp.getImg());
            ps.setObject(3, sp.getMaSz());
            ps.setObject(4, sp.getMaMau());
            ps.setObject(5, sp.getMaChatL());
            ps.setObject(6, sp.getTrangT());
            ps.setObject(7, sp.getSoL());
            ps.setObject(8, sp.getNgayNhap());
            ps.setObject(9, sp.getMaBrand());
            ps.setObject(10, sp.getMaSP());
            
            ps.setObject(11, sp.getMaDM());
            ps.setObject(12, sp.getTrangT());
            ps.setObject(13, sp.getGiaN());
            ps.setObject(14, sp.getGiaB());
            ps.setObject(15, sp.getMaKho());
            ps.setObject(16, sp.getMaSP());
            
            int check = ps.executeUpdate();
            if (check>0) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    
}
