package connect.frontend;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MenuPanel extends JPanel {
	FrontEnd front;
	
	public MenuPanel(FrontEnd f) {
		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.VERTICAL;
		c.insets = new Insets(10,0,0,0);
		front = f;
		
		c.ipadx = 40;
		c.ipady = 10;
		
		c.gridx = 0;
		c.gridy = 0;
		c.weightx = 0.5;
		
		JLabel label = new JLabel("Connect 4", JLabel.CENTER);
		label.setFont(new Font("Serif", Font.BOLD, 50));
		add(label,c);
		
		c.gridy = 1;
		JButton button = new JButton("Player vs Player");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent a) {
				front.run(1);
			}
		});
		add(button,c);
		
		c.gridy = 2;
		button = new JButton("Player vs AI");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent a) {
				front.run(2);
			}
		});
		add(button,c);
		
		c.gridy = 3;
		button = new JButton("Quit");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent a) {
				front.close();
			}
		});
		add(button,c);
	}
}
