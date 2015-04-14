/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coobler.controler;

import coobler.view.MainWindow;
import coobler.view.MenuPanel;
import coobler.view.MultiChoser;
import coobler.view.SingleChoser;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;

/**
 *
 * @author Dawid
 */
public class NavigationHandling implements MouseListener {

    private MenuPanel menuPanel;
    private ImageIcon singleIcon;
    private ImageIcon multiIcon;
    private ImageIcon lanIcon;
    private ImageIcon exitIcon;
    private MainWindow mainWindow;

    private MultiChoser multiChoser;
    private SingleChoser singleChoser;

    private MultiplayerSetPreferences multiplyPreferences;
    private SinglePlayerSetPreferences singlePreferences;

    public NavigationHandling(MenuPanel aMenuPanel, MainWindow aWindow) {

        this.mainWindow = aWindow;
        this.menuPanel = aMenuPanel;
        this.menuPanel.getSinglePlayerButton().addMouseListener(this);
        this.menuPanel.getMultiPlayerButton().addMouseListener(this);
        this.menuPanel.getLanModeButton().addMouseListener(this);
        this.menuPanel.getExitButton().addMouseListener(this);
        this.multiChoser = new MultiChoser();
        this.singleChoser = new SingleChoser();
        this.multiplyPreferences = new MultiplayerSetPreferences(multiChoser);
        this.singlePreferences = new SinglePlayerSetPreferences(singleChoser);
        this.lanIcon = new ImageIcon("grph/enteredLanButton.png");
        this.singleIcon = new ImageIcon("grph/enteredSingleButton.png");
        this.multiIcon = new ImageIcon("grph/enteredMultiButton.png");
        this.exitIcon = new ImageIcon("grph/enteredExitButton.png");
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        ;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getSource() == this.menuPanel.getSinglePlayerButton()) {
            this.menuPanel.getSinglePlayerButton().setIcon(new ImageIcon("grph/clickedSingleButton.png"));
            menuPanel.setVisible(false);
            singleChoser.setVisible(true);
            this.mainWindow.getPanel().removeAll();
            this.mainWindow.setPanel(singleChoser);
            this.mainWindow.repaint();
        }
        if (e.getSource() == this.menuPanel.getMultiPlayerButton()) {
            this.menuPanel.getMultiPlayerButton().setIcon(new ImageIcon("grph/clickedMultiButton.png"));
            menuPanel.setVisible(false);
            multiChoser.setVisible(true);
            this.mainWindow.getPanel().removeAll();
            this.mainWindow.setPanel(multiChoser);
            this.mainWindow.repaint();

        }
        if (e.getSource() == this.menuPanel.getLanModeButton()) {
            this.menuPanel.getLanModeButton().setIcon(new ImageIcon("grph/clickedLanButton.png"));
        }
        if (e.getSource() == this.menuPanel.getExitButton()) {
            this.menuPanel.getExitButton().setIcon(new ImageIcon("grph/clickedExitButton.png"));
        }

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (e.getSource() == this.menuPanel.getSinglePlayerButton()) {
            this.menuPanel.getSinglePlayerButton().setIcon(this.singleIcon);
        }
        if (e.getSource() == this.menuPanel.getMultiPlayerButton()) {
            this.menuPanel.getMultiPlayerButton().setIcon(this.multiIcon);

        }
        if (e.getSource() == this.menuPanel.getLanModeButton()) {
            this.menuPanel.getLanModeButton().setIcon(this.lanIcon);
        }
        if (e.getSource() == this.menuPanel.getExitButton()) {
            this.menuPanel.getExitButton().setIcon(this.exitIcon);
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if (e.getSource() == this.menuPanel.getSinglePlayerButton()) {
            this.menuPanel.getSinglePlayerButton().setIcon(this.singleIcon);
        }
        if (e.getSource() == this.menuPanel.getMultiPlayerButton()) {
            this.menuPanel.getMultiPlayerButton().setIcon(this.multiIcon);
        }
        if (e.getSource() == this.menuPanel.getLanModeButton()) {
            this.menuPanel.getLanModeButton().setIcon(this.lanIcon);
        }
        if (e.getSource() == this.menuPanel.getExitButton()) {
            this.menuPanel.getExitButton().setIcon(this.exitIcon);
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource() == this.menuPanel.getSinglePlayerButton()) {
            this.menuPanel.getSinglePlayerButton().setIcon(new ImageIcon("grph/singleButton.png"));
        }
        if (e.getSource() == this.menuPanel.getMultiPlayerButton()) {
            this.menuPanel.getMultiPlayerButton().setIcon(new ImageIcon("grph/multiButton.png"));
        }
        if (e.getSource() == this.menuPanel.getLanModeButton()) {
            this.menuPanel.getLanModeButton().setIcon(new ImageIcon("grph/lanButton.png"));
        }
        if (e.getSource() == this.menuPanel.getExitButton()) {
            this.menuPanel.getExitButton().setIcon(new ImageIcon("grph/exitButton.png"));
        }
    }

}
