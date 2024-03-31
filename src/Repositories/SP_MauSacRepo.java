/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories;

import Models.MauSac;
import java.util.ArrayList;
import java.sql.*;

/**
 *
 * @author X1
 */
public class SP_MauSacRepo {
    DbConnection dbConnection;
    
    public ArrayList<MauSac> getList(){
        String sql = "SELECT * FROM MauSac WHERE Deleted!=1";
        ArrayList<MauSac> ls = new ArrayList<>();
        
        try (Connection conn = dbConnection.getConnection();
                PreparedStatement ps = conn.prepareCall(sql)){
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                
                Integer idMau = rs.getInt("MaMau");
                String tenMau = rs.getString("TenMau");
                
                MauSac ms = new MauSac(idMau, tenMau);
                ls.add(ms);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ls;
    }
}
