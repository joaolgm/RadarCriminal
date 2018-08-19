package radarCriminal.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;


@Entity
@Table(name = "tb_crime")
public class Crime {

	private String year, neighbourhood, city, uf;
	private Double latitude, longitude;
	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO) 
	long id;
	
	public Crime(){};
	
	@Column(name="year")
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	@Column(name="neighbourhood")
	public String getNeighbourhood() {
		return neighbourhood;
	}
	public void setNeighbourhood(String neighbourhood) {
		this.neighbourhood = neighbourhood;
	}
	@Column(name="city")
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	@Column(name="uf")
	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}
	@Column(name="latitude")
	public Double getLatitude() {
		return latitude;
	}
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}
	@Column(name="longitude")
	public Double getLongitude() {
		return longitude;
	}
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}
}
