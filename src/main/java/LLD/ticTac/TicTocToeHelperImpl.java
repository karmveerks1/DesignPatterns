package LLD.ticTac;

import LLD.ticTac.model.PieceType;
import LLD.ticTac.model.Player;
import LLD.ticTac.model.PlayingPiece;

import java.util.List;
import java.util.Scanner;

public class TicTocToeHelperImpl implements TicTocToeHelperI{
    @Override
    public PieceType getPieceType(char c) {
        switch (c){
            case 'X' : return PieceType.X;
            case 'O' : return PieceType.O;
            case 'H' : return PieceType.H;
            case 'S' : return PieceType.S;
            default: return PieceType.D;
        }
    }

    @Override
    public void enterPlayers(List<Player> players, int countOfPlayers) {
            for(int i=0;i<countOfPlayers;i++){
                Scanner sc = new Scanner(System.in);
                System.out.print("Enter" + i+1 + " Player Name :");
                String playerName = sc.nextLine();

                System.out.print("Enter Rank:");
                int rank = sc.nextInt();

                System.out.print("Enter the piece type:");
                char c = sc.next().charAt(0);

                PlayingPiece pp = new PlayingPiece(getPieceType(c));
                players.add(new Player(pp,playerName,rank));
            }
        }
}
