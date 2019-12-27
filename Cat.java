package ru.geekbrains.java1.lesson5;

public class Cat extends Animal {

    public Cat (String name, int age) {
        super(name, age);
    }

    public Cat (String name) {
        super(name);
    }

    //@Override
    public String runs(int dst, int ownLimit) {
        if ((dst > 200)&&(dst > ownLimit)){
            return (" can't run " + dst + " meters. It gets tired!");
        } else return super.runs(dst, ownLimit);
    }

    @Override
    public void swims(int dst) {
        System.out.println(this.name + " can't swim at all!");
    }

    @Override
    public void jumpsOver(float hgt) {
        if (hgt > 2){
            System.out.println(this.name + " can't jump over " + hgt + " meters. It is too high!");
        } else super.jumpsOver(hgt);
    }
}
