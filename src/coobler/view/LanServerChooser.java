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
 * @author Dawid
 */
public class LanServerChooser extends JPanel {

    private JComboBox board;
    private JLabel boardLabel;

    private JLabel startButton;
    private JLabel colorChoser;

    private JTextField playerNameField;

    private JPanel mainPanel;
    private JPanel labelPanel;
    private JPanel chosePanel;
    private JPanel colorPanel;

    private JLabel showColorChoser;
    private JLabel namePlayerLabel;
    private JLabel colorPlayerLabel;

    public LanServerChooser() {
        this.setLayout(new GridLayout(1, 1, 50, 50));

        this.colorPanel = new JPanel(new GridLayout(1, 2, 20, 10));

        this.mainPanel = new JPanel(new GridBagLayout());
        this.chosePanel = new JPanel(new GridLayout(3, 1, 20, 30));
        this.labelPanel = new JPanel(new GridLayout(3, 1, 20, 30));

        this.mainPanel.setBorder(BorderFactory.createLineBorder(Color.WHITE));

        this.namePlayerLabel = new JLabel("FIRST PLAYER NAME");
        this.namePlayerLabel.setForeground(Color.WHITE);
        this.namePlayerLabel.setFont(new Font("Arial", 1, 18));

        this.colorPlayerLabel = new JLabel("FIRST PLAYER COLOR");
        this.colorPlayerLabel.setForeground(Color.WHITE);
        this.colorPlayerLabel.setFont(new Font("Arial", 1, 18));

        this.boardLabel = new JLabel("BOARD");
        this.boardLabel.setForeground(Color.WHITE);
        this.boardLabel.setFont(new Font("Arial", 1, 26));

        this.showColorChoser = new JLabel();
        this.showColorChoser.setBorder(BorderFactory.createLineBorder(new Color(249, 224, 75)));
        this.showColorChoser.setOpaque(true);
        this.showColorChoser.setBackground(Color.BLACK);

        this.playerNameField = new JTextField();
        this.playerNameField.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        this.playerNameField.setFont(new Font("Arial", 1, 22));

        String[] boardsSize = {
            "4x4", "5x5", "6x6", "7x7", "8x8"
        };
        this.board = new JComboBox(boardsSize);

        URL startURL = getClass().getResource("grph/startServerButton.png");
        this.startButton = new JLabel(new ImageIcon(startURL));
        URL colorURL = getClass().getResource("grph/choseButton.png");
        this.colorChoser = new JLabel(new ImageIcon(colorURL));

        this.namePlayerLabel.setPreferredSize(new Dimension(300, 50));
        this.colorPlayerLabel.setPreferredSize(new Dimension(300, 50));
        this.boardLabel.setPreferredSize(new Dimension(200, 50));

        this.namePlayerLabel.setHorizontalAlignment(JLabel.RIGHT);
        this.colorPlayerLabel.setHorizontalAlignment(JLabel.RIGHT);
        this.boardLabel.setHorizontalAlignment(JLabel.RIGHT);
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
        this.mainPanel.add(this.startButton, constraint);

        add(this.mainPanel, constraint);

        this.mainPanel.setOpaque(false);
        this.colorPanel.setOpaque(false);
        this.chosePanel.setOpaque(false);
        this.labelPanel.setOpaque(false);
        this.setOpaque(false);

    }

    public JTextField getPlayerNameField() {
        return this.playerNameField;
    }

    public JComboBox getBoardSize() {
        return this.board;
    }

    public JLabel getColorChoserButton() {
        return this.colorChoser;
    }

    public JLabel getStartButton() {
        return this.startButton;
    }

    public JLabel getShowColorChoserButton() {
        return this.showColorChoser;
    }

    public JComboBox getSizeBoard() {
        return this.board;
    }
}
