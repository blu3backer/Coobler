package coobler;

import coobler.controler.NavigationHandling;
import coobler.view.MainWindow;
import coobler.view.MenuPanel;
import java.net.MalformedURLException;
import javax.swing.JFrame;

/**
 *
 * @author Dawid
 */
public class Coobler {

    public static void main(String[] args) throws MalformedURLException {
        MainWindow.getInstance();
        MenuPanel menuPanel = new MenuPanel();
        MainWindow.MAIN_PANEL.add(menuPanel);
        NavigationHandling navigationHandling = new NavigationHandling(menuPanel);

        MainWindow.getInstance().setVisible(true);
        MainWindow.getInstance().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

}
