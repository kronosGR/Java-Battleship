package battleship;

import java.util.Arrays;

public class Battleship {
    private String[][] board = new String[10][10];

    private void initializeBoard(){
        Arrays.stream(this.board).forEach(row -> Arrays.fill(row, "~"));
    }

    public Battleship(){
        this.initializeBoard();
    }
}
