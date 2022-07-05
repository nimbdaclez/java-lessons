//package lection07.AppGui;
//
//import javax.swing.*;
//import java.awt.*;
//
///**
// * Created by Aleksandr Gladkov [Anticisco]
// * Date: 21.05.2022
// */
//
//public class MainWindow extends JFrame {
//
//    private int windowW = 1024;
//    private int windowH = 768;
//    private int windowX = 200;
//    private int windowY = 150;
//
//    private GameMap map;
//    private Menu menu;
//
//    public MainWindow() {
//        prepareWindow();
//
//        map = new GameMap();
//        menu = new Menu();
//
//        add(menu, BorderLayout.EAST);
//        add(map);
//
//        setVisible(true);
//    }
//
//    private void prepareWindow() {
//        setSize(windowW, windowH);
//        setLocation(windowX, windowY);
//        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//        setTitle("GUI Application");
//        setResizable(false);
//    }
//
//}
