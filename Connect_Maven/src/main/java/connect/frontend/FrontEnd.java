package connect.frontend;

import javax.swing.*;

import connect.backend.GameState;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.event.*;

public class FrontEnd {
	GameState state = new GameState();
	JFrame frame = new JFrame();

	public void menu() {
		// creates JFrame
		frame = new JFrame("Connect 4");
		int fwidth = 1400;
		int fheight = 800;
		frame.setSize(fwidth, fheight);
		
		MenuPanel panel = new MenuPanel(this);
		panel.setBounds(0, 0, 1400, 800);
		frame.add(panel);
		
		frame.setVisible(true);
	}
	
	// this method runs the main game
	public void run() {
		// removes menu panel
		frame.getContentPane().removeAll();
		
		///// creates GUI panel
		ConnectPanel panel = new ConnectPanel(state, this);
		panel.setBounds(0, 0, 1400, 800);
		frame.add(panel);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// makes frame visible
		frame.setVisible(true);
	}

	// this method is run when there is a winner
	public void end() {
		// removes all panels, then adds panel with label displaying winner
		frame.getContentPane().removeAll();
		
		JPanel panel = new JPanel(new GridBagLayout());
		panel.setBounds(0, 0, 1400, 800);
		JLabel label;
		if (state.winCheck()==1) {
			label = new JLabel("Yellow Wins!", JLabel.CENTER);
		} else {
			label = new JLabel("Red Wins!", JLabel.CENTER);
		}
		label.setFont(new Font("Serif", Font.PLAIN, 50));
		
		panel.add(label);
		frame.add(panel);
		
		frame.setSize(800, 800);
		frame.setVisible(true);
	}
}
