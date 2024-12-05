import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.JFrame;
public class return_book_demo extends JFrame {

    public static void main(String[] args) {
    }
    public return_book_demo() {
        JFrame g = new JFrame("Enter Details");
        JLabel l1,l2;

        l1=new JLabel("Enter your PRN");
        l1.setBounds(30,15, 120,30);

        l2=new JLabel("Enter the Book ID");
        l2.setBounds(30,53, 120,30);

        JTextField F_prn = new JTextField();
        F_prn.setBounds(160, 15, 200, 30);
        JComboBox box=new JComboBox();
        box.setBounds(160, 53, 200, 30);
        try{
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/All_Books", "root", "Gayu@321");
            Statement st=con.createStatement();
            st.executeUpdate("USE All_Books");
            ResultSet rs=st.executeQuery("select * from Issued_BookList");
            while(rs.next()){
                int str1=rs.getInt("book_id");
                box.addItem(str1);
            }
        }catch(Exception ee){
            System.out.println("Exception Occured."+ee);
        }

        JButton return_book=new JButton("Return Book");
        return_book.setBounds(170,200,150,25);
        return_book.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e) {
                setBounds(100, 100, 450, 300);
                String b_prn1 = F_prn.getText();
                int value=0,return_b_prn1=0;
                String selectedVal=box.getSelectedItem().toString();

                try {
                    value=Integer.parseInt(selectedVal);
                    return_b_prn1 = Integer.parseInt(b_prn1);
                }catch(NumberFormatException e4){
                    JOptionPane.showMessageDialog(null,"Input Should be integer.");
                }
                try{
                    int count=0,flag=0;
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/All_Books", "root", "Gayu@321");
                    PreparedStatement stmt=con.prepareStatement("select * from Issued_BookList");
                    stmt.executeUpdate("Use All_Books");
                    ResultSet return_rs= stmt.executeQuery();
                    try {
                        while (return_rs.next()) {
                            count++;
                        }
                    }catch(SQLException e3){
                        JOptionPane.showMessageDialog(null,e3);
                        con.close();
                    }
                    int count1=count;
                    ResultSet return_rs1=stmt.executeQuery();
                    while(return_rs1.next()) {
                        count1--;
                        int r1= return_rs1.getInt(2);
                        int r2=return_rs1.getInt(1);
                        if(return_b_prn1==r2 && value==r1) {
                            flag=1;
                            stmt.executeUpdate("update BookList set book_count=book_count+1 where book_id_num='" + value + "'");
                            stmt.executeUpdate("delete from Issued_BookList where book_id='" + value + "'");
                            JOptionPane.showMessageDialog(null, "Book Returned!");
                            con.close();
                            break;
                        }
                        else if(return_b_prn1==r2 && value!=r1){
                            JOptionPane.showMessageDialog(null,"Wrong Book ID, Different book was issued to you.");
                            con.close();
                            break;
                        }
                        else if( value==r1 && return_b_prn1!=r2 ){
                            JOptionPane.showMessageDialog(null,"Please check PRN, This Book is issued to another person.");
                        }
                        else if(count1<=0 && flag!=1){
                            JOptionPane.showMessageDialog(null,"This book was not issued to anyone,and currently you don't have any issued book from library. ");
                            con.close();
                            break;
                        }

                    }
                }catch(SQLException e1){
                    JOptionPane.showMessageDialog(null,e1);}
            }

        });
        g.add(box);
        g.add(return_book);
        g.add(l1);
        g.add(l2);
        g.add(F_prn);
        g.setSize(500,500);
        g.setLayout(null);
        g.setVisible(true);
        g.setLocationRelativeTo(null);
    }

}



