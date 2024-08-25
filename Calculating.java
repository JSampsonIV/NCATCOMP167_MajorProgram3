/*
John Sampson
5-1-2024
COMP 167-004
Creating a calculator application using Java's Swing package
*/
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculating implements ActionListener {
    GridBagConstraints layoutConst;
    JPanel screenPanel, buttonPanel;
    JFrame calcFrame;
    JTextField inputScreen, outputScreen;
    JButton num0Button, num1Button, num2Button, num3Button, num4Button, num5Button, num6Button, num7Button, num8Button, num9Button;
    JButton[] numButtons = new JButton[10];//each button is grouped into an array
    JButton plusButton, minusButton, multiplyButton, divideButton, modulusButton, equalsButton;
    JButton[] operatorButtons = new JButton[6];
    JButton percentButton, decimalButton, negativeButton;
    JButton[] modifierButtons = new JButton[3];
    JButton squareButton, cubeButton;
    JButton[] powerButtons = new JButton[2];
    JButton oneOverButton, sqrtButton;
    JButton[] dataManipButtons = new JButton[2];
    JButton logButton, lnButton;
    JButton[] logButtons = new JButton[2];
    JButton sinButton, cosButton, tanButton, asinButton, acosButton, atanButton, sinhButton, coshButton, tanhButton;
    JButton[] trigButtons = new JButton[9];
    JButton clearButton, exitButton;
    JButton[] miscButtons = new JButton[2];
    Border textBorder = BorderFactory.createLineBorder(new Color(0,100,50));
    double result;
    Calculating(){
        layoutConst = new GridBagConstraints();
        //building the calculator frame
        calcFrame = new JFrame();
        calcFrame.setTitle("JLS-4 Plus CE: Java Edition");//a play on the TI-84
        calcFrame.setLayout(new GridBagLayout());
        calcFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //I am using JPanels to position the screen and buttons to be right on top of each other
        //previously, the screen either had to be to the side or would separate buttons
        screenPanel = new JPanel();
        screenPanel.setLayout(new GridBagLayout());
        screenPanel.setBounds(0,0,1000,1000);
        layoutConst.gridx = 0;
        layoutConst.gridy = 0;
        calcFrame.add(screenPanel, layoutConst);

        buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridBagLayout());
        buttonPanel.setBounds(0,0,1000,1000);
        layoutConst.gridx = 0;
        layoutConst.gridy = 1;
        calcFrame.add(buttonPanel, layoutConst);


        //calculator screens
        inputScreen = new JTextField("",15);
        inputScreen.setEditable(false);
        inputScreen.setVisible(true);
        inputScreen.setHorizontalAlignment(SwingConstants.RIGHT);
        inputScreen.setFont(new Font("Arial", Font.BOLD, 21));
        inputScreen.setBackground(new Color(0, 250, 0));
        inputScreen.setBorder(textBorder);
        layoutConst.gridx = 10;
        layoutConst.gridy = 1;
        layoutConst.insets = new Insets(0, 0, 0, 0);
        screenPanel.add(inputScreen, layoutConst);

        outputScreen = new JTextField("",15);
        outputScreen.setEditable(false);
        outputScreen.setVisible(true);
        outputScreen.setHorizontalAlignment(SwingConstants.RIGHT);
        outputScreen.setFont(new Font("Arial", Font.BOLD, 21));
        outputScreen.setBackground(new Color(0, 250, 0));
        outputScreen.setBorder(textBorder);
        layoutConst.gridx = 10;
        layoutConst.gridy = 0;
        layoutConst.insets = new Insets(0, 0, 0, 0);
        screenPanel.add(outputScreen, layoutConst);

        //number buttons, ordered from top left
        num7Button = new JButton("7");
        layoutConst.gridx = 0;
        layoutConst.gridy = 2;
        layoutConst.insets = new Insets(5, 5, 5, 5);
        num7Button.addActionListener(this);
        buttonPanel.add(num7Button, layoutConst);
        numButtons[7] = num7Button;

        num8Button = new JButton("8");
        layoutConst.gridx = 1;
        layoutConst.gridy = 2;
        layoutConst.insets = new Insets(5, 5, 5, 5);
        num8Button.addActionListener(this);
        buttonPanel.add(num8Button, layoutConst);
        numButtons[8] = num8Button;

        num9Button = new JButton("9");
        layoutConst.gridx = 2;
        layoutConst.gridy = 2;
        layoutConst.insets = new Insets(5, 5, 5, 5);
        num9Button.addActionListener(this);
        buttonPanel.add(num9Button, layoutConst);
        numButtons[9] = num9Button;

        num4Button = new JButton("4");
        layoutConst.gridx = 0;
        layoutConst.gridy = 3;
        layoutConst.insets = new Insets(5, 5, 5, 5);
        num4Button.addActionListener(this);
        buttonPanel.add(num4Button, layoutConst);
        numButtons[4] = num4Button;

        num5Button = new JButton("5");
        layoutConst.gridx = 1;
        layoutConst.gridy = 3;
        layoutConst.insets = new Insets(5, 5, 5, 5);
        num5Button.addActionListener(this);
        buttonPanel.add(num5Button, layoutConst);
        numButtons[5] = num5Button;

        num6Button = new JButton("6");
        layoutConst.gridx = 2;
        layoutConst.gridy = 3;
        layoutConst.insets = new Insets(5, 5, 5, 5);
        num6Button.addActionListener(this);
        buttonPanel.add(num6Button, layoutConst);
        numButtons[6] = num6Button;

        num1Button = new JButton("1");
        layoutConst.gridx = 0;
        layoutConst.gridy = 4;
        layoutConst.insets = new Insets(5, 5, 5, 5);
        num1Button.addActionListener(this);
        buttonPanel.add(num1Button, layoutConst);
        numButtons[1] = num1Button;

        num2Button = new JButton("2");
        layoutConst.gridx = 1;
        layoutConst.gridy = 4;
        layoutConst.insets = new Insets(5, 5, 5, 5);
        num2Button.addActionListener(this);
        buttonPanel.add(num2Button, layoutConst);
        numButtons[2] = num2Button;

        num3Button = new JButton("3");
        layoutConst.gridx = 2;
        layoutConst.gridy = 4;
        layoutConst.insets = new Insets(5, 5, 5, 5);
        num3Button.addActionListener(this);
        buttonPanel.add(num3Button, layoutConst);
        numButtons[3] = num3Button;

        num0Button = new JButton("0");
        layoutConst.gridx = 0;
        layoutConst.gridy = 5;
        layoutConst.insets = new Insets(5, 5, 5, 5);
        num0Button.addActionListener(this);
        buttonPanel.add(num0Button, layoutConst);
        numButtons[0] = num0Button;

        //smooth operators
        plusButton = new JButton("+");
        layoutConst.gridx = 3;
        layoutConst.gridy = 5;
        layoutConst.insets = new Insets(5, 5, 5, 5);
        plusButton.addActionListener(this);
        buttonPanel.add(plusButton, layoutConst);
        operatorButtons[0] = plusButton;

        minusButton = new JButton("-");
        layoutConst.gridx = 3;
        layoutConst.gridy = 4;
        layoutConst.insets = new Insets(5, 5, 5, 5);
        minusButton.addActionListener(this);
        buttonPanel.add(minusButton, layoutConst);
        operatorButtons[1] = minusButton;

        multiplyButton = new JButton("*");
        layoutConst.gridx = 3;
        layoutConst.gridy = 3;
        layoutConst.insets = new Insets(5, 5, 5, 5);
        multiplyButton.addActionListener(this);
        buttonPanel.add(multiplyButton, layoutConst);
        operatorButtons[2] = multiplyButton;

        divideButton = new JButton("/");
        layoutConst.gridx = 3;
        layoutConst.gridy = 2;
        layoutConst.insets = new Insets(5, 5, 5, 5);
        divideButton.addActionListener(this);
        buttonPanel.add(divideButton, layoutConst);
        operatorButtons[3] = divideButton;

        modulusButton = new JButton("MOD");
        layoutConst.gridx = 3;
        layoutConst.gridy = 6;
        layoutConst.insets = new Insets(5, 5, 5, 5);
        modulusButton.addActionListener(this);
        buttonPanel.add(modulusButton, layoutConst);
        operatorButtons[4] = modulusButton;

        equalsButton = new JButton("=");
        layoutConst.gridx = 3;
        layoutConst.gridy = 10;
        layoutConst.insets = new Insets(5, 5, 5, 5);
        equalsButton.addActionListener(this);
        buttonPanel.add(equalsButton, layoutConst);
        operatorButtons[5] = equalsButton;

        //modifiers
        decimalButton = new JButton(".");
        layoutConst.gridx = 1;
        layoutConst.gridy = 5;
        layoutConst.insets = new Insets(5, 5, 5, 5);
        decimalButton.addActionListener(this);
        buttonPanel.add(decimalButton, layoutConst);
        modifierButtons[0] = decimalButton;

        negativeButton = new JButton("+/-");
        layoutConst.gridx = 2;
        layoutConst.gridy = 5;
        layoutConst.insets = new Insets(5, 5, 5, 5);
        negativeButton.addActionListener(this);
        buttonPanel.add(negativeButton, layoutConst);
        modifierButtons[1] = negativeButton;

        percentButton = new JButton("%");
        layoutConst.gridx = 0;
        layoutConst.gridy = 6;
        layoutConst.insets = new Insets(5, 5, 5, 5);
        percentButton.addActionListener(this);
        buttonPanel.add(percentButton, layoutConst);
        modifierButtons[2] = percentButton;

        //power buttons
        squareButton = new JButton("x^2");
        layoutConst.gridx = 0;
        layoutConst.gridy = 7;
        layoutConst.insets = new Insets(5, 5, 5, 5);
        squareButton.addActionListener(this);
        buttonPanel.add(squareButton, layoutConst);
        powerButtons[0] = squareButton;

        cubeButton = new JButton("x^3");
        layoutConst.gridx = 1;
        layoutConst.gridy = 7;
        layoutConst.insets = new Insets(5, 5, 5, 5);
        cubeButton.addActionListener(this);
        buttonPanel.add(cubeButton, layoutConst);
        powerButtons[1] = cubeButton;

        //data manipulation
        oneOverButton = new JButton("1/x");
        layoutConst.gridx = 2;
        layoutConst.gridy = 7;
        layoutConst.insets = new Insets(5, 5, 5, 5);
        oneOverButton.addActionListener(this);
        buttonPanel.add(oneOverButton, layoutConst);
        dataManipButtons[0] = oneOverButton;

        sqrtButton = new JButton("√x");
        layoutConst.gridx = 3;
        layoutConst.gridy = 7;
        layoutConst.insets = new Insets(5, 5, 5, 5);
        sqrtButton.addActionListener(this);
        buttonPanel.add(sqrtButton, layoutConst);
        dataManipButtons[1] = sqrtButton;

        //log buttons
        logButton = new JButton("log");
        layoutConst.gridx = 3;
        layoutConst.gridy = 8;
        layoutConst.insets = new Insets(5, 5, 5, 5);
        logButton.addActionListener(this);
        buttonPanel.add(logButton, layoutConst);
        logButtons[0] = logButton;

        lnButton = new JButton("ln");
        layoutConst.gridx = 3;
        layoutConst.gridy = 9;
        layoutConst.insets = new Insets(5, 5, 5, 5);
        lnButton.addActionListener(this);
        buttonPanel.add(lnButton, layoutConst);
        logButtons[1] = lnButton;

        //trig buttons
        sinButton = new JButton("sin");
        layoutConst.gridx = 0;
        layoutConst.gridy = 8;
        layoutConst.insets = new Insets(5, 5, 5, 5);
        sinButton.addActionListener(this);
        buttonPanel.add(sinButton, layoutConst);
        trigButtons[0] = sinButton;

        cosButton = new JButton("cos");
        layoutConst.gridx = 1;
        layoutConst.gridy = 8;
        layoutConst.insets = new Insets(5, 5, 5, 5);
        cosButton.addActionListener(this);
        buttonPanel.add(cosButton, layoutConst);
        trigButtons[1] = cosButton;

        tanButton = new JButton("tan");
        layoutConst.gridx = 2;
        layoutConst.gridy = 8;
        layoutConst.insets = new Insets(5, 5, 5, 5);
        tanButton.addActionListener(this);
        buttonPanel.add(tanButton, layoutConst);
        trigButtons[2] = tanButton;

        asinButton = new JButton("asin");
        layoutConst.gridx = 0;
        layoutConst.gridy = 9;
        layoutConst.insets = new Insets(5, 5, 5, 5);
        asinButton.addActionListener(this);
        buttonPanel.add(asinButton, layoutConst);
        trigButtons[3] = asinButton;

        acosButton = new JButton("acos");
        layoutConst.gridx = 1;
        layoutConst.gridy = 9;
        layoutConst.insets = new Insets(5, 5, 5, 5);
        acosButton.addActionListener(this);
        buttonPanel.add(acosButton, layoutConst);
        trigButtons[4] = acosButton;

        atanButton = new JButton("atan");
        layoutConst.gridx = 2;
        layoutConst.gridy = 9;
        layoutConst.insets = new Insets(5, 5, 5, 5);
        atanButton.addActionListener(this);
        buttonPanel.add(atanButton, layoutConst);
        trigButtons[5] = atanButton;

        sinhButton = new JButton("sinh");
        layoutConst.gridx = 0;
        layoutConst.gridy = 10;
        layoutConst.insets = new Insets(5, 5, 5, 5);
        sinhButton.addActionListener(this);
        buttonPanel.add(sinhButton, layoutConst);
        trigButtons[6] = sinhButton;

        coshButton = new JButton("cosh");
        layoutConst.gridx = 1;
        layoutConst.gridy = 10;
        layoutConst.insets = new Insets(5, 5, 5, 5);
        coshButton.addActionListener(this);
        buttonPanel.add(coshButton, layoutConst);
        trigButtons[7] = coshButton;

        tanhButton = new JButton("tanh");
        layoutConst.gridx = 2;
        layoutConst.gridy = 10;
        layoutConst.insets = new Insets(5, 5, 5, 5);
        tanhButton.addActionListener(this);
        buttonPanel.add(tanhButton, layoutConst);
        trigButtons[8] = tanhButton;

        //misc buttons
        clearButton = new JButton("C");
        layoutConst.gridx = 1;
        layoutConst.gridy = 6;
        layoutConst.insets = new Insets(5, 5, 5, 5);
        clearButton.addActionListener(this);
        buttonPanel.add(clearButton, layoutConst);
        miscButtons[0] = clearButton;

        exitButton = new JButton("EXIT");
        layoutConst.gridx = 2;
        layoutConst.gridy = 6;
        layoutConst.insets = new Insets(5, 5, 5, 5);
        exitButton.addActionListener(this);
        buttonPanel.add(exitButton, layoutConst);
        miscButtons[1] = exitButton;

        //creating the visible frame
        calcFrame.pack();
        //calcFrame.setSize(576, 1024);//this is a 9:16 ratio, and I just like the number 1024
        calcFrame.setVisible(true);
    }

    public static void main(String[] args) {
        Calculating calculator = new Calculating();
    }

    @Override
    public void actionPerformed(ActionEvent buttonPressed) {
        for (JButton numButton : numButtons) {
            if (buttonPressed.getActionCommand().equals(numButton.getActionCommand())) {
                String screenText = inputScreen.getText();
                inputScreen.setText(screenText + buttonPressed.getActionCommand());//add te number to the end of the bottom screen
                if ((outputScreen.getText().equals(Double.toString(result))) || (outputScreen.getText().equals(Integer.toString((int) result))) || (outputScreen.getText().contains("ERR:"))) {//if te only thing in the output
                     result = 0.0;
                    outputScreen.setText("");
                }
            }
        }
        for (JButton operatorButton : operatorButtons) {
            if (buttonPressed.getActionCommand().equals(operatorButton.getActionCommand())) {
                String inputScreenText = inputScreen.getText();
                inputScreen.setText("");
                if (inputScreenText.isEmpty()) {
                    if (buttonPressed.getActionCommand().equals("=")) {
                        if (result == (int) result) {
                            outputScreen.setText(Integer.toString((int) result));
                        } else {
                            outputScreen.setText(Double.toString(result));
                        }
                    }
                    else if (!outputScreen.getText().isEmpty()) {
                        if (result == (int) result) {
                            outputScreen.setText((int) result + " " + buttonPressed.getActionCommand());
                        }
                        else {
                            outputScreen.setText(result + " " + buttonPressed.getActionCommand());
                        }
                    }
                }
                else if (!buttonPressed.getActionCommand().equals("=")) {
                    if (outputScreen.getText().isEmpty()) {
                        outputScreen.setText(inputScreenText + " " + buttonPressed.getActionCommand());
                        String outputScreenText = outputScreen.getText();
                        result += Double.parseDouble(outputScreenText.substring(0, outputScreenText.indexOf(" ")));
                    }
                    else {
                        if (result == (int) result) {
                            outputScreen.setText((int) result + " " + buttonPressed.getActionCommand());
                        } else {
                            outputScreen.setText(result + " " + buttonPressed.getActionCommand());
                        }
                    }
                }
                else {//if equals is entered
                    try {
                        String operation = outputScreen.getText().substring(outputScreen.getText().length() - 1);
                        switch (operation) {
                            case "+":
                                result += Double.parseDouble(inputScreenText);
                                break;
                            case "-":
                                result -= Double.parseDouble(inputScreenText);
                                break;
                            case "*":
                                result *= Double.parseDouble(inputScreenText);
                                break;
                            case "/":
                                if (inputScreenText.equals("0")) {
                                    throw new ArithmeticException("Cannot divide by zero");
                                }
                                result /= Double.parseDouble(inputScreenText);
                                break;
                            case "D"://the end of MOD
                                if (inputScreenText.equals("0")) {
                                    throw new ArithmeticException("Cannot divide by zero");
                                }
                                try {
                                    result %= Integer.parseInt(inputScreenText);
                                    result = Math.abs(result);
                                }
                                catch (NumberFormatException n) {
                                    throw new NumberFormatException("ERR: Decimal modulo not allowed");
                                }
                                break;
                            case "f"://end of '% of'
                                int percentIndex = outputScreen.getText().indexOf("%");
                                double percentage = Double.parseDouble(outputScreen.getText().substring(0, percentIndex));
                                result = Double.parseDouble(inputScreenText);
                                result *= 0.01 * percentage;
                                if (result == (int) result) {
                                    outputScreen.setText(Integer.toString((int) result));
                                } else {
                                    outputScreen.setText(Double.toString(result));
                                }
                        }
                        if (result == (int) result) {
                            outputScreen.setText(Integer.toString((int) result));
                        } else {
                            outputScreen.setText(Double.toString(result));
                        }
                    }
                    catch (ArithmeticException | NumberFormatException e) {//IntelliJ suggested collapsing the previously identical catch blacks
                        outputScreen.setText(e.getMessage());
                    }
                    catch (StringIndexOutOfBoundsException s){//output screen is empty, just set it to whatever is in output screen
                        result = Double.parseDouble(inputScreenText);
                        if (result == (int) result) {
                            outputScreen.setText(Integer.toString((int) result));
                        } else {
                            outputScreen.setText(Double.toString(result));
                        }
                    }
                }
            }
        }
        for (JButton modifierButton : modifierButtons) {
            if (buttonPressed.getActionCommand().equals(modifierButton.getActionCommand())) {//percent, decimal, and negative
                String screenText = inputScreen.getText();
                switch (buttonPressed.getActionCommand()) {
                    case ".":
                        if (!inputScreen.getText().contains(".")) {
                            inputScreen.setText(screenText + buttonPressed.getActionCommand());
                        }
                        else {
                            int decimalIndex = inputScreen.getText().indexOf(".");
                            inputScreen.setText(inputScreen.getText().substring(0, decimalIndex) + inputScreen.getText().substring(decimalIndex+1) + ".");
                        }
                        break;
                    case "%":
                        if (outputScreen.getText().isEmpty()) {
                            if (!inputScreen.getText().isEmpty()) {
                                outputScreen.setText(inputScreen.getText() + "% of");
                                inputScreen.setText("");
                            }
                        }
                        else {//+/- does x% of y, */'/' multiplies by 0.01
                            String inputScreenText = inputScreen.getText();
                            String operation = outputScreen.getText().substring(outputScreen.getText().length() - 1);//grab last character, the operator
                            switch (operation) {
                                case "+":
                                case "-":
                                    double percentage = (result / 100) * Double.parseDouble(inputScreenText);
                                    if ((int) percentage == percentage) {
                                        inputScreen.setText(Integer.toString((int) percentage));
                                    } else {
                                        inputScreen.setText(Double.toString(percentage));
                                    }
                                    break;
                                case "*":
                                case "/":
                                case "D"://the end of MOD
                                    percentage = (Double.parseDouble(inputScreen.getText()) / 100);
                                    if ((int) percentage == percentage) {
                                        inputScreen.setText(Integer.toString((int) percentage));
                                    } else {
                                        inputScreen.setText(Double.toString(percentage));
                                    }
                                    break;
                            }
                        }
                        break;
                    case "+/-":
                        if (!outputScreen.getText().isEmpty()){
                            try {
                                if ((Double.parseDouble(outputScreen.getText()) == result) || (outputScreen.getText().contains("ERR:"))) {
                                    outputScreen.setText("");
                                    result = 0;
                                }
                            }
                            catch (NumberFormatException n){
                                //the below if/else does the correct operation, this just needs to "handle" the error
                            }
                        }
                        if (inputScreen.getText().isEmpty()) {
                            inputScreen.setText("-");
                        }
                        else {
                            if (inputScreen.getText().charAt(0) == '-') {
                                inputScreen.setText(inputScreen.getText().substring(1));
                            }
                            else {
                                inputScreen.setText("-" + inputScreen.getText());
                            }
                        }
                        break;
                }
            }
        }
        for (JButton powerButton : powerButtons) {
            if (buttonPressed.getActionCommand().equals(powerButton.getActionCommand())) {
                switch (buttonPressed.getActionCommand()) {
                    case "x^2":
                        if (outputScreen.getText().isEmpty()) {
                            if (!inputScreen.getText().isEmpty()) {
                                try {
                                    result = Double.parseDouble(inputScreen.getText());
                                    result *= result;
                                    if (result == (int) result) {
                                        outputScreen.setText(Integer.toString((int) result));
                                    } else {
                                        outputScreen.setText(Double.toString(result));
                                    }
                                } catch (NumberFormatException n) {
                                    outputScreen.setText("ERR: Invalid input");
                                }
                                inputScreen.setText("");
                            }
                        }
                        else {
                            if (!inputScreen.getText().isEmpty()) {
                                String operation = outputScreen.getText().substring(outputScreen.getText().length() - 1);
                                double numToSquare = Double.parseDouble(inputScreen.getText());
                                switch (operation) {
                                    case "+":
                                        result += (numToSquare * numToSquare);
                                        break;
                                    case "-":
                                        result -= (numToSquare * numToSquare);
                                        break;
                                    case "*":
                                        result *= (numToSquare * numToSquare);
                                        break;
                                    case "/":
                                        result /= (numToSquare * numToSquare);
                                        break;
                                    case "D"://the end of MOD
                                        result %= (numToSquare * numToSquare);
                                        break;
                                }
                                if (result == (int) result) {
                                    outputScreen.setText(Integer.toString((int) result));
                                    inputScreen.setText("");
                                } else {
                                    outputScreen.setText(Double.toString(result));
                                    inputScreen.setText("");
                                }
                            } else {
                                try {
                                    result = Double.parseDouble(outputScreen.getText());
                                    result *= result;
                                    if (result == (int) result) {
                                        outputScreen.setText(Integer.toString((int) result));
                                    } else {
                                        outputScreen.setText(Double.toString(result));
                                    }
                                } catch (NumberFormatException n) {
                                    outputScreen.setText("ERR: Invalid input");
                                }
                            }
                        }
                        break;
                    case "x^3":
                        if (outputScreen.getText().isEmpty()) {
                            if (!inputScreen.getText().isEmpty()) {
                                try {
                                    result = Double.parseDouble(inputScreen.getText());
                                    result *= result * result;
                                    if (result == (int) result) {
                                        outputScreen.setText(Integer.toString((int) result));
                                    } else {
                                        outputScreen.setText(Double.toString(result));
                                    }
                                } catch (NumberFormatException n) {
                                    outputScreen.setText("ERR: Invalid input");
                                }
                                inputScreen.setText("");
                            }
                        } else {
                            if (!inputScreen.getText().isEmpty()) {
                                String operation = outputScreen.getText().substring(outputScreen.getText().length() - 1);
                                double numToCube = Double.parseDouble(inputScreen.getText());
                                switch (operation) {
                                    case "+":
                                        result += (numToCube * numToCube * numToCube);
                                        break;
                                    case "-":
                                        result -= (numToCube * numToCube * numToCube);
                                        break;
                                    case "*":
                                        result *= (numToCube * numToCube * numToCube);
                                        break;
                                    case "/":
                                        result /= (numToCube * numToCube * numToCube);
                                        break;
                                    case "D"://the end of MOD
                                        result %= (numToCube * numToCube * numToCube);
                                        break;
                                }
                                if (result == (int) result) {
                                    outputScreen.setText(Integer.toString((int) result));
                                    inputScreen.setText("");
                                } else {
                                    outputScreen.setText(Double.toString(result));
                                    inputScreen.setText("");
                                }
                            } else {
                                try {
                                    result = Double.parseDouble(outputScreen.getText());
                                    result *= result * result;
                                    if (result == (int) result) {
                                        outputScreen.setText(Integer.toString((int) result));
                                    } else {
                                        outputScreen.setText(Double.toString(result));
                                    }
                                } catch (NumberFormatException n) {
                                    outputScreen.setText("ERR: Invalid input");
                                }
                            }
                        }
                        break;
                }
            }
        }
        for (JButton dataManipButton : dataManipButtons){
            if (buttonPressed.getActionCommand().equals(dataManipButton.getActionCommand())){
                switch (buttonPressed.getActionCommand()){
                    case "1/x":
                        if (outputScreen.getText().isEmpty() && inputScreen.getText().isEmpty()){
                            result = 1;
                            outputScreen.setText("1 /");
                        }
                        else if (!inputScreen.getText().isEmpty()){
                            outputScreen.setText(inputScreen.getText() + " /");
                            result = Double.parseDouble(inputScreen.getText());
                            inputScreen.setText("");
                        }
                        else if (!outputScreen.getText().isEmpty()) {
                            //try {
                            result = Double.parseDouble(outputScreen.getText());
                            //}
                            outputScreen.setText(outputScreen.getText() + " /");
                        }
                        break;
                    case "√x":
                        if (inputScreen.getText().isEmpty()){
                            outputScreen.setText("ERR: Enter number first");
                        }
                        else if (outputScreen.getText().isEmpty()){
                            result = Math.sqrt(Double.parseDouble(inputScreen.getText()));
                            if (result == (int) result) {
                                outputScreen.setText(Integer.toString((int) result));
                            }
                            else {
                                outputScreen.setText(Double.toString(result));
                            }
                            inputScreen.setText("");
                        }
                        else {
                            try {
                                result = Double.parseDouble(outputScreen.getText());
                                double sqrt = Math.sqrt(Double.parseDouble(inputScreen.getText()));
                                result *= sqrt;
                                if (result == (int) result) {
                                    outputScreen.setText(Integer.toString((int) result));
                                }
                                else {
                                    outputScreen.setText(Double.toString(result));
                                }
                            }
                            catch (NumberFormatException n){
                                outputScreen.setText("ERR: Invalid input");
                                inputScreen.setText("");
                            }
                        }
                        break;
                }
            }
        }
        for (JButton logarithmButton : logButtons){
            if (buttonPressed.getActionCommand().equals(logarithmButton.getActionCommand())){
                switch (buttonPressed.getActionCommand()){
                    case "log":
                        if (inputScreen.getText().isEmpty()){
                        outputScreen.setText("ERR: Enter number first");
                    }
                    else if (outputScreen.getText().isEmpty()){
                        result = Math.log10(Double.parseDouble(inputScreen.getText()));
                        if (result == (int) result) {
                            outputScreen.setText(Integer.toString((int) result));
                        }
                        else {
                            outputScreen.setText(Double.toString(result));
                        }
                        inputScreen.setText("");
                    }
                    else {
                        try {
                            result = Double.parseDouble(outputScreen.getText());
                            double log10 = Math.log10(Double.parseDouble(inputScreen.getText()));
                            result *= log10;
                            if (result == (int) result) {
                                outputScreen.setText(Integer.toString((int) result));
                            }
                            else {
                                outputScreen.setText(Double.toString(result));
                            }
                        }
                        catch (NumberFormatException n){
                            outputScreen.setText("ERR: Invalid input");
                            inputScreen.setText("");
                        }
                    }
                        break;
                    case "ln":
                        if (inputScreen.getText().isEmpty()){
                            outputScreen.setText("ERR: Enter number first");
                        }
                        else if (outputScreen.getText().isEmpty()){
                            outputScreen.setText(Double.toString(Math.log(Double.parseDouble(inputScreen.getText()))));
                            inputScreen.setText("");
                        }
                        else {
                            try {
                                result = Double.parseDouble(outputScreen.getText());
                                double natLog = Math.log(Double.parseDouble(inputScreen.getText()));
                                result *= natLog;
                                if (result == (int) result) {//I don't know if ln can ever return an int, but it's worth a try
                                    outputScreen.setText(Integer.toString((int) result));
                                }
                                else {
                                    outputScreen.setText(Double.toString(result));
                                }
                            }
                            catch (NumberFormatException n){
                                outputScreen.setText("ERR: Invalid input");
                                inputScreen.setText("");
                            }
                        }
                        break;
                }
            }
        }
        for (JButton trigButton : trigButtons){
            if (buttonPressed.getActionCommand().equals(trigButton.getActionCommand())){
                switch (buttonPressed.getActionCommand()){
                    case "sin":
                        if (inputScreen.getText().isEmpty()){
                            outputScreen.setText("ERR: Enter number first");
                        }
                        else if (outputScreen.getText().isEmpty()){
                            result = Math.sin(Double.parseDouble(inputScreen.getText()));
                            if (result == (int) result) {
                                outputScreen.setText(Integer.toString((int) result));
                            }
                            else {
                                outputScreen.setText(Double.toString(result));
                            }
                            inputScreen.setText("");
                        }
                        else {
                            try {
                                result = Double.parseDouble(outputScreen.getText());
                                double sin = Math.sin(Double.parseDouble(inputScreen.getText()));
                                result *= sin;
                                if (result == (int) result) {
                                    outputScreen.setText(Integer.toString((int) result));
                                }
                                else {
                                    outputScreen.setText(Double.toString(result));
                                }
                            }
                            catch (NumberFormatException n){
                                outputScreen.setText("ERR: Invalid input");
                                inputScreen.setText("");
                            }
                        }
                        break;
                    case "cos":
                        if (inputScreen.getText().isEmpty()){
                            outputScreen.setText("ERR: Enter number first");
                        }
                        else if (outputScreen.getText().isEmpty()){
                            result = Math.cos(Double.parseDouble(inputScreen.getText()));
                            if (result == (int) result) {
                                outputScreen.setText(Integer.toString((int) result));
                            }
                            else {
                                outputScreen.setText(Double.toString(result));
                            }
                            inputScreen.setText("");
                        }
                        else {
                            try {
                                result = Double.parseDouble(outputScreen.getText());
                                double cos = Math.cos(Double.parseDouble(inputScreen.getText()));
                                result *= cos;
                                if (result == (int) result) {
                                    outputScreen.setText(Integer.toString((int) result));
                                }
                                else {
                                    outputScreen.setText(Double.toString(result));
                                }
                            }
                            catch (NumberFormatException n){
                                outputScreen.setText("ERR: Invalid input");
                                inputScreen.setText("");
                            }
                        }
                        break;
                    case "tan":
                        if (inputScreen.getText().isEmpty()){
                            outputScreen.setText("ERR: Enter number first");
                        }
                        else if (outputScreen.getText().isEmpty()){
                            result = Math.tan(Double.parseDouble(inputScreen.getText()));
                            if (result == (int) result) {
                                outputScreen.setText(Integer.toString((int) result));
                            }
                            else {
                                outputScreen.setText(Double.toString(result));
                            }
                            inputScreen.setText("");
                        }
                        else {
                            try {
                                result = Double.parseDouble(outputScreen.getText());
                                double tan = Math.tan(Double.parseDouble(inputScreen.getText()));
                                result *= tan;
                                if (result == (int) result) {
                                    outputScreen.setText(Integer.toString((int) result));
                                }
                                else {
                                    outputScreen.setText(Double.toString(result));
                                }
                            }
                            catch (NumberFormatException n){
                                outputScreen.setText("ERR: Invalid input");
                                inputScreen.setText("");
                            }
                        }
                        break;
                    case "asin":
                        if (inputScreen.getText().isEmpty()){
                            outputScreen.setText("ERR: Enter number first");
                        }
                        else if (outputScreen.getText().isEmpty()){
                            result = Math.asin(Double.parseDouble(inputScreen.getText()));
                            if (result == (int) result) {
                                outputScreen.setText(Integer.toString((int) result));
                            }
                            else {
                                outputScreen.setText(Double.toString(result));
                            }
                            inputScreen.setText("");
                        }
                        else {
                            try {
                                result = Double.parseDouble(outputScreen.getText());
                                double asin = Math.acos(Double.parseDouble(inputScreen.getText()));
                                result *= asin;
                                if (result == (int) result) {
                                    outputScreen.setText(Integer.toString((int) result));
                                }
                                else {
                                    outputScreen.setText(Double.toString(result));
                                }
                            }
                            catch (NumberFormatException n){
                                outputScreen.setText("ERR: Invalid input");
                                inputScreen.setText("");
                            }
                        }
                        break;
                    case "acos":
                        if (inputScreen.getText().isEmpty()){
                            outputScreen.setText("ERR: Enter number first");
                        }
                        else if (outputScreen.getText().isEmpty()){
                            result = Math.acos(Double.parseDouble(inputScreen.getText()));
                            if (result == (int) result) {
                                outputScreen.setText(Integer.toString((int) result));
                            }
                            else {
                                outputScreen.setText(Double.toString(result));
                            }
                            inputScreen.setText("");
                        }
                        else {
                            try {
                                result = Double.parseDouble(outputScreen.getText());
                                double acos = Math.acos(Double.parseDouble(inputScreen.getText()));
                                result *= acos;
                                if (result == (int) result) {
                                    outputScreen.setText(Integer.toString((int) result));
                                }
                                else {
                                    outputScreen.setText(Double.toString(result));
                                }
                            }
                            catch (NumberFormatException n){
                                outputScreen.setText("ERR: Invalid input");
                                inputScreen.setText("");
                            }
                        }
                        break;
                    case "atan":
                        if (inputScreen.getText().isEmpty()){
                            outputScreen.setText("ERR: Enter number first");
                        }
                        else if (outputScreen.getText().isEmpty()){
                            result = Math.atan(Double.parseDouble(inputScreen.getText()));
                            if (result == (int) result) {
                                outputScreen.setText(Integer.toString((int) result));
                            }
                            else {
                                outputScreen.setText(Double.toString(result));
                            }
                            inputScreen.setText("");
                        }
                        else {
                            try {
                                result = Double.parseDouble(outputScreen.getText());
                                double atan = Math.atan(Double.parseDouble(inputScreen.getText()));
                                result *= atan;
                                if (result == (int) result) {
                                    outputScreen.setText(Integer.toString((int) result));
                                }
                                else {
                                    outputScreen.setText(Double.toString(result));
                                }
                            }
                            catch (NumberFormatException n){
                                outputScreen.setText("ERR: Invalid input");
                                inputScreen.setText("");
                            }
                        }
                        break;
                    case "sinh":
                        if (inputScreen.getText().isEmpty()){
                            outputScreen.setText("ERR: Enter number first");
                        }
                        else if (outputScreen.getText().isEmpty()){
                            result = Math.sinh(Double.parseDouble(inputScreen.getText()));
                            if (result == (int) result) {
                                outputScreen.setText(Integer.toString((int) result));
                            }
                            else {
                                outputScreen.setText(Double.toString(result));
                            }
                            inputScreen.setText("");
                        }
                        else {
                            try {
                                result = Double.parseDouble(outputScreen.getText());
                                double sinh = Math.sinh(Double.parseDouble(inputScreen.getText()));
                                result *= sinh;
                                if (result == (int) result) {
                                    outputScreen.setText(Integer.toString((int) result));
                                }
                                else {
                                    outputScreen.setText(Double.toString(result));
                                }
                            }
                            catch (NumberFormatException n){
                                outputScreen.setText("ERR: Invalid input");
                                inputScreen.setText("");
                            }
                        }
                        break;
                    case "cosh":
                        if (inputScreen.getText().isEmpty()){
                            outputScreen.setText("ERR: Enter number first");
                        }
                        else if (outputScreen.getText().isEmpty()){
                            result = Math.cosh(Double.parseDouble(inputScreen.getText()));
                            if (result == (int) result) {
                                outputScreen.setText(Integer.toString((int) result));
                            }
                            else {
                                outputScreen.setText(Double.toString(result));
                            }
                            inputScreen.setText("");
                        }
                        else {
                            try {
                                result = Double.parseDouble(outputScreen.getText());
                                double cosh = Math.cosh(Double.parseDouble(inputScreen.getText()));
                                result *= cosh;
                                if (result == (int) result) {
                                    outputScreen.setText(Integer.toString((int) result));
                                }
                                else {
                                    outputScreen.setText(Double.toString(result));
                                }
                            }
                            catch (NumberFormatException n){
                                outputScreen.setText("ERR: Invalid input");
                                inputScreen.setText("");
                            }
                        }
                        break;
                    case "tanh":
                        if (inputScreen.getText().isEmpty()){
                            outputScreen.setText("ERR: Enter number first");
                        }
                        else if (outputScreen.getText().isEmpty()){
                            result = Math.tanh(Double.parseDouble(inputScreen.getText()));
                            if (result == (int) result) {
                                outputScreen.setText(Integer.toString((int) result));
                            }
                            else {
                                outputScreen.setText(Double.toString(result));
                            }
                            inputScreen.setText("");
                        }
                        else {
                            try {
                                result = Double.parseDouble(outputScreen.getText());
                                double tanh = Math.tanh(Double.parseDouble(inputScreen.getText()));
                                result *= tanh;
                                if (result == (int) result) {
                                    outputScreen.setText(Integer.toString((int) result));
                                }
                                else {
                                    outputScreen.setText(Double.toString(result));
                                }
                            }
                            catch (NumberFormatException n){
                                outputScreen.setText("ERR: Invalid input");
                                inputScreen.setText("");
                            }
                        }
                        break;
                }
            }
        }
        for (JButton miscButton : miscButtons){
            if (miscButton.getActionCommand().equals(buttonPressed.getActionCommand())){
                switch (buttonPressed.getActionCommand()){
                    case "C":
                        if (!inputScreen.getText().isEmpty()){
                            inputScreen.setText("");
                        }
                        else if (!outputScreen.getText().isEmpty()) {
                            outputScreen.setText("");
                            result = 0;
                        }
                        break;
                    case "EXIT":
                        System.exit(0);
                }
            }
        }
    }
}
