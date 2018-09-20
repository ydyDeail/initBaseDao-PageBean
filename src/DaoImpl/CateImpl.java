package DaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Category;

import Dao.BaseDao;
import Dao.Cate;

public class CateImpl extends BaseDao implements Cate{

	public int findAll() {
		// TODO Auto-generated method stub
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		int result=0;
		int count=0;
		try {
			con=this.getConnection();
			ps=con.prepareStatement("SELECT COUNT(id) as c FROM news_category");
			rs=ps.executeQuery();
			if(rs.next()){
				count=rs.getInt("c");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}

	public List<Category> findAllType(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		List<Category> li=new ArrayList<Category>();
		try {
			con=this.getConnection();
			ps=con.prepareStatement("SELECT * FROM news_category limit ?,?");
			ps.setInt(1, (pageNo-1)*pageSize);
			ps.setInt(2, pageSize);
			rs=ps.executeQuery();
			while(rs.next()){
				Category c=new Category(rs.getInt(1), rs.getString(2), rs.getTimestamp(3),rs.getString(4));
				li.add(c);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			this.Close(con, rs, ps);
		}
		return li;
	}

	public int AddFindById(Category cg) {
		// TODO Auto-generated method stub
		Connection con=null;
		PreparedStatement ps=null;
		int result=0;
		Category c=null;
		try {
			con=this.getConnection();
			ps=con.prepareStatement("INSERT  INTO `news_category`(`name`,`createDate`,`pic`) VALUES (?,?,?)");
			
			ps.setString(1, cg.getName());
			ps.setTimestamp(2, cg.getCreateDate());
			ps.setString(3, cg.getPic());
			result=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			this.Close(con, null, ps);
		}
		return result;
	}

}
