package battleship;

public class Ship {

    private int index;
    private String name;
    private int cellsAmount;

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

    public void placeShip(Coordinates cords){
        isPlaced = true;
        coords = cords;
    }
}
