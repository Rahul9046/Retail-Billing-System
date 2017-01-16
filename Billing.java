
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout; 
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener; 
import java.io.File;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;














import javax.swing.AbstractButton;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JButton; 
import javax.swing.JComboBox;
import javax.swing.JFrame; 
import javax.swing.JLabel; 
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField; 
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField; 
import javax.swing.event.DocumentListener;

	public class Billing extends JFrame 
	{  
		ArrayList<Products> list;
		ArrayList<Bill_generation> bill1;
		ArrayList<stock_class> bill2;
		private int check=0;
		
		private JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13,l14;		
		private String sysdate,systime;
		private JComboBox pname,pquan;
		private static JTextField txt=new JTextField(10); 
		
		static JTextField address=new JTextField(20);
		
		
		public Billing(String title) 
		{   
			
	    super("title");
		txt.setText("");
		address.setText("");
		txt.setEnabled(false);
		address.setEnabled(false);
		File f=new File("Bdetail.dat");
	     if(f.exists())
	    	f.delete();
		getContentPane();
		setLayout(new GridLayout(15,8));
			
			int r=0;
		
			list=Product_details.readDataFromFile();
			String data[]=new String[list.size()];
			String d[]=new String[20];
			for(Products re:list)
			{
				
				data[r]=re.getdescp();
				r++;
			}
			pname=new JComboBox(data);
			for(int i=1;i<=20;i++)
				d[i-1]=String.valueOf(i);
			pquan=new JComboBox(d);
			JPanel p1=new JPanel();
			JPanel p2=new JPanel();
			JPanel p3=new JPanel();
			JPanel p4=new JPanel();
			JPanel p5=new JPanel();
			JPanel p6=new JPanel();
		    JPanel p7=new JPanel();
		    JPanel p8=new JPanel();
		    JPanel p9=new JPanel();
		    JPanel p10=new JPanel();
		    
			
			

			JRadioButton mem = new JRadioButton("Member   ");
			mem.setForeground(Color.red);
			mem.setFont(new Font("Arial",Font.BOLD,14));
		     JRadioButton nonmem = new JRadioButton("Non Member  ");
		 	nonmem.setForeground(Color.red);
			nonmem.setFont(new Font("Arial",Font.BOLD,14));
		     ButtonGroup bG = new ButtonGroup();
		     bG.add(mem);
		     bG.add(nonmem);
		     
		     
			
			
					
			l1=new JLabel(); 
			l1.setText("	Name :  "); 
			l1.setForeground(Color.red);
			l1.setFont(new Font("Arial",Font.BOLD,14));
			//JTextField txt=new JTextField(10); 
						
			l2=new JLabel();
			l2.setText(" Address  : ");
			l2.setForeground(Color.red);
			l2.setFont(new Font("Arial",Font.BOLD,14));
			//JTextField address=new JTextField(10);
						
			l3=new JLabel();
			l3.setText("Credit");
			l3.setForeground(Color.red);
			l3.setFont(new Font("Arial",Font.BOLD,14));
			JTextField credit=new JTextField(5);
			l3.setEnabled(false);
			credit.setEnabled(false);
						
			l4=new JLabel();
			l4.setText("Bill No :");
			l4.setForeground(Color.red);
			l4.setFont(new Font("Arial",Font.BOLD,14));
			JLabel bill=new JLabel();
			
			bill2=stock.readDataFromFile();
			String bill_no="12345";
			if(bill2.size()==0)
			{
			bill.setText(bill_no);
			bill.setForeground(Color.black);
			bill.setFont(new Font("Arial",Font.BOLD,14));
			}
			else{
			int i=bill2.size(),c=1;
		    for(stock_class r4:bill2){
		    if(c==i){
		    String no=r4.getbill_no();
		    int inc=Integer.parseInt(no)+1;
		    StringBuilder build=new StringBuilder();
		    build.append(inc);
		    bill.setText(build.toString());
		    bill.setForeground(Color.black);
			bill.setFont(new Font("Arial",Font.BOLD,14));
		    
		    }
		    c++;
			}
			}
			

			l12=new JLabel(); 
			l12.setText("	"); 
			
			
			
			l14=new JLabel();
			l14.setText("    Enter id  ");
			l14.setForeground(Color.red);
			l14.setFont(new Font("Arial",Font.BOLD,14));
			l14.setEnabled(false);
			JTextField eid=new JTextField(6);
			eid.setEnabled(false);
			
			mem.addActionListener((e) ->{
				l14.setEnabled(true);
				eid.setEnabled(true);
				l3.setEnabled(true);
				credit.setEnabled(true);
				txt.setEditable(false);
				address.setEditable(false);
				credit.setEditable(false);
				});
			nonmem.addActionListener((e) ->{
				txt.setEnabled(true);
				address.setEnabled(true);
				l14.setEnabled(false);
				eid.setText("");
				eid.setEnabled(false);
				l3.setEnabled(false);
				credit.setEnabled(false);
				});
			
			eid.addActionListener((e) ->{
				String search=eid.getText(),id2;
				ArrayList<Members> list;
			    int flag=0;
				list=MemberFile.readDataFromFile();
				for(Members re:list)
				{
					id2=re.getid();
					if(search.equals(id2))
					{   flag=1;
						txt.setText(re.getname());
						address.setText(re.getadd());
						credit.setText(re.getcredit());
					}
				}
				
				if(flag==0)
				{
					JOptionPane.showMessageDialog(this, "Incorrect ID");
					
				}
				
			
				});
		
			
			p1.add(mem);
		    p1.add(nonmem);
		    p1.add(l14);
		    p1.add(eid);
		    p1.setLayout(new GridBagLayout());
			
			LocalDate today=LocalDate.now();
			int day=today.getDayOfMonth();
			int month=today.getMonthValue();
			int year=today.getYear();
			sysdate="          Date : "+day+"/"+month+"/"+year;
			l5=new JLabel(sysdate);
			l5.setForeground(Color.blue);
			l5.setFont(new Font("Arial",Font.BOLD,12));
			
			LocalTime time=LocalTime.now();
			int hr=time.getHour();
			int min=time.getMinute();
			int sec=time.getSecond();
			systime="      Time : "+hr+":"+min+":"+sec;
			l13=new JLabel(systime);
			l13.setForeground(Color.blue);
			l13.setFont(new Font("Arial",Font.BOLD,12));
			
			JButton logout=new JButton("LOGOUT");
			logout.setBackground(Color.red);
			logout.setForeground(Color.white);
			logout.addActionListener((e) ->{
				new Login("Login to continue");
				dispose();
				});
			
			p10.add(logout);
			
			JButton but=new JButton(); 
			but.setText("ADD");
			but.setBackground(Color.blue);
			but.setForeground(Color.white);
			
			
			
			JButton res=new JButton(); 
			res.setText("RESET");
			res.setBackground(Color.blue);
			res.setForeground(Color.white);
			
			JButton sub=new JButton(); 
			sub.setText("SUBMIT"); 
			sub.setBackground(Color.blue);
			sub.setForeground(Color.white);
			
			p2.add(l1); 
			p2.add(txt);
			
			p2.add(l2);
			p2.add(address); 
			
			p2.add(l3);
			p2.add(credit);
			
			p3.add(l4);
			p3.add(bill);
			
			p3.add(l5);
			p3.add(l13);
			
			
			
			l6=new JLabel();
			l6.setText("Item name");
			l6.setForeground(Color.black);
			l6.setFont(new Font("Arial",Font.BOLD,12));
			
			l7=new JLabel();
			l7.setText("Item code");
			l7.setForeground(Color.black);
			l7.setFont(new Font("Arial",Font.BOLD,12));
			
			l8=new JLabel();
			l8.setText("Price");
			l8.setForeground(Color.black);
			l8.setFont(new Font("Arial",Font.BOLD,12));
			
			l9=new JLabel();
			l9.setText("Qty");
			l9.setForeground(Color.black);
			l9.setFont(new Font("Arial",Font.BOLD,12));
			
			l10=new JLabel();
			l10.setText("Discount");
			l10.setForeground(Color.black);
			l10.setFont(new Font("Arial",Font.BOLD,12));
			
			l11=new JLabel();
			l11.setText("Discounted Price");
			l11.setForeground(Color.black);
			l11.setFont(new Font("Arial",Font.BOLD,12));
			
			
			
				
			JLabel item1=new JLabel();
			JLabel price1=new JLabel();
		    JLabel dis=new JLabel();
			JLabel disPrice=new JLabel();
			
			
			p5.add(l6);
			p5.add(l7);
			p5.add(l8);
			p5.add(l9);
			p5.add(l10);
			p5.add(l11);
			
			p5.add(pname);
			p5.add(item1);
			p5.add(price1);
			p5.add(pquan);
			p5.add(dis);
			p5.add(disPrice);
	
			
			p5.setLayout(new GridLayout(2,50));
			
			
			p6.add(but);
			
			
			p6.add(res);
			p6.add(sub);
			
		
			res.addActionListener((e)->{
				//this.dispose();
				new Billing("Billing interface"); 
				dispose();
				
			});
			
			sub.addActionListener((e) ->{
				String ch1=txt.getText();
				String ch2=address.getText();
				if((ch1.length()!=0)&&(ch2.length()!=0))
			   {
				stock_class so;
				JTextArea isld=new JTextArea(10,20);
				StringBuilder s=new StringBuilder();
				String n="@";
				Integer d1,m,y;
				String bno=bill.getText();
				String t=systime.substring(4,12);
				d1=today.getDayOfMonth();
				m=today.getMonthValue();
				y=today.getYear();
				String d2=d1.toString();
				String m1=m.toString();
				String y1=y.toString();
				bill1=Bill_details.readDataFromFile();
				bill2=stock.readDataFromFile();
				
				
				
				String data1[][];
				data1=new String[bill1.size()][6];
				int r1=0;
				for(Bill_generation re:bill1)
				{
					data1[r1][0]=re.getname();
					data1[r1][1]=re.getid();
					data1[r1][2]=re.getprice();
					
					data1[r1][3]=re.getquantity();
					
					data1[r1][4]=re.getdisc();
					
					data1[r1][5]=re.getdisc_price();
					r1++;
				}
				int r2=bill1.size();
				
				for(int i=0;i<r2;i++)
				{   String a=data1[i][1];
				    
				    String b=data1[i][3];
				    String c=data1[i][5];
				   
					s.append(a);
					s.append(n);
					s.append(b);
					s.append(n);
					s.append(c);
					s.append(n);
					
				}
				String s1=s.toString();
				so=new stock_class(bno,d2,m1,y1,t,s1);
				bill2.add(so);
				stock.writeDatatoFile(bill2);
				
				
				if(mem.isSelected()==true)
				{
					String search=eid.getText(),id;
					ArrayList<Members> mlist1,mlist2;
					mlist1=MemberFile.readDataFromFile();
					mlist2=new ArrayList<Members>();
					for(Members re:mlist1)
					{
						id=re.getid();
						if(search.equals(id))
						{
							Double cr1=Double.parseDouble(re.getcredit());
							Double cr2=Bill.total();
							if(cr1<cr2)
							{
							JOptionPane.showMessageDialog(this,"Total amount exceeds Member's limit !!!");
							check=1;
							new Billing("Billing Interface");
							dispose();
							}
							cr1-=cr2;
							StringBuilder s11=new StringBuilder();
							s11.append(cr1);
							re.setcredit(s11.toString());
							mlist2.add(re);
						}
						else
							mlist2.add(re);
						
					}
					MemberFile.writeDatatoFile(mlist2);
					if(check==0)
						new Bill("Retail bill");
					
					
				}
				else 
					new Bill("Retail bill");
				
			   }
				else
					JOptionPane.showMessageDialog(this, "All fields are mandatory and should not ne left blank");
				
				
				
				
				
				
				});
			
			
			
			
			
			
			but.addActionListener((e) ->{
				p8.removeAll();
				ArrayList<Products> list,list1;
				list1=new ArrayList<Products>();
				String pn=(String)pname.getSelectedItem();
				String pq=(String)pquan.getSelectedItem();
				int inv1 = 0,inv2 = 0,f2=0;
				StringBuilder s1=new StringBuilder();
				try
				{
					list=Product_details.readDataFromFile();
					
					for(Products re:list)
					{
						
						if(pn.equals(re.getdescp()))
						{   
							inv1=Integer.parseInt(re.getinvent());
							inv2=Integer.parseInt(pq);
							
						   
						if(inv2>inv1)
						{
							JOptionPane.showMessageDialog(this,"Exceeding limit..setting to its maximum availabe amount");
							f2=1;
							
						}
						   
							
							Bill_generation b;
							String name,id,price,quantity,disc,disc_price;
							name=(String)pname.getSelectedItem();
							id=item1.getText();
							price=price1.getText();
							if(f2==0)
							quantity=(String)pquan.getSelectedItem();
							
							else
							{
						    quantity=re.getinvent();
						    inv2=inv1;	
							}
							disc=dis.getText();
							disc_price=disPrice.getText();
							b=new Bill_generation(name,id,price,quantity,disc,disc_price);
							bill1=Bill_details.readDataFromFile();
							bill1.add(b);
							Bill_details.writeDatatoFile(bill1);
							String heading[]={"Name","ID","Price","Quantity","Discount","Discounted price"};
							
							ArrayList<Bill_generation> bill3;
							
								bill3=Bill_details.readDataFromFile();
								String data1[][];
								data1=new String[bill3.size()][6];
								int r1=0;
								for(Bill_generation re1:bill3)
								{
									data1[r1][0]=re1.getname();
									data1[r1][1]=re1.getid();
									data1[r1][2]=re1.getprice();
									
									data1[r1][3]=re1.getquantity();
									
									data1[r1][4]=re1.getdisc();
								
									
									data1[r1][5]=re1.getdisc_price();
									r1++;
								}
								
								
								
								JTable datatable=new JTable(data1,heading);
								datatable.setFillsViewportHeight(true);
							
								JScrollPane jsp=new JScrollPane(datatable);
								
								
								
						          p8.add(jsp);
						          p8.setSize(500,500);
						          p8.setVisible(false);
						          p8.setVisible(true);
						          inv1-=inv2;
								  s1.append(inv1);
							      String update=s1.toString();
							      //JOptionPane.showMessageDialog(this,re.getinvent());
								  re.setinvent(update);
						          list1.add(re);
						          
						

						
						}
						else
							list1.add(re);
							
						}

					/*File f1=new File("Pdetail.dat");
				     if(f1.exists())
				    	f1.delete();*/
					Product_details.writeDatatoFile(list1);
					}
				catch(Exception e1)
				{
					e1.printStackTrace();
				}
				
				
			
				
				});
		
			
			pname.addActionListener((e) ->{
				String search=(String)pname.getSelectedItem();
	            String s,disc;
				ArrayList<Products> list;
			    dis.setText("");
			    disPrice.setText("");
				try
				{
					list=Product_details.readDataFromFile();
					
					
					for(Products re:list)
					{   
						s=re.getdescp();
						
						if(s.equals(search))
						{
							item1.setText(re.getid());
							price1.setText(re.getprice());
							//dis.setText(re.getprice());
							disc=re.getdisc();
							//JOptionPane.showMessageDialog(this,disc);
							if(mem.isSelected()==true)
							{   StringBuilder s1=new StringBuilder();
								int i=Integer.parseInt(disc);
								i+=5;
								s1.append(i);
								disc=s1.toString();
								dis.setText(disc);
						    }
							else 
								dis.setText(re.getdisc());
								
						   
							
						}
						
					}
				}
					catch(Exception g)
					{
						g.printStackTrace();
					}
					
				});
			
			pquan.addActionListener((e) ->{
				
				String s=(String)pquan.getSelectedItem();
				String a;
				a=price1.getText();
				Double p=Double.parseDouble(a);
				a=dis.getText();
				Double d1=Double.parseDouble(a);
				Double q=Double.parseDouble(s);
				Double dis_price=(p*q)-((p*q)*(d1/100));
				StringBuilder s1=new StringBuilder();
				s1.append(dis_price);
				s=s1.toString();
				disPrice.setText(s);
					
				
				});
			
			
			
			
			
			
			
			 
			
			add(p1);
			add(p2);
			add(p3);
			add(p5);
			
			add(p6);
			setLayout(new FlowLayout());
			add(p8);
			add(p9);
			add(p10);
	
			setLocation(450,0);
			setSize(700,2000); 
			setVisible(true); 
			setDefaultCloseOperation(EXIT_ON_CLOSE); 
			setResizable(false);
			
			} 
		static String gname()
		{
			return txt.getText();
		}
		static String gadd()
		{
			return address.getText();
		}
		public static void main(String args[]) 
		{ 
			new Billing("Billing interface"); 
			} 
		}

