import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class FindAccount extends JPanel
{
	public FindAccount(ArrayList <BankAccount> accList)
	{
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		JLabel accounts = new JLabel("");
		gbc.gridx = 0;
		gbc.gridy = 1;
		add(accounts, gbc);
		
		JButton displayAcc = new JButton("Display All Accounts");
		gbc.gridx = 0;
		gbc.gridy = 0;
		add(displayAcc, gbc);
		displayAcc.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				String str = "";
					for(BankAccount a : accList)
					{
						str += a.toString();
					}
				accounts.setText(str);
			}
		});	
	}
}
