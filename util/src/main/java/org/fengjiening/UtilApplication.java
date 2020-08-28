package org.fengjiening;

import io.swagger.annotations.ApiModel;
import lombok.extern.slf4j.Slf4j;

import org.springframework.boot.SpringApplication;

@Slf4j
public class UtilApplication {


	public static void main(String[] args) {
		log.debug("================");

		SpringApplication.run(UtilApplication.class, args);
	}

}
