package com.example.reviewsiteproject.demo;

import com.example.reviewsite.demo.Review;
import com.example.reviewsite.demo.ReviewRepository;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Collection;


public class ReviewRepositoryTests {

    private ReviewRepository underTest;
    private Review reviewOne = new Review(10l, "Review One name", "", "", "");
    private Review reviewTwo = new Review(11l, "Review Two name", "", "", "");

    @Test
    public void shouldFindReviewOne() {
        underTest = new ReviewRepository(reviewOne);
        Review foundReview = underTest.findOne(10l);
        assertEquals(foundReview, reviewOne);
    }

    @Test
    public void shouldFindReviewOneAndReviewTwo() {
        underTest = new ReviewRepository(reviewOne, reviewTwo);
        Collection<Review> foundReviews = underTest.findAll();
        assertThat(foundReviews).contains(reviewOne, reviewTwo);
    }
}
