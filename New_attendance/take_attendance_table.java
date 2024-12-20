 //                                                   4th page


import java.awt.BorderLayout;
import java.awt.Toolkit;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
 class take_attendace_table extends JFrame {
    private JPanel contentPane;
    private JTable table;

    public static void main(String[] args) {
        take_attendace_table obj=new take_attendace_table();
    }
    public take_attendace_table()
    {
        String data[][]=null;
        String column[]=null;
        try{
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oyster_kode", "root", "sankalp@123");
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
        JScrollPane sp=new JScrollPane(table);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        contentPane.add(sp, BorderLayout.CENTER);

        setVisible(true);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setBounds(400, 5, 1130, 800);
        //setSize(Toolkit.getDefaultToolkit().getScreenSize());
    }

}



