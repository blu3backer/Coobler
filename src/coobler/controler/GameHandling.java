package coobler.controler;

import coobler.model.Game;
import coobler.model.TypeOfField;
import coobler.view.Board;
import coobler.view.MultiChoser;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 *
 * @author Dawid
 */
public class GameHandling implements MouseListener {

    private MultiChoser multiChoser;
    private Board board;
    private Game game;

    public GameHandling(MultiChoser aMultiChoser, Board aBoard) {
        this.multiChoser = aMultiChoser;
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
                        board.getVerticalField()[i][j].setBackground(multiChoser.getFirstColor());                        
                        if (this.game.checkField(i, j, TypeOfField.VERTICAL) && j==0) {
                            board.getCenterField()[i][j].setBackground(multiChoser.getFirstColor());
                        }
                        else if (this.game.checkField(i, j, TypeOfField.VERTICAL)&& j==Board.AMOUNT_FIELD) {
                            board.getCenterField()[i][j-1].setBackground(multiChoser.getFirstColor());
                        }
                        board.repaint();
                    }

                }
                if (j < Board.AMOUNT_FIELD) {
                    if (e.getSource() == board.getHorizontalField()[i][j]) {
                        board.getHorizontalField()[i][j].setBackground(multiChoser.getFirstColor());
                        if (this.game.checkField(i, j, TypeOfField.HORIZONTAL) && i==0) {
                            board.getCenterField()[i][j].setBackground(multiChoser.getFirstColor());
                        }
                        else if(this.game.checkField(i, j, TypeOfField.HORIZONTAL) && i==Board.AMOUNT_FIELD){
                            board.getCenterField()[i-1][j].setBackground(multiChoser.getFirstColor());
                        }
                        board.repaint();
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
