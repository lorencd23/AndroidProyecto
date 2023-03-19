
package Factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author LorenzoGalveMuñoz
 */
public interface Motor {
    
    abstract void connect();
    abstract int executeUpdate(String SQL);
    abstract void disconnect();
    abstract int execute(String SQL);
    abstract ResultSet executeQuery(String sql_final);

    //public Object getConnection(String sql_final);
   
    
}
