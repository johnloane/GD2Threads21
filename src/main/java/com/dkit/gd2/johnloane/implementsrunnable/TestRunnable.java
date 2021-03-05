package com.dkit.gd2.johnloane.implementsrunnable;

public class TestRunnable
{
    public static void main(String[] args)
    {
        System.out.println("Hello from the main thread");

        /* Note the extra step -> new Thread needed when implements Runnable*/
        Thread printA = new Thread(new PrintChar('A', 100));
        Thread printB = new Thread(new PrintChar('B', 100));
        Thread print100 = new Thread(new PrintNumber(100));

        printA.start();
        printB.start();
        print100.start();

        System.out.println("Hello again from the main thread");
    }
}
