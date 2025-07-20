import java.util.ArrayList;
import java.util.List;

public class Board {

    public static List<List<Cell>> buildBoard() {
        List<List<Cell>> board = new ArrayList<>();
        for (int row = 0; row < 9; row++) {
            List<Cell> line = new ArrayList<>();
            for (int col = 0; col < 9; col++) {
                line.add(new Cell(0, false));
            }
            board.add(line);
        }
        return board;
    }

    public static void printTable(List<List<Cell>> board) {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                System.out.print(board.get(row).get(col).getNum() + " ");
            }
            System.out.println();
        }
    }

    public static boolean insertValue(List<List<Cell>> board, int line, int column, int value) {
        if (line < 0 || line > 8 || column < 0 || column > 8) {
            System.out.println("Line or column invalid.");
            return false;
        }
        if (value < 1 || value > 9) {
            System.out.println("Invalid value.");
            return false;
        }
        Cell cell = board.get(line).get(column);
        if (cell.isPlaced()) {
            System.out.println("Cannot change a fixed cell");
            return false;
        }
        cell.setNum(value);
        System.out.println("Value entered successfully");
        return true;
    }
}
