package coobler.view;

import java.awt.GridLayout;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Dawid
 */
public class LoadingView extends JPanel {

    private JLabel loadingLabel;

    public LoadingView() {
        this.setLayout(new GridLayout(1, 1));
        URL loadingURL = getClass().getResource("grph/loader.gif");
        this.loadingLabel = new JLabel(new ImageIcon(loadingURL));
        this.loadingLabel.setOpaque(false);
        this.setOpaque(false);
        this.add(this.loadingLabel);

    }
}
