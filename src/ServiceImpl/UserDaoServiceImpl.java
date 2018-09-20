package ServiceImpl;

import entity.User;
import Dao.UserDao;
import DaoImpl.UserDaoImpl;
import Service.UserDaoService;

public class UserDaoServiceImpl implements UserDaoService{
	UserDao ud=new UserDaoImpl();
	public User login(String name, String pwd) {
		// TODO Auto-generated method stub
		return ud.login(name, pwd);
	}

}
