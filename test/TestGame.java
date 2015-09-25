import static org.junit.Assert.*;

import org.junit.Test;

public class TestGame {

	@Test
	public void testGameNoPlayers() {
		Game game = new Game();

		assertTrue(game.getNumPlayers() == 0);
		assertTrue(game.getState() == GameState.SETUP);
	}
	
	@Test
	public void testAddPlayerToGame() throws IllegalGameStateException {
		Game game = new Game();
		
		int arbitraryPlayerId = 1;
		String arbitraryHand = "TwoHearts AceSpades AceHearts AceDiamonds FiveSpades";
		game.addPlayer(arbitraryPlayerId, arbitraryHand);
		
		assertTrue(game.getNumPlayers() == 1);
	}

	@Test(expected=IllegalGameStateException.class)
	public void testAddPlayerAfterRanking() throws Exception {
		Game game = new Game();
		
		int arbitraryPlayerId = 1;
		String arbitraryHand = "TwoHearts AceSpades AceHearts AceDiamonds FiveSpades";

		int arbitraryPlayerId2 = 2;
		String arbitraryHand2 = "TwoHearts AceSpades AceHearts AceDiamonds FiveSpades";

		game.addPlayer(arbitraryPlayerId, arbitraryHand);
		game.addPlayer(arbitraryPlayerId2, arbitraryHand2);

		game.rankPlayers();
		

		int arbitraryPlayerId3 = 3;
		String arbitraryHand3 = "TwoHearts AceSpades AceHearts AceDiamonds FiveSpades";

		game.addPlayer(arbitraryPlayerId3, arbitraryHand3);
}
}
