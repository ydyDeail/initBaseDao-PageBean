package Dao;

import entity.User;

public interface UserDao {
	User login(String name,String pwd);
}
