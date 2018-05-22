package com.simpleprogrammer.proteintracker;

import java.util.ArrayList;
import java.util.List;

public class TrackingService {
    private int total;
    private int goal;
    private List<HistoryItem> history = new ArrayList<HistoryItem>();
    private int historyId = 0;
    private Notifier notifier;

    public TrackingService (Notifier notifer){
        this.notifier = notifer;
    }

    public void addProtein(int amount)
    {
        total += amount;
        history.add(new HistoryItem(historyId++, amount, "add", total));

        if (total > goal) {
            boolean sendResult = notifier.send("goal met");
            String historyMessage = "send:goal met";
            if(!sendResult)
                historyMessage = "send_error: goal met";
            history.add(new HistoryItem(historyId++, 0, historyMessage, total));
        }
    }

    public void removeProtein(int amount)
    {
        total -= amount;
        if(total < 0)
            total = 0;

        history.add(new HistoryItem(historyId++, amount, "subtract", total));
    }

    public int getTotal() {
        return total;
    }

    public void setGoal(int value) throws InvalidGoalException {
        if (value < 0) {
            //this is specifically tested for in the tests
            throw new InvalidGoalException("Goal was less than zero");
        }
        goal = value;
    }

    public boolean isGoalMet() {
        return total >= goal;
    }

    public List<HistoryItem> getHistory() {
        return history;
    }
}
