
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Check extends JFrame
{
	private JButton b1=new JButton("Proceed");
	private JButton b2=new JButton("Back");
    public Check(String title)
    {
    	
    	super(title);
    	b1.setBackground(Color.blue);
		b1.setForeground(Color.white);
		b2.setBackground(Color.blue);
		b2.setForeground(Color.white);
    	Icon Available_ProductString = null;
    	Icon LastDay_SellString = null;
    	Icon Weekly_SellString = null;
    	Icon Monthly_SellString = null;

        
    	Container c = getContentPane();
         c.setLayout(new FlowLayout());
         JPanel p=new JPanel();
    	
        
    	JRadioButton Available_ProductButton= new JRadioButton(Available_ProductString);
        //Available_ProductButton.setSelected(true);
        
       

		JRadioButton LastDay_SellButton= new JRadioButton(LastDay_SellString);
		//JRadioButton Weekly_SellButton= new JRadioButton(Weekly_SellString);
		JRadioButton Monthly_SellButton= new JRadioButton(Monthly_SellString);
		
		b1.addActionListener((e) ->{
			if(Available_ProductButton.isSelected()==true)
			{
				new Availabe("Product Inventory");
				dispose();
				
			}
			if(LastDay_SellButton.isSelected()==true)
			{
				new Last_day("Last day sells");
				dispose();
			}
			if(Monthly_SellButton.isSelected()==true)
			{
				new Last_month("Last month sells");
				dispose();
			}
			
			});

		
		b2.addActionListener((e) ->{
			new Management("Management");
			dispose();
			});

		
        ButtonGroup group = new ButtonGroup();
        group.add(Available_ProductButton);
        group.add(LastDay_SellButton);
        group.add(Monthly_SellButton);
       // group.add(Weekly_SellButton);
        JLabel label1 = new JLabel("Available_Product");
        label1.setForeground(Color.red);
    	label1.setFont(new Font("Arial",Font.BOLD,12));
        
        JLabel label2 = new JLabel("Last Day Sell");
        label2.setForeground(Color.red);
    	label2.setFont(new Font("Arial",Font.BOLD,12));
 
        //JLabel label3 = new JLabel("Weekly_Sell");
        
        JLabel label4 = new JLabel("Last Month Sell");
        label4.setForeground(Color.red);
    	label4.setFont(new Font("Arial",Font.BOLD,12));
        
              
        c.add(Available_ProductButton);
        c.add(label1);
        c.add(LastDay_SellButton);
        c.add(label2);
       // c.add(Weekly_SellButton);
        //c.add(label3);
        c.add(Monthly_SellButton);
        c.add(label4);
        //c.setLayout(new GridLayout(2,3));
        p.add(b1);
        p.add(b2);
        c.add(p);
        
        setSize(500,100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setLocation(450,250);
    	setResizable(false);
    }
   
	public static void main(String args[])
    {
     Check ob=new Check("Selaect a category");	
    }
}
