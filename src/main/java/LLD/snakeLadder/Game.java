package LLD.snakeLadder;

public class Game {
    public static void main(String[] args) {
        SnakeLadderGame snakeLadderGame = new SnakeLadderGame();
        snakeLadderGame.initializeGame();
        System.out.println(snakeLadderGame.startGame());
    }
}
