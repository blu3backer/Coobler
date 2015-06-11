package coobler.controler;

import coobler.view.LanClientChooser;
import coobler.view.LanServerChooser;
import coobler.view.MainWindow;
import coobler.view.MenuPanel;
import coobler.view.MultiplayerChoser;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;
import javax.swing.ImageIcon;

/**
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

    private ImageIcon joinPressedIcon;
    private ImageIcon multiPressedIcon;
    private ImageIcon lanPressedIcon;
    private ImageIcon exitPressedIcon;

    private MultiplayerChoser multiChoser;

    private MultiplayerSetPreferences multiplyPreferences;

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
        URL lanEnteredURL = getClass().getResource("grph/enteredLanButton.png");
        this.lanEnteredIcon = new ImageIcon(lanEnteredURL);
        URL joinEnteredURL = getClass().getResource("grph/enteredJoinButton.png");
        this.joinEnteredIcon = new ImageIcon(joinEnteredURL);
        URL multiEnteredURL = getClass().getResource("grph/enteredMultiButton.png");
        this.multiEnteredIcon = new ImageIcon(multiEnteredURL);
        URL exitEnteredURL = getClass().getResource("grph/enteredExitButton.png");
        this.exitEnteredIcon = new ImageIcon(exitEnteredURL);

        URL lanPressedURL = getClass().getResource("grph/clickedLanButton.png");
        this.lanPressedIcon = new ImageIcon(lanPressedURL);
        URL joinPressedURL = getClass().getResource("grph/clickedJoinButton.png");
        this.joinPressedIcon = new ImageIcon(joinPressedURL);
        URL multiPressedURL = getClass().getResource("grph/clickedMultiButton.png");
        this.multiPressedIcon = new ImageIcon(multiPressedURL);
        URL exitPressedURL = getClass().getResource("grph/clickedExitButton.png");
        this.exitPressedIcon = new ImageIcon(exitPressedURL);

        URL lanURL = getClass().getResource("grph/lanButton.png");
        this.lanIcon = new ImageIcon(lanURL);
        URL joinURL = getClass().getResource("grph/joinButton.png");
        this.joinIcon = new ImageIcon(joinURL);
        URL multiURL = getClass().getResource("grph/multiButton.png");
        this.multiIcon = new ImageIcon(multiURL);
        URL exitURL = getClass().getResource("grph/exitButton.png");
        this.exitIcon = new ImageIcon(exitURL);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        ;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getSource() == this.menuPanel.getJoinButton()) {
            this.menuPanel.getJoinButton().setIcon(joinPressedIcon);
        }
        if (e.getSource() == this.menuPanel.getMultiPlayerButton()) {
            this.menuPanel.getMultiPlayerButton().setIcon(multiPressedIcon);

        }
        if (e.getSource() == this.menuPanel.getLanModeButton()) {
            this.menuPanel.getLanModeButton().setIcon(lanPressedIcon);
        }
        if (e.getSource() == this.menuPanel.getExitButton()) {
            this.menuPanel.getExitButton().setIcon(exitPressedIcon);
        }

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (e.getSource() == this.menuPanel.getJoinButton()) {
            this.menuPanel.getJoinButton().setIcon(joinIcon);

            menuPanel.setVisible(false);
            clientChoser.setVisible(true);
            MainWindow.MAIN_PANEL.removeAll();
            MainWindow.MAIN_PANEL.add(clientChoser);
            MainWindow.MAIN_PANEL.repaint();
        }
        if (e.getSource() == this.menuPanel.getMultiPlayerButton()) {
            this.menuPanel.getMultiPlayerButton().setIcon(multiIcon);
            menuPanel.setVisible(false);
            multiChoser.setVisible(true);
            MainWindow.MAIN_PANEL.removeAll();
            MainWindow.MAIN_PANEL.add(multiChoser);
            MainWindow.MAIN_PANEL.repaint();

        }
        if (e.getSource() == this.menuPanel.getLanModeButton()) {
            this.menuPanel.getLanModeButton().setIcon(lanIcon);

            menuPanel.setVisible(false);
            serverChoser.setVisible(true);
            MainWindow.MAIN_PANEL.removeAll();
            MainWindow.MAIN_PANEL.add(serverChoser);
            MainWindow.MAIN_PANEL.repaint();
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

}
