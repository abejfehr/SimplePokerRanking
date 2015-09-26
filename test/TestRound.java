import static org.junit.Assert.*;

import org.junit.Test;

public class TestRound {

	@Test
	public void testGameNoPlayers() {
		Round game = new Round();

		assertEquals(game.getNumPlayers(), 0);
		assertEquals(game.getState(), RoundState.SETUP);
	}
	
	@Test
	public void testAddPlayerToGame() throws Exception {
		Round game = new Round();
		
		int arbitraryPlayerId = 1;
		String arbitraryHand = "TwoHearts AceSpades AceHearts AceDiamonds FiveSpades";
		game.addPlayer(arbitraryPlayerId, arbitraryHand);
		
		assertEquals(game.getNumPlayers(), 1);
	}

	@Test(expected=IllegalRoundStateException.class)
	public void testAddPlayerAfterRanking() throws Exception {
		Round game = new Round();
		
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
		fail(); // Test fails if it gets here, exception should've been thrown by now
	}
}
