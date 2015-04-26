package coobler.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * SingleChoser class creates new view which set color and name user in single
 * player mode.
 *
 * @author Dawid
 */
public class SingleChoser extends JPanel {

    private JComboBox board;

    private JLabel okButton;
    private JLabel colorChoser;

    private JTextField playerNameField;

    private Color color;

    private JPanel mainPanel;
    private JPanel labelPanel;
    private JPanel chosePanel;
    private JPanel colorPanel;

    private JLabel showColorChoser;
    private JLabel namePlayerLabel;
    private JLabel colorPlayerLabel;
    private JLabel boardLabel;

    /**
     * creates a new instance SingleChoser class
     */
    public SingleChoser() {
        
        this.setLayout(new GridLayout(1, 1, 50, 50));
        
        this.colorPanel = new JPanel(new GridLayout(1, 2,20, 10));
        
        this.mainPanel = new JPanel(new GridBagLayout());
        this.chosePanel = new JPanel(new GridLayout(3, 1,20, 100));
        this.labelPanel = new JPanel(new GridLayout(3, 1,20, 100));

        color = Color.white;

        /*Panels*/
        this.mainPanel.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        /*Labels*/
        this.namePlayerLabel = new JLabel("NAME");
        this.namePlayerLabel.setForeground(Color.WHITE);        
        this.namePlayerLabel.setFont(new Font("Arial", 1, 30));

        this.colorPlayerLabel = new JLabel("COLOR");
        this.colorPlayerLabel.setForeground(Color.WHITE);        
        this.colorPlayerLabel.setFont(new Font("Arial", 1, 30));

        this.boardLabel = new JLabel("BOARD");
        this.boardLabel.setForeground(Color.WHITE);
        this.boardLabel.setFont(new Font("Arial", 1, 30));
        
        this.showColorChoser = new JLabel();
        this.showColorChoser.setBorder(BorderFactory.createLineBorder(new Color(249, 224, 75)));
        this.showColorChoser.setOpaque(true);
        this.showColorChoser.setBackground(this.color);

        /*User name field*/
        this.playerNameField = new JTextField();
        this.playerNameField.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        this.playerNameField.setFont(new Font("Arial", 1, 22));

        /*ComboBox*/
        String[] boardsSize = {
            "4x4", "5x5", "6x6", "8x8"
        };
        this.board = new JComboBox(boardsSize);

        /*Buttons*/
        this.okButton = new JLabel(new ImageIcon("grph/okButton.png"));
        this.colorChoser = new JLabel(new ImageIcon("grph/choseButton.png"));
        
        this.namePlayerLabel.setPreferredSize(new Dimension(200, 50));
        this.colorPlayerLabel.setPreferredSize(new Dimension(200, 50));
        this.boardLabel.setPreferredSize(new Dimension(200, 50));
        
        this.namePlayerLabel.setHorizontalAlignment(JLabel.RIGHT);
        this.colorPlayerLabel.setHorizontalAlignment(JLabel.RIGHT);
        this.boardLabel.setHorizontalAlignment(JLabel.RIGHT);
        
        this.playerNameField.setHorizontalAlignment(JLabel.LEFT);
        
        this.playerNameField.setHorizontalAlignment(JTextField.CENTER);
        

        this.colorPanel.add(this.colorChoser);
        this.colorPanel.add(this.showColorChoser);
        
        GridBagConstraints constraint = new GridBagConstraints();     
        constraint.weightx = 1.0;
        constraint.weighty = 1.0;
        constraint.gridy = 1;
        
        this.labelPanel.add(this.namePlayerLabel);
        this.labelPanel.add(this.colorPlayerLabel);
        this.labelPanel.add(this.boardLabel);
        
        this.mainPanel.add(this.labelPanel, constraint);
        
        this.chosePanel.add(this.playerNameField);
        this.chosePanel.add(this.colorPanel);
        this.chosePanel.add(this.board);
        
        constraint.gridy = 1;
        constraint.gridx = 2;
        
        this.mainPanel.add(this.chosePanel, constraint);
        
        constraint.gridy = 2;
        constraint.gridx = 0;
        
        constraint.gridwidth = GridBagConstraints.REMAINDER;
        this.okButton.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        this.mainPanel.add(this.okButton,constraint);
        
        add(this.mainPanel, constraint);
        
        this.mainPanel.setOpaque(false);        
        this.colorPanel.setOpaque(false);
        this.chosePanel.setOpaque(false);
        this.labelPanel.setOpaque(false);
        this.setOpaque(false);

    }

    /**
     *
     * @return JLabel which shows color picker dialog window
     */
    public JLabel getFirstColorChoserButton() {
        return this.colorChoser;
    }

    /**
     *
     * @return JLabel which approve changes
     */
    public JLabel getOkButton() {
        return this.okButton;
    }

    /**
     *
     * @return JLabel which shows color picker dialog window
     */
    public JLabel getShowFirstColorChoserButton() {
        return this.showColorChoser;
    }

    /**
     *
     * @return Color which is selected
     */
    public Color getFirstColor() {
        return this.color;
    }

    /**
     *
     * @param aColor set selected color
     */
    public void setFirstColor(Color aColor) {
        this.color = aColor;
    }
}
