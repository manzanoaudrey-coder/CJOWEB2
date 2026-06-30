package br.edu.ifspcjo.ads.web2.SdD.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifspcjo.ads.web2.SdD.domain.model.Denunciation;

public interface DenunciationRepository extends JpaRepository<Denunciation, Long> {

	List<Denunciation> findByUserEmail(String email);
}