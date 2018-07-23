package com.tsms.entity;

public class User {
	private int id;
	private String username;
	private String password;
	private int texerId;
	private String salt;
	private int permissionId;
	private String state;
	private String email;
	
	public User() {
		super();
	}
	
	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public User(int id, String username, String password, int texerId, String salt, int permissionId,
			String state, String email) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.texerId = texerId;
		this.salt = salt;
		this.permissionId = permissionId;
		this.state = state;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getTexerId() {
		return texerId;
	}

	public void setTexerId(int texerId) {
		this.texerId = texerId;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public int getPermissionId() {
		return permissionId;
	}

	public void setPermissionId(int permissionId) {
		this.permissionId = permissionId;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
}
