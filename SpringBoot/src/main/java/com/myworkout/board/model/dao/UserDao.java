package com.myworkout.board.model.dao;

import java.util.List;

import com.myworkout.board.model.dto.User;

public interface UserDao{
	// 회원 추가
	void insertUser(User user) throws Exception;
	
	// 회원 목록 검색
	List<User> selectAllUsers() throws Exception;
	
	// 회원 삭제
	int DeleteUser(String userId);
	
	// 회원 수정
	int UpdateUser(User user);
	
	// 회원 검색
	User selectOneUser(String userId) throws Exception;

	// 별명 이름 가져오기
	String getNickname(String followerId);
}