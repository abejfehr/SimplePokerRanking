import java.util.HashMap;

public class Game {

	private int numPlayers;
	private HashMap<Integer, String> players;
	
	public Game() {
		this.numPlayers = 0;
		this.players = new HashMap<Integer, String>();
	}
	
	public int getNumPlayers() {
		return numPlayers;
	}
	
	public void addPlayer(int playerId, String hand) {
		players.put(playerId, hand);
		++numPlayers;
	}
}
