import java.util.HashMap;

public class Game {

	private int numPlayers;
	private HashMap<Integer, String> players;
	
	public Game() {
		numPlayers = 0;
		players = new HashMap<Integer, String>();
	}
	
	public int getNumPlayers() {
		return numPlayers;
	}
	
	public void addPlayer(int playerId, String hand) {
		players.put(playerId, hand);
		++numPlayers;
	}
}
