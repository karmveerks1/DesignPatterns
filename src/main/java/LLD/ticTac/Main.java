package LLD.ticTac;

public class Main {
    public static void main(String[] args) {
        TicTacToeGame ticTacToeGame = new TicTacToeGame();
        ticTacToeGame.initializeGame();
        System.out.println("Starting the game:");
        ticTacToeGame.startGame();
        return ;
    }
}
