package com.myworkout.board.model.dto;

public class VideoReview {
	private int reviewId;
	private String content;
	private String time;
	private int changed;
	private int userPhoto;
	private String userId;
	private String userNickname;
	private int videoId;

	public VideoReview(String content) {
		this.content = content;
	}

	public int getReviewId() {
		return reviewId;
	}

	public void setReviewId(int reviewId) {
		this.reviewId = reviewId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public int getChanged() {
		return changed;
	}

	public void setChanged(int changed) {
		this.changed = changed;
	}

	public int getUserPhoto() {
		return userPhoto;
	}

	public void setUserPhoto(int userPhoto) {
		this.userPhoto = userPhoto;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserNickname() {
		return userNickname;
	}

	public void setUserNickname(String userNickname) {
		this.userNickname = userNickname;
	}

	public int getVideoId() {
		return videoId;
	}

	public void setVideoId(int videoId) {
		this.videoId = videoId;
	}

	public VideoReview() {
	}

	public VideoReview(String content, int userPhoto, String userId, String userNickname, int videoId) {
		this.content = content;
		this.userPhoto = userPhoto;
		this.userId = userId;
		this.userNickname = userNickname;
		this.videoId = videoId;
	}
	
	public VideoReview(int reviewId, String content, String time, int changed, int userPhoto, String userId,
			String userNickname, int videoId) {
		this.reviewId = reviewId;
		this.content = content;
		this.time = time;
		this.changed = changed;
		this.userPhoto = userPhoto;
		this.userId = userId;
		this.userNickname = userNickname;
		this.videoId = videoId;
	}

}
