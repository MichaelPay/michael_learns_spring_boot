package org.veevatools.corebackendjava21;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.veevatools.corebackendjava21.run.Location;
import org.veevatools.corebackendjava21.run.Run;

import java.time.LocalDateTime;

@SpringBootApplication
public class CoreBackendJava21Application {
	private static final Logger log = LoggerFactory.getLogger(CoreBackendJava21Application.class);

	public static void main(String[] args) {
		SpringApplication.run(CoreBackendJava21Application.class, args);
		System.out.println("Hello World");

		log.info("Hello World");
		Run run = new Run(1, "First Run", LocalDateTime.now(), LocalDateTime.now().plusDays(1), 12, Location.INDOOR);
		log.info(run.toString());
	}
}

