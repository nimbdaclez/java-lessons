package lection05.online;

/**
 * Created by Aleksandr Gladkov [Anticisco]
 * Date: 14.05.2022
 */

public class Coordinates {

    private int x;
    private int y;

    public Coordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    //Setter
    public void setX(int x) {
        this.x = x;
    }

    public void changeX() {
        this.x += 1;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void changeY() {
        this.y -= 1;
    }

}
