package ArturRSO.Sistema_de_Restaurantes.Pratos;

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

@RestController
public class PratosController {
    
    	@Autowired
	private PratosRepository pratosRepository;

	@GetMapping("/pratos")
	public List<PratosModel> retrieveAllPratos() {
		return pratosRepository.findAll();
	}

	@GetMapping("/pratos/{id}")
	public PratosModel retrievePrato(@PathVariable long id) throws javassist.NotFoundException {
		Optional<PratosModel> pratos = pratosRepository.findById(id);

		if (!pratos.isPresent())
			throw new javassist.NotFoundException("id-" + id);

		return pratos.get();
	}

	@DeleteMapping("/pratos/{id}")
	public void deletePrato(@PathVariable long id) {
		pratosRepository.deleteById(id);
	}

	@PostMapping("/pratos")
	public ResponseEntity<Object> createPrato(@RequestBody PratosModel prato) {
		PratosModel savedPrato = pratosRepository.save(prato);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedPrato.getId()).toUri();

		return ResponseEntity.created(location).build();

	}
	
	@PutMapping("/pratos/{id}")
	public ResponseEntity<Object> updatePrato(@RequestBody PratosModel prato, @PathVariable long id) {

		Optional<PratosModel> studentOptional = pratosRepository.findById(id);

		if (!studentOptional.isPresent())
			return ResponseEntity.notFound().build();

		prato.setId(id);
		
		pratosRepository.save(prato);

		return ResponseEntity.noContent().build();
	}
}
