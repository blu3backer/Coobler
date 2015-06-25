package coobler.controler;

import com.sun.java.accessibility.util.AWTEventMonitor;
import coobler.model.FillTypeField;
import coobler.model.Game;
import coobler.model.Player;
import coobler.model.StoreData;
import coobler.model.TypeOfField;
import coobler.model.ChosenField;
import coobler.model.UsefulFeatures;
import coobler.view.Board;
import coobler.view.MenuPanel;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 * The LanGameHandling is a class which receives user input and call appropriate
 * methods which change a board state in LAN game. For this purpose implements
 * MouseListener interface.
 *
 * @author Dawid
 */
public class LanGameHandling implements MouseListener {

    private MenuPanel menuPanel;
    private Board board;
    private Game game;
    private StoreData sData;
    private ChosenField wFIC;

    private boolean isTurn;

    private ObjectOutputStream output;
    private ObjectInputStream input;
    private ServerSocket server;
    private Socket socket;

    public static boolean LOCK;

    /**
     *
     * @param storeData instance of class which stores data game
     * @param aMenu instance of class which shows main menu
     * @param aBoard game board
     * @param aPlayer enum type which represents current user
     * @param out instance of ObjectOutputStream which is used to close the
     * stream in WindowsListener
     * @param wf this instance of class stores data which is used to exchange
     * data in network game
     * @param in instance of ObjectInputStream which is used to close the stream
     * in WindowsListener
     * @param sSock instance of ServerSocket which is used to close the server
     * socket in WindowsListener
     * @param sock instance of Socket which is used to close the socket in
     * WindowsListener
     */
    public LanGameHandling(StoreData storeData, MenuPanel aMenu, Board aBoard, Player aPlayer, ObjectOutputStream out, ChosenField wf, ObjectInputStream in, ServerSocket sSock, Socket sock) {
        this.wFIC = wf;
        this.sData = storeData;
        this.menuPanel = aMenu;
        this.board = aBoard;
        this.game = new Game(aBoard);
        this.output = out;
        this.input = in;
        this.server = sSock;
        this.socket = sock;
        LanGameHandling.LOCK = false;

        AWTEventMonitor.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                try {
                    output.close();
                    input.close();
                    server.close();
                    socket.close();
                } catch (IOException ex) {
                    Logger.getLogger(LanGameHandling.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

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

        if (LanGameHandling.LOCK) {
            for (int i = 0; i < Board.AMOUNT_FIELD + 1; i++) {
                for (int j = 0; j < Board.AMOUNT_FIELD + 1; j++) {

                    if (i < Board.AMOUNT_FIELD) {
                        if (e.getSource() == board.getVerticalField()[i][j]) {

                            if (!board.getVerticalField()[i][j].getBackground().equals(sData.getFirstColor())
                                    && !board.getVerticalField()[i][j].getBackground().equals(sData.getSecondColor())) {
                                isTurn = true;
                                board.getVerticalField()[i][j].setBackground(sData.getFirstColor());

                                wFIC.setX(j);
                                wFIC.setY(i);
                                wFIC.setTypeOfField(TypeOfField.VERTICAL);
                            } else {
                                isTurn = false;
                            }

                            if (this.game.checkField(i, j, TypeOfField.VERTICAL).equals(FillTypeField.CURRENT) && isTurn) {

                                this.sData.setFirstPlayerPoint(this.sData.getFirstPlayerPoint() + 1);
                                board.getFirstPlayerScoreLabel().setText(this.sData.getFirstPlayerPoint().toString());
                                board.getCenterField()[i][j].setBackground(sData.getFirstColor());

                                wFIC.setXCenter(j);
                                wFIC.setYCenter(i);
                                wFIC.setFill(true);
                                wFIC.setFillType(FillTypeField.CURRENT);

                            } else if (this.game.checkField(i, j, TypeOfField.VERTICAL).equals(FillTypeField.PREVIOUS) && isTurn) {

                                this.sData.setFirstPlayerPoint(this.sData.getFirstPlayerPoint() + 1);
                                board.getFirstPlayerScoreLabel().setText(this.sData.getFirstPlayerPoint().toString());
                                board.getCenterField()[i][j - 1].setBackground(sData.getFirstColor());

                                wFIC.setXCenter(j - 1);
                                wFIC.setYCenter(i);
                                wFIC.setFill(true);
                                wFIC.setFillType(FillTypeField.PREVIOUS);

                            } else if (this.game.checkField(i, j, TypeOfField.VERTICAL).equals(FillTypeField.BOTH) && isTurn) {

                                this.sData.setFirstPlayerPoint(this.sData.getFirstPlayerPoint() + 2);
                                board.getFirstPlayerScoreLabel().setText(this.sData.getFirstPlayerPoint().toString());

                                board.getCenterField()[i][j].setBackground(sData.getFirstColor());
                                board.getCenterField()[i][j - 1].setBackground(sData.getFirstColor());

                                wFIC.setXCenter(j);
                                wFIC.setYCenter(i);
                                wFIC.setFill(true);
                                wFIC.setFillType(FillTypeField.BOTH);

                            } else {
                                if (isTurn) {

                                    LanGameHandling.LOCK = false;

                                    wFIC.setXCenter(-1);
                                    wFIC.setYCenter(-1);
                                    wFIC.setFill(false);
                                    wFIC.setFillType(FillTypeField.NONE);

                                }
                            }
                            if (isTurn) {
                                try {

                                    output.writeInt(2);
                                    output.writeInt(wFIC.getXCenter());
                                    output.writeInt(wFIC.getYCenter());

                                    output.writeInt(wFIC.getY());
                                    output.writeInt(wFIC.getX());

                                    output.writeBoolean(wFIC.isFill());

                                    output.writeObject(wFIC.getFillType());
                                    output.writeObject(wFIC.getTypeOfField());

                                } catch (IOException ex) {
                                    Logger.getLogger(LanGameHandling.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }
                            board.revalidate();
                            board.repaint();
                        }

                    }
                    if (j < Board.AMOUNT_FIELD) {
                        if (e.getSource() == board.getHorizontalField()[i][j]) {

                            if (!board.getHorizontalField()[i][j].getBackground().equals(sData.getFirstColor())
                                    && !board.getHorizontalField()[i][j].getBackground().equals(sData.getSecondColor())) {
                                isTurn = true;
                                board.getHorizontalField()[i][j].setBackground(sData.getFirstColor());

                                wFIC.setX(j);
                                wFIC.setY(i);
                                wFIC.setTypeOfField(TypeOfField.HORIZONTAL);

                            } else {
                                isTurn = false;
                            }

                            if (this.game.checkField(i, j, TypeOfField.HORIZONTAL).equals(FillTypeField.CURRENT) && isTurn) {

                                this.sData.setFirstPlayerPoint(this.sData.getFirstPlayerPoint() + 1);
                                board.getFirstPlayerScoreLabel().setText(this.sData.getFirstPlayerPoint().toString());
                                board.getCenterField()[i][j].setBackground(sData.getFirstColor());

                                wFIC.setXCenter(j);
                                wFIC.setYCenter(i);
                                wFIC.setFill(true);
                                wFIC.setFillType(FillTypeField.CURRENT);

                            } else if (this.game.checkField(i, j, TypeOfField.HORIZONTAL).equals(FillTypeField.PREVIOUS) && isTurn) {

                                this.sData.setFirstPlayerPoint(this.sData.getFirstPlayerPoint() + 1);
                                board.getFirstPlayerScoreLabel().setText(this.sData.getFirstPlayerPoint().toString());
                                board.getCenterField()[i - 1][j].setBackground(sData.getFirstColor());

                                wFIC.setXCenter(j);
                                wFIC.setYCenter(i - 1);
                                wFIC.setFill(true);
                                wFIC.setFillType(FillTypeField.PREVIOUS);

                            } else if (this.game.checkField(i, j, TypeOfField.HORIZONTAL).equals(FillTypeField.BOTH) && isTurn) {

                                this.sData.setFirstPlayerPoint(this.sData.getFirstPlayerPoint() + 2);
                                board.getFirstPlayerScoreLabel().setText(this.sData.getFirstPlayerPoint().toString());

                                board.getCenterField()[i][j].setBackground(sData.getFirstColor());
                                board.getCenterField()[i - 1][j].setBackground(sData.getFirstColor());

                                wFIC.setXCenter(j);
                                wFIC.setYCenter(i);
                                wFIC.setFill(true);
                                wFIC.setFillType(FillTypeField.BOTH);

                            } else {
                                if (isTurn) {

                                    LanGameHandling.LOCK = false;

                                    wFIC.setXCenter(-1);
                                    wFIC.setYCenter(-1);
                                    wFIC.setFill(false);
                                    wFIC.setFillType(FillTypeField.NONE);
                                }
                            }
                            if (isTurn) {
                                try {

                                    output.writeInt(2);
                                    output.writeInt(wFIC.getXCenter());
                                    output.writeInt(wFIC.getYCenter());

                                    output.writeInt(wFIC.getY());
                                    output.writeInt(wFIC.getX());

                                    output.writeBoolean(wFIC.isFill());

                                    output.writeObject(wFIC.getFillType());
                                    output.writeObject(wFIC.getTypeOfField());

                                } catch (IOException ex) {

                                }
                            }
                            board.revalidate();
                            board.repaint();

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

                            try {

                                socket.close();
                                input.close();
                                output.close();
                            } catch (IOException ex) {
                                JOptionPane.showMessageDialog(menuPanel, "The problem of closure socket or streams");
                            }

                            System.exit(0);
                        } else {
                            try {

                                socket.close();
                                input.close();
                                output.close();
                            } catch (IOException ex) {
                                JOptionPane.showMessageDialog(menuPanel, "The problem of closure socket or streams");
                            }
                            game.clearBoard();
                            this.sData.setFirstPlayerPoint(0);
                            this.sData.setSecondPlayerPoint(0);
                            UsefulFeatures.update(menuPanel, board);

                        }

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

    /**
     *
     * @return object which controls movements of players
     */
    public Game getGame() {
        return this.game;
    }
}
