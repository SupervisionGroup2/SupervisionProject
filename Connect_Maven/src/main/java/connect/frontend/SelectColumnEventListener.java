package connect.frontend;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import connect.backend.GameState;

public class SelectColumnEventListener implements ActionListener {
	// reference to button
	private JButton buttonObj;

	GameState state;
	int column;
	ConnectPanel panel;

	public SelectColumnEventListener(JButton b, GameState s, int col, ConnectPanel p) {
		buttonObj = b;
		state = s;
		column = col;
		panel = p;
	}

	public void buttonAction(ActionEvent e) {
		state.addToken(column);
		panel.repaint();
		if (!(state.winCheck()==0)) {
			panel.endGame();
		}
	}

	public void actionPerformed(ActionEvent e) {
		buttonAction(e);
	}
}
