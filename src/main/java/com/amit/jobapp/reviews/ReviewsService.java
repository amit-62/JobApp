package com.amit.jobapp.reviews;

import com.amit.jobapp.company.Company;

import java.util.List;

public interface ReviewsService {
    List<Reviews> findAll(Long companyId);
    Reviews getReviewsById(Long companyId,Long id);
    void createReviews(Long companyId, Reviews reviews);
    boolean deleteReviewsById(Long companyId, Long id);
    boolean updateReview(Long companyId, Reviews reviews, Long id);
}
