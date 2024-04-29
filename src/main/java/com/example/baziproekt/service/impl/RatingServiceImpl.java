package com.example.baziproekt.service.impl;

import com.example.baziproekt.model.Rating;
import com.example.baziproekt.repository.RatingRepository;
import com.example.baziproekt.service.RatingService;
import org.springframework.stereotype.Service;

@Service
public class RatingServiceImpl implements RatingService {

    private final RatingRepository ratingRepository;

    public RatingServiceImpl(RatingRepository ratingRepository) {
        this.ratingRepository = ratingRepository;
    }

    @Override
    public Rating addRating(Integer rating) {
        Rating rating1 = new Rating(rating);
        return this.ratingRepository.save(rating1);
    }
}
