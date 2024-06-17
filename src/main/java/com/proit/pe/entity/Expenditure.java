package com.proit.pe.entity;

import java.io.Serializable;
import java.util.Date;

public class Expenditure implements Serializable {

    private int id;
    private String name;
    private double amount;
    private String note;
    private int typeId;
    private String typeName;
    private Date createdAt;

    public Expenditure() {
    }
    
    public Expenditure(int id, String name, double amount, String note, int typeId, String typeName) {
        this.id = id;
        this.name = name;
        this.amount = amount;
        this.note = note;
        this.typeId = typeId;
        this.typeName = typeName;
    }

    public Expenditure(int id, String name, double amount, String note, int typeId, String typeName, Date createdAt) {
        this.id = id;
        this.name = name;
        this.amount = amount;
        this.note = note;
        this.typeId = typeId;
        this.typeName = typeName;
        this.createdAt = createdAt;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
    
    
    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

}
