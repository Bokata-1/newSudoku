/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proektsudoku;

/**
 *
 * @author Boyanvb1
 */
import java.util.*;
 
public class SudokuGenerator {
 
    private static final int SIZE = 9;
    private static final int SUBGRIDSIZE = 3;
    private int[][] board;
 
    public SudokuGenerator() {
        board = new int[SIZE][SIZE];
        fillBoard();
    }
 
    private boolean isValid(int row, int col, int num) {
        // Проверка на реда и колоната
        for (int i = 0; i < SIZE; i++) {
            if (board[row][i] == num || board[i][col] == num)
                return false;
        }
 
        // Проверка на 3x3 подрешетката
        int startRow = row - row % SUBGRIDSIZE;
        int startCol = col - col % SUBGRIDSIZE;
 
        for (int i = 0; i < SUBGRIDSIZE; i++) {
            for (int j = 0; j < SUBGRIDSIZE; j++) {
                if (board[startRow + i][startCol + j] == num)
                    return false;
            }
        }
 
        return true;
    }
 
    private boolean fillBoard() {
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                if (board[row][col] == 0) {
                    List<Integer> numbers = new ArrayList<>();
                    for (int i = 1; i <= SIZE; i++) numbers.add(i);
                    Collections.shuffle(numbers);
 
                    for (int num : numbers) {
                        if (isValid(row, col, num)) {
                            board[row][col] = num;
                            if (fillBoard()) return true;
                            board[row][col] = 0; // backtrack
                        }
                    }
 
                    return false;
                }
            }
        }
        return true;
    }
 
    public int[][] printBoard() {
        return board;
    }
 
    public static void main(String[] args) {
        SudokuGenerator generator = new SudokuGenerator();
        generator.printBoard();
    }
}
