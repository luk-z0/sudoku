import java.util.List;
import java.util.Scanner;

import domain.models.Cell;
import domain.services.Board;

public class App {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        int opcao = 0;
        do {
            System.out.println("\n=== MENU SUDOKU ===");
            System.out.println("1. Iniciar novo jogo");
            System.out.println("2. Colocar um número");
            System.out.println("3. Remover um número");
            System.out.println("4. Visualizar jogo atual");
            System.out.println("5. Verificar status do jogo");
            System.out.println("6. Limpar jogo");
            System.out.println("7. Finalizar jogo");
            System.out.println("8. Sair");
            System.out.print("Escolha uma opção: ");

            try {
                opcao = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                opcao = -1;
            }

            switch (opcao) {
                case 1:
                    board = Board.buildBoard();
                    Board.fillRandomValues(board);
                    System.out.println("Novo jogo iniciado!");
                    Board.printTable(board);
                    break;
                case 2:
                    System.out.println("Colocar um número");
                    System.out.print("Linha (0-8): ");
                    int linha = Integer.parseInt(scanner.nextLine());
                    System.out.print("Coluna (0-8): ");
                    int coluna = Integer.parseInt(scanner.nextLine());
                    System.out.print("Valor (1-9): ");
                    int valor = Integer.parseInt(scanner.nextLine());
                    Board.insertValue(board, linha, coluna, valor);
                    break;
                case 3:
                    System.out.print("Linha (0-8): ");
                    int l = Integer.parseInt(scanner.nextLine());
                    System.out.print("Coluna (0-8): ");
                    int c = Integer.parseInt(scanner.nextLine());
                    Board.removeValue(board, l, c);
                    System.out.println("Remover um número");
                    break;
                case 4:
                    Board.printTable(board);
                    System.out.println("Visualizar jogo atual");
                    break;
                case 5:
                    if (Board.isComplete(board)) {
                        System.out.println("Parabéns! Sudoku completo.");
                    } else {
                        System.out.println("Sudoku incompleto ou inválido.");
                    }
                    System.out.println("Verificar status do jogo");
                    break;
                case 6:
                    System.out.println("Limpar jogo");
                    board = Board.buildBoard();
                    System.out.println("Jogo limpo.");
                    break;
                case 7:
                    board = Board.buildBoard();
                    System.out.println("Jogo finalizado e resetado.");
                    break;
                case 8:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }

        } while (opcao != 8);

        scanner.close();
    }
}
