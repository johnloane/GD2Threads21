package com.dkit.gd2.johnloane.threadcommunication;

public class BankingApp
{
    public static void main(String[] args)
    {
        System.out.println("The first command line argument is " + args[0]);
        System.out.println("The second command line argument is " + args[1]);
        BankAccount zaksAccount = new BankAccount();

        Spender spenderThread = new Spender(zaksAccount);
        Saver rSaver = new Saver(zaksAccount);
        Thread saverThread = new Thread(rSaver);

        spenderThread.start();
        saverThread.start();

        int time;
        if(args.length == 0)
        {
            time = 10000;
        }
        else
        {
            time = Integer.parseInt(args[0]) * 1000;
        }
        try
        {
            Thread.currentThread().sleep(time);
        }
        catch(InterruptedException ie)
        {
            System.out.println(ie.getMessage());
        }
        zaksAccount.close();
    }
}
