/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories;

import Models.SP_NhanHang;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author X1
 */
public class SP_NhanHangRepo {
    DbConnection dbConnection;
    
    public ArrayList<SP_NhanHang> getList(){
        String sql = "SELECT * FROM NhanHang WHERE Deleted!=1";
        ArrayList<SP_NhanHang> ls = new ArrayList<>();
        
        try (Connection conn = dbConnection.getConnection();
                PreparedStatement ps = conn.prepareCall(sql)){
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                
                Integer idB = rs.getInt("NhanHangID");
                String bN = rs.getString("TenNhanHang");
                
                SP_NhanHang nh = new SP_NhanHang(idB, bN);
                ls.add(nh);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ls;
    }
    
    public SP_NhanHang getIdByName(String name){
        String sql = "SELECT * FROM NhanHang WHERE Deleted!=1 AND TenNhanHang = ?";
        SP_NhanHang nh = new SP_NhanHang();
        
        try (Connection conn = dbConnection.getConnection();
                PreparedStatement ps = conn.prepareCall(sql)){
            ps.setObject(1, name);
            
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                
                Integer idB = rs.getInt("NhanHangID");
                String bN = rs.getString("TenNhanHang");
                
                nh = new SP_NhanHang(idB, bN);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return nh;
    }
    
    //CHECK ID
    public boolean checkIdBrand(Integer id) {
        String sql = "SELECT COUNT(*) FROM Size WHERE Deleted!=1 AND NhanHangID = ?";
        
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
    
    //CRUD
    public Boolean addBrand(SP_NhanHang brand) {
        String sql = "INSERT INTO NhanHang (TenNhanHang, Deleted) VALUES (?, 0)";

        try (Connection conn = dbConnection.getConnection();
                PreparedStatement ps = conn.prepareCall(sql)) {
            ps.setObject(1, brand.getBrandName());

            int check = ps.executeUpdate();
            if (check > 0) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    public Boolean updateBrand(SP_NhanHang brand) {
        String sql = "UPDATE NhanHang SET TenNhanHang = ? WHERE Deleted != 1 AND NhanHangID = ?";

        try (Connection conn = dbConnection.getConnection();
                PreparedStatement ps = conn.prepareCall(sql)) {
            ps.setObject(1, brand.getBrandName());
            ps.setObject(2, brand.getIdBrand());

            int check = ps.executeUpdate();
            if (check > 0) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    public Boolean hideBrand(SP_NhanHang brand) {
        String sql = "UPDATE NhanHang SET Deleted = 1 WHERE NhanHangID = ?";

        try (Connection conn = dbConnection.getConnection();
                PreparedStatement ps = conn.prepareCall(sql)) {
            ps.setObject(1, brand.getIdBrand());

            int check = ps.executeUpdate();
            if (check > 0) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    public Boolean unhideBrand(SP_NhanHang brand) {
        String sql = "UPDATE NhanHang SET Deleted = 0 WHERE NhanHangID = ?";

        try (Connection conn = dbConnection.getConnection();
                PreparedStatement ps = conn.prepareCall(sql)) {
            ps.setObject(1, brand.getIdBrand());

            int check = ps.executeUpdate();
            if (check > 0) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    public ArrayList<SP_NhanHang> getListHide(){
        String sql = "SELECT * FROM NhanHang WHERE Deleted = 1";
        ArrayList<SP_NhanHang> ls = new ArrayList<>();
        
        try (Connection conn = dbConnection.getConnection();
                PreparedStatement ps = conn.prepareCall(sql)){
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                
                Integer idB = rs.getInt("NhanHangID");
                String bN = rs.getString("TenNhanHang");
                
                SP_NhanHang nh = new SP_NhanHang(idB, bN);
                ls.add(nh);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ls;
    }
}
