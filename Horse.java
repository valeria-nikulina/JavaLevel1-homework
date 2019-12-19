package ru.geekbrains.java1.lesson5;

public class Horse extends Animal {

    public Horse (String name, int age) { super(name, age); }

    public Horse (String name) {
        super(name);
    }

    @Override
    public String runs(int dst, int ownLimit) {
        if ((dst > 1500)&&(dst > ownLimit)){
            return (" can't run " + dst + " meters. It gets tired!");
        } else return super.runs(dst, ownLimit);
    }

    @Override
    public void swims(int dst) {
        if (dst > 100){
            System.out.println(this.name + " can't swim " + dst + " meters. It begins to drown!");
        } else super.swims(dst);
    }

    @Override
    public void jumpsOver(float hgt) {
        if (hgt > 3){
            System.out.println(this.name + " can't jump over " + hgt + " meters. It is too high!");
        } else super.jumpsOver(hgt);
    }
}
