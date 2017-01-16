import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class Product_edit extends JFrame{
	String data[],id1,id2;
	int r=0;
	
	private JTextField tid,tdescp,tprice,tinvent,tdisc;
	private JButton b1,b2,b3,logout;
	private JLabel l1,l2,l3;
	Product_edit(String title)
	{
		super(title);
		Container c1=getContentPane();
		c1.setLayout(new GridLayout(10,8));
		Container c2=getContentPane();
		c2.setLayout(new GridLayout(10,8));
		JPanel p1=new JPanel();
		JPanel p2=new JPanel();
		JPanel p3=new JPanel();
		JPanel p4=new JPanel();
		JPanel p5=new JPanel();
		JPanel p6=new JPanel();
		JPanel p7=new JPanel();
		JPanel p8=new JPanel();
		
		tid=new JTextField(20);
	
		tdescp=new JTextField(10);
		tdescp.setEnabled(false);
		tprice=new JTextField(10);
		tprice.setEnabled(false);
		tdisc=new JTextField(10);
		tdisc.setEnabled(false);
		tinvent=new JTextField(10);	
		tinvent.setEnabled(false);
		
	
		
		
		l1=new JLabel("Enter Product ID:");
		l1.setForeground(Color.red);
	    l1.setFont(new Font("Arial",Font.BOLD,12));
		l2=new JLabel("");
		l3=new JLabel("Product name                                       Product Price                                   Product inventory                                    Product discount"); 
		l3.setForeground(Color.red);
	    l3.setFont(new Font("Arial",Font.BOLD,12));
		b1=new JButton("EDIT");
		b1.setBackground(Color.blue);
	    b1.setForeground(Color.white);
		b2=new JButton("SAVE");
		b2.setEnabled(false);
		b2.setBackground(Color.blue);
	    b2.setForeground(Color.white);
		
		b1.addActionListener((e) ->{search();});
		b2.addActionListener((e) ->{
			String ch1=tdescp.getText();
			String ch2=tprice.getText();
			String ch3=tprice.getText();
			String ch4=tinvent.getText();
			if((ch1.length()!=0)&&(ch2.length()!=0)&&(ch3.length()!=0)&&(ch4.length()!=0))
			    update();
			else
				JOptionPane.showMessageDialog(this, "All fields are mandatory and should not ne left blank");
			});
		
		b3=new JButton("BACK");
		b3.setBackground(Color.blue);
	    b3.setForeground(Color.white);
		b3.addActionListener((e) ->{
			new Product_options("Product options");
			dispose();
			});

		logout=new JButton("LOGOUT");
		logout.setBackground(Color.red);
		logout.setForeground(Color.white);
		logout.addActionListener((e) ->{
			new Login("Login to continue");
			dispose();
			});
		p8.add(logout);
		
		p1.add(l1);
		p1.add(tid);
		p1.setLayout(new GridLayout(2,5));
		p1.setPreferredSize(new Dimension(300,250));
		
		tdescp.setText("Product");
		tprice.setText("Price");
		tinvent.setText("Inventory");
		tdisc.setText("Discount");
		
		p2.add(tdescp);
		p2.add(tprice);
		p2.add(tinvent);
		p2.add(tdisc);
		//p2.setEnabled(false);
		p2.setLayout(new GridLayout(1,5));
		p2.setPreferredSize(new Dimension(300,350));
		
		p3.add(b2);
		p3.add(b3);
		
		
		p4.add(l2);
		
		p5.add(b1);
		
		p6.add(l3);
		
		c1.add(p1);
		c1.add(p5);
		c1.add(p4);
		c1.add(p4);
		c1.add(p4);
		c1.add(p4);
		c2.add(p6);
		c2.add(p2);
		c2.add(p3);
		c2.add(p7);
		c2.add(p8);
		
		setSize(800,600);
		setLocation(800,100);
		setVisible(true);
		setLocation(300,100);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	public void search()
	{   ArrayList<Products> list;
	    int flag=0;
		id1=tid.getText();
		list=Product_details.readDataFromFile();
		for(Products re:list)
		{
			id2=re.getid();
			if(id1.equals(id2))
			{   flag=1;
				tdescp.setText(re.getdescp());
				tdescp.setEnabled(true);
				tprice.setText(re.getprice());
				tprice.setEnabled(true);
				tinvent.setText(re.getinvent());
				tinvent.setEnabled(true);
				tdisc.setText(re.getdisc());
				tdisc.setEnabled(true);
				b2.setEnabled(true);
			}
		}
		if(flag==0)
		{
			JOptionPane.showMessageDialog(this, "Incorrect ID");
			new Product_edit("Edit Product Details");
			dispose();
		}
		
	}
	public void update()
	{
		ArrayList<Products> list,list1;
		list1=new ArrayList<Products>();
		String s,search1;
		search1=tid.getText();
		try
		{
			list=Product_details.readDataFromFile();
			
			
			for(Products re:list)
			{   
				s=re.getid();
				
				if(!(s.equals(search1)))
				{
					
				    list1.add(re);
					
				}
				else{
					re.setdescp(tdescp.getText());
				    re.setinvent(tinvent.getText());
				    re.setprice(tprice.getText());
				    re.setdisc(tdisc.getText());
				    list1.add(re);
				}
			}
			Product_details.writeDatatoFile(list1);
				JOptionPane.showMessageDialog(this, "Product Edited");
				new Product_edit("Edit Product Details");
				dispose();
				    
			}	
		catch(Exception e)
		{
			e.printStackTrace();
		}
			
		
		
	}
	public static void main(String args[])
	{
		new Product_edit("Edit Product Details");
	}
	

}
