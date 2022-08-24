package com.tong.telegrambot.domain.telegram;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * This object represents a venue.
 * <p>
 * Created by tong on 2022/08/23
 */
@Data
@Accessors(chain = true)
public class Venue {

    private Location location; // Venue location. Can't be a live location
    private String title; // Name of the venue
    private String address; // Address of the venue
    private String foursquareId; // Optional. Foursquare identifier of the venue
    private String foursquareType; // Optional. Foursquare type of the venue. (For example, “arts_entertainment/default”, “arts_entertainment/aquarium” or “food/icecream”.)
    private String googlePlaceId; // Optional. Google Places identifier of the venue
    private String googlePlaceType; // Optional. Google Places type of the venue. (See supported types.)

}
