package LLD.snakeLadder.model;

public enum Level {
    BEGINNER(1),EASY(2),INTERMEDIATE(3),HARD(4),ADVANCED(5);

    private int level;

    Level(int level) {
        this.level = level;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
