package com.itransition.lyubin.service.impl;

import com.itransition.lyubin.dto.AddRatingInfoDTO;
import com.itransition.lyubin.model.Profile;
import com.itransition.lyubin.model.User;
import com.itransition.lyubin.model.UsersProfiles;
import com.itransition.lyubin.repository.ProfileRepository;
import com.itransition.lyubin.repository.UserProfileRepository;
import com.itransition.lyubin.repository.UserRepository;
import com.itransition.lyubin.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class RatingServiceImpl implements RatingService {

    private UserProfileRepository userProfileRepository;
    private ProfileRepository profileRepository;
    private UserRepository userRepository;

    @Autowired
    public RatingServiceImpl(UserProfileRepository userProfileRepository,
                             ProfileRepository profileRepository,
                             UserRepository userRepository) {
        this.userProfileRepository = userProfileRepository;
        this.profileRepository = profileRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void addRating(AddRatingInfoDTO addRatingInfoDTO, UserDetails userDetails) {
        User user = this.userRepository.findByLogin(userDetails.getUsername());
        Profile profile = this.profileRepository.findById(addRatingInfoDTO.getProfileId());
        UsersProfiles usersProfiles = this.userProfileRepository.findFirstByUserAndProfile(user, profile);
        if (usersProfiles == null) {
            this.saveNewRatingRow(user, profile, addRatingInfoDTO);
        } else {
            this.saveRatingRow(usersProfiles, profile, addRatingInfoDTO);
        }

    }

    private void saveNewRatingRow(User user, Profile profile, AddRatingInfoDTO addRatingInfoDTO) {
        UsersProfiles usersProfiles = new UsersProfiles(user, profile, addRatingInfoDTO.getRating());
        this.userProfileRepository.save(usersProfiles);
        double rating = profile.getRating();
        int colLike = profile.getColLike();
        rating = (rating * colLike + addRatingInfoDTO.getRating()) / (colLike + 1);
        this.profileRepository.updateRating(rating, colLike + 1, addRatingInfoDTO.getProfileId());
    }

    private void saveRatingRow(UsersProfiles usersProfiles, Profile profile, AddRatingInfoDTO addRatingInfoDTO) {
        double ratingOld = usersProfiles.getRating();
        this.userProfileRepository.updateRatingById(usersProfiles.getId(), addRatingInfoDTO.getRating());
        double rating = profile.getRating();
        int colLike = profile.getColLike();
        rating = (rating * colLike - ratingOld + addRatingInfoDTO.getRating()) / colLike;
        this.profileRepository.updateRating(rating, colLike, addRatingInfoDTO.getProfileId());
    }
}