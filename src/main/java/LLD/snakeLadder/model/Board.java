package LLD.snakeLadder.model;

import java.util.HashMap;
import java.util.Map;

public class Board {
    private int boardSize;
    Map<Integer,Integer> snakes = new HashMap<>(); // Key will denote mouth and value will denote tail
    Map<Integer,Integer> ladders = new HashMap<>(); // key will denote bottom and value will be the top of the ladder
    private Level level;

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public Map<Integer, Integer> getSnakes() {
        return snakes;
    }

    public void setSnakes(Map<Integer, Integer> snakes) {
        this.snakes = snakes;
    }

    public Map<Integer, Integer> getLadders() {
        return ladders;
    }

    public void setLadders(Map<Integer, Integer> ladders) {
        this.ladders = ladders;
    }

    public int getBoardSize() {
        return boardSize;
    }
    public void setBoardSize(int size) {
        this.boardSize = size;
    }
}
