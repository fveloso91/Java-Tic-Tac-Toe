package tictactoe;

public class Game {

    GameBoard gameBoard;
    Player player1;
    Player player2;

    public Game(GameBoard gameBoard) {
        this.gameBoard = gameBoard;
        this.player1 = new Player(gameBoard, 'X');
        this.player2 = new Player(gameBoard, 'O');
    }

    public void init() {

        Player player = player1;

        while (checkGameState().equals("Game not finished")) {
            System.out.println(gameBoard);
            player.move();
            player = player == player1 ? player2 : player1;
        }

        System.out.println(gameBoard);
        System.out.println(checkGameState());
    }

    public String checkGameState() {

        if (player1.isWinner()) {
            return "X wins";
        }

        if (player2.isWinner()) {
            return "O wins";
        }

        if (gameBoard.movesLeft() == 0) {
            return "Draw";
        }

        return "Game not finished";
    }
}
