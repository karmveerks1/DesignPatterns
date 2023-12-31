package LLD.snakeLadder.model;

public class Player {
    private String name;
    private int id;
    private int currPos = 0;

    public Player(String name, int id, int currPos) {
        this.name = name;
        this.id = id;
        this.currPos = currPos;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCurrPos() {
        return currPos;
    }

    public void setCurrPos(int currPos) {
        this.currPos = currPos;
    }
}
