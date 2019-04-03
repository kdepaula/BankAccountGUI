import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
/**
 * AP Computer Science Period 7
 * Katelyn DePaula
 * @author kdepaula20
 *
 */
public class Frame extends JFrame
{
	
	public Frame()
	{
		ArrayList <BankAccount> accList = new ArrayList<BankAccount>();
		setTitle("Katelyn's Bank");
		setBounds(500, 200, 400, 250);
		
		CardLayout cl = new CardLayout();
		JPanel overall = new JPanel();
		overall.setLayout(cl);
		
		Home home = new Home();
		overall.add(home, "Home");
		cl.show(overall, "Home");
		
		//a bunch of menu bar stuff:
		JMenuBar bar = new JMenuBar();
		
		JMenu menu1 = new JMenu("Account");
		JMenuItem option1 = new JMenuItem("Add Account");
		menu1.add(option1);
		JMenuItem option2 = new JMenuItem("Remove Account");
		menu1.add(option2);
		JMenuItem option3 = new JMenuItem("Find Account");
		menu1.add(option3);
		bar.add(menu1);
		
		JMenu menu2 = new JMenu("Transaction");
		JMenuItem option4 = new JMenuItem("Deposit");
		menu2.add(option4);
		JMenuItem option5 = new JMenuItem("Withdraw");
		menu2.add(option5);
		JMenuItem option6 = new JMenuItem("Transfer");
		menu2.add(option6);
		bar.add(menu2);
		
		JMenuItem homeMenuItem = new JMenuItem("Home");
		bar.add(homeMenuItem);
		
		CreateAccount createAcc = new CreateAccount(accList);
		overall.add(createAcc, "Add Account");
		
		option1.addActionListener(new ActionListener ()
		{
			
			public void actionPerformed(ActionEvent arg0) 
			{
				cl.show(overall, "Add Account");
				System.out.println("test");
			}

		});
	
		
		this.setJMenuBar(bar);
		this.setVisible(true);
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		
	}
	
	
	
	public static void main(String args[])
	{
		Frame fr = new Frame();
	}
	
	private static boolean isNumeric(String str) 
	{
		try
		{
			Double.parseDouble(str);
			return true;
		}
		
		catch(IllegalArgumentException e)
		{
			return false;
		}
	}
}
