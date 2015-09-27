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
		String player1Hand = "TwoHearts AceSpades AceHearts AceDiamonds FiveSpades";
		String player2Hand = "TwoDiamonds AceClubs SixSpades SevenSpades FiveClubs";
		String player3Hand = "KingHearts KingSpades QueenHearts QueenDiamonds ThreeSpades";
		
		round.addPlayer(1 + " " + player1Hand);
		round.addPlayer(2 + " " + player2Hand);
		round.getRankedHands();
		round.addPlayer(3 + " " + player3Hand);
		
		fail(); // Test fails if it gets here, exception should've been thrown by now
	}

	@Test(expected=Exception.class)
	public void testAddPlayersOutOfOrder() throws Exception {
		Round round = new Round();
		String player1Hand = "TwoHearts AceSpades AceHearts AceDiamonds FiveSpades";
		String player2Hand = "TwoDiamonds AceClubs SixSpades SevenSpades FiveClubs";
		String player3Hand = "KingHearts KingSpades QueenHearts QueenDiamonds ThreeSpades";

		round.addPlayer(1 + " " + player1Hand);
		round.addPlayer(3 + " " + player3Hand);
		round.getRankedHands();
		round.addPlayer(2 + " " + player2Hand);
		
		fail(); // Test fails if it gets here, exception should've been thrown by now
	}
	
	@Test
	public void testGetRankedHands() throws Exception {
		Round round = new Round();
		String losingHand = "TwoHearts AceSpades QueenDiamonds SixSpades FiveSpades";
		String winningHand = "TenHearts JackHearts QueenHearts KingHearts AceHearts";

		round.addPlayer(1 + " " + losingHand); // The losing hand first
		round.addPlayer(2 + " " + winningHand);
		
		List<Hand> rankedHands = round.getRankedHands();
		
		assertEquals(rankedHands.get(0).getRanking(), Ranking.ROYAL_FLUSH);
		assertEquals(rankedHands.get(1).getRanking(), Ranking.HIGH_CARD);
	}
	
	@Test(expected=Exception.class)
	public void testDuplicateCardsBetweenHands() throws Exception {
		Round round = new Round();
		String hand1 = "TwoHearts ThreeHearts FourHearts FiveHearts SixHearts";
		String hand2 = "TwoDiamonds ThreeDiamonds FourDiamonds FiveDiamonds SixHearts";
		
		round.addPlayer(1 + " " + hand1);
		round.addPlayer(2 + " " + hand2);
		
		fail();
	}
}