package org.example;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        int errorCounter = 0;

        List<String> wordList = new ArrayList<>(Arrays.asList("cat","dog"));
//        drawStatus(errorCounter);
        String word = "dog";
//        gameStart(word,'o');
        System.out.println("Hi! HangMan is here! Press S to start and Q to quit");
        Scanner scanner = new Scanner(System.in);
        var started = false;
        while (!started){
//           String gameStatus = read.;sd
           if (gameStatus=="S"){
               gameStart(word,'o');
               started = true;
           }else if (gameStatus=="Q"){
               System.out.println("End");
               break;
           }

        }


        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.

    }
    public static void gameStart(String word,Character letter){
        for (int i = 0; i<word.length(); i++){
            if (letter==word.charAt(i)){
                System.out.print(letter);
                continue;
            }
            System.out.print("_");
        }
    }

    public static void drawStatus(int counter) {
        switch (counter) {
            case 0:
                System.out.println("----\n \nSTART \n  \n----");
            case 1:
                System.out.println("----\n 0\n   \n----");
            case 2:
                System.out.println("----\n 0\n | \n----");
            case 3:
                System.out.println("----\n 0\n |\n/ \n----");
            case 4:
                System.out.println("----\n 0\n |\n/ \\ \n----");
            case 5:
                System.out.println("----\n \nDEAD\n  \n----");
        }
    }
}

