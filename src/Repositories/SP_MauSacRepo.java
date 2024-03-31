/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories;

import Models.SP_MauSac;
import java.util.ArrayList;
import java.sql.*;

/**
 *
 * @author X1
 */
public class SP_MauSacRepo {
    DbConnection dbConnection;
    
    public ArrayList<SP_MauSac> getList(){
        String sql = "SELECT * FROM MauSac WHERE Deleted!=1";
        ArrayList<SP_MauSac> ls = new ArrayList<>();
        
        try (Connection conn = dbConnection.getConnection();
                PreparedStatement ps = conn.prepareCall(sql)){
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                
                Integer idMau = rs.getInt("MaMau");
                String tenMau = rs.getString("TenMau");
                
                SP_MauSac ms = new SP_MauSac(idMau, tenMau);
                ls.add(ms);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ls;
    }
    
    public SP_MauSac getIdByName(String name){
        String sql = "SELECT * FROM MauSac WHERE Deleted!=1 AND TenMau = ?";
        SP_MauSac ms = new SP_MauSac();
        
        try (Connection conn = dbConnection.getConnection();
                PreparedStatement ps = conn.prepareCall(sql)){
            ps.setObject(1, name);
            
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                
                Integer idMau = rs.getInt("MaMau");
                String tenMau = rs.getString("TenMau");
                
                ms = new SP_MauSac(idMau, tenMau);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ms;
    }
    
    //CHECK ID
    public boolean checkIdColor(Integer id) {
        String sql = "SELECT COUNT(*) FROM MauSac WHERE Deleted!=1 AND MaMau = ?";
        
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
    public Boolean addColor(SP_MauSac color) {
        String sql = "INSERT INTO MauSac (TenMau,Deleted) VALUES (?,0)";

        try (Connection conn = dbConnection.getConnection();
                PreparedStatement ps = conn.prepareCall(sql)) {
            ps.setObject(1, color);

            int check = ps.executeUpdate();
            if (check > 0) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    public Boolean updateMauSac(SP_MauSac color) {
        String sql = "UPDATE MauSac SET TenMau = ? WHERE Deleted != 1 AND MaMau = ?";

        try (Connection conn = dbConnection.getConnection();
                PreparedStatement ps = conn.prepareCall(sql)) {
            ps.setObject(1, color.getTenMau());
            ps.setObject(2, color.getIdMau());

            int check = ps.executeUpdate();
            if (check > 0) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    public Boolean hideMauSac(SP_MauSac color) {
        String sql = "UPDATE MauSac SET Deleted = 1 WHERE MaMau = ?";

        try (Connection conn = dbConnection.getConnection();
                PreparedStatement ps = conn.prepareCall(sql)) {
            ps.setObject(1, color.getIdMau());

            int check = ps.executeUpdate();
            if (check > 0) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    public Boolean unhideMauSac(SP_MauSac color) {
        String sql = "UPDATE MauSac SET Deleted = 0 WHERE MaMau = ?";

        try (Connection conn = dbConnection.getConnection();
                PreparedStatement ps = conn.prepareCall(sql)) {
            ps.setObject(1, color.getIdMau());

            int check = ps.executeUpdate();
            if (check > 0) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    public ArrayList<SP_MauSac> getListHide(){
        String sql = "SELECT * FROM MauSac WHERE Deleted = 1";
        ArrayList<SP_MauSac> ls = new ArrayList<>();
        
        try (Connection conn = dbConnection.getConnection();
                PreparedStatement ps = conn.prepareCall(sql)){
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                
                Integer idB = rs.getInt("MaMau");
                String tenM = rs.getString("TenMau");
                
                SP_MauSac dm = new SP_MauSac(idB, tenM);
                ls.add(dm);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ls;
    }
}
