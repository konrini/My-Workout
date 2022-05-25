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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.myworkout.board.model.dto.User;
import com.myworkout.board.model.service.UserService;
import com.myworkout.board.util.JWTUtil;
import com.myworkout.board.util.SHA256;

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
	public ResponseEntity<Map<String, Object>> login(@RequestParam String userId, @RequestParam String password) throws Exception {
		HttpStatus status = null;
		HashMap<String, Object> result = new HashMap<>();
		User user = UserService.getUser(userId);
		try {
			if (!(user == null)) {
				User user_login = UserService.login(userId, password);
				result.put("access-token", jwtUtil.createToken("id", userId));
				result.put("user", user_login);
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

	@GetMapping("/logout")
	public ResponseEntity<String> logout() throws Exception {
		return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
	}
	
	@GetMapping("/pw")
	public ResponseEntity<String> pwfind(@RequestParam String userId, @RequestParam String treasure) throws Exception {
		if (UserService.findPW(userId, treasure)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);			
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.OK);	
	}

	@PutMapping("/pw")
	public ResponseEntity<String> pwreset(@RequestParam String userId, @RequestParam String password) throws Exception {
		User user = UserService.getUser(userId);
		user.setPassword(new SHA256().getHash(password));
		UserService.modifyUser(user);
		return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);	
	}
	
	@PostMapping("/join")
	public ResponseEntity<String> join(@RequestParam String userId, @RequestParam String password, @RequestParam int height,
			@RequestParam int weight, @RequestParam String nickname, @RequestParam String treasure, 
			@RequestParam int selectedGender, @RequestParam int selectedPhoto) throws Exception {
		User new_user = new User(userId, password, nickname, height, weight, selectedGender, selectedPhoto, treasure);
		UserService.join(new_user);
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
