import static org.junit.Assert.*;

import org.junit.Test;

public class TestHand {

	@Test
	public void testHandEmpty() {
		int arbitraryPlayerId = 1;
		String emptyHand = "";

		Hand hand = new Hand(arbitraryPlayerId, emptyHand);
		
		assertTrue(hand.getNumCards() == 0);
	}
	
	@Test
	public void testHandCardCount() {
		int arbitraryPlayerId = 1;
		String arbitraryHand = "TwoHearts AceSpades AceHearts AceDiamonds FiveSpades";

		Hand hand = new Hand(arbitraryPlayerId, arbitraryHand);
		
		assertTrue(hand.getNumCards() == 5);
	}

	@Test
	public void testHandNotSorted() {
		int arbitraryPlayerId = 1;
		String arbitraryHand = "AceHearts KingSpades QueenDiamonds JackClubs NineSpades";

		Hand hand = new Hand(arbitraryPlayerId, arbitraryHand);
		
		assertFalse(hand.isSorted());
	}
	
	@Test
	public void testRankingHighCard() {
		int arbitraryPlayerId = 1;
		String highCardHand = "TwoHearts SixDiamonds NineHearts AceDiamonds FiveSpades";

		Hand hand = new Hand(arbitraryPlayerId, highCardHand);
		
		assertTrue(hand.getRanking() == Ranking.HIGH_CARD);
	}
	
	@Test
	public void testRankingOnePair() {
		int arbitraryPlayerId = 1;
		String onePairHand = "AceHearts AceSpades KingHearts QueenSpades JackDiamonds";
		String highCardHand = "TwoHearts SixDiamonds NineHearts AceDiamonds FiveSpades";
		
		Hand hand = new Hand(arbitraryPlayerId, onePairHand);
		
		assertTrue(hand.getRanking() == Ranking.ONE_PAIR);
		
		// Sanity check, just to make sure we're not wrongly ranking these
		Hand newHand = new Hand(arbitraryPlayerId, highCardHand);
		
		assertFalse(newHand.getRanking() == Ranking.ONE_PAIR);
	}
}
