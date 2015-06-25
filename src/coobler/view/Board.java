package coobler.view;

import coobler.model.StoreData;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.net.URL;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *Board class is a panel on which is displaying a game board  
 *
 * @author Dawid
 */
public class Board extends JPanel {

    private JPanel scorePanel;
    private JPanel boardPanel;

    private JPanel firstUserIdentify;
    private JPanel secondUserIdentify;

    private JLabel firstPlayerNameLabel;
    private JLabel secondPlayerNameLabel;

    private JLabel firstAvatar;
    private JLabel secondAvatar;

    private JLabel firstPlayerScoreLabel;
    private JLabel secondPlayerScoreLabel;

    private JLabel[][] horizontalField;
    private JLabel[][] verticalField;
    private JLabel[][] centerField;
    private JLabel[][] cornerField;

    private ImageIcon firstPlayerImageIcon;
    private ImageIcon secondPlayerImageIcon;
    private ImageIcon scaledFirstPlayerImageIcon;
    private ImageIcon scaledSecondPlayerImageIcon;

    public static int AMOUNT_FIELD;
    public static int SPACE_X;
    public static int SPACE_Y;
    public static int PIECE;
    public static int SIZE_OF_PIECE;

    public static int WIDTH_PANEL = 816;
    public static int HEIGHT_PANEL = 639;
    public static int WIDTH_SCORE_PANEL;
    public static int HEIGHT_SCORE_PANEL;
    public static int WIDTH_BOARD_PANEL;
    public static int HEIGHT_BOARD_PANEL;
    public static int SIZE_BOARD;

    private StoreData sData;

    /**
     * Creates a new instance of Board 
     *
     * @param storeData store data about player and size of board
     */
    public Board(StoreData storeData) {

        setLayout(null);

        sData = storeData;

        Board.AMOUNT_FIELD = sData.getSizeBoard();
        this.boardPanel = new JPanel(null);
        this.boardPanel.setOpaque(false);
        this.scorePanel = new JPanel(null);
        this.scorePanel.setBackground(new Color(255, 170, 1));

        this.firstUserIdentify = new JPanel(null);
        this.secondUserIdentify = new JPanel(null);
        this.firstUserIdentify.setOpaque(false);
        this.secondUserIdentify.setOpaque(false);

        Board.WIDTH_SCORE_PANEL = (Board.WIDTH_PANEL - 16) / 6;
        Board.HEIGHT_SCORE_PANEL = (Board.HEIGHT_PANEL - 39);

        Board.WIDTH_BOARD_PANEL = 5 * (Board.WIDTH_PANEL - 16) / 6;

        Board.HEIGHT_BOARD_PANEL = (Board.HEIGHT_PANEL - 39);

        this.horizontalField = new JLabel[Board.AMOUNT_FIELD + 1][Board.AMOUNT_FIELD];
        this.verticalField = new JLabel[Board.AMOUNT_FIELD][Board.AMOUNT_FIELD + 1];
        this.centerField = new JLabel[Board.AMOUNT_FIELD][Board.AMOUNT_FIELD];
        this.cornerField = new JLabel[Board.AMOUNT_FIELD + 1][Board.AMOUNT_FIELD + 1];

        for (int i = 0; i < Board.AMOUNT_FIELD; i++) {

            for (int j = 0; j < Board.AMOUNT_FIELD; j++) {

                this.horizontalField[i][j] = new JLabel();
                this.horizontalField[i][j].setBorder(BorderFactory.createLineBorder(Color.WHITE));
                this.horizontalField[i][j].setBackground(new Color(26,26,26));
                this.horizontalField[i][j].setOpaque(true);

                this.verticalField[i][j] = new JLabel();
                this.verticalField[i][j].setBorder(BorderFactory.createLineBorder(Color.WHITE));
                this.verticalField[i][j].setBackground(new Color(26,26,26));
                this.verticalField[i][j].setOpaque(true);

                this.centerField[i][j] = new JLabel();
                this.centerField[i][j].setBackground(new Color(26,26,26));
                this.centerField[i][j].setOpaque(true);

                this.cornerField[i][j] = new JLabel();

                this.cornerField[i][j].setBackground(Color.GRAY.darker());

                this.cornerField[i][j].setOpaque(true);

            }
        }

        for (int j = 0; j < Board.AMOUNT_FIELD; j++) {

            this.horizontalField[Board.AMOUNT_FIELD][j] = new JLabel();
            this.horizontalField[Board.AMOUNT_FIELD][j].setBorder(BorderFactory.createLineBorder(Color.WHITE));
            this.horizontalField[Board.AMOUNT_FIELD][j].setBackground(new Color(26,26,26));
            this.horizontalField[Board.AMOUNT_FIELD][j].setOpaque(true);

            this.verticalField[j][Board.AMOUNT_FIELD] = new JLabel();
            this.verticalField[j][Board.AMOUNT_FIELD].setBorder(BorderFactory.createLineBorder(Color.WHITE));
            this.verticalField[j][Board.AMOUNT_FIELD].setBackground(new Color(26,26,26));
            this.verticalField[j][Board.AMOUNT_FIELD].setOpaque(true);

            this.cornerField[Board.AMOUNT_FIELD][j] = new JLabel();

            this.cornerField[Board.AMOUNT_FIELD][j].setBackground(Color.WHITE);

            this.cornerField[Board.AMOUNT_FIELD][j].setOpaque(true);

        }
        for (int i = 0; i < Board.AMOUNT_FIELD + 1; i++) {
            this.cornerField[i][Board.AMOUNT_FIELD] = new JLabel();

            this.cornerField[i][Board.AMOUNT_FIELD].setBackground(Color.WHITE);

            this.cornerField[i][Board.AMOUNT_FIELD].setOpaque(true);
        }

        this.createBoard();
        URL firstPlayerURL = getClass().getResource("grph/Awatar/first.png");
        this.scaledFirstPlayerImageIcon = new ImageIcon();
        this.firstPlayerImageIcon = new ImageIcon(firstPlayerURL);
        this.scaledFirstPlayerImageIcon.setImage(this.firstPlayerImageIcon.getImage());
        this.firstAvatar = new JLabel(this.scaledFirstPlayerImageIcon);
        this.firstPlayerNameLabel = new JLabel(sData.getFirstNick());
        this.firstPlayerNameLabel.setHorizontalAlignment(JLabel.CENTER);

        this.firstPlayerScoreLabel = new JLabel("0");
        this.firstPlayerScoreLabel.setFont(new Font("Arial", 1, 25));
        this.firstPlayerScoreLabel.setHorizontalAlignment(JLabel.CENTER);

        this.scaledSecondPlayerImageIcon = new ImageIcon();
        URL secondPlayerURL = getClass().getResource("grph/Awatar/second.png");
        this.secondPlayerImageIcon = new ImageIcon(secondPlayerURL);
        this.scaledSecondPlayerImageIcon.setImage(this.secondPlayerImageIcon.getImage());
        this.secondAvatar = new JLabel(this.scaledSecondPlayerImageIcon);
        this.secondPlayerNameLabel = new JLabel(sData.getSecondNick());
        this.secondPlayerNameLabel.setHorizontalAlignment(JLabel.CENTER);

        this.secondPlayerScoreLabel = new JLabel("0");
        this.secondPlayerScoreLabel.setFont(new Font("Arial", 1, 25));
        this.secondPlayerScoreLabel.setHorizontalAlignment(JLabel.CENTER);

        this.createLabelsScoreAndName();

        this.boardPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        this.createPanels();

        this.firstUserIdentify.add(this.firstAvatar);
        this.firstUserIdentify.add(this.firstPlayerNameLabel);

        this.secondUserIdentify.add(this.secondAvatar);
        this.secondUserIdentify.add(this.secondPlayerNameLabel);

        this.scorePanel.add(this.firstUserIdentify);
        this.scorePanel.add(this.firstPlayerScoreLabel);
        this.scorePanel.add(this.secondUserIdentify);
        this.scorePanel.add(this.secondPlayerScoreLabel);

        this.add(this.boardPanel);
        this.add(this.scorePanel);

        this.setOpaque(false);

    }

    /**
     *
     * @return first player name label
     */
    public JLabel getFirstPlayerNameLabel() {
        return this.firstPlayerNameLabel;
    }

    /**
     *
     * @return panel which is displaying first player avatar
     */
    public JPanel getFirstUserIdentity() {
        return this.firstUserIdentify;
    }

    /**
     *
     * @return first player avatar
     */
    public JLabel getFirsAvatar() {
        return this.firstAvatar;
    }

    /**
     *
     * @return second player avatar
     */
    public JLabel getSecondAvatar() {
        return this.secondAvatar;
    }

    /**
     *
     * @return label which is displaying result which first player is scored
     */
    public JLabel getFirstPlayerScoreLabel() {
        return this.firstPlayerScoreLabel;
    }

    /**
     *
     * @return label which is displaying result which second player is scored
     */
    public JLabel getSecondPlayerNameLabel() {
        return this.secondPlayerNameLabel;
    }

    /**
     *
     * @return panel which is displaying second player avatar
     */
    public JPanel getSecondUserIdentity() {
        return this.secondUserIdentify;
    }

    /**
     *
     * @return label which is displaying result which second player is scored
     */
    public JLabel getSecondPlayerScoreLabel() {
        return this.secondPlayerScoreLabel;
    }

    /**
     *
     * @return  panel which is displaying player data like result score and name player
     */
    public JPanel getScorePanel() {
        return this.scorePanel;
    }

    /**
     *
     * @return panel which is displaying game board
     */
    public JPanel getBoardPanel() {
        return this.boardPanel;
    }

    /**
     *
     * @return center board field
     */
    public JLabel[][] getCenterField() {
        return this.centerField;
    }

    /**
     *
     * @return vertical board field
     */
    public JLabel[][] getVerticalField() {
        return this.verticalField;
    }

    /**
     *
     * @return horizontal board field
     */
    public JLabel[][] getHorizontalField() {
        return this.horizontalField;
    }

    /**
     * This method create a new board when the window size changes
     */
    public void createBoard() {
        int diference = Math.abs(Board.HEIGHT_BOARD_PANEL - Board.WIDTH_BOARD_PANEL);

        if (Board.HEIGHT_BOARD_PANEL >= Board.WIDTH_BOARD_PANEL) {
            Board.PIECE = (Board.AMOUNT_FIELD + 1) + (Board.AMOUNT_FIELD * 5);

            Board.SPACE_X = (Board.WIDTH_BOARD_PANEL % Board.PIECE);
            Board.SPACE_X = (int) Math.ceil(Board.SPACE_X / 2);

            Board.SPACE_Y = (Board.WIDTH_BOARD_PANEL % Board.PIECE) + diference;
            Board.SPACE_Y = (int) Math.ceil(Board.SPACE_Y / 2);

            Board.SIZE_OF_PIECE = (Board.WIDTH_BOARD_PANEL) / Board.PIECE;
        } else {
            Board.PIECE = (Board.AMOUNT_FIELD + 1) + (Board.AMOUNT_FIELD * 5);

            Board.SPACE_X = (Board.HEIGHT_BOARD_PANEL % Board.PIECE) + diference;
            Board.SPACE_X = (int) Math.ceil(Board.SPACE_X / 2);

            Board.SPACE_Y = (Board.HEIGHT_BOARD_PANEL % Board.PIECE);
            Board.SPACE_Y = (int) Math.ceil(Board.SPACE_Y / 2);
            Board.SIZE_OF_PIECE = (Board.HEIGHT_BOARD_PANEL) / Board.PIECE;
        }

        int x, y;
        int w, h;

        for (int i = 0; i < Board.AMOUNT_FIELD + 1; i++) {
            for (int j = 0; j < Board.AMOUNT_FIELD + 1; j++) {

                x = Board.SPACE_X + (j * Board.SIZE_OF_PIECE) + (j * 5 * Board.SIZE_OF_PIECE);
                y = Board.SPACE_Y + (i * Board.SIZE_OF_PIECE) + (i * 5 * Board.SIZE_OF_PIECE);
                w = Board.SIZE_OF_PIECE;
                h = Board.SIZE_OF_PIECE;

                this.cornerField[i][j].setBackground(Color.GRAY.darker());

                this.cornerField[i][j].setBounds(x, y, w, h);
                this.boardPanel.add(this.cornerField[i][j]);
            }

            for (int j = 0; j < Board.AMOUNT_FIELD; j++) {

                x = Board.SPACE_X + ((j + 1) * Board.SIZE_OF_PIECE) + (j * 5 * Board.SIZE_OF_PIECE);
                y = Board.SPACE_Y + (i * Board.SIZE_OF_PIECE) + (i * 5 * Board.SIZE_OF_PIECE);
                w = 5 * Board.SIZE_OF_PIECE;
                h = Board.SIZE_OF_PIECE;

                this.horizontalField[i][j].setBorder(BorderFactory.createLineBorder(Color.GRAY.darker()));

                this.horizontalField[i][j].setBounds(x, y, w, h);
                this.boardPanel.add(this.horizontalField[i][j]);
            }

            for (int j = 0; j < Board.AMOUNT_FIELD + 1; j++) {
                if (i < Board.AMOUNT_FIELD) {
                    x = Board.SPACE_X + (j * Board.SIZE_OF_PIECE) + (j * 5 * Board.SIZE_OF_PIECE);
                    y = Board.SPACE_Y + ((i + 1) * Board.SIZE_OF_PIECE) + (i * 5 * Board.SIZE_OF_PIECE);
                    w = 1 * Board.SIZE_OF_PIECE;
                    h = 5 * Board.SIZE_OF_PIECE;

                    this.verticalField[i][j].setBorder(BorderFactory.createLineBorder(Color.GRAY.darker()));

                    this.verticalField[i][j].setBounds(x, y, w, h);
                    this.boardPanel.add(this.verticalField[i][j]);
                }
            }

            for (int j = 0; j < Board.AMOUNT_FIELD; j++) {
                if (i < Board.AMOUNT_FIELD) {

                    x = Board.SPACE_X + ((j + 1) * Board.SIZE_OF_PIECE) + (j * 5 * Board.SIZE_OF_PIECE);
                    y = Board.SPACE_Y + ((i + 1) * Board.SIZE_OF_PIECE) + (i * 5 * Board.SIZE_OF_PIECE);
                    w = 5 * Board.SIZE_OF_PIECE;
                    h = 5 * Board.SIZE_OF_PIECE;
                    this.centerField[i][j].setBounds(x, y, w, h);
                    this.boardPanel.add(this.centerField[i][j]);
                }
            }
        }
    }

    /**
     * This method create panel with results and names players when the window size changes
     */
    public void createPanels() {

        this.firstPlayerScoreLabel.setBorder(BorderFactory.createLineBorder(this.sData.getFirstColor(), 2, false));
        this.secondPlayerScoreLabel.setBorder(BorderFactory.createLineBorder(this.sData.getSecondColor(), 2, false));

        int remainder = (Board.WIDTH_PANEL % 6) + (Board.WIDTH_PANEL % 6) * 5;
        this.getScorePanel().setBounds(0, 0, (int) Math.floor(Board.WIDTH_PANEL / 6), Board.HEIGHT_PANEL);
        this.getBoardPanel().setBounds((int) Math.floor(Board.WIDTH_PANEL / 6), 0, 5 * (int) Math.floor(Board.WIDTH_PANEL / 6) + remainder, Board.HEIGHT_PANEL);
    }

    public void createLabelsScoreAndName() {

        this.getFirstUserIdentity().setBounds(20, Board.HEIGHT_SCORE_PANEL / 12, Board.WIDTH_SCORE_PANEL - 40, Board.HEIGHT_SCORE_PANEL / 12);
        this.getFirstPlayerScoreLabel().setBounds(30, (2 * Board.HEIGHT_SCORE_PANEL / 12) + Board.HEIGHT_SCORE_PANEL / 12, Board.WIDTH_SCORE_PANEL - 60, Board.HEIGHT_SCORE_PANEL / 9);
        this.getSecondUserIdentity().setBounds(20, (4 * Board.HEIGHT_SCORE_PANEL / 12) + Board.HEIGHT_SCORE_PANEL / 12 + Board.HEIGHT_SCORE_PANEL / 9, Board.WIDTH_SCORE_PANEL - 40, Board.HEIGHT_SCORE_PANEL / 12);
        this.getSecondPlayerScoreLabel().setBounds(30, (5 * Board.HEIGHT_SCORE_PANEL / 12) + Board.HEIGHT_SCORE_PANEL / 12 + Board.HEIGHT_SCORE_PANEL / 9 + Board.HEIGHT_SCORE_PANEL / 12, Board.WIDTH_SCORE_PANEL - 60, Board.HEIGHT_SCORE_PANEL / 9);

        if (this.firstUserIdentify.getWidth() / 4 < this.firstUserIdentify.getHeight()) {
            this.scaledFirstPlayerImageIcon.setImage(this.firstPlayerImageIcon.getImage().getScaledInstance(this.firstUserIdentify.getWidth() / 4, this.firstUserIdentify.getWidth() / 4, Image.SCALE_SMOOTH));
            this.scaledSecondPlayerImageIcon.setImage(this.secondPlayerImageIcon.getImage().getScaledInstance(this.secondUserIdentify.getWidth() / 4, this.secondUserIdentify.getWidth() / 4, Image.SCALE_SMOOTH));

            this.firstAvatar.setBounds(0, (this.firstUserIdentify.getHeight() - (this.firstUserIdentify.getWidth() / 4)) / 2, this.firstUserIdentify.getWidth() / 4, this.firstUserIdentify.getWidth() / 4);
            this.secondAvatar.setBounds(0, (this.secondUserIdentify.getHeight() - (this.secondUserIdentify.getWidth() / 4)) / 2, this.secondUserIdentify.getWidth() / 4, this.secondUserIdentify.getWidth() / 4);

            this.firstPlayerNameLabel.setBounds(this.secondUserIdentify.getWidth() / 4, 0, 3 * this.secondUserIdentify.getWidth() / 4, this.secondUserIdentify.getHeight());
            this.secondPlayerNameLabel.setBounds(this.secondUserIdentify.getWidth() / 4, 0, 3 * this.secondUserIdentify.getWidth() / 4, this.secondUserIdentify.getHeight());
        } else {
            this.scaledFirstPlayerImageIcon.setImage(this.firstPlayerImageIcon.getImage().getScaledInstance(this.firstUserIdentify.getHeight(), this.firstUserIdentify.getHeight(), Image.SCALE_SMOOTH));
            this.scaledSecondPlayerImageIcon.setImage(this.secondPlayerImageIcon.getImage().getScaledInstance(this.secondUserIdentify.getHeight(), this.secondUserIdentify.getHeight(), Image.SCALE_SMOOTH));

            this.firstAvatar.setBounds(0, 0, this.firstUserIdentify.getHeight(), this.firstUserIdentify.getHeight());
            this.secondAvatar.setBounds(0, 0, this.secondUserIdentify.getHeight(), this.secondUserIdentify.getHeight());

            this.firstPlayerNameLabel.setBounds(this.firstUserIdentify.getHeight(), 0, this.firstUserIdentify.getWidth() - this.firstUserIdentify.getHeight(), this.firstUserIdentify.getHeight());
            this.secondPlayerNameLabel.setBounds(this.secondUserIdentify.getHeight(), 0, this.secondUserIdentify.getWidth() - this.secondUserIdentify.getHeight(), this.secondUserIdentify.getHeight());
        }
    }

}
