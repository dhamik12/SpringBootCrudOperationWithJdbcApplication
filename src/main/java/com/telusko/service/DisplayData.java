package com.telusko.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.telusko.bean.Student;

@Component
public class DisplayData {
	
	@Autowired
	private DataSource dataSource;
	
	
	List<Student> studentList;
	
	

	public DisplayData() {
		super();
		// TODO Auto-generated constructor stub
		System.out.println("Display Data Object created..");
	}
	
	
	public List<Student> display()
	{
		
		System.out.println("Fetching and Displaying Data");
		try {
			
			
			studentList=new ArrayList<>();
			Connection connect=dataSource.getConnection();
			String QUERY="Select id,name,age,address from student";
			PreparedStatement pstmt=connect.prepareStatement(QUERY);
			ResultSet result=pstmt.executeQuery();
			while(result.next()) {
				
				Student student=new Student();
				student.setId( result.getInt(1));
				student.setName(result.getString(2));
				student.setAge(result.getInt(3));
				student.setAddress(result.getString(4));
				studentList.add(student);
				
			}
			
			
			
		} 
		
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		catch(Exception e) {
			
			e.printStackTrace();
		}
		
		return studentList;
		
	}
}
