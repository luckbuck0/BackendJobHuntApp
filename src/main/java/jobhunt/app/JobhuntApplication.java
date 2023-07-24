package jobhunt.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("jobhunt/app/models")
public class JobhuntApplication {

	public static void main(String[] args) {
		SpringApplication.run(JobhuntApplication.class, args);
	}

}
