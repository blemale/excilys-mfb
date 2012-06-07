package com.ebi.formation.mfb.web.forms.admin;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

/**
 * Classe représentant le formulaire de création d'un client. Nécessaire pour la validation du formulaire.
 * 
 * @author fguillain
 * 
 */
public class ClientForm {

	@Size(max = 20)
	@Pattern(regexp = "\\w+")
	private String username;
	@Size(max = 64)
	@NotBlank
	private String firstname;
	@Size(max = 64)
	@NotBlank
	private String lastname;
	@Size(min = 6, max = 20)
	@Pattern(regexp = "\\w*")
	private String password;
	@Size(min = 6, max = 20)
	@Pattern(regexp = "\\w*")
	private String password2;

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username
	 *            the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the firstname
	 */
	public String getFirstname() {
		return firstname;
	}

	/**
	 * @param firstname
	 *            the firstname to set
	 */
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	/**
	 * @return the lastname
	 */
	public String getLastname() {
		return lastname;
	}

	/**
	 * @param lastname
	 *            the lastname to set
	 */
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the password2
	 */
	public String getPassword2() {
		return password2;
	}

	/**
	 * @param password2
	 *            the password2 to set
	 */
	public void setPassword2(String password2) {
		this.password2 = password2;
	}
}
