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

    public FillTypeField checkField(int i, int j, TypeOfField type) {
        if (type == TypeOfField.HORIZONTAL) {
            if (i == 0) {
                if ((!(board.getVerticalField()[i][j].getBackground().equals(new Color(0, 49, 83))))
                        && (!(board.getVerticalField()[i][j + 1].getBackground().equals(new Color(0, 49, 83))))
                        && (!(board.getHorizontalField()[i + 1][j].getBackground().equals(new Color(0, 49, 83))))) {
                    return FillTypeField.CURRENT;
                }
            } else if (i == Board.AMOUNT_FIELD) {
                if ((!(board.getVerticalField()[i - 1][j].getBackground().equals(new Color(0, 49, 83))))
                        && (!(board.getVerticalField()[i - 1][j + 1].getBackground().equals(new Color(0, 49, 83))))
                        && (!(board.getHorizontalField()[i - 1][j].getBackground().equals(new Color(0, 49, 83))))) {
                    return FillTypeField.PREVIOUS;
                }
            } else {
                if ((!(board.getVerticalField()[i][j].getBackground().equals(new Color(0, 49, 83))))
                        && (!(board.getVerticalField()[i][j + 1].getBackground().equals(new Color(0, 49, 83))))
                        && (!(board.getHorizontalField()[i + 1][j].getBackground().equals(new Color(0, 49, 83))))) {
                    if ((!(board.getVerticalField()[i - 1][j].getBackground().equals(new Color(0, 49, 83))))
                            && (!(board.getVerticalField()[i - 1][j + 1].getBackground().equals(new Color(0, 49, 83))))
                            && (!(board.getHorizontalField()[i - 1][j].getBackground().equals(new Color(0, 49, 83))))) {
                        return FillTypeField.BOTH;
                    }
                    return FillTypeField.CURRENT;
                } else if ((!(board.getVerticalField()[i - 1][j].getBackground().equals(new Color(0, 49, 83))))
                        && (!(board.getVerticalField()[i - 1][j + 1].getBackground().equals(new Color(0, 49, 83))))
                        && (!(board.getHorizontalField()[i - 1][j].getBackground().equals(new Color(0, 49, 83))))) {
                    if ((!(board.getVerticalField()[i][j].getBackground().equals(new Color(0, 49, 83))))
                            && (!(board.getVerticalField()[i][j + 1].getBackground().equals(new Color(0, 49, 83))))
                            && (!(board.getHorizontalField()[i + 1][j].getBackground().equals(new Color(0, 49, 83))))) {
                        return FillTypeField.BOTH;
                    }
                    return FillTypeField.PREVIOUS;
                }

            }

        } else {
            if (j == 0) {
                if ((!(board.getVerticalField()[i][j + 1].getBackground().equals(new Color(0, 49, 83))))
                        && (!(board.getHorizontalField()[i][j].getBackground().equals(new Color(0, 49, 83))))
                        && (!(board.getHorizontalField()[i + 1][j].getBackground().equals(new Color(0, 49, 83))))) {
                    return FillTypeField.CURRENT;
                }
            } else if (j == Board.AMOUNT_FIELD) {
                if ((!(board.getVerticalField()[i][j - 1].getBackground().equals(new Color(0, 49, 83))))
                        && (!(board.getHorizontalField()[i][j - 1].getBackground().equals(new Color(0, 49, 83))))
                        && (!(board.getHorizontalField()[i + 1][j - 1].getBackground().equals(new Color(0, 49, 83))))) {
                    return FillTypeField.PREVIOUS;
                }
            } else {
                if ((!(board.getVerticalField()[i][j + 1].getBackground().equals(new Color(0, 49, 83))))
                        && (!(board.getHorizontalField()[i][j].getBackground().equals(new Color(0, 49, 83))))
                        && (!(board.getHorizontalField()[i + 1][j].getBackground().equals(new Color(0, 49, 83))))) {
                    if ((!(board.getVerticalField()[i][j - 1].getBackground().equals(new Color(0, 49, 83))))
                            && (!(board.getHorizontalField()[i][j - 1].getBackground().equals(new Color(0, 49, 83))))
                            && (!(board.getHorizontalField()[i + 1][j - 1].getBackground().equals(new Color(0, 49, 83))))) {
                        return FillTypeField.BOTH;
                    }
                    return FillTypeField.CURRENT;
                } else if ((!(board.getVerticalField()[i][j - 1].getBackground().equals(new Color(0, 49, 83))))
                        && (!(board.getHorizontalField()[i][j - 1].getBackground().equals(new Color(0, 49, 83))))
                        && (!(board.getHorizontalField()[i + 1][j - 1].getBackground().equals(new Color(0, 49, 83))))) {
                    if ((!(board.getVerticalField()[i][j + 1].getBackground().equals(new Color(0, 49, 83))))
                            && (!(board.getHorizontalField()[i + 1][j].getBackground().equals(new Color(0, 49, 83))))
                            && (!(board.getHorizontalField()[i][j].getBackground().equals(new Color(0, 49, 83))))) {
                        return FillTypeField.BOTH;
                    }
                    return FillTypeField.PREVIOUS;
                }
            }
        }
        return FillTypeField.NONE;
    }

    public void clearBoard() {
        for (int i = 0; i <= board.getAmountField(); i++) {
            for (int j = 0; j <= board.getAmountField(); j++) {
                if (i < board.getAmountField()) {
                    if (j < board.getAmountField()) {
                        board.getCenterField()[i][j].setBackground(new Color(0, 49, 83));
                    }
                    board.getVerticalField()[i][j].setBackground(new Color(0, 49, 83));
                }
                if (j < board.getAmountField()) {
                    board.getHorizontalField()[i][j].setBackground(new Color(0, 49, 83));
                }

            }
        }
        board.getFirstPlayerScoreLabel().setText("0");
        board.getSecondPlayerScoreLabel().setText("0");

        board.repaint();
    }
}
