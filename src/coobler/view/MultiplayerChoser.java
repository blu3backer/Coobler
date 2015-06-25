package coobler.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.net.URL;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * 
 * 
 * @author Dawid
 */
public class MultiplayerChoser extends JPanel {

    private JComboBox board;
    private JLabel boardLabel;

    private JLabel okButton;
    private JLabel firstColorChoser;
    private JLabel secondColorChoser;

    private JTextField firstPlayerNameField;
    private JTextField secondPlayerNameField;

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

    /**
     * Creates instance of MultiplayerChoser class 
     */
    public MultiplayerChoser() {
        this.setLayout(new GridLayout(1, 1, 50, 50));

        this.firstColorPanel = new JPanel(new GridLayout(1, 2, 20, 10));
        this.secondColorPanel = new JPanel(new GridLayout(1, 2, 20, 10));

        this.mainPanel = new JPanel(new GridBagLayout());
        this.chosePanel = new JPanel(new GridLayout(5, 1, 20, 30));
        this.labelPanel = new JPanel(new GridLayout(5, 1, 20, 30));

        this.mainPanel.setBorder(BorderFactory.createLineBorder(Color.WHITE));

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
        this.firstShowColorChoser.setBackground(Color.WHITE);

        this.secondShowColorChoser = new JLabel();
        this.secondShowColorChoser.setBorder(BorderFactory.createLineBorder(new Color(249, 224, 75)));
        this.secondShowColorChoser.setOpaque(true);
        this.secondShowColorChoser.setBackground(Color.BLACK);

        this.firstPlayerNameField = new JTextField();
        this.firstPlayerNameField.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        this.firstPlayerNameField.setFont(new Font("Arial", 1, 22));

        this.secondPlayerNameField = new JTextField();
        this.secondPlayerNameField.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        this.secondPlayerNameField.setFont(new Font("Arial", 1, 22));

        String[] boardsSize = {
            "3x3","4x4", "5x5", "6x6", "7x7", "8x8", "9x9","10x10","11x11","12x12"
        };
        this.board = new JComboBox(boardsSize);

        URL okURL = getClass().getResource("grph/okButton.png");
        this.okButton = new JLabel(new ImageIcon(okURL));
        URL firstColorURL = getClass().getResource("grph/choseButton.png");
        this.firstColorChoser = new JLabel(new ImageIcon(firstColorURL));
        URL secondColorURL = getClass().getResource("grph/choseButton.png");
        this.secondColorChoser = new JLabel(new ImageIcon(secondColorURL));

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

    /**
     * 
     * @return JTextField which serves to the writing first player name
     */
    public JTextField getFirstPlayerNameField() {
        return this.firstPlayerNameField;
    }

    /**
     * 
     * @return JTextField which serves to the writing first player name
     */
    public JTextField getSecondPlayerNameField() {
        return this.secondPlayerNameField;
    }

    /**
     * 
     * @return JComboBox which allows chose board size
     */
    public JComboBox getBoardSize() {
        return this.board;
    }

    /**
     * 
     * @return JLabel which represents a button which calls a color choser for the first player
     */
    public JLabel getFirstColorChoserButton() {
        return this.firstColorChoser;
    }

    /**
     * 
     * @return JLabel which represents a button which calls a color choser for second player
     */
    public JLabel getSecondColorChoserButton() {
        return this.secondColorChoser;
    }

    /**
     * 
     * @return JLabel which represents a button which allows to starting the game
     */
    public JLabel getOkButton() {
        return this.okButton;
    }

    /**
     * 
     * @return label which shows current first player color 
     */
    public JLabel getShowFirstColorChoserButton() {
        return this.firstShowColorChoser;
    }

    /**
     * 
     * @return label which shows current second player color
     */
    public JLabel getShowSecondColorChoserButton() {
        return this.secondShowColorChoser;
    }

}
