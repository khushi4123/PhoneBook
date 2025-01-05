package com.entity;

public class Contact {
	private int contid;
	private String contname;
	private String contemail;
	private String contphone;
	private String about;
	private int userId;
	
	
	public Contact() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Contact( String contname, String contemail, String contphone, String about, int userId) {
		super();
		this.contname = contname;
		this.contemail = contemail;
		this.contphone = contphone;
		this.about = about;
		this.userId = userId;
	}
	public int getContid() {
		return contid;
	}
	public void setContid(int contid) {
		this.contid = contid;
	}
	public String getContname() {
		return contname;
	}
	public void setContname(String contname) {
		this.contname = contname;
	}
	
	
	
	public String getContemail() {
		return contemail;
	}
	public void setContemail(String contemail) {
		this.contemail = contemail;
	}
	public String getContphone() {
		return contphone;
	}
	public void setContphone(String contphone) {
		this.contphone = contphone;
	}
	public String getAbout() {
		return about;
	}
	public void setAbout(String about) {
		this.about = about;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}

	

}
