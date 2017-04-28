package com.itransition.lyubin.service;

import com.itransition.lyubin.dto.AddRatingInfoDTO;
import org.springframework.security.core.userdetails.UserDetails;

public interface RatingService {
    public void addRating(AddRatingInfoDTO addRatingInfoDTO, UserDetails userDetails);
}
