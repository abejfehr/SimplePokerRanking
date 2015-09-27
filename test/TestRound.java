import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

public class TestRound {

	@Test
	public void testGameNoPlayers() {
		Round round = new Round();

		assertEquals(round.getNumPlayers(), 0);
		assertEquals(round.getState(), RoundState.SETUP);
	}
	
	@Test
	public void testAddPlayerToGame() throws Exception {
		Round round = new Round();
		String arbitraryHand = "TwoHearts AceSpades AceHearts AceDiamonds FiveSpades";

		round.addPlayer(1 + " " + arbitraryHand);
		
		assertEquals(round.getNumPlayers(), 1);
	}

	@Test(expected=IllegalRoundStateException.class)
	public void testAddPlayerAfterRanking() throws Exception {
		Round round = new Round();
		String arbitraryHand = "TwoHearts AceSpades AceHearts AceDiamonds FiveSpades";
		
		round.addPlayer(1 + " " + arbitraryHand);
		round.addPlayer(2 + " " + arbitraryHand);
		round.getRankedHands();
		round.addPlayer(3 + " " + arbitraryHand);
		
		fail(); // Test fails if it gets here, exception should've been thrown by now
	}

	@Test(expected=Exception.class)
	public void testAddPlayersOutOfOrder() throws Exception {
		Round round = new Round();
		String arbitraryHand = "TwoHearts AceSpades AceHearts AceDiamonds FiveSpades";

		round.addPlayer(1 + " " + arbitraryHand);
		round.addPlayer(3 + " " + arbitraryHand);
		round.getRankedHands();
		round.addPlayer(2 + " " + arbitraryHand);
		
		fail(); // Test fails if it gets here, exception should've been thrown by now
	}
	
	@Test
	public void testGetRankedHands() throws Exception {
		Round round = new Round();
		String losingHand = "TwoHearts AceSpades QueenDiamonds SixSpades FiveSpades";
		String winningHand = "TenHearts JackHearts QueenHearts KingHearts AceHearts";

		round.addPlayer(1 + " " + losingHand); // The losing hand first
		round.addPlayer(2 + " " + winningHand);
		
		List<Hand> rankedHands = round.getRankedHands(); // Should return the ranked hands at some point
		
		assertEquals(rankedHands.get(0).getRanking(), Ranking.ROYAL_FLUSH);
		assertEquals(rankedHands.get(1).getRanking(), Ranking.HIGH_CARD);
	}
}
