package coobler;

import coobler.controler.NavigationHandling;
import coobler.view.MainWindow;
import coobler.view.MenuPanel;
import javax.swing.JFrame;

/**
 *
 * @author Dawid
 */
public class Coobler {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MainWindow window = new MainWindow();
        MenuPanel menuPanel = new MenuPanel();
        window.setPanel(menuPanel);
        NavigationHandling navigationHandling = new NavigationHandling(menuPanel, window);

        window.setVisible(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
