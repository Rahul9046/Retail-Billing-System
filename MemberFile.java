

import java.io.*;
import java.util.ArrayList;

public class MemberFile 
{
  public static ArrayList<Members> readDataFromFile()
  {
	  ArrayList<Members> list;	  
		  
  try
  {
	  FileInputStream fin=new FileInputStream("Mdetail.dat");
	  ObjectInputStream oin=new ObjectInputStream(fin);
	  list =(ArrayList<Members>)oin.readObject();
	  oin.close();
	  fin.close();	  
  }
  catch(Exception e)
  {
	  list=new ArrayList<Members>();
  }
  return list;
 }
  public static void writeDatatoFile(ArrayList<Members> wlist)
  {
	  try
	  {
		  FileOutputStream fout=new FileOutputStream("Mdetail.dat");
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
