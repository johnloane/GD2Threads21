package com.dkit.gd2.johnloane.threadgroup;

public class PiggyBank
{
    private int balance;

    public PiggyBank(int balance)
    {
        this.balance = balance;
    }

    public int getBalance()
    {
        return balance;
    }


    public void setBalance(int newBalance)
    {
        if(newBalance > 0)
        {
            this.balance = newBalance;
        }
    }
}
