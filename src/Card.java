
public class Card {

	private int rank;
	private String suit;
	
	public static final String HEARTS = "Hearts";
	public static final String DIAMONDS = "Diamonds";
	public static final String SPADES = "Spades";
	public static final String CLUBS = "Clubs";
	
	/**
	 * Creates an instance of the {@code Card} class
	 * 
	 * @param card the RankSuit string for the rank and suit of the card
	 */
	Card(String card) {
		for(String SUIT : new String[]{ HEARTS, DIAMONDS, SPADES, CLUBS }) {
			if(card.substring(card.length() - SUIT.length()).equalsIgnoreCase(SUIT)) {
				suit = SUIT;
				rank = getRankFrom(card.substring(0, card.length() - SUIT.length()));
			}
		}
	}
	
	/**
	 * The integer value of the card, with aces low
	 * <p>
	 * 
	 * @return the integer value of the card
	 */
	public int getRank() {
		return rank;
	}
	
	/**
	 * Gets the suit of the card
	 * 
	 * @return the suit of the card
	 */
	public String getSuit() {
		return suit;
	}
	
	/**
	 * Converts the rank of a card given as a string to an integer
	 * <p>
	 * Examples of accepted input: Three, Five, Ace, King, etc.
	 * 
	 * @param rankString the numerical rank of a card written as a word
	 * @return the integer rank of a card, -1 if input is an unknown word
	 */
	private int getRankFrom(String rankString) {
		switch(rankString) {
		case "Ace":
			return 1;
		case "Two":
			return 2;
		case "Three":
			return 3;
		case "Four":
			return 4;
		case "Five":
			return 5;
		case "Six":
			return 6;
		case "Seven":
			return 7;
		case "Eight":
			return 8;
		case "Nine":
			return 9;
		case "Ten":
			return 10;
		case "Jack":
			return 11;
		case "Queen":
			return 12;
		case "King":
			return 13;
		default:
			return -1;
		}
	}
}
