package coobler.model;

import coobler.controler.LanGameHandling;
import coobler.view.Board;
import coobler.view.LanClientChooser;
import coobler.view.MenuPanel;
import java.awt.Color;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;

/**
 * ClientGame class which handle incoming and outgoing data in LAN game on the
 * side of the player who joined the game. This class extends SwingWorker class
 * and work in other thread.
 *
 * @author Dawid
 */
public class ClientGame extends SwingWorker<Void, ChosenField> {

    private Socket socket;
    private ServerSocket serverSocket;
    private Board board;
    private LanClientChooser clientChooser;
    private StoreData sData;
    private MenuPanel menuPanel;

    private ObjectInputStream input;
    private ObjectOutputStream output;
    private LanGameHandling gameHandling;
    private ChosenField wFIC;

    boolean interruption;

    /**
     *
     * @param aClientChooser panel which allows to set player settings
     * @param storeData player data and size of board
     * @param aMenuPanel main menu panel
     */
    public ClientGame(LanClientChooser aClientChooser, StoreData storeData, MenuPanel aMenuPanel) {
        wFIC = new ChosenField();
        sData = storeData;
        this.clientChooser = aClientChooser;
        this.menuPanel = aMenuPanel;

        this.interruption = true;

    }

    @Override
    protected Void doInBackground() {
        try {
            this.socket = new Socket("127.0.0.1", 10007);

            this.output = new ObjectOutputStream(socket.getOutputStream());
            this.input = new ObjectInputStream(new BufferedInputStream(socket.getInputStream()));

            this.sData.setSizeBoard((Integer) this.input.readObject());
            this.sData.setSecondNick((String) this.input.readObject());
            this.sData.setSecondColor((Color) this.input.readObject());

            this.output.writeObject(this.sData.getFirstNick());
            this.output.writeObject(this.sData.getFirstColor());

            this.board = new Board(sData);
            gameHandling = new LanGameHandling(sData, menuPanel, board, Player.SECOND, output, wFIC, input, serverSocket, socket);
            LanGameHandling.LOCK = false;
            UsefulFeatures.update(board, menuPanel);

        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Can not find game. Try later...");
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(menuPanel, "CLASS NOT FOUND EXCEPTION");
        }
        LanGameHandling.LOCK = false;
        while (interruption) {

            try {
                this.input.readInt();
                this.wFIC.setXCenter(this.input.readInt());
                this.wFIC.setYCenter(this.input.readInt());
                this.wFIC.setY(this.input.readInt());
                this.wFIC.setX(this.input.readInt());
                this.wFIC.setFill(this.input.readBoolean());

                this.wFIC.setFillType((FillTypeField) this.input.readObject());
                this.wFIC.setTypeOfField((TypeOfField) this.input.readObject());

            } catch (IOException ex) {
                break;
            } catch (ClassNotFoundException ex) {
                JOptionPane.showMessageDialog(menuPanel, "CLASS NOT FOUND EXCEPTION");
                break;
            }

            publish(wFIC);

        }

        return null;

    }

    @Override
    protected void process(List<ChosenField> chunks) {
        for (ChosenField temp : chunks) {
            if (temp.isFill()) {
                if (!temp.getFillType().equals(FillTypeField.BOTH) && !temp.getFillType().equals(FillTypeField.NONE)) {
                    if (temp.getTypeOfField().equals(TypeOfField.VERTICAL)) {
                        this.board.getVerticalField()[temp.getY()][temp.getX()].setBackground(sData.getSecondColor());

                    } else if (temp.getTypeOfField().equals(TypeOfField.HORIZONTAL)) {
                        this.board.getHorizontalField()[temp.getY()][temp.getX()].setBackground(sData.getSecondColor());

                    }
                    this.sData.setSecondPlayerPoint(this.sData.getSecondPlayerPoint() + 1);
                    board.getSecondPlayerScoreLabel().setText(this.sData.getSecondPlayerPoint().toString());
                    this.board.getCenterField()[temp.getYCenter()][temp.getXCenter()].setBackground(sData.getSecondColor());
                } else if (temp.getFillType().equals(FillTypeField.BOTH)) {
                    if (temp.getTypeOfField().equals(TypeOfField.VERTICAL)) {
                        this.board.getVerticalField()[temp.getY()][temp.getX()].setBackground(sData.getSecondColor());
                        this.board.getCenterField()[temp.getYCenter()][temp.getXCenter()].setBackground(sData.getSecondColor());
                        this.board.getCenterField()[temp.getYCenter()][temp.getXCenter() - 1].setBackground(sData.getSecondColor());
                        this.sData.setSecondPlayerPoint(this.sData.getSecondPlayerPoint() + 2);
                        board.getSecondPlayerScoreLabel().setText(this.sData.getSecondPlayerPoint().toString());

                    } else if (temp.getTypeOfField().equals(TypeOfField.HORIZONTAL)) {
                        this.board.getHorizontalField()[temp.getY()][temp.getX()].setBackground(sData.getSecondColor());
                        this.board.getCenterField()[temp.getYCenter()][temp.getXCenter()].setBackground(sData.getSecondColor());
                        this.board.getCenterField()[temp.getYCenter() - 1][temp.getXCenter()].setBackground(sData.getSecondColor());
                        this.sData.setSecondPlayerPoint(this.sData.getSecondPlayerPoint() + 2);
                        board.getSecondPlayerScoreLabel().setText(this.sData.getSecondPlayerPoint().toString());
                    }

                }
            } else {
                if (temp.getTypeOfField().equals(TypeOfField.VERTICAL)) {
                    this.board.getVerticalField()[temp.getY()][temp.getX()].setBackground(sData.getSecondColor());
                } else if (temp.getTypeOfField().equals(TypeOfField.HORIZONTAL)) {
                    this.board.getHorizontalField()[temp.getY()][temp.getX()].setBackground(sData.getSecondColor());
                }
                LanGameHandling.LOCK = true;
            }
            this.wFIC = new ChosenField();
            board.revalidate();
            board.repaint();
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
                    this.sData.setFirstPlayerPoint(0);
                    this.sData.setSecondPlayerPoint(0);
                    if (board.isVisible()) {
                        gameHandling.getGame().clearBoard();
                        UsefulFeatures.update(board);
                    }

                } else if (choice == 2) {
                    try {
                        output.close();
                        input.close();
                        socket.close();
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(menuPanel, "The problem of closure socket or streams");
                    }

                    System.exit(0);
                } else {
                    try {
                        output.close();
                        input.close();
                        socket.close();
                    } catch (IOException ex) {

                        JOptionPane.showMessageDialog(menuPanel, "The problem of closure socket or streams");
                    }
                    gameHandling.getGame().clearBoard();
                    this.sData.setFirstPlayerPoint(0);
                    this.sData.setSecondPlayerPoint(0);
                    this.interruption = false;

                }

            }

        }
    }

    @Override
    protected void done() {
        try {
            output.close();
            input.close();
            socket.close();

            UsefulFeatures.update(menuPanel, board);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(menuPanel, "The problem of closure socket or streams");
        }
    }

    /**
     *
     * @return stream output socket
     */
    public ObjectOutputStream getOutput() {
        return this.output;
    }

    /**
     *
     * @return board current game
     */
    public Board getBoard() {
        return this.board;
    }
}
