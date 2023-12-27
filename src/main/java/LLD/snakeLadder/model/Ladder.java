package LLD.snakeLadder.model;

public class Ladder {
    private String color;
    private int startPos; // If player reaches to this , send him to endPos
    private int endPos;

    public Ladder(String color, int startPos, int endPos) {
        this.color = color;
        this.startPos = startPos;
        this.endPos = endPos;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getStartPos() {
        return startPos;
    }

    public void setStartPos(int startPos) {
        this.startPos = startPos;
    }

    public int getEndPos() {
        return endPos;
    }

    public void setEndPos(int endPos) {
        this.endPos = endPos;
    }
}
