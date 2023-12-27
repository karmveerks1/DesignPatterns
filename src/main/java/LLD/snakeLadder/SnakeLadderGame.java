package LLD.snakeLadder;

import LLD.snakeLadder.model.Board;
import LLD.snakeLadder.model.Dice;
import LLD.snakeLadder.model.Level;
import LLD.snakeLadder.model.Player;

import javax.xml.bind.SchemaOutputResolver;
import java.util.*;

public class SnakeLadderGame {
    private final Board board = new Board();
    private Dice dice = new Dice(6) ;
    private final List<Player> players = new LinkedList<>();
    private final Random random = new Random();
    public void initializeGame() {
        createPlayers();
        createDice();
        createBoard();
    }
    public String startGame(){
        int maxMove = 0;
        while(maxMove < 100){
            maxMove++;
            Player currPlayer = players.remove(0);
            Scanner scanner = new Scanner(System.in);
            System.out.println(currPlayer.getName() + ":Current Position->"+currPlayer.getCurrPos() + ", Enter R to roll dice" );
            char diceRoll = scanner.next().charAt(0);
            while(diceRoll != 'R'){
                System.out.println("Please enter R:");
                diceRoll = scanner.next().charAt(0);
            }
            int number = dice.rollDice();
            System.out.println("Got Number:" + number);
            currPlayer.setCurrPos(getNewCurrPos(currPlayer.getCurrPos(),number,board));
            System.out.println(currPlayer.getName() + ":New Current Position->"+currPlayer.getCurrPos());
            if(currPlayer.getCurrPos() == board.getBoardSize()){
                return "Player" + currPlayer.getName() + "is the Winner";
            }
            int count = 0;
            while(number == dice.getFaceCount() && count < 3){
                System.out.println("You can roll dice once again:");
                System.out.println(currPlayer.getName() + ":Current Position->"+currPlayer.getCurrPos());
                diceRoll = scanner.next().charAt(0);
                number = dice.rollDice();
                System.out.println("Got Number:" + number);
                currPlayer.setCurrPos(getNewCurrPos(currPlayer.getCurrPos(),number,board));
                System.out.println(currPlayer.getName() + ":New Current Position->"+currPlayer.getCurrPos());
                if(currPlayer.getCurrPos() == board.getBoardSize()){
                    return "Player" + currPlayer.getName() + "is the Winner";
                }
                count++;
            }
            players.add(currPlayer);
        }
        return "Tie:Moves Limit Reached";
    }

    private int getNewCurrPos(int currPos, int number, Board board) {
        if(currPos + number > board.getBoardSize()) return currPos;
        int newPos = currPos+number;
        // If newPos has snake head or new pos has ladder bottom , we need to change new pos
        for(Integer snakeHead:board.getSnakes().keySet()){
            // Key is head
            if(snakeHead == newPos){
                newPos = board.getSnakes().get(snakeHead);
                return newPos;
            }
        }

        for(Integer ladderBottom : board.getLadders().keySet()){
            // Key is head
            if(ladderBottom == newPos){
                newPos = board.getLadders().get(ladderBottom);
                return newPos;
            }
        }
        return newPos;
    }

    private void createPlayers() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of players(Min - 2 and Max - 4) :");
        int numberOfPlayers = scanner.nextInt();
        int counter = 0;
        while((numberOfPlayers > 4 || numberOfPlayers < 2 ) && (counter < 5)){
            counter++;
            System.out.println("Can not play with : " + numberOfPlayers + " players");
            System.out.print("Please enter the number between 2 and 4:");
            numberOfPlayers = scanner.nextInt();
        }
        if(counter == 5){
            System.out.println("We can't allow you to play this game. Please wait for 30 min before starting again");
        }
        for(int i=0;i<numberOfPlayers;i++){
            System.out.println("Enter the Name of " + (i+1) + " Player:");
            scanner.nextLine();
            String name = scanner.nextLine();
            System.out.println("Enter the starting Position: ");
            int startPos = scanner.nextInt();
            Player player = new Player(name,0,startPos);
            players.add(player);
        }
    }

    private void createDice() {
        System.out.println("Enter the number of faces of dice:");
        Scanner sc = new Scanner(System.in);
        int faceCount = sc.nextInt();
        dice.setFaceCount(faceCount);
    }

    private void createBoard(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the board size(Number of cells you want):");
        int size = scanner.nextInt();
        System.out.println("Enter the board level(1-5):");
        int level = scanner.nextInt();
        board.setBoardSize(size);
        board.setLevel(getDifficultyLevel(level));
        board.setLadders(getLadders(level,size));
        board.setSnakes(getSnakes(level,size));
    }

    private Map<Integer, Integer> getLadders(int level, int size) {
        // We have levels 1-5
        Map<Integer,Integer> ladders = new HashMap<>();
        for(int i=5;i>=level;i--){
            int bottomPart = random.nextInt(size/2) + 1;
            int topPart = bottomPart + 1 + random.nextInt(size/2 - size/10) ;
            ladders.put(bottomPart,topPart);
        }
        return ladders;
    }

    private Map<Integer, Integer> getSnakes(int level, int size) {
        Map<Integer,Integer> snakes = new HashMap<>();
        for(int i=0;i<level;i++){
            int tail = random.nextInt(size/2) + 1;
            int head = tail + 1 + random.nextInt(size/2 - size/10) ;
            snakes.put(head,tail);
        }
        return snakes;
    }

    private Level getDifficultyLevel(int level) {
        switch(level){
            case 2 : return Level.EASY;
            case 3 : return Level.INTERMEDIATE;
            case 4 : return Level.HARD;
            case 5 : return Level.ADVANCED;
            default:return Level.BEGINNER;
        }
    }

    public Board getBoard() {
        return board;
    }

    public Dice getDice() {
        return dice;
    }

    public List<Player> getPlayers() {
        return players;
    }
}
