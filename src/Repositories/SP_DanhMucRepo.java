/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories;

import Models.SP_DanhMuc;
import java.util.ArrayList;
import java.sql.*;

/**
 *
 * @author X1
 */
public class SP_DanhMucRepo {
    DbConnection dbConnection;
    
    public ArrayList<SP_DanhMuc> getList(){
        String sql = "SELECT * FROM DanhMuc WHERE Deleted!=1";
        ArrayList<SP_DanhMuc> ls = new ArrayList<>();
        
        try (Connection conn = dbConnection.getConnection();
                PreparedStatement ps = conn.prepareCall(sql)){
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                
                Integer idDM = rs.getInt("MaDanhMuc");
                String tenDM = rs.getString("TenDanhMuc");
                String trangT = rs.getString("TrangThai");
                
                SP_DanhMuc dm = new SP_DanhMuc(idDM, tenDM, trangT);
                ls.add(dm);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ls; 
    }
    
    public SP_DanhMuc getIdByName(String name){
        String sql = "SELECT * FROM DanhMuc WHERE Deleted!=1 AND TenDanhMuc = ?";
        SP_DanhMuc dm = new SP_DanhMuc();
        
        try (Connection conn = dbConnection.getConnection();
                PreparedStatement ps = conn.prepareCall(sql)){
            ps.setObject(1, name);
            
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                
                Integer maDM = rs.getInt("MaDanhMuc");
                String tenDM = rs.getString("TenDanhMuc");
                
                dm = new SP_DanhMuc(maDM, tenDM, null);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dm;
    }
    
    //CHECK ID
    public boolean checkIdCat(Integer id) {
        String sql = "SELECT COUNT(*) FROM DanhMuc WHERE Deleted!=1 AND MaDanhMuc = ?";
        
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
    public Boolean addCat(SP_DanhMuc danhMuc) {
        String sql = "INSERT INTO DanhMuc(TenDanhMuc, TrangThai,Deleted) VALUES (?,?,0)";

        try (Connection conn = dbConnection.getConnection();
                PreparedStatement ps = conn.prepareCall(sql)) {
            ps.setObject(1, danhMuc.getTenDM());
            ps.setObject(2, danhMuc.getTrangThai());

            int check = ps.executeUpdate();
            if (check > 0) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    public Boolean updateDanhMuc(SP_DanhMuc danhMuc) {
        String sql = "UPDATE DanhMuc SET TenDanhMuc = ?, TrangThai = ? WHERE Deleted != 1 AND MaDanhMuc = ?";

        try (Connection conn = dbConnection.getConnection();
                PreparedStatement ps = conn.prepareCall(sql)) {
            ps.setObject(1, danhMuc.getTenDM());
            ps.setObject(2, danhMuc.getTrangThai());
            ps.setObject(3, danhMuc.getIdDM());

            int check = ps.executeUpdate();
            if (check > 0) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    public Boolean hideDanhMuc(SP_DanhMuc danhMuc) {
        String sql = "UPDATE DanhMuc SET Deleted = 1 WHERE MaDanhMuc = ?";

        try (Connection conn = dbConnection.getConnection();
                PreparedStatement ps = conn.prepareCall(sql)) {
            ps.setObject(1, danhMuc.getIdDM());

            int check = ps.executeUpdate();
            if (check > 0) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    public Boolean unhideDanhMuc(SP_DanhMuc danhMuc) {
        String sql = "UPDATE DanhMuc SET Deleted = 0 WHERE MaDanhMuc = ?";

        try (Connection conn = dbConnection.getConnection();
                PreparedStatement ps = conn.prepareCall(sql)) {
            ps.setObject(1, danhMuc.getIdDM());

            int check = ps.executeUpdate();
            if (check > 0) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    public ArrayList<SP_DanhMuc> getListHide(){
        String sql = "SELECT * FROM DanhMuc WHERE Deleted = 1";
        ArrayList<SP_DanhMuc> ls = new ArrayList<>();
        
        try (Connection conn = dbConnection.getConnection();
                PreparedStatement ps = conn.prepareCall(sql)){
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                
                Integer idB = rs.getInt("MaDanhMuc");
                String tenDM = rs.getString("TenDanhMuc");
                String trangT = rs.getString("TrangThai");
                
                SP_DanhMuc dm = new SP_DanhMuc(idB, tenDM, trangT);
                ls.add(dm);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ls;
    }
}
