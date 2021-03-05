package com.dkit.gd2.johnloane.threadcontrol;

public class ThreadControl
{
    public static void main(String[] args)
    {
        RepeatedMessage m1 = new RepeatedMessage("Hello", 500);
        Thread m1T = new Thread(m1);
        m1T.start();

        RepeatedMessage m2 = new RepeatedMessage("Bonjour", 111);
        Thread m2T = new Thread(m2);
        m2T.start();

        RepeatedMessage m3 = new RepeatedMessage("Dia dhuit", 333);
        Thread m3T = new Thread(m3);
        m3T.start();

        try
        {
            Thread.currentThread().sleep(5000);
            m1.finish();
            m2.finish();
            m3.finish();
        }
        catch(InterruptedException ie)
        {
            System.out.println(ie.getMessage());
        }

    }
}
