package coobler.model;

import java.awt.Color;

/**
 * This class contain data players or size of board
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

    /**
     *
     * @param first first color player
     * @param second second color player
     * @param firstName first player name
     * @param secondName second player name
     */
    public StoreData(Color first, Color second, String firstName, String secondName) {
        this.firstPlayerPoint = 0;
        this.secondPlayerPoint = 0;

        this.firstColor = first;
        this.secondColor = second;

        this.firstNick = firstName;
        this.secondNick = secondName;

        this.sizeBoard = 5;

    }

    /**
     *
     * @return first color player
     */
    public Color getFirstColor() {
        return this.firstColor;
    }

    /**
     *
     * @return second color player
     */
    public Color getSecondColor() {
        return this.secondColor;
    }

    /**
     *
     * @param color set first color player
     */
    public void setFirstColor(Color color) {
        this.firstColor = color;
    }

    /**
     *
     * @param color set second color player
     */
    public void setSecondColor(Color color) {
        this.secondColor = color;
    }

    /**
     *
     * @return first player name
     */
    public String getFirstNick() {
        return this.firstNick;
    }

    /**
     *
     * @return second player name
     */
    public String getSecondNick() {
        return this.secondNick;
    }

    /**
     *
     * @param nick set first player name
     */
    public void setFirstNick(String nick) {
        this.firstNick = nick;
    }

    /**
     *
     * @param nick set second player name
     */
    public void setSecondNick(String nick) {
        this.secondNick = nick;
    }

    /**
     *
     * @return size board
     */
    public int getSizeBoard() {
        return this.sizeBoard;
    }

    /**
     *
     * @param size set size board
     */
    public void setSizeBoard(int size) {
        this.sizeBoard = size;
    }

    /**
     *
     * @return points of the first player
     */
    public Integer getFirstPlayerPoint() {
        return this.firstPlayerPoint;
    }

    /**
     *
     * @param point set points of the first player
     */
    public void setFirstPlayerPoint(Integer point) {
        this.firstPlayerPoint = point;
    }

    /**
     *
     * @return points of the second player
     */
    public Integer getSecondPlayerPoint() {
        return this.secondPlayerPoint;
    }

    /**
     *
     * @param point set points of the second player
     */
    public void setSecondPlayerPoint(Integer point) {
        this.secondPlayerPoint = point;
    }
}
