
public class Card {

	private int rank = -1;
	private String suit;
	
	public static final String HEARTS = "Hearts";
	public static final String DIAMONDS = "Diamonds";
	public static final String SPADES = "Spades";
	public static final String CLUBS = "Clubs";
	
	/**
	 * Creates an instance of the {@code Card} class
	 * 
	 * @param card the RankSuit string for the rank and suit of the card
	 * @throws ImpossibleCardException 
	 */
	Card(String card) throws ImpossibleCardException {
		for(String SUIT : new String[]{ HEARTS, DIAMONDS, SPADES, CLUBS }) {
			if(card.substring(card.length() - SUIT.length()).equalsIgnoreCase(SUIT)) {
				suit = SUIT;
				rank = getRankFrom(card.substring(0, card.length() - SUIT.length()));
			}
		}
		if(rank == -1 || suit == null) {
			throw new ImpossibleCardException();
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
	 * Examples of accepted input: Three, five, ace, KING, etc.
	 * 
	 * @param rankString the numerical rank of a card written as a word
	 * @return the integer rank of a card, -1 if input is an unknown word
	 */
	private int getRankFrom(String rankString) {
		switch(rankString.toLowerCase()) {
		case "ace":
			return 1;
		case "two":
			return 2;
		case "three":
			return 3;
		case "four":
			return 4;
		case "five":
			return 5;
		case "six":
			return 6;
		case "seven":
			return 7;
		case "eight":
			return 8;
		case "nine":
			return 9;
		case "ten":
			return 10;
		case "jack":
			return 11;
		case "queen":
			return 12;
		case "king":
			return 13;
		default:
			return -1;
		}
	}
	
	/**
	 * Returns the human-readable representation of a card
	 * 
	 * @return the human-readable representation of a card
	 */
	@Override
	public String toString() {
		String rankString = null;
		switch(rank) {
		case 1:
			rankString = "Ace";
			break;
		case 11:
			rankString = "Jack";
			break;
		case 12:
			rankString = "Queen";
			break;
		case 13:
			rankString = "King";
			break;
		}
		return (rankString != null ? rankString : rank) + " of " + suit;
	}
	
	/**
	 * Determines if this card is equal to another in suit and rank
	 * 
	 * @param otherCard the card to compare with
	 * @return whether or not this card is equal to another in suit and rank
	 */
	public boolean equals(Card otherCard) {
		return (this.rank == otherCard.rank && this.suit.equals(otherCard.suit));
	}
}
