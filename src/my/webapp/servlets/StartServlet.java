package my.webapp.servlets;

import my.app.IO.FileOut;
import my.app.switcher.Test;

import javax.script.ScriptException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

public class StartServlet extends Dispatcher {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Test test = new Test();
        FileOut fileOut = new FileOut();
        String expression = req.getParameter("expression");
        String result = "";
            try {
                if(expression.equals("")){
                    result = "";
                } else result = fileOut.getScriptEngine().eval(expression).toString();
            } catch (ScriptException e) {
                e.printStackTrace();
            }
        String action = req.getParameter("enter");

        if ("eval".equals(action)) {
            if(expression.contains("+")) expression = expression.replaceAll("\\+", "%2B");
            super.forward("/index.jsp?expression=" + expression + "&result=" + result, req, resp);
        } else if ("load".equals(action)) {
            FileOut secondFile = new FileOut(new File("e:/d.txt"));
            String sexpression = secondFile.getExpression();
            secondFile.closeReader();
            try {
                result = fileOut.getScriptEngine().eval(sexpression).toString();
            } catch (ScriptException e) {
                e.printStackTrace();
            }
            if(sexpression.contains("+")) sexpression = sexpression.replaceAll("\\+", "%2B");
            super.forward("/index.jsp?expression=" + sexpression + "&result=" + result, req, resp);
        } else if ("save".equals(action)) {
            fileOut.setExpression(result);
            fileOut.outputFile(new File("e:/data.txt"));
            if(expression.contains("+")) expression = expression.replaceAll("\\+", "%2B");
            super.forward("/index.jsp?expression=" + expression + "&result=" + result, req, resp);
        } else if ("insert".equals(action)) {
            fileOut.setExpression(expression);
            fileOut.outputDB();
            if(expression.contains("+")) expression = expression.replaceAll("\\+", "%2B");
            super.forward("/index.jsp?expression=" + expression + "&result=" + result, req, resp);
        }
    }

    public static void main(String[] args) {
        String expression = "2+4";

        expression = expression.replaceAll("\\+", "%2B");
        System.out.println(expression);
    }
}
