package com.myworkout.board.model.dto;

import lombok.NoArgsConstructor;

//@Data
@NoArgsConstructor
//@AllArgsConstructor
public class User {
	private String userId;
	private String password;
	private String nickname;
	private int height;
	private int weight;
	private int gender;
	private int photo;
	private String treasure;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public int getPhoto() {
		return photo;
	}

	public void setPhoto(int photo) {
		this.photo = photo;
	}

	public String getTreasure() {
		return treasure;
	}

	public void setTreasure(String treasure) {
		this.treasure = treasure;
	}

	public User(String userId, String password, String nickname, int height, int weight, int gender, int photo,
			String treasure) {
		this.userId = userId;
		this.password = password;
		this.nickname = nickname;
		this.height = height;
		this.weight = weight;
		this.gender = gender;
		this.photo = photo;
		this.treasure = treasure;
	}

}
