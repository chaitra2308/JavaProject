package com.example.javaproject;

import com.example.javaproject.Feedback.FeedbackRepository;
import com.example.javaproject.Feedback.Feedback;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class FeedbackTest {
    @Autowired
    private FeedbackRepository feedbackRepo;

    @Test
    public void testAddNew() throws ParseException {
        Feedback feedback = new Feedback();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = dateFormat.parse("2023-05-09");
        feedback.setDate(date);
        feedback.setUserId(1); // Set user ID
        //feedback.setDate("2023-05-09"); // Set date
        feedback.setRating(4); // Set rating
        feedback.setComments("Very informative"); // Set comments
        feedback.setExperience("Great"); // Set experience
        feedback.setDestination("hampi"); // Set destination
        feedback.setImprovementSuggestions("None"); // Set improvement suggestions

        Feedback savedFeedback = feedbackRepo.save(feedback);

        Assertions.assertThat(savedFeedback).isNotNull();
        Assertions.assertThat(savedFeedback.getId()).isGreaterThan(0);
    }
    @Test
    public void testListAllFeedback() {
        Iterable<Feedback> feedbackList = feedbackRepo.findAll();
        Assertions.assertThat(feedbackList).isNotEmpty();

        for (Feedback feedback : feedbackList) {
            System.out.println(feedback);
        }
    }
}
