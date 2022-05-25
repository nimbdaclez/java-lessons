package lection06.homework;

public class HomeWork6App {
    public static void main(String[] args) {

        int catCount = 0;
        int dogCount = 0;
        int animalCount = 0;

        // Объявляем массив с животным, передаем имя животного и дистанцию препятствия.
        Animal[] animals = new Animal[9];
        animals[0] = new Cat("Persik", 144,0);
        animals[1] = new Cat("Ciri", 187,0);
        animals[2] = new Cat("Alberta", 199,0);
        animals[3] = new Cat("Dusia", 102,0);
        animals[4] = new Dog("Baron", 435,8);
        animals[5] = new Cat("Latyshka", 124,0);
        animals[6] = new Dog("Michail", 256,4);
        animals[7] = new Cat("Michail", 180,0);
        animals[8] = new Dog("Michail", 475,3);

        // Цикл для обработки массива с выводом методов из классов и проверкой на принадлежность к определенным классам.
        for (int i = 0; i < animals.length; i++){
            animals[i].printRunning();
            animals[i].printSwimming();
            animalCount +=1;
            if (animals[i] instanceof Cat) {
                catCount += 1;
            } else if (animals[i] instanceof Dog) {
                dogCount +=1;
            }
        }
        System.out.println("--------------------------");
        System.out.println("Number of cats is: " + catCount);
        System.out.println("Number of dogs is: " + dogCount);
        System.out.println("Number of animals is: " + animalCount);
    }
}
