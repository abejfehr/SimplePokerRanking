import static org.junit.Assert.*;

import org.junit.Test;

public class TestCard {

	@Test
	public void testHasValueAndSuit() throws ImpossibleCardException {
		Card twoHearts = new Card("TwoHearts");	
		assertEquals(twoHearts.getRank(), 2);
		assertEquals(twoHearts.getSuit(), Card.HEARTS);
	}
	
	@Test
	public void testCardConstructorCaseInsensetive() throws ImpossibleCardException {
		Card twoHearts = new Card("tWohEARts");
		assertEquals(twoHearts.getRank(), 2);
		assertEquals(twoHearts.getSuit(), Card.HEARTS);		
	}

	@Test(expected=ImpossibleCardException.class)
	public void testImpossibleRank() throws ImpossibleCardException {
		new Card("FourteenClubs");
		fail(); // Should fail if it got here before throwing an exception
	}
	
	@Test(expected=ImpossibleCardException.class)
	public void testImpossibleSuit() throws ImpossibleCardException {
		new Card("ThreeShovels");
		fail();
	}
	
}
