package battleship;

import java.util.Arrays;

public class Ship {

    private int index;
    private String name;
    private int cellsAmount;
    private String[] cells;
    private boolean isDead = false;

    public boolean isPlaced() {
        return isPlaced;
    }

    public Coordinates getCoords() {
        return coords;
    }

    private boolean isPlaced = false;
    private Coordinates coords;

    public Ship(int index, String name, int cellsAmount) {
        this.index = index;
        this.name = name;
        this.cellsAmount = cellsAmount;
        this.cells = new String[cellsAmount];
        Arrays.fill(this.cells, "O");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCellsAmount() {
        return cellsAmount;
    }

    public void setCellsAmount(int cellsAmount) {
        this.cellsAmount = cellsAmount;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public boolean getIsDead(){
        return isDead;
    }

    public void placeShip(Coordinates cords){
        isPlaced = true;
        coords = cords;
    }

    public boolean isFinalHit(int idx){
        this.cells[idx] = "X";
        for (String s: this.cells){
            if (!s.equals("X")){
                return false;
            }
        }
        this.isDead = true;
        return true;
    }
}
