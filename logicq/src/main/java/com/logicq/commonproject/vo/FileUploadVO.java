package com.logicq.commonproject.vo;

import java.io.Serializable;

import org.springframework.web.multipart.MultipartFile;

public class FileUploadVO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3443858805460350347L;
	
	private  MultipartFile[]  filecontent;
	private String name;
	private String type;
	private String category;
	private String subcategory;
	private String path;
	private String displaytitle;
	private String displaysubtitle;
	private String tooltip;
	
	
	
	
	public MultipartFile[] getFilecontent() {
		return filecontent;
	}
	public void setFilecontent(MultipartFile[] filecontent) {
		this.filecontent = filecontent;
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
	
	
	@Override
	public String toString() {
		return "FileUploadVO [filecontent=" + filecontent + ", name=" + name + ", type=" + type + ", category="
				+ category + ", subcategory=" + subcategory + ", path=" + path + ", displaytitle=" + displaytitle
				+ ", displaysubtitle=" + displaysubtitle + ", tooltip=" + tooltip + "]";
	}
	
	

}
