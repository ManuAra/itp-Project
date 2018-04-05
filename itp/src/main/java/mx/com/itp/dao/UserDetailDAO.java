package mx.com.itp.dao;

import java.util.List;

import mx.com.itp.entity.UserDetail;

public interface UserDetailDAO {

	public List<UserDetail> getUserDetails();

	public void saveUserDetail(UserDetail theUserDetail);

	public UserDetail getUserDetail(int theId);

	public void deleteUserDetail(int theId);

	public List<UserDetail> searchUser(String searchName);
}
