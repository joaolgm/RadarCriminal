package radarCriminal.entity;

import javax.persistence.*;

@Entity
@Table(name = "tb_school")
public class School {
	
	private String schoolCod, schoolName, rede, sphereAdmin,
	workState, cep, description, neighborhood, city, uf, zone;
	private int NumberOfStudents;
	private double latitude, longitude;
	
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
		return schoolName;
	}

	public void setschoolName(String nome) {
		this.schoolName = nome;
	}

	@Column(name = "rede")
	public String getRede() {
		return rede;
	}

	public void setRede(String rede) {
		this.rede = rede;
	}

	@Column(name = "sphereAdmin")
	public String getsphereAdmin() {
		return sphereAdmin;
	}

	public void setsphereAdmin(String sphereAdmin) {
		this.sphereAdmin = sphereAdmin;
	}

	@Column(name = "workState")
	public String getWorkState() {
		return workState;
	}

	public void setWorkState(String workState) {
		this.workState = workState;
	}

	@Column(name = "cep")
	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	@Column(name = "description")
	public String getdescription() {
		return description;
	}

	public void setdescription(String description) {
		this.description = description;
	}

	@Column(name = "neighborhood")
	public String getneighborhood() {
		return neighborhood;
	}

	public void setneighborhood(String neighborhood) {
		this.neighborhood = neighborhood;
	}

	@Column(name = "city")
	public String getcity() {
		return city;
	}

	public void setcity(String city) {
		this.city = city;
	}

	@Column(name = "uf")
	public String getUf() {
		return uf;
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
	public int getQtdAlunos() {
		return NumberOfStudents;
	}

	public void setQtdAlunos(int qtdAlunos) {
		this.NumberOfStudents = qtdAlunos;
	}
	
	@Column(name = "latitude")
	public double getLatitude() {
		return this.latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	@Column(name = "longitude")
	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	

}
