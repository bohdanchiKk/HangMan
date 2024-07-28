package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class HangmanGameState implements GameState{
    private int errorCounter = 0;
    private String encodedWord;
    private String originalWord;
    private boolean gameIsOver = false;
    private Set<Character> guessedLetters = new HashSet<>();

    @Override
    public void initialize(String word) {
        originalWord = word;
        encodedWord = "*".repeat(word.length());
    }

    @Override
    public void attempt(String letter) {
        if (guessedLetters.contains(letter.charAt(0))){
            System.out.println("You already guessed that letter. Try another one)");
            return;
        }
        guessedLetters.add(letter.charAt(0));
        StringBuilder builder = new StringBuilder(encodedWord);
        if (originalWord.contains(letter)){
            for (int i = 0; i<originalWord.length(); i++){
                if (originalWord.charAt(i)==letter.charAt(0)){
                    builder.setCharAt(i,letter.charAt(0));
                }
            }
        }else {
            errorCounter++;
        }
        encodedWord = builder.toString();
        if (errorCounter==6 || isWordGuessed()){
            gameIsOver = true;
        }
    }

    @Override
    public void loadWord() {
        try {
            Random random = new Random();
            List<String> wordList = Files.readAllLines(Paths.get("word.txt"));
            initialize(wordList.get(random.nextInt(wordList.size())));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean isGameOver() {
        return gameIsOver;
    }

    @Override
    public boolean isWordGuessed() {
        return encodedWord.equals(originalWord);
    }

    @Override
    public int getErrorCount() {
        return errorCounter;
    }

    @Override
    public String getEncodedWord() {
        return encodedWord;
    }
}
