import static org.junit.Assert.*;

import org.junit.Test;

public class TestGame {

	@Test
	public void testGameNoPlayers() {
		Game game = new Game();

		assertTrue(game.getNumPlayers() == 0);
	}

}
