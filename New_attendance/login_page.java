//                                                1st Page (login page)

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.FlowLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

class login_page{

    public static void main(String[] args) {



        //Frame creation
        JFrame frame=new JFrame("LOGIN PAGE");
        frame.setSize(Toolkit.getDefaultToolkit().getScreenSize());
        frame.setBackground(Color.WHITE);


        //Panel Creation
        //1.design panels
        JPanel one=new JPanel();
        one.setBounds(0,0, 1700,70);
        one.setBackground(new Color(51,131,255,255));

        JPanel two=new JPanel();   //This panel is not used(BUT can be useful are bottom of login_page)
        two.setBounds(0, 746, 1700, 40);
        two.setBackground(new Color(51,131,255,255));


        //LOGIN PANEL(Actual login panel)
        JPanel login_panel=new JPanel();
        login_panel.setBounds(750,130,500,600);
        login_panel.setBackground(new Color(51,131,255,255));

        //IMAGE PANEL(used to show image near to login form)
        JPanel logopanel=new JPanel();
        logopanel.setBounds(250,130,540,598);
        ImageIcon icon = new ImageIcon("E:\\StudentAttendanceSystem\\New_attendance\\adj2.png");
        JLabel thumb = new JLabel();
        thumb.setIcon(icon);

        //LABEL CREATION

        //1.
        JLabel loginletter=new JLabel("SIGN UP");
        loginletter.setBounds(160, 40, 250, 50);
        loginletter.setForeground(Color.white);
        loginletter.setFont(new Font("Sans Serif", Font.BOLD, 45));

        //2.
        JLabel usernamelabel= new JLabel("User ID:");
        usernamelabel.setBounds(40, 150, 100, 100);
        usernamelabel.setForeground(Color.white);
        usernamelabel.setFont(new Font("Sans Serif", Font.BOLD, 20));

        //3.
        JLabel passwordlabel= new JLabel("Password:");
        passwordlabel.setBounds(40,250,100,100);
        passwordlabel.setForeground(Color.white);
        passwordlabel.setFont(new Font("Sans Serif", Font.BOLD, 20));

        // TEXT FIELD CREATION
        //1.
        JTextField userfield = new JTextField();
        //  userfield.setPlaceholder("Enter your name");
        userfield.setBounds(170, 180, 280, 40);
        userfield.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        userfield.setForeground(Color.black);
        userfield.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 5, 5, new java.awt.Color(12, 91, 160)));
        //  userfield.setBorder(new LineBorder(Color.BLACK, 2, true));

        //2.
        JPasswordField passwordfield = new JPasswordField();
        passwordfield.setBounds(170, 280, 280, 40);
        passwordfield.setBorder(new LineBorder(Color.BLACK, 2, true));
        passwordfield.setFont(new Font("Sans Serif", Font.PLAIN, 20));
        passwordfield.setForeground(Color.black);
        passwordfield.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 5, 5, new java.awt.Color(12, 91, 160)));

        //BUTTON CRATION
        JButton loginbutton=new JButton("LOGIN");
        loginbutton.setBorderPainted(false);
        loginbutton.setFocusPainted(false);

        loginbutton.addActionListener(new ActionListener()       //getting password and username and check whether they are valid or invalid
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                String enteredUsername = userfield.getText();
                char[] enteredPassword = passwordfield.getPassword();
                String storedUsername = "oyster";
                String storedPassword = "1";

                if (enteredUsername.equals(storedUsername) && new String(enteredPassword).equals(storedPassword)) {
                    JOptionPane.showMessageDialog(null, "Login Successful!");
                    new ViewPage();
                    frame.dispose();
                    // Open the main application window or perform any other action
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Invalid username or password. Please try again.");
                }
            }


        });


        //  loginbutton.addActionListener(new ActionListener(){

        //     @Override
        //     public void actionPerformed(ActionEvent e) {

        //         new ViewPage();

        //     }
        //  });


        loginbutton.setBounds(150, 400, 200, 50);
        loginbutton.setBackground(new Color(120,192,67,255));
        loginbutton.setForeground(new Color(255,255,255));
        loginbutton.setFont(new Font("Sans Serif", Font.PLAIN, 25));

        //adding components to panel
        login_panel.setLayout(null);
        login_panel.add(usernamelabel);
        login_panel.add(passwordlabel);
        login_panel.add(loginletter);
        login_panel.add(userfield);
        login_panel.add(passwordfield);
        login_panel.add(loginbutton);
        logopanel.add(thumb);


        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        //adding panel to frame
        Container container=frame.getContentPane();
        container.setLayout(null);
        //  container.setBackground(Color.white);
        container.add(one);
        // container.add(two);
        container.add(login_panel);
        container.add(logopanel);
        frame.setVisible(true);

    }
}


//Code for background image by tanaya shinde
//  ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("background_image.jpg"));
//         Image i2 = i1.getImage().getScaledInstance(1800, 1000, Image.SCALE_DEFAULT);
//         ImageIcon i3 = new ImageIcon(i2);
//         JLabel l3 = new JLabel(i3);
//         l3.setBounds(0, 0, 1800, 1000);
//         frame.add(l3);