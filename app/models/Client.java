package models;

import javax.persistence.Entity;
import javax.persistence.Id;

import play.db.ebean.Model;

@Entity
public class Client extends Model {

	private static final long serialVersionUID = 1L;

	@Id
	public Long id;
	public String clientIp;
	public String clientCity;
	public String clientCountry;

	public Client(String ip, String city, String country) {
		this.clientIp = ip;
		this.clientCity = city;
		this.clientCountry = country;
	}

	public static Finder<String, Client> find = new Finder<String, Client>(String.class, Client.class);

	public static Client findIp(String ip) {
		return find.where().eq("client_ip", ip).findUnique();
	}
}
