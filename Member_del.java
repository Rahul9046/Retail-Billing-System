

import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.*;


public class Member_del extends JFrame {
private JButton b1,b2,b3,logout;
private JTextField t;

public Member_del(String tiltle)
{   
	Container c=getContentPane();
	c.setLayout(new GridLayout(10,2));
	
	JPanel p=new JPanel();
	
	t=new JTextField(20);
	
	b1=new JButton("DELETE");
	b1.setBackground(Color.blue);
	b1.setForeground(Color.white);
	
	b2=new JButton("SHOW");
	b2.setBackground(Color.blue);
	b2.setForeground(Color.white);
	
	b3=new JButton("BACK");
	b3.setBackground(Color.blue);
	b3.setForeground(Color.white);
	
	
	logout=new JButton("LOGOUT");
	logout.setBackground(Color.red);
	logout.setForeground(Color.white);
	logout.addActionListener((e) ->{
		new Login("Login to continue");
		dispose();
		});
	
	
	b1.addActionListener((e) ->{
		String text=t.getText();
		Member_search ob=new Member_search();
		 ob.search(text);
		dispose();
		});
	
	b2.addActionListener((e) ->{new DisplayDetails();});
	
	b3.addActionListener((e) ->{
		new Member_options("Member options");
		dispose();
		});
	
	c.add(t);
	c.add(b1);
	c.add(b2);
	c.add(b3);
	c.add(p);
    c.add(logout);
	
	setSize(300,300);
	setVisible(true);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setLocation(500,200);
	setResizable(false);
}
public static void main(String args[])
{
new Member_del("Member Deletion");	
}
}

