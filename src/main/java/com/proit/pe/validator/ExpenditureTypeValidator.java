package com.proit.pe.validator;

import javax.swing.JTextField;

public class ExpenditureTypeValidator {
    public static String validate(JTextField txtName){
        StringBuilder sb = new StringBuilder();
            
        if (Validator.isEmpty(txtName)){
            sb.append("Name must be entered");
        }
        
        return sb.isEmpty()? null : sb.toString();
    }
}
