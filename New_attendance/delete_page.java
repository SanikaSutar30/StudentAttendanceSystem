  //                                               last page(delete page)
 
 
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
class delete_page{

    public delete_page() {



           //Frame creation
            JFrame deleteframe=new JFrame("Delete");
            // deleteframe.setLayout(null);         //enable it to change positions of sidetaskbars
            deleteframe.setSize(Toolkit.getDefaultToolkit().getScreenSize());
            deleteframe.setBackground(Color.WHITE);
              
            //main panel
            JPanel mainpanel=new JPanel();                      // main panel that contains delete, enter prn and delete button
            mainpanel.setBounds(700, 150, 400, 400);
            mainpanel.setBackground(new Color(51,131,255,255));

            JPanel sidetaskbar=new JPanel();         // sidebar that contains all fields by which we can switch frames easily
            sidetaskbar.setLayout(null);
            sidetaskbar.setBounds(0, 0 , 400, 800);
            sidetaskbar.setBackground(new Color(51,131,255,255));
            
            //LABEL CREATIONS
            JLabel deletetitle=new JLabel("DELETE");                // delete headtag in center panel
            deletetitle.setBounds(110, 30, 200, 35);
            deletetitle.setForeground(Color.white);
            deletetitle.setFont(new Font("Sans Serif", Font.PLAIN, 45));
          
            JLabel prn=new JLabel("Enter PRN:");                        
             prn.setBounds(140, 100, 200, 35);
            prn.setForeground(Color.white);
            prn.setFont(new Font("Sans Serif", Font.PLAIN, 20));
          
            //TEXTFLIEDS
            JTextField prnfield=new JTextField();                 //textfield to enter prn to delete student
            prnfield.setBounds(100, 150, 200, 35);

            //DELETE_BUTTON                                      //delete button
            JButton deletebutton=new JButton("DELETE");
            deletebutton.setBounds(100, 250, 200, 50);
            deletebutton.setBorderPainted(false);
            deletebutton.setBackground(new Color(120,192,67,255));
            deletebutton.setForeground(new Color(255,255,255));
            deletebutton.setFont(new Font("Sans Serif", Font.PLAIN, 25));
            deletebutton.setFocusPainted(false);
          // 1.working code=== // deletebutton.addActionListener(new ActionListener(){              //action listner for take attendance
            //     //String prnofstudent = prnfield.getText();
            //     @Override
            //     public void actionPerformed(ActionEvent e) {
            //         if(prnfield.getText().equals("")){
            //          JOptionPane.showMessageDialog(null, "Please Enter Number");}
            //          else{
            //             JOptionPane.showMessageDialog(null, "Deleted Student Details Successfully");}

            //          }
           
            //     }
            //  );

                

            //2.used to delete entry from database
        //     deletebutton.addActionListener(e -> {
        //     int prnvar = Integer.parseInt(prnfield.getText());
        //     try
        //     {
        //         //Class.forName("com.mysql.jdbc.Driver");
        //         //Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/oyster_kode", "root", "sankalp@123");
        //         Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/oyster_kode", "root", "sankalp@123");
        //         String insertQuery = "delete from student where prn=2103108";

        //         // try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery))
        //         // {
        //         //     preparedStatement.setString(1,name);
        //         //     preparedStatement.setInt(2, prnvar);
        //         //     preparedStatement.setString(3,branchvar);
        //         //     int rowsAffected = preparedStatement.executeUpdate();
        //         if (rowsAffected > 0)
        //             {
        //                 JOptionPane.showMessageDialog(null, "Please Enter Number");
        //                 // Additional handling after successful insertion (clear fields, update UI, etc.)
        //             }
        //             else
        //             {
        //                 JOptionPane.showMessageDialog(null, "Student data deleted successfully!");
        //             }
        //         }
            
        //     catch (SQLException ex)
        //     {
        //         ex.printStackTrace();
        //         JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
        //     }
        // });

       //3. new code
       deletebutton.addActionListener(e -> {
        try {
            int prnVar = Integer.parseInt(prnfield.getText());
    
            // Establish the database connection
            try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/oyster_kode", "root", "Sanika@4026")) {
                
                // Create the delete query using a prepared statement
                String deleteQuery = "DELETE FROM student WHERE prn = ?";
                
                try (PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery)) {
                    preparedStatement.setInt(1, prnVar);
                    
                    // Execute the delete query
                    int rowsAffected = preparedStatement.executeUpdate();
                    
                    if (rowsAffected > 0) {
                        JOptionPane.showMessageDialog(null, "Student data with PRN " + prnVar + " deleted successfully!");
                        // Additional handling after successful deletion (clear fields, update UI, etc.)
                    } else {
                        JOptionPane.showMessageDialog(null, "No student found with PRN " + prnVar);
                    }
                }
            }
        } catch (NumberFormatException ex) {
            // Handle the case where the user didn't enter a valid number in the PRN field
            JOptionPane.showMessageDialog(null, "Please enter a valid PRN (numeric value).");
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
        }
    });

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
        itemthree.setBounds(0, 200, 400, 70);
        itemthree.setPreferredSize(new java.awt.Dimension(400, 70));
        itemthree.setBackground(new Color(51, 131, 255, 255));
        itemthree.setForeground(Color.white);
        itemthree.setFont(new Font("Sans Serif", Font.PLAIN, 25));
        itemthree.setFocusPainted(false);
         itemtwo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new add_student();
                  
            }
        });

        // item four //taskbar fourth option
        JButton itemfour = new JButton("Delete Student");
        itemfour.setBounds(0, 210, 400, 70);
        itemfour.setPreferredSize(new java.awt.Dimension(400, 70));
        itemfour.setBackground(new Color(51, 131, 255, 255));
        itemfour.setForeground(Color.white);
        itemfour.setFont(new Font("Sans Serif", Font.PLAIN, 25));
        itemfour.setFocusPainted(false);





           //SIDE_PANEL TASK BAR
           sidetaskbar.add(itemone);
           sidetaskbar.add(itemtwo);
           sidetaskbar.add(itemthree);
           sidetaskbar.add(itemfour);
           

            mainpanel.setLayout(null);
            mainpanel.add(deletetitle);
            mainpanel.add(prn);
            mainpanel.add(prnfield);
            mainpanel.add(deletebutton);
            

            
            deleteframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            deleteframe.setLayout(null);
            Container container=deleteframe.getContentPane();
             container.setLayout(null);
             container.add(mainpanel);
             container.add(sidetaskbar);

           deleteframe.setVisible(true);

         

    }
    public static void main(String []args){
        new delete_page();
    }
}