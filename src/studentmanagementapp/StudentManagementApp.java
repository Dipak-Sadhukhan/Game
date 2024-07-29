package studentmanagementapp;

import DataAccessObject.StudentDAO;
import entity.Student;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StudentManagementApp {

  
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int op=0, id=0;
        String Name =" ", PhoneNumber=" ", City=" ";
        boolean status = false;
        while(true)
        {
             System.out.println("Hello Welcome to Student Management App!");
             System.out.println("Enter 1 to Display to all the Students.");
             System.out.println("Enter 2 to Insert in  Students.");
             System.out.println("Enter 3 to Update the Students.");
             System.out.println("Enter 4 to Delete the Students.");
             System.out.println("Enter 5 to Exit.");
             
             op = Integer.parseInt(br.readLine());
             
             if(op == 1)
             {
                 StudentDAO.dispalyStudent();
             }
             else if(op == 2)
             {
                 // Insert....
                 System.out.println("Enter the name of the Student ");
                 Name = br.readLine();
                 System.out.println("Enter the Phone number of the Student ");
                 PhoneNumber = br.readLine();
                 System.out.println("Enter the name of the City ");
                 City = br.readLine();
                 
                 Student st = new Student(Name, PhoneNumber, City);
                 status = StudentDAO.insertStudentToDB(st);
                 
                 if(status)
                 {
                     System.out.println("Success!");
                 }
                 else
                 {
                     System.out.println("Something went wrong! Please try again.");
                 }
             }
             else if(op == 3)
             {
                 // Update Student......
                 System.out.println("We suggest you to kindly display all the Students for confirming the student id, whom to be updated!");
                 System.out.println("Enter the Student id");
                 id = Integer.parseInt(br.readLine());
                 
                 System.out.println("Enter 1 to Update Name");
                 System.out.println("Enter 2 to Update Phone");
                 System.out.println("Enter 3 to Update City");
                 
                 op = Integer.parseInt(br.readLine());
                 
                 if(op==1)
                 {
                     //Update name...
                     System.out.println("Enter the new Name");
                     Name  = br.readLine();
                     status = StudentDAO.updateStudent(id, op, Name);
                     if(status)
                     {
                        System.out.println("Success!");
                     }
                     else
                     {
                        System.out.println("Something went wrong! Please try again.");
                     }
                 }
                 else if(op==2)
                 {
                     //Update phone number...
                     System.out.println("Enter the new Phone Number");
                     PhoneNumber  = br.readLine();
                     status = StudentDAO.updateStudent(id, op, PhoneNumber);
          
                     if(status)
                     {
                        System.out.println("Success!");
                     }
                     else
                     {
                        System.out.println("Something went wrong! Please try again.");
                     }
                 }
                 else if(op==3)
                 {
                     //Update city...
                     System.out.println("Enter the new City");
                     City  = br.readLine();
                     status = StudentDAO.updateStudent(id, op, City);
                     if(status)
                     {
                        System.out.println("Success!");
                     }
                     else
                     {
                        System.out.println("Something went wrong! Please try again.");
                     }
                 }
                 else
                 {
                    System.out.println("Please enter the right option! and try again"); 
                 }
                 
             }
             else if(op == 4)
             {
                 // Delete.....
                 System.out.println("We suggest you to kindly display all the Students for confirming the student id, whom to be Deleted!");
                 System.out.println("Enter the Student id");
                 id = Integer.parseInt(br.readLine());
                 
                 status = StudentDAO.deleteStudent(id);
                 if(status)
                 {
                    System.out.println("Success!");
                 }
                 else
                 {
                    System.out.println("Something went wrong! Please try again.");
                 }
             }
             else if(op == 5)
             {
                 System.out.println("Thanks for using our Application! Hope you enjoyred! See you.");
                 break;
             }
             
        }
       
    }
    
}
