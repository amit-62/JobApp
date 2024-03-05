package com.amit.jobapp.reviews;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/Review/{companyId}")
public class ReviewsController {
    ReviewsService reviewsService;

    public ReviewsController(ReviewsService reviewsService) {
        this.reviewsService = reviewsService;
    }

    @GetMapping("/reviews")
    public ResponseEntity<List<Reviews>> findAll(@PathVariable(value = "companyId") Long companyId){
        return ResponseEntity.ok(reviewsService.findAll(companyId));
    }

}
