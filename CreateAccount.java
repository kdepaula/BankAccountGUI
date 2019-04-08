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

public class CreateAccount extends JPanel
{
	private static final double OVER_DRAFT_FEE = 15;
	private static final double RATE = .0025;
	private static final double TRANSACTION_FEE = 1.5;
	private static final double MIN_BAL = 300;
	private static final double MIN_BAL_FEE = 10;
	private static final double FREE_TRANSACTIONS = 10;
	
	public CreateAccount(ArrayList <BankAccount> accList)
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
		
		JLabel bal = new JLabel("Initial Balance: ");
		gbc.gridx = 0;
		gbc.gridy = 1;
		add(bal, gbc);
		
		JTextField balTxt = new JTextField("");
		balTxt.setPreferredSize(new Dimension(200, 30));
		gbc.gridx = 1;
		add(balTxt, gbc);
		
		JLabel acc = new JLabel("Account Type: ");
		gbc.gridx = 0;
		gbc.gridy = 3;
		add(acc, gbc);
		
		JComboBox type = new JComboBox(new String[] {"", "Checking", "Savings"});
		gbc.gridx = 1;
		gbc.gridy = 3;
		add(type, gbc);
		
		
		JButton createAcc = new JButton("Create Account");
		gbc.gridx = 1;
		gbc.gridy = 5;
		add(createAcc, gbc);
		createAcc.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				if(!isNumeric(balTxt.getText()) || type.getSelectedItem().equals("") || nameTxt.getText().equals(""))
				{
					
				}
				else if(type.getSelectedItem().equals("Checking"))
				{
					accList.add(new CheckingAccount(nameTxt.getText(), Double.parseDouble(balTxt.getText()), OVER_DRAFT_FEE, TRANSACTION_FEE, FREE_TRANSACTIONS));
					nameTxt.setText("");
					balTxt.setText("");
					type.setSelectedItem("");
				}
				else if(type.getSelectedItem().equals("Savings"))
				{
					accList.add(new SavingsAccount(nameTxt.getText(), Double.parseDouble(balTxt.getText()), RATE, MIN_BAL, MIN_BAL_FEE));
					nameTxt.setText("");
					balTxt.setText("");
					type.setSelectedItem("");
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
