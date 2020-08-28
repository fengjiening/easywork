package org.fengjiening;

import lombok.extern.slf4j.Slf4j;
import org.fengjiening.constant.ProvinceCityArea;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.Resource;

@Slf4j
public class UtilApplication {


	public static void main(String[] args) {
		log.debug("================");

		SpringApplication.run(UtilApplication.class, args);
	}

}
