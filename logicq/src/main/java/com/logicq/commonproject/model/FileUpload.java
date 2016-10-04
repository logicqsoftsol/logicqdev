package com.logicq.commonproject.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "FILE_UPLOAD")
public class FileUpload implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1698849600844374112L;

	@Id
	@Column(name = "FILE_ID", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id;
	
	@Column(name = "FILE_NAME", nullable = true)
	private String name;
	
	@Column(name = "FILE_TYPE", nullable = true)
	private String type;
	
	@Column(name = "FILE_CATEGORY", nullable = true)
	private String category;
	
	@Column(name = "FILE_SUBCATEGORY", nullable = true)
	private String subcategory;
	
	@Column(name = "FILE_PATH", nullable = true)
	private String path;
	
	@Column(name = "DISPLAY_TITLE", nullable = true)
	private String displaytitle;
	
	@Column(name = "DISPLAY_SUBTITLE", nullable = true)
	private String displaysubtitle;
	
	@Column(name = "DISPLAY_TOOLTIP", nullable = true)
	private String tooltip;
	
	
	@Column(name = "FILE_SIZE", nullable = true)
	private String filesize;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getSubcategory() {
		return subcategory;
	}

	public void setSubcategory(String subcategory) {
		this.subcategory = subcategory;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getDisplaytitle() {
		return displaytitle;
	}

	public void setDisplaytitle(String displaytitle) {
		this.displaytitle = displaytitle;
	}

	public String getDisplaysubtitle() {
		return displaysubtitle;
	}

	public void setDisplaysubtitle(String displaysubtitle) {
		this.displaysubtitle = displaysubtitle;
	}

	public String getTooltip() {
		return tooltip;
	}

	public void setTooltip(String tooltip) {
		this.tooltip = tooltip;
	}

	public String getFilesize() {
		return filesize;
	}

	public void setFilesize(String filesize) {
		this.filesize = filesize;
	}

	@Override
	public String toString() {
		return "FileUpload [id=" + id + ", name=" + name + ", type=" + type + ", category=" + category
				+ ", subcategory=" + subcategory + ", path=" + path + ", displaytitle=" + displaytitle
				+ ", displaysubtitle=" + displaysubtitle + ", tooltip=" + tooltip + ", filesize=" + filesize + "]";
	}

	
	

}
