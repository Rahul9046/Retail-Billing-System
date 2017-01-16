
import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;

public class DisplayDetails extends JFrame//because we have to display it in a new window so frame is needed
{
	public DisplayDetails()
	{
		super("Display All");
		String heading[]={"ID","Name","Address","Phn no.","Credit"};
		String data[][];
		ArrayList<Members> list;
		try
		{
			list=MemberFile.readDataFromFile();
			data=new String[list.size()][5];
			int r=0;
			for(Members re:list)
			{
				data[r][0]=re.getid();
				data[r][1]=re.getname();
				data[r][2]=re.getadd();
				data[r][3]=re.getphn();
				data[r][4]=re.getcredit();
				r++;
			}
			Container con=getContentPane();
			con.setLayout(new BorderLayout());
			JTable datatable=new JTable(data,heading);
			datatable.setBackground(Color.yellow);
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

}
