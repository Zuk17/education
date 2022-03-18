package com.zuk17.oop.lesson2;

public class Computer {
    private int ssd = 500;
    private int ram = 1024;


    public Computer(){
        System.out.println("Я был создан");
    }

    Computer(int newSsd){
        ssd = newSsd;
    }

    protected Computer(int ssd, int newRam){
        this.ssd = ssd;
        ram = newRam;
    }

    void load(){
        System.out.println("Я загрузился!");
    }

    void load(boolean open){
        System.out.println("Я загрузился!");
        if (open)
            System.out.println("Крышка открыта");
    }

    void printState(){
        System.out.println("Computer name: ");
        System.out.println("Ssd: " + ssd);
        System.out.println("Ram: " + ram);
    }
}
