/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BookFay.DBconnection;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Qhristen
 */
public class BookFayConnection  {
    public static java.sql.Connection getConnection() throws SQLException{
		
		java.sql.Connection con = null;
		System.out.println("Connected....");
		try{           
			 //Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");	// for Ms access
			Class.forName("com.mysql.jdbc.Driver");	// for mysql
			
		}
		catch(ClassNotFoundException cnf){
			Logger.getLogger(BookFayConnection.class.getName()).log(Level.SEVERE,null,cnf);
		}
		try{							
			//con=DriverManager.getConnection("jdbc:odbc:hstldb1/newhstldb","",""); // connection for Ms access
			
			con=DriverManager.getConnection("jdbc:mysql://localhost/book_fay","root","");// connection for Mysql 

		}								
		catch(SQLException sqe){
			Logger.getLogger(BookFayConnection.class.getName()).log(Level.SEVERE,null,sqe);
		}
		return con;
	}
}
