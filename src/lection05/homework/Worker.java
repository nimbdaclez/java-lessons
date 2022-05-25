package lection05.homework;

public class Worker {

    // Описываем переменные
    String firstName;
    String secondName;
    String position;
    String phone;
    String email;
    int salary;
    int age;

    // Создаем конструктор
    public Worker (String firstName, String secondName, String position, String email, String phone, int salary, int age) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }

    // getter возвращающий возраст после выполнения метода
    public int personAge() {
        return age;
    }

    // Получение строкового представления объекта методом toString
    public String toString(){
        return(firstName + " | " + secondName + " | " + position + " | " + email + " | " + phone + " | " + salary + " | " + age);
    }

}
