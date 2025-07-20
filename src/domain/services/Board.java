package domain.services;

import java.util.ArrayList;
import java.util.List;

import java.util.Random;

import domain.models.Cell;

public class Board {

    private static List<List<Cell>> board = Board.buildBoard();
    public static final int TABLESIZE = 9;

    public static List<List<Cell>> buildBoard() {
        List<List<Cell>> board = new ArrayList<>();
        for (int row = 0; row < TABLESIZE; row++) {
            List<Cell> line = new ArrayList<>();
            for (int col = 0; col < TABLESIZE; col++) {
                line.add(new Cell(0, false));
            }
            board.add(line);
        }
        return board;
    }

    public static void printTable(List<List<Cell>> board) {
        for (int row = 0; row < TABLESIZE; row++) {
            for (int col = 0; col < TABLESIZE; col++) {
                System.out.print(board.get(row).get(col).getNum() + " ");
            }
            System.out.println();
        }
    }

    public static boolean insertValue(List<List<Cell>> board, int line, int column, int value) {
        if (line < 0 || line > 8 || column < 0 || column > 8) {
            return false;
        }
        if (value < 1 || value > 9) {
            return false;
        }
        Cell cell = board.get(line).get(column);
        if (cell.isPlaced()) {
            return false;
        }
        cell.setNum(value, false);
        return true;
    }

    public static void fillRandomValues(List<List<Cell>> board) {
        Random rand = new Random();

        for (int row = 0; row < TABLESIZE; row++) {
            List<Integer> usedColumns = new ArrayList<>();
            int fills = rand.nextInt(5);
            int attempts = 0;

            while (usedColumns.size() < fills && attempts < 20) {
                int col = rand.nextInt(9);

                if (usedColumns.contains(col)) {
                    attempts++;
                    continue;
                }

                int value = 1 + rand.nextInt(9);

                if (canInsert(board, row, col, value)) {
                    boolean inserted = insertValue(board, row, col, value);
                    if (inserted) {
                        usedColumns.add(col);
                    }
                }
                attempts++;
            }
        }
    }

    public static boolean canInsert(List<List<Cell>> board, int row, int col, int value) {

        for (int i = 0; i < 9; i++) {
            if (board.get(row).get(i).getNum() == value)
                return false;
            if (board.get(i).get(col).getNum() == value)
                return false;
        }

        int boxRowStart = (row / 3) * 3;
        int boxColStart = (col / 3) * 3;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board.get(boxRowStart + i).get(boxColStart + j).getNum() == value) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void removeValue(List<List<Cell>> board, int row, int col) {
        if (row < 0 || row > 8 || col < 0 || col > 8) {
            return;
        }
        Cell cell = board.get(row).get(col);
        if (cell.isPlaced()) {
            return;
        }
        cell.setNum(0, false);
    }

    public static boolean isComplete(List<List<Cell>> board) {
        for (int row = 0; row < TABLESIZE; row++) {
            for (int col = 0; col < TABLESIZE; col++) {
                int num = board.get(row).get(col).getNum();
                if (num == 0) {
                    return false;
                }
                if (!canInsert(board, row, col, num)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void reset() {
        board.stream().forEach(cell -> cell.forEach(Cell::clear));
    }

}
