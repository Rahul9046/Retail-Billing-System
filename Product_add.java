
import java.awt.Color;
import java.awt.Container;
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


public class Product_add extends JFrame {
	private JButton b1,b2,b3,b4;
	private JTextField tdescp,tprice,tinvent,tdisc;
	private JLabel lid,ldescp,lprice,linvent,ldisc;
	ArrayList<Products> prodlist;
	Products p;
	String bb="PR_123";
	public Product_add(String title)
	{
		super(title);
		Container c=getContentPane();
		JPanel p1=new JPanel();
		JPanel p2=new JPanel();
		JPanel p3=new JPanel();
		JPanel p4=new JPanel();
		c.setLayout(new GridLayout(10,2));
		//=new JTextField(20);
		tdescp=new JTextField(20);
		tprice=new JTextField(20);
		tinvent=new JTextField(20);
		tdisc=new JTextField(20);
		
		lid=new JLabel("Product ID :");
		lid.setForeground(Color.red);
		lid.setFont(new Font("Arial",Font.BOLD,14));
		ldescp=new JLabel("Product description :");
		ldescp.setForeground(Color.red);
		ldescp.setFont(new Font("Arial",Font.BOLD,14));
		lprice=new JLabel("Product price :");
		lprice.setForeground(Color.red);
		lprice.setFont(new Font("Arial",Font.BOLD,14));
		linvent=new JLabel("Product inventory :");
		linvent.setForeground(Color.red);
		linvent.setFont(new Font("Arial",Font.BOLD,14));
		ldisc=new JLabel("Product discount :");
		ldisc.setForeground(Color.red);
		ldisc.setFont(new Font("Arial",Font.BOLD,14));
		
		b1=new JButton("ADD");
		b1.setBackground(Color.blue);
		b1.setForeground(Color.white);
		b1.addActionListener((e) ->{
			
			String ch1=tdescp.getText();
			String ch2=tprice.getText();
			String ch3=tprice.getText();
			String ch4=tinvent.getText();
			if((ch1.length()!=0)&&(ch2.length()!=0)&&(ch3.length()!=0)&&(ch4.length()!=0))
				addInformation();
			else
				JOptionPane.showMessageDialog(this, "All fields are mandatory and should not ne left blank");
			});
		
		b2 =new JButton("SHOW");
		b2.setBackground(Color.blue);
		b2.setForeground(Color.white);
		b2.addActionListener((e) ->{new Disp_Data();});
		
		b3 =new JButton("RESET");
		b3.setBackground(Color.blue);
		b3.setForeground(Color.white);
		b3.addActionListener((e) ->{resetFrame();});
		
		b4 =new JButton("BACK");
		b4.setBackground(Color.blue);
		b4.setForeground(Color.white);
		b4.addActionListener((e) ->{
			new Product_options("Product Options");
			dispose();
			});
		
		p2.add(b1);p2.add(b2);
		p3.add(b3);p3.add(b4);
		c.add(ldescp);c.add(tdescp);
		c.add(lprice);c.add(tprice);
		c.add(linvent);c.add(tinvent);
		c.add(ldisc);c.add(tdisc);
		//c.add(b1);c.add(b2);c.add(b3);c.add(b4);
		c.add(p1);
		c.add(p2);
		c.add(p4);
		c.add(p3);
		setSize(500,500);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(500,100);
		setResizable(false);
		
		
		
	}
	
	public void createRegObj(String bb)
	{//getting values from swing interface
		String id = null,descp,price,invent,disc;
		//if(a==0)
		id=bb;
		descp=tdescp.getText().trim();
		price=tprice.getText().trim();
		invent=tinvent.getText().trim();
		disc=tdisc.getText().trim();
		p=new Products(id,descp,price,invent,disc);
	}
	public void createRegObj(Products r)
	{
		String id = null,descp,price,invent,disc;
		StringBuilder s=new StringBuilder();
		
		int i=Integer.parseInt(r.getid().substring(3,6))+1;

		s.append("PR_");
		s.append(i);
		id=s.toString();
		descp=tdescp.getText().trim();
		price=tprice.getText().trim();
		invent=tinvent.getText().trim();
		disc=tdisc.getText().trim();
		p=new Products(id,descp,price,invent,disc);
	}

	public void addInformation()
	{   
		prodlist=Product_details.readDataFromFile();
		if(prodlist.size()==0)
		createRegObj(bb);
		else
		{
		int i=prodlist.size(),c=1;
	    for(Products r:prodlist){
	    if(c==i){
	    
	    createRegObj(r);
	    }
	    c++;
		}
	    
	    }
		prodlist.add(p);//it appends the data with previous one
		Product_details.writeDatatoFile(prodlist);
		JOptionPane.showMessageDialog(this, "Product added..");
		
		resetFrame();
	}
	
	public void resetFrame()
	{
		this.dispose();
		new Product_add("Product Details");
	}
	
	
	public static void main(String[] args)
	{
		new Product_add("Product Details");
	}

}
