package battleship;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static battleship.Coordinates.indexToLetter;
import static battleship.Coordinates.letterToIndex;

public class Battleship {
    private String[][] board = new String[10][10];
    private List<Ship> ships = new ArrayList<>();
    Ship[] placedShips;
    private Scanner sc = new Scanner(System.in);

    private static String CELL_SHIP = "O";
    private static String CELL_EMPTY = "~";
    private static String CELL_HIT = "X";
    private static String CELL_MISS = "M";


    private void initializeBoard() {
        Arrays.stream(this.board).forEach(row -> Arrays.fill(row, CELL_EMPTY));
    }

    private void initializeShips() {
        ships.add(new Ship(1, "Aircraft Carrier", 5));
        ships.add(new Ship(2, "Battleship", 4));
        ships.add(new Ship(3, "Submarine", 3));
        ships.add(new Ship(4, "Cruiser", 3));
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

    private Ship getShipWithIndex(int index) {
        for (Ship tmp : ships) {
            if (tmp.getIndex() == index) {
                return tmp;
            }
        }
        return null;
    }

    private boolean isSizeCorrect(Ship ship, Coordinates cords) {
        if (goingVertically(cords.getFromX(), cords.getToX())) {
            return Math.abs(letterToIndex(cords.getToY()) - letterToIndex(cords.getFromY())) == ship.getCellsAmount() - 1;
        } else if (goingHorizontally(cords.getFromY(), cords.getToY())) {
            return Math.abs(Integer.parseInt(cords.getToX()) - Integer.parseInt(cords.getFromX())) == ship.getCellsAmount() - 1;
        }
        return false;
    }

    private boolean isLine(Coordinates cords) {
        return cords.getToX().equals(cords.getFromX()) || cords.getToY().equals(cords.getFromY());
    }

    private boolean isClose(Ship _ship, Coordinates coords) {
        for (Ship ship : ships) {
            if (ship != _ship && ship.isPlaced()) {
                for (int i = coords.getFromYn(); i <= coords.getToYn() + 1; i++) {
                    for (int j = coords.getFromXn(); j <= coords.getToXn() + 1; j++) {
                        if ((i == ship.getCoords().getFromYn() && j == ship.getCoords().getFromXn())
                                || (i == ship.getCoords().getToYn() && j == ship.getCoords().getToXn())) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    private void addShip(Ship ship, Coordinates cords) {

        if (goingVertically(cords.getFromX(), cords.getToX())) {
            // vertically
            for (int i = 0; i < ship.getCellsAmount(); i++) {
                board[letterToIndex(cords.getFromY()) + i][Integer.parseInt(cords.getFromX()) - 1] = CELL_SHIP;
                ship.placeShip(cords);
            }
        } else if (goingHorizontally(cords.getFromY(), cords.getToY())) {
            // horizontally
            for (int i = 0; i < ship.getCellsAmount(); i++) {
                board[letterToIndex(cords.getFromY())][Integer.parseInt(cords.getFromX()) + i - 1] = CELL_SHIP;
                ship.placeShip(cords);
            }
        }
    }

    private static Coordinates checkCordsAndReverse(Coordinates cords) {
        // check and reverse cords
        if (Integer.parseInt(cords.getFromX()) > Integer.parseInt(cords.getToX())
                || letterToIndex(cords.getFromY()) > letterToIndex(cords.getToY())) {
            String tmp = cords.getFrom();
            cords.setFrom(cords.getTo());
            cords.setTo(tmp);
        }
        return cords;
    }

    private static boolean goingVertically(String fromX, String toX) {
        return fromX.equals(toX);
    }

    private static boolean goingHorizontally(String fromY, String toY) {
        return fromY.equals(toY);
    }

    private void askForShips() {
        for (int i = 1; i <= ships.size(); i++) {
            Ship tmp = getShipWithIndex(i);
            int shipLength = tmp.getCellsAmount();
            System.out.println();
            String text = String.format("Enter the coordinates of the %s (%d cells):", tmp.getName(), shipLength);
            System.out.println(text);

            // ask for coordinates
            String coords = sc.nextLine();
            if (Coordinates.isValidCords(coords)) {
                Coordinates cords = new Coordinates(coords);
                cords = checkCordsAndReverse(cords);

                // check if is line
                if (!isLine(cords)) {
                    System.out.println("Error! Wrong ship location! Try again:");
                    while (true) {
                        coords = sc.nextLine();
                        Coordinates tmpC = new Coordinates(coords);
                        cords = checkCordsAndReverse(tmpC);
                        if (isLine(cords)) {
                            break;
                        }
                        System.out.println("Error! Wrong ship location! Try again:");
                    }
                }

                // check if size is correct
                if (!isSizeCorrect(tmp, cords)) {
                    System.out.println("Error! Wrong length of the " + tmp.getName() + "! Try again:");
                    while (true) {
                        coords = sc.nextLine();
                        Coordinates tmpC = new Coordinates(coords);
                        cords = checkCordsAndReverse(tmpC);
                        if (isSizeCorrect(tmp, cords)) {
                            break;
                        }
                        System.out.println("Error! Wrong length of the " + tmp.getName() + "! Try again:");
                    }
                }

                // check if close to another
                if (isClose(tmp, cords)) {
                    System.out.println("Error! You placed it too close to another one. Try again:");
                    while (true) {
                        coords = sc.nextLine();
                        Coordinates tmpC = new Coordinates(coords);
                        cords = checkCordsAndReverse(tmpC);
                        if (!isClose(tmp, cords)) {
                            break;
                        }
                        System.out.println("Error! You placed it too close to another one. Try again:");
                    }
                }

                addShip(tmp, cords);
                printBoard();
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
