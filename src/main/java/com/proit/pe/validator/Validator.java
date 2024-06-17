package com.proit.pe.validator;

import java.awt.Color;
import javax.swing.JComponent;
import javax.swing.JTextField;

public class Validator {

    public static boolean isEmpty(JComponent component) {
        JTextField txt = (JTextField) component;

        if (txt.getText().equals("")) {
            txt.setBackground(Color.yellow);
            return true;
        } else {
            txt.setBackground(Color.white);
        }

        return false;
    }

    public static boolean isMin(JComponent component, double min) {

        JTextField txt = (JTextField) component;
            double value = Double.parseDouble(txt.getText());
            
            System.out.println("jfbs" + value);

        try {
//            double value = Double.parseDouble(txt.getText());

            if (value < min) {
                txt.setBackground(Color.yellow);
                return true;
            }

            txt.setBackground(Color.white);
        } catch (Exception e) {
            txt.setBackground(Color.yellow);
        }

        return false;
    }
}
