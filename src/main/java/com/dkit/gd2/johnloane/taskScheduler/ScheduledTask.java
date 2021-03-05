package com.dkit.gd2.johnloane.taskScheduler;
/* To demonstrate how to use the Timer utility to
schedule tasks on a background thread
 */

import java.util.TimerTask;

public class ScheduledTask extends TimerTask
{
    private String message;

    public ScheduledTask(String message)
    {
        this.message = message;
    }

    @Override
    public void run()
    {
        System.out.println(message);
    }
}
