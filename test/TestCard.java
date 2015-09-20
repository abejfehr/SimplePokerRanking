import static org.junit.Assert.*;

import org.junit.Test;

public class TestCard {

	@Test
	public void testHasValueAndSuit() {
		Card twoHearts = new Card("TwoHearts");
		
		assertTrue(twoHearts.getRank() == 2);
		assertTrue(twoHearts.getSuit() == Card.HEARTS);
	}

}
