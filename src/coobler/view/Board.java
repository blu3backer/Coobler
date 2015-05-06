package coobler.view;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Dawid
 */
public class Board extends JPanel {

    private MultiChoser multiChoser;

    private JPanel scorePanel;
    private JPanel boardPanel;

    private JLabel firstPlayerNameLabel;
    private JLabel secondPlayerNameLabel;
    private JLabel firstPlayerScoreLabel;
    private JLabel secondPlayerScoreLabel;

    private JLabel[][] horizontalField;
    private JLabel[][] verticalField;
    private JLabel[][] centerField;
    private JLabel[][] cornerField;

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

    public Board(MultiChoser aMultiChoser) {
        setLayout(null);
        this.multiChoser = aMultiChoser;
        Board.AMOUNT_FIELD = this.multiChoser.getSizeBoard();

        this.boardPanel = new JPanel(null);
        this.scorePanel = new JPanel(null);

        Board.WIDTH_SCORE_PANEL = (Board.WIDTH_PANEL - 16) / 6;
        Board.HEIGHT_SCORE_PANEL = (Board.HEIGHT_PANEL - 39);

        Board.WIDTH_BOARD_PANEL = 5 * (Board.WIDTH_PANEL - 16) / 6;
        Board.HEIGHT_BOARD_PANEL = (Board.HEIGHT_PANEL - 39);

        //*************BOARD*******************************
        this.horizontalField = new JLabel[Board.AMOUNT_FIELD + 1][Board.AMOUNT_FIELD];
        this.verticalField = new JLabel[Board.AMOUNT_FIELD][Board.AMOUNT_FIELD + 1];
        this.centerField = new JLabel[Board.AMOUNT_FIELD][Board.AMOUNT_FIELD];
        this.cornerField = new JLabel[Board.AMOUNT_FIELD + 1][Board.AMOUNT_FIELD + 1];

        //*************INIT*******************************************
        for (int i = 0; i < Board.AMOUNT_FIELD; i++) {
            for (int j = 0; j < Board.AMOUNT_FIELD; j++) {

                this.horizontalField[i][j] = new JLabel();
                this.horizontalField[i][j].setBorder(BorderFactory.createLineBorder(Color.WHITE));
                this.horizontalField[i][j].setBackground(new Color(0, 49, 83));
                this.horizontalField[i][j].setOpaque(true);

                this.verticalField[i][j] = new JLabel();
                this.verticalField[i][j].setBorder(BorderFactory.createLineBorder(Color.WHITE));
                this.verticalField[i][j].setBackground(new Color(0, 49, 83));
                this.verticalField[i][j].setOpaque(true);

                this.centerField[i][j] = new JLabel();
                this.centerField[i][j].setBackground(new Color(0, 49, 83));
                this.centerField[i][j].setOpaque(true);

                this.cornerField[i][j] = new JLabel();

                this.cornerField[i][j].setBackground(Color.GRAY.darker());

                this.cornerField[i][j].setOpaque(true);

            }
        }

        for (int j = 0; j < Board.AMOUNT_FIELD; j++) {

            this.horizontalField[Board.AMOUNT_FIELD][j] = new JLabel();
            this.horizontalField[Board.AMOUNT_FIELD][j].setBorder(BorderFactory.createLineBorder(Color.WHITE));
            this.horizontalField[Board.AMOUNT_FIELD][j].setBackground(new Color(0, 49, 83));
            this.horizontalField[Board.AMOUNT_FIELD][j].setOpaque(true);

            this.verticalField[j][Board.AMOUNT_FIELD] = new JLabel();
            this.verticalField[j][Board.AMOUNT_FIELD].setBorder(BorderFactory.createLineBorder(Color.WHITE));
            this.verticalField[j][Board.AMOUNT_FIELD].setBackground(new Color(0, 49, 83));
            this.verticalField[j][Board.AMOUNT_FIELD].setOpaque(true);

            this.cornerField[Board.AMOUNT_FIELD][j] = new JLabel();
            System.out.println(multiChoser.getFirstColor());

            this.cornerField[Board.AMOUNT_FIELD][j].setBackground(Color.WHITE);

            this.cornerField[Board.AMOUNT_FIELD][j].setOpaque(true);

        }
        for (int i = 0; i < Board.AMOUNT_FIELD + 1; i++) {
            this.cornerField[i][Board.AMOUNT_FIELD] = new JLabel();

            this.cornerField[i][Board.AMOUNT_FIELD].setBackground(Color.WHITE);

            this.cornerField[i][Board.AMOUNT_FIELD].setOpaque(true);
        }

        this.createBoard();

        //**************LABELS**************************
        this.firstPlayerNameLabel = new JLabel(multiChoser.getFirstName());
        this.firstPlayerNameLabel.setHorizontalAlignment(JLabel.CENTER);
        this.firstPlayerNameLabel.setForeground(Color.WHITE);
        
        this.firstPlayerScoreLabel = new JLabel("0");
        this.firstPlayerScoreLabel.setHorizontalAlignment(JLabel.CENTER);
        this.firstPlayerScoreLabel.setForeground(Color.WHITE);

        this.secondPlayerNameLabel = new JLabel(multiChoser.getSecondName());
        this.secondPlayerNameLabel.setHorizontalAlignment(JLabel.CENTER);
        this.secondPlayerNameLabel.setForeground(Color.WHITE);
        
        this.secondPlayerScoreLabel = new JLabel("0");
        this.secondPlayerScoreLabel.setHorizontalAlignment(JLabel.CENTER);
        this.secondPlayerScoreLabel.setForeground(Color.WHITE);

        this.createLabelsScoreAndName();
        //*****************PANELS***********************
        this.boardPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        this.createPanels();
        this.scorePanel.setOpaque(false);
        this.boardPanel.setOpaque(false);

        this.scorePanel.add(this.firstPlayerNameLabel);
        this.scorePanel.add(this.firstPlayerScoreLabel);
        this.scorePanel.add(this.secondPlayerNameLabel);
        this.scorePanel.add(this.secondPlayerScoreLabel);

        this.add(this.boardPanel);
        this.add(this.scorePanel);
        this.setOpaque(false);

    }

    public JLabel getFirstPlayerNameLabel() {
        return this.firstPlayerNameLabel;
    }

    public JLabel getFirstPlayerScoreLabel() {
        return this.firstPlayerScoreLabel;
    }

    public JLabel getSecondPlayerNameLabel() {
        return this.secondPlayerNameLabel;
    }

    public JLabel getSecondPlayerScoreLabel() {
        return this.secondPlayerScoreLabel;
    }

    public JPanel getScorePanel() {
        return this.scorePanel;
    }

    public JPanel getBoardPanel() {
        return this.boardPanel;
    }

    public int getAmountField() {
        return this.AMOUNT_FIELD;
    }

    public JLabel[][] getCornerField() {
        return this.cornerField;
    }

    public JLabel[][] getCenterField() {
        return this.centerField;
    }

    public JLabel[][] getVerticalField() {
        return this.verticalField;
    }

    public JLabel[][] getHorizontalField() {
        return this.horizontalField;
    }

    public void createBoard() {
        int diference = Math.abs(Board.HEIGHT_BOARD_PANEL - Board.WIDTH_BOARD_PANEL);

        //******************ONE PART AND SPACE TO MAIN JPANEL*********************
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
        //*******************SET SIZE AND POSITION*******************************
        int x, y;
        int w, h;
        for (int i = 0; i < Board.AMOUNT_FIELD + 1; i++) {
            //*************CORNERS***********************
            for (int j = 0; j < Board.AMOUNT_FIELD + 1; j++) {

                x = Board.SPACE_X + (j * Board.SIZE_OF_PIECE) + (j * 5 * Board.SIZE_OF_PIECE);
                y = Board.SPACE_Y + (i * Board.SIZE_OF_PIECE) + (i * 5 * Board.SIZE_OF_PIECE);
                w = Board.SIZE_OF_PIECE;
                h = Board.SIZE_OF_PIECE;
                if (multiChoser.getFirstColor().getBlue() > 200 && multiChoser.getFirstColor().getRed() > 200 && multiChoser.getFirstColor().getGreen() > 200) {
                    this.cornerField[i][j].setBackground(Color.GRAY.darker());
                } else {
                    this.cornerField[i][j].setBackground(Color.WHITE);
                }
                this.cornerField[i][j].setBounds(x, y, w, h);
                this.boardPanel.add(this.cornerField[i][j]);
            }
            //***********HORIZONTAL FIELD*****************
            for (int j = 0; j < Board.AMOUNT_FIELD; j++) {

                x = Board.SPACE_X + ((j + 1) * Board.SIZE_OF_PIECE) + (j * 5 * Board.SIZE_OF_PIECE);
                y = Board.SPACE_Y + (i * Board.SIZE_OF_PIECE) + (i * 5 * Board.SIZE_OF_PIECE);
                w = 5 * Board.SIZE_OF_PIECE;
                h = Board.SIZE_OF_PIECE;
                if (multiChoser.getFirstColor().getBlue() > 200 && multiChoser.getFirstColor().getRed() > 200 && multiChoser.getFirstColor().getGreen() > 200) {
                    this.horizontalField[i][j].setBorder(BorderFactory.createLineBorder(Color.GRAY.darker()));
                } else {
                    this.horizontalField[i][j].setBorder(BorderFactory.createLineBorder(Color.WHITE));
                }
                this.horizontalField[i][j].setBounds(x, y, w, h);
                this.boardPanel.add(this.horizontalField[i][j]);
            }
            //**********VERTICAL FIELD*********************
            for (int j = 0; j < Board.AMOUNT_FIELD + 1; j++) {
                if (i < Board.AMOUNT_FIELD) {
                    x = Board.SPACE_X + (j * Board.SIZE_OF_PIECE) + (j * 5 * Board.SIZE_OF_PIECE);
                    y = Board.SPACE_Y + ((i + 1) * Board.SIZE_OF_PIECE) + (i * 5 * Board.SIZE_OF_PIECE);
                    w = 1 * Board.SIZE_OF_PIECE;
                    h = 5 * Board.SIZE_OF_PIECE;
                    if (multiChoser.getFirstColor().getBlue() > 200 && multiChoser.getFirstColor().getRed() > 200 && multiChoser.getFirstColor().getGreen() > 200) {
                        this.verticalField[i][j].setBorder(BorderFactory.createLineBorder(Color.GRAY.darker()));
                    } else {
                        this.verticalField[i][j].setBorder(BorderFactory.createLineBorder(Color.WHITE));
                    }
                    this.verticalField[i][j].setBounds(x, y, w, h);
                    this.boardPanel.add(this.verticalField[i][j]);
                }
            }
            //*********CENTER FIELD************************
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

    public void createPanels() {

        this.firstPlayerNameLabel.setBorder(BorderFactory.createLineBorder(this.multiChoser.getFirstColor(), 2, false));
        this.firstPlayerScoreLabel.setBorder(BorderFactory.createLineBorder(this.multiChoser.getFirstColor(), 2, false));
        this.secondPlayerNameLabel.setBorder(BorderFactory.createLineBorder(this.multiChoser.getSecondColor(), 2, false));
        this.secondPlayerScoreLabel.setBorder(BorderFactory.createLineBorder(this.multiChoser.getSecondColor(), 2, false));

        int remainder = (Board.WIDTH_PANEL % 6) + (Board.WIDTH_PANEL % 6) * 5;
        this.getScorePanel().setBounds(0, 0, (int) Math.floor(Board.WIDTH_PANEL / 6), Board.HEIGHT_PANEL);
        this.getBoardPanel().setBounds((int) Math.floor(Board.WIDTH_PANEL / 6), 0, 5 * (int) Math.floor(Board.WIDTH_PANEL / 6) + remainder, Board.HEIGHT_PANEL);
    }

    public void createLabelsScoreAndName() {
        this.getFirstPlayerNameLabel().setBounds(20, Board.HEIGHT_SCORE_PANEL / 12, Board.WIDTH_SCORE_PANEL - 40, Board.HEIGHT_SCORE_PANEL / 12);
        this.getFirstPlayerScoreLabel().setBounds(30, (2 * Board.HEIGHT_SCORE_PANEL / 12) + Board.HEIGHT_SCORE_PANEL / 12, Board.WIDTH_SCORE_PANEL - 60, Board.HEIGHT_SCORE_PANEL / 9);
        this.getSecondPlayerNameLabel().setBounds(20, (4 * Board.HEIGHT_SCORE_PANEL / 12) + Board.HEIGHT_SCORE_PANEL / 12 + Board.HEIGHT_SCORE_PANEL / 9, Board.WIDTH_SCORE_PANEL - 40, Board.HEIGHT_SCORE_PANEL / 12);
        this.getSecondPlayerScoreLabel().setBounds(30, (5 * Board.HEIGHT_SCORE_PANEL / 12) + Board.HEIGHT_SCORE_PANEL / 12 + Board.HEIGHT_SCORE_PANEL / 9 + Board.HEIGHT_SCORE_PANEL / 12, Board.WIDTH_SCORE_PANEL - 60, Board.HEIGHT_SCORE_PANEL / 9);
    }
}
