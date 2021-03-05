package com.dkit.gd2.johnloane.threadcommunication;

public class Saver implements Runnable
{
    private BankAccount account;

    public Saver(BankAccount account)
    {
        this.account = account;
    }

    @Override
    public void run()
    {
        while(account.isOpen())
        {
            if(account.deposit(100))
            {
                System.out.println("100 successfully deposited");
            }
            try
            {
                Thread.currentThread().sleep(1000);
            }
            catch (InterruptedException e)
            {
                System.out.println(e.getMessage());
            }
        }
    }
}
