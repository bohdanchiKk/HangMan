package org.example;

public class ConsoleDisplay implements Display{
    @Override
    public void showMessage(String message) {
        System.out.println(message);
    }

    @Override
    public void showHangman(int state) {
        switch (state) {
            case 0:
                System.out.println("----\n|  |\n|   \n|START \n|   \n|   \n|____");
                break;
            case 1:
                System.out.println("----\n|  |\n|  0\n|   \n|   \n|   \n|____");
                break;
            case 2:
                System.out.println("----\n|  |\n|  0\n|  |\n|   \n|   \n|____");
                break;
            case 3:
                System.out.println("----\n|  |\n|  0\n| /|\n|   \n|   \n|____");
                break;
            case 4:
                System.out.println("----\n|  |\n|  0\n| /|\\\n|   \n|   \n|____");
                break;
            case 5:
                System.out.println("----\n|  |\n|  0\n| /|\\\n| /  \n|   \n|____");
                break;
            case 6:
                System.out.println("----\n|  |\n|  0\n| /|\\\n| / \\\n|   \n|_D_E_A_D_");
                break;
        }
    }

    @Override
    public void showWord(String word) {
        System.out.println("The word: "+word);
    }
}
