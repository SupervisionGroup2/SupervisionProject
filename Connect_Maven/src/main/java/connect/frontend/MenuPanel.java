package connect.frontend;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class MenuPanel extends JPanel {
	FrontEnd front;
	
	public MenuPanel(FrontEnd f) {
		front = f;
		
		JButton button = new JButton("Player vs Player");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent a) {
				// change this code to implement the player vs player mode
				front.run();
			}
		});
		add(button);
		
		button = new JButton("Player vs AI");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent a) {
				// change this code to implement the player vs AI mode
				front.run();
			}
		});
		add(button);
	}
}
