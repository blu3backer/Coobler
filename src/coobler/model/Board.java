package coobler.model;

/**
 * Board class represent board game, all her fields and her size
 * 
 * @author Dawid
 */
public class Board {

    private int sizeBoard;
    private Field[][] horizontalFields;
    private Field[][] verticalFields;
    private Field[][] centerFields;
    /**
     * create instance of Board class and all her fields
     * @param size - board size
     */
    public Board(int size) {
        this.sizeBoard = size;
        
        this.horizontalFields = new Field[this.sizeBoard+1][this.sizeBoard];
        this.verticalFields = new Field[this.sizeBoard][this.sizeBoard+1];
        this.centerFields = new Field[this.sizeBoard][this.sizeBoard];
        
        for (int i = 0; i < this.sizeBoard; i++) {            
            for (int j = 0; j < this.sizeBoard; j++) {
                this.centerFields[i][j] = new Field(TypeOfField.CENTER);
            }
            for (int k = 0; k < this.sizeBoard+1; k++) {
                this.verticalFields[i][k] = new Field(TypeOfField.VERTICAL);
            }
            for (int l = 0; l < this.sizeBoard; l++) {
                this.horizontalFields[i][l] = new Field(TypeOfField.HORIZONTAL);
            }
            
        }
        for (int i = 0; i < this.sizeBoard; i++) {
                this.horizontalFields[this.sizeBoard][i] = new Field(TypeOfField.HORIZONTAL);
            }
        
    }
    public Field[][] getCenterFields() {
        return centerFields;
    }   
    public Field[][] getVerticalFields() {
        return verticalFields;
    }   
    public Field[][] getHorizontalFields() {
        return horizontalFields;
    }   
    
    public int getSizeBoard() {
        return sizeBoard;
    }
    
    
}
