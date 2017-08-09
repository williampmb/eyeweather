package com.pmb.eyeweather.users;

public class User {
	private String id;
	private String email;
	private String first;
	private String last;
	private String username;
	private String password;
	private String role;
	private Boolean enable;
	
	private User(){
		
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirst() {
		return first;
	}

	public void setFirst(String first) {
		this.first = first;
	}

	public String getLast() {
		return last;
	}
	
	public void setLast(String last) {
		this.last = last;
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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Boolean isEnable() {
		return enable;
	}

	public void setEnable(Boolean enable) {
		this.enable = enable;
	}

	public User(Builder b){
		this.id = b.id;
		this.email = b.email;
		this.first = b.first;
		this.last = b.last;
		this.username = b.username;
		this.password = b.password;
		this.role = b.role;
		this.enable = b.enable;
	}
	
	@Override
	public String toString(){
		return id + ", " + email +", " + first 
				+ ", " + last+ " ," + username + ", " + password +  ", " + role + ", " + enable;
	}
	
	public static class Builder{
		private String id;
		private String email;
		private String first;
		private String last;
		private String username;
		private String password;
		private String role;
		private Boolean enable;
		
		
		public Builder id(String id){
			this.id = id;
			return this;
		}
		
		public Builder email(String email){
			this.email = email;
			return this;
		}
		
		public Builder first(String first){
			this.first = first;
			return this;
		}
		public Builder last(String last){
			this.last = last;
			return this;
		}
		
		public Builder username(String username){
			this.username = username;
			return this;
		}
		public Builder password(String password){
			this.password = password;
			return this;
		}
		public Builder role(String role){
			this.role = role;
			return this;
		}
		public Builder enable(Boolean enable){
			this.enable = enable;
			return this;
		}
		public User build() {
			return new User(this);
		}
	}
}
