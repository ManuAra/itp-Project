package mx.com.itp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.com.itp.dao.UserDetailDAO;
import mx.com.itp.entity.UserDetail;

@Service
public class UserDetailServiceImpl implements UserDetailService {

	@Autowired
	private UserDetailDAO userDetailDAO;

	@Override
	@Transactional
	public List<UserDetail> getUserDetails() {
		
		return userDetailDAO.getUserDetails();
	}

	@Override
	@Transactional
	public void saveUserDetail(UserDetail theUserDetail) {
		
		userDetailDAO.saveUserDetail(theUserDetail);
		
	}

	@Override
	@Transactional
	public UserDetail getUserDetail(int userId) {
		
		return userDetailDAO.getUserDetail(userId);
	}

	@Override
	@Transactional
	public void deleteUserDetail(int userId) {
		
		userDetailDAO.deleteUserDetail(userId);
		
	}

	@Override
	@Transactional
	public List<UserDetail> searchUser(String searchName) {
		
		return userDetailDAO.searchUser(searchName);
	}
}
