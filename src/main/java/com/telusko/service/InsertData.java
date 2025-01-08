package com.telusko.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class InsertData {
	
	@Autowired
	private DataSource dataSource;
		
	Scanner  sc=new Scanner(System.in);
	int rowsAffected;
	
	
	public InsertData()
	{
		
		System.out.println("InsertData obj created.");
	}	
	
	
	public int insert()
	{
		
		System.out.println("***********Student Data************");
		boolean flag=true;
		try {
			
			while(flag) {
			Connection connect=dataSource.getConnection();
			String QUERY="insert into student (address,age,name) values (?,?,?)";
			PreparedStatement pstmt=connect.prepareStatement(QUERY);
			System.out.println("Enter The Name:");
			String name=sc.nextLine();
			pstmt.setString(3, name);
			System.out.println("Enter The Age:");
			int age=sc.nextInt();
			pstmt.setInt(2, age);
			sc.nextLine();
			System.out.println("Enter The Address:");
			String address=sc.nextLine();
			pstmt.setString(1, address);
			
		 rowsAffected=pstmt.executeUpdate();
			
			if(rowsAffected==1)
			{
				
				System.out.println(" Data Inserted Successfully");
				System.out.println("To add another data press 1 else press any other key");
				int addData=sc.nextInt();
				sc.nextLine();
				if(addData==1) {
					
					System.out.println();
					System.out.println();
					System.out.println("            Enter New Data:");
				}
				
				else {
					
					System.out.println("**************Welcome Back to Service Page************");
					flag=false;
					
				}
			}
			
			else
			{
				flag=false;
				System.out.println("Failed to insert data in the dababase.");
				
			}
			
			
			
			
		} 
		
		
		
		}
		
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("SQL exception Occured in insert method.");
		}
		
		catch(Exception e) {
			
			e.printStackTrace();
			System.out.println("Exception occured in insert method.");
		}
		
		//sc.close();
		return rowsAffected;
		
		
		
	}	

}
