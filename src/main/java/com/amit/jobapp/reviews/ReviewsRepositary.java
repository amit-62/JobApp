package com.amit.jobapp.reviews;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewsRepositary extends JpaRepository<Reviews, Long> {
    List<Reviews> findByCompanyId(Long companyId);
}
