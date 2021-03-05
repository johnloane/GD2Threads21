package com.dkit.gd2.johnloane.extendsthread;

public class TestThread
{
    public static void main(String[] args)
    {
        System.out.println("Hello from the main thread");

        PrintChar printA = new PrintChar('A', 100);
        PrintChar printB = new PrintChar('B', 100);
        PrintNumber print100 = new PrintNumber(100);

        printA.start();
        printB.start();
        print100.start();

        System.out.println("Hello again from the main thread");
    }
}
