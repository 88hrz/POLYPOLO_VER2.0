/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories;

import Models.DanhMuc;
import java.util.ArrayList;
import java.sql.*;

/**
 *
 * @author X1
 */
public class SP_DanhMucRepo {
    DbConnection dbConnection;
    
    public ArrayList<DanhMuc> getList(){
        String sql = "SELECT * FROM DanhMuc WHERE Deleted!=1";
        ArrayList<DanhMuc> ls = new ArrayList<>();
        
        try (Connection conn = dbConnection.getConnection();
                PreparedStatement ps = conn.prepareCall(sql)){
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                
                Integer idDM = rs.getInt("MaDanhMuc");
                String tenDM = rs.getString("TenDanhMuc");
                String trangT = rs.getString("TrangThai");
                
                DanhMuc dm = new DanhMuc(idDM, tenDM, trangT);
                ls.add(dm);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ls; 
    }
}
