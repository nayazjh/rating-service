package com.nayaz.ratingservice.services.impl;


import com.nayaz.ratingservice.entities.Rating;
import com.nayaz.ratingservice.repositories.RatingRepository;
import com.nayaz.ratingservice.services.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class RatingServiceImpl implements RatingService {

    @Autowired
    private RatingRepository ratingRepository;

    @Override
    public Rating saveRating(Rating rating) {
        String randomRatingId = UUID.randomUUID().toString();
        rating.setRatingId(randomRatingId);
        return ratingRepository.save(rating);
    }

    @Override
    public List<Rating> getAllRatings() {
        return ratingRepository.findAll();
    }

    @Override
    public List<Rating> getRatingByUserId(String userId) {
        return ratingRepository.findByUserId(userId);
    }

    @Override
    public List<Rating> getRatingByHotelId(String hotelId) {
        return ratingRepository.findByHotelId(hotelId);
    }

//    @Override
//    public Hotel updateHotel(String hotelId, Hotel hotel) {
//        Hotel updatehotel = hotelRepository.findById(hotelId).get();
//        updatehotel.setName(hotel.getName());
//        updatehotel.setLocation(hotel.getLocation());
//        updatehotel.setAbout(hotel.getAbout());
//        return hotelRepository.save(updatehotel);
//    }
//
//    @Override
//    public void deleteHotel(String hotelId) {
//        hotelRepository.deleteById(hotelId);
//    }


}
