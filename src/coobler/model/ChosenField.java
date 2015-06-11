package coobler.model;

import java.io.Serializable;

/**
 *
 * @author Dawid
 */
public class ChosenField implements Serializable {

    private TypeOfField field;
    private FillTypeField fillType;

    private int xPosition;
    private int yPosition;

    private boolean fill;
    private int xCenter;
    private int yCenter;

    public ChosenField() {

        field = TypeOfField.CENTER;
        fillType = FillTypeField.NONE;

        xCenter = -1;
        yCenter = -1;
        xPosition = 0;
        yPosition = 0;
        fill = false;

    }

    public boolean isFill() {
        return fill;
    }

    public void setFill(boolean aFill) {
        fill = aFill;
    }

    public FillTypeField getFillType() {
        return fillType;
    }

    public void setFillType(FillTypeField fType) {
        this.fillType = fType;
    }

    public int getX() {
        return this.xPosition;
    }

    public int getY() {
        return this.yPosition;
    }

    public int getXCenter() {
        return this.xCenter;
    }

    public int getYCenter() {
        return this.yCenter;
    }

    public TypeOfField getTypeOfField() {
        return this.field;
    }

    public void setX(int x) {
        this.xPosition = x;
    }

    public void setY(int y) {
        this.yPosition = y;
    }

    public void setXCenter(int x) {
        this.xCenter = x;
    }

    public void setYCenter(int y) {
        this.yCenter = y;
    }

    public void setTypeOfField(TypeOfField aField) {
        this.field = aField;
    }
}
