package com.dkit.gd2.johnloane.threadexercise;

/*
    a) A Poll is composed of a question, an ArrayList of options (all text) and
    an arraylist of votes for each of the options (ints)
    Write a Poll class which will model this
    b) Write a VoterThread class that takes in a shared Poll object and casts 100 votes at random during the course of its run. The thread should wait a random amount of time between casting each vote
    c) Write a VotingBooth class that creates a Poll about the best computer game in the world ever and it will share the poll with 10 VoterThreads. When all of the threads are completed display a tally of the final number of votes
 */

import java.util.ArrayList;

public class VoteApp
{
    public static void main(String[] args)
    {
        Poll bestComputerGameEver = generatePoll();
        Thread testThread = new Thread(new VoterThread(bestComputerGameEver));
        testThread.start();
        try
        {
            testThread.join();
        }
        catch(InterruptedException ie)
        {
            System.out.println(ie.getMessage());
        }
        System.out.println(bestComputerGameEver.getVotes());

    }

    private static Poll generatePoll()
    {
        ArrayList options = new ArrayList<>();
        options.add("Space Invaders");
        options.add("Splatter House");
        options.add("Knight Lore");

        Poll bestComputerGameEver = new Poll("What is the best computer game ever", options);
        return bestComputerGameEver;
    }
}
