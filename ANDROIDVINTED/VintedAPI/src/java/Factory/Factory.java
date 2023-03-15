package Factory;

import Motor_SQL.MotorSQL;

/**
 *
 * @author LorenzoGalveMuñoz
 */
public class Factory {
    
    public static int OPCION;

    public Factory() {
    }
    
    public static Motor getInstance(String opcion){
        Motor motor = null;
        
        switch(opcion){
            case "1":
                motor = new MotorSQL();
                break;
        }
        
        return motor;
    } 
    
}
