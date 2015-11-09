package my.app.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyDAO {

    public Connection getConnection(){
        String url = "jdbc:mysql://localhost:3306/service";
        Connection connection = null;
        try{
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            connection = DriverManager.getConnection(url, "root", "tz3vs2pf");
        } catch (Exception e){
            e.printStackTrace();
        }
        return connection;
    }

    public void closeConnecting(Connection connection){
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
