package ArturRSO.Sistema_de_Restaurantes.Restaurantes;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javassist.NotFoundException;

@RestController
public class RestaurantesController {
    
    	@Autowired
	private RestaurantesRepository restaurantesRepository;

	@GetMapping("/restaurantes")
	public List<RestaurantesModel> retrieveAllRestaurantes() {
		return restaurantesRepository.findAll();
	}

	@GetMapping("/restaurantes/{id}")
	public RestaurantesModel retrieveRestaurante(@PathVariable long id) throws NotFoundException {
		Optional<RestaurantesModel> restaurante = restaurantesRepository.findById(id);

		if (!restaurante.isPresent())
			throw new javassist.NotFoundException("id-" + id);

		return restaurante.get();
	}

	@DeleteMapping("/restaurantes/{id}")
	public void deleteRestaurante(@PathVariable long id) {
		restaurantesRepository.deleteById(id);
	}

	@PostMapping("/restaurantes")
	public ResponseEntity<Object> createStudent(@RequestBody RestaurantesModel restaurante) {
		RestaurantesModel savedRestaurante = restaurantesRepository.save(restaurante);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedRestaurante.getId()).toUri();

		return ResponseEntity.created(location).build();

	}
	
	@PutMapping("/restaurantes/{id}")
	public ResponseEntity<Object> updateStudent(@RequestBody RestaurantesModel restaurante, @PathVariable long id) {

		Optional<RestaurantesModel> restaurantesOptional = restaurantesRepository.findById(id);

		if (!restaurantesOptional.isPresent())
			return ResponseEntity.notFound().build();

		restaurante.setId(id);
		
		restaurantesRepository.save(restaurante);

		return ResponseEntity.noContent().build();
	}
}