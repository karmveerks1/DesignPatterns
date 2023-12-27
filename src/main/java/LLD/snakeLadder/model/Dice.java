package LLD.snakeLadder.model;

import java.util.Random;

public class Dice {

    private int faceCount; // If faceCount = N , then we can get 1,2,3,4,5....N
    private final Random random = new Random();
    public int getFaceCount() {
        return faceCount;
    }

    public void setFaceCount(int faceCount) {
        this.faceCount = faceCount;
    }

    public Dice(int faceCount) {
        this.faceCount = faceCount;
    }

    public int rollDice() {
        return random.nextInt(this.faceCount) + 1;
    }
}
