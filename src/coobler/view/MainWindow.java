
package coobler.view;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * MainWindow class creates new window aplication
 *
 * @author Dawid Frączek
 */
public class MainWindow extends JFrame{
    private JPanel mainPanel;
    private Dimension screenSize;
   
    public MainWindow(){
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        setLayout(new GridLayout(1, 1));
        this.mainPanel = new JPanel();
        this.mainPanel.setLayout(new GridLayout(1, 1));
        this.mainPanel.setBackground(new Color(0,49,83));
        this.screenSize = toolkit.getScreenSize();
        this.setSize(816, 639);
        this.setLocation((this.screenSize.width-816)/2, (this.screenSize.height-639)/2);
        add(this.mainPanel);
       
    }
    /**
     * 
     * @param panel add new panel to window
     */
    public void setPanel(JPanel panel)
    {
        this.mainPanel.add(panel);
        this.mainPanel.repaint();
        
    }
    /**
     * 
     * @return main panel window
     */
    public JPanel getPanel()
    {
        return this.mainPanel;
        
    }
    
}
