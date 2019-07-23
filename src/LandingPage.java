import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LandingPage extends JFrame implements ActionListener{

    JLabel jlabel;
    JButton accountbtn,bankdetailsbtn,loanbtn,accounttransbtn,updatecustdetailsbtn;
    JFrame jframe;
    Container c;
    JPanel jPanel;
    LandingPage()
    {
        jlabel = new JLabel("Bank Management System",SwingConstants.CENTER);
        accountbtn = new JButton("Create Account");
        updatecustdetailsbtn = new JButton("Delete Customer Details");
        bankdetailsbtn = new JButton("Check Balance");
        loanbtn = new JButton("Loan");
        accounttransbtn = new JButton("Account Transactions");
        jframe = new JFrame("Bank Management System");
        jframe.setLayout(null);
        jlabel.setBounds(0,0,325,30);
        accountbtn.setBounds(0,30,325,30);
        bankdetailsbtn.setBounds(0,60,325,30);
        loanbtn.setBounds(0,90,325,30);
        accounttransbtn.setBounds(0,120,325,30);
        updatecustdetailsbtn.setBounds(0,150,325,30);
        jframe.add(jlabel);
        jframe.add(accountbtn);
        jframe.add(bankdetailsbtn);
        jframe.add(loanbtn);
        jframe.add(accounttransbtn);
        jframe.add(updatecustdetailsbtn);
        accountbtn.addActionListener(this);
        bankdetailsbtn.addActionListener(this);
        loanbtn.addActionListener(this);
        accounttransbtn.addActionListener(this);
        updatecustdetailsbtn.addActionListener(this);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setSize(325, 220);
        jframe.setLocationRelativeTo(null);
        jframe.setVisible(true);
    }


    public static void main(String[] args) {
        new LandingPage();

    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if(actionEvent.getSource() == accountbtn)
        {
            jframe.setVisible(false);
            new CreateAccount();
        }
        if(actionEvent.getSource() == bankdetailsbtn)
        {
            jframe.setVisible(false);
            new CheckBalancePrompt();

        }
        if (actionEvent.getSource() == loanbtn)
        {
            jframe.setVisible(false);
            new Loan();

        }
        if(actionEvent.getSource() == accounttransbtn)
        {
            jframe.setVisible(false);
            new AccountTransaction();
        }
        if(actionEvent.getSource() == updatecustdetailsbtn)
        {
            jframe.setVisible(false);
            new UpdateCustomerDetail();
        }
    }
}
