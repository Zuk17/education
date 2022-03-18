package com.zuk17.oop.lesson2;

public class ComputerRunner {
    public static void main(String[] args) {
        int value = 5;
        Computer computer = new Computer();
        computer.printState();
        computer.load(true);

        Computer computer2 = new Computer(1050);
        computer2.printState();

        Computer computer3 = new Computer(1000,1050);
        computer3.printState();
    }
}
