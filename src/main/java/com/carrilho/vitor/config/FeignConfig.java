package com.carrilho.vitor.config;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.carrilho.vitor.client.TransactionClient;

import feign.Feign;
import feign.Logger;
import feign.Request;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import feign.okhttp.OkHttpClient;
import feign.slf4j.Slf4jLogger;

@Configuration
public class FeignConfig {
	
	@Value("${openbank.api}")
	private String openBankUrl;
	
	@Value("${timeout.seconds}")
	private long timeout;
	
	@Value("${readtimeout.seconds}")
	private long readTimeout;

	@Bean
	public TransactionClient transactionClient() {
		return Feign.builder()
				  .client(new OkHttpClient())
				  .encoder(new GsonEncoder())
				  .decoder(new GsonDecoder())
				  .options(new Request.Options(timeout, TimeUnit.SECONDS, readTimeout, TimeUnit.SECONDS, true))
				  .logger(new Slf4jLogger(TransactionClient.class))
				  .logLevel(Logger.Level.FULL)
				  .target(TransactionClient.class, openBankUrl);
	}

}
