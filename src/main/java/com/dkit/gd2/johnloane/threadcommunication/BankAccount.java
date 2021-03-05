package com.dkit.gd2.johnloane.threadcommunication;

/* Class to demonstrate the wait(), notify and notifyAll methods
    To show how thread communicate
 */

public class BankAccount
{
    private double balance = 0;
    private boolean isOpen = true;

    /* If the funds are insufficient, it will wait until there are enough funds
    @return true if withdrawal successful
    @exception InterruptedException if another thread calls the interrupt method
     */
    public synchronized boolean withdraw(double amount) throws InterruptedException
    {
        while(amount > balance && isOpen())
        {
            System.out.println("Waiting for some money.....");
            wait();
        }
        boolean result = false;
        if(isOpen())
        {
            balance -= amount;
            result = true;
        }
        return result;
    }

    public synchronized boolean isOpen()
    {
        return isOpen;
    }

    public synchronized boolean deposit(double amount)
    {
        if(isOpen())
        {
            balance += amount;
            notifyAll();
            return true;
        }
        else
        {
            return false;
        }
    }

    public synchronized void close()
    {
        isOpen = false;
        notifyAll();
    }
}
