
package examseatingarrangement;

import java.sql.*;
import java.sql.ResultSet;


public class ConnectionClass {
    
    Connection con;
    Statement stm;
    
    ConnectionClass()
    {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/examseatingarrangement","root","1234");
            stm=con.createStatement();
        
        }
        catch(Exception e){
            
            e.printStackTrace();
        
        }
        
    }
    public static void main(String[] args){
        new ConnectionClass();
    }
}

