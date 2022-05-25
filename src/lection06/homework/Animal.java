package lection06.homework;

public class Animal {

    // Конструктор родительского класса животные
    protected String type;
    protected String name;
    protected int runDistance;
    protected int swimDistance;

    public Animal(String type, String name, int runDistance, int swimDistance) {
        this.type = type;
        this.name = name;
        this.runDistance = runDistance;
        this.swimDistance = swimDistance;
    }

    public void printRunning() {
        System.out.println(type + " " + name + " ran " + runDistance + " meters");
    }

    // Метод вывода в консоль о дистанции плавания животного, с простой проверкой на возможность плавать.
    public void printSwimming() {
        if (swimDistance > 0) {
        System.out.println(type + " " + name + " swam " + swimDistance + " meters");
    } else {
            System.out.println(type + " " + name + " can't swim ");
        }
    }

}
