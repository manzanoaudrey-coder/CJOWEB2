package br.edu.ifspcjo.ads.web2.SdD.domain.model;

import java.time.LocalDate;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "denuncia")
public class Denunciation {

	@NotNull
	@Enumerated(EnumType.STRING)
	private DenunciationType type;
	@NotNull
	@Column(name = "denunciation_date")
	@JsonFormat(pattern =  "dd/MM/yyyy")
	private LocalDate date;
	@NotNull
	private Double distance;
	@NotNull
	private Integer duration;
	@NotNull
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	@NotNull
	private Long id;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public DenunciationType getType() {
		return type;
	}
	public void setType(DenunciationType type) {
		this.type = type;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setData(LocalDate date) {
		this.date = date;
	}
	public Double getDistance() {
		return distance;
	}
	public void setDistance(Double distance) {
		this.distance = distance;
	}
	public Integer getDuration() {
		return duration;
	}
	public void setDuration(Integer duration) {
		this.duration = duration;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Denunciation other = (Denunciation) obj;
		return Objects.equals(id, other.id);
	}
	
}
