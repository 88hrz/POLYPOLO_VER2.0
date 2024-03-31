/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories;

import Models.SP_KichCo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author X1
 */
public class SP_KichCoRepo {
    DbConnection dbConnection;
    
    public ArrayList<SP_KichCo> getList(){
        String sql = "SELECT * FROM Size WHERE Deleted!=1";
        ArrayList<SP_KichCo> ls = new ArrayList<>();
        
        try (Connection conn = dbConnection.getConnection();
                PreparedStatement ps = conn.prepareCall(sql)){
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                
                Integer idSz = rs.getInt("MaSize");
                String tenSz = rs.getString("TenSize");
                
                SP_KichCo sz = new SP_KichCo(idSz, tenSz);
                ls.add(sz);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ls;
    }
    
    public SP_KichCo getIdByName(String name){
        String sql = "SELECT * FROM Size WHERE Deleted!=1 AND TenSize = ?";
        SP_KichCo sz = new SP_KichCo();
        
        try (Connection conn = dbConnection.getConnection();
                PreparedStatement ps = conn.prepareCall(sql)){
            ps.setObject(1, name);
            
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                
                Integer idSz = rs.getInt("MaSize");
                String tenSz = rs.getString("TenSize");
                
                sz = new SP_KichCo(idSz, tenSz);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sz;
    }
    
    //CHECK ID
    public boolean checkIdSz(Integer id) {
        String sql = "SELECT COUNT(*) FROM Size WHERE Deleted!=1 AND MaSize = ?";
        
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
    public Boolean addSz(SP_KichCo sz) {
        String sql = "INSERT INTO Size (TenSize,Deleted) VALUES (?,0)";

        try (Connection conn = dbConnection.getConnection();
                PreparedStatement ps = conn.prepareCall(sql)) {
            ps.setObject(1, sz.getTenSz());

            int check = ps.executeUpdate();
            if (check > 0) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    public Boolean updateSize(SP_KichCo sz) {
        String sql = "UPDATE Size SET TenSize = ? WHERE Deleted != 1 AND MaSize = ?";

        try (Connection conn = dbConnection.getConnection();
                PreparedStatement ps = conn.prepareCall(sql)) {
            ps.setObject(1, sz.getTenSz());
            ps.setObject(2, sz.getIdSz());

            int check = ps.executeUpdate();
            if (check > 0) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    public Boolean hideSize(SP_KichCo sz) {
        String sql = "UPDATE Size SET Deleted = 1 WHERE MaSize = ?";

        try (Connection conn = dbConnection.getConnection();
                PreparedStatement ps = conn.prepareCall(sql)) {
            ps.setObject(1, sz.getIdSz());

            int check = ps.executeUpdate();
            if (check > 0) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    public Boolean unhideSize(SP_KichCo sz) {
        String sql = "UPDATE Size SET Deleted = 0 WHERE MaSize = ?";

        try (Connection conn = dbConnection.getConnection();
                PreparedStatement ps = conn.prepareCall(sql)) {
            ps.setObject(1, sz.getIdSz());

            int check = ps.executeUpdate();
            if (check > 0) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    public ArrayList<SP_KichCo> getListHide(){
        String sql = "SELECT * FROM Size WHERE Deleted = 1";
        ArrayList<SP_KichCo> ls = new ArrayList<>();
        
        try (Connection conn = dbConnection.getConnection();
                PreparedStatement ps = conn.prepareCall(sql)){
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                
                Integer idSz = rs.getInt("MaSize");
                String tenSz = rs.getString("TenSize");
                
                SP_KichCo dm = new SP_KichCo(idSz, tenSz);
                ls.add(dm);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ls;
    }
}
