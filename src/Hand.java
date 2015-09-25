import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.TreeMap;

public class Hand {
	
	private ArrayList<Card> cards;
	private TreeMap<String, ArrayList<Card>> cardsBySuit;
	private TreeMap<Integer, ArrayList<Card>> cardsByRank;
	
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
		cardsBySuit = new TreeMap<String, ArrayList<Card>>();
		cardsByRank = new TreeMap<Integer, ArrayList<Card>>();
		
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
		// Add empty lists for all ranks that aren't contained in your hand
		for(int i=1;i<=13;++i) {
			if(cardsByRank.get(i) == null) {
				cardsByRank.put(i, new ArrayList<Card>());
			}
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
		if(isRoyalFlush()) {
			return Ranking.ROYAL_FLUSH;
		}
		if(isStraight() && isFlush()) {
			return Ranking.STRAIGHT_FLUSH;
		}
		if(isFullHouse()) {
			return Ranking.FULL_HOUSE;
		}
		if(isFlush()) {
			return Ranking.FLUSH;
		}
		if(isStraight()) {
			return Ranking.STRAIGHT;
		}
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
	 * if the hand contains two pairs
	 * 
	 * @return whether or not the hand contains one pair
	 */
	private boolean isOnePair() {
	    Iterator<Entry<Integer, ArrayList<Card>>> it = cardsByRank.entrySet().iterator();
	    while (it.hasNext()) {
	        Entry<Integer, ArrayList<Card>> pair = it.next();
	        if(cardsByRank.get(pair.getKey()).size() == 2) {
	        	return true;
	        }
	    }
	    return false;
	}
	
	/**
	 * Returns whether or not the hand contains two pairs
	 * 
	 * @return whether or not the hand contains two pairs
	 */
	private boolean isTwoPair() {
		// Store the number of pairs
	    int count = 0;
	    // Loop through the cards(by rank)
	    Iterator<Entry<Integer, ArrayList<Card>>> it = cardsByRank.entrySet().iterator();
	    while (it.hasNext()) {
	        Entry<Integer, ArrayList<Card>> pair = it.next();
	        if(cardsByRank.get(pair.getKey()).size() == 2) {
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
	        Entry<Integer, ArrayList<Card>> pair = it.next();
	        if(cardsByRank.get(pair.getKey()).size() == 3) {
	        	return true;
	        }
	    }
	    return false;
	}
	
	/**
	 * Returns whether or not the hand is a straight
	 * <p>
	 * Warning: This is a private method because it is not meant to be called outside the context
	 * of the checks done in {@code getRanking()}. This method will return true for straights even
	 * if the hand contains a straight flush or royal flush
	 * 
	 * @return whether or not the hand is a straight
	 */
	private boolean isStraight() {
	    // Store the number of consecutive cards in a row we've seen so far
	    int cardsInARow = 0;
	    // Loop through the cards(by rank) and check for a straight
	    cardsInARow = 0;
	    for(int i=1;i<15;++i) { // Loops through all cards including Ace as a high card
	    	if(cardsByRank.get(i % 14 == 0 ? 1 : i).size() == 1) {
	        	if(++cardsInARow == 5) {
	        		return true;
	        	}
	    	} else {
        		// Reset the number of consecutive cards seen
        		cardsInARow = 0;
        	}
	    }
		return false;
	}

	/**
	 * Returns whether or not the hand is a flush
	 * <p>
	 * Warning: This is a private method because it is not meant to be called outside the context
	 * of the checks done in {@code getRanking()}. This method will return true for flushes even if
	 * the hand contains a straight flush or royal flush
	 * 
	 * @return whether or not the hand is a flush
	 */
	private boolean isFlush() {
	    Iterator<Entry<String, ArrayList<Card>>> it = cardsBySuit.entrySet().iterator();
	    while (it.hasNext()) {
	        Entry<String, ArrayList<Card>> pair = it.next();
	        if(cardsBySuit.get(pair.getKey()).size() == 5) {
	        	return true;
	        }
	    }
	    return false;
	}

	/**
	 * Returns whether or not the hand is a full house
	 * 
	 * @return whether or not the hand is a flush
	 */
	private boolean isFullHouse() {
		boolean hasThreeOfAKind = false, hasPair = false;
	    Iterator<Entry<Integer, ArrayList<Card>>> it = cardsByRank.entrySet().iterator();
	    while (it.hasNext()) {
	        Entry<Integer, ArrayList<Card>> pair = it.next();
	        if(cardsByRank.get(pair.getKey()).size() == 3) {
	        	hasThreeOfAKind = true;
	        } else if(cardsByRank.get(pair.getKey()).size() == 2) {
	        	hasPair = true;
	        }
	    }
	    return hasThreeOfAKind && hasPair;
	}
	
	/**
	 * Returns whether or not the hand is a royal flush
	 * 
	 * @return whether or not the hand is a royal flush
	 */
	private boolean isRoyalFlush() {
		return isStraight() &&                   // A royal flush has a straight...
			   isFlush() &&                      // ...a flush...
			   cardsByRank.get(1).size() == 1 && // ...contains an ace...
			   cardsByRank.get(13).size() == 1;  // ...and a king(to make sure it wasn't a low ace)
	}
}
