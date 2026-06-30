package br.edu.ifspcjo.ads.web2.SdD.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import br.edu.ifspcjo.ads.web2.SdD.repository.DenunciationRepository;
import br.edu.ifspcjo.ads.web2.SdD.domain.model.Denunciation;
import br.edu.ifspcjo.ads.web2.SdD.domain.model.User;
import br.edu.ifspcjo.ads.web2.SdD.repository.UserRepository;
import br.edu.ifspcjo.ads.web2.SdD.service.exception.NonExistentOrInactiveUserException;
import jakarta.validation.Valid;
import java.util.List;

@Service
@Validated
public class DenunciationService {

	@Autowired
	private DenunciationRepository denunciationRepository;
	
	@Autowired
	private UserRepository userRepository;

		public void delete(Long id) {
			denunciationRepository.deleteById(id);
		}
	
	public Denunciation save(@Valid Denunciation denunciation) {
		
		Long userId = denunciation.getUser().getId();

		User user = userRepository.findById(userId)
				.orElseThrow(NonExistentOrInactiveUserException::new);

		if (!user.getActive()) {
			throw new NonExistentOrInactiveUserException();
		}

		return denunciationRepository.save(denunciation);
	}

	public Denunciation update(Long id, @Valid Denunciation denunciation) {

		Long userId = denunciation.getUser().getId();

		User user = userRepository.findById(userId)
				.orElseThrow(NonExistentOrInactiveUserException::new);

		if (!user.getActive()) {
			throw new NonExistentOrInactiveUserException();
		}

		Denunciation denunciationSaved = findDenunciationById(id);

		BeanUtils.copyProperties(denunciation, denunciationSaved, "id");

		return denunciationRepository.save(denunciationSaved);
	}

	private Denunciation findDenunciationById(Long id) {
		return denunciationRepository.findById(id)
				.orElseThrow(() -> 
					new EmptyResultDataAccessException("Denunciation not found", 1));
	}
	
	public List<Denunciation> listByUser(String email) {
		return denunciationRepository.findByUserEmail(email);
	}
}