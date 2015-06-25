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
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * LanClientChoser class extends JPanel and display JTextField which allows 
 * write a player name and two JButtons which allows to chose player color and 
 * join to the LAN game
 *
 * @author Dawid 
 */
public class LanClientChooser extends JPanel {

    private JLabel joinButton;
    private JLabel colorChoser;

    private JTextField playerNameField;

    private JPanel mainPanel;
    private JPanel labelPanel;
    private JPanel chosePanel;
    private JPanel colorPanel;

    private JLabel showColorChoser;
    private JLabel namePlayerLabel;
    private JLabel colorPlayerLabel;

    public LanClientChooser() {
        this.setLayout(new GridLayout(1, 1, 50, 50));

        this.colorPanel = new JPanel(new GridLayout(1, 2, 20, 10));

        this.mainPanel = new JPanel(new GridBagLayout());
        this.chosePanel = new JPanel(new GridLayout(2, 1, 20, 30));
        this.labelPanel = new JPanel(new GridLayout(2, 1, 20, 30));

        this.mainPanel.setBorder(BorderFactory.createLineBorder(Color.WHITE));

        this.namePlayerLabel = new JLabel("PLAYER NAME");
        this.namePlayerLabel.setForeground(Color.WHITE);
        this.namePlayerLabel.setFont(new Font("Arial", 1, 18));

        this.colorPlayerLabel = new JLabel("PLAYER COLOR");
        this.colorPlayerLabel.setForeground(Color.WHITE);
        this.colorPlayerLabel.setFont(new Font("Arial", 1, 18));

        this.showColorChoser = new JLabel();
        this.showColorChoser.setBorder(BorderFactory.createLineBorder(new Color(249, 224, 75)));
        this.showColorChoser.setOpaque(true);
        this.showColorChoser.setBackground(Color.WHITE);

        this.playerNameField = new JTextField();
        this.playerNameField.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        this.playerNameField.setFont(new Font("Arial", 1, 22));

        URL joinURL = getClass().getResource("grph/waitJoinButton.png");
        this.joinButton = new JLabel(new ImageIcon(joinURL));
        URL colorURL = getClass().getResource("grph/choseButton.png");
        this.colorChoser = new JLabel(new ImageIcon(colorURL));

        this.namePlayerLabel.setPreferredSize(new Dimension(300, 50));
        this.colorPlayerLabel.setPreferredSize(new Dimension(300, 50));

        this.namePlayerLabel.setHorizontalAlignment(JLabel.RIGHT);
        this.colorPlayerLabel.setHorizontalAlignment(JLabel.RIGHT);
        this.playerNameField.setHorizontalAlignment(JTextField.CENTER);

        this.colorPanel.add(this.colorChoser);
        this.colorPanel.add(this.showColorChoser);

        GridBagConstraints constraint = new GridBagConstraints();
        constraint.weightx = 1.0;
        constraint.weighty = 1.0;
        constraint.gridy = 1;

        this.labelPanel.add(this.namePlayerLabel);
        this.labelPanel.add(this.colorPlayerLabel);

        this.mainPanel.add(this.labelPanel, constraint);

        this.chosePanel.add(this.playerNameField);
        this.chosePanel.add(this.colorPanel);

        constraint.gridy = 1;
        constraint.gridx = 2;

        this.mainPanel.add(this.chosePanel, constraint);
        constraint.gridy = 2;
        constraint.gridx = 0;

        constraint.gridwidth = GridBagConstraints.REMAINDER;
        this.mainPanel.add(this.joinButton, constraint);

        add(this.mainPanel, constraint);

        this.mainPanel.setOpaque(false);
        this.colorPanel.setOpaque(false);
        this.chosePanel.setOpaque(false);
        this.labelPanel.setOpaque(false);
        this.setOpaque(false);

    }

    /**
     * 
     * @return field which serves to the writing player name
     */
    public JTextField getPlayerNameField() {
        return this.playerNameField;
    }

    /**
     * 
     * @return jlabel which represent button which calls color chooser
     */
    public JLabel getColorChoserButton() {
        return this.colorChoser;
    }

    /**
     * 
     * @return jlabel which represent button which allows to join to the game
     */
    public JLabel getJoinButton() {
        return this.joinButton;
    }

    /**
     * 
     * @return show curren color
     */
    public JLabel getShowColorChoserButton() {
        return this.showColorChoser;
    }

}
