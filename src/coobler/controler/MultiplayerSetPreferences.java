package coobler.controler;

import coobler.model.StoreData;
import coobler.model.UsefulFeatures;
import coobler.view.Board;
import coobler.view.MenuPanel;
import coobler.view.MultiplayerChoser;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JColorChooser;

/**
 * MultiplayerSetPreferences is a class which receives user input and call
 * appropriate methods in order to chose user color and set user name for both
 * players and then create new multiplayer game.
 *
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

    private ImageIcon firstChoseButtonEnteredIcon;
    private ImageIcon secondChoseButtonEnteredIcon;
    private ImageIcon okButtonEnteredIcon;

    /**
     *
     * @param aMultiChoser instance of class which shows panel for selecting
     * options for the game where user join to the multiplayer game.
     *
     * @param aMenu instance of class which shows panel which allows to choose
     * appropriate game mode
     */
    public MultiplayerSetPreferences(MultiplayerChoser aMultiChoser, MenuPanel aMenu) {

        this.multiChoser = aMultiChoser;
        this.menuPanel = aMenu;

        this.sData = new StoreData(Color.WHITE, Color.BLACK, "UNNAMED", "UNNAMED2");
        this.multiChoser.getFirstColorChoserButton().addMouseListener(this);
        this.multiChoser.getSecondColorChoserButton().addMouseListener(this);
        this.multiChoser.getOkButton().addMouseListener(this);

        this.firstChoseButtonIcon = this.changeImage("grph/choseButton.png");
        this.secondChoseButtonIcon = this.changeImage("grph/choseButton.png");
        this.okButtonIcon = this.changeImage("grph/okButton.png");

        this.firstChoseButtonEnteredIcon = this.changeImage("grph/enteredChoseButton.png");
        this.secondChoseButtonEnteredIcon = this.changeImage("grph/enteredChoseButton.png");
        this.okButtonEnteredIcon = this.changeImage("grph/enteredOkButton.png");

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        ;
    }

    @Override
    public void mousePressed(MouseEvent e) {
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

            sData.setSizeBoard(multiChoser.getBoardSize().getSelectedIndex() + 3);

            this.board = new Board(sData);
            this.gameHandling = new GameHandling(sData, board, this.menuPanel);
            multiChoser.getOkButton().setIcon(okButtonIcon);

            UsefulFeatures.update(board, multiChoser);
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

    /**
     *
     * @param path path of the desired resource
     * @return ImageIcon contain image of button
     */
    public final ImageIcon changeImage(String path) {
        URL url = getClass().getResource(path);
        ImageIcon image = new ImageIcon(url);
        return image;
    }

}
