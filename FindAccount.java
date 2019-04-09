import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FindAccount extends JPanel
{
	public FindAccount(ArrayList <BankAccount> accList)
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
		
		JLabel accounts = new JLabel("");
		gbc.gridx = 1;
		gbc.gridy = 3;
		add(accounts, gbc);
		
		JButton displayAcc = new JButton("Display Account");
		gbc.gridx = 1;
		gbc.gridy = 2;
		add(displayAcc, gbc);
		displayAcc.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				String str = "";
					for(BankAccount a : accList)
					{
						if(("" + a.getName()).equals(nameTxt.getText()))
								str += a.toString();
					}
				accounts.setText(str);
			}
		});	
	}
}
