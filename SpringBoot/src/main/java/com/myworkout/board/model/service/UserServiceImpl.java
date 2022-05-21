//package com.myworkout.board.model.service;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import com.myworkout.board.model.dao.UserDao;
//import com.myworkout.board.model.dto.User;
//import com.myworkout.board.util.SHA256;
//
//@Service("UserService")
//public class UserServiceImpl implements UserService {
//
//	@Autowired
//	private UserDao userDao;
//	
//	@Transactional
//	@Override
//	public void join(User user, String msg) throws Exception {
//		user.setPassword((new SHA256().getHash(user.getPassword())));
//		userDao.insertUser(user);
//	}
//
//	@Override
//	public User login(String id, String password) throws Exception {
//		User user = userDao.selectById(id);
////		if (user == null)
////			throw new UserNotFoundException();
////		if (!user.getPassword().equals(new SHA256().getHash(password)))
////			throw new PWIncorrectException();
////		else
////			return user;
//		if (user.getPassword().equals(new SHA256().getHash(password)))
//			return user;
//	}
//}
