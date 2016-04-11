package server;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Login extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 response.setContentType("text/html");  
		   
		    ObjectOutputStream out=new ObjectOutputStream(response.getOutputStream());
		         
		    String n=request.getParameter("name");  
		    String p=request.getParameter("pass");
		    System.out.println(n);
		    System.out.println(p);
		          
		    if(validate(n, p)){  
		       out.writeObject("Succesfully Login");
		    
		    }  
		    else{  
		       out.writeObject("Sorry username or password error");
		    			       
		    }  
		          
		    out.close();  
		    }  
		
	
	public static boolean validate(String name,String pass){  
		boolean status=false;  
		try{  
			Class.forName("oracle.jdbc.driver.OracleDriver");
	    	Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","oracle");
		      
		PreparedStatement ps=con.prepareStatement(  
		"select * from javatpoint_user where name=? and password=?");  
		ps.setString(1,name);  
		ps.setString(2,pass);  
		      
		ResultSet rs=ps.executeQuery();  
		status=rs.next();  
		          
		}catch(Exception e){System.out.println(e);}  
		return status;  
		}  
	public void doPost(HttpServletRequest request,HttpServletResponse response)
    throws ServletException, IOException {
doGet(request, response);

}
}
