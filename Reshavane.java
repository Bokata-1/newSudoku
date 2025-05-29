/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proekt;

/**
 *
 * @author Boyanvb1
 */
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author boyanvb1
 */
public class Reshavane {

    public static boolean isNumberInRow(int[][] arr, int number, int row) {
        for (int i = 0; i < 9; i++) {
            if (arr[row][i] == number) {
                return true;
            }
        }
        return false;
    }

    public static boolean isNumberInColumn(int[][] arr, int number, int column) {
        for (int i = 0; i < 9; i++) {
            if (arr[i][column] == number) {
                return true;
            }
        }
        return false;
    }

    public static boolean isNumberInSquare(int[][] arr, int number, int row, int column) {
        int localBowRow = row - row % 3;
        int localBowColumn = column - column % 3;
        for (int i = localBowRow; i < localBowRow + 3; i++) {
            for (int k = localBowColumn; k < localBowColumn + 3; k++) {
                if (arr[i][k] == number) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isValidPlacement(int[][] arr, int number, int row, int column) {
        return !isNumberInRow(arr, number, row)
                && !isNumberInColumn(arr, number, column)
                && !isNumberInSquare(arr, number, row, column);
    }

    public static boolean solveBoard(int arr[][]) {
        for (int i = 0; i < 9; i++) {
            for (int k = 0; k < 9; k++) {
                if (arr[i][k] == 0) {
                    for (int numberToTry = 1; numberToTry <= 9; numberToTry++) {
                        if (isValidPlacement(arr, numberToTry, i, k)) {
                            arr[i][k] = numberToTry;
                            if (solveBoard(arr)) {
                                return true;
                            } else {
                                arr[i][k] = 0;
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;

    }

    public static void printBoard(int[][] arr) {
        for (int i = 0; i < 0; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.println(arr[i][j] + ",");
            }
            System.out.println("");
        }
    }

    public static void main(String[] args) {
        int board[][] = {
            {7, 0, 2, 0, 5, 0, 6, 0, 0},
            {0, 0, 0, 0, 0, 3, 0, 0, 0},
            {1, 0, 0, 0, 0, 9, 5, 0, 0},
            {8, 0, 0, 0, 0, 0, 0, 9, 0},
            {0, 4, 3, 0, 0, 0, 7, 5, 0},
            {0, 9, 0, 0, 0, 0, 0, 0, 8},
            {0, 0, 9, 7, 0, 0, 0, 0, 5},
            {0, 0, 0, 2, 0, 0, 0, 0, 0},
            {0, 0, 7, 0, 4, 0, 2, 0, 3}
        
        };
        
        System.out.println(solveBoard(board));
        for(int i = 0;i<9;i++){
            for(int k = 0;k<9;k++){
                System.out.print(board[i][k]);
            }
            System.out.println("");
        }
         
    }
}

/**
 *
 * @author Lenovo
 */
/**
 *
 * @author boyanvb1
 */
