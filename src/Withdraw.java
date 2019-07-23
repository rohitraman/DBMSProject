import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Withdraw implements ActionListener
{
    JFrame frame;
    JButton button;
    JLabel displayLabel,accountNumberLabel,withdrawLabel;
    JTextField accountNumber,withdrawAmount;
    int amt;

    public Withdraw() {
        frame = new JFrame("Bank Management System");
        button = new JButton("Withdraw");
        displayLabel = new JLabel("Withdraw",SwingConstants.CENTER);
        accountNumberLabel = new JLabel("Enter Account Number");
        withdrawLabel = new JLabel("Amount to withdraw");
        accountNumber = new JTextField();
        withdrawAmount = new JTextField();
        displayLabel.setBounds(0,0,450,30);
        accountNumberLabel.setBounds(70,30,175,25);
        withdrawLabel.setBounds(70,60,175,25);
        accountNumber.setBounds(250,30,125,25);
        withdrawAmount.setBounds(250,60,125,25);
        button.setBounds(165,100,125,25);

        frame.setLayout(null);
        frame.add(button);
        frame.add(displayLabel);
        frame.add(accountNumberLabel);
        frame.add(withdrawAmount);
        frame.add(withdrawLabel);
        frame.add(accountNumber);
        button.addActionListener(this);
        frame.setSize(450,175);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new Withdraw();
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if(actionEvent.getSource() == button)
        {
            try
            {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","dbsproject","dbsproject");
                PreparedStatement ps=con.prepareStatement("select account_balance from Account where account_number="+accountNumber.getText());
                ResultSet rs = ps.executeQuery();
                while(rs.next())
                {
                    amt=rs.getInt(1);
//                    System.out.print(amt);
                }
                con.close();
            }
            catch(Exception e) {
                System.out.println(e);
            }
            if(amt>Integer.parseInt(withdrawAmount.getText())){
            try
            {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","dbsproject","dbsproject");
                PreparedStatement ps=con.prepareStatement("UPDATE account set Account_balance = Account_balance- "+withdrawAmount.getText()+" where account_number ="+accountNumber.getText());
                ps.executeUpdate();
                con.close();
            }
            catch(Exception e) {
                System.out.println(e);
            }

            }
            else
            {
                JOptionPane.showMessageDialog(null,"Low Balance!");
            }
            new AccountTransaction();
            frame.setVisible(false);
        }
    }
}
