package connect.frontend;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

import connect.backend.GameState;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class ConnectPanel extends JPanel {
	GameState state;
	FrontEnd front;
	JLabel yellowTurn;
	JLabel redTurn;
	
	public ConnectPanel(GameState s, FrontEnd f) {
		state = s;
		front = f;
		setLayout(null);
		int x=370;
		JButton button;
		for (int i=0; i<=6; i++) {
			button = new JButton();
			button.setBounds(x, 20, 70, 70);
			button.addActionListener(new SelectColumnEventListener(button, s, i, this));
			add(button);
			x+=100;
		}
	}
	
	public void paintComponent (Graphics g) {
		// calls paintComponent on superclass
		super.paintComponent(g);


		// Retrieves the graphics context
		Graphics2D graphics2d = (Graphics2D)g;

		// displays the player's turn
		if (state.getTurn()==1) {
			graphics2d.setColor(Color.YELLOW);
			drawCircleCentre(graphics2d, 150, 400, 150);			
		}
		if (state.getTurn()==2) {
			graphics2d.setColor(Color.RED);
			drawCircleCentre(graphics2d, 1200, 400, 150);
		}
		
		// draws board
		graphics2d.setColor(Color.BLUE);
		graphics2d.fillRect(350, 100, 700, 600);
		
		// draws the circles
		int px;
		// py starts at the y co-ordinate of the board + 50
		int py = 150;
		for (int[] row: state.getBoard()) {
			// px starts each row at the x co-ordinate of the board + 50
			px = 100;
			for (int p: row) {
				switch (p) {
				case 0:
					graphics2d.setColor(Color.WHITE);
					break;
				case 1:
					graphics2d.setColor(Color.YELLOW);
					break;
				case 2:
					graphics2d.setColor(Color.RED);
					break;
				default:
					graphics2d.setColor(Color.WHITE);
				}
				drawCircleCentre(graphics2d, px + 300, py, 80);
				px+=100;
			}
			py += 100;
		}

	}
	
	public void drawCircleCentre(Graphics2D g, int x, int y, int r) {
		// draws a circle using centre x and y co-ordinates
		g.fillOval(x-(r/2), y-(r/2), r, r);
	}

	public void endGame() {
		front.end();
	}
}

