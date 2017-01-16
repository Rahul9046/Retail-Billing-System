

import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.*;


public class Product_del extends JFrame {
private JButton b1,b2,b3,logout;
private JTextField t;

public Product_del(String title)
{   
	Container c=getContentPane();
	c.setLayout(new GridLayout(10,2));
	
	JPanel p1=new JPanel();
	JPanel p2=new JPanel();
	JPanel p3=new JPanel();
	
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
	p2.add(logout);
	
	b1.addActionListener((e) ->{
		String text=t.getText();
		Product_search ob=new Product_search();
		 ob.search(text);
		dispose();
		});
	
	b2.addActionListener((e) ->{new Disp_Data();});
	
	b3.addActionListener((e) ->{
		new Product_options("Product options");
		dispose();
		});
	
	
	c.add(t);
	c.add(p1);
	c.add(b1);
	c.add(b2);
	c.add(b3);
    c.add(p3);
    c.add(p2);
	
	setSize(300,300);
	setVisible(true);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setLocation(500,200);
	setResizable(false);
}

public static void main(String args[])
{
new Product_del("Product Deletion");	
}
}

