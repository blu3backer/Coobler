package coobler;

import coobler.controler.NavigationHandling;
import coobler.view.MainWindow;
import coobler.view.MenuPanel;
import java.net.MalformedURLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 * Main class
 *
 * @author Dawid
 */
public class Coobler {

    /**
     * 
     * @param args the command line arguments
     * 
     */
    public static void main(String[] args) {
        MainWindow.getInstance();
        MenuPanel menuPanel;
        try {
            menuPanel = new MenuPanel();
            MainWindow.MAIN_PANEL.add(menuPanel);
            NavigationHandling navigationHandling = new NavigationHandling(menuPanel);
        } catch (MalformedURLException ex) {
            Logger.getLogger(Coobler.class.getName()).log(Level.SEVERE, null, ex);
        }        
        
        MainWindow.getInstance().setVisible(true);
        MainWindow.getInstance().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

}
