import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class Home extends JPanel
{
	public Home()
	{
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		JLabel welcome = new JLabel("Welcome");
		add(welcome, gbc);
		
		setVisible(true);
	}
}
