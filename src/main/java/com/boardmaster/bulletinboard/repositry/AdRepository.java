package com.boardmaster.bulletinboard.repositry;

import com.boardmaster.bulletinboard.entity.AdStatus;
import com.boardmaster.bulletinboard.entity.Advertisement;
import com.boardmaster.bulletinboard.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AdRepository extends JpaRepository<Advertisement, Long> {

  List<Advertisement> findAdvertisementByAuthorId(Long authorId);

  List<Advertisement> findByStatus(AdStatus status);

  List<Advertisement> findByCategory(Category category);

  List<Advertisement> findByDescriptionContainingIgnoreCase(String description);
}
