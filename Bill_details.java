

import java.io.*;
import java.util.ArrayList;

public class Bill_details
{
  public static ArrayList<Bill_generation> readDataFromFile()
  {
	  ArrayList<Bill_generation> bill;	  
		  
  try
  {
	  FileInputStream fin=new FileInputStream("Bdetail.dat");
	  ObjectInputStream oin=new ObjectInputStream(fin);
	  bill =(ArrayList<Bill_generation>)oin.readObject();
	  oin.close();
	  fin.close();	  
  }
  catch(Exception e)
  {
	  bill=new ArrayList<Bill_generation>();
  }
  return bill;
 }
  public static void writeDatatoFile(ArrayList<Bill_generation> wlist)
  {
	  try
	  {
		  FileOutputStream fout=new FileOutputStream("Bdetail.dat");
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
