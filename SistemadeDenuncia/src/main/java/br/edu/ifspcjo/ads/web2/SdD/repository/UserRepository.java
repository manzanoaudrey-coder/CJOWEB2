package br.edu.ifspcjo.ads.web2.SdD.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifspcjo.ads.web2.SdD.domain.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

	Optional<User> findByEmail(String email);

	Optional<User> findByEmailAndActiveTrue(String email);
}