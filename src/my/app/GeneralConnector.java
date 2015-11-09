package my.app;

import my.app.DAO.MyDAO;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

public abstract class GeneralConnector extends MyDAO {
    private ScriptEngineManager sem = new ScriptEngineManager();
    private ScriptEngine scriptEngine = sem.getEngineByName("JavaScript");
    private BufferedReader reader;
    private boolean appending = false;
    private String expression;


    public void outputConsole() throws ScriptException {
        //System.out.println(scriptEngine.eval(expression));
        System.out.println(expression);
    }

    public void outputFile(File filePath){
        try(FileWriter fileWriter = new FileWriter(filePath, appending)) {
            //char[] c =(scriptEngine.eval(expression)).toString().replaceAll(".0", "").toCharArray();
            char[] c = expression.toCharArray();
            fileWriter.write(c);
            fileWriter.write(String.format("%n").toCharArray());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void outputDB(){
        String sql = "insert into expression(expr, result) values (?,?)";
        Connection connection = getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, expression);
            preparedStatement.setString(2, scriptEngine.eval(expression).toString().replaceAll(".0", ""));
            preparedStatement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnecting(connection);
        }
    }

    public void closeReader(){
        try {
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean isAppending() {
        return appending;
    }

    public void setAppending(boolean appending) {
        this.appending = appending;
    }

    public BufferedReader getReader() {
        return reader;
    }

    public void setReader(BufferedReader reader) {
        this.reader = reader;
    }

    public String getExpression() {
        return expression;
    }

    public ScriptEngine getScriptEngine() {
        return scriptEngine;
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }
}
