package my.app.swing;

import my.app.IO.FileOut;
import my.app.switcher.Test;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class MySwing {
    JFrame frame = new JFrame("myCalc");
    JRadioButton binaryButtonIn = new JRadioButton("Binary");
    JRadioButton decimalButtonIn = new JRadioButton("Decimal");
    JRadioButton hexButtonIn = new JRadioButton("Hex");
    JRadioButton binaryButtonOut = new JRadioButton("Binary");
    JRadioButton decimalButtonOut = new JRadioButton("Decimal");
    JRadioButton hexButtonOut = new JRadioButton("Hex");
    JButton evalButton = new JButton("eval");
    JButton openFileButton = new JButton("open file");
    JButton loadDBButton = new JButton("load DB");
    JButton saveFileButton = new JButton("save as");
    JButton updateDBButton = new JButton("update DB");
    //JButton consoleButton = new JButton("console");
    JTextField textAreaIn = new JTextField();
    JTextField textAreaOut = new JTextField();
    JFileChooser fc = new JFileChooser();
    private Test test = new Test();


    public static void main(String[] args) {
        MySwing s = new MySwing();
        s.init();
    }

    public void init() {
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(500, 320);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setLayout(new GridBagLayout());
        decimalButtonIn.setSelected(true);
        decimalButtonOut.setSelected(true);
        decimalButtonIn.addActionListener(new InButtonAction());
        binaryButtonIn.addActionListener(new InButtonAction());
        hexButtonIn.addActionListener(new InButtonAction());
        binaryButtonOut.addActionListener(new OutButtonAction());
        decimalButtonOut.addActionListener(new OutButtonAction());
        hexButtonOut.addActionListener(new OutButtonAction());
        evalButton.addActionListener(new InButtonAction());
        openFileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int returnVal = fc.showOpenDialog(frame);
                if (returnVal == JFileChooser.APPROVE_OPTION)
                {
                    File file = fc.getSelectedFile();
                    FileOut fileOut = new FileOut(file);
                    fileOut.closeReader();
                    textAreaIn.setText(fileOut.getExpression());
                }
                if (returnVal == JFileChooser.CANCEL_OPTION)
                {
                    fc.cancelSelection();
                }
            }
        });
        loadDBButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        saveFileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int returnVal = fc.showOpenDialog(frame);
                if (returnVal == JFileChooser.APPROVE_OPTION)
                {
                    File file = fc.getSelectedFile();
                    FileOut fileOut = new FileOut();
                    fileOut.setExpression(textAreaOut.getText());
                    fileOut.outputFile(file);
                }
                if (returnVal == JFileChooser.CANCEL_OPTION)
                {
                    fc.cancelSelection();
                }
            }
        });
        updateDBButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FileOut fileOut = new FileOut();
                fileOut.setExpression(textAreaIn.getText());
                fileOut.outputDB();
            }
        });
/*        consoleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MyConsole console = new MyConsole();
                textAreaIn.setText(get.Expression());
                try {
                    console.outputConsole();
                } catch (ScriptException e1) {
                    e1.printStackTrace();
                }
            }
        });*/
        frame.add(binaryButtonIn, new GridBagConstraints(0, 1, 1, 1, 1, 0, GridBagConstraints.CENTER, GridBagConstraints.WEST,
                new Insets(2, 2, 2, 2), 10, 10));
        frame.add(decimalButtonIn, new GridBagConstraints(0, 2, 1, 1, 1, 0, GridBagConstraints.CENTER, GridBagConstraints.WEST,
                new Insets(2, 2, 2, 2), 10, 10));
        frame.add(hexButtonIn, new GridBagConstraints(0, 3, 1, 1, 1, 0, GridBagConstraints.CENTER, GridBagConstraints.WEST,
                new Insets(2, 2, 2, 2), 10, 10));
        frame.add(binaryButtonOut, new GridBagConstraints(1, 1, 1, 1, 1, 0, GridBagConstraints.CENTER, GridBagConstraints.EAST,
                new Insets(2, 2, 2, 2), 10, 10));
        frame.add(decimalButtonOut, new GridBagConstraints(1, 2, 1, 1, 1, 0, GridBagConstraints.CENTER, GridBagConstraints.EAST,
                new Insets(2, 2, 2, 2), 10, 10));
        frame.add(hexButtonOut, new GridBagConstraints(1, 3, 1, 1, 1, 0, GridBagConstraints.CENTER, GridBagConstraints.EAST,
                new Insets(2, 2, 2, 2), 10, 10));
        frame.add(textAreaIn, new GridBagConstraints(0, 4, 1, 1, 1, 0, GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(2, 2, 2, 2), 10, 10));
        frame.add(textAreaOut, new GridBagConstraints(1, 4, 1, 1, 1, 0, GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(2, 2, 2, 2), 10, 10));
        frame.add(evalButton, new GridBagConstraints(0, 5, 2, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.VERTICAL,
                new Insets(2, 2, 2, 2), 10, 10));
        frame.add(openFileButton, new GridBagConstraints(0, 6, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.VERTICAL,
                new Insets(2, 2, 2, 2), 10, 10));
        frame.add(loadDBButton, new GridBagConstraints(0, 7, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.VERTICAL,
                new Insets(2, 2, 2, 2), 10, 10));
        frame.add(saveFileButton, new GridBagConstraints(1, 6, 2, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.VERTICAL,
                new Insets(2, 2, 2, 2), 10, 10));
        frame.add(updateDBButton, new GridBagConstraints(1, 7, 2, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.VERTICAL,
                new Insets(2, 2, 2, 2), 10, 10));
/*        frame.add(consoleButton, new GridBagConstraints(1, 8, 2, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.VERTICAL,
                new Insets(2, 2, 2, 2), 10, 10));*/
        frame.setSize(500, 350);
    }

    public class InButtonAction implements ActionListener {

        private ScriptEngine scriptEngine = new ScriptEngineManager().getEngineByName("JavaScript");

        public void actionPerformed(ActionEvent e) {
            if (e.getSource() instanceof JRadioButton) {
                JRadioButton button = (JRadioButton) e.getSource();
                boolean hex = hexButtonIn.isSelected();
                boolean dec = decimalButtonIn.isSelected();
                boolean bin = binaryButtonIn.isSelected();
                hexButtonIn.setSelected(false);
                binaryButtonIn.setSelected(false);
                decimalButtonIn.setSelected(false);
                button.setSelected(true);
                String text = textAreaIn.getText();
                switch (button.getText()) {
                    case "Hex":
                        if(dec){
                            textAreaIn.setText(test.convertDecimalHex(text));
                        } else if(bin){
                            textAreaIn.setText(test.convertBinaryHex(text));
                        }
                        break;
                    case "Decimal":
                        if(hex){
                            textAreaIn.setText(test.convertHexDecimal(text));
                        } else if(bin){
                            textAreaIn.setText(test.convertBinaryDecimal(text));
                        }
                        break;
                    case "Binary":
                        if(dec){
                            textAreaIn.setText(test.convertDecimalBinary(text));
                        } else if(hex){
                            textAreaIn.setText(test.convertHexBinary(text));
                        }
                        break;
                    default:
                        break;
                }
            }
            if (e.getSource() instanceof JButton) {
                String inputText = textAreaIn.getText();
                if (decimalButtonIn.isSelected()) {
                    if (decimalButtonOut.isSelected()) {
                        try {
                            textAreaOut.setText(scriptEngine.eval(inputText).toString());
                        } catch (ScriptException e1) {
                            e1.printStackTrace();
                        }
                    } else if (hexButtonOut.isSelected()) {
                        try {
                            textAreaOut.setText(test.convertDecimalHex(scriptEngine.eval(inputText).toString()));
                        } catch (ScriptException e1) {
                            e1.printStackTrace();
                        }
                    } else {
                        try {
                            textAreaOut.setText(test.convertDecimalBinary(scriptEngine.eval(inputText).toString()));
                        } catch (ScriptException e1) {
                            e1.printStackTrace();
                        }
                    }
                } else if (hexButtonIn.isSelected()) {
                    String hexResult = test.convertHexDecimal(textAreaIn.getText());
                    String result = "";
                    try {
                        result = scriptEngine.eval(hexResult).toString();
                    } catch (ScriptException e1) {
                        e1.printStackTrace();
                    }
                    if (decimalButtonOut.isSelected()) {
                        textAreaOut.setText(result);
                    } else if (hexButtonOut.isSelected()) {
                        textAreaOut.setText(test.convertDecimalHex(result));
                    } else {
                        textAreaOut.setText(test.convertDecimalBinary(result));
                    }
                } else {
                    String binaryResult = test.convertBinaryDecimal(textAreaIn.getText());
                    String result = "";
                    try {
                        result = scriptEngine.eval(binaryResult).toString();
                    } catch (ScriptException e1) {
                        e1.printStackTrace();
                    }
                    if (decimalButtonOut.isSelected()) {
                        textAreaOut.setText(result);
                    } else if (hexButtonOut.isSelected()) {
                        textAreaOut.setText(test.convertDecimalHex(result));
                    } else {
                        textAreaOut.setText(test.convertDecimalBinary(result));
                    }
                }
            }
        }
    }


    public class OutButtonAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() instanceof JRadioButton) {
                JRadioButton button = (JRadioButton) e.getSource();
                boolean hex = hexButtonOut.isSelected();
                boolean dec = decimalButtonOut.isSelected();
                boolean bin = binaryButtonOut.isSelected();
                hexButtonOut.setSelected(false);
                binaryButtonOut.setSelected(false);
                decimalButtonOut.setSelected(false);
                button.setSelected(true);
                String text = textAreaOut.getText();

                switch (button.getText()) {
                    case "Hex":
                        if(dec){
                            textAreaOut.setText(test.convertDecimalHex(text));
                        } else if(bin){
                            textAreaOut.setText(test.convertBinaryHex(text));
                        }
                        return;
                    case "Decimal":
                        if(hex){
                            textAreaOut.setText(test.convertHexDecimal(text));
                        } else if(bin){
                            textAreaOut.setText(test.convertBinaryDecimal(text));
                        }
                        return;
                    case "Binary":
                        if(dec){
                            textAreaOut.setText(test.convertDecimalBinary(text));
                        } else if(hex){
                            textAreaOut.setText(test.convertHexBinary(text));
                        }
                        return;
                    default:
                        return;
                }
            }
        }
    }

}
