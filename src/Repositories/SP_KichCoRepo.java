/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories;

import Models.KichCo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author X1
 */
public class SP_KichCoRepo {
    DbConnection dbConnection;
    
    public ArrayList<KichCo> getList(){
        String sql = "SELECT * FROM Size WHERE Deleted!=1";
        ArrayList<KichCo> ls = new ArrayList<>();
        
        try (Connection conn = dbConnection.getConnection();
                PreparedStatement ps = conn.prepareCall(sql)){
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                
                Integer idSz = rs.getInt("MaSize");
                String tenSz = rs.getString("TenSize");
                
                KichCo sz = new KichCo(idSz, tenSz);
                ls.add(sz);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ls;
    }
}
