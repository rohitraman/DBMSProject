import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Deposit implements ActionListener
{
    JFrame frame;
    JButton button;
    JLabel displayLabel,accountNumberLabel,depositLabel;
    JTextField accountNumber,depositAmount;

    public Deposit() {
        frame = new JFrame("Bank Management System");
        button = new JButton("Deposit");
        displayLabel = new JLabel("Deposit",SwingConstants.CENTER);
        accountNumberLabel = new JLabel("Enter Account Number");
        depositLabel = new JLabel("Amount to deposit");
        accountNumber = new JTextField();
        depositAmount = new JTextField();
        displayLabel.setBounds(0,0,450,30);
        accountNumberLabel.setBounds(70,30,175,25);
        depositLabel.setBounds(70,60,175,25);
        accountNumber.setBounds(250,30,125,25);
        depositAmount.setBounds(250,60,125,25);
        button.setBounds(165,100,125,25);
        frame.setLayout(null);
        frame.add(button);
        frame.add(displayLabel);
        frame.add(accountNumberLabel);
        frame.add(depositAmount);
        frame.add(depositLabel);
        frame.add(accountNumber);
        button.addActionListener(this);
        frame.setSize(450,175);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new Deposit();
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if(actionEvent.getSource() == button)
        {
            frame.setVisible(false);
            try
            {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","dbsproject","dbsproject");
                PreparedStatement ps=con.prepareStatement("UPDATE account set Account_balance = Account_balance+ "+depositAmount.getText()+" where account_number ="+accountNumber.getText());
                ps.executeUpdate();
                con.close();
            }
            catch(Exception e) {
                System.out.println(e);
            }
            new AccountTransaction();
        }
    }

}
