package com.boardmaster.bulletinboard.controller;

import com.boardmaster.bulletinboard.dto.AdRequest;
import com.boardmaster.bulletinboard.dto.AdResponse;
import com.boardmaster.bulletinboard.entity.Category;
import com.boardmaster.bulletinboard.service.AdService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/ads")
@RestController
public class AdController {
  private final AdService adService;
  public AdController(AdService adService){
    this.adService=adService;
  }

  @PostMapping
  public ResponseEntity<AdResponse> createAd (@RequestBody @Valid AdRequest adRequest){
    AdResponse adResponse=adService.createAd(adRequest);
    return ResponseEntity.status(HttpStatus.CREATED).body(adResponse);
  }

  @GetMapping("/{id}")
  public ResponseEntity<AdResponse> getAdById(@PathVariable Long id){
    AdResponse adResponse=adService.getAdById(id);
    return ResponseEntity.status(HttpStatus.OK).body(adResponse);
  }
  @GetMapping("/all")
  public ResponseEntity<List<AdResponse>> getAllAds(){
    List<AdResponse> adResponseList=adService.getAllAds();
    return ResponseEntity.status(HttpStatus.OK).body(adResponseList);
  }
  @GetMapping("/category/{category}")
  public ResponseEntity<List<AdResponse>> getAdsByCategory(@PathVariable Category category){
    List<AdResponse> adResponseList=adService.getAdsByCategory(category);
    return ResponseEntity.status(HttpStatus.OK).body(adResponseList);
  }
  @GetMapping("/search")
  public ResponseEntity<List<AdResponse>> searchAds(@RequestParam("q") String keyword){
    List<AdResponse> adResponse=adService.searchAds(keyword);
    return ResponseEntity.status(HttpStatus.OK).body(adResponse);
  }

}
