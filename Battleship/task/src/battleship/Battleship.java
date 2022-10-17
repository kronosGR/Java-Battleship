package battleship;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Battleship {
    private String[][] board = new String[10][10];
    private List<Ship> ships = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);

    private void initializeBoard() {
        Arrays.stream(this.board).forEach(row -> Arrays.fill(row, "~"));
    }

    private void initializeShips() {
        ships.add(new Ship(1, "Aircraft Carrier", 5));
        ships.add(new Ship(2, "Battleship", 4));
        ships.add(new Ship(3, "Submarine", 3));
        ships.add(new Ship(4, "Cruise", 3));
        ships.add(new Ship(5, "Destroyer", 2));
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

    private Ship getShipWithIndex(int index) {
        for (Ship tmp : ships) {
            if (tmp.getIndex() == index) {
                return tmp;
            }
        }
        return null;
    }

    private void askForShips() {
        for (int i = 1; i <= ships.size(); i++) {
            Ship tmp = getShipWithIndex(i);
            String text = String.format("Enter the coordinate for the %s (%d cells):", tmp.getName(), tmp.getCellsAmount());
            System.out.println(text);

            // ask for coordinates
            String coords = sc.nextLine();
            if(Coordinates.isValidCords(coords)) {
                Coordinates cords = new Coordinates(coords);
                String from = cords.getFrom();
                String to = cords.getTo();

                // add to board
                // TODO check if all cells are free and inside the board
            }

        }
    }

    public Battleship() {
        this.initializeBoard();
        this.initializeShips();
    }

    public void start() {
        this.printBoard();
        this.askForShips();
    }
}
