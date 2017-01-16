

import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;

public class Disp_Data extends JFrame//because we have to display it in a new window so frame is needed
{
	public Disp_Data()
	{
		super("Display All");
		String heading[]={"Product ID","Description","Price","Inventory","Discount in %"};
		String data[][];
		ArrayList<Products> list;
		try
		{
			list=Product_details.readDataFromFile();
			data=new String[list.size()][5];
			int r=0,l=list.size();
			for(Products re:list)
			{
				data[r][0]=re.getid();
				data[r][1]=re.getdescp();
				data[r][2]=re.getprice();
				data[r][3]=re.getinvent();
				data[r][4]=re.getdisc();
				r++;
			}
			Container con=getContentPane();
			con.setLayout(new BorderLayout());
			JTable datatable=new JTable(data,heading);
			datatable.setBackground(Color.yellow);
			JScrollPane jsp=new JScrollPane(datatable);
			con.add(new JLabel("All Product details"),BorderLayout.NORTH);
			con.add(jsp,BorderLayout.CENTER);
			setSize(500,500);
			setLocation(200,200);
			setVisible(true);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
