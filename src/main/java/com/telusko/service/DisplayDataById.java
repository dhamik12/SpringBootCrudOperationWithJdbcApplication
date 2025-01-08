package com.telusko.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;




@Component
public class DisplayDataById {
	
	 int id;
	
	Scanner sc=null;
	
	@Autowired
	private DataSource dataSource;
	
	ResultSet result=null;
	
	
	

	public DisplayDataById() {
		super();
		// TODO Auto-generated constructor stub
		System.out.println("Display Data by Id object created.");
	}
	
	
	
	public void displayDataById(int id) {
		
		System.out.println("Data Display by Id");
		
		try {
			
			this.id=id;
			Connection connect=dataSource.getConnection();
			String SQLQUERY="select id,name,age,address from student where id=?";
			PreparedStatement pstmt=connect.prepareStatement(SQLQUERY);
			pstmt.setInt(1, id);
			result=pstmt.executeQuery();
			while(result.next()) {
				
				int idNum=result.getInt(1);
				String name=result.getString(2);
				int age=result.getInt(3);
				String address=result.getString(4);
				
				System.out.println("Student Details :");
				System.out.println("Id :"+idNum+", "+"Name :"+name+", "+"Age :"+age+", "+"Address :"+address);
				
			}
		} 
		
		
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		
	}
	

	public void displayDataById()
	{
		
try {
		
			Connection connect=dataSource.getConnection();
			String SQLQUERY="select id,name,age,address from student where id=?";
			PreparedStatement pstmt=connect.prepareStatement(SQLQUERY);
			sc=new Scanner(System.in);
			System.out.println("Please enter the id you want to display :");
			int id=sc.nextInt();
			pstmt.setInt(1, id);
			result=pstmt.executeQuery();
			while(result.next()) {
				
				int idNum=result.getInt(1);
				String name=result.getString(2);
				int age=result.getInt(3);
				String address=result.getString(4);
				
				System.out.println("Student Details :");
				System.out.println("Id :"+idNum+", "+"Name :"+name+", "+"Age :"+age+", "+"Address :"+address);
				
			}
		} 
		
	
		
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}	

}
