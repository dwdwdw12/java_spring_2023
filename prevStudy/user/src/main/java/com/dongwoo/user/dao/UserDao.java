package com.dongwoo.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dongwoo.user.domain.User;

public class UserDao {
//	@Autowired		//객체를 알아서 집어넣어줌. xml파일에 bean 하위 항목 필요없음.
	private ConnectionInter inter;	//필요한 객체를 주입받기 위해서 상위 인터페이스 타입으로 정의하고.

	public void setInter(ConnectionInter inter) {	//setter 메서드 만들어주고.
		this.inter = inter;
	}
	
//	public UserDao(ConnectionInter inter) {
//		super();
//		this.inter = inter;
//	}

	public int add(User user) {
		int result=0;
		Connection con = null;
		PreparedStatement ps = null;
		
		con = inter.getConnection();
		try {
			con=inter.getConnection();
			ps = con.prepareStatement("insert into users values(?,?,?)");
			ps.setString(1, user.getId());
			ps.setString(2, user.getName());
			ps.setString(3, user.getPassword());
			result = ps.executeUpdate();	
			
		} catch (SQLException e) {		
			e.printStackTrace();
		} finally {

			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
				}
			}
		}
		
		return result;
	}
	
	public User get(String id) {	
		User user = null;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			con=inter.getConnection();
			ps = con.prepareStatement("select * from users where id =?");
			ps.setString(1, id);
			rs = ps.executeQuery();
			while(rs.next()) {
				user= new User();
				user.setId(rs.getString("id"));
				user.setName(rs.getString("name"));
				user.setPassword(rs.getString("password"));
				return user;	//조기반환(return), 문제가 없으면 
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {	// rs, ps, con은 반드시 닫아주어야 함. 문제 발생 가능
				try {
					rs.close();
				} catch (SQLException e) {
				} 
			}
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
				}
			}
		}
		return user;
	}
	
	public List<User> getAll(String id) {	//list import할 때 주의하기
		List<User> list = null;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			con=inter.getConnection();
			ps = con.prepareStatement("select * from users");
			rs = ps.executeQuery();
			list = new ArrayList<User>();
			while(rs.next()) {
				User user = new User();  
				user.setId(rs.getString("id"));
				user.setName(rs.getString("name"));
				user.setPassword(rs.getString("password"));
				list.add(user);
	
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {	// rs, ps, con은 반드시 닫아주어야 함. 문제 발생 가능
				try {
					rs.close();
				} catch (SQLException e) {
				} 
			}
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
				}
			}
		}
		return list;
	}

}
