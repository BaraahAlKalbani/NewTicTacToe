package org.NewTicTacToe;
import java.util.Scanner;
/**
 * Main class to run the Tic Tac Toe game
 */
public class Main {
    /**
     * Main class to run the Tic Tac Toe game
     */
    public static void main(String[] args) {
        Player player1 = null; // Initialize player1 as null
        Player player2 = null; // Initialize player2 as null
        Board board = null; // Initialize board as null
        Scanner userInput = new Scanner(System.in); // Scanner to get input from user
        System.out.println("Do you want to continue a saved game? (yes/no)");
        String response = userInput.nextLine(); // Get response from user

        StateManager stateManager = new StateManager(); // Create object of StateManager

        if (response.equals("yes")) {
            board = stateManager.loadGame(); // Load the saved game
            if (board == null) {
                System.out.println("No Saved Game Found!! \nStarting a New Game !!");
            }
        }
        if (board == null) {
            // Get player details if no saved game is found
            System.out.println("Enter player 1 name: ");
            String p1Name = userInput.nextLine();
            System.out.println("Enter player 1 symbol: ");
            String p1Symbol = userInput.nextLine();
            System.out.println("Do you want to play against a Bot? (yes/no)");
            String playAgainstBot = userInput.nextLine();
            player1 = new Player(p1Name, p1Symbol);
            if (playAgainstBot.equals("yes")) {
                player2 = new Bot("Bot", "O");
            } else {
                System.out.println("Enter player 2 name: ");
                String p2Name = userInput.nextLine();
                System.out.println("Enter player 2 symbol: ");
                String p2Symbol = userInput.nextLine();
                player2 = new Player(p2Name, p2Symbol);
            }
            board = new Board(player1, player2);
        }
        board.play(); // Start the game
    }
}