package coobler.controler;

import coobler.model.ClientGame;
import coobler.model.StoreData;
import coobler.view.LanClientChooser;
import coobler.view.MenuPanel;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JColorChooser;

/**
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
    private ImageIcon choseButtonPressedImage;
    private ImageIcon joinButtonPressedImage;

    public LanClientSetPreferences(LanClientChooser aLanClientChoser, MenuPanel aMenuPanel) {
        this.lanClientChoser = aLanClientChoser;
        this.lanClientChoser.getColorChoserButton().addMouseListener(this);
        this.lanClientChoser.getJoinButton().addMouseListener(this);
        this.sData = new StoreData(Color.BLACK, Color.WHITE,"UNNAMED2","UNNAMED");
        this.menuPanel = aMenuPanel;

        URL choseButtonURL = getClass().getResource("grph/choseButton.png");
        URL joinButtonURL = getClass().getResource("grph/waitJoinButton.png");
        URL choseButtonEnteredURL = getClass().getResource("grph/enteredChoseButton.png");
        URL joinButtonEnteredURL = getClass().getResource("grph/waitJoinButtonEntered.png");
        URL choseButtonPressedURL = getClass().getResource("grph/clickedChoseButton.png");
        URL joinButtonPressedURL = getClass().getResource("grph/waitJoinButtonPressed.png");

        choseButtonImage = new ImageIcon(choseButtonURL);
        joinButtonImage = new ImageIcon(joinButtonURL);
        choseButtonPressedImage = new ImageIcon(choseButtonPressedURL);
        joinButtonPressedImage = new ImageIcon(joinButtonPressedURL);
        choseButtonEnteredImage = new ImageIcon(choseButtonEnteredURL);
        joinButtonEnteredImage = new ImageIcon(joinButtonEnteredURL);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getSource() == this.lanClientChoser.getColorChoserButton()) {
            this.lanClientChoser.getColorChoserButton().setIcon(choseButtonPressedImage);
        } else if (e.getSource() == this.lanClientChoser.getJoinButton()) {
            this.lanClientChoser.getJoinButton().setIcon(joinButtonPressedImage);
        }
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
            try {
                clientGame = new ClientGame(lanClientChoser, sData, menuPanel);

            } catch (ClassNotFoundException ex) {
                Logger.getLogger(LanClientSetPreferences.class.getName()).log(Level.SEVERE, null, ex);
            }

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

}
