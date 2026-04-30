package com.boardmaster.bulletinboard.service;

import com.boardmaster.bulletinboard.repositry.AdRepository;
import org.springframework.stereotype.Service;


@Service
public class AdService {

  private final AdRepository adRepository;
  public AdService (AdRepository adRepository){
    this.adRepository=adRepository;
  }
}
