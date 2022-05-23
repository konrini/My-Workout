package com.myworkout.board.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myworkout.board.model.dto.User;
import com.myworkout.board.model.service.UserService;
import com.myworkout.board.util.JWTUtil;

@RestController
@RequestMapping("/user")
public class UserController {

	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";

	@Autowired
	private UserService UserService;

	@Autowired
	private JWTUtil jwtUtil;

	// 회원 목록 조회
//	@GetMapping("/")
//	public ResponseEntity<List<User>> userlist() throws Exception {
//		return new ResponseEntity<List<User>>(UserService.getUserList(), HttpStatus.OK);
//	}

	// 로그인
	@PostMapping("/login")
	public ResponseEntity<Map<String, Object>> login(@RequestBody User user) throws Exception {
		HttpStatus status = null;
		HashMap<String, Object> result = new HashMap<>();
		List<User> userList = UserService.getUserList();
		boolean check = false;
		for (int i = 0; i < userList.size(); i++) {
			if (userList.get(i).getUserId().equals(user.getUserId())) {
				check = true;
				break;
			}
		}
		try {
			if (check) {
				User user_login = UserService.login(user.getUserId(), user.getPassword());
				result.put("access-token", jwtUtil.createToken("id", user.getUserId()));
				result.put("message", SUCCESS);
				status = HttpStatus.ACCEPTED;
			} else {
				result.put("message", FAIL);
				status = HttpStatus.ACCEPTED;
			}
		} catch (Exception e) {
			result.put("message", FAIL); 
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<Map<String, Object>>(result, status);
	}

	@GetMapping("logout")
	public ResponseEntity<String> logout(HttpSession session) throws Exception {
		session.invalidate();
		return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
	}
	
	@PostMapping("/join")
	public ResponseEntity<String> join(@RequestBody User user) throws Exception {
		UserService.join(user);
		return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
	}

	@GetMapping("/{userId}")
	public ResponseEntity<User> userdetail(@PathVariable String userId) throws Exception {
		return new ResponseEntity<User>(UserService.getUser(userId), HttpStatus.OK);
	}
	
	@PutMapping("/")
	public ResponseEntity<String> update(User user) throws Exception {
		UserService.modifyUser(user);
		return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
	}
	
	@DeleteMapping("/{userId}")
	public ResponseEntity<String> delete(@PathVariable String userId) throws Exception{
		if (UserService.removeUser(userId) == 1) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}
}
