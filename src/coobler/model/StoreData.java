package coobler.model;

import java.awt.Color;

/**
 *
 * @author Dawid
 */
public class StoreData {

    private Color firstColor;
    private Color secondColor;

    private String firstNick;
    private String secondNick;

    private Integer firstPlayerPoint;
    private Integer secondPlayerPoint;

    private int sizeBoard;

    public StoreData(Color first, Color second, String firstName, String secondName) {
        this.firstPlayerPoint = 0;
        this.secondPlayerPoint = 0;

        this.firstColor = first;
        this.secondColor = second;

        this.firstNick = firstName;
        this.secondNick = secondName;

        this.sizeBoard = 5;

    }

    public Color getFirstColor() {
        return this.firstColor;
    }

    public Color getSecondColor() {
        return this.secondColor;
    }

    public void setFirstColor(Color color) {
        this.firstColor = color;
    }

    public void setSecondColor(Color color) {
        this.secondColor = color;
    }

    public String getFirstNick() {
        return this.firstNick;
    }

    public String getSecondNick() {
        return this.secondNick;
    }

    public void setFirstNick(String nick) {
        this.firstNick = nick;
    }

    public void setSecondNick(String nick) {
        this.secondNick = nick;
    }

    public int getSizeBoard() {
        return this.sizeBoard;
    }

    public void setSizeBoard(int size) {
        this.sizeBoard = size;
    }

    public Integer getFirstPlayerPoint() {
        return this.firstPlayerPoint;
    }

    public void setFirstPlayerPoint(Integer point) {
        this.firstPlayerPoint = point;
    }

    public Integer getSecondPlayerPoint() {
        return this.secondPlayerPoint;
    }

    public void setSecondPlayerPoint(Integer point) {
        this.secondPlayerPoint = point;
    }
}
