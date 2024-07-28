package org.example;

public interface GameState {
    void initialize(String word);
    void attempt(String word);
    void loadWord();
    boolean isGameOver();
    boolean isWordGuessed();
    int getErrorCount();
    String getEncodedWord();
}
