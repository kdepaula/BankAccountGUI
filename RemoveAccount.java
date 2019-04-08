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

public class RemoveAccount extends JPanel
{
	public RemoveAccount(ArrayList <BankAccount> accList)
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
		
		JLabel acc = new JLabel("Account Number: ");
		gbc.gridx = 0;
		gbc.gridy = 1;
		add(acc, gbc);
		
		JTextField numTxt = new JTextField("");
		numTxt.setPreferredSize(new Dimension(200, 30));
		gbc.gridx = 1;
		add(numTxt, gbc);
		
		JButton removeAcc = new JButton("Remove Account");
		gbc.gridx = 1;
		gbc.gridwidth = 2;
		gbc.gridy = 2;
		add(removeAcc, gbc);
		removeAcc.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				if(!isNumeric(numTxt.getText())|| nameTxt.getText().equals(""))
				{
					
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
