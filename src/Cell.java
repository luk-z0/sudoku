public class Cell {

    private Integer num;
    private final boolean placed;

    public Cell(int num, final boolean placed) {
        this.num = num;
        this.placed = placed;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        if (!placed) {
            this.num = num;
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
