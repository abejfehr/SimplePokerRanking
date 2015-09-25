import java.util.HashMap;

public class Game {

	private int numPlayers;
	private int gameState;
	private HashMap<Integer, String> players;
	
	/**
	 * Creates a new instance of the {@code Game} class
	 */
	public Game() {
		this.numPlayers = 0;
		this.gameState = GameState.SETUP;
		this.players = new HashMap<Integer, String>();
	}
	
	/**
	 * Returns the number of players in the game
	 * 
	 * @return the number of players in the game
	 */
	public int getNumPlayers() { return numPlayers; }
	
	/**
	 * Adds a player to the game
	 * 
	 * @param playerId the ID of the player to add
	 * @param hand the list of cards in the player's hand, formatted as RankSuit separated by 
	 *        whitespace. Example: "TwoHearts AceSpades"
	 * @throws IllegalGameStateException if the game is not in setup when trying to add a player
	 */
	public void addPlayer(int playerId, String hand) throws IllegalGameStateException {
		if(gameState != GameState.SETUP) {
			throw new IllegalGameStateException();
		}
		players.put(playerId, hand);
		++numPlayers;
	}
	
	/**
	 * Returns the state of the game
	 * 
	 * @return the state of the game
	 */
	public int getState() { return gameState; }
	
	/**
	 * Ranks the players based on their hands.
	 * 
	 * @throws Exception if the number of players is not within 2-4 inclusive
	 */
	public void rankPlayers() throws Exception {
		if(numPlayers < 2 || numPlayers > 4) {
			throw new Exception();
		}
			gameState = GameState.RANKING;
	}
}
