package coobler.model;

import coobler.view.Board;
import java.awt.Color;

/**
 * This class is represent game logic
 *
 * @author Dawid
 */
public class Game {

    private Board board;
    
    /**
     * 
     * @param aBoard game board
     */
    public Game(Board aBoard) {
        this.board = aBoard;

    }
    /**
     * This method check that the field should be filled.
     * 
     * @param i means rows board
     * @param j means kolumns board
     * @param type type of field board
     * @return if field should be filled return type of fill field otherwise return TypeOfField.NONE
     */
    public FillTypeField checkField(int i, int j, TypeOfField type) {
        if (type == TypeOfField.HORIZONTAL) {
            if (i == 0) {
                if ((!(board.getVerticalField()[i][j].getBackground().equals(new Color(26,26,26))))
                        && (!(board.getVerticalField()[i][j + 1].getBackground().equals(new Color(26,26,26))))
                        && (!(board.getHorizontalField()[i + 1][j].getBackground().equals(new Color(26,26,26))))) {
                    return FillTypeField.CURRENT;
                }
            } else if (i == Board.AMOUNT_FIELD) {
                if ((!(board.getVerticalField()[i - 1][j].getBackground().equals(new Color(26,26,26))))
                        && (!(board.getVerticalField()[i - 1][j + 1].getBackground().equals(new Color(26,26,26))))
                        && (!(board.getHorizontalField()[i - 1][j].getBackground().equals(new Color(26,26,26))))) {
                    return FillTypeField.PREVIOUS;
                }
            } else {
                if ((!(board.getVerticalField()[i][j].getBackground().equals(new Color(26,26,26))))
                        && (!(board.getVerticalField()[i][j + 1].getBackground().equals(new Color(26,26,26))))
                        && (!(board.getHorizontalField()[i + 1][j].getBackground().equals(new Color(26,26,26))))) {
                    if ((!(board.getVerticalField()[i - 1][j].getBackground().equals(new Color(26,26,26))))
                            && (!(board.getVerticalField()[i - 1][j + 1].getBackground().equals(new Color(26,26,26))))
                            && (!(board.getHorizontalField()[i - 1][j].getBackground().equals(new Color(26,26,26))))) {
                        return FillTypeField.BOTH;
                    }
                    return FillTypeField.CURRENT;
                } else if ((!(board.getVerticalField()[i - 1][j].getBackground().equals(new Color(26,26,26))))
                        && (!(board.getVerticalField()[i - 1][j + 1].getBackground().equals(new Color(26,26,26))))
                        && (!(board.getHorizontalField()[i - 1][j].getBackground().equals(new Color(26,26,26))))) {
                    if ((!(board.getVerticalField()[i][j].getBackground().equals(new Color(26,26,26))))
                            && (!(board.getVerticalField()[i][j + 1].getBackground().equals(new Color(26,26,26))))
                            && (!(board.getHorizontalField()[i + 1][j].getBackground().equals(new Color(26,26,26))))) {
                        return FillTypeField.BOTH;
                    }
                    return FillTypeField.PREVIOUS;
                }

            }

        } else {
            if (j == 0) {
                if ((!(board.getVerticalField()[i][j + 1].getBackground().equals(new Color(26,26,26))))
                        && (!(board.getHorizontalField()[i][j].getBackground().equals(new Color(26,26,26))))
                        && (!(board.getHorizontalField()[i + 1][j].getBackground().equals(new Color(26,26,26))))) {
                    return FillTypeField.CURRENT;
                }
            } else if (j == Board.AMOUNT_FIELD) {
                if ((!(board.getVerticalField()[i][j - 1].getBackground().equals(new Color(26,26,26))))
                        && (!(board.getHorizontalField()[i][j - 1].getBackground().equals(new Color(26,26,26))))
                        && (!(board.getHorizontalField()[i + 1][j - 1].getBackground().equals(new Color(26,26,26))))) {
                    return FillTypeField.PREVIOUS;
                }
            } else {
                if ((!(board.getVerticalField()[i][j + 1].getBackground().equals(new Color(26,26,26))))
                        && (!(board.getHorizontalField()[i][j].getBackground().equals(new Color(26, 26, 26))))
                        && (!(board.getHorizontalField()[i + 1][j].getBackground().equals(new Color(26, 26, 26))))) {
                    if ((!(board.getVerticalField()[i][j - 1].getBackground().equals(new Color(26, 26, 26))))
                            && (!(board.getHorizontalField()[i][j - 1].getBackground().equals(new Color(26, 26, 26))))
                            && (!(board.getHorizontalField()[i + 1][j - 1].getBackground().equals(new Color(26, 26, 26))))) {
                        return FillTypeField.BOTH;
                    }
                    return FillTypeField.CURRENT;
                } else if ((!(board.getVerticalField()[i][j - 1].getBackground().equals(new Color(26, 26, 26))))
                        && (!(board.getHorizontalField()[i][j - 1].getBackground().equals(new Color(26, 26, 26))))
                        && (!(board.getHorizontalField()[i + 1][j - 1].getBackground().equals(new Color(26, 26, 26))))) {
                    if ((!(board.getVerticalField()[i][j + 1].getBackground().equals(new Color(26, 26, 26))))
                            && (!(board.getHorizontalField()[i + 1][j].getBackground().equals(new Color(26, 26, 26))))
                            && (!(board.getHorizontalField()[i][j].getBackground().equals(new Color(26, 26, 26))))) {
                        return FillTypeField.BOTH;
                    }
                    return FillTypeField.PREVIOUS;
                }
            }
        }
        return FillTypeField.NONE;
    }
    /**
     * This method clear the board
     */
    public void clearBoard() {
        for (int i = 0; i <= Board.AMOUNT_FIELD; i++) {
            for (int j = 0; j <= Board.AMOUNT_FIELD; j++) {
                if (i < Board.AMOUNT_FIELD) {
                    if (j < Board.AMOUNT_FIELD) {
                        board.getCenterField()[i][j].setBackground(new Color(26, 26, 26));
                    }
                    board.getVerticalField()[i][j].setBackground(new Color(26, 26, 26));
                }
                if (j < Board.AMOUNT_FIELD) {
                    board.getHorizontalField()[i][j].setBackground(new Color(26, 26, 26));
                }

            }
        }
        board.getFirstPlayerScoreLabel().setText("0");
        board.getSecondPlayerScoreLabel().setText("0");

        board.repaint();
    }

    

   
}
