package coobler.controler;

import coobler.model.UsefulFeatures;
import coobler.view.LanClientChooser;
import coobler.view.LanServerChooser;
import coobler.view.MenuPanel;
import coobler.view.MultiplayerChoser;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;
import javax.swing.ImageIcon;

/**
 * NavigationHandling is a class which receives user input and call method which
 * begin selected new game mode.
 *
 * @author Dawid
 */
public class NavigationHandling implements MouseListener {

    private MenuPanel menuPanel;
    private LanClientChooser clientChoser;
    private LanServerChooser serverChoser;

    private LanClientSetPreferences clientHandling;
    private LanServerSetPreferences serverHandling;

    private ImageIcon joinEnteredIcon;
    private ImageIcon multiEnteredIcon;
    private ImageIcon lanEnteredIcon;
    private ImageIcon exitEnteredIcon;

    private ImageIcon joinIcon;
    private ImageIcon multiIcon;
    private ImageIcon lanIcon;
    private ImageIcon exitIcon;

    private MultiplayerChoser multiChoser;
    private MultiplayerSetPreferences multiplyPreferences;

    /**
     * Creates a new instance of NavigationHandling class
     *
     * @param aMenuPane instance of class which shows panel which allows to
     * choose appropriate game mode
     */
    public NavigationHandling(MenuPanel aMenuPane) {

        this.menuPanel = aMenuPane;
        this.menuPanel.getJoinButton().addMouseListener(this);
        this.menuPanel.getMultiPlayerButton().addMouseListener(this);
        this.menuPanel.getLanModeButton().addMouseListener(this);
        this.menuPanel.getExitButton().addMouseListener(this);
        this.multiChoser = new MultiplayerChoser();

        this.clientChoser = new LanClientChooser();
        this.serverChoser = new LanServerChooser();

        this.clientHandling = new LanClientSetPreferences(clientChoser, menuPanel);
        this.serverHandling = new LanServerSetPreferences(serverChoser, menuPanel);

        this.multiplyPreferences = new MultiplayerSetPreferences(multiChoser, menuPanel);
        lanEnteredIcon = this.changeImage("grph/enteredLanButton.png");
        joinEnteredIcon = this.changeImage("grph/enteredJoinButton.png");
        multiEnteredIcon = this.changeImage("grph/enteredMultiButton.png");
        exitEnteredIcon = this.changeImage("grph/enteredExitButton.png");

        lanIcon = this.changeImage("grph/lanButton.png");
        joinIcon = this.changeImage("grph/joinButton.png");
        multiIcon = this.changeImage("grph/multiButton.png");
        exitIcon = this.changeImage("grph/exitButton.png");
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
        if (e.getSource() == this.menuPanel.getJoinButton()) {
            this.menuPanel.getJoinButton().setIcon(joinIcon);
            UsefulFeatures.update(clientChoser, menuPanel);
        }
        if (e.getSource() == this.menuPanel.getMultiPlayerButton()) {
            this.menuPanel.getMultiPlayerButton().setIcon(multiIcon);
            UsefulFeatures.update(multiChoser, menuPanel);

        }
        if (e.getSource() == this.menuPanel.getLanModeButton()) {
            this.menuPanel.getLanModeButton().setIcon(lanIcon);
            UsefulFeatures.update(serverChoser, menuPanel);
        }
        if (e.getSource() == this.menuPanel.getExitButton()) {
            this.menuPanel.getExitButton().setIcon(this.exitEnteredIcon);
            System.exit(0);
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if (e.getSource() == this.menuPanel.getJoinButton()) {
            this.menuPanel.getJoinButton().setIcon(this.joinEnteredIcon);
        }
        if (e.getSource() == this.menuPanel.getMultiPlayerButton()) {
            this.menuPanel.getMultiPlayerButton().setIcon(this.multiEnteredIcon);
        }
        if (e.getSource() == this.menuPanel.getLanModeButton()) {
            this.menuPanel.getLanModeButton().setIcon(this.lanEnteredIcon);
        }
        if (e.getSource() == this.menuPanel.getExitButton()) {
            this.menuPanel.getExitButton().setIcon(this.exitEnteredIcon);
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource() == this.menuPanel.getJoinButton()) {
            this.menuPanel.getJoinButton().setIcon(joinIcon);
        }
        if (e.getSource() == this.menuPanel.getMultiPlayerButton()) {
            this.menuPanel.getMultiPlayerButton().setIcon(multiIcon);
        }
        if (e.getSource() == this.menuPanel.getLanModeButton()) {
            this.menuPanel.getLanModeButton().setIcon(lanIcon);
        }
        if (e.getSource() == this.menuPanel.getExitButton()) {
            this.menuPanel.getExitButton().setIcon(exitIcon);
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
