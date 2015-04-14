
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
  *MultiChoser class creates new view which set color and name user
 * in multi player mode.
 * 
 * @author Dawid
 */
public class MultiChoser extends JPanel{

    private JComboBox board;
    
    private JLabel okButton;
    private JLabel firstColorChoser;
    private JLabel secondColorChoser;
    
    private JTextField firstPlayerNameField;
    private JTextField secondPlayerNameField;
    
    private Color firstColor;
    private Color secondColor;
    
    private JPanel firstPlayerPanel;
    private JPanel secondPlayerPanel;
    
    private JLabel showFirstColorChoser;
    private JLabel showSecondColorChoser;
    private JLabel nameFirstPlayerLabel;
    private JLabel nameSecondPlayerLabel;
    private JLabel colorFirstPlayerLabel;
    private JLabel colorSecondPlayerLabel;
    private JLabel boardLabel;
    /**
     * Creates a new instance of MultiChoser class
     */
    public MultiChoser() {
        this.setLayout(null);
        firstColor = Color.white;
        secondColor = Color.red;
        this.firstPlayerPanel = new JPanel(null);        
        this.secondPlayerPanel = new JPanel(null);
        
        this.nameFirstPlayerLabel = new JLabel("NAME");
        this.nameFirstPlayerLabel.setForeground(Color.WHITE);
        this.nameSecondPlayerLabel = new JLabel("NAME");
        this.nameSecondPlayerLabel.setForeground(Color.WHITE);
        
        this.colorFirstPlayerLabel = new JLabel("COLOR");
        this.colorFirstPlayerLabel.setForeground(Color.WHITE);
        this.colorSecondPlayerLabel = new JLabel("COLOR");          
        this.colorSecondPlayerLabel.setForeground(Color.WHITE);          
        
        this.firstColorChoser = new JLabel(new ImageIcon("grph/choseButton.png"));
        this.secondColorChoser = new JLabel(new ImageIcon("grph/choseButton.png"));
        
        this.showFirstColorChoser = new JLabel();
        this.showFirstColorChoser.setBorder(BorderFactory.createLineBorder(new Color(249, 224, 75)));
        this.showSecondColorChoser = new JLabel();
        this.showSecondColorChoser.setBorder(BorderFactory.createLineBorder(new Color(249, 224, 75)));
        
        this.showFirstColorChoser.setOpaque(true);
        this.showSecondColorChoser.setOpaque(true);
        this.showFirstColorChoser.setBackground(this.firstColor);
        this.showSecondColorChoser.setBackground(this.secondColor);
        
        this.firstPlayerNameField = new JTextField();
        this.firstPlayerNameField.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        this.firstPlayerNameField.setFont(new Font("Arial", 1, 22));        
        this.secondPlayerNameField = new JTextField();
        this.secondPlayerNameField.setBorder(BorderFactory.createLineBorder(Color.BLACK));        
        this.secondPlayerNameField.setFont(new Font("Arial", 1, 22));
        
        
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
        
        this.nameFirstPlayerLabel.setBounds(25, 25, 250, 50);
        this.nameSecondPlayerLabel.setBounds(25, 25, 250, 50);
        
        this.firstPlayerNameField.setBounds(25, 75, 250, 50);
        this.secondPlayerNameField.setBounds(25, 75, 250, 50);
        
        this.colorFirstPlayerLabel.setBounds(325, 25, 250, 50);
        this.colorSecondPlayerLabel.setBounds(325, 25, 250, 50);
        
        this.firstColorChoser.setBounds(325, 75, 115, 50);
        this.secondColorChoser.setBounds(325, 75, 115, 50);
        
        this.showFirstColorChoser.setBounds(460, 75, 115, 50);
        this.showSecondColorChoser.setBounds(460, 75, 115, 50);
        
        this.firstPlayerPanel.add(this.nameFirstPlayerLabel);
        this.firstPlayerPanel.add(this.firstPlayerNameField);
        this.firstPlayerPanel.add(this.colorFirstPlayerLabel);
        this.firstPlayerPanel.add(this.firstColorChoser);
        this.firstPlayerPanel.add(this.showFirstColorChoser);
        
        this.secondPlayerPanel.add(this.nameSecondPlayerLabel);
        this.secondPlayerPanel.add(this.secondPlayerNameField);
        this.secondPlayerPanel.add(this.colorSecondPlayerLabel);
        this.secondPlayerPanel.add(this.secondColorChoser);
        this.secondPlayerPanel.add(this.showSecondColorChoser);
        
        this.firstPlayerPanel.setBounds(100, 25, 600, 150);
        this.secondPlayerPanel.setBounds(100, 225, 600, 150);
        
        Border whiteline = BorderFactory.createLineBorder(Color.white);
        this.firstPlayerPanel.setBorder(BorderFactory.createTitledBorder(whiteline, "FIRST PLAYER", TitledBorder.LEFT, TitledBorder.TOP, new Font("Arial", 1, 20), Color.WHITE));
        this.secondPlayerPanel.setBorder(BorderFactory.createTitledBorder(whiteline, "SECOND PLAYER", TitledBorder.LEFT, TitledBorder.TOP, new Font("Arial", 1, 20), Color.WHITE));
        this.firstPlayerPanel.setOpaque(false);
        this.secondPlayerPanel.setOpaque(false);
        add(this.firstPlayerPanel);
        add(this.secondPlayerPanel);
        add(this.boardLabel);
        add(this.board);
        add(this.okButton);
        this.setOpaque(false);
        
    }
    /**
     * 
     * @return JLabel which shows color picker dialog window for a first player
     */
     public JLabel getFirstColorChoserButton(){
        return this.firstColorChoser;
    }
     /**
     * 
     * @return JLabel which shows color picker dialog window for a second player
     */
    public JLabel getSecondColorChoserButton(){
        return this.secondColorChoser;
    }
    /**
     * 
     * @return JLabel which approve all changes
     */
    public JLabel getOkButton(){
        return this.okButton;
    }
    
    /**
     * 
     * @return JLabel which shows selected color for the first player
     */
    public JLabel getShowFirstColorChoserButton(){
        return this.showFirstColorChoser;
    }
    /**
     * 
     * @return JLabel which shows selected color for the second player
     */
    public JLabel getShowSecondColorChoserButton(){
        return this.showSecondColorChoser;
    }
    /**
     * 
     * @return Color which is selected for the second player
     */
    public Color getSecondColor(){
        return this.secondColor;
    }
    /**
     * 
     * @return Color which is selected for the first player
     */
    public Color getFirstColor(){
        return this.firstColor;
    }
    /**
     * 
     * @param color set selected color for the second player
     */
    public void setSecondColor(Color color){
        this.secondColor = color;
    }
    /**
     * 
     * @param color set selected color for the first player
     */
    public void setFirstColor(Color color){
        this.firstColor = color;
    }
}
