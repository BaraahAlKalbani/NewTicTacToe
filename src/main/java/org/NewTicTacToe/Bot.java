package org.NewTicTacToe;
import java.util.Random;
public class Bot extends Player {
    public Bot(String name, String symbol) {
        super(name, symbol);
    }
    public int[] makeMove(String[][] board) {
        Random random = new Random();
        int row, col;
        do {
            row = random.nextInt(3);
            col = random.nextInt(3);
        } while (!Board.isEmptyCell(row, col));
        return new int[]{row, col};
    }
}