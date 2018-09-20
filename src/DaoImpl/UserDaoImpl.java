package DaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entity.User;

import Dao.BaseDao;
import Dao.UserDao;

public class UserDaoImpl extends BaseDao implements UserDao{

	public User login(String name, String pwd) {
		// TODO Auto-generated method stub
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		User user=null;
		con=this.getConnection();
		try {
			ps=con.prepareStatement("select * from user where name=? and pwd=?");
			ps.setString(1, name);
			ps.setString(2, pwd);
			rs=ps.executeQuery();
			if(rs.next()){
				user=new User(rs.getInt(1),rs.getString(2),rs.getString(3));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			this.Close(con, rs, ps);
		}
		
		return user;
	}

}
