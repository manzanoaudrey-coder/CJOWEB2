package br.edu.ifspcjo.ads.web2.SdD.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.edu.ifspcjo.ads.web2.SdD.domain.model.User;
import br.edu.ifspcjo.ads.web2.SdD.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
		
		public br.edu.ifspcjo.ads.web2.SdD.domain.model.User update(Long id, User user) {
			br.edu.ifspcjo.ads.web2.SdD.domain.model.User userSaved = findUserById(id);
			BeanUtils.copyProperties(user, userSaved, "id");
			return userRepository.save(userSaved);
		}

		public void updateActiveProperty(Long id, Boolean active) {
			br.edu.ifspcjo.ads.web2.SdD.domain.model.User userSaved = findUserById(id);
			userSaved.setActive(active);
			userRepository.save(userSaved);
		}
		
		public br.edu.ifspcjo.ads.web2.SdD.domain.model.User findUserById(Long id) {
			br.edu.ifspcjo.ads.web2.SdD.domain.model.User userSaved = userRepository.findById(id).orElseThrow(() -> new EmptyResultDataAccessException(1));
			return userSaved;
		}


	}

