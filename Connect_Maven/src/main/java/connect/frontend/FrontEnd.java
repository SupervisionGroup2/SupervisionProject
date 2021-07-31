package connect.frontend;

import javax.swing.*;
import connect.backend.AI;
import connect.backend.GameState;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.event.*;
import java.util.Timer;
import java.util.TimerTask;


public class FrontEnd {
	GameState state;
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
	public void run(int num) {
		// if num is 1, PVP
		// if num is 2, PVE

		// removes menu panel
		frame.getContentPane().removeAll();

		if (num==1) {
			state = new GameState();
		} else {
			state = new AI();
		}

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
		int winState = state.winCheck();
		if (winState==1) {
			label = new JLabel("Yellow Wins!", JLabel.CENTER);
		} else if (winState==2){
			label = new JLabel("Red Wins!", JLabel.CENTER);
		} else {
			label = new JLabel("<html>No winner!<br>The grid is full</html>", JLabel.CENTER);
		}
		label.setFont(new Font("Serif", Font.PLAIN, 50));

		panel.add(label);
		frame.add(panel);

		frame.setSize(800, 800);
		frame.setVisible(true);

		Timer timer = new Timer();
		timer.schedule(new TimerTask() {
			public void run() {
				frame.dispose();
				menu();
			}
		}, 3000 );


	}

	public void close() {
		frame.dispose();
		System.exit(0);
	}
}
