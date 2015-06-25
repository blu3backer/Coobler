package coobler.model;

import coobler.controler.LanGameHandling;
import coobler.view.Board;
import coobler.view.LoadingView;
import coobler.view.MenuPanel;
import java.awt.Color;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;

/**
 * ServerGame class which handle incoming and outgoing data in LAN game on the
 * side of the player who created the new game. This class extends SwingWorker
 * class and work in other thread.
 *
 * @author Dawid
 */
public class ServerGame extends SwingWorker<Void, ChosenField> {

    private LoadingView loadingView;
    private StoreData sData;

    private ServerSocket server;
    private Socket socket;
    private Board board;
    private ChosenField wFIC;
    private MenuPanel menuPanel;

    private ObjectInputStream input;
    private ObjectOutputStream output;

    private LanGameHandling gameHandling;

    private boolean interruption;

    /**
     *
     * @param aLoadingView the panel which simulates loading game
     * @param storeData player data and size of board
     * @param aMenuPanel main menu panel
     */
    public ServerGame(LoadingView aLoadingView, StoreData storeData, MenuPanel aMenuPanel) {
        this.menuPanel = aMenuPanel;
        this.loadingView = aLoadingView;
        this.sData = storeData;
        this.interruption = true;

        this.wFIC = new ChosenField();
    }

    @Override
    public Void doInBackground() {

        try {
            server = new ServerSocket(10007);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(menuPanel, "The problem of creation socket");
        }

        try {
            socket = server.accept();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(menuPanel, "No connection");
        }

        try {
            this.output = new ObjectOutputStream(socket.getOutputStream());
            this.input = new ObjectInputStream(new BufferedInputStream(socket.getInputStream()));
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(menuPanel, "The problem with the creation streams");
        }

        try {
            this.output.writeObject(this.sData.getSizeBoard());
            this.output.writeObject(this.sData.getFirstNick());
            this.output.writeObject(this.sData.getFirstColor());
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(menuPanel, "The problem with sending data");
        }

        try {
            this.sData.setSecondNick((String) this.input.readObject());
            this.sData.setSecondColor((Color) this.input.readObject());
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(menuPanel, "The problem with geting data");
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(menuPanel, "CLASS NOT FOUND EXCEPTION");
        }

        this.board = new Board(sData);
        gameHandling = new LanGameHandling(sData, menuPanel, board, Player.SECOND, output, wFIC, input, server, socket);

        LanGameHandling.LOCK = true;
        UsefulFeatures.update(board, loadingView);
        while (true) {

            try {
                this.input.readInt();
            } catch (IOException ex) {

                break;
            }

            try {

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
                        server.close();
                        socket.close();
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(menuPanel, "The problem of closure sockets or streams");
                    }

                    System.exit(0);
                } else {
                    try {
                        output.close();
                        input.close();
                        server.close();
                        socket.close();
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(menuPanel, "The problem of closure sockets or streams");
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
            server.close();
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
     * @return stream input socket
     */
    public ObjectInputStream getInput() {
        return this.input;
    }

    /**
     *
     * @return socket
     */
    public Socket getSocket() {
        return this.socket;
    }

    /**
     *
     * @return current board
     */
    public Board getBoard() {
        return this.board;
    }
}
