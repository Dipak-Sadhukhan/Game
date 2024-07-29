
package connectionProvider;

import java.sql.Connection;
import java.sql.DriverManager;


public class CP {
    
    private static Connection con;
    
    public static Connection getConnection()
    {
        try
        {
            // Load The Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            String username = "root";
            String pwd = "dipak";
            String url = "jdbc:mysql://localhost:3306/studentmanagementapp";
            
            con = DriverManager.getConnection(url, username, pwd);
        
        }
        catch(Exception e)
        {
          e.printStackTrace();
        }
        return con;
    }
    
}
