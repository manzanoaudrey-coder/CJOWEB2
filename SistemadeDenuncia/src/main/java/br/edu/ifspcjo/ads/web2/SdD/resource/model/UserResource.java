package br.edu.ifspcjo.ads.web2.SdD.resource.model;

import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifspcjo.ads.web2.SdD.domain.model.Gender;
import br.edu.ifspcjo.ads.web2.SdD.domain.model.User;
import br.edu.ifspcjo.ads.web2.SdD.repository.UserRepository;
import br.edu.ifspcjo.ads.web2.SdD.service.UserService;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserResource {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserService userService;

	@GetMapping
	@PreAuthorize("hasAuthority('ROLE_SEARCH_USER')")
	public List<User> listar() {

		var user1 = new User();
		user1.setId(1L);
		user1.setName("Fernando Duarte");
		user1.setEmail("fernandoduarte@ifsp.edu.br");
		user1.setPassword("cjoweb3");
		user1.setBirthDate(LocalDate.of(1975, 11, 16));
		user1.setAddress("Rua dos Banks 800");
		user1.setNeighborhood("Uberlandia");
		user1.setCountry("Brasil");
		user1.setGender(Gender.MASCULINO);
		user1.setPhone(null);
		user1.setActive(true);

		var user2 = new User();
		user2.setId(2L);
		user2.setName("Adriana Santos");
		user2.setEmail("adrianasantos@ifsp.edu.br");
		user2.setPassword("adriana");
		user2.setBirthDate(LocalDate.of(1980, 1, 1));
		user2.setAddress("Rua dos Bobos 0");
		user2.setNeighborhood("Lugar Nenhum");
		user2.setCountry("Brasil");
		user2.setGender(Gender.FEMININO);
		user2.setPhone(null);
		user2.setActive(true);

		return List.of(user1, user2);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	@PreAuthorize("hasAuthority('ROLE_REGISTER_USER')")
	public User create(@Valid @RequestBody User user, HttpServletResponse response) {
		return userRepository.save(user);
	}

	@PutMapping("/{id}")
	@PreAuthorize("hasAuthority('ROLE_REGISTER_USER')")
	public ResponseEntity<User> update(@PathVariable Long id, @Valid @RequestBody User user) {
		User userSaved = userService.update(id, user);
		return ResponseEntity.ok(userSaved);
	}

	@PutMapping("/{id}/active")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@PreAuthorize("hasAuthority('ROLE_REGISTER_USER')")
	public void atualizarPropriedadeAtivo(@PathVariable Long id, @RequestBody Boolean active) {
		userService.updateActiveProperty(id, active);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@PreAuthorize("hasAuthority('ROLE_REMOVE_USER')")
	public void remove(@PathVariable Long id) {
		userRepository.deleteById(id);
	}
}