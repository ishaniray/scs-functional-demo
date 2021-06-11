package com.ishaniray.scs;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ScsFunctionalDemoApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(ScsFunctionalDemoApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ScsFunctionalDemoApplication.class, args);
	}

	@Bean
	public Supplier<String> scsFunctionalSource() {
		return () -> "This is a text message emitted by the source";
	}

	@Bean
	public Function<String, String> scsFunctionalProcessor() {
		return message -> new StringBuilder(message).append(", processed by the processor").toString();
	}

	@Bean
	public Consumer<String> scsFunctionalSink() {
		return message -> {
			message = new StringBuilder(message).append(" and received by the sink.").toString();
			LOGGER.debug(message);
		};
	}
}
