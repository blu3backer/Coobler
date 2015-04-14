
package coobler.model;

/**
 * Field class is board field definition. 
 * These fields can be in two different states EMPTY or FILL and three different type HORIZONTAL,VERTICAL,CENTER
 * Field class contains only "get" and "set" metods
 *
 * @author Dawid
 */
public class Field {
    private StateOfField fieldState;
    private TypeOfField fieldType;
    
    
    
    /**
     * Creates new field on the board
     * @param type field type
     */
    public Field(TypeOfField type){
        this.fieldState = StateOfField.EMPTY;
        this.fieldType = type;
        
    }
    
   public StateOfField getStateOfField()
   {
       return this.fieldState;
   }
 
   public void setStateOfField(StateOfField aFieldState)
   {
       this.fieldState = aFieldState;
   }
   
   public TypeOfField getTypeOfField()
   {
       return this.fieldType;
   }
 
   
}
