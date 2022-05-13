package lection03.homework;

import java.util.Random;
import java.util.Scanner;

public class HomeWork3App {

    public static Random random = new Random();
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        changeNumbersInArray();
        oneHundredArray();
        dividingNumbersInArray();
        oneInArrayDiagonal();
        arrayFromReturn(10,258);
        arrayMinMaxValue();

    }

    public static int hwRandom () {
        return random.nextInt (2);
    }

    public static void changeNumbersInArray () {

        int [] hwTask01 = new int [10];
        System.out.println("Task 1 - Change numbers in array");

        for (int i = 0; i < hwTask01.length; i++) {
            hwTask01[i] = hwRandom();
        }
        System.out.print("BEFORE CHANGES | ");
        for (int i = 0; i < hwTask01.length; i++) {
            System.out.print(hwTask01[i] + " | ");
        }

        System.out.println();

        for (int i = 0; i < hwTask01.length; i++) {
            if (hwTask01[i] == 1) {
                hwTask01[i] = 0;
            } else hwTask01[i] = 1;
        }
        System.out.print("AFTER CHANGES | ");
        for (int i = 0; i < hwTask01.length; i++) {
            System.out.print(hwTask01[i] + " | ");
        }
        System.out.println();
    }

    public static void oneHundredArray () {
        int [] hwTask02 = new int [100];
        hwTask02[0] = 1;
        System.out.println();
        System.out.println("Task 2 - One hundred numbers array from 1 to 100");

        for (int i = 1; i < hwTask02.length; i++) {
            hwTask02[i] = hwTask02 [i-1] + 1;
        }

        for (int i = 0; i < hwTask02.length; i++) {
        System.out.print(hwTask02[i] + " | ");
        }
        System.out.println();
    }

    public static void dividingNumbersInArray () {
        int [] hwTask03 = new int [12];
        hwTask03[0] = 1;
        hwTask03[1] = 5;
        hwTask03[2] = 3;
        hwTask03[3] = 2;
        hwTask03[4] = 11;
        hwTask03[5] = 4;
        hwTask03[6] = 5;
        hwTask03[7] = 2;
        hwTask03[8] = 4;
        hwTask03[9] = 8;
        hwTask03[10] = 9;
        hwTask03[11] = 1;

        System.out.println();
        System.out.println("Task 3 - Dividing numbers which < 6 on 2 in array");
        System.out.print("ORIGINAL NUMBERS | ");
        for (int i = 0; i < hwTask03.length; i++) {
            System.out.print(hwTask03[i] + " | ");
        }
        System.out.println();
        for (int i = 0; i < hwTask03.length; i++) {
            if (hwTask03[i] < 6 ) {
                hwTask03[i] = hwTask03[i] * 2;
            }
        }
        System.out.print("DIVIDED NUMBERS | ");
        for (int i = 0; i < hwTask03.length; i++) {
            System.out.print(hwTask03[i] + " | ");
        }
        System.out.println();
    }

    public static void oneInArrayDiagonal () {
        int [][] hwTask04 = new int [6][6];
        System.out.println();
        System.out.println("Task 4 - Filling diagonal elements");
        for (int i = 0; i < hwTask04.length; i++) {
            for (int j = 0; j < hwTask04.length; j++) {
                if (hwTask04[i] == hwTask04[j]) {
                    hwTask04[i][j] = 1;
                } else if (i + j == hwTask04.length - 1) {
                    hwTask04[i][j] = 1;
                }
            }
        }

        for (int i = 0; i < hwTask04.length; i++) {
            for (int j = 0; j < hwTask04.length; j++) {
                System.out.print(hwTask04[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public static int arrayFromReturn (int len, int initialValue) {
        int [] hwTask05 = new int [len];
        System.out.println();
        System.out.println("Task 5 - Array length and elements by user");
        for (int i = 0; i < hwTask05.length; i++) {
            hwTask05[i] = initialValue;
        }

        for (int i = 0; i < hwTask05.length; i++) {
            System.out.print(hwTask05[i] + " | ");
        }
        System.out.println();
        System.out.println();
        return len;
    }

    public static void arrayMinMaxValue () {
        System.out.println("Task 6 - Min and Max numbers in array");
        int [] hwTask06 = new int [10];
        for (int i = 0; i < hwTask06.length; i++) {
            hwTask06[i] = random.nextInt (5, 55);
        }
        int min = hwTask06[1];
        int max = hwTask06[1];
        for (int i = 0; i < hwTask06.length; i++) {
            if (hwTask06[i] > max) {
                max = hwTask06[i];
            } else if (hwTask06[i] < min) {
                min = hwTask06[i];
            }
        }
        for (int i = 0; i < hwTask06.length; i++) {
            System.out.print(hwTask06[i] + " | ");
        }
        System.out.println();
        System.out.println("Minimum is: " + min + " | " + "Maximum is: " + max);
    }

}
