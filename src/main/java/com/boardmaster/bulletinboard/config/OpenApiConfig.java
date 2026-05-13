package com.boardmaster.bulletinboard.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {
  @Bean
  public OpenAPI bulletinBoardOpenAPI(){
    Info info = new Info()
        .title("Bulletin Board API")
        .description("Доска объявлений — REST API для публикации и поиска объявлений")
        .version("1.0.0");
    OpenAPI openAPI = new OpenAPI();
    openAPI.setInfo(info);
    return openAPI;
  }
}
