package org.NewTicTacToe;

import com.google.gson.Gson;

import java.io.*;
import java.util.Scanner;

class StateManager {
    private Gson gson;
    final String fileName = "data/saved_game.json";

    public StateManager() {
        this.gson = new Gson();
    }

    public void saveGame(Board board) {
        File file = new File(fileName);
        if (!file.exists()) {
            try {
                file.createNewFile();
                System.out.println("File created: " + fileName);
            } catch (IOException e) {
                System.out.println("Failed to create file: " + fileName);
                e.printStackTrace();
            }
        }
        String json = gson.toJson(board);
        try {
            FileWriter writer = new FileWriter(fileName);
            writer.write(json);
            writer.close();
        } catch (IOException e) {
            System.out.println("An error occurred while saving the game.");
            e.printStackTrace();
        }
    }

    public Board loadGame() {
        File file = new File(fileName);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                System.out.println("Failed to create file: " + fileName);
                e.printStackTrace();
            }
        }
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String json = reader.readLine();
            reader.close();
            return gson.fromJson(json, Board.class);
        } catch (IOException e) {
            System.out.println("An error occurred while loading the game.");
            e.printStackTrace();
        }
        return null;
    }

    public void deleteSaveFile(){
        File file = new File(fileName);
        if (file.exists()) {
            boolean deleted = file.delete();
            if (deleted) {
                System.out.println("Save File deleted successfully.");
            } else {
                System.out.println("Save File could not be deleted.");
            }
        } else {
            System.out.println("Save File not found.");
        }
}
    public void saveState(String json) {
        File file = new File(fileName);
        if (!file.exists()) {
            try {
                file.createNewFile();
                System.out.println("File created: " + fileName);
            } catch (IOException e) {
                System.out.println("Failed to create file: " + fileName);
                e.printStackTrace();
            }
        }
        try (Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName), "utf-8"))) {
            writer.write(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
