/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BookFay.Controller;
import BookFay.DBconnection.BookFayConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Qhristen
 */
public class LibrarianDBController {
    
	public static int save(String name,String password,String email,String address,String city,String contact, String type){
		int status=0;
		try(Connection con=BookFayConnection.getConnection()){
			try(PreparedStatement ps=con.prepareStatement("insert into librarian(name,password,email,address,city,contact,user_type) values(?,?,?,?,?,?,?)")){
                        ps.setString(1,name);
			ps.setString(2,password);
			ps.setString(3,email);
			ps.setString(4,address);
			ps.setString(5,city);
			ps.setString(6,contact);
                        ps.setString(7,type);
                        
			status = ps.executeUpdate();  
                            
                        }
                         try(PreparedStatement ps=con.prepareStatement("insert into login (name,password,matric,user_type) values(?,?,?,?)")){
                        ps.setString(1,name);
			ps.setString(2,password);
                        ps.setString(3, "");
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
			Connection con=BookFayConnection.getConnection();
			PreparedStatement ps=con.prepareStatement("delete from librarian where id=?");
			ps.setInt(1,id);
			status = ps.executeUpdate();
			con.close();
		}catch(Exception e){System.out.println(e);}
		return status;
	}

	public static boolean validate(String name,String password){
		boolean status=false;
		try{
			Connection con=BookFayConnection.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from librarian where name=? and password=?");
			ps.setString(1,name);
			ps.setString(2,password);
			ResultSet rs=ps.executeQuery();
			status=rs.next();
			con.close();
		}catch(Exception e){System.out.println(e);}
		return status;
	}
    
}
