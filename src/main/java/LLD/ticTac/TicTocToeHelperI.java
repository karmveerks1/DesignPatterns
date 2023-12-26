package LLD.ticTac;

import LLD.ticTac.model.PieceType;
import LLD.ticTac.model.Player;

import java.util.List;

public interface TicTocToeHelperI {
    public PieceType getPieceType(char c);
    void enterPlayers(List<Player> players, int countOfPlayers);
}
