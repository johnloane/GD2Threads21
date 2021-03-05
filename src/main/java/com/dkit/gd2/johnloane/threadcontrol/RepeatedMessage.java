package com.dkit.gd2.johnloane.threadcontrol;

public class RepeatedMessage implements Runnable
{
    private String message;
    private int pauseTime;
    /*Declared volatile so that every thread sees changes immediately
    no caching
     */
    private volatile boolean stopFlag;
    private static Object sharedLock = new Object();

    public RepeatedMessage(String message, int pauseTime)
    {
        this.message = message;
        this.pauseTime = pauseTime;
    }

    public static void displayMessage(RepeatedMessage rm) throws InterruptedException
    {
        synchronized (sharedLock)
        {
            for (int i = 0; i < rm.message.length(); ++i)
            {
                System.out.print(rm.message.charAt(i));
                Thread.currentThread().sleep(50);
            }
        }
    }

    @Override
    public void run()
    {
        stopFlag = false;

        try
        {
            while(!stopFlag)
            {
                displayMessage(this);
                Thread.currentThread().sleep(pauseTime);
            }
        }
        catch(InterruptedException ie)
        {
            System.out.println(ie.getMessage());
        }
    }

    public void finish()
    {
        stopFlag = true;
        return;
    }
}
