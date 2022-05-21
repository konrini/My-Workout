package com.myworkout.board.model.service;

import com.myworkout.board.model.dto.User;

public interface UserService {
	// 회원 가입
	void join(User user, String msg) throws Exception;

	// 로그인
	User login(String id, String password) throws Exception;
}
