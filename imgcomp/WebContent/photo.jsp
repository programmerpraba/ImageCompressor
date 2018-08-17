<%@page import="com.img.util.DbConnector"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.io.OutputStream"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   
<%

String id=request.getParameter("id");
String imageno=request.getParameter("img");
Connection con=null;
PreparedStatement ps=null;
ResultSet rs=null;
OutputStream photo;
try{
	con=DbConnector.createConnection();
	String query="select "+imageno+" from img where imgid="+id+"";
	System.out.println(query);
	ps=con.prepareStatement(query);
	rs=ps.executeQuery();
	while(rs.next()){
		byte array[]=rs.getBytes(1);
	    photo=	response.getOutputStream();
	    photo.write(array);
	    photo.flush();
	    photo.close();
	    return;
	}
	
}catch(Exception e){
	System.out.println(e);
	
}



%>