package my.sheshenya.samplemicronaut;

import io.micronaut.runtime.Micronaut;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@OpenAPIDefinition(
		info = @Info(
				title = "Sample micronaut Application",
				version = "1.0",
				description = "Implements a Sample Service API",
				license = @License(name = "Apache 2.0", url = "http://foo.bar")
		)
)
@SpringBootApplication
public class SampleMicronautApplication {

	public static void main(String[] args) {
		Micronaut.run(SampleMicronautApplication.class);
//		SpringApplication.run(SampleMicronautApplication.class, args);
	}

}
