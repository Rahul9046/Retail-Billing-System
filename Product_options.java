

import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.*;


public class Product_options extends JFrame {
private JButton b1,b2,b3,b4,logout;
public Product_options(String title)
{   
	super(title);
	Container c=getContentPane();
	c.setLayout(new GridLayout(10,2));
	JPanel p1=new JPanel();
	JPanel p2=new JPanel();
	JPanel p3=new JPanel();
	
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
	
	logout=new JButton("LOGOUT");
	logout.setBackground(Color.red);
	logout.setForeground(Color.white);
	logout.addActionListener((e) ->{
		new Login("Login to continue");
		dispose();
		});
	
	p3.add(logout);
	
	b1.addActionListener((e) ->{
		new Product_add("Product Details");
		dispose();
		});
	
	b2.addActionListener((e) ->{
		new Product_del("Product Deletion");
		dispose();
		});
	
	b3.addActionListener((e) ->{
		new Product_edit("Edit Product Details");
		dispose();
		});
	
	b4.addActionListener((e) ->{
		new Management("Management");
		dispose();
		});
	
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
new Product_options("Product Options");	
}
}

