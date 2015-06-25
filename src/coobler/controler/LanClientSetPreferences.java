package coobler.controler;

import coobler.model.ClientGame;
import coobler.model.StoreData;
import coobler.view.LanClientChooser;
import coobler.view.MenuPanel;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JColorChooser;

/**
 * LanClientSetPreferences is a class which receives user input and call
 * appropriate methods in order to chose user color and set user name and then
 * join to the LAN game
 *
 * @author Dawid
 */
public class LanClientSetPreferences implements MouseListener {

    private LanClientChooser lanClientChoser;

    private StoreData sData;
    private ClientGame clientGame;
    private MenuPanel menuPanel;

    private ImageIcon choseButtonImage;
    private ImageIcon joinButtonImage;
    private ImageIcon choseButtonEnteredImage;
    private ImageIcon joinButtonEnteredImage;

    /**
     * Creates a new instance of LanClientSetPreferences class
     *
     * @param aLanClientChoser instance of class which shows panel for selecting
     * options for the game where user join to the lan game.
     *
     * @param aMenuPanel instance of class which shows panel which allows to
     * choose appropriate game mode
     */
    public LanClientSetPreferences(LanClientChooser aLanClientChoser, MenuPanel aMenuPanel) {
        this.lanClientChoser = aLanClientChoser;
        this.lanClientChoser.getColorChoserButton().addMouseListener(this);
        this.lanClientChoser.getJoinButton().addMouseListener(this);
        this.sData = new StoreData(Color.BLACK, Color.WHITE, "UNNAMED2", "UNNAMED");
        this.menuPanel = aMenuPanel;

        this.choseButtonImage = this.changeImage("grph/choseButton.png");
        this.joinButtonImage = this.changeImage("grph/waitJoinButton.png");
        
        this.choseButtonEnteredImage = this.changeImage("grph/enteredChoseButton.png");
        this.joinButtonEnteredImage = this.changeImage("grph/waitJoinButtonEntered.png");
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (e.getSource() == this.lanClientChoser.getColorChoserButton()) {
            this.lanClientChoser.getColorChoserButton().setIcon(choseButtonImage);
            this.sData.setFirstColor(JColorChooser.showDialog(null, "Chose color", this.sData.getFirstColor()));
            this.lanClientChoser.getShowColorChoserButton().setBackground(this.sData.getFirstColor());
        } else if (e.getSource() == this.lanClientChoser.getJoinButton()) {

            this.lanClientChoser.getJoinButton().setIcon(joinButtonImage);
            if (!this.lanClientChoser.getPlayerNameField().getText().equals("")) {
                this.sData.setFirstNick(this.lanClientChoser.getPlayerNameField().getText());
            }
            clientGame = new ClientGame(lanClientChoser, sData, menuPanel);

            this.clientGame.execute();

        }

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if (e.getSource() == this.lanClientChoser.getColorChoserButton()) {
            this.lanClientChoser.getColorChoserButton().setIcon(choseButtonEnteredImage);
        } else if (e.getSource() == this.lanClientChoser.getJoinButton()) {
            this.lanClientChoser.getJoinButton().setIcon(joinButtonEnteredImage);
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource() == this.lanClientChoser.getColorChoserButton()) {
            this.lanClientChoser.getColorChoserButton().setIcon(choseButtonImage);
        } else if (e.getSource() == this.lanClientChoser.getJoinButton()) {
            this.lanClientChoser.getJoinButton().setIcon(joinButtonImage);
        }
    }

    /**
     *
     * @param path path of the desired resource
     * @return ImageIcon contain image of button
     */
    public ImageIcon changeImage(String path) {
        URL url = getClass().getResource(path);
        ImageIcon image = new ImageIcon(url);
        return image;
    }
}
