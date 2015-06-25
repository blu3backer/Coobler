package coobler.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * MainWindow class extends JFrame and show all contents of game
 * In this class is used singleton design pattern.
 * 
 * @author Dawid
 */
public class MainWindow extends JFrame {

    public static JPanel MAIN_PANEL;
    private Dimension screenSize;
    private static MainWindow instance = null;

    /**
     * Creates instance of MainWindow but only one.
     */
    private MainWindow() {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        setLayout(new GridLayout(1, 1));
        MainWindow.MAIN_PANEL = new JPanel();
        MainWindow.MAIN_PANEL.setLayout(new GridLayout(1, 1));
        MainWindow.MAIN_PANEL.setBackground(new Color(26,26,26));
        this.screenSize = toolkit.getScreenSize();
        this.setMinimumSize(new Dimension(800, 600));
        this.setSize(816, 639);
        this.setLocation((this.screenSize.width - 816) / 2, (this.screenSize.height - 639) / 2);
        add(MainWindow.MAIN_PANEL);

    }

    /**
     * 
     * @return Instance of MainWindow class.
     */
    public static MainWindow getInstance() {
        if (instance == null) {
            instance = new MainWindow();
        }

        return instance;
    }


}
