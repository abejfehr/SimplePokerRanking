import static org.junit.Assert.*;

import org.junit.Test;

public class TestCard {

	@Test
	public void testHasValueAndSuit() throws ImpossibleCardException {
		Card twoHearts = new Card("TwoHearts");	
		assertTrue(twoHearts.getRank() == 2);
		assertTrue(twoHearts.getSuit() == Card.HEARTS);
	}
	
	@Test
	public void testCardConstructorCaseInsensetive() throws ImpossibleCardException {
		Card twoHearts = new Card("tWohEARts");
		assertTrue(twoHearts.getRank() == 2);
		assertTrue(twoHearts.getSuit() == Card.HEARTS);		
	}

	@Test(expected=ImpossibleCardException.class)
	public void testImpossibleRank() throws ImpossibleCardException {
		Card impossible = new Card("FourteenClubs");
	}
	
	@Test(expected=ImpossibleCardException.class)
	public void testImpossibleSuit() throws ImpossibleCardException {
		Card impossible = new Card("ThreeShovels");
	}
	
}
