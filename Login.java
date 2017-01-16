
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Login extends JFrame
{
    public Login(String title)
    {
        super(title);
        Icon managementString = null;
    	Icon billingString = null;
    	
    	JTextField uname;
    	JPasswordField upass;
    	String uaname="admin";
        String uapass="admin123";
        JPanel panel = new JPanel();
        JTextField field= new JTextField();
        Container c = getContentPane();
        c.setLayout(new FlowLayout());
        
        JRadioButton managementButton = new JRadioButton(managementString);
    	managementButton.setSelected(true);

		JRadioButton billingButton = new JRadioButton(billingString);

        ButtonGroup group = new ButtonGroup();
        group.add(managementButton);
        group.add(billingButton);
        
       
        
        JLabel label1 = new JLabel("management");
        label1.setForeground(Color.blue);
		label1.setFont(new Font("Arial",Font.BOLD,12));
        
        JLabel label2 = new JLabel("billing");
        label2.setForeground(Color.blue);
   		label2.setFont(new Font("Arial",Font.BOLD,12));
 
        JLabel label3 = new JLabel("user-name:");
        label3.setForeground(Color.red);
   		label3.setFont(new Font("Arial",Font.BOLD,13));
        
        JLabel label4 = new JLabel("password:");
        label4.setForeground(Color.red);
   		label4.setFont(new Font("Arial",Font.BOLD,13));
        
        JLabel l5=new JLabel("");
        
        uname=new JTextField(20);
        
        upass=new JPasswordField(20);
        
        JButton button=new JButton("LOGIN");
        button.setBackground(Color.blue);
		button.setForeground(Color.white);
		
		button.addActionListener((e) ->{
		String a1=uname.getText();
		String a2=upass.getText();
		if(managementButton.isSelected()==true){
		if((a1.equals(uaname))&&(a2.equals(uapass)))
		{
			new Management("Management");
			dispose();
		}
		else
			JOptionPane.showMessageDialog(this, "Invalid user-id or password..");
		}
		if(billingButton.isSelected()==true){
			if((a1.equals(uaname))&&(a2.equals(uapass)))
			{
				new Billing("Billing Interface");
				dispose();
			}
		else
			JOptionPane.showMessageDialog(this, "Invalid user-id or password..");
			
		}
		});
        
        c.add(managementButton);c.add(label1);
        c.add(billingButton);c.add(label2);
        c.add(l5);
        c.add(l5);
        c.add(l5);
        c.add(label3);c.add(uname);
        c.add(label4);c.add(upass);
        c.add(button);
        
        setLocation(550,200);
        setSize(250,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);
    }
    public static void main(String args[])
    {
    	Login ob=new Login("Login to continue");
    }
  
}
