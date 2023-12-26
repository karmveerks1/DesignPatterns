package LLD.ticTac.model;

public class PlayingPiece {

    private PieceType pieceType;

    public PlayingPiece(PieceType pieceType) {
        this.pieceType = pieceType;
    }

    @Override
    public String toString() {
        return pieceType.value;
    }

    public PieceType getPieceType() {
        return this.pieceType;
    }

    public void setPieceType(PieceType pieceType) {
        this.pieceType = pieceType;
    }
}

