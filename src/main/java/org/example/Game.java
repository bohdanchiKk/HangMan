package org.example;

import java.security.PublicKey;
import java.util.*;

public class Game {
    private final GameState gameState;
    private final Display display;

    public Game(GameState gameState, Display display){
        this.gameState = gameState;
        this.display = display;
    }

    public void onStart(){
        Scanner scanner = new Scanner(System.in);

        gameState.loadWord();
        display.showHangman(gameState.getErrorCount());
        display.showWord(gameState.getEncodedWord());

        while (!gameState.isGameOver()){
            String letter = scanner.next();
            gameState.attempt(letter);
            display.showHangman(gameState.getErrorCount());
            display.showWord(gameState.getEncodedWord());
            display.showMessage("Errors: "+String.valueOf(gameState.getErrorCount()));

            if (gameState.isGameOver()){
                if (gameState.isWordGuessed()){
                    display.showMessage("Victory!");
                }else display.showMessage("Better luck next time!");
            }
        }
    }

}

