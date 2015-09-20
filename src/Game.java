import java.util.HashMap;

public class Game {

	private int numPlayers;
	private HashMap<Integer, String> players;
	
	/**
	 * Creates a new instance of the {@code Game} class
	 */
	public Game() {
		this.numPlayers = 0;
		this.players = new HashMap<Integer, String>();
	}
	
	/**
	 * Returns the number of players in the game
	 * 
	 * @return the number of players in the game
	 */
	public int getNumPlayers() {
		return numPlayers;
	}
	
	/**
	 * Adds a player to the game
	 * 
	 * @param playerId the ID of the player to add
	 * @param hand the list of cards in the player's hand, formatted as RankSuit separated by
	 *        whitespace. Example: "TwoHearts AceSpades"
	 */
	public void addPlayer(int playerId, String hand) {
		players.put(playerId, hand);
		++numPlayers;
	}
}
