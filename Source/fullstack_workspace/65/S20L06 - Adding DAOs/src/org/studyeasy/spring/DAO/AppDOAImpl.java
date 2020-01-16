package org.studyeasy.spring.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.studyeasy.spring.model.User;

public class AppDOAImpl implements AppDOA {

	private DataSource dataSource;

	public AppDOAImpl(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public List<User> listUsers() {
		String SQL = "Select * from users";
		List<User> listUsers = new ArrayList<User>();
		Connection conn = null;
		try{
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(SQL);
			ResultSet rs =  ps.executeQuery();
	        while(rs.next()){
	        	User temp = new User(
	        			rs.getInt("user_id"),
	        			rs.getString("name"),
	        			rs.getString("email")
	        			);
	        	listUsers.add(temp);
	        }
	     rs.close();
	     ps.close();
	     return listUsers;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}finally{
			if (conn != null) {
				try {
				conn.close();
				} catch (SQLException e) {e.printStackTrace();}
			}
			
		}
			
	
	}

}



























