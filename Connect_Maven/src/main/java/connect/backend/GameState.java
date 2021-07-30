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
	
	// checks for vertical win con (win condition)
	for (int y = 0; y < 7; y++) {

		for (int x = 0; x < 6; x++) {

			try 
			{
				if (board[y] [x] == 1) {xCounter++; if (board[y+1] [x] == 1) {xCounter++;  if (board[y+2] [x] == 1) {xCounter++;}  if (board[y+3] [x] == 1) {xCounter++;} } };
				if (xCounter == 4) {System.out.println("col: YELLOW (1) WINS"); return 1;}else {xCounter=0;}
				
				if (board[y] [x] == 2) {yCounter++; if (board[y+1] [x] == 2) {yCounter++;  if (board[y+2] [x] == 2) {yCounter++;}  if (board[y+3] [x] == 2) {yCounter++;} } };
				if (xCounter == 4) {System.out.println("col: RED (2) WINS"); return 2;}else {yCounter=0;}
			}catch (Exception e) {
				yCounter=0;
				xCounter=0;
			}finally {
				
			}

		}
		xCounter = 0;
		yCounter = 0;
		}
	
	// checks for horizontal win con
	for (int y = 0; y < 6; y++) {

		for (int x = 0; x < 7; x++) {

			try 
			{
				if (board[y] [x] == 1) {xCounter++; if (board[y] [x+1] == 1) {xCounter++;  if (board[y] [x+2] == 1) {xCounter++;}  if (board[y] [x+3] == 1) {xCounter++;} } };
				if (xCounter == 4) {System.out.println("row: YELLOW (1) WINS"); return 1;}else {xCounter=0;}
				
				if (board[y] [x] == 2) {yCounter++; if (board[y] [x+1] == 2) {yCounter++;  if (board[y] [x+2] == 2) {yCounter++;}  if (board[y] [x+3] == 2) {yCounter++;} } };
				if (xCounter == 4) {System.out.println("row: RED (2) WINS"); return 2;}else {yCounter=0;}
			}catch (Exception e) {
				yCounter=0;
				xCounter=0;
			}finally {
				
			}
		}	
		xCounter = 0;
		yCounter = 0;
	}

	// checks for diagonal win con 
	for (int y = 0; y < 6; y++) {
		
		for (int x = 0; x < 7; x++) {
			try 
			{
				if (board[y] [x] == 1) {xCounter++; if (board[y+1] [x+1] == 1) {xCounter++;  if (board[y+2] [x+2] == 1) {xCounter++;}  if (board[y+3] [x+3] == 1) {xCounter++;} } };
				if (xCounter == 4) {System.out.println("diag1: YELLOW (1) WINS"); return 1;}else {xCounter=0;}
				
				if (board[y] [x] == 2) {yCounter++; if (board[y+1] [x+1] == 2) {yCounter++;  if (board[y+2] [x+2] == 2) {yCounter++;}  if (board[y+3] [x+3] == 2) {yCounter++;} } };
				if (yCounter == 4) {System.out.println("diag1: RED (2) WINS"); return 2;}else {yCounter=0;}
				
			}catch (Exception e) {
				yCounter=0;
				xCounter=0;
			}finally {
				
			}

		}

		xCounter = 0;
		yCounter = 0;
		
		for (int x = 0; x < 7; x++) {
			try 
			{
				if (board[y] [x] == 1) {xCounter++; if (board[y+1] [x-1] == 1) {xCounter++;  if (board[y+2] [x-2] == 1) {xCounter++;}  if (board[y+3] [x-3] == 1) {xCounter++;} } };
				if (xCounter == 4) {System.out.println("diag2: YELLOW (1) WINS"); return 1;}else {xCounter=0;}
				
				if (board[y] [x] == 2) {yCounter++; if (board[y+1] [x-1] == 2) {yCounter++;  if (board[y+2] [x-2] == 2) {yCounter++;}  if (board[y+3] [x-3] == 2) {yCounter++;} } };
				if (yCounter == 4) {System.out.println("diag2: RED (2) WINS"); return 2;}else {yCounter=0;}
				
			}
			catch (Exception e) {
				yCounter=0;
				xCounter=0;
			}
			finally {
				
			}

		}
		
	}

	 return 0;
	
	}

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
