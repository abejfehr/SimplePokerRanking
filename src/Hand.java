
public class Hand {
	
	private String[] cards;
	
	/**
	 * Creates a new instance of the {@code Hand} class
	 * 
	 * @param playerId the player's ID in the game
	 * @param cards a whitespace separated list of cards, given in RankSuit format. For example: 
	 *        "TwoHearts AceSpades" would constitute a valid hand
	 */
	public Hand(int playerId, String cards) {
		if(cards.trim().equals("")) {
			this.cards = new String[0];
		} else {
			this.cards = cards.split("\\s+");
		}
	}
	
	/**
	 * Returns the number of cards in the hand
	 * 
	 * @return the number of cards held
	 */
	public int getNumCards() {
		return cards.length;
	}
	
	/**
	 * Returns whether or not the cards in the hand are already sorted
	 * 
	 * @return true if the hand is sorted, false if not
	 */
	public boolean isSorted() {
		return false;
	}
	
	/**
	 * Gets the ranking of the hand
	 * 
	 * @return the ranking of the hand
	 */
	public int getRanking() {
		return Ranking.HIGH_CARD;
	}
}
