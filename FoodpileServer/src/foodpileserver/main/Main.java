package foodpileserver.main;

/**
 *
 * @author SHRESHTH
 */
import foodpileserver.constants.RequestCode;
import foodpileserver.sql.MysqlConnection;
import foodpileserver.sql.SystemProperties;

import java.sql.Connection;
import java.io.IOException;

public class Main  {
    
    
    
    public static String user= SystemProperties.getMySQLUserName();
    public static String password=SystemProperties.getMySQLPassword();
    public static String host=SystemProperties.getMySQLHostName();//"jdbc:mysql://localhost:3306/Distribution";
    public static Connection connection = MysqlConnection.connect();
    public static void main(String args[]){
        
    }
}
