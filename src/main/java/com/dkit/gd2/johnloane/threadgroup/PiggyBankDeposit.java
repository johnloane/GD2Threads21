package com.dkit.gd2.johnloane.threadgroup;

public class PiggyBankDeposit implements Runnable
{
    private PiggyBank henryTheHippo;

    public PiggyBankDeposit(PiggyBank henryTheHippo)
    {
        this.henryTheHippo = henryTheHippo;
    }


    @Override
    public void run()
    {
        addAPenny(henryTheHippo);
    }

    private static synchronized void addAPenny(PiggyBank henryTheHippo)
    {
        int newBalance = henryTheHippo.getBalance()+1;
        System.out.println(newBalance);
        try
        {
            Thread.currentThread().sleep(10);
        }
        catch(InterruptedException ie)
        {
            System.out.println(ie.getMessage());
        }
        henryTheHippo.setBalance(newBalance);
    }
}
