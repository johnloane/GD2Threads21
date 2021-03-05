package com.dkit.gd2.johnloane.unfairbankaccount;

public class AccountThread implements Runnable
{
    Account acc;

    public AccountThread(Account acc)
    {
        this.acc = acc;
    }


    @Override
    public void run()
    {
        //Try to deposit 100, 10 times
        for(int i=0; i < 10; ++i)
        {
            acc.deposit(100);
        }
    }
}
