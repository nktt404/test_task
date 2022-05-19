package payroll;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class LoadDatabase {

	private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

	@Bean
	CommandLineRunner initDatabase(PaydocsRepository repository) {

		return args -> {
			log.info("Preloading " + repository.save(new PayDocs("123")));
			log.info("Preloading " + repository.save(new PayDocs("54444")));
		};
	}
}
