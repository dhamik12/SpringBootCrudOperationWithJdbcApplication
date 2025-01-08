package com.telusko.service;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeleteData {
	
	@Autowired
	private DataSource dataSource;
	Scanner sc=null;
	int rowsAffected;
	@Autowired
	private DisplayDataById displayDataById;
	

	public DeleteData() {
		super();
		// TODO Auto-generated constructor stub
		System.out.println("Delete Data object created...");
	}
	
	

	public void delete()
	{
		
		System.out.println("Deleting data from database");
		sc=new Scanner(System.in);
			try {
				
				Connection connect=dataSource.getConnection();
				String SQLQUERY="delete from student where id=?";
				PreparedStatement pstmt=connect.prepareStatement(SQLQUERY);
				System.out.println("Enter the Id you want to delete from the Database.");
				int id=sc.nextInt();
				System.out.println("Data Deleted :");
				displayDataById.displayDataById(id);
				sc.nextLine();
				pstmt.setInt(1, id);
				rowsAffected =pstmt.executeUpdate();
				if(rowsAffected==1) {
					
					System.out.println("Deletion Successfull.");
					
					
				}
				else {
					
					System.out.println("Failed to delete data from database.");
				}
				
			} 
			
			
			
			
			
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("SQLException occured from delete method.");
			}
			
			catch(Exception e) {
				
				
				e.printStackTrace();
				System.out.println("Exception Occured from delete method.");
			}
			
			
		
		
		
	}
	



}
