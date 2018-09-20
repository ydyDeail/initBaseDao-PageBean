package Dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class BaseDao {
	private static String CLASSNAME="com.mysql.jdbc.Driver";
	private static String URL="jdbc:mysql://localhost:3306/haha?useUnicode=true&characterEncoding=utf-8";
	private static String USER="root";
	private static String PWD="root";
	/*static{
		Properties prop=new Properties();
		BaseDao.class.getClassLoader().getResourceAsStream("datasource.properties");
	}*/
	public Connection getConnection(){
		Connection con=null;
		try {
			Class.forName(CLASSNAME);
			con=DriverManager.getConnection(URL,USER,PWD);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*try {
			Context ctx=new InitialContext();
			DataSource ds=(DataSource)ctx.lookup("newJdbc");
			con=ds.getConnection();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		return con;
	}
	public int executeUpdate(String sql,Object... parameters){
		Connection con=this.getConnection();
		PreparedStatement ps=null;
		int result=0;
		try {
			ps=con.prepareStatement(sql);
			int i=0;
			for(Object p:parameters){
				ps.setObject((i+1), p);
				i++;
			}
			
			result=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			this.Close(con, null, ps);
		}
		return result;
	}
	public void Close(Connection con,ResultSet rs,Statement st){
		if(rs!=null){
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(st!=null){
			try {
				st.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(con!=null){
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

