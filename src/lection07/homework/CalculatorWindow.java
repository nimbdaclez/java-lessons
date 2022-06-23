package lection07.homework;

import javax.swing.*;
import java.awt.*;

public class CalculatorWindow extends JFrame {

    public int getWindowW = 450;
    public int getWindowH = 650;
    public int windowX = 800;
    public int windowY = 300;
    private JLabel labelGreetingText;
    private JTextArea textEnterArea;

    private JButton buttonNumber0;
    private JButton buttonNumber1;
    private JButton buttonNumber2;
    private JButton buttonNumber3;
    private JButton buttonNumber4;
    private JButton buttonNumber5;
    private JButton buttonNumber6;
    private JButton buttonNumber7;
    private JButton buttonNumber8;
    private JButton buttonNumber9;
    private JButton buttonNumberEqual;
    private JButton buttonNumberPlus;
    private JButton buttonNumberMinus;
    private JButton buttonNumberDivide;
    private JButton buttonNumberMultiply;
    public CalculatorWindow() {
        prepareWindow();
        greetingText();
        enterArea();
        calculatorButtons();
        setVisible(true);
    }

    private void prepareWindow() {
        setSize(getWindowW,getWindowH);
        setLocation(windowX,windowY);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Calculator");
        setResizable(false);
    }

    private void greetingText(){
    labelGreetingText = new JLabel("Hello this is GUI of calculator");
    labelGreetingText.setBackground(Color.red);
    add(labelGreetingText, BorderLayout.NORTH);

    }

    private void enterArea (){
    textEnterArea = new JTextArea("Testing: 6723883");
    add(textEnterArea, BorderLayout.SOUTH);

    }

    private void calculatorButtons(){
        setLayout(new GridLayout(4,4));
        buttonNumber0 = new JButton(" 0 ");
        buttonNumber1 = new JButton(" 1 ");
        buttonNumber2 = new JButton(" 2 ");
        buttonNumber3 = new JButton(" 3 ");
        buttonNumber4 = new JButton(" 4 ");
        buttonNumber5 = new JButton(" 5 ");
        buttonNumber6 = new JButton(" 6 ");
        buttonNumber7 = new JButton(" 7 ");
        buttonNumber8 = new JButton(" 8 ");
        buttonNumber9 = new JButton(" 9 ");
        buttonNumberEqual = new JButton(" = ");
        buttonNumberPlus = new JButton(" + ");
        buttonNumberMinus = new JButton(" - ");
        buttonNumberDivide = new JButton(" / ");
        buttonNumberMultiply = new JButton(" * ");

        add(buttonNumber0);
        add(buttonNumber1);
        add(buttonNumber2);
        add(buttonNumber3);
        add(buttonNumber4);
        add(buttonNumber5);
        add(buttonNumber6);
        add(buttonNumber7);
        add(buttonNumber8);
        add(buttonNumber9);
        add(buttonNumberEqual);
        add(buttonNumberPlus);
        add(buttonNumberMinus);
        add(buttonNumberDivide);
        add(buttonNumberMultiply);


    }
}
