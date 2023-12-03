package com.company;

import javax.swing.*;

public class ViewGradeTrigger {
    public static void main() {
        SwingUtilities.invokeLater(() -> {
            ViewGrades grade = new ViewGrades("Student Grades Chart");
            grade.setSize(800, 600);
            grade.setLocationRelativeTo(null);
            grade.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            grade.setVisible(true);
        });
    }
}