package lection07.homework;

import javax.swing.*;
import java.awt.*;

public class CalculatorWindow extends JFrame {
    Font font = new Font("Arial",Font.BOLD,20);
    Font eaFont = new Font("Arial",Font.BOLD,60);
    public int getWindowW = 400;
    public int getWindowH = 540;
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
        setLayout(null);
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
    labelGreetingText = new JLabel("This is frontend of Calculator", SwingConstants.CENTER);
    labelGreetingText.setFont(font);
    labelGreetingText.setSize(350, 30);
    labelGreetingText.setLocation(20,10);
    add(labelGreetingText);


    }

    private void enterArea (){
    textEnterArea = new JTextArea("0");
    textEnterArea.setFont(eaFont);
    textEnterArea.setSize(350,80);
    textEnterArea.setLocation(20,50);
    add(textEnterArea);

    }

    private void calculatorButtons(){
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

        buttonNumber7.setFont(font);
        buttonNumber7.setSize(80,80);
        buttonNumber7.setLocation(20,140);
        add(buttonNumber7);

        buttonNumber8.setFont(font);
        buttonNumber8.setSize(80,80);
        buttonNumber8.setLocation(110,140);
        add(buttonNumber8);

        buttonNumber9.setFont(font);
        buttonNumber9.setSize(80,80);
        buttonNumber9.setLocation(200,140);
        add(buttonNumber9);

        buttonNumberPlus.setFont(font);
        buttonNumberPlus.setSize(80,80);
        buttonNumberPlus.setLocation(290,140);
        add(buttonNumberPlus);

        buttonNumber4.setFont(font);
        buttonNumber4.setSize(80,80);
        buttonNumber4.setLocation(20,230);
        add(buttonNumber4);

        buttonNumber5.setFont(font);
        buttonNumber5.setSize(80,80);
        buttonNumber5.setLocation(110,230);
        add(buttonNumber5);

        buttonNumber6.setFont(font);
        buttonNumber6.setSize(80,80);
        buttonNumber6.setLocation(200,230);
        add(buttonNumber6);

        buttonNumberMinus.setFont(font);
        buttonNumberMinus.setSize(80,80);
        buttonNumberMinus.setLocation(290,230);
        add(buttonNumberMinus);

        buttonNumber1.setFont(font);
        buttonNumber1.setSize(80,80);
        buttonNumber1.setLocation(20,320);
        add(buttonNumber1);

        buttonNumber2.setFont(font);
        buttonNumber2.setSize(80,80);
        buttonNumber2.setLocation(110,320);
        add(buttonNumber2);

        buttonNumber3.setFont(font);
        buttonNumber3.setSize(80,80);
        buttonNumber3.setLocation(200,320);
        add(buttonNumber3);

        buttonNumberDivide.setFont(font);
        buttonNumberDivide.setSize(80,80);
        buttonNumberDivide.setLocation(290,320);
        add(buttonNumberDivide);

        buttonNumber0.setFont(font);
        buttonNumber0.setSize(170,80);
        buttonNumber0.setLocation(20,410);
        add(buttonNumber0);

        buttonNumberEqual.setFont(font);
        buttonNumberEqual.setSize(80,80);
        buttonNumberEqual.setLocation(200,410);
        add(buttonNumberEqual);

        buttonNumberMultiply.setFont(font);
        buttonNumberMultiply.setSize(80,80);
        buttonNumberMultiply.setLocation(290,410);
        add(buttonNumberMultiply);

    }
}
