package com.telusko.service;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.telusko.bean.Student;


@Service
public class ManageOperations {
	
	
	private boolean flag=true;
	
	
	
	@Autowired
	private InsertData insertData;
	
	@Autowired
	private DisplayData displayData;
	
	@Autowired
	private DeleteData deleteData;
	
	@Autowired
	private UpdateData updateData;
	
	@Autowired
	private DisplayDataById displayDataByID;
	
	
	public ManageOperations()
	{
		System.out.println("Manage Operations object created...");
	}
	
	
	public void task() {
		
		Scanner sc1=new Scanner(System.in);
		while(flag) {
		
		System.out.println();
		System.out.println();
		System.out.println("*********Welcome to CRUD Operations***********");
		System.out.println("Insert Operation----> Press 1");
		System.out.println("Display Operation----> Press 2");
		System.out.println("Update Operation----> Press 3");
		System.out.println("Delete Operation-----> Press 4");
		System.out.println("Display Data By Id Operation-----> Press 5");
		System.out.println("End Program---->Press 6");
		
		int option=sc1.nextInt();
		sc1.nextLine();
		System.out.println("Option :"+ option);
		
		switch(option) {
		
		case 1:
			System.out.println("****************Insert Data********************");
			insertData.insert();
			break;
			
			
		case 2: System.out.println("************Display Data********************");
				List<Student> listOfStudents=displayData.display();
				Iterator<Student> itr=listOfStudents.iterator();
				while(itr.hasNext()) {
					
					System.out.println(itr.next());
				}
				break;
		case 3: System.out.println("***********Update Data**********************");
				int rowsAffected=updateData.update();
				if(rowsAffected==1) {
					
					System.out.println("Data updated successfully in the Database.");
				}
				
				break;
				
		case 4: System.out.println("************Delete Data**********************");
				deleteData.delete();
				break;
				
				
		case 5: System.out.println("************Display Data By ID**************************");
				displayDataByID.displayDataById();
				break;
				
		case 6: System.out.println("************The END**************************");
			flag=false;
			break;
		
		default:
			System.out.println("Incorrect Option Selected....");
		
		}
	
		
		}
		
		sc1.close();
	}
}
