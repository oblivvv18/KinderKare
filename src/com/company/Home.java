package com.company;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Home {
    private static JFrame frame;
    private static JButton add;
    private static JButton view;
    private static JButton remove;
    private static ImageIcon bg;
    private static JLabel background;
    private static JButton logout;
    private static JButton update;
    private static ImageIcon addIcon;
    private static JLabel addLabel;
    private static ImageIcon removeIcon;
    private static JLabel removeLabel;
    private static ImageIcon viewIcon;
    private static JLabel viewLabel;
    private static ImageIcon updateIcon;
    private static JLabel updateLabel;
    private static ImageIcon logoutIcon;
    private static JLabel logoutLabel;
    static String choice;

    public static void main(String[] args) {
        showHome();
    }

    public static void showHome() {
        frame = new JFrame();
        frame.setSize(1366,768);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setMinimumSize(new Dimension(1366, 768));

        bg = new ImageIcon("src/com/company/images/THomeBg.png");
        background = new JLabel(null,bg,JLabel.CENTER);;
        background.setBounds(0, 0, 1366, 768);
        frame.add(background);

        logoutIcon = new ImageIcon("src/com/company/images/logoutIcon.png");
        logoutLabel = new JLabel(logoutIcon);
        logoutLabel.setBounds(20, 10, 200, 150);
        createButton("logout",60, 55, 120, 60);

        addIcon = new ImageIcon("src/com/company/images/addIcon.png");
        addLabel = new JLabel(addIcon);
        addLabel.setBounds(85, 370, 280, 180);
        createButton("add",110, 390, 235, 140);

        viewIcon = new ImageIcon("src/com/company/images/viewIcon.png");
        viewLabel = new JLabel(viewIcon);
        viewLabel.setBounds(400, 370, 280, 180);
        createButton("view",425, 390, 235, 140);


        removeIcon = new ImageIcon("src/com/company/images/removeIcon.png");
        removeLabel = new JLabel(removeIcon);
        removeLabel.setBounds(715, 370, 280, 180);
        createButton("delete",740, 390, 235, 140);


        updateIcon = new ImageIcon("src/com/company/images/updateIcon.png");
        updateLabel = new JLabel(updateIcon);
        updateLabel.setBounds(1030, 370, 280, 180);
        createButton("update",1055, 390, 235, 140);

        background.add(logoutLabel);
        background.add(updateLabel);
        background.add(addLabel);
        background.add(viewLabel);
        background.add(removeLabel);
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
                choice = info;
                System.out.print(choice);

                switch (info) {
                    case "logout":
                        LandingPage.showLanding();
                        frame.dispose();
                        break;
                    case "add":
                        Adding.showAdding();
                        frame.dispose();
                        break;
                    case "view":
                        View.viewpreview();
                        frame.dispose();
                        break;
                    case "delete":
                        Deleting.showDelete();
                        frame.dispose();
                        break;
                    case "update":
                        Update.showUpdateMenu();
                        frame.dispose();
                        break;
                }
            }
        });
        background.add(infor);
    }
}