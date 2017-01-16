
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;


public class Last_month extends JFrame{

	public Last_month(String title)
	{
		super(title);
		JLabel l1,l2,l3;
		JButton b1=new JButton("BACK");
		l1=new JLabel("Total : ");
		l1.setForeground(Color.red);
		l1.setFont(new Font("Arial",Font.BOLD,14));
		l2=new JLabel("");
		l2.setFont(new Font("Arial",Font.BOLD,13));
		l3=new JLabel("Selling details of last month");
		l3.setForeground(Color.red);
		l3.setFont(new Font("Arial",Font.BOLD,13));
		int r=0;
		String s1,s3;
		
		JPanel p1=new JPanel();
	    JPanel p2=new JPanel();
	    JPanel p3=new JPanel();
	    JPanel p4=new JPanel();
		
	    b1.setBackground(Color.blue);
		b1.setForeground(Color.white);
		b1.addActionListener((e) ->{
			new Check("Select a category");
			dispose();
			});
		p4.add(b1);
		
		Container con=getContentPane();
		con.setLayout(new GridLayout(4,2));
		
		
		String heading[]={"Product name","Items sold"};
		ArrayList<Products> list;
		list=Product_details.readDataFromFile();
		String data[][]=new String[list.size()][2];
		ArrayList<stock_class> list1;
		list1=stock.readDataFromFile();
		double s=0;
		String data1[][]=new String[list1.size()][6];
		String values[]=new String[3*(list1.size())];
	
		
		for(Products re:list)
		{
			
			data[r][0]=re.getdescp();
			data[r][1]="0";
			int r1=0;
		
			for(stock_class ro:list1)
			{
				data1[r1][0]=ro.getbill_no();
				data1[r1][1]=ro.getday();
				data1[r1][2]=ro.getmon();
				data1[r1][3]=ro.getyear();
				data1[r1][4]=ro.gettime();
				data1[r1][5]=ro.getitems_sold();
				
		    LocalDate today=LocalDate.now();	
		    int month=today.getMonthValue();
		    //JOptionPane.showMessageDialog(this,month);
		    month-=1;
			StringBuilder s2=new StringBuilder();
			s2.append(month);
			s3=s2.toString();
			
			s1=data1[r1][5];
			values=s1.split("@");
			for(int i=0;i<(values.length);i+=3)
			{   
				StringBuilder s21=new StringBuilder();
				if(values[i].equals(data[r][0])&& s3.equals(data1[r1][2]))
				{
					int j=Integer.parseInt(values[i+1]);
					int k=Integer.parseInt(data[r][1]);
					j=j+k;
					s=s+Double.parseDouble(values[i+2]);
					s21.append(j);
					data[r][1]=s21.toString();
							
				}
			}
			r1++;
			}
			r++;
		}
		StringBuilder s2=new StringBuilder();
		s2.append(s);
		l2.setText(s2.toString());
		
		JTable datatable=new JTable(data,heading);
		datatable.setBackground(Color.yellow);
		JScrollPane jsp=new JScrollPane(datatable);
		p1.add(l3,BorderLayout.NORTH);
		p1.add(jsp,BorderLayout.CENTER);
		//con.setLayout(new GridLayout(1,5));
		p2.add(l1);
		p2.add(l2);
		con.add(p3);
		con.add(p1);
		con.add(p2);
		con.add(p4);
		setSize(500,700);
		setVisible(true);
		setLocation(500,50);
		setResizable(false);
		
		
		
	}
	
	
	

public static void main(String[] args)
{
	new Last_month("Last month sales");
}

}

