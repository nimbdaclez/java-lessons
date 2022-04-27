package lection01.homework;

public class HomeWorkApp {
    public static void main(String[] args) {

        printThreeWords();

        int Sum = checkSumSign(-13, 10);
        if (Sum >= 1) {
            System.out.println("Sum " + "("+ Sum +") " + "is positive");
        } else {
            System.out.println("Sum " + "("+ Sum +") " + "is negative");
        }

        int Color = printColor(101);
        if (Color <= 0) {
            System.out.println("Red");
        } else if (Color >= 1 && Color <= 100) {
            System.out.println("Yellow");
        } else {
            System.out.println("Green");
        }

        compareNumbers();
    }

    public static void printThreeWords() {
        System.out.println("Orange");
        System.out.println("Banana");
        System.out.println("Apple");
    }

    public static int checkSumSign(int a, int b) {
        return a + b;
    }

    public static int printColor(int value) {
        return value;
    }

    public static void compareNumbers() {
        int a = 55;
        int b = 44;

        if (a >= b) {
            System.out.println("a >= b");
        } else {
            System.out.println("a < b");
        }
    }
}
