
public class Hand {
	
	String[] cards;
	
	public Hand(int playerId, String cards) {
		if(cards.trim().equals("")) {
			this.cards = new String[0];
		} else {
			this.cards = cards.split("\\s+");
		}
	}
	
	public int getNumCards() {
		return cards.length;
	}
	
}
