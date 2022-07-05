package lection05.homework;

public class HomeWork5App {

    public static void main(String[] args) {

        Worker testWorker1 = new Worker("Garry","Potter","Testing","garrypotter@mail.ru","+7999345688", 232222,11);

        // Создаем и заполняем массив с работниками данными
        Worker [] workerArray = new Worker[5];
        workerArray[0] = new Worker("Nikita","Litvinkov","QA","litvinkov@mail.ru","+7999345688", 102000,28);
        workerArray[1] = new Worker("Arthur","Pirozkov","Manager","pirozkov@mail.ru","+7888254592", 210000,32);
        workerArray[2] = new Worker("Vladimir","Matrosov","Programmer","matrosov@mail.ru","+7922368587", 150000,26);
        workerArray[3] = new Worker("Evgeniy","Kozlovsky","Lead","kozlovsky@mail.ru","+78586253699", 2500000,42);
        workerArray[4] = new Worker("Ivan","Vladimirov","Director","vladimirov@mail.ru","+7984558496", 300000,44);

        // Задание 3 - Внутри класса «Сотрудник» написать метод, который выводит информацию об объекте в консоль.
        System.out.println( "Task 3: print information about object" + "\n" + testWorker1 + "\n");


        // Вывод массива циклом foreach
        System.out.println("Task 5: Print worker from array who age > 40");
        for (Worker constructor : workerArray) {
            if (constructor.personAge() > 40) {
                System.out.println(constructor);
            }
        }
    }
}
