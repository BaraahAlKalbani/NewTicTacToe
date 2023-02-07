package org.NewTicTacToe;

/**
 * Player Class To get/set the player Symbol and name
 */
class Player {
    private String name; // variable to store the name of the player
    private String symbol; // variable to store the symbol of the player
    /**
     * Constructor to initialize the name and symbol of the player
     * @param name: name of the player
     * @param symbol: symbol of the player
     */
    public Player(String name, String symbol) {
        this.name = name;
        this.symbol = new String(symbol);
    }

    /**
     * Get the name of the player
     * @return name of the player
     */
    public String getName() {
        return name;
    }

    /**
     * Set the symbol of the player
     * @param symbol: symbol of the player
     */
    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    /**
     * Get the symbol of the player
     * @return symbol of the player
     */
    public String getSymbol() {
        return symbol;
    }
}