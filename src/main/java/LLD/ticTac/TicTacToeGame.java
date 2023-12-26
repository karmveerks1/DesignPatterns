package LLD.ticTac;

import LLD.ticTac.model.PieceType;
import LLD.ticTac.model.Player;
import LLD.ticTac.model.Board;
import LLD.ticTac.model.PlayingPiece;
import javafx.util.Pair;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class TicTacToeGame {
    public List<Player> players;
    public Board playingBoard;
    private TicTocToeHelperI helper;
    public TicTacToeGame(TicTocToeHelperI helper) {
        this.helper = helper;
    }

    public void initializeGame() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of players:");
        int countOfPlayers = scanner.nextInt();
        players = new LinkedList<>();
        helper.enterPlayers(players,countOfPlayers);
        System.out.println("Enter Board Size:");
        int boardSize = scanner.nextInt();
        playingBoard = new Board(boardSize);
    }

    public String startGame(){
        boolean noWinner = true;
        while(noWinner){
            // Need to take out players from list one by one and keep appending on the last
            Player currPlayer = players.remove(0);
            playingBoard.printBoard();
            List<Pair<Integer,Integer>> freeSpaces = playingBoard.getFreeCells();
            if(freeSpaces.isEmpty()){
                noWinner = false;
                break;
            }
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter the cell where you want to insert(Row,Col)");
            boolean insert = true;
            int currRow = 0,currCol = 0;
            while(insert){
                int row = scanner.nextInt();
                int col = scanner.nextInt();
                if(playingBoard.canEnterAtThisPos(row,col,freeSpaces)){
                    playingBoard.board[row][col].setPieceType(currPlayer.playingPiece.getPieceType());
                    currRow = row;
                    currCol = col;
                    insert = false;
                }else{
                    System.out.println("You can not enter at occupied cells. Please select from free cells");
                }
            }
            // Need to check whether current Move of player made him won the match or not
            boolean isCurrentPlayerWon = playingBoard.checkForWinner(currRow,currCol,currPlayer.playingPiece.getPieceType());
            if(isCurrentPlayerWon){
                return "Player :" + currPlayer.name + " won the match\n";
            }
            players.add(currPlayer);
        }
        return "TIE";
    }

    private boolean canMakeMove(int row, int col, Board playingBoard) {
        return playingBoard.board[row][col].getPieceType().equals(PieceType.N);
    }
}
