
<%@page import="com.img.util.DbConnector"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%
String name=request.getParameter("txtFldFullname");
String email=request.getParameter("txtFldEmail");
String password=request.getParameter("txtFldPword");
String mobile=request.getParameter("txtFldMobile");

System.out.println(name+" "+email+" "+password+" "+mobile);
int userid=0;
Connection con=null;
PreparedStatement ps=null;
try{
	con=DbConnector.createConnection();
	ps=con.prepareStatement("insert into users (userid,name,email,password,mobile) values(?,?,?,?,?)");
	ps.setInt(1, userid);
	ps.setString(2, name);
	ps.setString(3, email);
	ps.setString(4, password);
	ps.setString(5, mobile);
	int i=ps.executeUpdate();
	if(i>0){
request.setAttribute("RegisterSuccess", "User registered successfully");
request.getRequestDispatcher("login.jsp").forward(request, response);
	}
	
}catch(Exception e){
	System.out.println(e);
}
    
    
    %>