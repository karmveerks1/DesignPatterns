package LLD.snakeLadder.model;

public class Snake {
    private String color;
    private int mouthPos; // Represent mouth of the snake
    private int tailPos;  // Represent tail of the snake

    public Snake(String color, int mouthPos, int tailPos) {
        this.color = color;
        this.mouthPos = mouthPos;
        this.tailPos = tailPos;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getMouthPos() {
        return mouthPos;
    }

    public void setMouthPos(int mouthPos) {
        this.mouthPos = mouthPos;
    }

    public int getTailPos() {
        return tailPos;
    }

    public void setTailPos(int tailPos) {
        this.tailPos = tailPos;
    }

}
