
package com.proit.pe.dao;

import com.proit.pe.entity.ExpenditureType;
import com.proit.pe.util.DatabaseUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ExpenditureTypeDao {
    public boolean insert(ExpenditureType entity) throws Exception{
        String sql = "INSERT INTO expenditureType(name) values(?) ";
        
        try(Connection con = DatabaseUtil.getConnection();
            PreparedStatement pstmt= con.prepareStatement(sql)) {

            pstmt.setString(1, entity.getName());
                        
            return pstmt.executeUpdate()>0;
        } 
    }
    public boolean update(ExpenditureType entity) throws Exception{
        String sql = "UPDATE expenditureType SET name= ? WHERE id = ? ";
        
        try(Connection con = DatabaseUtil.getConnection();
            PreparedStatement pstmt= con.prepareStatement(sql);) {

            pstmt.setString(1, entity.getName());
            pstmt.setInt(2, entity.getId());
                        
            return pstmt.executeUpdate() > 0;
        } 
    }
    
    public boolean delete(int id) throws Exception{
        String sql = "DELETE FROM expenditureType WHERE id = ? ";
        
        try(Connection con = DatabaseUtil.getConnection();
            PreparedStatement pstmt= con.prepareStatement(sql);) {

            pstmt.setInt(1, id);
            
            return pstmt.executeUpdate()>0;
        } 
    }
    
    public List<ExpenditureType> findAll() throws Exception{
        String sql = "SELECT * FROM expenditureType ";
        
        try(Connection con = DatabaseUtil.getConnection();
            PreparedStatement pstmt= con.prepareStatement(sql);) {

            List<ExpenditureType> list = new ArrayList<>();
            
            try(ResultSet rs = pstmt.executeQuery();){
                while (rs.next()){
                    ExpenditureType entity = new ExpenditureType();
                    entity.setId(rs.getInt("id"));
                    entity.setName(rs.getString("name"));
                    
                    list.add(entity);
                }
            }
            return list;
        } 
    }
    
    public ExpenditureType findById(int id) throws Exception{
        String sql = "SELECT * FROM expenditureType WHERE id = ? ";
        
        try(Connection con = DatabaseUtil.getConnection();
            PreparedStatement pstmt= con.prepareStatement(sql);) {

            pstmt.setInt(1, id);
            
            try(ResultSet rs = pstmt.executeQuery();){
                if (rs.next()){
                    ExpenditureType entity = new ExpenditureType();
                    entity.setId(rs.getInt("id"));
                    entity.setName(rs.getString("name"));
                    
                    return entity;
                }
            }
            return null;
        } 
    }
}


















