import static org.junit.Assert.*;

import org.junit.Test;

public class TestHand {

	// Player ID's we can use for testing
	private static final int arbitraryPlayerId = 1;

	// Different hands we can use for testing, taken from:
	//   http://www.pokerlistings.com/poker-hand-ranking
	private static final String highCardHand = "TwoHearts SixDiamonds NineHearts AceDiamonds FiveSpades";
	private static final String onePairHand = "AceHearts AceSpades KingHearts QueenSpades JackDiamonds";
	private static final String twoPairHand = "AceHearts AceSpades KingClubs KingDiamonds QueenSpades";
	private static final String threeOfAKindHand = "AceHearts AceSpades AceClubs KingSpades JackDiamonds";


	@Test
	public void testHandEmpty() {
		String emptyHand = "";
		Hand hand = new Hand(arbitraryPlayerId, emptyHand);
		assertTrue(hand.getNumCards() == 0);
	}
	
	@Test
	public void testHandCardCount() {
		Hand hand = new Hand(arbitraryPlayerId, highCardHand);
		assertTrue(hand.getNumCards() == 5);
	}

	@Test
	public void testHandNotSorted() {
		Hand hand = new Hand(arbitraryPlayerId, highCardHand);
		assertFalse(hand.isSorted());
	}
	
	@Test
	public void testRankingHighCard() {
		Hand hand = new Hand(arbitraryPlayerId, highCardHand);
		assertTrue(hand.getRanking() == Ranking.HIGH_CARD);
	}
	
	@Test
	public void testRankingOnePair() {
		Hand hand = new Hand(arbitraryPlayerId, onePairHand);
		assertTrue(hand.getRanking() == Ranking.ONE_PAIR);
		// Sanity check, just to make sure we're not wrongly ranking these
		Hand newHand = new Hand(arbitraryPlayerId, highCardHand);
		assertFalse(newHand.getRanking() == Ranking.ONE_PAIR);
	}
	
	@Test
	public void testRankingTwoPair() {
		Hand hand = new Hand(arbitraryPlayerId, twoPairHand);
		assertTrue(hand.getRanking() == Ranking.TWO_PAIR);
		// Sanity check, just to make sure we're not wrongly ranking these
		Hand newHand = new Hand(arbitraryPlayerId, onePairHand);
		assertFalse(newHand.getRanking() == Ranking.TWO_PAIR);
	}
	
	@Test
	public void testRankingThreeOfAKind() {
		Hand hand = new Hand(arbitraryPlayerId, threeOfAKindHand);
		assertTrue(hand.getRanking() == Ranking.THREE_OF_A_KIND);		
		// Sanity check, just to make sure we're not wrongly ranking these
		Hand newHand = new Hand(arbitraryPlayerId, onePairHand);
		assertFalse(newHand.getRanking() == Ranking.THREE_OF_A_KIND);
	}
}
