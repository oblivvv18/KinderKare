package com.company;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Adding2 {
    private static JButton add;
    private static JButton back;
    private static ImageIcon warningIcon;
    private static JLabel warningLabel;
    private static ImageIcon backIcon;
    private static JLabel backLabel;
    private static ImageIcon addIcon;
    private static JLabel addLabel;
    private static ImageIcon bg;
    private static JLabel background;
    private static ImageIcon allergiesIcon;
    private static JLabel allergiesLabel;
    private static ImageIcon vaccinationsIcon;
    private static JLabel vaccinationsLabel;
    private static ImageIcon dietrestrictionsIcon;
    private static JLabel dietrestrictionsLabel;
    private static ImageIcon medicationsIcon;
    private static JLabel medicationsLabel;
    private static ImageIcon specialinstIcon;
    private static JLabel specialinstLabel;
    private static Watermark allergies;
    private static Watermark vaccinations;
    private static Watermark dietrestrictions;
    private static Watermark medications;
    private static Watermark specialinst;

     public static void main(String[] args){
        showAdding2();
    }
    public static void showAdding2() {
        int srcode = Adding.getSRCode();
        final JFrame frame = new JFrame();
        frame.setSize(1366,768);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setMinimumSize(new Dimension(1366, 768));

        bg = new ImageIcon("src/com/company/images/addSection/ADDBg.png");
        background = new JLabel(null,bg,JLabel.CENTER);
        background.setBounds(0, 0, 1366, 768);
        frame.add(background);

        warningIcon = new ImageIcon("src/com/company/images/addSection/warningIcon.png");
        warningLabel = new JLabel(warningIcon);
        warningLabel.setBounds(500, 550, 300, 110);
        background.add(warningLabel);

        allergiesIcon = new ImageIcon("src/com/company/images/addSection/allergiesIcon.png");
        allergiesLabel = new JLabel(allergiesIcon);
        allergiesLabel.setBounds(300, 31, 176, 60);
        allergies = new Watermark("20 characters max.");
        allergies.setBounds(305, 101, 165, 35);
        background.add(allergies);
        background.add(allergiesLabel);

        vaccinationsIcon = new ImageIcon("src/com/company/images/addSection/vaccinationsIcon.png");
        vaccinationsLabel = new JLabel(vaccinationsIcon);
        vaccinationsLabel.setBounds(570, 30, 176, 60);
        vaccinations = new Watermark("20 characters max.");
        vaccinations.setBounds(578, 100, 165, 35);
        background.add(vaccinations);
        background.add(vaccinationsLabel);

        dietrestrictionsIcon = new ImageIcon("src/com/company/images/addSection/dietrestrictionsIcon.png");
        dietrestrictionsLabel = new JLabel(dietrestrictionsIcon);
        dietrestrictionsLabel.setBounds(840, 30, 176, 60);
        dietrestrictions = new Watermark("30 characters max.");
        dietrestrictions.setBounds(848, 100, 165, 35);
        background.add(dietrestrictions);
        background.add(dietrestrictionsLabel);

        medicationsIcon = new ImageIcon("src/com/company/images/addSection/medicationsIcon.png");
        medicationsLabel = new JLabel(medicationsIcon);
        medicationsLabel.setBounds(440, 221, 176, 60);
        medications = new Watermark("20 characters max.");
        medications.setBounds(445, 290, 165, 35);
        background.add(medications);
        background.add(medicationsLabel);

        specialinstIcon = new ImageIcon("src/com/company/images/addSection/specialinstIcon.png");
        specialinstLabel = new JLabel(specialinstIcon);
        specialinstLabel.setBounds(710, 221, 176, 60);
        specialinst = new Watermark("50 characters max.");
        specialinst.setBounds(715, 290, 165, 35);
        background.add(specialinst);
        background.add(specialinstLabel);

        addIcon = new ImageIcon("src/com/company/images/addSection/addButton.png");
        addLabel = new JLabel(addIcon);
        addLabel.setBounds(1165, 5, 150, 150);
        add = new JButton("");
        add.setBounds(1165, 5, 150, 150);
        add.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        add.setOpaque(false);
        add.setContentAreaFilled(false);
        add.setForeground(Color.WHITE);
        add.setBorderPainted(false);
        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                insertIntoDatabase();
            }
        });
        background.add(add);
        background.add(addLabel);
/*
        backIcon = new ImageIcon("src/com/company/images/backButton.png");
        backLabel = new JLabel(backIcon);
        backLabel.setBounds(30, 5, 150, 150);
        back = new JButton("");
        back.setBounds(30, 5, 150, 150);
        back.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        back.setOpaque(false);
        back.setContentAreaFilled(false);
        back.setForeground(Color.WHITE);
        back.setBorderPainted(false);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Adding.showAdding();
            }
        });
        background.add(back);
        background.add(backLabel);
*/
        frame.setVisible(true);
    }
    private static void insertIntoDatabase() {
        try {
            //connection to database
            int srcode = Adding.getSRCode();
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectdatabase", "root", "sqlOMNIVERSE24");

            String sql = "UPDATE studentdetails SET allergies = ?, vaccinations = ?, dietrestrictions = ? , medications = ?, specialinst = ? WHERE srcode = ?";


            PreparedStatement prompts = connection.prepareStatement(sql);
            prompts.setString(1, allergies.getText             ().equals("M / F") ? null : allergies.getText());
            prompts.setString(2, vaccinations.getText());
            prompts.setString(3, dietrestrictions.getText());
            prompts.setString(4, medications.getText().equals("15 characters max.") ? null : medications.getText());
            prompts.setString(5, specialinst.getText().equals("11 digits max.") ? null : specialinst.getText());
            prompts.setInt(6, srcode);

            int rowsAdded = prompts.executeUpdate(); //mysql RETURNS integers such as rows returned/rows affected/rows deleted
            if (rowsAdded > 0) {                     //i used it to determine if row is added successfully
                JOptionPane.showMessageDialog(null, "Student added successfully!");
            }
            connection.close();
            Home.showHome();


        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error. Please Try Again.");
        }
    }
}
