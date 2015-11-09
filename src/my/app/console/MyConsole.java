package my.app.console;

import my.app.GeneralConnector;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MyConsole extends GeneralConnector {
    public MyConsole(){
        setReader(new BufferedReader(new InputStreamReader(System.in)));
        try {
            setExpression(getReader().readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
