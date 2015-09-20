import static org.junit.Assert.*;

import org.junit.Test;

public class TestHand {

	@Test
	public void testHandEmpty() {
		Hand hand = new Hand(1, "");
		
		assertTrue(hand.getNumCards() == 0);
	}

}
