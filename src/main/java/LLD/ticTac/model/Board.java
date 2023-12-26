package LLD.ticTac.model;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Board {
   public int size;
   public PlayingPiece[][] board;

    public Board(int size) {
        this.size = size;
        this.board = new PlayingPiece[size][size];
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                board[i][j] = new PlayingPiece(PieceType.N);
            }
        }
    }

    public void printBoard() {
        for(int i=0;i< board.length;i++){
            for(int j=0;j<board[0].length;j++){
                System.out.print(board[i][j] + "  | ");
            }
            System.out.println();
        }
    }

    public List<Pair<Integer, Integer>> getFreeCells() {
        List<Pair<Integer,Integer>> freeSpaces = new ArrayList<>();
        for(int i=0;i< board.length;i++){
            for(int j=0;j<board[0].length;j++){
//                if(board[i][j].pieceType != PieceType.O && board[i][j].pieceType != PieceType.X){
//                    freeSpaces.add(new Pair<>(i,j));
//                }
                if(board[i][j].getPieceType().equals(PieceType.N)){
                    freeSpaces.add(new Pair<>(i,j));
                }
            }
        }
        return freeSpaces;
    }

    public boolean canEnterAtThisPos(int row, int col, List<Pair<Integer, Integer>> freeSpaces) {
        boolean canMove = false;
        for(Pair<Integer,Integer> p : freeSpaces){
            int row1 = p.getKey();
            int col1 = p.getValue();
            if(row1 == row && col1 == col){
                canMove = true;
                break;
            }
        }
        return canMove;
    }

    public boolean checkForWinner(int currRow, int currCol, PieceType pieceType) {
        boolean isWinnerFound = false;
        // Need to check in row
        boolean rowCheck = true;
        for(int i=0;i<size;i++){
            if(board[currRow][i].getPieceType().equals(PieceType.N) || board[currRow][i].getPieceType() != pieceType){
                rowCheck = false;
                break;
            }
        }
        if(rowCheck) return true;

        boolean colCheck = true;
        for(int i=0;i<size;i++){
            if(board[i][currCol].getPieceType().equals(PieceType.N) || board[i][currCol].getPieceType() != pieceType){
                colCheck = false;
                break;
            }
        }
        if(colCheck) return true;

        // First need to check whether diagonal need to check for this pos or not
        if(currCol == currRow && currCol + currRow == size-1){
            // Need to check for diagonals
            // Now everytime we don't need to check for both diagonals
            if(currCol == currRow && size/2 == currCol && size%2 == 1){
                // If we have size as odd, only then both diagonals can pass through each other
                boolean leftUpperToRightBottom = checkForLeftTopToRightBottom(currRow,currCol,pieceType);
                boolean rightUpperToLeftBottom = checkForRightTopToLeftBottom(currRow,currCol,pieceType);
                return leftUpperToRightBottom || rightUpperToLeftBottom;
            }else{
                if(currCol == currRow){
                    //Left upper to right bottom
                    boolean leftUpperToRightBottom = checkForLeftTopToRightBottom(currRow,currCol,pieceType);
                    return leftUpperToRightBottom;
                }else{
                    boolean rightUpperToLeftBottom = checkForRightTopToLeftBottom(currRow,currCol,pieceType);
                    return rightUpperToLeftBottom;
                }
            }
        }
        return isWinnerFound;
    }

    private boolean checkForRightTopToLeftBottom(int currRow, int currCol, PieceType pieceType) {
        boolean isWinner = true;
        for(int i=0,j=size-1;i<size && j>=0;i++,j--){
            if(board[i][j].getPieceType().equals(PieceType.N) || board[i][j].getPieceType() != pieceType){
                isWinner = false;
                break;
            }
        }
        return isWinner;
    }

    private boolean checkForLeftTopToRightBottom(int currRow, int currCol, PieceType pieceType) {
        boolean isWinner = true;
        for(int i=0;i<size;i++){
            if(board[i][i].getPieceType().equals(PieceType.N) || board[i][i].getPieceType() != pieceType){
                isWinner = false;
                break;
            }
        }
        return isWinner;
    }
}
