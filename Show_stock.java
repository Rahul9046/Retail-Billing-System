
import java.awt.*;
import java.awt.Container;
import java.util.ArrayList;

import javax.swing.*;

public class Show_stock extends JFrame//because we have to display it in a new window so frame is needed
{
	public Show_stock(String title)
	{
		super(title);
		String heading[]={"Bill no.","Day","Month","Year","Time","Items_sold"};
		String data[][];
		ArrayList<stock_class> list;
		try
		{
			list=stock.readDataFromFile();
			data=new String[list.size()][6];
			int r=0;
			for(stock_class re:list)
			{
				data[r][0]=re.getbill_no();
				data[r][1]=re.getday();
				data[r][2]=re.getmon();
				data[r][3]=re.getyear();
				data[r][4]=re.gettime();
				data[r][5]=re.getitems_sold();
				r++;
			}
			Container con=getContentPane();
			con.setLayout(new BorderLayout());
			JTable datatable=new JTable(data,heading);
			JScrollPane jsp=new JScrollPane(datatable);
			con.add(new JLabel("All Registration details"),BorderLayout.NORTH);
			con.add(jsp,BorderLayout.PAGE_END);
			setSize(500,500);
			setLocation(200,200);
			setVisible(true);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public static void main(String args[])
	{
		new Show_stock("Display all");
	}

}
