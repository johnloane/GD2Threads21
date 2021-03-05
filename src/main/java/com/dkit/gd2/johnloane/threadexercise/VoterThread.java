package com.dkit.gd2.johnloane.threadexercise;

import java.util.concurrent.ThreadLocalRandom;

public class VoterThread implements Runnable
{
    private Poll poll;
    private static Object sharedLock = new Object();

    public VoterThread(Poll poll)
    {
        this.poll = poll;
    }

    @Override
    public void run()
    {
        for(int i=0; i < 100; i++)
        {
            castRandomVote();
            int randomSleepTime = ThreadLocalRandom.current().nextInt(0, 100);
            try
            {
                Thread.currentThread().sleep(randomSleepTime);
            }
            catch(InterruptedException ie)
            {
                System.out.println(ie.getMessage());
            }
        }
    }

    private void castRandomVote()
    {
        int randomNum = ThreadLocalRandom.current().nextInt(0, (this.poll.getOptions().size()));
        synchronized (sharedLock)
        {
            this.poll.castVote(randomNum);
        }
    }
}
