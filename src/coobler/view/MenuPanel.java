
package coobler.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * MenuPanel class creates menu view 
 * 
 * @author Dawid Frączek
 */
public class MenuPanel extends JPanel {

    private JLabel title;

    private JPanel menuPanel;

    
    private JLabel lan;
    private JLabel singlePlayer;
    private JLabel multiPlayer;
    private JLabel exit;

    
    private JPanel lanPanel;
    private JPanel singlePlayerPanel;
    private JPanel multiPlayerPanel;
    private JPanel exitPanel;
    
    
    public MenuPanel() {
        BorderLayout layout = new BorderLayout(0, 70);
        this.setLayout(layout);
        this.menuPanel = new JPanel();
        this.menuPanel.setLayout(new GridLayout(4, 1));
        this.menuPanel.setOpaque(false);

        this.title = new JLabel("COOBLER");
        this.title.setFont(new Font("Bauhaus 93", 1, 46));
        this.title.setForeground(Color.white);
        this.title.setHorizontalAlignment(JLabel.CENTER);
        
        
        this.lan = new JLabel(new ImageIcon("grph/lanButton.png"));
        this.singlePlayer = new JLabel(new ImageIcon("grph/singleButton.png"));
        this.multiPlayer = new JLabel(new ImageIcon("grph/multiButton.png"));
        this.exit = new JLabel(new ImageIcon("grph/exitButton.png"));

        this.singlePlayerPanel = new JPanel();
        this.multiPlayerPanel = new JPanel();
        this.lanPanel = new JPanel();
        this.exitPanel = new JPanel();
        
        this.singlePlayerPanel.setOpaque(false);
        this.multiPlayerPanel.setOpaque(false);
        this.lanPanel.setOpaque(false);
        this.exitPanel.setOpaque(false);
        
        this.singlePlayerPanel.add(this.singlePlayer);
        this.multiPlayerPanel.add(this.multiPlayer);
        this.lanPanel.add(this.lan);
        this.exitPanel.add(this.exit);
        
        this.menuPanel.add(this.singlePlayerPanel);
        this.menuPanel.add(this.multiPlayerPanel);
        this.menuPanel.add(this.lanPanel);
        this.menuPanel.add(this.exitPanel);

        add(title, BorderLayout.NORTH);
        add(menuPanel, BorderLayout.CENTER);
        setOpaque(false);

    }
    /**
     * 
     * @return JLabel representing button which riderects to SinglePlayer menu
     */
    public JLabel getSinglePlayerButton() {
        return this.singlePlayer;
    }
    /**
     * 
     * @return JLabel representing button which riderects to MultiPlayer menu
     */
    public JLabel getMultiPlayerButton() {
        return this.multiPlayer;
    }
    /**
     * 
     * @return JLabel representing button which riderects to LAN mode menu
     */
    public JLabel getLanModeButton() {
        return this.lan;
    }
    /**
     * 
     * @return JLabel representing exit button 
     */
    public JLabel getExitButton() {
        return this.exit;
    }
}
