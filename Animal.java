package ru.geekbrains.java1.lesson5;

public abstract class Animal extends Object {
    String name;
    int age;

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Animal(String name) {
        this.name = name;
        this.age = 0;
    }

    // animal can run
    public String runs(int distance, int ownLimit) {
        return (" easily runs " + distance + " meters! Can even run "+ ownLimit);
    }

    // animal can swim
    public void swims(int distance) {
        System.out.println(this.name + " easily swims " + distance + " meters!");
    }

    // animal can jump over the barrier
    public void jumpsOver(float barrier) {
        System.out.println(this.name + " easily jumps over " + barrier + " meter barrier!");
    }
}
