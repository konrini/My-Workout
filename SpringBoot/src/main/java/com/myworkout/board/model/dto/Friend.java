package com.myworkout.board.model.dto;

import lombok.NoArgsConstructor;

//@Data
@NoArgsConstructor
//@AllArgsConstructor
public class Friend {
	private int friendId;
	private String targetId;
	private String followerId;

	public int getFriendId() {
		return friendId;
	}

	public void setFriendId(int friendId) {
		this.friendId = friendId;
	}

	public String getTargetId() {
		return targetId;
	}

	public void setTargetId(String targetId) {
		this.targetId = targetId;
	}

	public String getFollowerId() {
		return followerId;
	}

	public void setFollowerId(String followerId) {
		this.followerId = followerId;
	}

	public Friend(int friendId, String targetId, String followerId) {
		this.friendId = friendId;
		this.targetId = targetId;
		this.followerId = followerId;
	}

}
