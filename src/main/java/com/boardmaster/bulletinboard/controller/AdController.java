package com.boardmaster.bulletinboard.controller;

import com.boardmaster.bulletinboard.dto.AdRequest;
import com.boardmaster.bulletinboard.dto.AdResponse;
import com.boardmaster.bulletinboard.entity.Category;
import com.boardmaster.bulletinboard.service.AdService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/ads")
@RestController
@Tag(name="Advertisements",description = "Управление объявлениями")
public class AdController {
  private final AdService adService;
  public AdController(AdService adService){
    this.adService=adService;
  }

  @PostMapping
  @Operation(summary = "Создать объявление", description = "Создание нового объявления пользователем")
  @ApiResponse(responseCode = "201",description = "Объявление создано")
  @ApiResponse(responseCode = "400", description = "Ошибка валидации")
  public ResponseEntity<AdResponse> createAd (@RequestBody @Valid AdRequest adRequest){
    AdResponse adResponse=adService.createAd(adRequest);
    return ResponseEntity.status(HttpStatus.CREATED).body(adResponse);
  }

  @GetMapping("/{id}")
  @Operation(summary = "Поиск объявления по ID", description = "Поиск объявления по указанному ID объявления")
  @ApiResponse(responseCode = "200",description = "Объявление найдено")
  @ApiResponse(responseCode = "404", description = "Объявление не найдено")
  public ResponseEntity<AdResponse> getAdById(@Parameter(description = "ID Объявления") @PathVariable Long id){
    AdResponse adResponse=adService.getAdById(id);
    return ResponseEntity.status(HttpStatus.OK).body(adResponse);
  }
  @GetMapping
  @Operation(summary = "Все объявления", description = "Поиск всех объявлений")
  @ApiResponse(responseCode = "200", description = "Объявления найдены")
  public ResponseEntity<List<AdResponse>> getAllAds(){
    List<AdResponse> adResponseList=adService.getAllAds();
    return ResponseEntity.status(HttpStatus.OK).body(adResponseList);
  }
  @GetMapping("/category/{category}")
  @Operation(summary = "Поиск по категории", description = "Поиск всех объявлений по указанной категории")
  @ApiResponse(responseCode = "200", description = "Объявления по категории найдены")
  public ResponseEntity<List<AdResponse>> getAdsByCategory(@Parameter(description="Название категории")@PathVariable Category category){
    List<AdResponse> adResponseList=adService.getAdsByCategory(category);
    return ResponseEntity.status(HttpStatus.OK).body(adResponseList);
  }
  @GetMapping("/search")
  @Operation(summary = "Поиск по ключевому слову", description = "Поиск объявлений, содержащих ключевое слово")
  @ApiResponse(responseCode = "200", description = "Объявления найдены")
  public ResponseEntity<List<AdResponse>> searchAds(@Parameter(description = "Кодовое слово")@RequestParam("q") String keyword){
    List<AdResponse> adResponse=adService.searchAds(keyword);
    return ResponseEntity.status(HttpStatus.OK).body(adResponse);
  }

}
