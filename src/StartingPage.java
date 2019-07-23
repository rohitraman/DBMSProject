import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class StartingPage implements ActionListener
{
    private JFrame jFrame;
    private JTextField username;
    private JPasswordField password;
    private JLabel usernameLabel,passwordLabel,displayLabel;
    private JButton button;

    StartingPage()
    {
        username = new JTextField();
        password = new JPasswordField();
        password.setEchoChar('*');
        usernameLabel = new JLabel("Username");
        passwordLabel = new JLabel("Password");
        displayLabel = new JLabel("");
        usernameLabel.setBounds(100,25,125,25);
        displayLabel.setBounds(150,150,175,25);
        username.setBounds(250,25,125,25);
        passwordLabel.setBounds(100,50,125,25);
        password.setBounds(250,50,125,25);
        button = new JButton("OK");
        button.setBounds(175,100,100,25);
        jFrame = new JFrame("Bank Management System");
        jFrame.setLayout(null);
        jFrame.add(usernameLabel);
        jFrame.add(username);
        jFrame.add(passwordLabel);
        jFrame.add(displayLabel);
        jFrame.add(password);
        jFrame.add(button);
        button.addActionListener(this);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setSize(450,220);
        jFrame.setLocationRelativeTo(null);
        jFrame.setVisible(true);

    }

    public static void main(String[] args) {
         new StartingPage();
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getSource() == button)
        {
            String usernameText = username.getText();
            String passwordText = password.getText();
            try
            {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","dbsproject","dbsproject");
                PreparedStatement ps=con.prepareStatement("select branch_name,banker_id from Banker_info");
                ResultSet rs = ps.executeQuery();
                int flag=0;
                while (rs.next())
                {
                    System.out.println("a");
                    if(usernameText.equals(rs.getString(1).trim()) && passwordText.equals(rs.getString(2).trim()))
                    {
                        flag=1;
                        break;
                        //System.out.println(usernameText);
                        //System.out.println(passwordText);
                    }

                }
                if(flag==1)
                {
                    new LandingPage();
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"WRONG Id/password");
                }
                con.close();
            }
            catch(Exception e1)
            {
                System.out.println(e1);
            }
            jFrame.setVisible(false);
        }
    }
}
