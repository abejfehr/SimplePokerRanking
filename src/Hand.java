import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class Hand {
	
	private ArrayList<Card> cards;
	private HashMap<String, ArrayList<Card>> cardsBySuit;
	private HashMap<Integer, ArrayList<Card>> cardsByRank;
	
	/**
	 * Creates a new instance of the {@code Hand} class
	 * 
	 * @param playerId the player's ID in the game
	 * @param cards a whitespace separated list of cards, given in RankSuit format. For example: 
	 *        "TwoHearts AceSpades" would constitute a valid hand
	 */
	public Hand(int playerId, String hand) {
		
		// Initialize the lists of cards
		cards = new ArrayList<Card>();
		cardsBySuit = new HashMap<String, ArrayList<Card>>();
		cardsByRank = new HashMap<Integer, ArrayList<Card>>();
		
		String[] rankSuits;
		if(hand.trim().equals("")) {
			rankSuits = new String[0];
		} else {
			rankSuits = hand.split("\\s+");
		}
		for(String rankSuit : rankSuits) {
			Card card = new Card(rankSuit);
			// Add the card to the regular list
			cards.add(card);
			// Add the card to the list organized by suit
			ArrayList<Card> suitList = cardsBySuit.get(card.getSuit());
			if(suitList == null) {
				suitList = new ArrayList<Card>();
			}
			suitList.add(card);
			cardsBySuit.put(card.getSuit(), suitList);
			// Add the card to the list organized by rank
			ArrayList<Card> rankList = cardsByRank.get(card.getRank());
			if(rankList == null) {
				rankList = new ArrayList<Card>();
			}
			rankList.add(card);
			cardsByRank.put(card.getRank(), rankList);
		}
	}
	
	/**
	 * Returns the number of cards in the hand
	 * 
	 * @return the number of cards held
	 */
	public int getNumCards() {
		return cards.size();
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
		
		if(isThreeOfAKind()) {
			return Ranking.THREE_OF_A_KIND;
		}
		if(isTwoPair()) {
			return Ranking.TWO_PAIR;
		}
		if(isOnePair()) {
			return Ranking.ONE_PAIR;
		}
		return Ranking.HIGH_CARD;
	}
	
	/**
	 * Returns whether or not the hand contains one pair
	 * <p>
	 * Warning: This is a private method because it is not meant to be called outside the context
	 * of the checks done in {@code getRanking()}. This method will return true for one pair even
	 * if the hand contains two pairs or three of a kind.
	 * 
	 * @return whether or not the hand contains one pair
	 */
	private boolean isOnePair() {
	    Iterator<Entry<Integer, ArrayList<Card>>> it = cardsByRank.entrySet().iterator();
	    while (it.hasNext()) {
	        Map.Entry pair = (Map.Entry)it.next();
	        if(cardsByRank.get(pair.getKey()).size() >= 2) {
	        	return true;
	        }
	    }
	    return false;
	}
	
	/**
	 * Returns whether or not the hand contains two pairs
	 * <p>
	 * Warning: This is a private method because it is not meant to be called outside the context
	 * of the checks done in {@code getRanking()}. This method will return true for two pairs even
	 * if the hand contains a full house
	 * 
	 * @return whether or not the hand contains two pairs
	 */
	private boolean isTwoPair() {
	    Iterator<Entry<Integer, ArrayList<Card>>> it = cardsByRank.entrySet().iterator();
	    int count = 0;
	    while (it.hasNext()) {
	        Map.Entry pair = (Map.Entry)it.next();
	        if(cardsByRank.get(pair.getKey()).size() >= 2) {
	        	++count;
	        }
	    }
	    return count >= 2;
	}

	
	/**
	 * Returns whether or not the hand contains three of a kind
	 * <p>
	 * Warning: This is a private method because it is not meant to be called outside the context
	 * of the checks done in {@code getRanking()}. This method will return true for three of a kind
	 * even if the hand contains a full house
	 * 
	 * @return whether or not the hand contains three of a kind
	 */
	private boolean isThreeOfAKind() {
	    Iterator<Entry<Integer, ArrayList<Card>>> it = cardsByRank.entrySet().iterator();
	    while (it.hasNext()) {
	        Map.Entry pair = (Map.Entry)it.next();
	        if(cardsByRank.get(pair.getKey()).size() >= 3) {
	        	return true;
	        }
	    }
	    return false;
	}
}
