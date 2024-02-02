package com.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.Entity.Student;

public class RegisterDao {
	
	private Connection conn;

	public RegisterDao(Connection conn) {
		super();
		this.conn = conn;
	}
	
	
	
	public boolean StudentRegister(Student st) {
		boolean f=false;
		
		try {
			String sql="insert into student(name,email,dob,address,phno,gender,password)  values(?,?,?,?,?,?,?)";
			PreparedStatement ps=conn.prepareStatement(sql);
		
			ps.setString(1, st.getName());
			ps.setString(2, st.getEmail());
			ps.setString(3, st.getDob());
			ps.setString(4, st.getAddress());
			ps.setString(5, st.getPhno());
			ps.setString(6, st.getGender());
			ps.setString(7, st.getPassword());
			
			int i=ps.executeUpdate();
			
			if(i == 1) {
				f=true;
			}
			} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		return f;
	}
}
