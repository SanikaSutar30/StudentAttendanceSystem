//                                                3rd page(Actual Attandance page)

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
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Take_Attendace extends JFrame{


    public static void main(String[] args) {
        new Take_Attendace();
    }


        public Take_Attendace(){
        JFrame takeframe = new JFrame("Take Attendace");
        takeframe.setSize(Toolkit.getDefaultToolkit().getScreenSize());
        takeframe.setBackground(Color.WHITE);

        JPanel sidetaskbar=new JPanel();    // sidebar that contains all fields by which we can switch frames easily
        sidetaskbar.setBounds(0, 0 , 400, 800);
        sidetaskbar.setBackground(new Color(51,131,255,255));

        //item one                                               //taskbar first option
             JButton itemone=new JButton("Take Attendance");
             itemone.setPreferredSize(new java.awt.Dimension(400, 70)); // Set preferred size
            itemone.setBackground(new Color(51,131,255,255));
            itemone.setForeground(Color.white);
            itemone.setFont(new Font("Sans Serif", Font.PLAIN, 25));
            itemone.setFocusPainted(false);

            
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
        itemthree.addActionListener(new ActionListener() {
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
        itemfour.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                
                new delete_page();
       
            }
         });
        
 

        JPanel one=new JPanel();
          one.setBounds(0,0, 1700,70);
          one.setBackground(new Color(51,131,255,255));


          sidetaskbar.add(itemone);
          sidetaskbar.add(itemtwo);
          sidetaskbar.add(itemthree);
          sidetaskbar.add(itemfour);

          Container container=takeframe.getContentPane();
          container.setLayout(null);
          container.add(sidetaskbar);

        takeframe.setVisible(true);
    }
    
}
