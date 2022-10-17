package battleship;

public class Ship {
    private String name;
    private int cellsAmount;

    public Ship(String name, int cellsAmount) {
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
}
