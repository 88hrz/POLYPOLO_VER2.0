/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories;

import ViewModels.SanPhamViewModel;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author X1
 */
public class SanPhamRepository {
    DbConnection dbConnection;
    
    public ArrayList<SanPhamViewModel> getListSPVM(){
        String sql = "SELECT sp.MaSanPham, spct.TenSanPhamChiTiet, dm.TenDanhMuc, nh.TenNhanHang, ms.TenMau, sz.TenSize, cl.TenChatLieu\n" +
"			, sp.GiaNhap, sp.GiaBan, sp.TrangThai, spct.SoLuongTon, kh.TenKhuVuc FROM SanPham sp \n" +
"										INNER JOIN SanPhamChiTiet spct ON sp.MaSanPham = spct.MaSanPham\n" +
"										INNER JOIN DanhMuc dm ON sp.MaDanhMuc = dm.MaDanhMuc\n" +
"										INNER JOIN NhanHang nh ON spct.NhanHangID = nh.NhanHangID\n" +
"										INNER JOIN MauSac ms ON spct.MaMau = ms.MaMau\n" +
"										INNER JOIN Size sz ON spct.MaSize = sz.MaSize\n" +
"										INNER JOIN ChatLieu cl ON spct.MaChatLieu = cl.MaChatLieu\n" +
"										INNER JOIN KhuVucKho kh ON sp.KhuVucID = kh.KhuVucID";
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
    
}
