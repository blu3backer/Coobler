package coobler.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author Dawid Frączek
 */
public class MainWindow extends JFrame {

    public static JPanel MAIN_PANEL;
    private Dimension screenSize;
    private static MainWindow instance = null;

    private MainWindow() {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        setLayout(new GridLayout(1, 1));
        MainWindow.MAIN_PANEL = new JPanel();
        MainWindow.MAIN_PANEL.setLayout(new GridLayout(1, 1));
        MainWindow.MAIN_PANEL.setBackground(new Color(0, 49, 83));
        this.screenSize = toolkit.getScreenSize();
        this.setMinimumSize(new Dimension(800, 600));
        this.setSize(816, 639);
        this.setLocation((this.screenSize.width - 816) / 2, (this.screenSize.height - 639) / 2);
        add(MainWindow.MAIN_PANEL);

    }

    public static MainWindow getInstance() {
        if (instance == null) {
            instance = new MainWindow();
        }

        return instance;
    }

    public void closeStreams() {

    }

}
