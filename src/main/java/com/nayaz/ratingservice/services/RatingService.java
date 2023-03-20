package com.nayaz.ratingservice.services;

import com.nayaz.ratingservice.entities.Rating;

import java.util.List;

public interface RatingService {

    Rating saveRating(Rating rating);

    List<Rating> getAllRatings();

    List<Rating> getRatingByUserId(String userId);

    List<Rating> getRatingByHotelId(String hotelId);


}
