package ru.geekbrains.java1.lesson5;

public class Dog extends Animal {

    public Dog(String name, int age) {
        super(name, age);
    }

    public Dog(String name) {
        super(name);
    }

    @Override
    public String runs(int dst, int ownLimit) {
        if ((dst > 500)&&(dst > ownLimit)){
            return (" can't run " + dst + " meters. It gets tired!");
        } else return super.runs(dst, ownLimit);
    }

    @Override
    public void swims(int dst) {
        if (dst > 10){
            System.out.println(this.name + " can't swim " + dst + " meters. It begins to drown!");
        } else super.swims(dst);
    }

    @Override
    public void jumpsOver(float hgt) {
        if (hgt > 0.5){
            System.out.println(this.name + " can't jump over " + hgt + " meters. It is too high!");
        } else super.jumpsOver(hgt);
    }


}
