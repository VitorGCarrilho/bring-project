package com.carrilho.vitor.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.carrilho.vitor.client.TransactionClient;

import feign.Feign;
import feign.Logger;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import feign.okhttp.OkHttpClient;
import feign.slf4j.Slf4jLogger;

@Configuration

public class FeignConfig {
	
	@Bean
	public TransactionClient transactionClient() {
		return Feign.builder()
				  .client(new OkHttpClient())
				  .encoder(new GsonEncoder())
				  .decoder(new GsonDecoder())
				  .logger(new Slf4jLogger(TransactionClient.class))
				  .logLevel(Logger.Level.FULL)
				  .target(TransactionClient.class, "https://apisandbox.openbankproject.com/obp/v1.2.1/banks/rbs/accounts/savings-kids-john/public/transactions");
	}

}
