package com.example.bhupendra.firbase;

public class Player {
    String playerId;
    String playerName;
    String playerGame;

    public Player(String playerId, String playerName, String playerGame) {
        this.playerId = playerId;
        this.playerName = playerName;
        this.playerGame = playerGame;
    }

    public String getPlayerId() {
        return playerId;
    }

    public String getPlayerName() {
        return playerName;
    }

    public String getPlayerGame() {
        return playerGame;
    }
}
