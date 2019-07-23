import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AccountTransaction implements ActionListener
{
    JButton withdrawbtn,depositbtn,gobackbtn;
//    JTextField amount,accountNo1,accountNo2;
    JLabel displayLabel;
    JFrame frame;
    public AccountTransaction() {
        withdrawbtn = new JButton("Withdraw");
        depositbtn = new JButton("Deposit");
        gobackbtn = new JButton("Go Back");
        displayLabel = new JLabel("ACCOUNT TRANSACTION",SwingConstants.CENTER);
        displayLabel.setBounds(0,30,450,30);
        withdrawbtn.setBounds(162,70,125,25);
        depositbtn.setBounds(162,100,125,25);
        gobackbtn.setBounds(162,150,125,25);
        frame = new JFrame("Bank Management System");
        frame.setLayout(null);
        frame.setSize(450,230);
        frame.add(displayLabel);
        frame.add(withdrawbtn);
        frame.add(depositbtn);
        frame.add(gobackbtn);
        withdrawbtn.addActionListener(this);
        depositbtn.addActionListener(this);
        gobackbtn.addActionListener(this);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

      }

    public static void main(String[] args) {
        new AccountTransaction();
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if(actionEvent.getSource() == withdrawbtn)
        {
            frame.setVisible(false);
            new Withdraw();
        }
        if(actionEvent.getSource() == depositbtn)
        {
            frame.setVisible(false);
            new Deposit();
        }
        if(actionEvent.getSource() == gobackbtn)
        {
            frame.setVisible(false);
            new LandingPage();
        }
    }
}
