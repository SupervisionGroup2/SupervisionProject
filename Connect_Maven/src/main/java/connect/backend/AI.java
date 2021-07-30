package connect.backend;

import java.util.Random;

public class AI extends GameState {

	public void addToken(int column) {
		super.addToken(column);
		
		if (playerTurn==2) {
			aiAddToken();
		}
	}

	private void aiAddToken() {
		playerTurn = 1;
		System.out.println("\nAI ---------------------------------------\n");

		for (int i = 0; i<7; i++) {
			System.out.println("\nAI - trial " + i);

			int	x = addTokenAI(i, 2);
			System.out.println("\n x: " + x + "\n");
			System.out.println();
			for (int i1 = 0; i1 < board.length; i1++) { 
				for (int j = 0; j < board[i1].length; j++) { 
					System.out.print(board[i1][j] + " ");
				};
				System.out.println();
			}
			System.out.println();


			if(x != 11) {

				columnState[i] = columnState[i] + 1;
				board [columnState[i]] [i] = 0;	

				if(x != 10) {
					System.out.print("AI: wins : " + x);

					board [columnState[x]] [x] = 2;
					columnState[x] = columnState[x] - 1;
					return;
				}							
			}else {
				System.out.print("too full : " + x);
			}		
		}

		for (int i = 0; i<7; i++) {
			System.out.println("\nAI - trial " + i);

			int	x = addTokenAI(i, 1);
			System.out.println("\n x: " + x + "\n");
			System.out.println();
			for (int i1 = 0; i1 < board.length; i1++) { 
				for (int j = 0; j < board[i1].length; j++) { 
					System.out.print(board[i1][j] + " ");
				};
				System.out.println();
			}
			System.out.println();

			if(x != 11) {

				columnState[i] = columnState[i] + 1;
				board [columnState[i]] [i] = 0;	

				if(x != 10) {
					System.out.print("AI: wins : " + x);

					board [columnState[x]] [x] = 2;
					columnState[x] = columnState[x] - 1;
					return;
				}
				if(i == 6) {
					Random rand = new Random();
					int y = rand.nextInt(7); 

					board [columnState[y]] [y] = 2;
					columnState[y] = columnState[y] - 1;
					return;
				}							
			}else {
				System.out.print("too full : " + x);
			}
			winCheck();
		}

	};

	public int addTokenAI(int column, int colour) { 
		if (columnState[column] >= 0) {

			board [columnState[column]] [column] = colour;
			columnState[column] = columnState[column] - 1;

			int pathend = winCheck();
			if (pathend == 0) {
				return(10);
			}else {
				//int path = Integer.valueOf(String.valueOf(column) + String.valueOf(pathend));
				//return(path);
				return(column);
			}

		};
		return(11);

	}
}
