package coobler.model;

import java.io.Serializable;

/**
 * This class store data about positions movement in LAN game
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

    /**
     * Instance of ChosenField class
     */
    public ChosenField() {

        field = TypeOfField.CENTER;
        fillType = FillTypeField.NONE;

        xCenter = -1;
        yCenter = -1;
        xPosition = 0;
        yPosition = 0;
        fill = false;

    }
    
    /**
     * 
     * @return true if center field is filled or 
     * false otherwise
     */
    public boolean isFill() {
        return fill;
    }

    /**
     * 
     * @param aFill sets variable "fill" value true if center field is filled
     * or false otherwise
     */
    public void setFill(boolean aFill) {
        fill = aFill;
    }

    /**
     * 
     * @return fill type
     */
    public FillTypeField getFillType() {
        return fillType;
    }

    /**
     * 
     * @param fType value which set fill type
     */
    public void setFillType(FillTypeField fType) {
        this.fillType = fType;
    }
    
    /**
     * 
     * @return x position of normal field
     */
    public int getX() {
        return this.xPosition;
    }

    /**
     * 
     * @return y position of normal field
     */
    public int getY() {
        return this.yPosition;
    }

    /**
     * 
     * @return x position of center field
     */
    public int getXCenter() {
        return this.xCenter;
    }
    
    /**
     * 
     * @return y position of center field
     */
    public int getYCenter() {
        return this.yCenter;
    }
    
    /**
     * 
     * @return type of field
     */
    public TypeOfField getTypeOfField() {
        return this.field;
    }

    /**
     * 
     * @param x value which set x position normal field
     */
    public void setX(int x) {
        this.xPosition = x;
    }

    /**
     * 
     * @param y value which set x position normal field
     */
    public void setY(int y) {
        this.yPosition = y;
    }

    /**
     * 
     * @param x value which set x position center field
     */
    public void setXCenter(int x) {
        this.xCenter = x;
    }

    /**
     * 
     * @param y value which set x position center field
     */
    public void setYCenter(int y) {
        this.yCenter = y;
    }

    /**
     * 
     * @param aField value which set type of field
     */
    public void setTypeOfField(TypeOfField aField) {
        this.field = aField;
    }
}
