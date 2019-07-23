import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CreateAccount {
    JLabel jl,jl1,jl2,jl4,jl5;
    JTextField jt,jt1,jt2,jt4,jt5;
    JFrame jframe;
    JButton jButton;

    CreateAccount()
    {
        jl = new JLabel("Customer ID:");
        jl1 = new JLabel("Customer Name:");
        jl2 = new JLabel("Customer Street:");
        //jl3 = new JLabel("Customer City:");
        jl4 = new JLabel("Branch Name:");
        jl5 = new JLabel("Branch City:");
        //jl6 = new JLabel("Account Category:");
        //jl7 = new JLabel("Account Number:");
        //jl8 = new JLabel("Balance:");
        jt = new JTextField();
        jt1 = new JTextField();
        jt2 = new JTextField();
        //jt3 = new JTextField();
        jt4 = new JTextField();
        jt5 = new JTextField();
        //jt6 = new JTextField();
        //jt7 = new JTextField();
        //jt8 = new JTextField();
        jButton = new JButton("OK");

//        Rectangle rectangle = new Rectangle(100,200);
        jframe = new JFrame("Bank Management System");
        jl.setBounds(100,25,125,25);
        jt.setBounds(250,25,125,25);
        jl1.setBounds(100,50,125,25);
        jt1.setBounds(250,50,125,25);
        jl2.setBounds(100,75,125,25);
        jt2.setBounds(250,75,125,25);
        //jl3.setBounds(100,100,125,25);
        //jt3.setBounds(250,100,125,25);
        jl4.setBounds(100,125,125,25);
        jt4.setBounds(250,125,125,25);
        jl5.setBounds(100,150,125,25);
        jt5.setBounds(250,150,125,25);
        //jl6.setBounds(100,175,150,25);
        //jt6.setBounds(250,175,125,25);
        //jl7.setBounds(100,200,125,25);
        //jt7.setBounds(250,200,125,25);
        //jl8.setBounds(100,225,125,25);
        //jt8.setBounds(250,225,125,25);
        jButton.setBounds(175,200,100,25);
//        j.setBounds(100,150,125,25);
//        jt6.setBounds(250,150,125,25);
        jframe.setLayout(null);
        jframe.setSize(450,275);
        jframe.add(jl);
        jframe.add(jt);
        jframe.add(jl1);
        jframe.add(jt1);
        jframe.add(jl2);
        jframe.add(jt2);
        //jframe.add(jl3);
        //jframe.add(jt3);
        jframe.add(jl4);
        jframe.add(jt4);
        jframe.add(jl5);
        jframe.add(jt5);
        /*jframe.add(jl6);
        jframe.add(jt6);
        jframe.add(jl7);
        jframe.add(jt7);
        jframe.add(jl8);
        jframe.add(jt8);
        */
        jframe.add(jButton);
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                jframe.setVisible(false);
                try
                {
//                    String sql = "insert into Customer values(?,?,?,?,?)";
//                    Class.forName("oracle.jdbc.driver.OracleDriver");
                    DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
                    Connection con=DriverManager.getConnection("jdbc:oracle:thin:dbsproject/dbsproject:@localhost:1521:xe","dbsproject","dbsproject");
                    PreparedStatement ps=con.prepareStatement("insert into Customer values(?,?,?,?,?)");
                    ps.setString(1,jt.getText());
                    ps.setString(2,jt1.getText());
                    ps.setString(3,jt2.getText());
                    ps.setString(4,jt4.getText());
                    ps.setString(5,jt5.getText());
                    //System.out.println("aa");
                    ps.executeUpdate();
//                    System.out.print(i);
//                    ResultSet i = ps.executeQuery();
//                    JOptionPane.showMessageDialog(null,i+ " Record added");
                    //System.out.println("aa");
//                    con.commit();
                    con.close();
                }
                catch(Exception e)
                {
                    JOptionPane.showMessageDialog(null,"invalid data : ");
                    System.out.println(e);
                }
                System.out.println("aa");
                new CreteAccountDetail(jt.getText());
            }
        });
        jframe.setLocationRelativeTo(null);
        jframe.setVisible(true);
    }

    public static void main(String[] args) {
        new CreateAccount();
    }
}
