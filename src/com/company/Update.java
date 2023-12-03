package com.company;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Update {
    private static JFrame frame;
    private static JFrame frame2;
    private static JButton update;
    private static ImageIcon act1Icon;
    private static JLabel act1Label;
    private static ImageIcon act2Icon;
    private static JLabel act2Label;
    private static ImageIcon act3Icon;
    private static JLabel act3Label;
    private static ImageIcon act4Icon;
    private static JLabel act4Label;
    private static ImageIcon test1Icon;
    private static JLabel test1Label;
    private static ImageIcon test2Icon;
    private static JLabel test2Label;
    private static ImageIcon selectionIcon;
    private static JLabel selectionLabel;
    private static ImageIcon enterIcon;
    private static JLabel enterLabel;
    private static ImageIcon updataIcon;
    private static JLabel updataLabel;
    private static ImageIcon warningIcon;
    private static JLabel warningLabel;
    private static ImageIcon updateIcon;
    private static JLabel updateLabel;
    private static ImageIcon backIcon;
    private static JLabel backLabel;
    private static ImageIcon bg;
    private static JLabel updateGradesLabel;
    private static ImageIcon updateGradesIcon;
    private static JLabel updateProfileLabel;
    private static ImageIcon updateProfileIcon;
    private static JLabel background;
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
    private static Watermark srcode;
    private static Watermark info;
    static String updateChoice;

    public static void main(String[] args) {
        showUpdateMenu();
    }

    public static void showUpdateMenu() {
        frame = new JFrame();
        frame.setSize(1366, 768);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setMinimumSize(new Dimension(1366, 768));

        bg = new ImageIcon("src/com/company/images/updateSection/updateBg.png");
        background = new JLabel(null, bg, JLabel.CENTER);
        background.setBounds(0, 0, 1366, 768);
        frame.add(background);

        updateProfileIcon = new ImageIcon("src/com/company/images/updateSection/updateProfileIcon.png");
        updateProfileLabel = new JLabel(updateProfileIcon);
        updateProfileLabel.setBounds(450, 250, 180, 180);
        createButton("profile",450, 250, 180, 180);
        background.add(updateProfileLabel);

        updateGradesIcon = new ImageIcon("src/com/company/images/updateSection/updateGradesIcon.png");
        updateGradesLabel = new JLabel(updateGradesIcon);
        updateGradesLabel.setBounds(750, 250, 180, 180);
        createButton("grades",750, 250, 180, 180);
        background.add(updateGradesLabel);

        backIcon = new ImageIcon("src/com/company/images/addSection/backButton.png");
        backLabel = new JLabel(backIcon);
        backLabel.setBounds(30, 5, 150, 150);
        createButton("back",30, 5, 150, 150);
        background.add(backLabel);

        frame.setVisible(true);
    }
    public static void showUpdate() {
        frame = new JFrame();
        frame.setSize(1366, 768);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setMinimumSize(new Dimension(1366, 768));

        bg = new ImageIcon("src/com/company/images/updateSection/updateBg.png");
        background = new JLabel(null, bg, JLabel.CENTER);
        background.setBounds(0, 0, 1366, 768);
        frame.add(background);

        enterIcon = new ImageIcon("src/com/company/images/updateSection/upenterIcon.png");
        enterLabel = new JLabel(enterIcon);
        enterLabel.setBounds(575, 10, 200, 90);
        background.add(enterLabel);

        srcode = new Watermark("XXXXX");
        srcode.setBounds(600, 112, 155, 30);
        background.add(srcode);

        selectionIcon = new ImageIcon("src/com/company/images/updateSection/upselectIcon.png");
        selectionLabel = new JLabel(selectionIcon);
        selectionLabel.setBounds(575, 165, 200, 90);
        background.add(selectionLabel);

        updataIcon = new ImageIcon("src/com/company/images/updateSection/updataIcon.png");
        updataLabel = new JLabel(updataIcon);
        updataLabel.setBounds(330, 590, 200, 90);
        background.add(updataLabel);

        info = new Watermark("Enter the new data");
        info.setBounds(550, 615, 170, 40);
        background.add(info);

        /*warningIcon = new ImageIcon("src/com/company/images/updateSection/upwarningIcon.png");
        warningLabel = new JLabel(warningIcon);
        warningLabel.setBounds(30, 620, 300, 110);
        background.add(warningLabel);*/

        lastnameIcon = new ImageIcon("src/com/company/images/updateSection/uplastnameIcon.png");
        lastnameLabel = new JLabel(lastnameIcon);
        lastnameLabel.setBounds(330, 275, 145, 65);
        createButton("lastname",330, 275, 145, 65);
        background.add(lastnameLabel);

        firstnameIcon = new ImageIcon("src/com/company/images/updateSection/upfirstnameIcon.png");
        firstnameLabel = new JLabel(firstnameIcon);
        firstnameLabel.setBounds(510, 275, 145, 65);
        createButton("firstname",510, 275, 145, 65);
        background.add(firstnameLabel);

        midnameIcon = new ImageIcon("src/com/company/images/updateSection/upmidnameIcon.png");
        midnameLabel = new JLabel(midnameIcon);
        midnameLabel.setBounds(690, 275, 145, 65);
        createButton("middlename",690, 275, 145, 65);
        background.add(midnameLabel);

        parentnumIcon = new ImageIcon("src/com/company/images/updateSection/upparentnumIcon.png");
        parentnumLabel = new JLabel(parentnumIcon);
        parentnumLabel.setBounds(870, 275, 145, 65);
        createButton("ParentNum",870, 275, 145, 65);
        background.add(parentnumLabel);

        addressIcon = new ImageIcon("src/com/company/images/updateSection/upaddressIcon.png");
        addressLabel = new JLabel(addressIcon);
        addressLabel.setBounds(330, 350, 145, 65);
        createButton("Address",330, 350, 145, 65);
        background.add(addressLabel);

        ageIcon = new ImageIcon("src/com/company/images/updateSection/upageIcon.png");
        ageLabel = new JLabel(ageIcon);
        ageLabel.setBounds(510, 350, 145, 65);
        createButton("Age",510, 350, 145, 65);
        background.add(ageLabel);
        //createButton("age");

        birthdateIcon = new ImageIcon("src/com/company/images/updateSection/upbirthdateIcon.png");
        birthdateLabel = new JLabel(birthdateIcon);
        birthdateLabel.setBounds(690, 350, 145, 65);
        createButton("BirthDate",690, 350, 145, 65);
        background.add(birthdateLabel);

        genderIcon = new ImageIcon("src/com/company/images/updateSection/upgenderIcon.png");
        genderLabel = new JLabel(genderIcon);
        genderLabel.setBounds(870, 350, 145, 65);
        createButton("gender",870, 350, 145, 65);
        background.add(genderLabel);

        allergiesIcon = new ImageIcon("src/com/company/images/updateSection/upallergiesIcon.png");
        allergiesLabel = new JLabel(allergiesIcon);
        allergiesLabel.setBounds(330, 425, 145, 65);
        createButton("Allergies",330, 425, 145, 65);
        background.add(allergiesLabel);

        vaccinationsIcon = new ImageIcon("src/com/company/images/updateSection/upvaccinationIcon.png");
        vaccinationsLabel = new JLabel(vaccinationsIcon);
        vaccinationsLabel.setBounds(510, 425, 145, 65);
        createButton("Vaccinations",510,425, 145, 65);
        background.add(vaccinationsLabel);

        dietrestrictionsIcon = new ImageIcon("src/com/company/images/updateSection/updietrestIcon.png");
        dietrestrictionsLabel = new JLabel(dietrestrictionsIcon);
        dietrestrictionsLabel.setBounds(690, 425, 145, 65);
        createButton("DietRestrictions",690, 425, 145, 65);
        background.add(dietrestrictionsLabel);

        medicationsIcon = new ImageIcon("src/com/company/images/updateSection/upmedicationsIcon.png");
        medicationsLabel = new JLabel(medicationsIcon);
        medicationsLabel.setBounds(870, 425, 145, 65);
        createButton("Medications",870, 425, 145, 65);
        background.add(medicationsLabel);

        specialinstIcon = new ImageIcon("src/com/company/images/updateSection/upspecialinstIcon.png");
        specialinstLabel = new JLabel(specialinstIcon);
        specialinstLabel.setBounds(603, 500, 145, 65);
        createButton("SpecialInst",603, 500, 145, 65);
        background.add(specialinstLabel);

        updateIcon = new ImageIcon("src/com/company/images/updateSection/updateIcon.png");
        updateLabel = new JLabel(updateIcon);
        updateLabel.setBounds(1165, 5, 150, 150);
        update = new JButton("");
        update.setBounds(1165, 5, 150, 150);
        update.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        update.setOpaque(false);
        update.setContentAreaFilled(false);
        update.setForeground(Color.WHITE);
        update.setBorderPainted(false);
        update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateDatabase();
            }
        });
        background.add(update);
        background.add(updateLabel);

        backIcon = new ImageIcon("src/com/company/images/addSection/backButton.png");
        backLabel = new JLabel(backIcon);
        backLabel.setBounds(30, 5, 150, 150);
        createButton("back",30, 5, 150, 150);
        background.add(backLabel);

        frame.setVisible(true);
    }

    public static void showUpdate2(){
        frame = new JFrame();
        frame.setSize(1366, 768);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        bg = new ImageIcon("src/com/company/updateSection/updateBg.png");
        background = new JLabel(null, bg, JLabel.CENTER);
        background.setBounds(0, 0, 1366, 768);
        frame.add(background);

        enterIcon = new ImageIcon("src/com/company/images/updateSection/upenterIcon.png");
        enterLabel = new JLabel(enterIcon);
        enterLabel.setBounds(575, 10, 200, 90);
        background.add(enterLabel);

        srcode = new Watermark("XXXXX");
        srcode.setBounds(600, 112, 155, 30);
        background.add(srcode);

        selectionIcon = new ImageIcon("src/com/company/images/updateSection/upselectIcon.png");
        selectionLabel = new JLabel(selectionIcon);
        selectionLabel.setBounds(575, 165, 200, 90);
        background.add(selectionLabel);

        backIcon = new ImageIcon("src/com/company/images/addSection/backButton.png");
        backLabel = new JLabel(backIcon);
        backLabel.setBounds(30, 5, 150, 150);
        createButton("back2",30, 5, 150, 150);
        background.add(backLabel);

        act1Icon = new ImageIcon("src/com/company/images/updateSection/activity1.png");
        act1Label = new JLabel(act1Icon);
        act1Label.setBounds(330, 275, 145, 65);
        createButton("activity1",330, 275, 145, 65);
        background.add(act1Label);

        act2Icon = new ImageIcon("src/com/company/images/updateSection/activity2.png");
        act2Label = new JLabel(act2Icon);
        act2Label.setBounds(510, 275, 145, 65);
        createButton("activity2",510, 275, 145, 65);
        background.add(act2Label);

        act3Icon = new ImageIcon("src/com/company/images/updateSection/activity3.png");
        act3Label = new JLabel(act3Icon);
        act3Label.setBounds(690, 275, 145, 65);
        createButton("activity3",690, 275, 145, 65);
        background.add(act3Label);

        act4Icon = new ImageIcon("src/com/company/images/updateSection/activity4.png");
        act4Label = new JLabel(act4Icon);
        act4Label.setBounds(870, 275, 145, 65);
        createButton("activity4",870, 275, 145, 65);
        background.add(act4Label);

        test1Icon = new ImageIcon("src/com/company/images/updateSection/test1.png");
        test1Label = new JLabel(test1Icon);
        test1Label.setBounds(510, 350, 145, 65);
        createButton("test1",510, 350, 145, 65);
        background.add(test1Label);

        test2Icon = new ImageIcon("src/com/company/images/updateSection/test2.png");
        test2Label = new JLabel(test2Icon);
        test2Label.setBounds(690, 350, 145, 65);
        createButton("test2",690, 350, 145, 65);
        background.add(test2Label);

        updataIcon = new ImageIcon("src/com/company/images/updateSection/updataIcon.png");
        updataLabel = new JLabel(updataIcon);
        updataLabel.setBounds(330, 500, 200, 90);
        background.add(updataLabel);

        info = new Watermark("Enter the new data");
        info.setBounds(550, 525, 170, 40);
        background.add(info);

        updateIcon = new ImageIcon("src/com/company/images/updateSection/updateIcon.png");
        updateLabel = new JLabel(updateIcon);
        updateLabel.setBounds(1165, 5, 150, 150);
        update = new JButton("");
        update.setBounds(1165, 5, 150, 150);
        update.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        update.setOpaque(false);
        update.setContentAreaFilled(false);
        update.setForeground(Color.WHITE);
        update.setBorderPainted(false);
        update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateDatabase2();
            }
        });
        background.add(update);
        background.add(updateLabel);


        frame.setVisible(true);
    }
    public static void createButton(final String info, int x, int y, int w, int h) {
        JButton infor = new JButton("");
        infor.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        infor.setBounds(x,y,w,h);
        infor.setOpaque(false);
        infor.setContentAreaFilled(false);
        infor.setForeground(infor.getBackground());
        infor.setBorderPainted(false);
        infor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateChoice = info;
                System.out.print(updateChoice);

                switch (info) {
                    case "grades":
                        frame.dispose();
                        showUpdate2();
                        break;
                    case "profile":
                        frame.dispose();
                        showUpdate();
                        break;
                    case "back":
                        frame.dispose();
                        Home.showHome();
                        break;
                    case "back2":
                        frame.dispose();
                        showUpdateMenu();
                        break;
                    case "update":
                        updateDatabase();
                        break;
                }
            }
        });
        background.add(infor);
    }
    private static void updateDatabase() {
        try {
            //connection to database
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectdatabase", "root", "sqlOMNIVERSE24");

             String tableName = (updateChoice.equals("lastname") || updateChoice.equals("firstname") || updateChoice.equals("middlename") || updateChoice.equals("gender"))
             ? "students" : "studentdetails";

            String sql = "UPDATE " + tableName + " SET " + updateChoice + " = ? WHERE srcode = ?";
            System.out.println("SQL Query: " + sql);

            PreparedStatement prompts = connection.prepareStatement(sql);
            prompts.setString(1, info.getText().equals("Enter the new data") ? null : info.getText());
            prompts.setString(2, srcode.getText().equals("XXXXX") ? null : srcode.getText());


            int rowsaffected = prompts.executeUpdate(); //mysql RETURNS integers such as rows returned/rows affected/rows deleted
            if (rowsaffected > 0) {                     //used it to determine if row is added successfully
                JOptionPane.showMessageDialog(null, "Data updated successfully!");
            }else{
                JOptionPane.showMessageDialog(null, "Error. Check your inputs and try again.");
            }
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error. Please Try Again.");
        }
    }
    private static void updateDatabase2() {
        try {
            //connection to database
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectdatabase", "root", "sqlOMNIVERSE24");

            String sql = "UPDATE grades SET " + updateChoice + " = ? WHERE srcode = ?";

            PreparedStatement prompts = connection.prepareStatement(sql);
            prompts.setString(1, info.getText().equals("Enter the new data") ? null : info.getText());
            prompts.setString(2, srcode.getText().equals("XXXXX") ? null : srcode.getText());


            int rowsaffected = prompts.executeUpdate(); //mysql RETURNS integers such as rows returned/rows affected/rows deleted
            if (rowsaffected > 0) {                     //used it to determine if row is added successfully
                JOptionPane.showMessageDialog(null, "Grade updated successfully!");
            }else{
                JOptionPane.showMessageDialog(null, "Error. Check your inputs and try again.");
            }
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error. Please Try Again.");
        }
    }
}
