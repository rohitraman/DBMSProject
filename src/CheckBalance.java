import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.sql.*;
public class CheckBalance implements ActionListener
{
    JFrame jFrame;
    JLabel balanceLabel,balance;
    JButton button;

    public CheckBalance(String s) {
        jFrame = new JFrame("Bank Management System");
        balanceLabel = new JLabel("Balance:");
        jFrame.setLayout(null);
        balance = new JLabel("Rs."+s);
        button = new JButton("Go back");
        balanceLabel.setBounds(95,30,125,25);
        balance.setBounds(160,30,125,25);
        button.setBounds(105,70,100,25);
        jFrame.add(balance);
        jFrame.add(balanceLabel);
        jFrame.add(button);
        button.addActionListener(this);
        jFrame.setSize(300,150);
        jFrame.setLocationRelativeTo(null);
        jFrame.setVisible(true);
    }

    public static void main(String[] args) {

    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if(actionEvent.getSource() == button)
        {

            jFrame.setVisible(false);
            new LandingPage();
        }
    }
}
