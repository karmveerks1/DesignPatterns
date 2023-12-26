package LLD.ticTac.model;

public class Player {
    public PlayingPiece playingPiece;
    public String name;
    public int rank;

    public Player(PlayingPiece playingPiece, String name, int rank) {
        this.playingPiece = playingPiece;
        this.name = name;
        this.rank = rank;
    }

    public PlayingPiece getPlayingPiece() {
        return playingPiece;
    }

    public void setPlayingPiece(PlayingPiece playingPiece) {
        this.playingPiece = playingPiece;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }
}
