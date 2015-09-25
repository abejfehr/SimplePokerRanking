import java.io.IOException;
import java.util.Scanner;

public class Main {

	/**
	 * The main entry point of the game
	 */
	public static void main(String[] args) {
		// We'll need this
		Scanner input = new Scanner(System.in);
		
		System.out.println("Welcome to Simple Poker Hand Ranking.");
		System.out.println("");
		System.out.println("Please enter the number of players below:");
		int numPlayers = input.nextInt();
		
		// Add that many players
		clearConsole();
		for(int i=0;i<numPlayers;++i) {
			System.out.println("What are the cards in the player's hand?");
			input.nextLine();
		}
		
		input.close();
	}
	
	/**
	 * Clears the console
	 */
	public final static void clearConsole() {
        try {
			Runtime.getRuntime().exec(System.getProperty("os.name").contains("Windows") 
					? "cls"     // For windows
					: "clear"); // For OSX and Linux
		} catch (IOException e) {
			// Silently fail if unable to clear the screen(it's not *that* important)
		}
	}
}
