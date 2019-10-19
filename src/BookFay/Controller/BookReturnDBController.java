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

/**
 *
 * @author Qhris
 */
public class BookReturnDBController {
    public static int delete(int id,int studentid){
		int status=0;
		try{
			Connection con=BookFayConnection.getConnection();
			
			status=updatebook(id);//updating quantity and issue
			
			if(status>0){
			PreparedStatement ps=con.prepareStatement("delete from issuebooks where Book_Id=? and studentid=?");
			ps.setInt(1,id);
			ps.setInt(2,studentid);
			status=ps.executeUpdate();
			}
			
			con.close();
		}catch(Exception e){System.out.println(e);}
		return status;
	}
	public static int updatebook(int Bookid){
		int status=0;
		int quantity=0;
		try{
			Connection con=BookFayConnection.getConnection();
			
			PreparedStatement ps=con.prepareStatement("select quantity from books where id=?");
			ps.setInt(1,Bookid);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				quantity=rs.getInt("quantity");
//				issued=rs.getInt("issued");
			}
			
			if(quantity > 0){
			PreparedStatement ps2=con.prepareStatement("update books set quantity=? where id=?");
			ps2.setInt(1,quantity+1);
			ps2.setInt(2,Bookid);
			
			status=ps2.executeUpdate();
			}
			con.close();
		}catch(Exception e){System.out.println(e);}
		return status;
    
}
}