package lection01.online;

public class on01 {
    public static void main(String[] args) {
//        System.out.print("Hello World");
//        System.out.println("Hello Java");
//        System.out.println("Hello Peace");

        //numbers
//        byte myByte = 20; //1 byte <-128 ... +127>
//        short myShort = 220; //2 bytes <-32768 .. +32767>
//        int myInteger = 52000; //4 bytes <-2.1mlrd .. +2.1mlrd> DEFAULT
//        long myLong = 3000000000L; //8 bytes <-2^53 .. +2^63>
//
//        float myFloat = 14.2324f; //4 bytes < >.00000000
//        double myDouble = 14.2324; //8 bytes < >.0000000000000000 DEFAULT
//
//        //letters
//        char myChar = 'q'; //2 bytes -> ASCII, UTF8 .... (1 symbol)
//        boolean myBooleant = true; //2 bytes ->
//        boolean myBooleanf = false;
//
//        //!!!! NO PRIMITIVE !!!!
//        String myString = "Hello World";
//
//        //Math-operation
//        //+,-,*,/,^
//
//        int a = 10;
//        int b = 20;
//        System.out.println(a + b);
//
//        String name = "Oleg";
//        int c = 45;
//        System.out.println(name + c); //конкатинация строк
//        System.out.println("Result = " + (a + b) + " > " + name);
//        int a = 120;
//        if (a > 100) {
//            System.out.println("all good a > 100");
//        } else {
//            System.out.println("all bad a < 100");
//        }
//        operationWeekDay();
//        operationWeekDay();
//        operationWeekDay();
//        operationWeekDay();
//        welcomeUser("Oleg", 21);
//        welcomeUser("Stepan", 22);
//        welcomeUser("Xyan",32);
        int tempValue = sum(10, 15);
        System.out.println(tempValue);
    }
//    public static void operationWeekDay() {
//        System.out.println("Timmi");
//    }
    public static void welcomeUser(String nameUser, int age) {
        System.out.println("welcome " + nameUser + "!");
        System.out.println("age " + age);
    }
    public static int sum(int value1, int value2){
        return value1 + value2;
    }
}
