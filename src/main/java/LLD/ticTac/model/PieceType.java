package LLD.ticTac.model;

public enum PieceType {
    X("X"),O("O"),N(" ");

    String value ;

    PieceType(String value) {
        this.value = value;
    }
}
