package DataAccessObject;

import connectionProvider.CP;
import entity.Student;
import java.sql.*;


public class StudentDAO {
    public static boolean insertStudentToDB(Student student)
    {
        boolean status = false;
        try
        {
        Connection con = CP.getConnection();        
        DatabaseMetaData meta = con.getMetaData();
        
        ResultSet set = meta.getTables(null, null, "student", null);
        
            if(set.next())
            {
                // Table Exists...
                //INSERT.....
                String insertQuery = "INSERT INTO Student(sname, sNumber, sCity) values(?, ?, ?)";

                PreparedStatement preparedStatement = con.prepareStatement(insertQuery);

                preparedStatement.setString(1, student.getName());
                preparedStatement.setString(2, student.getNumber());
                preparedStatement.setString(3, student.getCity());

                preparedStatement.executeUpdate();

            }
            else
            {
                // create table
                String createTable = "create table Student( sid int auto_increment, sName varchar(200), sNumber varchar(10), sCity varchar(200), primary key(sid))";
                Statement statement = con.createStatement();
                statement.executeUpdate(createTable);

                // Insert...

                String insertQuery = "INSERT INTO Student(sname, sNumber, sCity) values(?, ?, ?)";

                PreparedStatement preparedStatement = con.prepareStatement(insertQuery);

                preparedStatement.setString(1, student.getName());
                preparedStatement.setString(2, student.getNumber());
                preparedStatement.setString(3, student.getCity());

                preparedStatement.executeUpdate();
            }
            status = true;
        
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return status;
        }
        return status;       
    }
    
    public static boolean updateStudent(int sid, int option, String val)
    {
        boolean status =false;
        try
        {
            Connection con =CP.getConnection();
            if(option==1)
            {
                // upadte name
                String query = "update student set sName = ? where  sid = ?";
                PreparedStatement preparedStatement = con.prepareStatement(query);
                preparedStatement.setString(1, val);
                preparedStatement.setInt(2, sid);
                
                preparedStatement.executeUpdate();
            }
            else if(option == 2)
            {
                // update phone number
                String query = "update student set sNumber = ? where  sid = ?";
                PreparedStatement preparedStatement = con.prepareStatement(query);
                preparedStatement.setString(1, val);
                preparedStatement.setInt(2, sid);
                
                preparedStatement.executeUpdate();
            }
            else
            {
                // update city
                String query = "update student set sCity = ? where  sid = ?";
                PreparedStatement preparedStatement = con.prepareStatement(query);
                preparedStatement.setString(1, val);
                preparedStatement.setInt(2, sid);
                
                preparedStatement.executeUpdate();
            }
            status = true;
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return status;            
        }
        return status;
    }
    
    public static boolean deleteStudent(int sid)
    {
          boolean status = false;
        try
        {
        Connection con = CP.getConnection(); 

        String query = "DELETE from student where sid = ?";

        PreparedStatement preparedStatement = con.prepareStatement(query);

        preparedStatement.setInt(1,sid);

        preparedStatement.executeUpdate();
        status = true;
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return status;
        }
        return status;
        
    }
    
    public static void dispalyStudent()
    {
        try
        {
            Connection con = CP.getConnection();
            String query = "Select * from student";
            
            
            Statement statement = con.createStatement();
            ResultSet set = statement.executeQuery(query);
            int c=0;
            while(set.next())
            {
                c++;
                System.out.println("Student Id = "+set.getInt(1));
                System.out.println("Student Name = "+set.getString(2));
                System.out.println("Student Number = "+set.getString(3));
                System.out.println("Student City = "+set.getString(4));
                System.out.println("*************************************");
            }
            if(c==0)
            {
                System.out.println("No Data Found !! please Insert some data first to dispaly.");
            }
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
