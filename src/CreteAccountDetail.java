import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class CreteAccountDetail {

    JLabel jl,jl1,jl2;
    JTextField jt,jt1,jt2;
    JFrame jframe;
    JButton jButton;

    CreteAccountDetail(String s1)
    {
        jl = new JLabel("Account Number:");
        jl1 = new JLabel("Account Category:");
        jl2 = new JLabel("Balance:");
        jt = new JTextField();
        jt1 = new JTextField();
        jt2 = new JTextField();
        jButton = new JButton("OK");

        jframe = new JFrame("Bank Management System");
        jl.setBounds(100,25,125,25);
        jt.setBounds(250,25,125,25);
        jl1.setBounds(100,50,125,25);
        jt1.setBounds(250,50,125,25);
        jl2.setBounds(100,75,125,25);
        jt2.setBounds(250,75,125,25);
        jButton.setBounds(175,120,100,25);

        jframe.setLayout(null);
        jframe.setSize(450,200);
        jframe.add(jl);
        jframe.add(jt);
        jframe.add(jl1);
        jframe.add(jt1);
        jframe.add(jl2);
        jframe.add(jt2);
        jframe.add(jButton);
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try
                {
                    DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
                    Connection con=DriverManager.getConnection("jdbc:oracle:thin:dbsproject/dbsproject:@localhost:1521:xe","dbsproject","dbsproject");
                    PreparedStatement ps=con.prepareStatement("insert into Account values(?,?,?,?)");
                    ps.setString(1,jt.getText());
                    ps.setString(2,jt1.getText());
                    ps.setString(3,jt2.getText());
                    ps.setString(4,s1);
                    ps.executeUpdate();
                    con.close();
                }
                catch(Exception e)
                {
                    System.out.println(e);
                }
                jframe.setVisible(false);
                new LandingPage();
            }
        });
        jframe.setLocationRelativeTo(null);
        jframe.setVisible(true);
    }
}

