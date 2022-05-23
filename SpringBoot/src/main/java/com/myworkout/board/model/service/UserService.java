package com.myworkout.board.model.service;

import java.util.List;

import com.myworkout.board.model.dto.User;

public interface UserService {
	// 회원 가입
	void join(User user) throws Exception;

	// 로그인
	User login(String userId, String password) throws Exception;
	
	// 회원 정보 수정
	int modifyUser(User user) throws Exception;
	
	// 회원 삭제
	int removeUser(String userId) throws Exception;
	
	// 회원 목록 조회
	List<User> getUserList() throws Exception;
	
	// 회원 조회
	User getUser(String userId) throws Exception;
}
