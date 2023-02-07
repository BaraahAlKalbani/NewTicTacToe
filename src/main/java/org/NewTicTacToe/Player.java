package org.NewTicTacToe;

class Player {
    public String getName() {
        return name;
    }

    String name;

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }

    String symbol;

    public Player(String name, String symbol) {
        this.name = name;
        this.symbol = new String(symbol);
    }
}