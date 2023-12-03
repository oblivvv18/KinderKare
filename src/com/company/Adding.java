package com.company;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Adding {
    private static JFrame frame;
    private static JButton add;
    private static JButton back;
    private static ImageIcon warningIcon;
    private static JLabel warningLabel;
    private static ImageIcon addIcon;
    private static JLabel addLabel;
    private static ImageIcon backIcon;
    private static JLabel backLabel;
    private static ImageIcon bg;
    private static ImageIcon lastnameIcon;
    private static JLabel lastnameLabel;
    private static ImageIcon firstnameIcon;
    private static JLabel firstnameLabel;
    private static ImageIcon midnameIcon;
    private static JLabel midnameLabel;
    private static ImageIcon parentnumIcon;
    private static JLabel parentnumLabel;
    private static ImageIcon addressIcon;
    private static JLabel addressLabel;
    private static ImageIcon ageIcon;
    private static JLabel ageLabel;
    private static ImageIcon genderIcon;
    private static JLabel genderLabel;
    private static ImageIcon birthdateIcon;
    private static JLabel birthdateLabel;
    private static ImageIcon medhistoryIcon;
    private static JLabel medhistoryLabel;
    private static JLabel background;
    private static Watermark gender;
    private static Watermark lastname;
    private static Watermark firstname;
    private static Watermark midname;
    private static Watermark parentnum;
    private static Watermark address;
    private static Watermark age;
    private static Watermark birthdate;
    private static Watermark medhistory;
    private static int srcode;

    public static void showAdding() {
        frame = new JFrame();
        frame.setSize(1366,768);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        bg = new ImageIcon("src/com/company/images/addSection/ADDBg.png");
        background = new JLabel(null,bg,JLabel.CENTER);
        background.setBounds(0, 0, 1366, 768);
        frame.add(background);

        warningIcon = new ImageIcon("src/com/company/images/addSection/warningIcon.png");
        warningLabel = new JLabel(warningIcon);
        warningLabel.setBounds(500, 590, 300, 110);
        background.add(warningLabel);

        lastnameIcon = new ImageIcon("src/com/company/images/addSection/lastnameIcon.png");
        lastnameLabel = new JLabel(lastnameIcon);
        lastnameLabel.setBounds(300, 31, 176, 60);
        lastname = new Watermark("20 characters max.");
        lastname.setBounds(305, 100, 165, 35);
        background.add(lastname);
        background.add(lastnameLabel);

        firstnameIcon = new ImageIcon("src/com/company/images/addSection/firstnameIcon.png");
        firstnameLabel = new JLabel(firstnameIcon);
        firstnameLabel.setBounds(570, 29, 176, 60);
        firstname = new Watermark("25 characters max.");
        firstname.setBounds(578, 100, 165, 35);
        background.add(firstname);
        background.add(firstnameLabel);

        midnameIcon = new ImageIcon("src/com/company/images/addSection/middlenameIcon.png");
        midnameLabel = new JLabel(midnameIcon);
        midnameLabel.setBounds(840, 29, 176, 60);
        midname = new Watermark("15 characters max.");
        midname.setBounds(848, 100, 165, 35);
        background.add(midname);
        background.add(midnameLabel);

        parentnumIcon = new ImageIcon("src/com/company/images/addSection/parentumIcon.png");
        parentnumLabel = new JLabel(parentnumIcon);
        parentnumLabel.setBounds(300, 221, 176, 60);
        parentnum = new Watermark("11 digits max.");
        parentnum.setBounds(305, 290, 165, 35);
        background.add(parentnum);
        background.add(parentnumLabel);

        addressIcon = new ImageIcon("src/com/company/images/addSection/addressIcon.png");
        addressLabel = new JLabel(addressIcon);
        addressLabel.setBounds(570, 219, 176, 60);
        address = new Watermark("40 characters max.");
        address.setBounds(575, 290, 165, 35);
        background.add(address);
        background.add(addressLabel);

        ageIcon = new ImageIcon("src/com/company/images/addSection/ageIcon.png");
        ageLabel = new JLabel(ageIcon);
        ageLabel.setBounds(840, 219, 176, 60);
        age = new Watermark("Age");
        age.setBounds(845, 290, 165, 35);
        background.add(age);
        background.add(ageLabel);

        birthdateIcon = new ImageIcon("src/com/company/images/addSection/birthdateIcon.png");
        birthdateLabel = new JLabel(birthdateIcon);
        birthdateLabel.setBounds(300, 411, 176, 60);
        birthdate = new Watermark("YYYY-MM-DD");
        birthdate.setBounds(305, 480, 165, 35);
        background.add(birthdate);
        background.add(birthdateLabel);

        genderIcon = new ImageIcon("src/com/company/images/addSection/genderIcon.png");
        genderLabel = new JLabel(genderIcon);
        genderLabel.setBounds(570, 409, 176, 60);
        gender = new Watermark("M / F");
        gender.setBounds(575, 480, 165, 35);
        background.add(gender);
        background.add(genderLabel);

        medhistoryIcon = new ImageIcon("src/com/company/images/addSection/medhistoryIcon.png");
        medhistoryLabel = new JLabel(medhistoryIcon);
        medhistoryLabel.setBounds(840, 409, 176, 60);
        medhistory = new Watermark("Yes/No (If none, type 'N/A'");
        medhistory.setBounds(845, 480, 165, 35);
        background.add(medhistory);
        background.add(medhistoryLabel);

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

        backIcon = new ImageIcon("src/com/company/images/addSection/backButton.png");
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
                Home.showHome();
                frame.dispose();
            }
        });
        background.add(back);
        background.add(backLabel);

        frame.setVisible(true);
    }
    private static void insertIntoDatabase() {
        try {
            //connection to database
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectdatabase", "root", "sqlOMNIVERSE24");

            String sql = "INSERT INTO students (lastname, firstname, middlename, gender, medicalhistory) VALUES (?, ?, ?, ?, ?)";
            String sql2 = "INSERT INTO studentdetails (srcode, ParentNum,Address,Age,Birthdate) VALUES (?, ? ,?,?,?)";
            String sql3 = "INSERT INTO grades (srcode) VALUES (?)";
            // The ? is for (condition) true? if yes then return null if no, get the value in text field

            PreparedStatement prompts = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            PreparedStatement prompts2 = connection.prepareStatement(sql2, Statement.RETURN_GENERATED_KEYS);
            PreparedStatement prompts3 = connection.prepareStatement(sql3);

            prompts.setString(1, lastname.getText().equals("20 characters max.") ? null : lastname.getText());
            prompts.setString(2, firstname.getText().equals("25 characters max.") ? null : firstname.getText());
            prompts.setString(3, midname.getText().equals("15 characters max.") ? null : midname.getText());
            prompts.setString(4, gender.getText().equals("M / F") ? null : gender.getText());
            prompts.setString(5, medhistory.getText().equals("Yes/No (If none, type 'N/A'") ? null : medhistory.getText());

            int rowsAdded = prompts.executeUpdate();

            if (rowsAdded > 0) {
                ResultSet generatedKey = prompts.getGeneratedKeys();
                if (generatedKey.next()) {
                    srcode = generatedKey.getInt(1); //get the value of column 1
                    prompts2.setInt(1, srcode);
                    prompts2.setString(2, parentnum.getText().equals("11 digits max.") ? null : parentnum.getText());
                    prompts2.setString(3, address.getText());
                    prompts2.setInt(4, Integer.parseInt(age.getText()));
                    prompts2.setString(5, birthdate.getText());
                    prompts3.setInt(1, srcode);

                    if (medhistory.getText().isEmpty() || medhistory.getText().equalsIgnoreCase("No") || medhistory.getText().equalsIgnoreCase("Y/N (If none, type 'N/A'")) {
                        prompts.setNull(5, Types.VARCHAR); //automatically set the other columns to NULL
                    } else if (medhistory.getText().equalsIgnoreCase("Yes") || medhistory.getText().equalsIgnoreCase("Y") ){
                        frame.dispose();
                        Adding2.showAdding2();

                    }

                    prompts2.executeUpdate();
                    prompts3.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Details Added Successfully");
                }
            }
            connection.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error. Please Try Again.");
        }
    }
    public static int getSRCode() {
        return srcode;
    }
}
