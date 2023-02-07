package org.NewTicTacToe;

import com.google.gson.Gson;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Board class containing the play function
 */
class Board {
    Player player1;
    Player player2;
    String[][] grid;
    Player currentPlayer;
    /**
     * Constructor for the Board class.
     * @param player1 the first player
     * @param player2 the second player
     */
    public Board(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        this.grid = new String[][]{{"0,0", "0,1", "0,2"}, {"1,0", "1,1", "1,2"}, {"2,0", "2,1", "2,2"}};
        this.currentPlayer = player1;
    }

    /**
     * This method allows the players to play the game
     */
    public void play() {
        StateManager stateManager =new StateManager();
        boolean isFinished = false;
        while (!isFinished) {
            displayGrid();
            int[] coordinates = getMove(currentPlayer);
            grid[coordinates[0]][coordinates[1]] = currentPlayer.getSymbol();
            if (isWinningMove(coordinates[0], coordinates[1])) {
                displayGrid();
                System.out.println("Player " + currentPlayer.getName() + " wins!");
                isFinished = true;
                stateManager.deleteSaveFile();
                break;
            }
            if (isDraw()) {
                displayGrid();
                System.out.println("It's a draw.");
                isFinished = true;
                stateManager.deleteSaveFile();
                break;
            }
            currentPlayer = (currentPlayer == player1) ? player2 : player1;
            saveGame();
        }
    }
    /**
     * This method gets the player's move
     * @param currPlayer the current player
     * @return the player's move in the form of (row, column)
     */
    private int[] getMove(Player currPlayer) {
        Scanner UserInput = new Scanner(System.in);
        int row,col;

        while (true) {
            System.out.println("Player " + currPlayer.getName().toString() + ", enter your move (row column): ");
            try {
                row = UserInput.nextInt();
                col = UserInput.nextInt();
                if (row >= 0 && row < 3 && col >= 0 && col < 3) {
                    if (grid[row][col] != player1.getSymbol().toString() && grid[row][col] != player2.getSymbol().toString()) {
                        break;
                    } else {
                        System.out.println("Position already taken. Try again.");
                    }
                } else {
                    System.out.println("Invalid move. Try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Try again.");
                UserInput.nextLine();
            }
        }

        int[] move = {row, col};
        return move;
    }


    private boolean isWinningMove(int row, int col) {
        // Check if there is a winning move in the current grid
        return (grid[row][0] == grid[row][1] && grid[row][1] == grid[row][2]) ||
                (grid[0][col] == grid[1][col] && grid[1][col] == grid[2][col]) ||
                (row == col && grid[0][0] == grid[1][1] && grid[1][1] == grid[2][2]) ||
                (row + col == 2 && grid[0][2] == grid[1][1] && grid[1][1] == grid[2][0]);
    }

    private boolean isDraw() {
        // Check if the current game is a draw
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (grid[i][j] != player1.getSymbol().toString() ||grid[i][j] != player2.getSymbol().toString()) {
                    return false;
                }
            }
        }
        return true;
    }

    private void displayGrid() {
        // Display the current game grid
        System.out.println("------------------------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print((grid[i][j] == null ? " " : grid[i][j]) + " | ");
            }
            System.out.println();
            System.out.println("------------------------");
        }
    }

    private void saveGame() {
        // Save the current game state to a file
        Gson gson = new Gson();
        String json = gson.toJson(this);
        StateManager stateManager = new StateManager();
        stateManager.saveState(json);
    }


    public Player getPlayer1() {
        return player1;
    }

    public void setPlayer1(Player player1) {
        this.player1 = player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public void setPlayer2(Player player2) {
        this.player2 = player2;
    }

    public String[][] getGrid() {
        return grid;
    }

    public void setGrid(String[][] grid) {
        this.grid = grid;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
    }
}