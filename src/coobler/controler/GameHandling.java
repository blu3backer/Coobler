package coobler.controler;

import coobler.model.FillField;
import coobler.model.Game;
import coobler.model.Player;
import coobler.model.TypeOfField;
import coobler.view.Board;
import coobler.view.MainWindow;
import coobler.view.MenuPanel;
import coobler.view.MultiChoser;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Dawid
 */
public class GameHandling implements MouseListener {

    private MultiChoser multiChoser;
    private MenuPanel menuPanel;
    private Board board;
    private Game game;
    private MainWindow mainWindow;
    private Player turn;

    private Integer firstPlayerPoints;
    private Integer secondPlayerPoints;

    private boolean isTurn;

    public GameHandling(MultiChoser aMultiChoser, Board aBoard, MenuPanel aMenu, MainWindow aWindow) {
        this.firstPlayerPoints = 0;
        this.secondPlayerPoints = 0;
        this.turn = Player.FIRST;
        this.multiChoser = aMultiChoser;
        this.menuPanel = aMenu;
        this.board = aBoard;
        this.game = new Game(aBoard);
        this.mainWindow = aWindow;

        board.addComponentListener(new ComponentListener() {

            @Override
            public void componentResized(ComponentEvent e) {

                Board.WIDTH_PANEL = board.getWidth();
                Board.HEIGHT_PANEL = board.getHeight();

                Board.WIDTH_SCORE_PANEL = Board.WIDTH_PANEL / 6;
                Board.HEIGHT_SCORE_PANEL = Board.HEIGHT_PANEL;

                Board.WIDTH_BOARD_PANEL = 5 * (Board.WIDTH_PANEL / 6);
                Board.HEIGHT_BOARD_PANEL = Board.HEIGHT_PANEL;

                System.out.println(Board.SPACE_X);
                System.out.println(Board.SPACE_Y);
                System.out.println(Board.HEIGHT_BOARD_PANEL);
                board.createBoard();
                board.createPanels();
                board.createLabelsScoreAndName();
                board.repaint();
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
                            if (!board.getVerticalField()[i][j].getBackground().equals(multiChoser.getFirstColor())
                                    && !board.getVerticalField()[i][j].getBackground().equals(multiChoser.getSecondColor())) {
                                isTurn = true;
                                board.getVerticalField()[i][j].setBackground(multiChoser.getFirstColor());
                            } else {
                                isTurn = false;
                            }
                        } else {
                            if (!board.getVerticalField()[i][j].getBackground().equals(multiChoser.getFirstColor())
                                    && !board.getVerticalField()[i][j].getBackground().equals(multiChoser.getSecondColor())) {
                                isTurn = true;
                                board.getVerticalField()[i][j].setBackground(multiChoser.getSecondColor());
                            } else {
                                isTurn = false;
                            }

                        }

                        if (this.game.checkField(i, j, TypeOfField.VERTICAL).equals(FillField.CURRENT) && isTurn) {
                            if (this.turn.equals(Player.FIRST)) {
                                firstPlayerPoints = firstPlayerPoints + 1;
                                board.getFirstPlayerScoreLabel().setText(firstPlayerPoints.toString());
                                board.getCenterField()[i][j].setBackground(multiChoser.getFirstColor());
                            } else {
                                secondPlayerPoints = secondPlayerPoints + 1;
                                board.getSecondPlayerScoreLabel().setText(secondPlayerPoints.toString());
                                board.getCenterField()[i][j].setBackground(multiChoser.getSecondColor());
                            }
                        } else if (this.game.checkField(i, j, TypeOfField.VERTICAL).equals(FillField.PREVIOUS) && isTurn) {
                            if (this.turn.equals(Player.FIRST)) {
                                firstPlayerPoints = firstPlayerPoints + 1;
                                board.getFirstPlayerScoreLabel().setText(firstPlayerPoints.toString());
                                board.getCenterField()[i][j - 1].setBackground(multiChoser.getFirstColor());
                            } else {
                                secondPlayerPoints = secondPlayerPoints + 1;
                                board.getSecondPlayerScoreLabel().setText(secondPlayerPoints.toString());
                                board.getCenterField()[i][j - 1].setBackground(multiChoser.getSecondColor());
                            }

                        } else if (this.game.checkField(i, j, TypeOfField.VERTICAL).equals(FillField.BOTH) && isTurn) {
                            if (this.turn.equals(Player.FIRST)) {
                                firstPlayerPoints = firstPlayerPoints + 2;
                                board.getFirstPlayerScoreLabel().setText(firstPlayerPoints.toString());

                                board.getCenterField()[i][j].setBackground(multiChoser.getFirstColor());
                                board.getCenterField()[i][j - 1].setBackground(multiChoser.getFirstColor());
                            } else {
                                secondPlayerPoints = secondPlayerPoints + 2;
                                board.getSecondPlayerScoreLabel().setText(secondPlayerPoints.toString());

                                board.getCenterField()[i][j].setBackground(multiChoser.getSecondColor());
                                board.getCenterField()[i][j - 1].setBackground(multiChoser.getSecondColor());
                            }
                        } else {
                            if (this.turn.equals(Player.FIRST) && isTurn) {
                                this.turn = Player.SECOND;
                            } else if (this.turn.equals(Player.SECOND) && isTurn) {
                                this.turn = Player.FIRST;
                            }
                        }
                        board.repaint();
                    }

                }
                if (j < Board.AMOUNT_FIELD) {
                    if (e.getSource() == board.getHorizontalField()[i][j]) {
                        if (this.turn.equals(Player.FIRST)) {
                            if (!board.getHorizontalField()[i][j].getBackground().equals(multiChoser.getFirstColor())
                                    && !board.getHorizontalField()[i][j].getBackground().equals(multiChoser.getSecondColor())) {
                                isTurn = true;
                                board.getHorizontalField()[i][j].setBackground(multiChoser.getFirstColor());
                            } else {
                                isTurn = false;
                            }
                        } else {
                            if (!board.getHorizontalField()[i][j].getBackground().equals(multiChoser.getFirstColor())
                                    && !board.getHorizontalField()[i][j].getBackground().equals(multiChoser.getSecondColor())) {
                                isTurn = true;
                                board.getHorizontalField()[i][j].setBackground(multiChoser.getSecondColor());
                            } else {
                                isTurn = false;
                            }

                        }
                        if (this.game.checkField(i, j, TypeOfField.HORIZONTAL).equals(FillField.CURRENT) && isTurn) {
                            if (this.turn.equals(Player.FIRST)) {
                                firstPlayerPoints = firstPlayerPoints + 1;
                                board.getFirstPlayerScoreLabel().setText(firstPlayerPoints.toString());
                                board.getCenterField()[i][j].setBackground(multiChoser.getFirstColor());
                            } else {
                                secondPlayerPoints = secondPlayerPoints + 1;
                                board.getSecondPlayerScoreLabel().setText(secondPlayerPoints.toString());
                                board.getCenterField()[i][j].setBackground(multiChoser.getSecondColor());
                            }
                        } else if (this.game.checkField(i, j, TypeOfField.HORIZONTAL).equals(FillField.PREVIOUS) && isTurn) {
                            if (this.turn.equals(Player.FIRST)) {
                                firstPlayerPoints = firstPlayerPoints + 1;
                                board.getFirstPlayerScoreLabel().setText(firstPlayerPoints.toString());
                                board.getCenterField()[i - 1][j].setBackground(multiChoser.getFirstColor());
                            } else {
                                secondPlayerPoints = secondPlayerPoints + 1;
                                board.getSecondPlayerScoreLabel().setText(secondPlayerPoints.toString());
                                board.getCenterField()[i - 1][j].setBackground(multiChoser.getSecondColor());
                            }
                        } else if (this.game.checkField(i, j, TypeOfField.HORIZONTAL).equals(FillField.BOTH) && isTurn) {
                            if (this.turn.equals(Player.FIRST)) {
                                firstPlayerPoints = firstPlayerPoints + 2;
                                board.getFirstPlayerScoreLabel().setText(firstPlayerPoints.toString());

                                board.getCenterField()[i][j].setBackground(multiChoser.getFirstColor());
                                board.getCenterField()[i - 1][j].setBackground(multiChoser.getFirstColor());
                            } else {
                                secondPlayerPoints = secondPlayerPoints + 2;
                                board.getSecondPlayerScoreLabel().setText(secondPlayerPoints.toString());

                                board.getCenterField()[i][j].setBackground(multiChoser.getSecondColor());
                                board.getCenterField()[i - 1][j].setBackground(multiChoser.getSecondColor());
                            }
                        } else {
                            if (this.turn.equals(Player.FIRST) && isTurn) {
                                this.turn = Player.SECOND;
                            } else if (this.turn.equals(Player.SECOND) && isTurn) {
                                this.turn = Player.FIRST;
                            }
                        }
                        board.repaint();

                    }
                }
                if (firstPlayerPoints + secondPlayerPoints >= multiChoser.getSizeBoard() * multiChoser.getSizeBoard()) {
                    String[] options = {"Repeat", "Main menu", "Exit to OS"};
                    int choice;
                    if (firstPlayerPoints > secondPlayerPoints) {
                        choice = JOptionPane.showOptionDialog(board, "Winner is " + multiChoser.getFirstName() + "!!!", "WINNER", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
                    } else if (secondPlayerPoints > firstPlayerPoints) {
                        choice = JOptionPane.showOptionDialog(board, "Winner is " + multiChoser.getSecondName() + "!!!", "WINNER", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
                    } else {
                        choice = JOptionPane.showOptionDialog(board, "DRAW!!!", "DRAW", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
                    }
                    if (choice == 0) {
                        game.clearBoard();
                        this.firstPlayerPoints = 0;
                        this.secondPlayerPoints = 0;
                    } else if (choice == 2) {
                        System.exit(0);
                    } else {
                        menuPanel.setVisible(true);
                        board.setVisible(false);
                        this.firstPlayerPoints = 0;
                        this.secondPlayerPoints = 0;
                        mainWindow.getPanel().removeAll();
                        mainWindow.setPanel(menuPanel);
                        mainWindow.repaint();

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
