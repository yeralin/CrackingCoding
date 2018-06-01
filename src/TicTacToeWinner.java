import javafx.util.Pair;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/*
    Find out who won TicTacToe given filled board
 */
public class TicTacToeWinner {
    public enum Point {Red, Blue, Null}

    static int traverse(Point[][] board, int row, int col, int counter) {
        Point type = board[row][col]; // Red/Blue
        board[row][col] = Point.Null;
        if (row+1 < board.length && board[row+1][col].equals(type)) {
            counter = traverse(board, row+1, col, counter+1);
        } else if (row-1 >= 0 && board[row-1][col].equals(type)) {
            counter = traverse(board, row+1, col, counter+1);
        } else if (col+1 < board[row].length && board[row][col+1].equals(type)) {
            counter = traverse(board, row, col+1, counter+1);
        } else if (col-1 >= 0 && board[row][col-1].equals(type)) {
            counter = traverse(board, row, col-1, counter+1);
        } else if (row+1 < board.length && col+1 < board[row+1].length && board[row+1][col+1].equals(type)) {
            counter = traverse(board, row+1, col+1, counter+1);
        } else if (row+1 < board.length && col-1 >= 0 && board[row+1][col-1].equals(type)) {
            counter = traverse(board, row+1, col-1, counter+1);
        } else if (row-1 >= 0 && col-1 >= 0 && board[row-1][col-1].equals(type)) {
            counter = traverse(board, row-1, col-1, counter+1);
        } else if (row-1 >= 0 && col+1 < board[row-1].length && board[row-1][col+1].equals(type)) {
            counter = traverse(board, row-1, col+1, counter+1);
        }
        board[row][col] = type;
        return counter;
    }

    static String hasOne(Point[][] board) {
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[r].length; c++) {
                if (board[r][c] != Point.Null) {
                    Point[][] dup = board.clone();
                    int count = traverse(dup, r, c, 1);
                    if (count >= 3) return board[r][c].toString();
                    board[r][c] = Point.Null;
                }
            }
        }
        return "No winner";
    }

    public static void main(String[] args) throws Exception {
        int[] arr = new int[] {1,5};
        Point[][] board = new Point[][] {{Point.Red, Point.Red, Point.Red},{Point.Null,Point.Null,Point.Null},{Point.Null,Point.Null,Point.Null}};
        System.out.println(hasOne(board));
    }
}
