package com.aralmighty.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="status")
public class Status {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(name="text")
	@NotNull
	@Size(min=6, max=255, message="{addstatus.text.size}")
	private String text;
	
	@Column(name="added_at")
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern="yyyy/MM/dd HH:mm:ss")
	private Date addedAt;
	
	@PrePersist
	protected void onCreate() {
		if (this.addedAt == null) {
			this.addedAt = new Date();
		}
	}
	
	public Status() {
		
	}
	
	public Status(String text) {
		this.text = text;
	}
	
	public Status(String text, Date addedAt) {
		this.text = text;
		this.addedAt = addedAt;
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
	 * @return the text
	 */
	public String getText() {
		return text;
	}
	/**
	 * @param text the text to set
	 */
	public void setText(String text) {
		this.text = text;
	}
	/**
	 * @return the addedAt
	 */
	public Date getAddedAt() {
		return addedAt;
	}
	/**
	 * @param addedAt the addedAt to set
	 */
	public void setAddedAt(Date addedAt) {
		this.addedAt = addedAt;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((addedAt == null) ? 0 : addedAt.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((text == null) ? 0 : text.hashCode());
		return result;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Status other = (Status) obj;
		if (addedAt == null) {
			if (other.addedAt != null)
				return false;
		} else if (!addedAt.equals(other.addedAt))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (text == null) {
			if (other.text != null)
				return false;
		} else if (!text.equals(other.text))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Status [id=" + id + ", text=" + text + ", addedAt=" + addedAt + "]";
	}
	
	
	
	
}
