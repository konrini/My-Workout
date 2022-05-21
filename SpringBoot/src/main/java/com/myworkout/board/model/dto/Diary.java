package com.myworkout.board.model.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

//@Data
@NoArgsConstructor
@AllArgsConstructor
public class Diary {
	private int id;
	private String category;
	private String diary;
	private String date;
	private int changedWeight;
	private int changedHeight;
	private String userId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDiary() {
		return diary;
	}

	public void setDiary(String diary) {
		this.diary = diary;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getChangedWeight() {
		return changedWeight;
	}

	public void setChangedWeight(int changedWeight) {
		this.changedWeight = changedWeight;
	}

	public int getChangedHeight() {
		return changedHeight;
	}

	public void setChangedHeight(int changedHeight) {
		this.changedHeight = changedHeight;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

}
