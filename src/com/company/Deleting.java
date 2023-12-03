package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
public class Deleting {
    private static ImageIcon delIcon;
    private static JLabel delLabel;
    private static ImageIcon warningIcon;
    private static JLabel warningLabel;
    private static ImageIcon deleteIcon;
    private static JLabel deleteLabel;
    private static ImageIcon backIcon;
    private static JLabel backLabel;
    private static ImageIcon dbg;
    private static JLabel dbackground;
    private static JButton delete;
    private static JButton goback;
    private static JTextField dsrcode;

     public static void main(String[] args) {
        showDelete();
    }

    public static void showDelete() {
        final JFrame frame = new JFrame();
        frame.setSize(1366,768);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        dbg = new ImageIcon("src/com/company/images/deleteSection/delBg.png");
        dbackground = new JLabel(null,dbg,JLabel.CENTER);;
        dbackground.setBounds(0, 0, 1366, 768);
        frame.add(dbackground);

        warningIcon = new ImageIcon("src/com/company/images/deleteSection/dwarningIcon.png");
        warningLabel = new JLabel(warningIcon);
        warningLabel.setBounds(500, 400, 300, 110);
        dbackground.add(warningLabel);

        delIcon = new ImageIcon("src/com/company/images/deleteSection/deldisplayIcon.png");
        delLabel = new JLabel(delIcon);
        delLabel.setBounds(480, 100, 350, 130);
        dbackground.add(delLabel);

        dsrcode = new Watermark("XXXXX");
        dsrcode.setBounds(510, 265, 280, 45);
        dbackground.add(dsrcode);

        backIcon = new ImageIcon("src/com/company/images/deleteSection/delbackIcon.png");
        backLabel = new JLabel(backIcon);
        backLabel.setBounds(30, 5, 150, 150);
        goback = new JButton("");
        goback.setBounds(30, 5, 150, 150);
        goback.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        goback.setOpaque(false);
        goback.setContentAreaFilled(false);
        goback.setForeground(Color.WHITE);
        goback.setBorderPainted(false);
        goback.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Home.showHome();
                frame.dispose();
            }
        });
        dbackground.add(goback);
        dbackground.add(backLabel);

        deleteIcon = new ImageIcon("src/com/company/images/deleteSection/deleteIcon.png");
        deleteLabel = new JLabel(deleteIcon);
        deleteLabel.setBounds(1165, 5, 150, 150);
        delete = new JButton("");
        delete.setBounds(1165, 5, 150, 150);
        delete.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        delete.setOpaque(false);
        delete.setContentAreaFilled(false);
        delete.setForeground(Color.WHITE);
        delete.setBorderPainted(false);
        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteFromDatabase();
                frame.dispose();
            }
        });
        dbackground.add(delete);
        dbackground.add(deleteLabel);
        frame.setVisible(true);
    }
    public static void deleteFromDatabase(){
        try {
            // set up the connection again
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectdatabase", "root", "sqlOMNIVERSE24");

            // inserting the prompt
            String sql = "DELETE FROM students where srcode = ? ";

            // inserting a statement placeholder
            PreparedStatement prompts = connection.prepareStatement(sql);
            prompts.setString(1, dsrcode.getText());
            if(dsrcode.getText().equals("XXXXX")){
                JOptionPane.showMessageDialog(null, "Enter a student's SR Code!");
                showDelete();
            }else{
                int deletedRows = prompts.executeUpdate(); //mysql returns integers such as rows returned/rows affected/rows deleted
                if (deletedRows > 0) {                     //i used it to detect if row is deleted to trigger different panes
                    JOptionPane.showMessageDialog(null, "Student's record deleted successfully!");
                    Home.showHome();
                } else {
                    JOptionPane.showMessageDialog(null, "SR Code not found.");
                    showDelete();
                }
            }

            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
