package com.proit.pe.util;

import java.awt.Component;
import javax.swing.JOptionPane;

public class MessageBox {
    public static void showErrorMessage(Component parent, String title, String message){
        JOptionPane.showMessageDialog(parent, message,
                    title, JOptionPane.ERROR_MESSAGE);
    }
    public static void showErrorMessage(Component parent, String message){
        showErrorMessage(parent, "Error", message);
    }
    public static void showInformationMessage(Component parent, String title, String message){
        JOptionPane.showMessageDialog(parent, message,
                    title, JOptionPane.INFORMATION_MESSAGE);
    }
    
    public static void showWarningMessage(Component parent, String title, String message){
        JOptionPane.showMessageDialog(parent, message,
                    title, JOptionPane.WARNING_MESSAGE);
    }
    
    public static int showConfirmMessage(Component parent, String title, String message){
        return JOptionPane.showConfirmDialog(parent, message,
                    title, JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE);
    }
    
    public static int showConfirmMessage(Component parent, String message){
        return showConfirmMessage(parent, "Confirmation", message);
    }
}






