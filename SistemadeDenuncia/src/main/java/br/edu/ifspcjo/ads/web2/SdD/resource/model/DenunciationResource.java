package br.edu.ifspcjo.ads.web2.SdD.resource.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import br.edu.ifspcjo.ads.web2.SdD.domain.model.Denunciation;
import br.edu.ifspcjo.ads.web2.SdD.repository.DenunciationRepository;
import br.edu.ifspcjo.ads.web2.SdD.service.DenunciationService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/denunciations")
public class DenunciationResource {

	@Autowired
	private DenunciationRepository denunciationRepository;

	@Autowired
	private DenunciationService denunciationService;

	@GetMapping
	@PreAuthorize("hasAuthority('ROLE_SEARCH_DENUNCIATION')")
	public List<Denunciation> list() {
		return denunciationRepository.findAll();
	}

	@GetMapping("/{id}")
	@PreAuthorize("hasAuthority('ROLE_SEARCH_DENUNCIATION')")
	public ResponseEntity<Denunciation> findById(@PathVariable Long id) {
		return denunciationRepository.findById(id)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	@PreAuthorize("hasAuthority('ROLE_REGISTER_DENUNCIATION')")
	public Denunciation create(@Valid @RequestBody Denunciation denunciation) {
		return denunciationService.save(denunciation);
	}

	@PutMapping("/{id}")
	@PreAuthorize("hasAuthority('ROLE_REGISTER_DENUNCIATION')")
	public ResponseEntity<Denunciation> update(
			@PathVariable Long id,
			@Valid @RequestBody Denunciation denunciation) {

		return ResponseEntity.ok(denunciationService.update(id, denunciation));
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@PreAuthorize("hasAuthority('ROLE_REMOVE_DENUNCIATION')")
	public void remove(@PathVariable Long id) {
		denunciationService.delete(id);
	}

	@GetMapping("/user/{email}")
	@PreAuthorize("hasAuthority('ROLE_SEARCH_DENUNCIATION')")
	public ResponseEntity<List<Denunciation>> listByUser(@PathVariable String email) {

		List<Denunciation> denunciations = denunciationService.listByUser(email);

		if (denunciations == null || denunciations.isEmpty()) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok(denunciations);
	}
}