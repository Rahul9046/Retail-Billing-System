
import java.awt.Color;
import java.awt.Container;
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


public class Membership extends JFrame {
	private JButton b1,b2,b3;
	private JTextField tid,tname,tphn,tcredit;
	private JTextArea tadd;
	private JLabel lid,lname,ladd,lphn,lcredit;
	ArrayList<Members> memberlist;
	Members m;
	String bb="ME_123";
	public Membership(String title)
	{
		super(title);
		Container c=getContentPane();
		c.setLayout(new GridLayout(7,2));
		//tid=new JTextField(20);
		JPanel p=new JPanel();
		JPanel p1=new JPanel();
		JPanel p2=new JPanel();
		JPanel p3=new JPanel();
		tname=new JTextField(20);
		tadd=new JTextArea(5,20);
		tcredit=new JTextField(20);
		tphn=new JTextField(10);
		JScrollPane t=new JScrollPane(tadd);
		//lid=new JLabel("Member ID :");
		lname=new JLabel("Member Name :");
		lname.setForeground(Color.red);
		lname.setFont(new Font("Arial",Font.BOLD,14));
		ladd=new JLabel("Member Address :");
		ladd.setForeground(Color.red);
		ladd.setFont(new Font("Arial",Font.BOLD,14));
		lphn=new JLabel("Member phone no. :");
		lphn.setForeground(Color.red);
		lphn.setFont(new Font("Arial",Font.BOLD,14));
		lcredit=new JLabel("Member Credit :");
		lcredit.setForeground(Color.red);
		lcredit.setFont(new Font("Arial",Font.BOLD,14));
		
		b1=new JButton("ADD");
		b1.setBackground(Color.blue);
		b1.setForeground(Color.white);
		b1.addActionListener((e) ->{
			String ch1=tname.getText();
			String ch2=tphn.getText();
			String ch3=tadd.getText();
			String ch4=tcredit.getText();
			
			//if(ch2.length()!=10)
				//JOptionPane.showMessageDialog(this, "Phone number should be 10 digits");
			
			if((ch1.length()!=0)&&(ch2.length()!=0)&&(ch3.length()!=0)&&(ch4.length()!=0))
			{
				if(ch2.length()==10)
				{
					try{
						double i=Double.parseDouble(ch2);	
						addInformation();
						}
						catch(Exception x){
							JOptionPane.showMessageDialog(this, "Phone number should be numeric");
						}
				}
				//addInformation();
				else
					JOptionPane.showMessageDialog(this, "Phone number should be 10 digits");	
			}
			else 
				JOptionPane.showMessageDialog(this, "All fields are mandatory and should not ne left blank");

			
			
			});
		
		b2 =new JButton("Show All Records");
		b2.setBackground(Color.blue);
		b2.setForeground(Color.white);
		b2.addActionListener((e) ->{new DisplayDetails();});
		
		b3=new JButton("BACK");
		b3.setBackground(Color.blue);
		b3.setForeground(Color.white);
		b3.addActionListener((e) ->{
			new Member_options("Member options");
			dispose();
			});
		p1.add(b1);
		p1.add(b2);
		p.add(b3);
		//c.add(lid);c.add(tid);
		c.add(lname);c.add(tname);
		c.add(ladd);c.add(t);
		c.add(lphn);c.add(tphn);
		c.add(lcredit);c.add(tcredit);
		//c.add(b1);c.add(b2);
		c.add(p3);
		c.add(p1);
		c.add(p2);
		c.add(p);
		
		setSize(500,350);
	    setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(500,200);
		setResizable(false);
		
		
		
	}
	public void createRegObj(String bb)
	{//getting values from swing interface
		String id,name,add,phn,credit;
		//if(a==0)
		id=bb;
		name=tname.getText().trim();
		add=tadd.getText().trim();
		phn=tphn.getText().trim();
		credit=tcredit.getText().trim();
		m=new Members(id,name,add,phn,credit);//JOptionPane.showMessageDialog(this, "First record");
	}
	public void createRegObj(Members r)
	{
		String id,name,add,phn,credit;
		StringBuilder s=new StringBuilder();
		
		int i=Integer.parseInt(r.getid().substring(3,6))+1;

		s.append("ME_");
		s.append(i);
		id=s.toString();
		name=tname.getText().trim();
		add=tadd.getText().trim();
		phn=tphn.getText().trim();
		credit=tcredit.getText().trim();
		m=new Members(id,name,add,phn,credit);//JOptionPane.showMessageDialog(this, "First record");
	}

	


	public void addInformation()
	{
		memberlist=MemberFile.readDataFromFile();
		if(memberlist.size()==0)
		createRegObj(bb);
		else
		{
		int i=memberlist.size(),c=1;
	    for(Members r:memberlist){
	    if(c==i){
	    
	    createRegObj(r);
	    }
	    c++;
		}
	    
	    }
		memberlist.add(m);//it appends the data with previous one
		MemberFile.writeDatatoFile(memberlist);
		JOptionPane.showMessageDialog(this, "Member added..");
		/*if(userlist.size()==1)
		*/
		resetFrame();
	}
	
	public void resetFrame()
	{
		this.dispose();
		new Membership("Membership Details");
	}
	
	
	public static void main(String[] args)
	{
		new Membership("Membership Details");
	}

}
