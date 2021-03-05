package com.dkit.gd2.johnloane.extendsthread;

/* This thread class prints a specified character a specified number of times*/
/* extends Thread means that no other class can be extended - Java only supports
single inheritance
 */

public class PrintChar extends Thread
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
