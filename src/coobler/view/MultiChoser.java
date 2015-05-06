
package coobler.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
  * MultiChoser class creates new view which set color and name user
 * in multi player mode.
 * 
 * @author Dawid
 */
public class MultiChoser extends JPanel{

    private JComboBox board;
    private JLabel boardLabel;

    private JLabel okButton;
    private JLabel firstColorChoser;
    private JLabel secondColorChoser;

    private JTextField firstPlayerNameField;
    private JTextField secondPlayerNameField;

    private Color firstColor;
    private Color secondColor;
    
    private int sizeBoard;
    
    private String firstName;
    private String secondName;
    
    private int firstPkt;
    private int secondPkt;

    private JPanel mainPanel;
    private JPanel labelPanel;
    private JPanel chosePanel;
    private JPanel firstColorPanel;
    private JPanel secondColorPanel;

    private JLabel firstShowColorChoser;
    private JLabel firstNamePlayerLabel;
    private JLabel firstColorPlayerLabel;
    private JLabel secondShowColorChoser;
    private JLabel secondNamePlayerLabel;
    private JLabel secondColorPlayerLabel;
    
    
    
    public MultiChoser() {
        this.setLayout(new GridLayout(1, 1, 50, 50));
        
        this.firstColorPanel = new JPanel(new GridLayout(1, 2,20, 10));
        this.secondColorPanel = new JPanel(new GridLayout(1, 2,20, 10));
        
        this.mainPanel = new JPanel(new GridBagLayout());
        this.chosePanel = new JPanel(new GridLayout(5, 1,20, 30));
        this.labelPanel = new JPanel(new GridLayout(5, 1,20, 30));

        this.firstColor = Color.BLACK;
        this.secondColor = Color.RED;
        
        this.sizeBoard = 4;
        this.firstName = "Unnamed";
        this.secondName = "Unnamed";
        this.firstPkt = 0;
        this.secondPkt = 0;

        
        this.mainPanel.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        /*Labels*/
        this.firstNamePlayerLabel = new JLabel("FIRST PLAYER NAME");
        this.firstNamePlayerLabel.setForeground(Color.WHITE);        
        this.firstNamePlayerLabel.setFont(new Font("Arial", 1, 18));

        this.firstColorPlayerLabel = new JLabel("FIRST PLAYER COLOR");
        this.firstColorPlayerLabel.setForeground(Color.WHITE);        
        this.firstColorPlayerLabel.setFont(new Font("Arial", 1, 18));
        
        this.secondNamePlayerLabel = new JLabel("SECOND PLAYER NAME");
        this.secondNamePlayerLabel.setForeground(Color.WHITE);        
        this.secondNamePlayerLabel.setFont(new Font("Arial", 1, 18));

        this.secondColorPlayerLabel = new JLabel("SECOND PLAYER COLOR");
        this.secondColorPlayerLabel.setForeground(Color.WHITE);        
        this.secondColorPlayerLabel.setFont(new Font("Arial", 1, 18));

        this.boardLabel = new JLabel("BOARD");
        this.boardLabel.setForeground(Color.WHITE);
        this.boardLabel.setFont(new Font("Arial", 1, 26));
        
        this.firstShowColorChoser = new JLabel();
        this.firstShowColorChoser.setBorder(BorderFactory.createLineBorder(new Color(249, 224, 75)));
        this.firstShowColorChoser.setOpaque(true);
        this.firstShowColorChoser.setBackground(this.firstColor);
        
        this.secondShowColorChoser = new JLabel();
        this.secondShowColorChoser.setBorder(BorderFactory.createLineBorder(new Color(249, 224, 75)));
        this.secondShowColorChoser.setOpaque(true);
        this.secondShowColorChoser.setBackground(this.secondColor);

        /*User name field*/
        this.firstPlayerNameField = new JTextField();
        this.firstPlayerNameField.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        this.firstPlayerNameField.setFont(new Font("Arial", 1, 22));
        
        /*User name field*/
        this.secondPlayerNameField = new JTextField();
        this.secondPlayerNameField.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        this.secondPlayerNameField.setFont(new Font("Arial", 1, 22));

        /*ComboBox*/
        String[] boardsSize = {
            "4x4", "5x5", "6x6","7x7", "8x8"
        };
        this.board = new JComboBox(boardsSize);

        /*Buttons*/
        this.okButton = new JLabel(new ImageIcon("grph/okButton.png"));
        this.firstColorChoser = new JLabel(new ImageIcon("grph/choseButton.png"));
        this.secondColorChoser = new JLabel(new ImageIcon("grph/choseButton.png"));
        
        this.firstNamePlayerLabel.setPreferredSize(new Dimension(300, 50));
        this.firstColorPlayerLabel.setPreferredSize(new Dimension(300, 50));
        this.secondNamePlayerLabel.setPreferredSize(new Dimension(300, 50));
        this.secondColorPlayerLabel.setPreferredSize(new Dimension(300, 50));
        this.boardLabel.setPreferredSize(new Dimension(200, 50));
        
        this.firstNamePlayerLabel.setHorizontalAlignment(JLabel.RIGHT);
        this.firstColorPlayerLabel.setHorizontalAlignment(JLabel.RIGHT);
        this.secondNamePlayerLabel.setHorizontalAlignment(JLabel.RIGHT);
        this.secondColorPlayerLabel.setHorizontalAlignment(JLabel.RIGHT);
        this.boardLabel.setHorizontalAlignment(JLabel.RIGHT);
        this.firstPlayerNameField.setHorizontalAlignment(JTextField.CENTER);
        this.secondPlayerNameField.setHorizontalAlignment(JTextField.CENTER);
        

        this.firstColorPanel.add(this.firstColorChoser);
        this.firstColorPanel.add(this.firstShowColorChoser);
        
        this.secondColorPanel.add(this.secondColorChoser);
        this.secondColorPanel.add(this.secondShowColorChoser);
        
        GridBagConstraints constraint = new GridBagConstraints();     
        constraint.weightx = 1.0;
        constraint.weighty = 1.0;
        constraint.gridy = 1;
        
        this.labelPanel.add(this.firstNamePlayerLabel);
        this.labelPanel.add(this.firstColorPlayerLabel);
        this.labelPanel.add(this.secondNamePlayerLabel);
        this.labelPanel.add(this.secondColorPlayerLabel);
        this.labelPanel.add(this.boardLabel);
        
        this.mainPanel.add(this.labelPanel, constraint);
        
        this.chosePanel.add(this.firstPlayerNameField);
        this.chosePanel.add(this.firstColorPanel);
        this.chosePanel.add(this.secondPlayerNameField);
        this.chosePanel.add(this.secondColorPanel);
        this.chosePanel.add(this.board);
        
        constraint.gridy = 1;
        constraint.gridx = 2;
        
        this.mainPanel.add(this.chosePanel, constraint);
        constraint.gridy = 2;
        constraint.gridx = 0;
        
        constraint.gridwidth = GridBagConstraints.REMAINDER;
        this.mainPanel.add(this.okButton, constraint);
        
        add(this.mainPanel, constraint);
        
        this.mainPanel.setOpaque(false);
        this.firstColorPanel.setOpaque(false);
        this.secondColorPanel.setOpaque(false);
        this.chosePanel.setOpaque(false);
        this.labelPanel.setOpaque(false);
        this.setOpaque(false);
        
    }
    public String getFirstName(){
        return this.firstName;
    }
    public String getSecondName(){
        return this.secondName;
    }
    public void setFirstName(String aFirstName){
        this.firstName = aFirstName;
    }
    public void setSecondName(String aSecondName){
        this.secondName = aSecondName;
    }
    public JTextField getFirstPlayerNameField(){
        return this.firstPlayerNameField;
    }
    public JTextField getSecondPlayerNameField(){
        return this.secondPlayerNameField;
    }
    public JComboBox getBoardSize(){
        return this.board;
    }
   /**
     *
     * @return representing button which calls ColorPicker windows for the first player
     */
    public JLabel getFirstColorChoserButton() {
        return this.firstColorChoser;
    }
    /**
     *
     * @return representing button which calls ColorPicker windows for the second player
     */
    public JLabel getSecondColorChoserButton() {
        return this.secondColorChoser;
    }

    /**
     *
     * @return representing button which approves all changes
     */
    public JLabel getOkButton() {
        return this.okButton;
    }

    /**
     *
     * @return showing current selected color of the first player
     */
    public JLabel getShowFirstColorChoserButton() {
        return this.firstShowColorChoser;
    }
    /**
     *
     * @return showing current selected color of the second player
     */
    public JLabel getShowSecondColorChoserButton() {
        return this.secondShowColorChoser;
    }

    /**
     *
     * @return Color which is chosen for the first player
     */
    public Color getFirstColor() {
        return this.firstColor;
    }
    /**
     *
     * @return Color which is chosen for the second player
     */
    public Color getSecondColor() {
        return this.secondColor;
    }

    /**
     *
     * @param aColor sets first player color
     */
    public void setFirstColor(Color aColor) {
        this.firstColor = aColor;
    }
    /**
     *
     * @param aColor sets second player color
     */
    public void setSecondColor(Color aColor) {
        this.secondColor = aColor;
    }
    
    public int getSizeBoard(){
        return this.sizeBoard;
    }
    public void setSizeBoard(int aSizeBoard){
        this.sizeBoard = aSizeBoard;
    }
}
