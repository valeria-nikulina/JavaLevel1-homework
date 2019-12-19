package ru.geekbrains.java1.lesson5;
/*
1. Создать классы Собака, Лошадь, Птица и Кот с наследованием от класса Животное.

2. Животные могут выполнять действия: бежать, плыть, перепрыгивать препятствие.
В качестве параметра каждому методу передается величина, означающая или длину
препятствия (для бега и плавания), или высоту (для прыжков).

3. У каждого животного есть ограничения на действия
(бег: кот 200 м., собака 500 м., Лошадь 1500 м., Птица 5 м.,;
прыжок: кот 2 м., собака 0.5 м., Лошадь 3 м., Птица 0.2 м. ;
плавание: кот и птица не умеет плавать, собака 10 м., лошадь 100 м.).

4. При попытке животного выполнить одно из этих действий,
оно должно сообщить результат.
(Например, dog1.run(150); -> результат: 'Пёсик пробежал!')

5. * Добавить животным разброс в ограничениях.
То есть у одной собаки ограничение на бег может быть 400 м.,
у другой 600 м.
// --> ownLimit реализовала только на бег, потому что не вполне понимаю, видимо, логику работы:(

* */
public class Main {

    public static void main (String[] args) {
        Animal d = new Dog("Sharik");
        Animal h = new Horse("Dymka", 3);
        Animal b = new Bird("Ryaba", 1);
        Animal c = new Cat("Iriska", 7);

        Animal[] farm = {d, h, b, c};

        for (int i=0; i < farm.length; i++) {
           System.out.println(farm[i].name + " lives on our farm.");
           if (farm[i] instanceof Dog) {
               System.out.println(farm[i].name + farm[i].runs(550, 600));
           } else if (farm[i] instanceof Bird) {
               System.out.println(farm[i].name + farm[i].runs(50, 40));
           } else // cats and horses
               System.out.println(farm[i].name + farm[i].runs(600, 800));

           farm[i].swims(10);
           farm[i].jumpsOver(2);
           System.out.println("   ---///---   ---///---   ---///---");
        }


    }

}
