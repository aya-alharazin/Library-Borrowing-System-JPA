/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import config.DBConnection;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import models.Borrow;
import java.sql.PreparedStatement;
/**
 *
 * @author aya
 */
public class BorrowDAO {

    public List<Borrow> findAll(){
        List<Borrow> list = new ArrayList<>();
        try {
            Connection conn = DBConnection.getInstance().getConnection();
            String sql = "SELECT * FROM borrow";
            Statement stat = conn.createStatement();
            ResultSet rs = stat.executeQuery(sql);
            while(rs.next()){
                Integer borrow_id =rs.getInt("borrow_id");
                Integer student_id = rs.getInt("student_id");
                Integer book_id = rs.getInt("book_id");
                String borrow_date = rs.getString("borrow_date");
                String return_date = rs.getString("return_date");
                Boolean status = rs.getBoolean("status");
                Borrow b = new Borrow(borrow_id, student_id,book_id,
                        borrow_date, return_date, status);
                list.add(b);
                
            }
        } catch (SQLException ex) {
            System.getLogger(BorrowDAO.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
        
        return list;
    }
    
    public boolean insertOne(Borrow b){
        try {
            Connection conn = DBConnection.getInstance().getConnection();
            PreparedStatement ps =conn.prepareStatement("INSERT INTO borrow"
                    + "(student_id,book_id,borrow_date,return_date,status) VALUES(?,?,?,?,?)");
            ps.setInt(1, b.getStudentId());
            ps.setInt(2, b.getBookId());
            ps.setString(3, b.getBorrowDate());
            ps.setString(4, b.getReturnDate());
            ps.setBoolean(5, b.getStatus());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.getLogger(BorrowDAO.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    return false;
        
    }
    
    
    public boolean updateOne(Borrow b){
        String sql = "UPDATE borrow SET return_date=? , status=? WHERE borrow_id =?";
        Connection conn;
        try {
            conn = DBConnection.getInstance().getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, b.getReturnDate());
            ps.setBoolean(2, b.getStatus());
            ps.setInt(3, b.getBorrowId());
            int noOfRows = ps.executeUpdate();
            return noOfRows>0;
        } catch (SQLException ex) {
            System.getLogger(BorrowDAO.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
       
        return false;
        
    }
    
    
    public boolean deleteOne(Borrow b){
        String sql = "DELETE FROM borrow WHERE borrow_id=?";
        Connection conn;
        try {
            conn = DBConnection.getInstance().getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, b.getBorrowId());
            int noOfRows = ps.executeUpdate();
            return noOfRows > 0;
        } catch (SQLException ex) {
            System.getLogger(BorrowDAO.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
        return false;
    }
    
}
