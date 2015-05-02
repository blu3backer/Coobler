
package coobler.controler;

import coobler.view.Board;
import coobler.view.MainWindow;
import coobler.view.MultiChoser;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JColorChooser;

/**
 * MultiPlayerSetPreferences class implements MouseListener supports clicked 
 * or entered buttons in multi player mode. 
 * 
 * @author Dawid
 */
public class MultiplayerSetPreferences implements MouseListener {

    private MultiChoser multiChoser;
    private GameHandling gameHandling;
    private Board board;
    private MainWindow mainWindow;

    /**
     * creates new instance of MultiPlayerSetPreferences class
     * @param aMultiChoser is using to retrive the components from multi player menu
     */
    public MultiplayerSetPreferences(MultiChoser aMultiChoser,MainWindow aMainWindow) {
        this.multiChoser = aMultiChoser;
        this.board = new Board(multiChoser);
        this.mainWindow = aMainWindow;
        this.gameHandling = new GameHandling(multiChoser,board);
        this.multiChoser.getFirstColorChoserButton().addMouseListener(this);
        this.multiChoser.getSecondColorChoserButton().addMouseListener(this);
        this.multiChoser.getOkButton().addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        ;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getSource() == multiChoser.getFirstColorChoserButton()) {
            multiChoser.getFirstColorChoserButton().setIcon(new ImageIcon("grph/clickedChoseButton.png"));

        }else if (e.getSource() == multiChoser.getSecondColorChoserButton()) {
            multiChoser.getSecondColorChoserButton().setIcon(new ImageIcon("grph/clickedChoseButton.png"));

        }else if (e.getSource() == multiChoser.getOkButton()) {
            multiChoser.getOkButton().setIcon(new ImageIcon("grph/clickedOkButton.png"));
            
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (e.getSource() == multiChoser.getFirstColorChoserButton()) {
            multiChoser.getFirstColorChoserButton().setIcon(new ImageIcon("grph/enteredChoseButton.png"));
            multiChoser.setFirstColor(JColorChooser.showDialog(null, "Color choser", multiChoser.getFirstColor()));
            multiChoser.getShowFirstColorChoserButton().setBackground(multiChoser.getFirstColor());

        }else if (e.getSource() == multiChoser.getSecondColorChoserButton()) {
           multiChoser.getSecondColorChoserButton().setIcon(new ImageIcon("grph/enteredChoseButton.png"));
            multiChoser.setSecondColor(JColorChooser.showDialog(null, "Color choser", multiChoser.getSecondColor()));
            multiChoser.getShowSecondColorChoserButton().setBackground(multiChoser.getSecondColor());

        }else if (e.getSource() == multiChoser.getOkButton()) {
            multiChoser.getOkButton().setIcon(new ImageIcon("grph/enteredOkButton.png"));
            multiChoser.setVisible(false);
            board.setVisible(true);
            mainWindow.getPanel().removeAll();            
            mainWindow.setPanel(board);              
            mainWindow.repaint();
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if (e.getSource() == multiChoser.getFirstColorChoserButton()) {
            multiChoser.getFirstColorChoserButton().setIcon(new ImageIcon("grph/enteredChoseButton.png"));

        }else if (e.getSource() == multiChoser.getSecondColorChoserButton()) {
            multiChoser.getSecondColorChoserButton().setIcon(new ImageIcon("grph/enteredChoseButton.png"));

        }else if (e.getSource() == multiChoser.getOkButton()) {
            multiChoser.getOkButton().setIcon(new ImageIcon("grph/enteredOkButton.png"));
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource() == multiChoser.getFirstColorChoserButton()) {
            multiChoser.getFirstColorChoserButton().setIcon(new ImageIcon("grph/choseButton.png"));

        }else if (e.getSource() == multiChoser.getSecondColorChoserButton()) {
            multiChoser.getSecondColorChoserButton().setIcon(new ImageIcon("grph/choseButton.png"));

        }else if (e.getSource() == multiChoser.getOkButton()) {
            multiChoser.getOkButton().setIcon(new ImageIcon("grph/okButton.png"));
        }
    }

}
