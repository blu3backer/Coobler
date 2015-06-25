package coobler.controler;

import coobler.model.ServerGame;
import coobler.model.StoreData;
import coobler.model.UsefulFeatures;
import coobler.view.LanServerChooser;
import coobler.view.LoadingView;
import coobler.view.MenuPanel;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JColorChooser;

/**
 * LanServerSetPreferences is a class which receives user input and call
 * appropriate methods in order to chose user color, set user name and chose
 * size of board and then create the new LAN game
 *
 * @author Dawid
 */
public class LanServerSetPreferences implements MouseListener {

    private final LanServerChooser lanServerChoser;
    private final LoadingView loadingView;
    private ServerGame serverGame;
    private final StoreData sData;
    private final MenuPanel menuPanel;

    private ImageIcon choseButtonImage;
    private ImageIcon startButtonImage;
    private ImageIcon choseButtonEnteredImage;
    private ImageIcon startButtonEnteredImage;

    /**
     *
     * @param aLanServerChoser instance of class which shows panel for selecting
     * options for the game where user creting to the lan game.
     *
     * @param aMenuPanel instance of class which shows panel which allows to
     * choose appropriate game mode
     */
    public LanServerSetPreferences(LanServerChooser aLanServerChoser, MenuPanel aMenuPanel) {
        this.menuPanel = aMenuPanel;
        this.lanServerChoser = aLanServerChoser;
        this.loadingView = new LoadingView();
        this.lanServerChoser.getColorChoserButton().addMouseListener(this);
        this.lanServerChoser.getStartButton().addMouseListener(this);
        sData = new StoreData(Color.WHITE, Color.BLACK, "UNNAMED", "UNNAMED2");

        this.choseButtonImage = this.changeImage("grph/choseButton.png");
        this.startButtonImage = this.changeImage("grph/startServerButton.png");
        this.choseButtonEnteredImage = this.changeImage("grph/enteredChoseButton.png");
        this.startButtonEnteredImage = this.changeImage("grph/startServerButtonEntered.png");
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (e.getSource() == this.lanServerChoser.getColorChoserButton()) {
            this.lanServerChoser.getColorChoserButton().setIcon(choseButtonImage);
            this.sData.setFirstColor(JColorChooser.showDialog(
                    null, "Choser color", sData.getFirstColor()));
            this.lanServerChoser.getShowColorChoserButton().
                    setBackground(sData.getFirstColor());
        } else if (e.getSource() == this.lanServerChoser.getStartButton()) {
            this.lanServerChoser.getStartButton().setIcon(startButtonImage);
            if (!lanServerChoser.getPlayerNameField().getText().equals("")) {
                sData.setFirstNick(lanServerChoser.getPlayerNameField().getText());
            }
            sData.setSizeBoard(lanServerChoser.getSizeBoard().getSelectedIndex() + 3);
            serverGame = new ServerGame(loadingView, sData, menuPanel);
            serverGame.execute();

            UsefulFeatures.update(loadingView, lanServerChoser);

        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if (e.getSource() == this.lanServerChoser.getColorChoserButton()) {
            this.lanServerChoser.getColorChoserButton().setIcon(choseButtonEnteredImage);
        } else if (e.getSource() == this.lanServerChoser.getStartButton()) {
            this.lanServerChoser.getStartButton().setIcon(startButtonEnteredImage);
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource() == this.lanServerChoser.getColorChoserButton()) {
            this.lanServerChoser.getColorChoserButton().setIcon(choseButtonImage);
        } else if (e.getSource() == this.lanServerChoser.getStartButton()) {
            this.lanServerChoser.getStartButton().setIcon(startButtonImage);
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
