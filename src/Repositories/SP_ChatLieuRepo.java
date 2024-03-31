/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories;

import Models.ChatLieu;
import java.util.ArrayList;
import java.sql.*;

/**
 *
 * @author X1
 */
public class SP_ChatLieuRepo {
    DbConnection dbConnection;
    
    public ArrayList<ChatLieu> getList(){
        String sql = "SELECT * FROM ChatLieu WHERE Deleted!=1";
        ArrayList<ChatLieu> ls = new ArrayList<>();
        
        try (Connection conn = dbConnection.getConnection();
                PreparedStatement ps = conn.prepareCall(sql)){
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                
                Integer idMat = rs.getInt("MaChatLieu");
                String tenMat = rs.getString("TenChatLieu");
                
                ChatLieu cl = new ChatLieu(idMat, tenMat);
                ls.add(cl);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ls;
    }
}
