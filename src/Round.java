import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

public class Round {

	private int numPlayers;
	private int roundState;
	private HashMap<Integer, Hand> players;
	
	/**
	 * Creates a new instance of the {@code Game} class
	 */
	public Round() {
		this.numPlayers = 0;
		this.roundState = RoundState.SETUP;
		this.players = new HashMap<Integer, Hand>();
	}
	
	/**
	 * Returns the number of players in the game
	 * 
	 * @return the number of players in the game
	 */
	public int getNumPlayers() { return numPlayers; }
	
	/**
	 * Adds a player to the round
	 * 
	 * @param hand the list of cards in the player's hand, formatted as RankSuit separated by 
	 *        whitespace. Example: "TwoHearts AceSpades"
	 * @throws Exception when the player's ID doesn't match what it should be, or when a hand is
	 *         given that contains a card already in use by another hand
	 */
	public void addPlayer(String player) throws Exception {
		if(roundState != RoundState.SETUP) {
			throw new IllegalRoundStateException();
		}
		player = player.trim();
		int playerId = Integer.parseInt(player.split("\\s")[0]);
		Hand hand = new Hand(playerId, player.substring(player.indexOf(" ")).trim());
		// Check to make sure the hand doesn't contain cards that another hand already does
		for(int i=1;i<=numPlayers;++i) {
			if(players.get(i).containsCardFrom(hand)) {
				throw new Exception();
			}
		}
		// Ensure that the player ID is as expected
		if(playerId != ++numPlayers) {
			throw new Exception();
		}
		players.put(playerId, hand);
	}
	
	/**
	 * Returns the state of the round
	 * 
	 * @return the state of the round
	 */
	public int getState() { return roundState; }
	
	/**
	 * Ranks the players based on their hands.
	 * 
	 * @throws Exception if the number of players is not within 2-4 inclusive
	 */
	public List<Hand> getRankedHands() throws Exception {
		if(numPlayers < 2 || numPlayers > 4) {
			throw new Exception();
		}
		roundState = RoundState.RANKING;
		
		List<Hand> sortedHands = new ArrayList<Hand>();
		
	    Iterator<Entry<Integer, Hand>> it = players.entrySet().iterator();
	    while (it.hasNext()) {
	        Entry<Integer, Hand> pair = it.next();
	        sortedHands.add(pair.getValue());
	    }

	    Collections.sort(sortedHands);
	    return sortedHands;
	}
}
