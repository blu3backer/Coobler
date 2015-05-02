package coobler.model;

import coobler.view.Board;
import java.awt.Color;

/**
 *
 * @author Dawid
 */
public class Game {

    private Board board;

    public Game(Board aBoard) {
        this.board = aBoard;
    }

    public boolean checkField(int i, int j, TypeOfField type) {
        if (type == TypeOfField.HORIZONTAL) {
            if (i == 0) {
                if ((!(board.getVerticalField()[i][j].getBackground().equals(new Color(0, 49, 83))))
                        && (!(board.getVerticalField()[i][j + 1].getBackground().equals(new Color(0, 49, 83))))
                        && (!(board.getHorizontalField()[i + 1][j].getBackground().equals(new Color(0, 49, 83))))) {                    
                    return true;
                }
            } else if (i == Board.AMOUNT_FIELD) {
                if ((!(board.getVerticalField()[i-1][j].getBackground().equals(new Color(0, 49, 83))))
                        && (!(board.getVerticalField()[i-1][j + 1].getBackground().equals(new Color(0, 49, 83))))
                        && (!(board.getHorizontalField()[i - 1][j].getBackground().equals(new Color(0, 49, 83))))) {                    
                    return true;
                }
            } else {
                
            }
        } else {
            if (j == 0) {
                if ((!(board.getVerticalField()[i][j+1].getBackground().equals(new Color(0, 49, 83))))
                        && (!(board.getHorizontalField()[i][j].getBackground().equals(new Color(0, 49, 83))))
                        && (!(board.getHorizontalField()[i + 1][j].getBackground().equals(new Color(0, 49, 83))))) {                    
                    return true;
                }
            } else if (j == Board.AMOUNT_FIELD) {
                if ((!(board.getVerticalField()[i][j-1].getBackground().equals(new Color(0, 49, 83))))
                        && (!(board.getHorizontalField()[i][j-1].getBackground().equals(new Color(0, 49, 83))))
                        && (!(board.getHorizontalField()[i + 1][j-1].getBackground().equals(new Color(0, 49, 83))))) {                    
                    return true;
                }
            } else {
                
            }
        }
        return false;
    }
}
