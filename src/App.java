import java.util.List;

public class App {
    public static void main(String[] args) {
        List<List<Cell>> board = Board.buildBoard();
        Board.printTable(board);

    }

}
