package coobler.controler;

import coobler.model.ServerGame;
import coobler.model.StoreData;
import coobler.view.LanServerChooser;
import coobler.view.LoadingView;
import coobler.view.MainWindow;
import coobler.view.MenuPanel;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JColorChooser;

/**
 *
 * @author Dawid
 */
public class LanServerSetPreferences implements MouseListener {

    private LanServerChooser lanServerChoser;
    private LoadingView loadingView;
    private ServerGame serverGame;
    private StoreData sData;
    private MenuPanel menuPanel;

    private ImageIcon choseButtonImage;
    private ImageIcon startButtonImage;
    private ImageIcon choseButtonEnteredImage;
    private ImageIcon startButtonEnteredImage;
    private ImageIcon choseButtonPressedImage;
    private ImageIcon startButtonPressedImage;

    public LanServerSetPreferences(LanServerChooser aLanServerChoser, MenuPanel aMenuPanel) {
        this.menuPanel = aMenuPanel;
        this.lanServerChoser = aLanServerChoser;
        this.loadingView = new LoadingView();
        this.lanServerChoser.getColorChoserButton().addMouseListener(this);
        this.lanServerChoser.getStartButton().addMouseListener(this);
        sData = new StoreData(Color.WHITE, Color.BLACK,"UNNAMED","UNNAMED2");

        URL choseButtonURL = getClass().getResource("grph/choseButton.png");
        URL startButtonURL = getClass().getResource("grph/startServerButton.png");
        URL choseButtonEnteredURL = getClass().getResource("grph/enteredChoseButton.png");
        URL startButtonEnteredURL = getClass().getResource("grph/startServerButtonEntered.png");
        URL choseButtonPressedURL = getClass().getResource("grph/clickedChoseButton.png");
        URL startButtonPressedURL = getClass().getResource("grph/startServerButtonPressed.png");

        choseButtonImage = new ImageIcon(choseButtonURL);
        startButtonImage = new ImageIcon(startButtonURL);
        choseButtonPressedImage = new ImageIcon(choseButtonPressedURL);
        startButtonPressedImage = new ImageIcon(startButtonPressedURL);
        choseButtonEnteredImage = new ImageIcon(choseButtonEnteredURL);
        startButtonEnteredImage = new ImageIcon(startButtonEnteredURL);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getSource() == this.lanServerChoser.getColorChoserButton()) {
            this.lanServerChoser.getColorChoserButton().setIcon(choseButtonPressedImage);
        } else if (e.getSource() == this.lanServerChoser.getStartButton()) {
            this.lanServerChoser.getStartButton().setIcon(startButtonPressedImage);
        }
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
            if (!lanServerChoser.getFirstPlayerNameField().getText().equals("")) {
                sData.setFirstNick(lanServerChoser.getFirstPlayerNameField().getText());
            }
            sData.setSizeBoard(lanServerChoser.getSizeBoard().getSelectedIndex() + 4);
            serverGame = new ServerGame(loadingView, sData, menuPanel);
            serverGame.execute();

            lanServerChoser.setVisible(false);
            this.loadingView.setVisible(true);

            MainWindow.MAIN_PANEL.removeAll();
            MainWindow.MAIN_PANEL.add(this.loadingView);
            MainWindow.MAIN_PANEL.revalidate();
            MainWindow.MAIN_PANEL.repaint();

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

}
