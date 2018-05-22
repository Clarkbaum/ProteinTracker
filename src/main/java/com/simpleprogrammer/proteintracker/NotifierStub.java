package com.simpleprogrammer.proteintracker;

public class NotifierStub implements Notifier {
    @Override
    public boolean send(String message) {
        //fake stub that just returns true
        return true;
    }
}
