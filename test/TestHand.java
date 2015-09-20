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

}
