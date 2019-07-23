import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class UpdateCustomerDetail {
    JLabel l;
    JTextField tf;
    JButton b;
    JFrame f;

    UpdateCustomerDetail(){
        l = new JLabel("Enter Customer ID to be removed :");
        tf= new JTextField();
        b = new JButton("OK");

        f = new JFrame("Bank Management System");
        l.setBounds(100,25,220,25);
        tf.setBounds(100,50,220,25);
        b.setBounds(150,75,125,25);

        f.setLayout(null);
        f.setSize(450,200);
        f.add(l);
        f.add(tf);
        f.add(b);

        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.setVisible(false);
                    try{

                        DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
                        Connection con=DriverManager.getConnection("jdbc:oracle:thin:dbsproject/dbsproject:@localhost:1521:xe","dbsproject","dbsproject");
                        PreparedStatement ps=con.prepareStatement("delete from  Customer where Customer_id="+tf.getText());
                        ps.executeUpdate();
                        con.close();

                    }catch (Exception xe) {
                        System.out.println(xe);
                    }
            }
        });
        f.setLocationRelativeTo(null);
        f.setVisible(true);

        }
    }

