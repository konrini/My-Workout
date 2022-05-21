//package com.myworkout.board.controller;
//
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import javax.servlet.http.HttpSession;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.myworkout.board.model.dto.User;
//import com.myworkout.board.model.dto.Video;
//import com.myworkout.board.model.service.UserService;
//import com.myworkout.board.util.JWTUtil;
//
//@RestController
//@RequestMapping("/user")
//public class UserController {
//
//	private static final String SUCCESS = "success";
//	private static final String FAIL = "fail";
//
//	@Autowired
//	private UserService UserService;
//
//	@Autowired
//	private JWTUtil jwtUtil;
//
//	// 회원 조회 
//	@GetMapping("/")
//	public ResponseEntity<List<User>> userlist() {
//		return new ResponseEntity<List<User>>(UserService., HttpStatus.OK);
//	}
//	
//	// 회원 등록
//	@PostMapping("/")
//	
//	// 회원 삭제
//	@DeleteMapping("/")
//		
//	@PostMapping("/login")
//	public ResponseEntity<Map<String, Object>> login(@RequestBody User user) {
//		System.out.println(user);
//		HttpStatus status = null;
//
//		HashMap<String, Object> result = new HashMap<>();
//		try {
//			if (user.getUserId() != null || user.getUserId().length() > 0) {
//				result.put("access-token", jwtUtil.createToken("id", user.getUserId()));
//				result.put("message", SUCCESS);
//				status = HttpStatus.ACCEPTED;
//			} else {
//				result.put("message", FAIL);
//				status = HttpStatus.ACCEPTED;
//			}
//		} catch (Exception e) {
//			result.put("message", FAIL);
//			status = HttpStatus.INTERNAL_SERVER_ERROR;
//		}
//		return new ResponseEntity<Map<String, Object>>(result, status);
//	}
//
//	@GetMapping("/login")
//	public String loginForm() {
//		return "user/login";
//	}
//
//	@GetMapping("logout")
//	public String logout(HttpSession session) {
//		session.invalidate();
//		return "redirect:/";
//	}
//
//	@PostMapping("/join")
//	public String join(User user, String msg) {
//		try {
//			userService.join(user, msg);
//		} catch (Exception e) {
////			e.printStackTrace();
////			System.out.println(e.getMessage());
//			return "redirect:/user/join";
//		}
//		return "redirect:/user/login";
//	}
//}
