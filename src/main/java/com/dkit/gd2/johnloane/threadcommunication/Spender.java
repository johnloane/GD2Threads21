package com.dkit.gd2.johnloane.threadcommunication;

public class Spender extends Thread
{
    private BankAccount account;

    public Spender(BankAccount account)
    {
        this.account = account;
    }

    @Override
    public void run()
    {
        while(account.isOpen())
        {
            try
            {
                if(account.withdraw(500))
                {
                    System.out.println("500 taken from the account");
                }
                Thread.currentThread().sleep(1000);
            }
            catch(InterruptedException ie)
            {
                System.out.println(ie.getMessage());
            }
        }
    }
}
