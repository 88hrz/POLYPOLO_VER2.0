/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories;

import Models.KhoHang;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author X1
 */
public class KhoHangRepo {
    DbConnection dbConnection;
    
    public ArrayList<KhoHang> getList(){
        String sql = "SELECT * FROM KhuVucKho WHERE Deleted!=1";
        ArrayList<KhoHang> ls = new ArrayList<>();
        
        try (Connection conn = dbConnection.getConnection();
                PreparedStatement ps = conn.prepareCall(sql)){
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                
                Integer idKhuVuc = rs.getInt("KhuVucID");
                String tenKho = rs.getString("TenKhuVuc");
                
                KhoHang kh= new KhoHang(idKhuVuc, tenKho);
                ls.add(kh);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ls;
    }
    
    public KhoHang getIdByName(String name){
        String sql = "SELECT * FROM KhuVucKho WHERE Deleted!=1 AND TenKhuVuc = ?";
        KhoHang kh = new KhoHang();
        
        try (Connection conn = dbConnection.getConnection();
                PreparedStatement ps = conn.prepareCall(sql)){
            ps.setObject(1, name);
            
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                
                Integer idKhuVuc = rs.getInt("KhuVucID");
                String tenKho = rs.getString("TenKhuVuc");
                
                kh = new KhoHang(idKhuVuc, tenKho);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return kh;
    }
    
    //CHECK ID
    public boolean checkIdKho(Integer id) {
        String sql = "SELECT COUNT(*) FROM Size WHERE Deleted!=1 AND KhuVucID = ?";
        
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
}
