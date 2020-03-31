package tictactoe;

import java.util.Arrays;

public class GameBoard {

    private char[][] board;

    public GameBoard() {
        this.board = new char[3][3];
        createBoard();
    }

    private void createBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }
    }


    public char[][] getBoard() {
        return board;
    }

    public boolean makeMove(int row, int col, char gameObject){

        if(board[row][col] == ' ') {
            board[row][col] = gameObject;
            return true;
        }

        return false;
    }

    public int movesLeft() {
        int count = 0;

        for (char[] chArr : board) {

            for (char gO : chArr) {
                if(gO == ' ') {
                    count++;
                }
            }
        }

        return count;
    }

    @Override
    public String toString() {
        return String.format("---------\n" +
                "| %s %s %s |\n" +
                "| %s %s %s |\n" +
                "| %s %s %s |\n" +
                "---------\n",
        board[0][0],
                board[0][1],
                board[0][2],
                board[1][0],
                board[1][1],
                board[1][2],
                board[2][0],
                board[2][1],
                board[2][2]);
    }

}
