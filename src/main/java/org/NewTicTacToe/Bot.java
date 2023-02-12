package org.NewTicTacToe;
import com.google.gson.*;
import java.io.*;
import java.util.*;
public class Bot extends Player {
    public Bot(String name, String symbol) {
        super(name, symbol);
    }
    public static int[] makeMove(String[][] board) {
        Random random = new Random();
        int row, col;
        do {
            row = random.nextInt(3);
            col = random.nextInt(3);
        } while (!isEmptyCell(row, col));
        return new int[]{row, col};
    }
    public static boolean isEmptyCell(int row, int col) {
        String[][] grid=getGrid();
        return grid[row][col].equals("0,0") || grid[row][col].equals("0,1") || grid[row][col].equals("0,2")
                || grid[row][col].equals("1,0") || grid[row][col].equals("1,1") || grid[row][col].equals("1,2")
                || grid[row][col].equals("2,0") || grid[row][col].equals("2,1") || grid[row][col].equals("2,2");
    }
        public static String[][] getGrid() {
            // Read the JSON file
            final String fileName = "data/saved_game.json";
            JsonParser parser = new JsonParser();
            JsonObject json = null;
            try {
                json = parser.parse(new FileReader(fileName)).getAsJsonObject();
            } catch (FileNotFoundException e) {
                System.out.println("File not found");
                System.exit(1);
            }

            // Extract the grid from the JSON object
            JsonArray gridArray = json.getAsJsonArray("grid");
            String[][] grid = new String[3][3];
            for (int i = 0; i < gridArray.size(); i++) {
                JsonArray rowArray = gridArray.get(i).getAsJsonArray();
                for (int j = 0; j < rowArray.size(); j++) {
                    grid[i][j] = rowArray.get(j).getAsString();
                }
            }
            return grid;
        }
    }