package org.NewTicTacToe;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Player player1 = null;
        Player player2 = null;
        Board board = null;

            Scanner userInput = new Scanner(System.in);
            System.out.println("Do you want to continue a saved game? (yes/no)");
            String response = userInput.nextLine();


            StateManager stateManager = new StateManager();

            if (response.equals("yes")) {
                board = stateManager.loadGame();
                if (board==null)
                {
                    System.out.println("No Saved Game Found!! \nStarting a New Game !!");
                }
            }
            if(board==null) {
                System.out.println("Enter player 1 name: ");
                String p1Name = userInput.nextLine();
                System.out.println("Enter player 1 symbol: ");
                String p1Symbol = userInput.nextLine();
                System.out.println("Enter player 2 name: ");
                String p2Name = userInput.nextLine();
                System.out.println("Enter player 2 symbol: ");
                String p2Symbol = userInput.nextLine();
                player1 = new Player(p1Name, p1Symbol);
                player2 = new Player(p2Name, p2Symbol);
                board = new Board(player1, player2);
            }

        board.play();
    }
}
