
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;
import java.lang.*;
import java.awt.*;

public class CheckBalancePrompt implements ActionListener
{
    String s;
    private JFrame frame;
    private JButton button,button1;
    JTextField accountNo;
    JLabel accountNoLabel,accountDetailsLabel;
    //JLabel jl,jl1,jl2,jl3,jl4,jl5,jl6,jl7,jl8,jl9,jl10,jl11,jl12,jl13,jl14,jl15,jl16,jl17;

    public CheckBalancePrompt() {
        accountNo = new JTextField();
        button = new JButton("OK");
        button1 = new JButton("Go back");
        button.setBounds(162,80,100,25);
        button1.setBounds(162,110,100,25);
        accountNoLabel = new JLabel("Enter Account No:");
        accountDetailsLabel = new JLabel("Check Balance",SwingConstants.CENTER);
        accountDetailsLabel.setBounds(0,0,450,30);
        accountNoLabel.setBounds(75,35,175,25);
        accountNo.setBounds(250,35,125,25);
        frame = new JFrame("Bank Management System");
        frame.setLayout(null);
        frame.add(button);
        frame.add(button1);
        frame.add(accountNo);
        frame.add(accountNoLabel);
        frame.add(accountDetailsLabel);
        button1.addActionListener(this);
        button.addActionListener(this);
        frame.setSize(450,185);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent actionEvent)
    {
        if(actionEvent.getSource() == button)
        {
            frame.setVisible(false);

            try
            {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","dbsproject","dbsproject");
                PreparedStatement ps=con.prepareStatement("select Account_balance from Account where Account_number="+accountNo.getText());
                ResultSet rs=ps.executeQuery();
                while(rs.next()) {
                    s = rs.getString(1);
                }
                new CheckBalance(s);
            }
            catch(Exception e) {
                System.out.println(e);
            }
        }

        if(actionEvent.getSource() == button1)
        {
            frame.setVisible(false);
            new LandingPage();
        }
    }

    public static void main(String[] args) {
        new CheckBalancePrompt();
    }
}
