package com.telusko.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UpdateData {
	
	@Autowired
	private DataSource dataSource;
	int rowsAffected;
	Scanner sc=null;
	

	public UpdateData() {
		super();
		// TODO Auto-generated constructor stub
		System.out.println("UpdateData object created..");
	}
	
	

	public int update() {
		
		try {
			
			Connection connect=dataSource.getConnection();
			String QUERY= "update student set name=?,age=?,address=? where id=?";
			PreparedStatement pstmt=connect.prepareStatement(QUERY);
			 sc=new Scanner(System.in);
			System.out.println("Enter The Id You Want To Update :");
			int id=sc.nextInt();
			pstmt.setInt(4, id);
			sc.nextLine();
			System.out.println("Enter The Correct Name :");
			String name=sc.nextLine();
			pstmt.setString(1, name);
			
			System.out.println("Enter The Correct Age :");
			int age=sc.nextInt();
			pstmt.setInt(2, age);
			sc.nextLine();
			
			System.out.println("Enter The Correct Address :");
			String address=sc.nextLine();
			pstmt.setString(3, address);
			
			rowsAffected =pstmt.executeUpdate();
			
		} 
		
		
		
		
		
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		catch(Exception e) {
			
			e.printStackTrace();
		}
	
		sc.close();
		return rowsAffected;
	}
	
	
}
