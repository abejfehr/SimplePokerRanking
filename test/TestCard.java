import static org.junit.Assert.*;

import org.junit.Test;

public class TestCard {

	@Test
	public void testHasValueAndSuit() {
		Card twoHearts = new Card("TwoHearts");
		
		assertTrue(twoHearts.getValue() == 2);
		assertTrue(twoHearts.getSuit() == "Hearts");
	}

}
