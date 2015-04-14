
package coobler.view;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Dawid
 */
public class BoardView extends JPanel{
    
    private int sizeBoard;
    
    private JPanel scorePanel;
    private JPanel boardPanel;
    
    private JLabel [][]dots;
    private JLabel [][]verticalField;
    private JLabel [][]horizontalField;
    private JLabel [][]centerField;
    
    private JLabel [][]horizontalTempField;
    private JLabel [][]verticalTempField;
    
    private JLabel firstUserField;
    private JLabel secondUserField;
    private JLabel firstPunktField;
    private JLabel secondPunktField;
    
    public BoardView(int size, String firstUserName, String secondUserName){
        this.sizeBoard = size;
        
        this.scorePanel = new JPanel();
        this.boardPanel = new JPanel();
        
        this.firstUserField = new JLabel(firstUserName);
        this.firstUserField.setBounds(10, 50, 140, 50);
        this.secondUserField = new JLabel(secondUserName);
        this.secondUserField.setBounds(10, 250, 140, 50);
        this.firstPunktField = new JLabel("0");
        this.firstPunktField.setBounds(50, 130, 70, 70);
        this.secondPunktField = new JLabel("0");
        this.secondPunktField.setBounds(50, 330, 70, 70);
        
    }
}
