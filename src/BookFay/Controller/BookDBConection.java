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
 * @author Qhris
 */
public class BookDBConection {
    public static int save(String isbn,String name,String author,String publisher,String quantity){
	int status=0;
	try{
		Connection con = BookFayConnection.getConnection();
		PreparedStatement ps=con.prepareStatement("insert into books(ISBN,name,author,publisher,quantity) values(?,?,?,?,?)");
		ps.setString(1,isbn);
		ps.setString(2,name);
		ps.setString(3,author);
		ps.setString(4,publisher);
		ps.setString(5,quantity);
		status = ps.executeUpdate();
		con.close();
	}catch(Exception e){System.out.println(e);}
	return status;
}
    public static int delete(int id){
		int status=0;
		try{
			Connection con=BookFayConnection.getConnection();
			PreparedStatement ps=con.prepareStatement("delete from books where id=?");
			ps.setInt(1,id);
			status = ps.executeUpdate();
			con.close();
		}catch(Exception e){System.out.println(e);}
		return status;
	}
}
