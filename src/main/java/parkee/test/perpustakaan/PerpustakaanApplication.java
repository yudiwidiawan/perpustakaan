package parkee.test.perpustakaan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import parkee.test.perpustakaan.audit.SpringSecurityAuditorAware;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditorAware")
public class PerpustakaanApplication {

	@Bean
	public AuditorAware<String> auditorAware() {
		return new SpringSecurityAuditorAware();
	}

	public static void main(String[] args) {
		SpringApplication.run(PerpustakaanApplication.class, args);
	}

}
