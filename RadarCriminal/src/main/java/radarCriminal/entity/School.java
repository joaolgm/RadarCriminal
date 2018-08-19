package radarCriminal.entity;

import javax.persistence.*;

@Entity
@Table(name = "tb_school")
public class School {
	
	private String schoolCod, schoolName, rede, sphereAdmin,
	workState, cep, description, neighbourhood, city, uf, zone;
	private Integer NumberOfStudents;
	private Double latitude, longitude;
	
	public School() {}
	

	@Id
	@Column(name = "pk_schoolCod")
	public String getSchoolCod() {
		return schoolCod;
	}

	public void setSchoolCod(String codEscola) {
		this.schoolCod = codEscola;
	}
	
	@Column(name = "schoolName")
	public String getSchoolName() {
		return schoolName.trim();
	}

	public void setSchoolName(String nome) {
		this.schoolName = nome;
	}

	@Column(name = "rede")
	public String getRede() {
		return rede.trim();
	}

	public void setRede(String rede) {
		this.rede = rede;
	}

	@Column(name = "sphereAdmin")
	public String getSphereAdmin() {
		return sphereAdmin.trim();
	}

	public void setSphereAdmin(String sphereAdmin) {
		this.sphereAdmin = sphereAdmin;
	}

	@Column(name = "workState")
	public String getWorkState() {
		return workState.trim();
	}

	public void setWorkState(String workState) {
		this.workState = workState;
	}

	@Column(name = "cep")
	public String getCep() {
		return cep.trim();
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	@Column(name = "description")
	public String getDescription() {
		return description.trim();
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "neighbourhood")
	public String getNeighbourhood() {
		return neighbourhood.trim();
	}

	public void setNeighbourhood(String neighborhood) {
		this.neighbourhood = neighborhood.trim();
	}

	@Column(name = "city")
	public String getCity() {
		return city.trim();
	}

	public void setCity(String city) {
		this.city = city.trim();
	}

	@Column(name = "uf")
	public String getUf() {
		return uf.trim();
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	@Column(name = "zone")
	public String getZone() {
		return zone;
	}

	public void setZone(String zone) {
		this.zone = zone;
	}

	@Column(name = "numberOfStudents")
	public Integer getQtdAlunos() {
		return NumberOfStudents;
	}

	public void setQtdAlunos(Integer qtdAlunos) {
		this.NumberOfStudents = qtdAlunos;
	}
	
	@Column(name = "latitude")
	public Double getLatitude() {
		return this.latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	@Column(name = "longitude")
	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	
}
