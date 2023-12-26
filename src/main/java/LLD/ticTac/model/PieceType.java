package LLD.ticTac.model;

public enum PieceType {
    X("X"),O("O"),N(" "),S("*"),H("#"),D("$");

    String value ;

    PieceType(String value) {
        this.value = value;
    }
}
