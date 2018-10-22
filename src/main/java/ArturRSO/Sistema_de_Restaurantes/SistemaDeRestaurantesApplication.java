package ArturRSO.Sistema_de_Restaurantes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:application.properties")
public class SistemaDeRestaurantesApplication {

	public static void main(String[] args) {
		SpringApplication.run(SistemaDeRestaurantesApplication.class, args);
	}
}
