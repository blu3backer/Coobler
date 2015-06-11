package coobler.controler;

import coobler.model.StoreData;
import coobler.view.Board;
import coobler.view.MainWindow;
import coobler.view.MenuPanel;
import coobler.view.MultiplayerChoser;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JColorChooser;

/**
 * @author Dawid
 */
public class MultiplayerSetPreferences implements MouseListener {

    private MultiplayerChoser multiChoser;

    private GameHandling gameHandling;
    private Board board;
    private MenuPanel menuPanel;
    private StoreData sData;

    private ImageIcon firstChoseButtonIcon;
    private ImageIcon secondChoseButtonIcon;
    private ImageIcon okButtonIcon;

    private ImageIcon firstChoseButtonPressedIcon;
    private ImageIcon secondChoseButtonPressedIcon;
    private ImageIcon okButtonPressedIcon;

    private ImageIcon firstChoseButtonEnteredIcon;
    private ImageIcon secondChoseButtonEnteredIcon;
    private ImageIcon okButtonEnteredIcon;

    public MultiplayerSetPreferences(MultiplayerChoser aMultiChoser, MenuPanel aMenu) {

        this.multiChoser = aMultiChoser;
        this.menuPanel = aMenu;

        this.sData = new StoreData(Color.WHITE, Color.BLACK,"UNNAMED","UNNAMED2");
        this.multiChoser.getFirstColorChoserButton().addMouseListener(this);
        this.multiChoser.getSecondColorChoserButton().addMouseListener(this);
        this.multiChoser.getOkButton().addMouseListener(this);

        URL firstURL = getClass().getResource("grph/choseButton.png");
        URL secondURL = getClass().getResource("grph/choseButton.png");
        URL okURL = getClass().getResource("grph/okButton.png");

        firstChoseButtonIcon = new ImageIcon(firstURL);
        secondChoseButtonIcon = new ImageIcon(secondURL);
        okButtonIcon = new ImageIcon(okURL);

        URL firstPressedURL = getClass().getResource("grph/clickedChoseButton.png");
        URL secondPressedURL = getClass().getResource("grph/clickedChoseButton.png");
        URL okPressedURL = getClass().getResource("grph/clickedOkButton.png");

        firstChoseButtonPressedIcon = new ImageIcon(firstPressedURL);
        secondChoseButtonPressedIcon = new ImageIcon(secondPressedURL);
        okButtonPressedIcon = new ImageIcon(okPressedURL);

        URL firstEnteredURL = getClass().getResource("grph/enteredChoseButton.png");
        URL secondEnteredURL = getClass().getResource("grph/enteredChoseButton.png");
        URL okEnteredURL = getClass().getResource("grph/enteredOkButton.png");

        firstChoseButtonEnteredIcon = new ImageIcon(firstEnteredURL);
        secondChoseButtonEnteredIcon = new ImageIcon(secondEnteredURL);
        okButtonEnteredIcon = new ImageIcon(okEnteredURL);

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        ;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getSource() == multiChoser.getFirstColorChoserButton()) {
            multiChoser.getFirstColorChoserButton().setIcon(firstChoseButtonPressedIcon);

        } else if (e.getSource() == multiChoser.getSecondColorChoserButton()) {
            multiChoser.getSecondColorChoserButton().setIcon(secondChoseButtonPressedIcon);

        } else if (e.getSource() == multiChoser.getOkButton()) {
            multiChoser.getOkButton().setIcon(okButtonPressedIcon);

        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (e.getSource() == multiChoser.getFirstColorChoserButton()) {
            multiChoser.getFirstColorChoserButton().setIcon(firstChoseButtonIcon);
            sData.setFirstColor(JColorChooser.showDialog(null, "Color choser", sData.getFirstColor()));
            multiChoser.getShowFirstColorChoserButton().setBackground(sData.getFirstColor());

        } else if (e.getSource() == multiChoser.getSecondColorChoserButton()) {
            multiChoser.getSecondColorChoserButton().setIcon(secondChoseButtonIcon);
            sData.setSecondColor(JColorChooser.showDialog(null, "Color choser", sData.getSecondColor()));
            multiChoser.getShowSecondColorChoserButton().setBackground(sData.getSecondColor());

        } else if (e.getSource() == multiChoser.getOkButton()) {
            if (!multiChoser.getFirstPlayerNameField().getText().equals("")) {
                sData.setFirstNick(multiChoser.getFirstPlayerNameField().getText());
            }
            if (!multiChoser.getSecondPlayerNameField().getText().equals("")) {
                sData.setSecondNick(multiChoser.getSecondPlayerNameField().getText());
            }

            sData.setSizeBoard(multiChoser.getBoardSize().getSelectedIndex() + 4);

            this.board = new Board(sData);
            this.gameHandling = new GameHandling(sData, board, this.menuPanel);
            multiChoser.getOkButton().setIcon(okButtonIcon);

            multiChoser.setVisible(false);
            board.setVisible(true);

            MainWindow.MAIN_PANEL.removeAll();
            MainWindow.MAIN_PANEL.add(board);
            MainWindow.MAIN_PANEL.repaint();
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if (e.getSource() == multiChoser.getFirstColorChoserButton()) {
            multiChoser.getFirstColorChoserButton().setIcon(firstChoseButtonEnteredIcon);

        } else if (e.getSource() == multiChoser.getSecondColorChoserButton()) {
            multiChoser.getSecondColorChoserButton().setIcon(secondChoseButtonEnteredIcon);

        } else if (e.getSource() == multiChoser.getOkButton()) {
            multiChoser.getOkButton().setIcon(okButtonEnteredIcon);
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource() == multiChoser.getFirstColorChoserButton()) {
            multiChoser.getFirstColorChoserButton().setIcon(firstChoseButtonIcon);

        } else if (e.getSource() == multiChoser.getSecondColorChoserButton()) {
            multiChoser.getSecondColorChoserButton().setIcon(secondChoseButtonIcon);

        } else if (e.getSource() == multiChoser.getOkButton()) {
            multiChoser.getOkButton().setIcon(okButtonIcon);
        }
    }

}
