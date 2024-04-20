package com.example.javaproject.Feedback;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FeedBackSystem {
    private List<FeedBackObserver> observers = new ArrayList<>();

    public void addObserver(FeedBackObserver observer) {
        observers.add(observer);
        System.out.println("Hello Observer has been added");
    }

    public void setObserver(FeedBackObserver observer){
        System.out.println("Feedback added");
        notifyObservers();
    }

    public void removeObserver(FeedBackObserver observer) {
        observers.remove(observer);
    }

    private void notifyObservers() {
        System.out.println("entered notifyObservers");
        for (FeedBackObserver observer : observers) {
            System.out.println("Observer is"+observer);
            observer.updateFeedback();
        }
    }
}
