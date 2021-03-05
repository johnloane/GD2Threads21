package com.dkit.gd2.johnloane.implementsrunnable;

public class PrintChar implements Runnable
{
    private char charToPrint;
    private int timesToPrint;

    public PrintChar(char c, int t)
    {
        charToPrint = c;
        timesToPrint = t;
    }

    //Override run to tell what the thread will do
    @Override
    public void run()
    {
        for(int i=0; i < timesToPrint; i++)
        {
            System.out.print(charToPrint);
        }
    }
}
