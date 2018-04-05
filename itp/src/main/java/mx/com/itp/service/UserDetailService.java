package mx.com.itp.service;

import java.util.List;

import mx.com.itp.entity.UserDetail;

public interface UserDetailService {

	public List<UserDetail> getUserDetails();

	public void saveUserDetail(UserDetail theUserDetail);

	public UserDetail getUserDetail(int theId);

	public void deleteUserDetail(int theId);

	public List<UserDetail> searchUser(String searchName);

}
