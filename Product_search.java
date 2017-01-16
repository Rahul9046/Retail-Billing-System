

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Product_search extends JFrame {
	public void search(String search1)
	{   
		String s;
		int flag=0;
		ArrayList<Products> list,list1;
		list1=new ArrayList<Products>();
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
				else
					flag=1;
			}	
			
			if(flag==1)
			{
				JOptionPane.showMessageDialog(this, "Product deleted..");
				new Product_del("Product deletion");
			}
			else
			{
				JOptionPane.showMessageDialog(this, "Product not found..");
				new Product_del("Product deletion");
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		Product_details.writeDatatoFile(list1);
	
}

}
