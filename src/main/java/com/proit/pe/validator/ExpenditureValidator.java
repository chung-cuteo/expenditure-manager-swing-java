package com.proit.pe.validator;

import com.proit.pe.entity.ExpenditureType;
import javax.swing.JComboBox;
import javax.swing.JTextField;

public class ExpenditureValidator {

    public static String validate(JTextField txtName, JTextField txtAmount,
        JComboBox<ExpenditureType> cbxType) {
        StringBuilder sb = new StringBuilder();

        if (Validator.isEmpty(txtName)) {
            sb.append("Name must be entered\n");
        }

        if (Validator.isEmpty(txtAmount)) {
            sb.append("Amount must be entered\n");
        }

        if (Validator.isMin(txtAmount, 0)) {
            sb.append("Amount must be greater than 0 or invalid number\n");
        }

        return sb.isEmpty() ? null : sb.toString();
    }
}
