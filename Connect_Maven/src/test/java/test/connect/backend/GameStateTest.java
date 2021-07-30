package test.connect.backend;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import connect.backend.GameState;

class GameStateTest {

	@Test
	void testAddToken() {
		// tests addToken method
		GameState state = new GameState();
		
		int testColumn = 0;
		int startTurn = state.getTurn();
		int startColState = state.getColumnState(testColumn);
		state.addToken(testColumn);
		
		if (startTurn==1) {
			assertEquals(state.getTurn(), 2);
		} else {
			assertEquals(state.getTurn(), 1);
		}
		
		assertEquals(startColState, state.getColumnState(testColumn)+1);
	}

	@Test
	void testWinCheck() {
		GameState state = new GameState();
		
		// player 1 should win
		state.addToken(0);
		state.addToken(0);
		state.addToken(1);
		state.addToken(1);
		state.addToken(2);
		state.addToken(2);
		state.addToken(3);
		
		assertEquals(state.winCheck(), 1, "Error with player 1");
		
		state = new GameState();
		
		// player 2 should win
		state.addToken(0);
		state.addToken(1);
		state.addToken(0);
		state.addToken(2);
		state.addToken(0);
		state.addToken(3);
		state.addToken(1);
		state.addToken(4);
		
		assertEquals(state.winCheck(), 2, "Error with player 2");
		
		state = new GameState();
		
		// should not have a winner
		state.addToken(0);
		
		assertEquals(state.winCheck(), 0, "Error with loss");
	}

}
