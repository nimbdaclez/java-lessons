package lection02.homework;

public class HomeWork2App {

    public static void main(String[] args) {

        System.out.println(hwTask01(22,11));
        hwTask02(-12);
        System.out.println(hwTask03(-12));
        hwTask04("Stroka",6);
        System.out.println(hwTask05(2004));
    }

    static boolean hwTask01(int a, int b) {
        int sum = a + b;
        return (sum > 9 && sum < 21);
    }

    public static void hwTask02(int a) {
        if (a <= 0) {
            System.out.println("Number is negative");
        } else {
            System.out.println("Number is positive");
        }
    }
    static boolean hwTask03(int a) {
        return (a <= -1);

    }

    public static void hwTask04 (String txt, int n) {
        for (int i = 1; i <= n; i++) {
            System.out.println(txt);
        }
    }

    static boolean hwTask05 (int year) {
        return ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0);
    }
}
