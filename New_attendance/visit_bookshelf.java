 //                                                   4th page


import java.awt.BorderLayout;
import java.awt.Toolkit;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
public class visit_bookshelf extends JFrame {
    private JPanel contentPane;
    private JTable table;

    public static void main(String[] args) {
        new visit_bookshelf();
    }
    public visit_bookshelf()
    {
        String data[][]=null;
        String column[]=null;
        try{
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oyster_kode", "root", "Sanika@4026");
            PreparedStatement ps=con.prepareStatement("select * from student",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            ResultSet rs=ps.executeQuery();
            ResultSetMetaData rsmd=rs.getMetaData();
            int cols=rsmd.getColumnCount();
            column=new String[cols];
            for(int i=1;i<=cols;i++){
                column[i-1]=rsmd.getColumnName(i);
            }
            rs.last();
            int rows=rs.getRow();
            rs.beforeFirst();   

            data=new String[rows][cols];
            int count=0;
            while(rs.next()){
                for(int i=1;i<=cols;i++){
                    data[count][i-1]=rs.getString(i);
                }
                count++;
            }
            con.close();
        }catch(Exception e){System.out.println(e);}
        table = new JTable(data,column);
        // table.setLayout(null);
        // table.setBounds(0, 0, 300, 300);
        JScrollPane sp=new JScrollPane(table);
       
      

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        contentPane.add(sp, BorderLayout.CENTER);

        setVisible(true);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setBounds(350, 80, 700, 700);
        // setSize(Toolkit.getDefaultToolkit().getScreenSize());          to make frame full screen
    }

}



