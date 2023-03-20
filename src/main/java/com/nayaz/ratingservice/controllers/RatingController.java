package com.nayaz.ratingservice.controllers;


import com.nayaz.ratingservice.entities.Rating;
import com.nayaz.ratingservice.services.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ratings")
public class RatingController {

    @Autowired
    private RatingService ratingService;

    @PostMapping
    public ResponseEntity<Rating> createUser(@RequestBody Rating rating)  {
        return  ResponseEntity.status(HttpStatus.CREATED).body(ratingService.saveRating(rating));
    }

    @GetMapping("/users/{userId}")
    public  ResponseEntity<List<Rating>> getRatingByUserId(@PathVariable String userId) {
        return  ResponseEntity.ok(ratingService.getRatingByUserId(userId));
    }

    @GetMapping
    public  ResponseEntity<List<Rating>> getRatings() {
        List<Rating> allratings = ratingService.getAllRatings();
        return  ResponseEntity.ok(allratings);
    }

    @GetMapping("/hotels/{hotelId}")
    public  ResponseEntity<List<Rating>> getRatingByHotelId(@PathVariable String hotelId) {
        return  ResponseEntity.ok(ratingService.getRatingByHotelId(hotelId));
    }

//    @PutMapping("/{hotelId}")
//    public ResponseEntity<Hotel> updateHotel(@PathVariable("hotelId") String hotelId, @RequestBody Hotel hotel) {
//        hotelService.updateHotel(hotelId,hotel);
//        return new ResponseEntity<Hotel>(hotelService.getHotelById(hotelId), HttpStatus.OK);
//    }
//
//    @DeleteMapping({"/{hotelId}"})
//    public ResponseEntity<Hotel> deleteUser(@PathVariable("hotelId") String hotelId) {
//        hotelService.deleteHotel(hotelId);
//        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//    }
}
