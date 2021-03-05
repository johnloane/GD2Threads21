package com.dkit.gd2.johnloane.threadexercise;

import java.util.ArrayList;

public class Poll
{
    private String question;
    private ArrayList<String> options;
    private ArrayList<Integer> votes;

    public Poll(String question, ArrayList<String> options)
    {
        this.question = question;
        this.options = options;
        this.votes = new ArrayList<>();
        for(int i=0; i < this.options.size();i++)
        {
            this.votes.add(i, 0);
        }
    }

    public String getQuestion()
    {
        return question;
    }

    public ArrayList<String> getOptions()
    {
        return options;
    }

    public ArrayList<Integer> getVotes()
    {
        return votes;
    }

    @Override
    public String toString()
    {
        return "Poll{" +
                "question='" + question + '\'' +
                ", options=" + options +
                ", votes=" + votes +
                '}';
    }

    public void castVote(int i)
    {
        Integer value = this.getVotes().get(i);
        value += 1;
        this.getVotes().set(i, value);
    }
}
