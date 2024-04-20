package com.example.javaproject;
import com.example.javaproject.Feedback.*;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.annotation.Rollback;

import java.text.ParseException;
import java.time.LocalDate;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class FeedbackTest {
    @Autowired
    private FeedbackRepository feedbackRepo;

    //@MockBean
    //private FeedBackSystem feedBackSystem;

    //private Fee

    //@Autowired
    //private LoggingObserver loggingObserver;

    @Test
    public void testAddNew() throws ParseException {

        //feedBackSystem.addObserver(loggingObserver);
        FeedBackSystem feedbackSystem = new FeedBackSystem();
        LoggingObserver loggingObserver = new LoggingObserver();
        feedbackSystem.addObserver(loggingObserver);
        System.out.println("New Observer");
        //System.out.println(feedBackSystem.ob)
        Feedback feedback = new Feedback();
        //SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        //Date date = dateFormat.parse("2023-05-09");
        feedback.setDate(LocalDate.now());
        feedback.setUserId(1); // Set user ID
        //feedback.setDate("2023-05-09"); // Set date
        feedback.setRating(4); // Set rating
        feedback.setComments("Very informative"); // Set comments
        feedback.setExperience("not good"); // Set experience
        feedback.setDestination("bihar"); // Set destination
        feedback.setImprovementSuggestions("None"); // Set improvement suggestions

        Feedback savedFeedback = feedbackRepo.save(feedback);
        //feedBackSystem.notifyObservers(feedback);
        Assertions.assertThat(savedFeedback).isNotNull();
        Assertions.assertThat(savedFeedback.getId()).isGreaterThan(0);
        System.out.println("Feedback is being implemented");
        feedbackSystem.setObserver(loggingObserver);
        //Mockito.verify(feedbackSystem).addObserver(loggingObserver);

    }
    @Test
    public void testListAllFeedback() {
        Iterable<Feedback> feedbackList = feedbackRepo.findAll();
        Assertions.assertThat(feedbackList).isNotEmpty();

        for (Feedback feedback : feedbackList) {
            System.out.println(feedback);
        }
    }
    /*@Test
    public void testHandleFeedbackUpdate() {
        // Create a dummy feedback object
        Feedback feedback = new Feedback();
        feedback.setComments("Test comment");
        // Set other properties...

        // Call the handleFeedbackUpdate method
        FeedbackNotificationService.handleFeedbackUpdate(feedback);
    }*/
}
