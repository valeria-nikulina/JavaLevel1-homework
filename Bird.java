package ru.geekbrains.java1.lesson5;

public class Bird extends Animal {

    public Bird(String name, int age) {
        super(name, age);
    }

    public Bird(String name) {
        super(name);
    }

    @Override
    public String runs(int dst, int ownLimit) {
        if ((dst > 5)&&(dst > ownLimit)){
            return (" can't run " + dst + " meters. It gets tired!");
        } else return super.runs(dst, ownLimit);
    }

    @Override
    public void swims(int dst) {
         System.out.println(this.name + " can't swim at all!");
    }

    @Override
    public void jumpsOver(float hgt) {
        if (hgt > 0.2){
            System.out.println(this.name + " can't jump over " + hgt + " meters. It is too high!");
        } else super.jumpsOver(hgt);
    }
}
