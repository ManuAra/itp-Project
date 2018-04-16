package mx.com.itp.dao;

import java.util.List;

import mx.com.itp.entity.UserDetail;

public interface UserDetailDAO {

	public List<UserDetail> getUserDetails();

	public void saveUserDetail(UserDetail theUserDetail);

	public UserDetail getUserDetail(int userId);

	public void deleteUserDetail(int userId);

	public List<UserDetail> searchUser(String searchName);
}
