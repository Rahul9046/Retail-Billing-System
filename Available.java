import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

 public class Availabe extends JFrame
    {   public Availabe(String title){
    	
        super(title);
    	String heading[]={"Product ID","Description","Inventory"};
		String data[][];
		JPanel p1=new JPanel();
		JPanel p2=new JPanel();
		JLabel l1=new JLabel("Product inventory :");
		l1.setForeground(Color.red);
		l1.setFont(new Font("Arial",Font.BOLD,14));
		JButton b=new JButton("BACK");
		b.setBackground(Color.blue);
		b.setForeground(Color.white);
		
		b.addActionListener((e) ->{
			new Check("Select a category");
			dispose();
		});
		p2.add(b);
		ArrayList<Products> list;
		try
		{
			list=Product_details.readDataFromFile();
			data=new String[list.size()][3];
			int r=0,l=list.size();
			for(Products re:list)
			{
				data[r][0]=re.getid();
				data[r][1]=re.getdescp();
			
				data[r][2]=re.getinvent();
				
				r++;
			}
			Container con=getContentPane();
			con.setLayout(new GridLayout(4,3));
			JTable datatable=new JTable(data,heading);
			datatable.setBackground(Color.yellow);
			JScrollPane jsp=new JScrollPane(datatable);
			con.add(l1,BorderLayout.NORTH);
			con.add(jsp,BorderLayout.CENTER);
			con.add(p1);
			con.add(p2);
			setSize(850,500);
			setLocation(250,100);
			setVisible(true);
        }
		catch(Exception e)
		{
			e.printStackTrace();
		}
    }
    public static void main(String args[])
    {
    	new Availabe("Product inventory");
    }
    }
