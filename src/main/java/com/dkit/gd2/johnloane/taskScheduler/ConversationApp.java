package com.dkit.gd2.johnloane.taskScheduler;

import java.util.Timer;

public class ConversationApp
{
    public static void main(String[] args)
    {
        ScheduledTask helloFromEthan = new ScheduledTask("Hello");
        ScheduledTask helloFromAlex = new ScheduledTask("How are you?");
        ScheduledTask imGrand = new ScheduledTask("I'm grand");
        ScheduledTask okBye = new ScheduledTask("Ok, Bye");

        //run a timer
        Timer timer = new Timer(true);
        timer.schedule(helloFromEthan, 1000);
        timer.schedule(helloFromAlex, 2000);
        timer.schedule(imGrand, 3000);
        timer.schedule(okBye, 3500);

        try
        {
            Thread.currentThread().sleep(11000);
        }
        catch(InterruptedException ie)
        {
            System.out.println(ie.getMessage());
        }
    }
}
