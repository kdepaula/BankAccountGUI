import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Transfer extends JPanel
{
	public Transfer(ArrayList <BankAccount> accList)
	{
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		JLabel name = new JLabel("Name: ");
		gbc.gridx = 0;
		gbc.gridy = 0;
		add(name, gbc);
		
		JTextField nameTxt = new JTextField("");
		gbc.gridx = 1;
		nameTxt.setPreferredSize(new Dimension(200, 30));
		add(nameTxt, gbc);
		
		JLabel acc = new JLabel("Account Number to Transfer from: ");
		gbc.gridx = 0;
		gbc.gridy = 1;
		add(acc, gbc);
		
		JTextField accTxt = new JTextField("");
		accTxt.setPreferredSize(new Dimension(200, 30));
		gbc.gridx = 1;
		add(accTxt, gbc);
		
		JLabel acc2 = new JLabel("Account Number to Transfer to: ");
		gbc.gridx = 0;
		gbc.gridy = 1;
		add(acc2, gbc);
		
		JTextField accTxt2 = new JTextField("");
		accTxt2.setPreferredSize(new Dimension(200, 30));
		gbc.gridx = 1;
		add(accTxt2, gbc);
		
		JLabel heading = new JLabel("If you do not know your account number, go to the Find Account tab under Accounts.");
		gbc.gridx = 1;
		gbc.gridy = 3;
		add(heading, gbc);
		
		JButton transfer = new JButton("Transfer");
		gbc.gridx = 1;
		gbc.gridwidth = 2;
		gbc.gridy = 2;
		add(transfer, gbc);
		transfer.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				if(!isNumeric(accTxt.getText()) || !isNumeric(accTxt2.getText())|| 
				nameTxt.getText().equals(""))
				{
					
				}
				else()
				{
					for(int i = 0; i< accList.size(); i++)
					{
						if(accList.get(i).getAccNum() == Double.parseDouble(numTxt.getText()) && 
						accList.get(i).getName().equals(nameTxt.getText()))
						{
							accList.remove(i);
						}
					}
				}
				else
				{for(int i = 0; i< accList.size(); i++)
				{
					if(accList.get(i).getAccNum() == Double.parseDouble(numTxt.getText()) && 
					accList.get(i).getName().equals(nameTxt.getText()))
					{
						accList.remove(i);
					}
				}
				}
			}
		});	
		setVisible(true);
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

