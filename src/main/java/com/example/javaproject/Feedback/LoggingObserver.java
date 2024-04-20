package com.example.javaproject.Feedback;

import org.springframework.stereotype.Component;

@Component
public class LoggingObserver implements FeedBackObserver {
    @Override
    public void updateFeedback() {
        System.out.println("Feedback has been added: ");
    }
}
