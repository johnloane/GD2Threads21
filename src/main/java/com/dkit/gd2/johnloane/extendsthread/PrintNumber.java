package com.dkit.gd2.johnloane.extendsthread;

public class PrintNumber extends Thread
{
    private int lastNumber;

    public PrintNumber(int n)
    {
        lastNumber = n;
    }

    @Override
    public void run()
    {
        for(int i=1; i < lastNumber; i++)
        {
            System.out.print(" " + i);
        }
    }
}
