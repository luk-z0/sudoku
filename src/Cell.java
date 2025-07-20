public class Cell {

    private Integer num;
    private boolean placed;

    public Cell(int num, boolean placed) {
        this.num = num;
        this.placed = placed;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num, boolean newPlaced) {
        if (!placed) {
            this.num = num;
            this.placed = newPlaced;
        }

    }

    public boolean isPlaced() {
        return placed;
    }

    @Override
    public String toString() {
        return (num == 0) ? "" : String.valueOf(num);
    }

}
