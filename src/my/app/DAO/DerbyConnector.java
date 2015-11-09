package my.app.DAO;

import java.sql.*;
import java.util.Properties;

public class DerbyConnector {

    public Connection getConnection() {
        Connection connection = null;
        try {
            Properties props = new Properties();
            props.put("user", "user1");
            props.put("password", "user1");
            connection = DriverManager.getConnection("jdbc:derby:myDB;create=true", props);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }

    public void closeConnection(Connection connection) {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Connection connection = new DerbyConnector().getConnection();
        try {
            PreparedStatement p = connection.prepareStatement("insert into expression(id,expr,result) values (1,'adsasd','werwer')");
            p.execute();
            PreparedStatement ps = connection.prepareStatement("select * from expression");
            ResultSet s = ps.executeQuery();
            while(s.next()){
                System.out.printf("id %d expression %s result %s", s.getInt("id"), s.getString("expr"), s.getString("result"));
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void create() {
        Connection connection = new DerbyConnector().getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement("create table expression(id int, expr varchar(40), result VARCHAR(40))");
            ps.execute();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void selectAll(){
        Connection connection = new DerbyConnector().getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement("select * from expression");
            ResultSet s = ps.executeQuery();
            while(s.next()){
                System.out.printf("id %d expression %s result %s", s.getInt("id"), s.getString("expr"), s.getString("result"));
            }
            ps.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insert(){
        Connection connection = new DerbyConnector().getConnection();
        try {
            PreparedStatement p = connection.prepareStatement("insert into expression(id,expr,result) values (1,'adsasd','werwer')");
            p.execute();
            p.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}

