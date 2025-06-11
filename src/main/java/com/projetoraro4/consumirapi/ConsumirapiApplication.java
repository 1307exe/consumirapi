package com.projetoraro4.consumirapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ConsumirapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsumirapiApplication.class, args);
	}
}



