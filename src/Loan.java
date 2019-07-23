import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Loan implements ActionListener
{
   private JLabel accountNumberLabel,loanNumberLabel,loanAmountLabel;
   private JTextField accountNumber,loanNumber,loanAmount;
   private JFrame jFrame;
   private JButton button;
   Loan()
   {
       jFrame = new JFrame("Bank Management System");
       accountNumberLabel = new JLabel("Account Number");
       loanAmountLabel = new JLabel("Loan Amount");
       loanNumberLabel = new JLabel("Loan Number");
       accountNumber = new JTextField();
       loanNumber = new JTextField();
       loanAmount = new JTextField();
       button = new JButton("OK");
       accountNumberLabel.setBounds(100,75,125,25);
       accountNumber.setBounds(250,75,125,25);
       loanNumberLabel.setBounds(100,100,125,25);
       loanNumber.setBounds(250,100,125,25);
       loanAmountLabel.setBounds(100,125,125,25);
       loanAmount.setBounds(250,125,125,25);
       button.setBounds(175,175,100,25);
       jFrame.setLayout(null);
       jFrame.setSize(450,350);
       jFrame.add(accountNumberLabel);
       jFrame.add(accountNumber);
       jFrame.add(loanNumberLabel);
       jFrame.add(loanNumber);
       jFrame.add(loanAmountLabel);
       jFrame.add(loanAmount);
       jFrame.add(button);
       button.addActionListener(this);
       jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       jFrame.setLocationRelativeTo(null);
       jFrame.setVisible(true);
   }

    public static void main(String[] args) {
        new Loan();
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if(actionEvent.getSource() == button)
        {
            jFrame.setVisible(false);

            try
            {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","dbsproject","dbsproject");
                PreparedStatement ps=con.prepareStatement("insert into Loan values (?,?,?)");
                ps.setString(1,loanNumber.getText());
                ps.setString(2,loanAmount.getText());
                ps.setInt(3,Integer.parseInt(accountNumber.getText()));
//                ResultSet rs=ps.executeQuery();
//                while(rs.next()) {
//                }
//                new CheckBalance(s);
                ps.executeUpdate();
                con.close();
            }
            catch(Exception e) {
                System.out.println(e);
                JOptionPane.showMessageDialog(null,"Invalid Account No./Loan No.");
            }
            new LandingPage();
        }
    }
}
