package LLD.ticTac;

public class Main {
    public static void main(String[] args) {
        TicTocToeHelperI helperI = new TicTocToeHelperImpl();
        TicTacToeGame ticTacToeGame = new TicTacToeGame(helperI);
        ticTacToeGame.initializeGame();
        System.out.println("Starting the game:");
        System.out.println(ticTacToeGame.startGame());
        return ;
    }
}
