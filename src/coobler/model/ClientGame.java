package coobler.model;

import coobler.controler.LanGameHandling;
import coobler.view.Board;
import coobler.view.LanClientChooser;
import coobler.view.MainWindow;
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

    private boolean loopInterupted;

    public ClientGame(LanClientChooser aClientChooser, StoreData storeData, MenuPanel aMenuPanel) throws ClassNotFoundException {
        wFIC = new ChosenField();
        sData = storeData;
        this.clientChooser = aClientChooser;
        loopInterupted = true;
        this.menuPanel = aMenuPanel;

    }

    @Override
    protected Void doInBackground() throws Exception {
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
            clientChooser.setVisible(false);
            board.setVisible(true);
            MainWindow.MAIN_PANEL.removeAll();
            MainWindow.MAIN_PANEL.add(board);
            MainWindow.MAIN_PANEL.revalidate();
            MainWindow.MAIN_PANEL.repaint();

        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Can not find game. Try later...");
        }
        LanGameHandling.LOCK = false;
        while (loopInterupted) {

            this.input.readInt();
            this.wFIC.setXCenter(this.input.readInt());
            this.wFIC.setYCenter(this.input.readInt());

            this.wFIC.setY(this.input.readInt());
            this.wFIC.setX(this.input.readInt());

            this.wFIC.setFill(this.input.readBoolean());

            this.wFIC.setFillType((FillTypeField) this.input.readObject());
            this.wFIC.setTypeOfField((TypeOfField) this.input.readObject());

            System.out.println("CLIENT:" + wFIC.getX() + wFIC.getY() + wFIC.getFillType() + wFIC.getXCenter() + wFIC.getYCenter() + wFIC.getTypeOfField().toString());
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
                    gameHandling.getGame().clearBoard();
                    this.sData.setFirstPlayerPoint(0);
                    this.sData.setSecondPlayerPoint(0);
                    MainWindow.MAIN_PANEL.removeAll();
                    MainWindow.MAIN_PANEL.add(board);
                    MainWindow.MAIN_PANEL.repaint();
                } else if (choice == 2) {
                    try {
                        output.close();
                        input.close();
                        socket.close();
                    } catch (IOException ex) {
                        Logger.getLogger(ClientGame.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    System.exit(0);
                } else {
                    try {
                        output.close();
                        input.close();
                        socket.close();
                    } catch (IOException ex) {
                        Logger.getLogger(ClientGame.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    gameHandling.getGame().clearBoard();
                    menuPanel.setVisible(true);
                    board.setVisible(false);
                    this.sData.setFirstPlayerPoint(0);
                    this.sData.setSecondPlayerPoint(0);
                    MainWindow.MAIN_PANEL.removeAll();
                    MainWindow.MAIN_PANEL.add(menuPanel);
                    MainWindow.MAIN_PANEL.repaint();

                }

            }

        }
    }

    public ObjectOutputStream getOutput() {
        return this.output;
    }

    public Board getBoard() {
        return this.board;
    }
}
