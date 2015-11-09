package my.app.DAO;

import my.app.GeneralConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DatabaseOut extends GeneralConnector {
    private List<String> expressions = new ArrayList<>();
    public DatabaseOut() {
        setAppending(true);
        Connection connection = getConnection();
        String sql = "select * from expression where result = 'null'";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet result = statement.executeQuery();
            while(result.next()){
                expressions.add(result.getString("expr"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnecting(connection);
        }
    }

    @Override
    public void outputDB() {
        String sql = "update expression set result = ? where expr = ?";
        Connection connection = getConnection();
        try {
            for (String expression : expressions) {
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setString(1, getScriptEngine().eval(expression).toString());
                statement.setString(2, expression);
                statement.execute();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnecting(connection);
        }
    }

    public List<String> getExpressions() {
        return expressions;
    }

    public void setExpressions(List<String> expressions) {
        this.expressions = expressions;
    }
}
