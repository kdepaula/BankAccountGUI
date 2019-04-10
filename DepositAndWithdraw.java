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

public class DepositAndWithdraw extends JPanel
{
	private static final double OVER_DRAFT_FEE = 15;
	private static final double RATE = .0025;
	private static final double TRANSACTION_FEE = 1.5;
	private static final double MIN_BAL = 300;
	private static final double MIN_BAL_FEE = 10;
	private static final double FREE_TRANSACTIONS = 10;
	
	public DepositAndWithdraw(ArrayList <BankAccount> accList)
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
		
		JLabel accNum = new JLabel("Account Number: ");
		gbc.gridx = 0;
		gbc.gridy = 0;
		add(name, gbc);
		
		JTextField accTxt = new JTextField("");
		gbc.gridx = 1;
		accTxt.setPreferredSize(new Dimension(200, 30));
		add(accTxt, gbc);
		
		JLabel bal = new JLabel("Balance to Transfer: ");
		gbc.gridx = 0;
		gbc.gridy = 1;
		add(bal, gbc);
		
		JTextField balTxt = new JTextField("");
		balTxt.setPreferredSize(new Dimension(200, 30));
		gbc.gridx = 1;
		add(balTxt, gbc);
		
		JLabel acc = new JLabel("Deposit or Withdraw? ");
		gbc.gridx = 0;
		gbc.gridy = 3;
		add(acc, gbc);
		
		JComboBox type = new JComboBox(new String[] {"", "Deposit", "Withdraw"});
		gbc.gridx = 1;
		gbc.gridy = 3;
		add(type, gbc);
		
		JLabel valid = new JLabel("");
		gbc.gridx = 2;
		gbc.gridy = 7;
		add(valid, gbc);
		
		JLabel complete = new JLabel("");
		gbc.gridx = 2;
		gbc.gridy = 8;
		
		
		
		JButton submit = new JButton("Complete Transaction");
		gbc.gridx = 1;
		gbc.gridy = 5;
		add(submit, gbc);
		submit.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				boolean notValid = true;
				if(!isNumeric(balTxt.getText()) || type.getSelectedItem().equals("") || nameTxt.getText().equals(""))
				{
					
				}
				else
				{
					for(BankAccount a: accList)
					{
						if(a.getName().equals(nameTxt.getText()) && a.getAccNum() == Double.parseDouble(accTxt.getText()))
						{
							valid.setText("The name and account number does not match. Please try again.");
							notValid = false;
						}
					}
				if(type.getSelectedItem().equals("Deposit") && !notValid)
				{
					for(BankAccount a: accList)
					{
						if(a.getName().equals(nameTxt.getText()) && a.getAccNum() == Double.parseDouble(accTxt.getText()))
						{
							complete.setText("Deposit complete!");
							a.deposit(Double.parseDouble(balTxt.getText()));
						}
					}
					nameTxt.setText("");
					balTxt.setText("");
					type.setSelectedItem("");
				}
				else if(type.getSelectedItem().equals("Withdraw") && !notValid)
				{
					for(BankAccount a: accList)
					{
						if(a.getName().equals(nameTxt.getText()) && a.getAccNum() == Double.parseDouble(accTxt.getText()))
						{
							complete.setText("Withdraw complete!");
							a.withdraw(Double.parseDouble(balTxt.getText()));
						}
					}
					nameTxt.setText("");
					balTxt.setText("");
					type.setSelectedItem("");
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
