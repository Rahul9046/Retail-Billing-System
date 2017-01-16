
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class Management extends JFrame{
	
private JButton bcheck,bmodify,bm_manage,logout;
public Management(String title)
{
	super(title);
	
	Container c=getContentPane();
	c.setLayout(new GridLayout(10,2));
	JPanel p1=new JPanel();
	JPanel p2=new JPanel();
	

	bcheck=new JButton("CHECK");
	bcheck.setBackground(Color.blue);
	bcheck.setForeground(Color.white);
	bcheck.addActionListener((e) ->{
		new Check("Select a category");
		dispose();
		});
	
	bmodify=new JButton("PRODUCT MANAGEMENT");
	bmodify.setBackground(Color.blue);
	bmodify.setForeground(Color.white);
	bmodify.addActionListener((e) ->{
		new Product_options("Product Options");
		dispose();
		});
	
	bm_manage=new JButton("MEMBER MANAGEMENT");
	bm_manage.setBackground(Color.blue);
	bm_manage.setForeground(Color.white);
	bm_manage.addActionListener((e) ->{
		new Member_options("Member Options");
		dispose();
		});
	 
	logout=new JButton("LOGOUT");
	logout.setBackground(Color.red);
	logout.setForeground(Color.white);
	logout.addActionListener((e) ->{
		new Login("Login to continue");
		dispose();
		});
	
	
	c.add(p1);
	c.add(bcheck);
	c.add(bmodify);
	c.add(bm_manage);
	c.add(p2);
	c.add(logout);
	
	setSize(300,300);
	setLocation(800,100);
	setVisible(true);
	setLocation(500,200);
	setResizable(false);
	
}

public static void main(String[] args)
{
	new Management("Management");
}

}

