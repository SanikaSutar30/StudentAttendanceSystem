               //                              5th page(Adding new student)

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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

import com.mysql.cj.x.protobuf.MysqlxNotice.Frame;
            
public class add_student {
    add_student(){

        //Frame Creation
        JFrame JF1=new JFrame("ADD STUDENT");
        JF1.setSize(Toolkit.getDefaultToolkit().getScreenSize());
        JF1.setBackground(Color.WHITE);

        //Panel Creation

        //Top panel
        JPanel one=new JPanel();
        one.setBounds(0,0,1600,50);
        one.setBackground(new Color(51,131,255,255));
       

        //sankalp start


        //Left Side Panel  name= leftpanel
        JPanel leftPanel=new JPanel();                  // sidebar that contains all fields by which we can switch frames easily
            leftPanel.setBounds(0, 0 , 400, 800);
            leftPanel.setBackground(new Color(51,131,255,255));

             //item one                                               //taskbar first option
             JButton itemone=new JButton("Take Attendance");
             itemone.setPreferredSize(new java.awt.Dimension(400, 70)); // Set preferred size
            itemone.setBackground(new Color(51,131,255,255));
            itemone.setForeground(Color.white);
            itemone.setFont(new Font("Sans Serif", Font.PLAIN, 25));
            itemone.setFocusPainted(false);
        itemone.addActionListener(new ActionListener(){                        //adding function to itemone (take attendance) 

            @Override
            public void actionPerformed(ActionEvent e) {
                
                new Take_Attendace();
       
            }
         });

            
        // item two //taskbar second option
        JButton itemtwo = new JButton("View Attendance");
        itemtwo.setBounds(0, 70, 400, 70);
        itemtwo.setPreferredSize(new java.awt.Dimension(400, 70));
        itemtwo.setBackground(new Color(51, 131, 255, 255));
        itemtwo.setForeground(Color.white);
        itemtwo.setFont(new Font("Sans Serif", Font.PLAIN, 25));
        itemtwo.setFocusPainted(false);
        itemtwo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new visit_bookshelf();
            }
        });

        // item three //taskbar third option
        JButton itemthree = new JButton("Add New Student");
        itemthree.setBounds(0, 140, 400, 70);
        itemthree.setPreferredSize(new java.awt.Dimension(400, 70));
        itemthree.setBackground(new Color(51, 131, 255, 255));
        itemthree.setForeground(Color.white);
        itemthree.setFont(new Font("Sans Serif", Font.PLAIN, 25));
        itemthree.setFocusPainted(false);

        // item four //taskbar fourth option
        JButton itemfour = new JButton("Delete Student");
        itemfour.setBounds(0, 210, 400, 70);
        itemfour.setPreferredSize(new java.awt.Dimension(400, 70));
        itemfour.setBackground(new Color(51, 131, 255, 255));
        itemfour.setForeground(Color.white);
        itemfour.setFont(new Font("Sans Serif", Font.PLAIN, 25));
        itemfour.setFocusPainted(false);
          

        itemfour.addActionListener(new ActionListener(){           //action listner for delete page

            @Override
            public void actionPerformed(ActionEvent e) {
                
                new delete_page();
       
            }
         });


          //sankalp finish







        //Add Image on left side panel
        ImageIcon IM1 = new ImageIcon("Images/Attendence1copy.jpg");
        JLabel JL1 = new JLabel();
        JL1.setIcon(IM1);


        //Right Side Panel
        JPanel rightPanel=new JPanel();
        rightPanel.setBounds(750,100,500,600);
        rightPanel.setBackground(new Color(51,131,255,255));
        
        //Left top corner ImageIcon Creation
        ImageIcon I1=new ImageIcon("Images/AttendanceLogo1.jpg");
        setIconImage(I1.getImage());


        //Label Creation

        //1.Right Panel Tittle Label Creation
        JLabel rightPanelTittle=new JLabel("Student Details");
        rightPanelTittle.setBounds(120, 40, 280, 50);
        rightPanelTittle.setForeground(Color.white);
        rightPanelTittle.setFont(new Font("Sans Serif", Font.BOLD, 35));


        //2.Name Label Creation
        JLabel nameLabel= new JLabel("Name :");
        nameLabel.setBounds(70, 130, 100, 40);
        nameLabel.setForeground(Color.white);
        nameLabel.setFont(new Font("Sans Serif", Font.BOLD, 25));


        //3.ID Label Creation
        JLabel idLabel= new JLabel("PRN   :");
        idLabel.setBounds(70, 230, 100, 40);
        idLabel.setForeground(Color.white);
        idLabel.setFont(new Font("Sans Serif", Font.BOLD, 25));

        //4.Branch Label Creation
        JLabel branchLabel= new JLabel("Branch :");
        branchLabel.setBounds(50, 330, 100, 40);
        branchLabel.setForeground(Color.white);
        branchLabel.setFont(new Font("Sans Serif", Font.BOLD, 25));


        //5.Class Label Creation
        JLabel classLabel= new JLabel("Class :");
        classLabel.setBounds(70, 420, 100, 40);
        classLabel.setForeground(Color.white);
        classLabel.setFont(new Font("Sans Serif", Font.BOLD, 25));


        // TextField Creation

        //1.TextFiled Creation For Name Label
        JTextField nameField = new JTextField();
        Font customFont = new Font("Arial", Font.PLAIN, 20);
        nameField.setFont(customFont);
        nameField.setBounds(180, 135, 250, 40);
        nameField.setForeground(Color.black);


        //2.TextFiled Creation For ID Label
        JTextField prnflied = new JTextField();
        Font largerFont = prnflied.getFont().deriveFont(Font.PLAIN, 18f);

            // Set the font for the JTextField
            prnflied.setFont(largerFont);
        prnflied.setBounds(180, 230, 250, 40);
        prnflied.setBackground(Color.white);

        //3.TextFiled Creation For Branch Label
        JTextField branchField = new JTextField();
        Font branchfieldfont = branchField.getFont().deriveFont(Font.PLAIN, 18f);

            // Set the font for the JTextField
            branchField.setFont(branchfieldfont);
        branchField.setBounds(180, 330, 250, 40);
        branchField.setBackground(Color.white);

        //4.TextFiled Creation For Class Label
        JTextField classField = new JTextField();
         Font classfieldfont = classField.getFont().deriveFont(Font.PLAIN, 18f);

            // Set the font for the JTextField
            classField.setFont(classfieldfont);
        classField.setBounds(180, 420, 250, 40);
        classField.setBackground(Color.white);


        //Button Creation
        JButton addButton=new JButton("Add Details");
        addButton.setBounds(60, 500, 400, 50);
        addButton.setBackground(new Color(120,192,67,255));
        addButton.setForeground(Color.white);
        addButton.setFont(new Font("Sans Serif", Font.BOLD, 25));
        



        //sankalp start

         addButton.addActionListener(e -> {
            String name = nameField.getText();
            int prnvar = Integer.parseInt(prnflied.getText());
            String branchvar = branchField.getText();
            String classf = classField.getText();
           

            try
            {
                //Class.forName("com.mysql.jdbc.Driver");
                //Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/oyster_kode", "root", "sankalp@123");
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/oyster_kode", "root", "Sanika@4026");
                String insertQuery = "INSERT INTO student (name, prn, branch,class) VALUES (?, ?, ?, ?)";

                try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery))
                {
                    preparedStatement.setString(1,name);
                    preparedStatement.setInt(2, prnvar);
                    preparedStatement.setString(3,branchvar);
                    preparedStatement.setString(4,classf);
                    int rowsAffected = preparedStatement.executeUpdate();
                    if (rowsAffected > 0)
                    {
                        JOptionPane.showMessageDialog(null, "Student data inserted successfully!");
                        // Additional handling after successful insertion (clear fields, update UI, etc.)
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "Failed to insert student data.");
                    }
                }
            }
            catch (SQLException ex)
            {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
            }
        });

            //sankalp finish



        // Set some criteria(rules) to the right side panel
        rightPanel.setLayout(null);

        //Adding components of to right side panel
        //1.Adding Right Side Panel Title Label
        rightPanel.add(rightPanelTittle);
        //2.Adding Name Label on Right Side Panel
        rightPanel.add(nameLabel);
        //3.Adding  ID Label on Right Side Panel
        rightPanel.add(idLabel);
        //4.Adding Branch Label on Right Side Panel
        rightPanel.add(branchLabel);
        //5.Adding Class Label on Right Side Panel
        rightPanel.add(classLabel);


        //7.Adding Image  Label on Right Side Panel
        rightPanel.add(JL1);

        //1.Adding Name Label textField on Right Side Panel
        rightPanel.add(nameField);
        //2.Adding  ID Label textField on Right Side Panel
        rightPanel.add(prnflied);
        //3.Adding Branch Label textField on Right Side Panel
        rightPanel.add(branchField);
        //4.Adding Class Label textField Right Side Panel
        rightPanel.add(classField);
        //6.Adding ADD Button Label on Right Side Panel
        rightPanel.add(addButton);



        //adding left panel compoment to frame
         //SIDE_PANEL TASK BAR
           leftPanel.add(itemone);
           leftPanel.add(itemtwo);
           leftPanel.add(itemthree);
           leftPanel.add(itemfour);


        // Set some criteria(rules) to the main frame
        JF1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JF1.setLayout(null);


        //adding panel to frame
        Container C1=JF1.getContentPane();
        //set layout for container
        C1.setLayout(null);
        //adding top panel to the container
        C1.add(one);
        //Adding panels to the container
        C1.add(rightPanel);
        C1.add(leftPanel);

        //set visibility for frame
        JF1.setVisible(true);


    }
    private void setIconImage(Image image) {
    }
    //private Frame getContentPane() {
  //      return null;
   // }
    public static void main(String[] args) {

        new  new1();
    }
}
