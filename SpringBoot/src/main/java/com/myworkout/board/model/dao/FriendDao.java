package com.myworkout.board.model.dao;

import java.util.List;

import com.myworkout.board.model.dto.Friend;

public interface FriendDao {
	// 친구 추가하기 (팔로우 추가)
	void insertFollowing(Friend friend);
	
	// 친구 삭제하기 (팔로우 삭제)
	void DeleteFollowing(String targetId, String followerId);
	
	// 내가 팔로우 하는 사람들
	List<Friend> selectMyFollowings(String targetId);
	
	// 나를 팔로우 하는 사람
	List<Friend> selectMyFollowers(String targetId);
	
}
