import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class Member_edit extends JFrame{
	String data[],id1,id2;
	int r=0;
	
	private JTextField tid,tname,tphn,tcredit,tadd;
	
	//private JTextArea tadd;
	private JButton b1,b2,b3,logout;
	private JLabel l1,l2,l3;
	Member_edit(String title)
	{
		super(title);
		Container c1=getContentPane();
		c1.setLayout(new GridLayout(10,8));
		Container c2=getContentPane();
		c2.setLayout(new GridLayout(10,8));
		JPanel p1=new JPanel();
		JPanel p2=new JPanel();
		JPanel p3=new JPanel();
		JPanel p4=new JPanel();
		JPanel p5=new JPanel();
		JPanel p6=new JPanel();
		JPanel p7=new JPanel();
		JPanel p8=new JPanel();
		
		tid=new JTextField(20);
		
		tname=new JTextField(20);
		tname.setEnabled(false);
		tphn=new JTextField(20);
		tphn.setEnabled(false);
		tcredit=new JTextField(20);
		tcredit.setEnabled(false);
		tadd=new JTextField(30);
		tadd.setEnabled(false);
		//JScrollPane t=new JScrollPane(tadd);
		
		l1=new JLabel("Enter the Member ID:");
		l1.setForeground(Color.red);
		l1.setFont(new Font("Arial",Font.BOLD,13));
		l2=new JLabel("");
		l3=new JLabel("Member name                     Member address                    Member phn no.                 Member credit");
		l3.setForeground(Color.red);
		l3.setFont(new Font("Arial",Font.BOLD,12));
		
		b1=new JButton("EDIT");
		b1.setBackground(Color.blue);
		b1.setForeground(Color.white);
		
		b2=new JButton("SAVE");
		b2.setBackground(Color.blue);
		b2.setForeground(Color.white);
		b2.setEnabled(false);
		
		b1.addActionListener((e) ->{search();});
		b2.addActionListener((e) ->{
			String ch1=tname.getText();
			String ch2=tphn.getText();
			String ch3=tcredit.getText();
			String ch4=tadd.getText();
			
			if((ch1.length()!=0)&&(ch2.length()!=0)&&(ch3.length()!=0)&&(ch4.length()!=0))
			{
				if(ch2.length()==10)
				{
				try{
				double i=Double.parseDouble(ch2);	
				update();
				}
				catch(Exception x){
					JOptionPane.showMessageDialog(this, "Phone number should be numeric");
				}
				}
				else
					JOptionPane.showMessageDialog(this, "Phone number should be 10 digits");	
			}
			else 
				JOptionPane.showMessageDialog(this, "All fields are mandatory and should not ne left blank");

		});
		
		b3=new JButton("BACK");
		b3.setBackground(Color.blue);
		b3.setForeground(Color.white);
		b3.addActionListener((e) ->{
			new Member_options("Member options");
			dispose();
			});
		
		logout=new JButton("LOGOUT");
		logout.setBackground(Color.red);
		logout.setForeground(Color.white);
		logout.addActionListener((e) ->{
			new Login("Login to continue");
			dispose();
			});
		
		p1.add(l1);
		p1.add(tid);
		p1.setLayout(new GridLayout(2,5));
		p1.setPreferredSize(new Dimension(300,250));
		
		tname.setText("NAME");
		tadd.setText("ADDRESS");
		tphn.setText("PHN No.");
		tcredit.setText("CREDIT");
		
		
		p2.add(tname);
		p2.add(tadd);
		p2.add(tphn);
		p2.add(tcredit);
		//p2.setEnabled(false);
		p2.setLayout(new GridLayout(1,5));
		p2.setPreferredSize(new Dimension(300,350));
		
		p3.add(b2);
		p3.add(b3);
		
		
		p4.add(l2);
		
		p5.add(b1);
		
		p6.add(l3);
		
		p8.add(logout);
		
		c1.add(p1);
		c1.add(p5);
		c1.add(p4);
		c1.add(p4);
		c1.add(p4);
		c1.add(p4);
		c2.add(p6);
		c2.add(p2);
		c2.add(p3);
		c2.add(p7);
		c2.add(p8);

		
		
		
		setSize(600,500);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(500,100);
		setResizable(false);
		
	}
	public void search()
	{   ArrayList<Members> list;
	    int flag=0;
		id1=tid.getText();
		list=MemberFile.readDataFromFile();
		for(Members re:list)
		{
			id2=re.getid();
			if(id1.equals(id2))
			{   flag=1;
				tname.setText(re.getname());
				tname.setEnabled(true);
				tadd.setText(re.getadd());
				tadd.setEnabled(true);
				tphn.setText(re.getphn());
				tphn.setEnabled(true);
				tcredit.setText(re.getcredit());
				tcredit.setEnabled(true);
				b2.setEnabled(true);
				
			}
		}
		if(flag==0)
		{
			JOptionPane.showMessageDialog(this, "Incorrect ID");
			new Member_edit("Edit Member Details");
			dispose();
		}
		
	}
	public void update()
	{
		ArrayList<Members> list,list1;
		list1=new ArrayList<Members>();
		String s,search1;
		search1=tid.getText();
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
				else{
					re.setname(tname.getText());
				    re.setadd(tadd.getText());
				    re.setphn(tphn.getText());
				    re.setcredit(tcredit.getText());
				    list1.add(re);
				}
			}
				MemberFile.writeDatatoFile(list1);
				JOptionPane.showMessageDialog(this, "Member edited");
				new Member_edit("Edit Member Details");
				dispose();
				    
			}	
		catch(Exception e)
		{
			e.printStackTrace();
		}
			
		
		
	}
	public static void main(String args[])
	{
		new Member_edit("Edit Member Details");
	}
	

}
