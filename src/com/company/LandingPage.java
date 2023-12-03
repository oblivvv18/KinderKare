package com.company;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LandingPage implements ActionListener {
    private static JLabel usernameLabel;
    private static JFrame frame;
    private static JLabel passLabel;
    private static JTextField userText;
    private static JPasswordField passText;
    private static JButton login;
    private static JLabel background;
    private static JLabel correct;
    private static ImageIcon loginicon;
    private static JLabel loginlabel;

    public static void main(String[] args) {
        showLanding();
}

    public static void showLanding(){
        frame = new JFrame();
        frame.setSize(1366,768);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setMinimumSize(new Dimension(1366, 768));
        ImageIcon bgicon = new ImageIcon("src/com/company/images/TLogin.png");

        background = new JLabel(null,bgicon,JLabel.CENTER);
        background.setLayout(null);
        background.setBounds(0, 0, 1366, 768);


        loginicon = new ImageIcon("src/com/company/images/loginbutton.png");
        loginlabel = new JLabel(loginicon);
        loginlabel.setBounds(612, 415, 125, 30);

        JLabel image = new JLabel(bgicon);
        image.setBounds(0, 0, 1366, 768);


        usernameLabel = new JLabel("Username:");
        usernameLabel.setBounds(560, 330, 80, 25);
        background.add(usernameLabel);

        passLabel = new JLabel("Password:");
        passLabel.setBounds(560, 370, 80, 25);
        background.add(passLabel);

        userText = new JTextField(25);
        userText.setBounds(650, 330, 165, 25);
        background.add(userText);

        passText = new JPasswordField(25);
        passText.setBounds(650, 370, 165, 25);
        background.add(passText);

        login = new JButton("");
        login.setBounds(612, 415, 125, 30);
        loginlabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        login.setOpaque(true);
        login.setContentAreaFilled(false);
        login.setForeground(Color.WHITE);
        login.setBorderPainted(false);
        login.addActionListener(new LandingPage());
        background.add(login);

        correct = new JLabel("");
        correct.setForeground(Color.RED);
        correct.setBounds(640, 455, 120, 20);
        background.add(correct);

        frame.add(background);
        frame.add(loginlabel);
        frame.getContentPane().add(background);
        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String enduser = userText.getText();
        String password = new String(passText.getPassword());

        boolean verified = Verify.authenticate(enduser,password);

        if(verified == true){
            frame.dispose();
            Home.showHome();
        }else{
            correct.setText(("Log-in Failed"));
        }

    }
    }
