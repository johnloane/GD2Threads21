package com.dkit.gd2.johnloane.unfairbankaccount;

public class BankExample
{
    public static void main(String[] args)
    {
        Account michaelAccount = new Account(1000);
        Runnable runner = new AccountThread(michaelAccount);

        System.out.println("Starting all of the threads");
        Thread t1 = new Thread(runner);
        Thread t2 = new Thread(runner);
        Thread t3 = new Thread(runner);

        t1.start();
        t2.start();
        t3.start();

        //Wait for threads
        try
        {
            t1.join();
            t2.join();
            t3.join();
        }
        catch(InterruptedException ie)
        {
            System.out.println(ie.getMessage());
        }
        System.out.println("Account balance is: " + michaelAccount.getBalance());
    }
}
