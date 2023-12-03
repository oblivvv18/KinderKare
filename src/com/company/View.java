package com.company;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class View {
    private static ImageIcon bg;
    private static JFrame frame;
    private static JFrame frame2;
    private static JFrame frame3;
    private static JFrame frame4;
    private static JFrame frame5;
    private static JLabel background;
    private static Watermark vsrcode;
    private static ImageIcon viewIcon;
    private static JLabel viewLabel;
    private static ImageIcon backIcon;
    private static JLabel backLabel;
    private static ImageIcon viewIcon2;
    private static JLabel viewLabel2;
    private static ImageIcon specificIcon;
    private static JLabel specificLabel;
    private static ImageIcon allIcon;
    private static JLabel allLabel;
    private static ImageIcon gradesIcon;
    private static JLabel gradesLabel;


    public static void viewpreview(){
        frame = new JFrame();
        frame.setSize(1366,768);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setMinimumSize(new Dimension(1366, 768));

        bg = new ImageIcon("src/com/company/images/viewSection/viewBG.jpg");
        background = new JLabel(null,bg,JLabel.CENTER);
        background.setBounds(0, 0, 1366, 768);
        background.setOpaque(true);
        frame.add(background);

        viewIcon = new ImageIcon("src/com/company/images/viewSection/viewSelect.png");
        viewLabel = new JLabel(viewIcon);
        viewLabel.setBounds(500, 70, 350, 130);
        background.add(viewLabel);

        specificIcon = new ImageIcon("src/com/company/images/viewSection/viewSpecific.png");
        specificLabel = new JLabel(specificIcon);
        specificLabel.setBounds(330, 280, 180, 180);
        createButton("specific",330, 280, 180, 180);
        background.add(specificLabel);

        allIcon = new ImageIcon("src/com/company/images/viewSection/viewAll.png");
        allLabel = new JLabel(allIcon);
        allLabel.setBounds(580, 280, 180, 180);
        createButton("all",580, 280, 180, 180);
        background.add(allLabel);

        gradesIcon = new ImageIcon("src/com/company/images/viewSection/viewGradesIcon.png");
        gradesLabel = new JLabel(gradesIcon);
        gradesLabel.setBounds(830, 280, 180, 180);
        createButton("grades",830, 280, 180, 180);
        background.add(gradesLabel);

        backIcon = new ImageIcon("src/com/company/images/addSection/backButton.png");
        backLabel = new JLabel(backIcon);
        backLabel.setBounds(30, 5, 150, 150);
        createButton("back",30, 5, 150, 150);
        background.add(backLabel);


        frame.setVisible(true);
    }
    public static void showView(){ //view specific or all
        frame3 = new JFrame();
        frame3.setSize(1366,768);
        frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame3.setMinimumSize(new Dimension(1366, 768));

        bg = new ImageIcon("src/com/company/images/viewSection/viewBG.jpg");
        background = new JLabel(null,bg,JLabel.CENTER);
        background.setBounds(0, 0, 1366, 768);
        background.setOpaque(true);
        frame3.add(background);

        viewIcon = new ImageIcon("src/com/company/images/deleteSection/deldisplayIcon.png");
        viewLabel = new JLabel(viewIcon);
        viewLabel.setBounds(500, 100, 350, 130);
        background.add(viewLabel);

        vsrcode = new Watermark("XXXXX");
        vsrcode.setBounds(535, 265, 280, 45);
        background.add(vsrcode);

        backIcon = new ImageIcon("src/com/company/images/addSection/backButton.png");
        backLabel = new JLabel(backIcon);
        backLabel.setBounds(30, 5, 150, 150);
        createButton("back1",30, 5, 150, 150);
        background.add(backLabel);

        viewIcon2 = new ImageIcon("src/com/company/images/viewSection/viewButton.png");
        viewLabel2 = new JLabel(viewIcon2);
        viewLabel2.setBounds(1165, 5, 150, 150);
        createButton("view",1165, 5, 150, 150);
        background.add(viewLabel2);

        frame3.setVisible(true);
    }

    public static void showView2() { //view specific
        frame2 = new JFrame();
        frame2.setSize(1366,768);
        frame2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame2.setMinimumSize(new Dimension(1366, 768));

        /*bg = new ImageIcon("src/com/company/images/addSection/ADDBg.png");
        background = new JLabel(null,bg,JLabel.CENTER);
        background.setBounds(0, 0, 1366, 768);
        background.setOpaque(true);
        frame.add(background);*/

        DefaultTableModel jointTable = new DefaultTableModel();
        JTable table = new JTable(jointTable);
        JScrollPane scrollPane = new JScrollPane(table);
        frame2.add(scrollPane);

        ResultSet vsrcodeChecker = null;
        try {
            int srcodeValue = Integer.parseInt(vsrcode.getText());
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectdatabase", "root", "sqlOMNIVERSE24");
            Statement statement = connection.createStatement();

            // check if vsrcode exists in sql
            String vsrcodeCheckQuery = "SELECT COUNT(*) FROM students WHERE srcode = " + vsrcode.getText();
            vsrcodeChecker = statement.executeQuery(vsrcodeCheckQuery);

            if (vsrcodeChecker.next()) {
                int vsrcodeCount = vsrcodeChecker.getInt(1);

                if (vsrcodeCount > 0) {
                    // The vsrcode exists, proceed with the main query
                    String sql = "SELECT students.*, studentdetails.parentnum as ParentContactNumber,studentdetails.Address,studentdetails.Age,studentdetails.BirthDate,studentdetails.Allergies,studentdetails.Vaccinations,studentdetails.DietRestrictions,studentdetails.Medications,studentdetails.SpecialInst\n" +
                            "FROM students\n" +
                            "LEFT JOIN studentdetails ON students.srcode = studentdetails.srcode\n" +
                            "WHERE students.srcode = " + vsrcode.getText();

                    ResultSet resultSet = statement.executeQuery(sql);
                    int columnCount = resultSet.getMetaData().getColumnCount();

                    for (int i = 1; i <= columnCount; i++) {
                        jointTable.addColumn(resultSet.getMetaData().getColumnName(i));
                    }

                    while (resultSet.next()) {
                        Object[] row = new Object[columnCount];
                        for (int i = 1; i <= columnCount; i++) {
                            row[i - 1] = resultSet.getObject(i);
                        }
                        jointTable.addRow(row);
                    }

                    resultSet.close();
                } else {
                    JOptionPane.showMessageDialog(null, "Student with srcode " + srcodeValue + " not found.");
                    return;
                }
            } else {
                JOptionPane.showMessageDialog(null, "Error checking srcode existence.");
            }

            statement.close();
            connection.close();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Please enter a valid numeric SR Code.");
            return;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (vsrcodeChecker != null) {
                try {
                    vsrcodeChecker.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        frame2.setVisible(true);
    }

    public static void viewAll() {
        frame4 = new JFrame();
        frame4.setSize(1366,768);
        frame4.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame4.setMinimumSize(new Dimension(1366, 768));

        DefaultTableModel jointTable = new DefaultTableModel();
        JTable table = new JTable(jointTable);
        JScrollPane scrollPane = new JScrollPane(table);
        frame4.add(scrollPane);

        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectdatabase", "root", "sqlOMNIVERSE24");
            Statement statement = connection.createStatement();

            String sql = "SELECT students.*, studentdetails.parentnum as ParentContactNumber,studentdetails.Address,studentdetails.Age,studentdetails.BirthDate,studentdetails.Allergies,studentdetails.Vaccinations,studentdetails.DietRestrictions,studentdetails.Medications,studentdetails.SpecialInst\n" +
                    "FROM students\n" +
                    "LEFT JOIN studentdetails ON students.srcode = studentdetails.srcode;\n";
            ResultSet resultSet = statement.executeQuery(sql);

            int columnCount = resultSet.getMetaData().getColumnCount();
            for (int i = 1; i <= columnCount; i++) {
                jointTable.addColumn(resultSet.getMetaData().getColumnName(i));
            }

            while (resultSet.next()) {
                Object[] row = new Object[columnCount];
                for (int i = 1; i <= columnCount; i++) {
                    row[i - 1] = resultSet.getObject(i);
                }
                jointTable.addRow(row);
            }

            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        frame4.setVisible(true);
    }
    public static void showGrades(){
        frame5 = new JFrame();
        frame5.setSize(1366,768);
        frame5.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        bg = new ImageIcon("src/com/company/images/viewSection/viewBG.jpg");
        background = new JLabel(null,bg,JLabel.CENTER);
        background.setBounds(0, 0, 1366, 768);
        background.setOpaque(true);
        frame5.add(background);

        viewIcon = new ImageIcon("src/com/company/images/deleteSection/deldisplayIcon.png");
        viewLabel = new JLabel(viewIcon);
        viewLabel.setBounds(500, 100, 350, 130);
        background.add(viewLabel);

        vsrcode = new Watermark("XXXXX");
        vsrcode.setBounds(535, 265, 280, 45);
        background.add(vsrcode);

        backIcon = new ImageIcon("src/com/company/images/addSection/backButton.png");
        backLabel = new JLabel(backIcon);
        backLabel.setBounds(30, 5, 150, 150);
        createButton("back2",30, 5, 150, 150);
        background.add(backLabel);

        viewIcon2 = new ImageIcon("src/com/company/images/viewSection/viewButton.png");
        viewLabel2 = new JLabel(viewIcon2);
        viewLabel2.setBounds(1165, 5, 150, 150);
        createButton("view1",1165, 5, 150, 150);
        background.add(viewLabel2);

        frame5.setVisible(true);
    }
    public static void createButton(final String info, int x, int y, int w, int h) {
        JButton infor = new JButton("");
        infor.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        infor.setBounds(x,y,w,h);
        infor.setOpaque(false);
        infor.setContentAreaFilled(false);
        infor.setForeground(Color.WHITE);
        infor.setBorderPainted(false);
        background.add(infor);

        infor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch (info) {
                    case "back":
                        frame.dispose();
                        Home.showHome();
                        break;
                    case "view":
                        showView2();
                        break;
                    case "specific":
                        showView();
                        frame.dispose();
                        break;
                    case "all":
                        viewAll();
                        break;
                    case "back1":
                        Home.showHome();
                        frame.dispose();
                        if (frame3 != null) frame3.dispose();
                        break;
                    case "back2":
                        Home.showHome();
                        frame.dispose();
                        if (frame5 != null) frame5.dispose();
                        break;
                    case "grades":
                        frame.dispose();
                        showGrades();
                        if (frame3 != null) frame3.dispose();
                        else System.out.println("Warning: frame3 is null");
                        break;
                    default:
                        frame.dispose();
                        ViewGradeTrigger.main();
                }
            }
        });
        }
    public static Watermark getSRCode() {
        return vsrcode;
    }
}