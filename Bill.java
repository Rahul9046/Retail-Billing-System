
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;


public class Bill extends JFrame{
private static double s=0;	
private static final String String = null;

@SuppressWarnings("null")
public Bill(String title)
{
    
	super(title);
	String sysdate,systime;
	JPanel p1=new JPanel();
	JPanel p2=new JPanel();
	JPanel p3=new JPanel();
	JPanel p4=new JPanel();
	JPanel p5=new JPanel();
	ArrayList<Bill_generation> bill3;
	bill3=Bill_details.readDataFromFile();
	

	getContentPane();
	setLayout(new GridLayout(10,4));
	

	JLabel l1,l2 ,l3,l4,l5,l6,l7,l8,l9,l10,l12,l13;
	l1=new JLabel("Bill no. :");
	l1.setForeground(Color.red);
	l1.setFont(new Font("Arial",Font.BOLD,22));
	l2=new JLabel();
	
	l2.setFont(new Font("Arial",Font.BOLD,20));
	l3=new JLabel("Name :");
	l3.setForeground(Color.red);
	l3.setFont(new Font("Arial",Font.BOLD,22));
	l5=new JLabel("Address :");
	l5.setForeground(Color.red);
	l5.setFont(new Font("Arial",Font.BOLD,20));
	l8=new JLabel("Billing Details :");
	l8.setFont(new Font("Arial",Font.BOLD,22));
	l9=new JLabel("Total :");
	l9.setForeground(Color.red);
	l9.setFont(new Font("Arial",Font.BOLD,22));
	l10=new JLabel("   ");
	String heading[]={"Items","Quantity","Price"};
	
	l4=new JLabel(Billing.gname());
	l4.setFont(new Font("Arial",Font.BOLD,20));
	l6= new JLabel(Billing.gadd());
	l6.setFont(new Font("Arial",Font.BOLD,20));
	ArrayList<Products> list;
	list=Product_details.readDataFromFile();
	String data[][]=new String[bill3.size()][3];
	ArrayList<stock_class> list1;
	list1=stock.readDataFromFile();
	String values[]=new String[3*(bill3.size())];
	
	LocalDate today=LocalDate.now();
	int day=today.getDayOfMonth();
	int month=today.getMonthValue();
	int year=today.getYear();
	sysdate="          Date : "+day+"/"+month+"/"+year;
	l12=new JLabel(sysdate);
	l12.setForeground(Color.blue);
	l12.setFont(new Font("Arial",Font.BOLD,12));
	
	LocalTime time=LocalTime.now();
	int hr=time.getHour();
	int min=time.getMinute();
	int sec=time.getSecond();
	systime="      Time : "+hr+":"+min+":"+sec;
	l13=new JLabel(systime);
	l13.setForeground(Color.blue);
	l13.setFont(new Font("Arial",Font.BOLD,12));
	
	int size=list1.size(),c1=0,r1=1;
	
	String data1[]=new String[2];
	for(stock_class ro:list1)
		{
		if(r1==size)
		{
		
			data1[0]=ro.getbill_no();
			data1[1]=ro.getitems_sold();
			l2.setText(data1[0]);
   
	StringBuilder s21=new StringBuilder();
	String s1=data1[1];
	values=s1.split("@");
	for(int i=0,j=0;i<3*(bill3.size())&&j<bill3.size();i+=3,j++)
	{   
		data[j][0]=values[i];
		data[j][1]=values[i+1];
		data[j][2]=values[i+2];
		s=s+Double.parseDouble(values[i+2]);
		
	}
	s21.append(s);
	l10=new JLabel(s21.toString());
	l10.setFont(new Font("Arial",Font.BOLD,20));
	}
		r1++;
		}
	
	p1.add(l1);p1.add(l2);p1.add(l12);p1.add(l13);
	p2.add(l3);p2.add(l4);
	p3.add(l5);p3.add(l6);
	JTable datatable=new JTable(data,heading);
	//datatable.setBackground(Color.yellow);
	JScrollPane jsp=new JScrollPane(datatable);
	jsp.setSize(200,1000);
	p5.add(l9);p5.add(l10);
	
	add(p1);
	add(p2);
	add(p3);
	add(l8,BorderLayout.NORTH);
	add(jsp,BorderLayout.PAGE_END);

	add(p5);

	
	
	//p1.setBackground(Color.yellow);
	//p2.setBackground(Color.yellow);
	//p3.setBackground(Color.yellow);
	//p4.setBackground(Color.yellow);
	//p5.setBackground(Color.yellow);
	
	setSize(600,900);
	setLocation(800,100);
	setVisible(true);
	setLocation(450,0);
	setResizable(false);
	
}
public static double total()
{
	
	return s;
	
	
}

public static void main(String[] args)
{
	new Bill("Retail bill");
}

}

