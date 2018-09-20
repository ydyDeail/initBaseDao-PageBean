package Service;

import entity.User;

public interface UserDaoService {
	User login(String name,String pwd);
}
