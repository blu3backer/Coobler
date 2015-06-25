package coobler.controler;

import coobler.model.FillTypeField;
import coobler.model.Game;
import coobler.model.Player;
import coobler.model.StoreData;
import coobler.model.TypeOfField;
import coobler.model.UsefulFeatures;
import coobler.view.Board;
import coobler.view.MenuPanel;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;

/**
 * The GameHandling is a class which receives user input and call appropriate
 * methods which change a board state. For this purpose implements MouseListener
 * interface.
 *
 * @author Dawid
 */
public class GameHandling implements MouseListener {

    private MenuPanel menuPanel;
    private Board board;
    private Game game;
    private Player turn;
    private StoreData sData;

    private boolean isTurn;

    /**
     * Creates a new instance of GameHandling
     *
     * @param storeData instance of StoreData class which stores date about game
     * @param aBoard game board
     * @param aMenu instance of class representing the main menu
     */
    public GameHandling(StoreData storeData, Board aBoard, MenuPanel aMenu) {

        this.turn = Player.FIRST;
        this.sData = storeData;
        this.menuPanel = aMenu;
        this.board = aBoard;
        this.game = new Game(aBoard);

        board.addComponentListener(new ComponentListener() {

            @Override
            public void componentResized(ComponentEvent e) {

                Board.WIDTH_PANEL = board.getWidth();
                Board.HEIGHT_PANEL = board.getHeight();

                Board.WIDTH_SCORE_PANEL = Board.WIDTH_PANEL / 6;
                Board.HEIGHT_SCORE_PANEL = Board.HEIGHT_PANEL;

                Board.WIDTH_BOARD_PANEL = 5 * (Board.WIDTH_PANEL / 6);
                Board.HEIGHT_BOARD_PANEL = Board.HEIGHT_PANEL;

                board.createBoard();
                board.createPanels();
                board.createLabelsScoreAndName();
                board.repaint();
                board.revalidate();
            }

            @Override
            public void componentMoved(ComponentEvent e) {

            }

            @Override
            public void componentShown(ComponentEvent e) {

            }

            @Override
            public void componentHidden(ComponentEvent e) {

            }
        });

        for (int i = 0; i < Board.AMOUNT_FIELD + 1; i++) {
            for (int j = 0; j < Board.AMOUNT_FIELD + 1; j++) {
                if (i < Board.AMOUNT_FIELD) {
                    board.getVerticalField()[i][j].addMouseListener(this);
                    this.game.checkField(i, j, TypeOfField.VERTICAL);
                }
                if (j < Board.AMOUNT_FIELD) {
                    board.getHorizontalField()[i][j].addMouseListener(this);

                }

            }
        }

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        for (int i = 0; i < Board.AMOUNT_FIELD + 1; i++) {
            for (int j = 0; j < Board.AMOUNT_FIELD + 1; j++) {

                if (i < Board.AMOUNT_FIELD) {
                    if (e.getSource() == board.getVerticalField()[i][j]) {
                        if (this.turn.equals(Player.FIRST)) {
                            if (!board.getVerticalField()[i][j].getBackground().equals(sData.getFirstColor())
                                    && !board.getVerticalField()[i][j].getBackground().equals(sData.getSecondColor())) {
                                isTurn = true;
                                board.getVerticalField()[i][j].setBackground(sData.getFirstColor());
                            } else {
                                isTurn = false;
                            }
                        } else {
                            if (!board.getVerticalField()[i][j].getBackground().equals(sData.getFirstColor())
                                    && !board.getVerticalField()[i][j].getBackground().equals(sData.getSecondColor())) {
                                isTurn = true;
                                board.getVerticalField()[i][j].setBackground(sData.getSecondColor());
                            } else {
                                isTurn = false;
                            }

                        }

                        if (this.game.checkField(i, j, TypeOfField.VERTICAL).equals(FillTypeField.CURRENT) && isTurn) {
                            if (this.turn.equals(Player.FIRST)) {
                                this.sData.setFirstPlayerPoint(this.sData.getFirstPlayerPoint() + 1);
                                board.getFirstPlayerScoreLabel().setText(this.sData.getFirstPlayerPoint().toString());
                                board.getCenterField()[i][j].setBackground(sData.getFirstColor());
                            } else {
                                this.sData.setSecondPlayerPoint(this.sData.getSecondPlayerPoint() + 1);
                                board.getSecondPlayerScoreLabel().setText(this.sData.getSecondPlayerPoint().toString());
                                board.getCenterField()[i][j].setBackground(sData.getSecondColor());
                            }
                        } else if (this.game.checkField(i, j, TypeOfField.VERTICAL).equals(FillTypeField.PREVIOUS) && isTurn) {
                            if (this.turn.equals(Player.FIRST)) {
                                this.sData.setFirstPlayerPoint(this.sData.getFirstPlayerPoint() + 1);
                                board.getFirstPlayerScoreLabel().setText(this.sData.getFirstPlayerPoint().toString());
                                board.getCenterField()[i][j - 1].setBackground(sData.getFirstColor());
                            } else {
                                this.sData.setSecondPlayerPoint(this.sData.getSecondPlayerPoint() + 1);
                                board.getSecondPlayerScoreLabel().setText(this.sData.getSecondPlayerPoint().toString());
                                board.getCenterField()[i][j - 1].setBackground(sData.getSecondColor());
                            }

                        } else if (this.game.checkField(i, j, TypeOfField.VERTICAL).equals(FillTypeField.BOTH) && isTurn) {
                            if (this.turn.equals(Player.FIRST)) {
                                this.sData.setFirstPlayerPoint(this.sData.getFirstPlayerPoint() + 2);
                                board.getFirstPlayerScoreLabel().setText(this.sData.getFirstPlayerPoint().toString());

                                board.getCenterField()[i][j].setBackground(sData.getFirstColor());
                                board.getCenterField()[i][j - 1].setBackground(sData.getFirstColor());
                            } else {
                                this.sData.setSecondPlayerPoint(this.sData.getSecondPlayerPoint() + 2);
                                board.getSecondPlayerScoreLabel().setText(this.sData.getSecondPlayerPoint().toString());

                                board.getCenterField()[i][j].setBackground(sData.getSecondColor());
                                board.getCenterField()[i][j - 1].setBackground(sData.getSecondColor());
                            }
                        } else {
                            if (this.turn.equals(Player.FIRST) && isTurn) {
                                this.turn = Player.SECOND;
                            } else if (this.turn.equals(Player.SECOND) && isTurn) {
                                this.turn = Player.FIRST;
                            }
                        }
                        board.repaint();
                        board.revalidate();
                    }

                }
                if (j < Board.AMOUNT_FIELD) {
                    if (e.getSource() == board.getHorizontalField()[i][j]) {
                        if (this.turn.equals(Player.FIRST)) {
                            if (!board.getHorizontalField()[i][j].getBackground().equals(sData.getFirstColor())
                                    && !board.getHorizontalField()[i][j].getBackground().equals(sData.getSecondColor())) {
                                isTurn = true;
                                board.getHorizontalField()[i][j].setBackground(sData.getFirstColor());
                            } else {
                                isTurn = false;
                            }
                        } else {
                            if (!board.getHorizontalField()[i][j].getBackground().equals(sData.getFirstColor())
                                    && !board.getHorizontalField()[i][j].getBackground().equals(sData.getSecondColor())) {
                                isTurn = true;
                                board.getHorizontalField()[i][j].setBackground(sData.getSecondColor());
                            } else {
                                isTurn = false;
                            }

                        }
                        if (this.game.checkField(i, j, TypeOfField.HORIZONTAL).equals(FillTypeField.CURRENT) && isTurn) {
                            if (this.turn.equals(Player.FIRST)) {
                                this.sData.setFirstPlayerPoint(this.sData.getFirstPlayerPoint() + 1);
                                board.getFirstPlayerScoreLabel().setText(this.sData.getFirstPlayerPoint().toString());
                                board.getCenterField()[i][j].setBackground(sData.getFirstColor());
                            } else {
                                this.sData.setSecondPlayerPoint(this.sData.getSecondPlayerPoint() + 1);
                                board.getSecondPlayerScoreLabel().setText(this.sData.getSecondPlayerPoint().toString());
                                board.getCenterField()[i][j].setBackground(sData.getSecondColor());
                            }
                        } else if (this.game.checkField(i, j, TypeOfField.HORIZONTAL).equals(FillTypeField.PREVIOUS) && isTurn) {
                            if (this.turn.equals(Player.FIRST)) {
                                this.sData.setFirstPlayerPoint(this.sData.getFirstPlayerPoint() + 1);
                                board.getFirstPlayerScoreLabel().setText(this.sData.getFirstPlayerPoint().toString());
                                board.getCenterField()[i - 1][j].setBackground(sData.getFirstColor());
                            } else {
                                this.sData.setSecondPlayerPoint(this.sData.getSecondPlayerPoint() + 1);
                                board.getSecondPlayerScoreLabel().setText(this.sData.getSecondPlayerPoint().toString());
                                board.getCenterField()[i - 1][j].setBackground(sData.getSecondColor());
                            }
                        } else if (this.game.checkField(i, j, TypeOfField.HORIZONTAL).equals(FillTypeField.BOTH) && isTurn) {
                            if (this.turn.equals(Player.FIRST)) {
                                this.sData.setFirstPlayerPoint(this.sData.getFirstPlayerPoint() + 2);
                                board.getFirstPlayerScoreLabel().setText(this.sData.getFirstPlayerPoint().toString());

                                board.getCenterField()[i][j].setBackground(sData.getFirstColor());
                                board.getCenterField()[i - 1][j].setBackground(sData.getFirstColor());
                            } else {
                                this.sData.setSecondPlayerPoint(this.sData.getSecondPlayerPoint() + 2);
                                board.getSecondPlayerScoreLabel().setText(this.sData.getSecondPlayerPoint().toString());

                                board.getCenterField()[i][j].setBackground(sData.getSecondColor());
                                board.getCenterField()[i - 1][j].setBackground(sData.getSecondColor());
                            }
                        } else {
                            if (this.turn.equals(Player.FIRST) && isTurn) {
                                this.turn = Player.SECOND;
                            } else if (this.turn.equals(Player.SECOND) && isTurn) {
                                this.turn = Player.FIRST;
                            }
                        }
                        board.repaint();
                        board.revalidate();

                    }
                }
                if (this.sData.getFirstPlayerPoint() + this.sData.getSecondPlayerPoint() >= sData.getSizeBoard() * sData.getSizeBoard()) {
                    String[] options = {"Repeat", "Main menu", "Exit to OS"};
                    int choice;
                    if (this.sData.getFirstPlayerPoint() > this.sData.getSecondPlayerPoint()) {
                        choice = JOptionPane.showOptionDialog(board, "Winner is " + sData.getFirstNick() + "!!!", "WINNER", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
                    } else if (this.sData.getSecondPlayerPoint() > this.sData.getFirstPlayerPoint()) {
                        choice = JOptionPane.showOptionDialog(board, "Winner is " + sData.getSecondNick() + "!!!", "WINNER", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
                    } else {
                        choice = JOptionPane.showOptionDialog(board, "DRAW!!!", "DRAW", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
                    }
                    if (choice == 0) {
                        game.clearBoard();
                        this.sData.setFirstPlayerPoint(0);
                        this.sData.setSecondPlayerPoint(0);
                        UsefulFeatures.update(board);
                    } else if (choice == 2) {
                        System.exit(0);
                    } else {
                        game.clearBoard();
                        this.sData.setFirstPlayerPoint(0);
                        this.sData.setSecondPlayerPoint(0);
                        UsefulFeatures.update(menuPanel, board);

                    }

                }
            }
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

}
