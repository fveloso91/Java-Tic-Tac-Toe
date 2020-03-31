package tictactoe;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Player {

    private GameBoard board;
    private boolean isWinner;
    private char gameObject;

    public Player(GameBoard board, char gameObject) {
        this.board = board;
        this.gameObject = gameObject;
        this.isWinner = false;
    }

    public boolean isWinner() {
        calcWinner();
        return isWinner;
    }

    private void calcWinner() {

        for (int i = 0; i < 3; i++) {

            // winner by column
            if (board.getBoard()[0][i] == gameObject &&
                    board.getBoard()[1][i] == gameObject &&
                    board.getBoard()[2][i] == gameObject) {

                isWinner = true;
                return;
            }

            // winner by row
            if (board.getBoard()[i][0] == gameObject &&
                    board.getBoard()[i][1] == gameObject &&
                    board.getBoard()[i][2] == gameObject) {

                isWinner = true;
                return;
            }
        }

        // winner by diagonal l -> r
        if (board.getBoard()[0][0] == gameObject &&
                board.getBoard()[1][1] == gameObject &&
                board.getBoard()[2][2] == gameObject) {

            isWinner = true;
            return;
        }

        // winner by diagonal r -> l
        if (board.getBoard()[0][2] == gameObject &&
                board.getBoard()[1][1] == gameObject &&
                board.getBoard()[2][0] == gameObject) {

            isWinner = true;
            return;
        }
    }


    public void move() {

        int[] colRow = moveAndCheck();

        if (!board.makeMove(3 - colRow[1], colRow[0] - 1, gameObject)) {
            System.out.println("This cell is occupied! Choose another one!");
            move();
        }
    }

    private int[] moveAndCheck() {
        int[] colRow = getColRow();

        if (colRow[0] > 3 || colRow[1] > 3) {
            System.out.println("Coordinates should be from 1 to 3!");
            colRow = moveAndCheck();
        }
        return colRow;
    }

    private int[] getColRow() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the coordinates: ");
        int[] colRow = new int[2];

        try {
            colRow[0] = scanner.nextInt();
            colRow[1] = scanner.nextInt();

        } catch (InputMismatchException e) {
            System.out.println("You should enter numbers!");
            colRow = getColRow();
        }

        return colRow;
    }
}

