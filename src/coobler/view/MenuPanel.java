package coobler.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * 
 * 
 * @author Dawid
 */
public class MenuPanel extends JPanel {

    private JLabel title;

    private JPanel menuPanel;

    private JLabel lan;
    private JLabel join;
    private JLabel multiPlayer;
    private JLabel exit;

    
    private JPanel lanPanel;
    private JPanel joinPanel;
    private JPanel multiPlayerPanel;
    private JPanel exitPanel;

    /**
     * 
     */
    public MenuPanel() {
        BorderLayout layout = new BorderLayout(0, 70);
        this.setLayout(layout);
        this.menuPanel = new JPanel();
        this.menuPanel.setLayout(new GridLayout(4, 1));
        this.menuPanel.setOpaque(false);

        this.title = new JLabel(this.changeImage("grph/title.png"));
        this.title.setHorizontalAlignment(JLabel.CENTER);

        
        
        this.lan = new JLabel(this.changeImage("grph/lanButton.png"));
        this.join = new JLabel(this.changeImage("grph/joinButton.png"));
        this.multiPlayer = new JLabel(this.changeImage("grph/multiButton.png"));
        this.exit = new JLabel(this.changeImage("grph/exitButton.png"));

       
        this.multiPlayerPanel = new JPanel();
        this.lanPanel = new JPanel();
        this.joinPanel = new JPanel();
        this.exitPanel = new JPanel();

        this.multiPlayerPanel.setOpaque(false);
        this.lanPanel.setOpaque(false);
        this.exitPanel.setOpaque(false);
        this.joinPanel.setOpaque(false);

        this.multiPlayerPanel.add(this.multiPlayer);
        this.lanPanel.add(this.lan);
        this.joinPanel.add(this.join);
        this.exitPanel.add(this.exit);

        this.menuPanel.add(this.multiPlayerPanel);
        this.menuPanel.add(this.lanPanel);
        this.menuPanel.add(this.joinPanel);
        this.menuPanel.add(this.exitPanel);

        add(title, BorderLayout.NORTH);
        add(menuPanel, BorderLayout.CENTER);
        setOpaque(false);

    }

    /**
     * 
     * @return button which allows to display LanClientChoser panel
     */
    public JLabel getJoinButton() {
        return this.join;
    }

    /**
     * 
     * @return button which allows to display MultiplayerChooser panel
     */
    public JLabel getMultiPlayerButton() {
        return this.multiPlayer;
    }

    /**
     * 
     * @return button which allows to display LanServerChoser panel
     */
    public JLabel getLanModeButton() {
        return this.lan;
    }

    /**
     * 
     * @return button which allows to exit the game
     */
    public JLabel getExitButton() {
        return this.exit;
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
