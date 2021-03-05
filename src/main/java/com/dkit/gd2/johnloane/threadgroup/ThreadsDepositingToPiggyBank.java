package com.dkit.gd2.johnloane.threadgroup;

public class ThreadsDepositingToPiggyBank
{
    private PiggyBank bank = new PiggyBank(0);
    private Thread thread[] = new Thread[100];

    public ThreadsDepositingToPiggyBank()
    {
        ThreadGroup saverGroup = new ThreadGroup("saverGroup");
        boolean done = false;

        for(int i=0; i < 100; i++)
        {
            System.out.println("Starting thread " + i);
            thread[i] = new Thread(saverGroup, new PiggyBankDeposit(bank));
            thread[i].start();
        }

        while(!done)
        {
            if(saverGroup.activeCount() == 0)
            {
                System.out.println("Finishing balance is: " + bank.getBalance());
                done = true;
            }
        }
    }
}
