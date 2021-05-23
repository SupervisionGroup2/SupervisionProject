package connect.backend;

import java.util.stream.IntStream;

public class GameState {
	//this list will keep track of how many tokens there are in a specific column
	int [] columnState = {5, 5, 5, 5, 5, 5, 5};

	// this keeps track of which player's turn it is
	int playerTurn=1;

	// This matrix represents the board, the number 0 represents an unclaimed spot,
	//1 will be yellow and 2 will be red tokens respectively
	//The columns will be named:  0, 1, 2, 3, 4, 5, 6
	int [] [] board = {   {0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0}
	};

	public void addToken(int column) {
		board [columnState[column]] [column] = playerTurn;

		// gamestate keeps track of who's turn it is
		if (playerTurn==1) {
			playerTurn=2;
		} else {
			playerTurn=1;
		}

		columnState[column] = columnState[column] - 1;

		for (int i = 0; i < board.length; i++) { //this equals to the row in our matrix.
			for (int j = 0; j < board[i].length; j++) { //this equals to the column in each row.
				System.out.print(board[i][j] + " ");
			};
			System.out.println();

		}

		//System.out.print(columnState[0]);
		//System.out.print(columnState[1]);
		//System.out.print(columnState[2]);
		//System.out.print(columnState[3]);
		//System.out.print(columnState[4]);
		//System.out.print(columnState[5]);
		System.out.println();


		System.out.println("current winner: " + winCheck() + " (0 = none yet, 1 = yellow, 2 = red)");
	};



	@SuppressWarnings("finally")
	public int winCheck(){
		int i = 0;
		int j = 0;
		int yCounter = 0;
		int xCounter = 0;
		/////////////////////////////// checks for vertical win con (win condition)
		for (int y = 0; y < 7; y++) {
			//System.out.println("y = " + y);

			for (int x = 0; x < 6; x++) {

				//System.out.println("x = " + x);
				try 
				{
					if (board[x] [y] == 1) {xCounter++; 
					//System.out.println("col: 1 found at: " + x + " " + y + " counter: " + xCounter);
					};
					if (xCounter == 4) {System.out.println("col: YELLOW (1) WINS"); return 1;}
					if (board[x] [y] == 2 || board[x] [y] == 0) {xCounter = 0; 
					//System.out.println("col: 2 blocked at: " + x + " " + y + " counter: " + xCounter);
					};

					if (board[x] [y] == 2) {yCounter++; 
					//System.out.println("col: 1 found at: " + x + " " + y + " counter: " + xCounter);
					};
					if (yCounter == 4) {System.out.println("col: RED (2) WINS"); return 2;}
					if (board[x] [y] == 1 || board[x] [y] == 0) {yCounter = 0; 
					//System.out.println("col: 2 blocked at: " + x + " " + y + " counter: " + xCounter);
					};

				}finally {

				}

			}
			xCounter = 0;
		}
		/////////////////////////////////////////// checks for horizontal win con 

		for (int y = 0; y < 6; y++) {
			//System.out.println("y = " + y);

			for (int x = 0; x < 7; x++) {

				//System.out.println("x = " + x);
				try 
				{
					if (board[y] [x] == 1) {xCounter++; 
					//System.out.println("row: 1 found at: " + x + " " + y + " counter: " + xCounter);
					};
					if (xCounter == 4) {System.out.println("row: YELLOW (1) WINS"); return 1;}
					if (board[y] [x] == 2 || board[y] [x] == 0) {xCounter = 0; 
					//System.out.println("row: 2 blocked at: " + x + " " + y + " counter: " + xCounter);
					};

					if (board[y] [x] == 2) {yCounter++; 
					//System.out.println("row: 1 found at: " + x + " " + y + " counter: " + xCounter);
					};
					if (yCounter == 4) {System.out.println("row: RED (1) WINS"); return 2;}
					if (board[y] [x] == 1 || board[y] [x] == 0) {yCounter = 0; 
					//System.out.println("row: 2 blocked at: " + x + " " + y + " counter: " + xCounter);
					};
				}finally {

				}

			}
			xCounter = 0;
		}

		///////////////////////////////////////////////////////// checks for diagonal (\) win con 
		for (int y = 0; y < 6; y++) {
			//System.out.println("y = " + y);

			for (int x = 0; x < 7; x++) {

				//System.out.println("x = " + x);
				try 
				{
					if (board[y+x] [x] == 1) {xCounter++; 
					//System.out.println("diag1 : 1 found at: " + (x + y) + " " + y + " counter: " + xCounter);
					};
					if (xCounter == 4) {System.out.println("diag1: YELLOW (1) WINS"); return 1;}
					if (board[y+x] [x] == 2 || board[y+x] [x] == 0) {xCounter = 0; 
					//System.out.println("diag: 2 blocked at: " + x + " " + y + " counter: " + xCounter);
					};

					if (board[y+x] [x] == 2) {yCounter++; 
					//System.out.println("diag1 : 1 found at: " + (x + y) + " " + y + " counter: " + xCounter);
					};
					if (yCounter == 4) {System.out.println("diag1: RED (2) WINS"); return 2;}
					if (board[y+x] [x] == 1 || board[y+x] [x] == 0) {yCounter = 0; 
					//System.out.println("diag: 2 blocked at: " + x + " " + y + " counter: " + xCounter);
					};


				}catch (Exception e) {
					//System.out.println("can not input: " + (x + y) + " " + y);
				}finally {

				}

			}

			xCounter = 0;

			for (int x = 0; x < 7; x++) {

				//System.out.println("x = " + x);
				try 
				{
					if (board[x] [x+y] == 1) {xCounter++; 
					//System.out.println("diag2 : 1 found at: " + x + " " + (x + y) + " counter: " + xCounter);
					};
					if (xCounter == 4) {System.out.println("diag2: YELLOW (1) WINS"); return 1;}
					if (board[x] [x+y] == 2 || board[x] [x+y] == 0) {xCounter = 0; 
					//System.out.println("diag: 2 blocked at: " + x + " " + y + " counter: " + xCounter);
					};

					if (board[x] [x+y] == 2) {yCounter++; 
					//System.out.println("diag2 : 1 found at: " + x + " " + (x + y) + " counter: " + xCounter);
					};
					if (yCounter == 4) {System.out.println("diag2: RED (2) WINS"); return 2;}
					if (board[x] [x+y] == 1 || board[x] [x+y] == 0) {yCounter = 0; 
					//System.out.println("diag: 2 blocked at: " + x + " " + y + " counter: " + xCounter);
					};

				}
				catch (Exception e) {
					//System.out.println("can not input: " + (x + y) + " " + y);
				}
				finally {

				}

			}

		}


		/////////////////////////////////////////////////////////// checks for diagonal (/) win con 

		for (int y = 0; y < 6; y++) {
			//System.out.println("y = " + y);

			for (int x = 0; x < 7; x++) {

				//System.out.println("x = " + x);
				try 
				{
					if (board[y-x] [x] == 1) {xCounter++; 
					//System.out.println("diag3 : 1 found at: " + (y - x) + " " + y + " counter: " + xCounter);
					};
					if (xCounter == 4) {System.out.println("diag1:  YELLOW (1) WINS"); return 1;}
					if (board[y-x] [x] == 2 || board[y-x] [x] == 0) {xCounter = 0; 
					//System.out.println("diag: 2 blocked at: " + x + " " + y + " counter: " + xCounter);
					};

					if (board[y-x] [x] == 2) {yCounter++; 
					//System.out.println("diag3 : 1 found at: " + (y - x) + " " + y + " counter: " + xCounter);
					};
					if (yCounter == 4) {System.out.println("diag1:RED (2) WINS"); return 2;}
					if (board[y-x] [x] == 1 || board[y-x] [x] == 0) {yCounter = 0; 
					//System.out.println("diag: 2 blocked at: " + x + " " + y + " counter: " + xCounter);
					};

				}catch (Exception e) {
					//System.out.println("can not input: " + (x + y) + " " + y);
				}finally {

				}

			}

			xCounter = 0;

			for (int x = 0; x < 7; x++) {

				//System.out.println("x = " + x);
				try 
				{
					if (board[x] [y-x] == 1) {xCounter++; 
					//System.out.println("diag4 : 1 found at: " + x + " " + (y - x) + " counter: " + xCounter);
					};
					if (xCounter == 4) {System.out.println("diag2: YELLOW (1) WINS"); return 1;}
					if (board[x] [y-x] == 2 || board[x] [y-x] == 0) {xCounter = 0; 
					//System.out.println("diag: 2 blocked at: " + x + " " + y + " counter: " + xCounter);
					};

					if (board[x] [y-x] == 2) {yCounter++; 
					//System.out.println("diag4 : 1 found at: " + x + " " + (y - x) + " counter: " + xCounter);
					};
					if (yCounter == 4) {System.out.println("diag2: RED (2) WINS"); return 2;}
					if (board[x] [y-x] == 1 || board[x] [y-x] == 0) {yCounter = 0; 
					//System.out.println("diag: 2 blocked at: " + x + " " + y + " counter: " + xCounter);
					};

				}
				catch (Exception e) {
					//System.out.println("can not input: " + (x + y) + " " + y);
				}
				finally {

				}

			}

		}
		return 0;

	}
	
	// returns game board
	public int[] [] getBoard() {
		return board;
	}
	
	// returns who's turn it is
	public int getTurn() {
		return playerTurn;
	}
	
	public int getColumnState(int column) {
		return columnState[column];
	}
}
