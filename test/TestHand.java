import static org.junit.Assert.*;

import org.junit.Test;

public class TestHand {

	// Player ID's we can use for testing
	private static final int arbitraryPlayerId = 1;

	// Different hands we can use for testing, mostly taken from:
	//   http://www.pokerlistings.com/poker-hand-ranking
	private static final String highCardHand = "TwoHearts SixDiamonds NineHearts AceDiamonds FiveSpades";
	private static final String onePairHand = "AceHearts AceSpades KingHearts QueenSpades JackDiamonds";
	private static final String twoPairHand = "AceHearts AceSpades KingClubs KingDiamonds QueenSpades";
	private static final String threeOfAKindHand = "AceHearts AceSpades AceClubs KingSpades JackDiamonds";
	private static final String straightAceLowHand = "FiveClubs FourDiamonds ThreeSpades TwoHearts AceHearts";
	private static final String straightAceHighHand = "TenClubs JackDiamonds QueenSpades KingHearts AceHearts";
	private static final String flushHand = "AceSpades TenSpades SevenSpades SixSpades TwoSpades";
	private static final String fullHouseHand = "AceHearts AceSpades AceDiamonds KingHearts KingSpades";
	private static final String straightFlushHand = "NineClubs EightClubs SevenClubs SixClubs FiveClubs";
	private static final String royalFlushHand = "AceHearts KingHearts QueenHearts JackHearts TenHearts";
	
	@Test
	public void testHandEmpty() throws ImpossibleCardException {
		String emptyHand = "";
		Hand hand = new Hand(arbitraryPlayerId, emptyHand);
		assertTrue(hand.getNumCards() == 0);
	}
	
	@Test
	public void testHandCardCount() throws ImpossibleCardException {
		Hand hand = new Hand(arbitraryPlayerId, highCardHand);
		assertTrue(hand.getNumCards() == 5);
	}

	@Test
	public void testHandNotSorted() throws ImpossibleCardException {
		Hand hand = new Hand(arbitraryPlayerId, highCardHand);
		assertFalse(hand.isSorted());
	}
	
	@Test
	public void testRankingHighCard() throws ImpossibleCardException {
		Hand hand = new Hand(arbitraryPlayerId, highCardHand);
		assertTrue(hand.getRanking() == Ranking.HIGH_CARD);
	}
	
	@Test
	public void testRankingOnePair() throws ImpossibleCardException {
		Hand hand = new Hand(arbitraryPlayerId, onePairHand);
		assertTrue(hand.getRanking() == Ranking.ONE_PAIR);
	}
	
	@Test
	public void testRankingTwoPair() throws ImpossibleCardException {
		Hand hand = new Hand(arbitraryPlayerId, twoPairHand);
		assertTrue(hand.getRanking() == Ranking.TWO_PAIR);
	}
	
	@Test
	public void testRankingThreeOfAKind() throws ImpossibleCardException {
		Hand hand = new Hand(arbitraryPlayerId, threeOfAKindHand);
		assertTrue(hand.getRanking() == Ranking.THREE_OF_A_KIND);
	}
	
	@Test
	public void testRankingStraightAceLow() throws ImpossibleCardException {
		Hand hand = new Hand(arbitraryPlayerId, straightAceLowHand);
		assertTrue(hand.getRanking() == Ranking.STRAIGHT);
	}

	@Test
	public void testRankingStraightAceHigh() throws ImpossibleCardException {
		Hand hand = new Hand(arbitraryPlayerId, straightAceHighHand);
		assertTrue(hand.getRanking() == Ranking.STRAIGHT);
	}

	@Test
	public void testRankingFlush() throws ImpossibleCardException {
		Hand hand = new Hand(arbitraryPlayerId, flushHand);
		assertTrue(hand.getRanking() == Ranking.FLUSH);
	}
	
	@Test
	public void testRankingFullHouse() throws ImpossibleCardException {
		Hand hand = new Hand(arbitraryPlayerId, fullHouseHand);
		assertTrue(hand.getRanking() == Ranking.FULL_HOUSE);
	}
	
	@Test
	public void testRankingStraightFlush() throws ImpossibleCardException {
		Hand hand = new Hand(arbitraryPlayerId, straightFlushHand);
		assertTrue(hand.getRanking() == Ranking.STRAIGHT_FLUSH);
	}
	
	@Test
	public void testRankingRoyalFlush() throws ImpossibleCardException {
		Hand hand = new Hand(arbitraryPlayerId, royalFlushHand);
		assertTrue(hand.getRanking() == Ranking.ROYAL_FLUSH);
	}
}