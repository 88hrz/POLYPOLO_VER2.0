/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories;

import Models.SP_ChatLieu;
import java.util.ArrayList;
import java.sql.*;

/**
 *
 * @author X1
 */
public class SP_ChatLieuRepo {
    DbConnection dbConnection;
    
    public ArrayList<SP_ChatLieu> getList(){
        String sql = "SELECT * FROM ChatLieu WHERE Deleted!=1";
        ArrayList<SP_ChatLieu> ls = new ArrayList<>();
        
        try (Connection conn = dbConnection.getConnection();
                PreparedStatement ps = conn.prepareCall(sql)){
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                
                Integer idMat = rs.getInt("MaChatLieu");
                String tenMat = rs.getString("TenChatLieu");
                
                SP_ChatLieu cl = new SP_ChatLieu(idMat, tenMat);
                ls.add(cl);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ls;
    }
    
    public SP_ChatLieu getIdByName(String name){
        String sql = "SELECT * FROM ChatLieu WHERE Deleted!=1 AND TenChatLieu = ?";
        SP_ChatLieu cl = new SP_ChatLieu();
        
        try (Connection conn = dbConnection.getConnection();
                PreparedStatement ps = conn.prepareCall(sql)){
            ps.setObject(1, name);
            
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                
                Integer idMat = rs.getInt("MaChatLieu");
                String tenMat = rs.getString("TenChatLieu");
                
                cl = new SP_ChatLieu(idMat, tenMat);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cl;
    }
    
    //CHECK ID
    public boolean checkIdChatL(Integer id) {
        String sql = "SELECT COUNT(*) FROM Size WHERE Deleted!=1 AND MaChatLieu = ?";
        
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
    public Boolean addMaterial(SP_ChatLieu material) {
        String sql = "INSERT INTO ChatLieu (TenChatLieu, Deleted) VALUES (?,0)";

        try (Connection conn = dbConnection.getConnection();
                PreparedStatement ps = conn.prepareCall(sql)) {
            ps.setObject(1, material);

            int check = ps.executeUpdate();
            if (check > 0) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    public Boolean updateMaterial(SP_ChatLieu material) {
        String sql = "UPDATE ChatLieu SET TenChatLieu = ? WHERE Deleted != 1 AND MaChatLieu = ?";

        try (Connection conn = dbConnection.getConnection();
                PreparedStatement ps = conn.prepareCall(sql)) {
            ps.setObject(1, material.getTenChatL());

            int check = ps.executeUpdate();
            if (check > 0) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    public Boolean hideMaterial(SP_ChatLieu material) {
        String sql = "UPDATE ChatLieu SET Deleted = 1 WHERE MaChatLieu = ?";

        try (Connection conn = dbConnection.getConnection();
                PreparedStatement ps = conn.prepareCall(sql)) {
            ps.setObject(1, material.getIdChatL());

            int check = ps.executeUpdate();
            if (check > 0) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    public Boolean unhideMaterial(SP_ChatLieu material) {
        String sql = "UPDATE ChatLieu SET Deleted = 0 WHERE MaChatLieu = ?";

        try (Connection conn = dbConnection.getConnection();
                PreparedStatement ps = conn.prepareCall(sql)) {
            ps.setObject(1, material.getIdChatL());

            int check = ps.executeUpdate();
            if (check > 0) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    public ArrayList<SP_ChatLieu> getListHide(){
        String sql = "SELECT * FROM ChatLieu WHERE Deleted = 1";
        ArrayList<SP_ChatLieu> ls = new ArrayList<>();
        
        try (Connection conn = dbConnection.getConnection();
                PreparedStatement ps = conn.prepareCall(sql)){
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                
                Integer idB = rs.getInt("MaChatLieu");
                String bN = rs.getString("TenChatLieu");
                
                SP_ChatLieu nh = new SP_ChatLieu(idB, bN);
                ls.add(nh);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ls;
    }
}
