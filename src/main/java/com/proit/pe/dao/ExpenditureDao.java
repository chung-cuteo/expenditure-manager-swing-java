package com.proit.pe.dao;

import com.proit.pe.entity.Expenditure;
import com.proit.pe.util.DatabaseUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ExpenditureDao {
    public boolean insert(Expenditure entity) throws Exception{
        String sql = "INSERT INTO expenditures(name, amount, note, type) "
                + " VALUES(?, ?, ?, ?) ";
        
        try(Connection con = DatabaseUtil.getConnection();
            PreparedStatement pstmt= con.prepareStatement(sql)) {

            pstmt.setString(1, entity.getName());
            pstmt.setDouble(2, entity.getAmount());
            pstmt.setString(3, entity.getNote());
            pstmt.setInt(4, entity.getTypeId());
                        
            return pstmt.executeUpdate() > 0;
        } 
    }
    
    public boolean update(Expenditure entity) throws Exception{
        String sql = "UPDATE expenditures SET "
                + " name = ?, amount = ?, note = ?, type = ? "
                + " WHERE id = ? ";
        
        try(Connection con = DatabaseUtil.getConnection();
            PreparedStatement pstmt= con.prepareStatement(sql);) {

            pstmt.setString(1, entity.getName());
            pstmt.setDouble(2, entity.getAmount());
            pstmt.setString(3, entity.getNote());
            pstmt.setInt(4, entity.getTypeId());
            pstmt.setInt(5, entity.getId());
            
            return pstmt.executeUpdate() > 0;
        } 
    }
    
    public boolean delete(int id) throws Exception{
        String sql = " DELETE FROM expenditures WHERE id = ? ";
        
        try(Connection con = DatabaseUtil.getConnection();
            PreparedStatement pstmt= con.prepareStatement(sql);) {
            
            pstmt.setInt(1, id);
            
            return pstmt.executeUpdate() > 0;
        } 
    }
    
    public List<Expenditure> findAll() throws Exception{
        String sql = "SELECT * FROM expenditures INNER JOIN expenditureType ON expenditures.type = expenditureType.id";
        
        try(Connection con = DatabaseUtil.getConnection();
            PreparedStatement pstmt= con.prepareStatement(sql);) {

            List<Expenditure> list = new ArrayList<>();
            
            try(ResultSet rs = pstmt.executeQuery();){
                while (rs.next()){
                    Expenditure entity = new Expenditure();
                    entity.setId(rs.getInt("id"));
                    entity.setName(rs.getString("name"));
                    entity.setAmount(rs.getDouble("amount"));
                    entity.setNote(rs.getString("note"));
                    entity.setTypeId(rs.getInt("expenditureType.id"));
                    entity.setTypeName(rs.getString("expenditureType.name"));
                    entity.setCreatedAt(rs.getDate("created_at"));
                    
                    list.add(entity);
                }
            }
            return list;
        } 
    }
    
    public Expenditure findById(int id) throws Exception{
        String sql = "SELECT * FROM expenditures INNER JOIN expenditureType ON expenditures.type = expenditureType.id WHERE expenditures.id = ?";
        
        try(Connection con = DatabaseUtil.getConnection();
            PreparedStatement pstmt= con.prepareStatement(sql);) {

            pstmt.setInt(1, id);
            
            try(ResultSet rs = pstmt.executeQuery();){
                if (rs.next()){
                    Expenditure entity = new Expenditure();
                    entity.setId(rs.getInt("id"));
                    entity.setName(rs.getString("name"));
                    entity.setAmount(rs.getDouble("amount"));
                    entity.setNote(rs.getString("note"));
                    entity.setTypeId(rs.getInt("expenditureType.id"));
                    entity.setTypeName(rs.getString("expenditureType.name"));
                    entity.setCreatedAt(rs.getDate("created_at"));
                    
                    return entity;
                }
            }
            return null;
        } 
    }
}
