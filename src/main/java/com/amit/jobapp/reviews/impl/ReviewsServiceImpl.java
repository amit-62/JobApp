package com.amit.jobapp.reviews.impl;

import com.amit.jobapp.reviews.Reviews;
import com.amit.jobapp.reviews.ReviewsRepositary;
import com.amit.jobapp.reviews.ReviewsService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewsServiceImpl implements ReviewsService {

    ReviewsRepositary reviewsRepositary;

    public ReviewsServiceImpl(ReviewsRepositary reviewsRepositary) {
        this.reviewsRepositary = reviewsRepositary;
    }


    @Override
    public List<Reviews> findAll(Long companyId) {
        return reviewsRepositary.findByCompanyId(companyId);
    }

    @Override
    public Reviews getReviewsById(Long companyId, Long id) {
        return null;
    }

    @Override
    public void createReviews(Long companyId, Reviews reviews) {

    }

    @Override
    public boolean deleteReviewsById(Long companyId, Long id) {
        return false;
    }

    @Override
    public boolean updateReview(Long companyId, Reviews reviews, Long id) {
        return false;
    }

    @Override
    public Reviews getReviewsById(Long id) {
        return null;
    }

    @Override
    public void createReviews(Reviews reviews) {

    }

    @Override
    public boolean deleteReviewsById(Long id) {
        return false;
    }

    @Override
    public boolean updateReview(Reviews reviews, Long id) {
        return false;
    }
}
