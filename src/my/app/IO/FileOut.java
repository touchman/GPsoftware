package my.app.IO;

import my.app.GeneralConnector;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class FileOut extends GeneralConnector {

    public FileOut() {

    }

    public FileOut(File filePath){
        try {
            setReader(new BufferedReader(new FileReader(filePath)));
            setExpression(getReader().readLine());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
