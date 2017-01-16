

import java.io.*;
import java.util.ArrayList;

public class Product_details 
{
  public static ArrayList<Products> readDataFromFile()
  {
	  ArrayList<Products> list;	  
		  
  try
  {
	  FileInputStream fin=new FileInputStream("Pdetail.dat");
	  ObjectInputStream oin=new ObjectInputStream(fin);
	  list =(ArrayList<Products>)oin.readObject();
	  oin.close();
	  fin.close();	  
  }
  catch(Exception e)
  {
	  list=new ArrayList<Products>();
  }
  return list;
 }
  public static void writeDatatoFile(ArrayList<Products> wlist)
  {
	  try
	  {
		  FileOutputStream fout=new FileOutputStream("Pdetail.dat");
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
