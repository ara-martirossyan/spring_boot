package com.aralmighty.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.aralmighty.validation.PasswordMatch;

@Entity
@Table(name="users")
@PasswordMatch
public class SiteUser {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private Long id;
	
	@Column(name="email", unique=true)
	@Email(message="{register.email.invalid}")
	@NotBlank(message="{register.email.invalid}")
	private String email;
	
	@Column(name="password", length=60)
	@NotBlank
	private String password;
	
	@Transient
	@Size(min=5, max=15, message="{register.password.size}")
	private String plainPassword;
	
	@Transient
	private String repeatPassword;
	
	@Column(name="role", length=20)
	private String role;
	
	@Column(name="enabled")
	private Boolean enabled = false;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the role
	 */
	public String getRole() {
		return role;
	}

	/**
	 * @param role the role to set
	 */
	public void setRole(String role) {
		this.role = role;
	}	

	/**
	 * @return the plainPassword
	 */
	public String getPlainPassword() {
		return plainPassword;
	}

	/**
	 * @param plainPassword the plainPassword to set
	 */
	public void setPlainPassword(String plainPassword) {
		this.password = new BCryptPasswordEncoder().encode(plainPassword);
		this.plainPassword = plainPassword;
	}

	/**
	 * @return the repeatPassword
	 */
	public String getRepeatPassword() {
		return repeatPassword;
	}

	/**
	 * @param repeatPassword the repeatPassword to set
	 */
	public void setRepeatPassword(String repeatPassword) {
		this.repeatPassword = repeatPassword;
	}
	
	/**
	 * @return the enabled
	 */
	public Boolean getEnabled() {
		return enabled;
	}

	/**
	 * @param enabled the enabled to set
	 */
	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "SiteUser [id=" + id + ", email=" + email + ", password=" + password + "]";
	}

}
