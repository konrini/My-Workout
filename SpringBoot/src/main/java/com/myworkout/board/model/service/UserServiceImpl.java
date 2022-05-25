package com.myworkout.board.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myworkout.board.exception.PWIncorrectException;
import com.myworkout.board.exception.UserNotFoundException;
import com.myworkout.board.model.dao.UserDao;
import com.myworkout.board.model.dto.User;
import com.myworkout.board.util.SHA256;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	@Override
	public User login(String userId, String password) throws Exception {
		User user = userDao.selectOneUser(userId);
		if (user == null)
			throw new UserNotFoundException();
		if (!user.getPassword().equals(new SHA256().getHash(password)))
			throw new PWIncorrectException();
		else
			return user;
	}

//	@Transactional
	@Override
	public void join(User user) throws Exception {
		user.setPassword((new SHA256().getHash(user.getPassword())));
		userDao.insertUser(user);
	}

	@Override
	public int modifyUser(User user) throws Exception {
		User originuser = userDao.selectOneUser(user.getUserId());
		originuser.setPassword(user.getPassword());
		originuser.setHeight(user.getHeight());
		originuser.setWeight(user.getWeight());
		originuser.setPhoto(user.getPhoto());
		return userDao.UpdateUser(originuser);
	}

	@Override
	public int removeUser(String userId) throws Exception {
		return userDao.DeleteUser(userId);
	}

	@Override
	public List<User> getUserList() throws Exception {
		return userDao.selectAllUsers();
	}

	@Override
	public User getUser(String userId) throws Exception {
		return userDao.selectOneUser(userId);
	}

	@Override
	public boolean findPW(String userId, String treasure) throws Exception {
		User user = userDao.selectOneUser(userId);
		if (user.getTreasure().equals(treasure)) {
			return true;
		}
		return false;
	}
}
