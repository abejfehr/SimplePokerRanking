import java.io.IOException;
import java.util.Scanner;

public class Main {

	private static int currentRound = 1;
	private static boolean playing = true;
	
	/**
	 * The main entry point of the game
	 */
	public static void main(String[] args) {
		// We'll need this
		Scanner input = new Scanner(System.in);
		
		System.out.println("Welcome to Simple Poker Ranking!\n");
		
		while(playing) {
			Round round = new Round();
			System.out.println("Round " + currentRound++);
			System.out.println("Type each player's hand. When you're finished "
					+ "entering hands, press enter with a blank prompt.");
			String inputString = null;
			int playerNumber = 1;
			do {
				System.out.print("Player " + playerNumber + "'s Hand> ");
				inputString = input.nextLine();
				if(inputString.trim().isEmpty()) { break; }
				try {
					round.addPlayer(inputString);
					++playerNumber;
				} catch (Exception e) {
					System.out.println("Failed to add the player.");
					System.out.println("Ensure that none of your cards are spelled wrong, your "
							+ "hand contains 5 cards, and that there are no duplicates.");
				}
			} while(!inputString.trim().isEmpty());
		
			System.out.println("Ranking Hands now");
			
			// Print out the hands in order somehow
			//ArrayList<Hand> rankedHands = round.getRankedHands();
			
			System.out.println("Would you like to try another round?");
			do {
				System.out.print("Response (y/n): ");
				inputString = input.nextLine();
				if(inputString.trim().equals("y")) {
					break;
				} else if(inputString.trim().equals("n")) {
					System.out.println("Thanks for playing!");
					playing = false;
					break;
				}
			} while(!inputString.trim().equalsIgnoreCase("y"));
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
