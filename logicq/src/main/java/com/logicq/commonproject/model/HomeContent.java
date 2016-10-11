package com.logicq.commonproject.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "HOME_CONTENT")
public class HomeContent implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2967666181595376776L;
	
	@Id
	@Column(name = "CONTENT_ID", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "CONTENT_FOR", nullable = true)
	private String name;

	@Column(name = "IMAGE_PATH", nullable = true)
	private String imagepath;
	
	@Column(name = "TEXT_ONE", nullable = true)
	private String text1;
	
	@Column(name = "TEXT_TWO", nullable = true)
	private String text2;
	
	@Column(name = "TEXT_THREE", nullable = true)
	private String text3;
	
	@Column(name = "TEXT_EXTRA", nullable = true)
	private String textextra;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getText1() {
		return text1;
	}

	public void setText1(String text1) {
		this.text1 = text1;
	}

	public String getText2() {
		return text2;
	}

	public void setText2(String text2) {
		this.text2 = text2;
	}

	public String getText3() {
		return text3;
	}

	public void setText3(String text3) {
		this.text3 = text3;
	}

	public String getTextextra() {
		return textextra;
	}

	public void setTextextra(String textextra) {
		this.textextra = textextra;
	}

	public String getImagepath() {
		return imagepath;
	}

	public void setImagepath(String imagepath) {
		this.imagepath = imagepath;
	}

	@Override
	public String toString() {
		return "HomeContent [id=" + id + ", name=" + name + ", imagepath=" + imagepath + ", text1=" + text1 + ", text2="
				+ text2 + ", text3=" + text3 + ", textextra=" + textextra + "]";
	}

	
}
