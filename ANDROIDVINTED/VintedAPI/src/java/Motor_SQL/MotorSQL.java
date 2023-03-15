package Motor_SQL;

import Factory.Motor;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MotorSQL implements Motor {

    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String USER = "root";
    private static final String PASS = "";
    private static final String URL
            = "jdbc:mysql://localhost:3306/";
    private static final String DB_NAME = "vinted?";
    private static final String PARAM1 = "useUnicode=true&";
    private static final String PARAM2 = "useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&";
    private static final String PARAM3 = "serverTimezone=UTC";

    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;

    public MotorSQL() {
    }

    public void connect() {

        try {
            Class.forName(DRIVER);
        } catch (Exception e) {
            System.out.println("No se pudo cargar el puente JDBC con phpMyADMIN.");
            return;
        }
        try {
            connection = DriverManager.getConnection(URL + DB_NAME + PARAM1 + PARAM2 + PARAM3, USER, PASS);
            statement = connection.createStatement();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public int executeUpdate(String SQL) {
        int num = 0;
        try {
            num = statement.executeUpdate(SQL);

        } catch (Exception e) {
        }
        return num;
    }

    public void disconnect() {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                resultSet.close();
            }
            if (connection != null) {
                resultSet.close();
            }
            //(resultSet!=null)?resultSet.close():null;
        } catch (SQLException ex) {
            Logger.getLogger(MotorSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int execute(String SQL) {
        int filasModificadas = 0;
        try {
            filasModificadas = statement.executeUpdate(SQL);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return filasModificadas;
    }

    public ResultSet executeQuery(String sql_final) {
        try {
            resultSet = statement.executeQuery(sql_final);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return resultSet;
    }

}
