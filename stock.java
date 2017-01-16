

import java.io.*;
import java.util.ArrayList;

public class stock
{
  public static ArrayList<stock_class> readDataFromFile()
  {
	  ArrayList<stock_class> bill;	  
		  
  try
  {
	  FileInputStream fin=new FileInputStream("Stock.dat");
	  ObjectInputStream oin=new ObjectInputStream(fin);
	  bill =(ArrayList<stock_class>)oin.readObject();
	  oin.close();
	  fin.close();	  
  }
  catch(Exception e)
  {
	  bill=new ArrayList<stock_class>();
  }
  return bill;
 }
  public static void writeDatatoFile(ArrayList<stock_class> wlist)
  {
	  try
	  {
		  FileOutputStream fout=new FileOutputStream("Stock.dat");
		  ObjectOutputStream oout=new ObjectOutputStream(fout);
		  oout.writeObject(wlist);
		  oout.close();	  
	  }
	  catch(Exception e)
	  {
		  System.out.println(e);
	  }
  }
}
