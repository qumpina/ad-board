package com.boardmaster.bulletinboard.service;

import com.boardmaster.bulletinboard.dto.AdRequest;
import com.boardmaster.bulletinboard.dto.AdResponse;
import com.boardmaster.bulletinboard.entity.AdStatus;
import com.boardmaster.bulletinboard.entity.Advertisement;
import com.boardmaster.bulletinboard.entity.Category;
import com.boardmaster.bulletinboard.entity.User;
import com.boardmaster.bulletinboard.exception.ResourceNotFoundException;
import com.boardmaster.bulletinboard.repository.AdRepository;
import com.boardmaster.bulletinboard.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;


@Service
public class AdService {

  private final AdRepository adRepository;
  private final UserRepository userRepository;

  public AdService(AdRepository adRepository, UserRepository userRepository) {
    this.adRepository = adRepository;
    this.userRepository = userRepository;
  }

  private AdResponse getAdResponse(Advertisement ad) {
    return new AdResponse(new AdResponse
        .AdBuilder(ad.getId(), ad.getName(), ad.getStatus(), ad.getAuthor().getUsername())
        .setCreatedAt(ad.getCreatedAt()));
  }

  private Advertisement getAdFromRequest(AdRequest adRequest) {
    Advertisement advertisement = new Advertisement();
    advertisement.setName(adRequest.getName());
    advertisement.setCategory(adRequest.getCategory());
    advertisement.setPrice(adRequest.getPrice());
    advertisement.setDescription(adRequest.getDescription());
    advertisement.setStatus(adRequest.getStatus());
    return advertisement;
  }

  public AdResponse createAd(AdRequest adRequest) {
    User user = userRepository.findById(adRequest.getUserId()).orElseThrow(() -> new ResourceNotFoundException("User", adRequest.getUserId()));
    Advertisement ad = getAdFromRequest(adRequest);
    ad.setAuthor(user);
    ad.setStatus(AdStatus.ACTIVE);
    ad.setCreatedAt(LocalDateTime.now());
    adRepository.save(ad);
    return getAdResponse(ad);

  }

  public AdResponse getAdById(Long id) {
    Advertisement ad = adRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Ad", id));
    return getAdResponse(ad);
  }

  public List<AdResponse> getAllAds() {
    return adRepository.findAll().stream().map(this::getAdResponse).toList();
  }

  public List<AdResponse> getAdsByCategory(Category category) {
    return adRepository.findByCategory(category).stream().map(this::getAdResponse).toList();
  }

  public List<AdResponse> searchAds(String keyword) {
    return adRepository.findByNameContainingIgnoreCase(keyword).stream().map(this::getAdResponse).toList();
  }
}
