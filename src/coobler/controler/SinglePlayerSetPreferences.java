package coobler.controler;

import coobler.view.SingleChoser;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JColorChooser;

/**
 * SinglePlayerSetPreferences class implements MouseListener supports 
 * clicked or entered buttons in single player mode.
 *
 * @author Dawid
 */
public class SinglePlayerSetPreferences implements MouseListener {

    private SingleChoser singleChoser;
    /**
     * creates new instance of SinglePlaterSetPreferences class
     * @param aSingleChoser is using to retrive the components from single player menu
     */
    public SinglePlayerSetPreferences(SingleChoser aSingleChoser) {
        this.singleChoser = aSingleChoser;
        this.singleChoser.getFirstColorChoserButton().addMouseListener(this);
        this.singleChoser.getOkButton().addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        ;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getSource() == singleChoser.getFirstColorChoserButton()) {
            singleChoser.getFirstColorChoserButton().setIcon(new ImageIcon("grph/clickedChoseButton.png"));

        } else if (e.getSource() == singleChoser.getOkButton()) {
            singleChoser.getOkButton().setIcon(new ImageIcon("grph/clickedOkButton.png"));
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (e.getSource() == singleChoser.getFirstColorChoserButton()) {
            singleChoser.getFirstColorChoserButton().setIcon(new ImageIcon("grph/enteredChoseButton.png"));
            singleChoser.setFirstColor(JColorChooser.showDialog(null, "Color choser", singleChoser.getFirstColor()));
            singleChoser.getShowFirstColorChoserButton().setBackground(singleChoser.getFirstColor());

        } else if (e.getSource() == singleChoser.getOkButton()) {
            singleChoser.getOkButton().setIcon(new ImageIcon("grph/enteredOkButton.png"));
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if (e.getSource() == singleChoser.getFirstColorChoserButton()) {
            singleChoser.getFirstColorChoserButton().setIcon(new ImageIcon("grph/enteredChoseButton.png"));

        } else if (e.getSource() == singleChoser.getOkButton()) {
            singleChoser.getOkButton().setIcon(new ImageIcon("grph/enteredOkButton.png"));
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource() == singleChoser.getFirstColorChoserButton()) {
            singleChoser.getFirstColorChoserButton().setIcon(new ImageIcon("grph/choseButton.png"));

        } else if (e.getSource() == singleChoser.getOkButton()) {
            singleChoser.getOkButton().setIcon(new ImageIcon("grph/okButton.png"));
        }
    }

}
