package com.dkit.gd2.johnloane.unfairbankaccount;

public class Account
{
    private double balance;
    private static Object sharedLock = new Object();

    public Account(double balance)
    {
        this.balance = balance;
    }

    public Account()
    {
        this.balance = 0.0;
    }

    public double getBalance()
    {
        return balance;
    }

    public void deposit(double amount)
    {
        double temp;

        synchronized (sharedLock)
        {

            temp = balance;

            try
            {
                Thread.sleep(500);
            } catch (InterruptedException ie)
            {
                System.out.println(ie.getMessage());
            }
            if (amount > 0)
            {
                temp += amount;
                balance = temp;
            } else
            {
                System.out.println("You cannot deposit negative amounts or zero");
            }
        }
    }

    public void withdraw(double amount)
    {
        try
        {
            Thread.sleep(500);
        }
        catch(InterruptedException ie)
        {
            System.out.println(ie.getMessage());
        }
        balance -= amount;
    }
}
