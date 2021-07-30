package connect.backend;

public class GameState {
	//this list will keep track of how many tokens there are in a specific column
	int [] columnState = {5, 5, 5, 5, 5, 5, 5};

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

	int playerTurn = 1;

	public void addToken(int column) { 
		if (columnState[column]>=0) {
			board [columnState[column]] [column] = playerTurn;
			columnState[column] = columnState[column] - 1;
			
			if (playerTurn==1) {
				playerTurn = 2;
			} else {
				playerTurn = 1;
			}

			for (int i = 0; i < board.length; i++) {
				for (int j = 0; j < board[i].length; j++) { 
					System.out.print(board[i][j] + " ");
				};
				System.out.println();

			}

			System.out.println();


			System.out.println("current winner: " + winCheck() + " (0 = none yet, 1 = yellow, 2 = red)");

		}
	};


	public int winCheck(){
		int yCounter = 0;
		int xCounter = 0;
		/////////////////////////////// checks for vertical win con (win condition)
		for (int y = 0; y < 7; y++) {
			//System.out.println("y = " + y);

			for (int x = 0; x < 6; x++) {

				//System.out.println("x = " + x);
				try 
				{
					if (board[x] [y] == 1) {xCounter++; };
					if (xCounter == 4) {System.out.println("col: YELLOW (1) WINS"); return 1;}

					if (board[x] [y] == 2 || board[x] [y] == 0) {xCounter = 0; };
					if (board[x] [y] == 2) {yCounter++; };

					if (yCounter == 4) {System.out.println("col: RED (2) WINS"); return 2;}
					if (board[x] [y] == 1 || board[x] [y] == 0) {yCounter = 0; 
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
					if (board[y] [x] == 1) {xCounter++; };
					if (xCounter == 4) {System.out.println("row: YELLOW (1) WINS"); return 1;}
					if (board[y] [x] == 2 || board[y] [x] == 0) {xCounter = 0;};
					if (board[y] [x] == 2) {yCounter++; };
					if (yCounter == 4) {System.out.println("row: RED (2) WINS"); return 2;}
					if (board[y] [x] == 1 || board[y] [x] == 0) {yCounter = 0; };
				}finally {

				}

			}	
			xCounter = 0;
		}

		///////////////////////////////////////////////////////// checks for diagonal (\) win con 
		for (int y = 0; y < 6; y++) {
			for (int x = 0; x < 7; x++) {
				try 
				{
					if (board[y+x] [x] == 1) {xCounter++; };
					if (xCounter == 4) {System.out.println("diag1: YELLOW (1) WINS"); return 1;}
					if (board[y+x] [x] == 2 || board[y+x] [x] == 0) {xCounter = 0;};
					if (board[y+x] [x] == 2) {yCounter++;};
					if (yCounter == 4) {System.out.println("diag1: RED (2) WINS"); return 2;}
					if (board[y+x] [x] == 1 || board[y+x] [x] == 0) {yCounter = 0;};	

				}catch (Exception e) {
				}finally {

				}

			}

			xCounter = 0;

			for (int x = 0; x < 7; x++) {

				//System.out.println("x = " + x);
				try 
				{
					if (board[x] [x+y] == 1) {xCounter++; };
					if (xCounter == 4) {System.out.println("diag2: YELLOW (1) WINS"); return 1;}
					if (board[x] [x+y] == 2 || board[x] [x+y] == 0) {xCounter = 0;};
					if (board[x] [x+y] == 2) {yCounter++;};
					if (yCounter == 4) {System.out.println("diag2: RED (2) WINS"); return 2;}
					if (board[x] [x+y] == 1 || board[x] [x+y] == 0) {yCounter = 0;};

				}
				catch (Exception e) {
				}
				finally {

				}

			}

		}


		/////////////////////////////////////////////////////////// checks for diagonal (/) win con 
/*
		for (int y = 0; y < 6; y++) {

			for (int x = 0; x < 7; x++) {

				try 
				{
					if (board[y-x] [x] == 1) {xCounter++;};
					if (xCounter == 4) {System.out.println("diag1:  YELLOW (1) WINS"); return 1;}
					if (board[y-x] [x] == 2 || board[y-x] [x] == 0) {xCounter = 0;};

					if (board[y-x] [x] == 2) {yCounter++;};
					if (yCounter == 4) {System.out.println("diag1:RED (2) WINS"); return 2;}
					if (board[y-x] [x] == 1 || board[y-x] [x] == 0) {yCounter = 0;};

				}catch (Exception e) {
				}finally {

				}

			}

			xCounter = 0;

			for (int x = 0; x < 7; x++) {

				try 
				{
					if (board[x] [y-x] == 1) {xCounter++; 

					};
					if (xCounter == 4) {System.out.println("diag2: YELLOW (1) WINS"); return 1;}
					if (board[x] [y-x] == 2 || board[x] [y-x] == 0) {xCounter = 0;};

					if (board[x] [y-x] == 2) {yCounter++;};
					if (yCounter == 4) {System.out.println("diag2: RED (2) WINS"); return 2;}
					if (board[x] [y-x] == 1 || board[x] [y-x] == 0) {yCounter = 0; };

				}
				catch (Exception e) {
				}
				finally {

				}

			}

		}
		return 0;

	}
*/
	public int[] [] getBoard() {
		return board;
	}
	
	public int getTurn() {
		return playerTurn;
	}

	public int getColumnState(int column) {
		return columnState[column];
	}
}
