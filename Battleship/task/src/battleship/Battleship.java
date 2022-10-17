package battleship;

import java.util.Arrays;

public class Battleship {
    private String[][] board = new String[10][10];

    private void initializeBoard() {
        Arrays.stream(this.board).forEach(row -> Arrays.fill(row, "~"));
    }

    private void printBoard() {
        int len = this.board.length;
        System.out.println("  1 2 3 4 5 6 7 8 9 10");
        for (int y = 0; y < len; y++) {
            System.out.print(indexToLetter(y).toUpperCase());
            for (int x = 0; x < this.board[y].length; x++) {
                System.out.print(" " + this.board[y][x]);
            }
            System.out.println();
        }
    }

    private String indexToLetter(int idx) {
        switch (idx) {
            case 0:
                return "a";
            case 1:
                return "b";
            case 2:
                return "c";
            case 3:
                return "d";
            case 4:
                return "e";
            case 5:
                return "f";
            case 6:
                return "g";
            case 7:
                return "h";
            case 8:
                return "i";
            case 9:
                return "j";
        }
        return "";
    }

    private int letterToIndex(String letter) {
        switch (letter) {
            case "a":
                return 0;
            case "b":
                return 1;
            case "c":
                return 2;
            case "d":
                return 3;
            case "e":
                return 4;
            case "f":
                return 5;
            case "g":
                return 6;
            case "h":
                return 7;
            case "i":
                return 8;
            case "j":
                return 9;
        }
        return -1;
    }

    public Battleship() {
        this.initializeBoard();
    }

    public void start() {
        this.printBoard();
    }
}
