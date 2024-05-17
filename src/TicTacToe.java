import java.util.Scanner;
import java.util.Arrays;

public class TicTacToe {
    private String[][] board;
    private int turn;
    
    public TicTacToe() {
        board = new String[][] {
            {"- ", "- ", "- "},
            {"- ", "- ", "- "},
            {"- ", "- ", "- "}
        };
        turn = 0;
    }
    
    public int getTurn() {
        return turn;
    }
    
    public void printBoard() {
        System.out.println("  0 1 2");
        for (int i = 0; i < 3; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println(" ");
        }
    }
    
    public boolean pickLocation(int row, int col) {
        if (row < 3 && col < 3) {
            return board[row][col].equals("- ");
        }
        return false;
    }
    
    public void takeTurn(int row, int col) {
        if (turn % 2 == 0) {
            board[row][col] = "X ";
        } else {
            board[row][col] = "O ";
        }
        turn += 1;
    }
    
    public boolean checkRow() {
        for (int row = 0; row < 3; row++) {
            if (board[row][0].equals(board[row][1]) && board[row][1].equals(board[row][2]) && !board[row][0].equals("- ")) {
                return true;
            }
        }
        return false;
    }

    public boolean checkCol() {
        for (int i = 0; i < 3; i++) {
            if (board[0][i].equals(board[1][i]) && board[1][i].equals(board[2][i]) && !board[0][i].equals("- ")) {
                return true;
            }
        }
        return false;
    }
    
    public boolean checkDiag() {
        if (board[0][0].equalsIgnoreCase(board[1][1]) && board[1][1].equalsIgnoreCase(board[2][2]) && !board[1][1].equals("- ")) {
            return true;
        } else if (board[0][2].equalsIgnoreCase(board[1][1]) && board[1][1].equalsIgnoreCase(board[2][0]) && !board[1][1].equals("- ")) {
            return true;
        }
        return false;
    }
    
    public boolean checkCat() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j].equals("- ")) {
                    return false;
                }
            }
        }
        return true;
    }
    
    public boolean checkWin() {
        return checkRow() || checkCol() || checkDiag();
    }
    
    public void play(Scanner scanner) {
        while (!checkWin() && !checkCat()) {
            printBoard();
            System.out.println("Player" + (turn % 2 == 0 ? " X" : " O") + ", enter your move (row & colum):");
            int row = scanner.nextInt();
            int col = scanner.nextInt();
            if (pickLocation(row, col)) {
                takeTurn(row, col);
            } else { 
                System.out.println("Invalid, try again!");
        }
    }
    
    printBoard();
    if (checkWin()) {
        System.out.println("Player" + (turn % 2 == 0 ? " O" : " X") + " wins!");
        } else {
            System.out.println("It's a tie!");
        }
    }  
}