
public class Card {

	private int value;
	private String suit;
	
	public static final String HEARTS = "Hearts";
	
	Card(String card) {
		// Hearts
		if(card.substring(card.length() - HEARTS.length()).equalsIgnoreCase(HEARTS)) {
			suit = HEARTS;
			value = getValueFrom(card.substring(0, card.length() - HEARTS.length()));
		}
	}
	
	public int getValue() {
		return value;
	}
	
	public String getSuit() {
		return suit;
	}
	
	private int getValueFrom(String numberString) {
		switch(numberString) {
		case "Two":
			return 2;
		default:
			return 0;
		}
	}
}
