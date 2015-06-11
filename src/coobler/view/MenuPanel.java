package coobler.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.net.MalformedURLException;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * @author Dawid Frączek
 */
public class MenuPanel extends JPanel {

    private JLabel title;

    private JPanel menuPanel;

    private JLabel lan;
    private JLabel join;
    private JLabel multiPlayer;
    private JLabel exit;

    private JPanel lanPanel;
    private JPanel singlePlayerPanel;
    private JPanel multiPlayerPanel;
    private JPanel exitPanel;

    public MenuPanel() throws MalformedURLException {
        BorderLayout layout = new BorderLayout(0, 70);
        this.setLayout(layout);
        this.menuPanel = new JPanel();
        this.menuPanel.setLayout(new GridLayout(4, 1));
        this.menuPanel.setOpaque(false);

        this.title = new JLabel("COOBLER");
        this.title.setFont(new Font("Bauhaus 93", 1, 46));
        this.title.setForeground(Color.white);
        this.title.setHorizontalAlignment(JLabel.CENTER);

        URL lanURL = getClass().getResource("grph/lanButton.png");
        this.lan = new JLabel(new ImageIcon(lanURL));
        URL joinURL = getClass().getResource("grph/joinButton.png");
        this.join = new JLabel(new ImageIcon(joinURL));
        URL multiURL = getClass().getResource("grph/multiButton.png");
        this.multiPlayer = new JLabel(new ImageIcon(multiURL));
        URL exitURL = getClass().getResource("grph/exitButton.png");
        this.exit = new JLabel(new ImageIcon(exitURL));

        this.singlePlayerPanel = new JPanel();
        this.multiPlayerPanel = new JPanel();
        this.lanPanel = new JPanel();
        this.exitPanel = new JPanel();

        this.singlePlayerPanel.setOpaque(false);
        this.multiPlayerPanel.setOpaque(false);
        this.lanPanel.setOpaque(false);
        this.exitPanel.setOpaque(false);

        this.multiPlayerPanel.add(this.multiPlayer);
        this.lanPanel.add(this.lan);
        this.singlePlayerPanel.add(this.join);
        this.exitPanel.add(this.exit);

        this.menuPanel.add(this.multiPlayerPanel);
        this.menuPanel.add(this.lanPanel);
        this.menuPanel.add(this.singlePlayerPanel);
        this.menuPanel.add(this.exitPanel);

        add(title, BorderLayout.NORTH);
        add(menuPanel, BorderLayout.CENTER);
        setOpaque(false);

    }

    public JLabel getJoinButton() {
        return this.join;
    }

    public JLabel getMultiPlayerButton() {
        return this.multiPlayer;
    }

    public JLabel getLanModeButton() {
        return this.lan;
    }

    public JLabel getExitButton() {
        return this.exit;
    }
}
