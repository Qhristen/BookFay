/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BookFay.Controller;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import BookFay.DBconnection.BookFayConnection;
import java.util.Date;

/**
 *
 * @author Qhris
 */
public class BooksIssueDBController {
    	
public static boolean checkBook(int BookId){
	boolean status=false;
	try{
		Connection con = BookFayConnection.getConnection();
		PreparedStatement ps=con.prepareStatement("select * from books where id=?");
		ps.setInt(1,BookId);
	    ResultSet rs=ps.executeQuery();
		status=rs.next();
		con.close();
	}catch(Exception e){System.out.println(e);}
	return status;
}

public static int save(int BookId,String studentid,String studentname,String studentcontact, String ReturnDate){
	int status=0;
	try{
		Connection con = BookFayConnection.getConnection();		
		status=updatebook(BookId);//updating quantity and issue
		if(status>0){
		PreparedStatement ps=con.prepareStatement("insert into issuebooks(Book_Id,studentid,studentname,studentcontact,ReturnDate) values(?,?,?,?,?)");
		ps.setInt(1,BookId);
		ps.setString(2,studentid);
		ps.setString(3,studentname);
		ps.setString(4,studentcontact);
                ps.setString(5, ReturnDate);
		status=ps.executeUpdate();
		}
		
		con.close();
	}catch(Exception e){System.out.println(e);}
	return status;
}
public static int updatebook(int BookId){
	int status=0;
	int quantity=0,issued=0;
	try{
		Connection con=BookFayConnection.getConnection();
		
		PreparedStatement ps=con.prepareStatement("select quantity from books where id=?");
		ps.setInt(1,BookId);
		ResultSet rs=ps.executeQuery();
		if(rs.next()){
			quantity=rs.getInt("quantity");
			
		}
		
		if(quantity>0){
		PreparedStatement ps2=con.prepareStatement("update books set quantity=? where id=?");
		ps2.setInt(1,quantity-1);
	
		ps2.setInt(2,BookId);
		
		status=ps2.executeUpdate();
		}
		con.close();
	}catch(Exception e){System.out.println(e);}
	return status;
}

public static int delete(int id){
		int status=0;
		try{
			Connection con=BookFayConnection.getConnection();
			PreparedStatement ps=con.prepareStatement("delete from issuebooks where Book_Id=?");
			ps.setInt(1,id);
			status = ps.executeUpdate();
			con.close();
		}catch(Exception e){System.out.println(e);}
		return status;
	}
}
