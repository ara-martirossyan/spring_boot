package com.aralmighty.model;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="verification")
public class VerificationToken {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private Long id;
	
	@Column(name="token")
	private String token;
	
	@OneToOne(targetEntity=SiteUser.class)
	@JoinColumn(name="user_id", nullable=false)
	private SiteUser user;	

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="expiry_date")
	private Date expiry;
	
	@Enumerated(EnumType.STRING)
	@Column(name="token_type")
	private TokenType type;
	
	@PrePersist
	private void setDate() {
		Calendar c = Calendar.getInstance();
		c.add(Calendar.HOUR, 24);
		expiry = c.getTime();
	}	

	public VerificationToken() {
		
	}

	public VerificationToken(String token, SiteUser user, TokenType type) {
		this.token = token;
		this.user = user;
		this.type = type;
	}

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
	 * @return the token
	 */
	public String getToken() {
		return token;
	}

	/**
	 * @param token the token to set
	 */
	public void setToken(String token) {
		this.token = token;
	}

	/**
	 * @return the user
	 */
	public SiteUser getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(SiteUser user) {
		this.user = user;
	}

	/**
	 * @return the expiry
	 */
	public Date getExpiry() {
		return expiry;
	}

	/**
	 * @param expiry the expiry to set
	 */
	public void setExpiry(Date expiry) {
		this.expiry = expiry;
	}

	/**
	 * @return the type
	 */
	public TokenType getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(TokenType type) {
		this.type = type;
	}
}
