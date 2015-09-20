import static org.junit.Assert.*;

import org.junit.Test;

public class TestGame {

	@Test
	public void testGameNoPlayers() {
		Game game = new Game();

		assertTrue(game.getNumPlayers() == 0);
	}
	
	@Test
	public void testAddPlayerToGame() {
		Game game = new Game();
		
		int arbitraryPlayerId = 1;
		String arbitraryHand = "TwoHearts AceSpades AceHearts AceDiamonds FiveSpades";
		game.addPlayer(arbitraryPlayerId, arbitraryHand);
		
		assertTrue(game.getNumPlayers() == 1);
	}

}
