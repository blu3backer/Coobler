
package coobler.model;

import coobler.view.MainWindow;
import javax.swing.JPanel;

/**
 * Class which contain some useful methods
 *
 * @author Dawid
 */
public class UsefulFeatures {
    
    
     /**
      * 
      * @param panel which becomes visible in the window
      */
     public static void update(JPanel panel) {

        MainWindow.MAIN_PANEL.removeAll();
        MainWindow.MAIN_PANEL.add(panel);
        MainWindow.MAIN_PANEL.repaint();
        MainWindow.MAIN_PANEL.revalidate();

    }
     
     /**
      * Update window aplication
      * 
      * @param visiblePanel this panel becomes visible in the window
      * @param invisiblePanel this panel becomes invisible in the window
      */
     public static void update(JPanel visiblePanel, JPanel invisiblePanel) {

        visiblePanel.setVisible(true);
        invisiblePanel.setVisible(false);

        MainWindow.MAIN_PANEL.removeAll();
        MainWindow.MAIN_PANEL.add(visiblePanel);
        MainWindow.MAIN_PANEL.repaint();
        MainWindow.MAIN_PANEL.revalidate();

    }
}
