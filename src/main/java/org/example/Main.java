package org.example;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ConsoleDisplay display = new ConsoleDisplay();
        display.showMessage("Hi! HangMan is here! Press S to start and Q to quit:");

        while (true){
            String startOrQuit = scanner.next();
            if (startOrQuit.toUpperCase(Locale.ROOT).equals("S")){
                GameState gameState = new HangmanGameState();
                Game game = new Game(gameState,display);
                game.onStart();
                display.showMessage("Would you like to play again? (S-start, Q-quit)");
            }else if (startOrQuit.toUpperCase(Locale.ROOT).equals("Q")){
                scanner.close();
                System.exit(0);
            }
        }

    }

}

