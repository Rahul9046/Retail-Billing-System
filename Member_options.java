

import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.*;


public class Member_options extends JFrame {
private JButton b1,b2,b3,b4,logout;
public Member_options(String tiltle)
{   
	Container c=getContentPane();
	JPanel p1=new JPanel();
	JPanel p2=new JPanel();
	JPanel p3=new JPanel();
	c.setLayout(new GridLayout(10,2));
	b1=new JButton("ADD");
	b1.setBackground(Color.blue);
	b1.setForeground(Color.white);
	b2=new JButton("DELETE");
	b2.setBackground(Color.blue);
	b2.setForeground(Color.white);
	b3=new JButton("EDIT");
	b3.setBackground(Color.blue);
	b3.setForeground(Color.white);
	b4=new JButton("BACK");
	b4.setBackground(Color.blue);
	b4.setForeground(Color.white);
	
	b1.addActionListener((e) ->{
		new Membership("Membership Details");
		dispose();
		});
	
	b2.addActionListener((e) ->{
		new Member_del("Membership Deletion");
		dispose();
		});
	
	b3.addActionListener((e) ->{
		new Member_edit("Edit Member Details");
		dispose();
		});
	
	b4.addActionListener((e) ->{
		new Management("Management");
		dispose();
		});
	
	logout=new JButton("LOGOUT");
	logout.setBackground(Color.red);
	logout.setForeground(Color.white);
	logout.addActionListener((e) ->{
		new Login("Login to continue");
		dispose();
		});
	p3.add(logout);
	
	c.add(p1);
	c.add(b1);
	c.add(b2);
	c.add(b3);
	c.add(b4);
    c.add(p2);
    c.add(p3);
	
	setSize(300,300);
	setVisible(true);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setLocation(500,200);
	setResizable(false);
}
public static void main(String args[])
{
new Member_options("Member Options");	
}
}

