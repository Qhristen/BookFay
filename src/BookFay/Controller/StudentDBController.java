/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BookFay.Controller;

import BookFay.DBconnection.BookFayConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author Qhristen
 */
public class StudentDBController {
    public static int save(String name,String password,String email,String Phone,String matric, String type){
		int status=0;
		try(Connection con=BookFayConnection.getConnection()){
			try(PreparedStatement ps=con.prepareStatement("insert into student (stdname,stdpass,stdemail,stdmatric,stdphone, user_type) values(?,?,?,?,?,?)")){
                        ps.setString(1,name);
			ps.setString(2,password);
			ps.setString(3,email);
			ps.setString(4,Phone);
			ps.setString(5,matric);
                        ps.setString(6,type);
			status=ps.executeUpdate();
                        }
			
                        try(PreparedStatement ps=con.prepareStatement("insert into login (name,password,matric,user_type) values(?,?,?,?)")){
                        ps.setString(1,name);
			ps.setString(2,password);
                        ps.setString(3,matric);
                        ps.setString(4,type);
			status=ps.executeUpdate();
			con.close();
                        }
			
		}catch(Exception e){System.out.println(e);}
		return status;
                
               
	}
    
    public static int delete(int id){
		int status=0;
		try{
			Connection con = BookFayConnection.getConnection();
			PreparedStatement ps=con.prepareStatement("delete from student where std_id=?");
			ps.setInt(1,id);
			status = ps.executeUpdate();
			con.close();
		}catch(Exception e){System.out.println(e);}
		return status;
	}


}
