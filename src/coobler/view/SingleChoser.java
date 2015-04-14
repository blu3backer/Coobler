package coobler.view;

import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

/**
 * SingleChoser class creates new view which set color and name user
 * in single player mode.
 * 
 * @author Dawid
 */
public class SingleChoser extends JPanel{

    private JComboBox board;
    
    private JLabel okButton;
    private JLabel colorChoser;
    
    private JTextField playerNameField;
    
    private Color color;
    
    private JPanel playerPanel;
    
    private JLabel showColorChoser;
    private JLabel namePlayerLabel;
    private JLabel colorPlayerLabel;
    private JLabel boardLabel;
    
    /**
     * creates a new instance SingleChoser class 
     */
    public SingleChoser() {
        this.setLayout(null);
        color = Color.white;
        this.playerPanel = new JPanel(null);     
        
        this.namePlayerLabel = new JLabel("NAME");
        this.namePlayerLabel.setForeground(Color.WHITE);
        
        this.colorPlayerLabel = new JLabel("COLOR");
        this.colorPlayerLabel.setForeground(Color.WHITE);         
        
        this.colorChoser = new JLabel(new ImageIcon("grph/choseButton.png"));
        
        this.showColorChoser = new JLabel();
        this.showColorChoser.setBorder(BorderFactory.createLineBorder(new Color(249, 224, 75)));
        
        this.showColorChoser.setOpaque(true);
        this.showColorChoser.setBackground(this.color);
        
        this.playerNameField = new JTextField();
        this.playerNameField.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        this.playerNameField.setFont(new Font("Arial", 1, 22));   
        
        
        String[] boardsSize = {
          "4x4","5x5","6x6"  
        };
        this.board = new JComboBox(boardsSize);
        this.okButton = new JLabel(new ImageIcon("grph/okButton.png"));
        this.boardLabel = new JLabel("PLANSZA");
        
        this.boardLabel.setBounds(200, 400, 150, 50);
        this.boardLabel.setForeground(Color.WHITE);
        this.boardLabel.setFont(new Font("Arial", 1, 20));
        
        this.board.setBounds(400, 400, 150, 50);
        this.okButton.setBounds(300, 500, 200, 50);
        
        this.namePlayerLabel.setBounds(25, 50, 250, 50);
        
        this.playerNameField.setBounds(25, 100, 250, 50);
        
        this.colorPlayerLabel.setBounds(325, 50, 250, 50);
        
        this.colorChoser.setBounds(325, 100, 115, 50);
        
        this.showColorChoser.setBounds(460, 100, 115, 50);
        
        this.playerPanel.add(this.namePlayerLabel);
        this.playerPanel.add(this.playerNameField);
        this.playerPanel.add(this.colorPlayerLabel);
        this.playerPanel.add(this.colorChoser);
        this.playerPanel.add(this.showColorChoser);
        
        this.playerPanel.setBounds(100, 100, 600, 250);
        
        Border whiteline = BorderFactory.createLineBorder(Color.white);
        this.playerPanel.setBorder(BorderFactory.createTitledBorder(whiteline, "FIRST PLAYER", TitledBorder.LEFT, TitledBorder.TOP, new Font("Arial", 1, 20), Color.WHITE));
        this.playerPanel.setOpaque(false);
        
        add(this.playerPanel);
        add(this.boardLabel);
        add(this.board);
        add(this.okButton);
        
        this.setOpaque(false);
        
    }
    /**
     * 
     * @return JLabel which shows color picker dialog window
     */
     public JLabel getFirstColorChoserButton(){
        return this.colorChoser;
    }
     /**
      * 
      * @return JLabel which approve changes
      */
    public JLabel getOkButton(){
        return this.okButton;
    }
    /**
     * 
     * @return JLabel which shows color picker dialog window
     */
    public JLabel getShowFirstColorChoserButton(){
        return this.showColorChoser;
    }
    /**
     * 
     * @return Color which is selected
     */
    public Color getFirstColor(){
        return this.color;
    }
    /**
     * 
     * @param aColor set selected color
     */
    public void setFirstColor(Color aColor){
        this.color = aColor;
    }
}