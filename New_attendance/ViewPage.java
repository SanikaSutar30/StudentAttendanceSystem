//                                               2nd page (menu page or hero page)


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class ViewPage extends JFrame{        
    JFrame frame;
    JLabel head_lable;
    JLabel head1_lable;


    public static void main(String[] args) {
        ViewPage v = new ViewPage();
    }
    public ViewPage()
    {
        frame = new JFrame("Main Page");
        frame.setSize(1800,1800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



        //background image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("oyster5.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1800, 1000, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(0, 0, 1800, 1000);
        frame.add(l3);
        Container c= frame.getContentPane();

        // logo label
        JLabel l5=new JLabel();
        l5.setIcon(new ImageIcon(ClassLoader.getSystemResource("logo2.jpg")));
        l5.setBounds(1300, 20, 150, 150);
        l3.add(l5);
        l5.setVisible(true);


        frame.getContentPane().setLayout(null);

        //heading
        head_lable = new JLabel("Oyster Kode Club");
        head_lable.setForeground(Color.ORANGE);
        head_lable.setFont(new Font("Tahoma", Font.BOLD, 70));
        head_lable.setBounds(500,50,800,75 );
        l3.add(head_lable);

        //subheading
        head1_lable = new JLabel("Code To Change");
        head1_lable.setForeground(Color.black);
        head1_lable.setFont(new Font("Tahoma", Font.BOLD, 30));
        head1_lable.setBounds(680,130,500,40 );
        l3.add(head1_lable);

//        buttons
        JButton take_A = new JButton("Take Attendance");
        take_A.setBounds(1000,240,370,70);
//        take_A.setBackground(Color.magenta);
take_A.setFocusPainted(false);
        take_A.setFont(new Font("Tahoma", Font.BOLD, 15));
        l3.add(take_A);
         take_A.addActionListener(new ActionListener(){              //action listner for take attendance

            @Override
            public void actionPerformed(ActionEvent e) {
                
                new Take_Attendace();
                //new take_attendace_table();
       
            }
         });

        JButton view_A = new JButton("View Student List");
        view_A.setBounds(1000,350,370,70);
        view_A.setFont(new Font("Tahoma", Font.BOLD, 15));
//        view_A.setBackground(Color.magenta);
view_A.setFocusPainted(false);
        l3.add(view_A);
        
        view_A.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new visit_bookshelf();
            }
        });
       

        JButton add_Std = new JButton("Add New Student");
        add_Std.setBounds(1000,460,370,70);
//        add_Std.setBackground(Color.magenta);
        add_Std.setFont(new Font("Tahoma", Font.BOLD, 15));
        l3.add(add_Std);
        add_Std.setFocusPainted(false);
        l3.add(view_A);
        add_Std.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new add_student();
            }
        });


        JButton delt_Std = new JButton("Delete Student");
        delt_Std.setBounds(1000,570,370,70);
//        delt_Std.setBackground(Color.magenta);
        delt_Std.setFont(new Font("Tahoma", Font.BOLD, 15));
        l3.add(delt_Std);
        delt_Std.setFocusPainted(false);

        delt_Std.addActionListener(new ActionListener(){

                @Override
                public void actionPerformed(ActionEvent e) {
                    
                    new delete_page();
           
                }
             });


        frame.setVisible(true);
        frame.setLocationRelativeTo(null);


    }

}