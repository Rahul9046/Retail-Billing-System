

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Member_search extends JFrame {
	public void search(String search1)
	{   
		String s;
		int flag=0;
		ArrayList<Members> list,list1;
		list1=new ArrayList<Members>();
		try
		{
			list=MemberFile.readDataFromFile();
			
			
			for(Members re:list)
			{   
				s=re.getid();
				
				if(!(s.equals(search1)))
				{
					
				    list1.add(re);
					
				}
				else
					flag=1;
			}	
			
			if(flag==1)
			{
				JOptionPane.showMessageDialog(this, "Member deleted..");
				new Member_del("Member deletion");
			}
			else
			{
				JOptionPane.showMessageDialog(this, "Member not found..");
				new Member_del("Member deletion");
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		MemberFile.writeDatatoFile(list1);
	
}

}
