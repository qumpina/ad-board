package com.boardmaster.bulletinboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "com.boardmaster.bulletinboard.entity")
public class BulletinBoardApplication {

	public static void main(String[] args) {
		SpringApplication.run(BulletinBoardApplication.class, args);
	}

}
