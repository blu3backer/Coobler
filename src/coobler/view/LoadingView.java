package coobler.view;

import java.awt.Color;
import java.awt.GridLayout;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Display gif image which is showed when the first player wait for second 
 * player in LAN game
 *
 * @author Dawid
 */
public class LoadingView extends JPanel {

    private JLabel loadingLabel;

    /**
     * Creates new instance of LoadingView
     */
    public LoadingView() {
        this.setLayout(new GridLayout(1, 1));
        URL loadingURL = getClass().getResource("grph/loader.gif");
        this.loadingLabel = new JLabel(new ImageIcon(loadingURL));
        this.loadingLabel.setOpaque(true);
        this.loadingLabel.setBackground(Color.BLACK);
        this.setOpaque(false);
        this.add(this.loadingLabel);

    }
}
