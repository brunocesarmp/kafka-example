package dev.brunocesar.ecsale.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.gson.Gson;

@Configuration
public class GsonConfig {

	@Bean
	public Gson jsonConverter() {
		return new Gson();
	}

}
