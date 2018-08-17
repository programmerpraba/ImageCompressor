<%@page import="com.img.util.DbConnector"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<!-- //<img alt="hi" height="120 px" width="120 px"  src="photo.jsp?id="""><a href="">Download 50%</a><br> -->

	<%
	String files=request.getParameter("files");
	String imageid=request.getParameter("imageid");
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String size1="";
		String size2="";
		String size3="";
		try {
			con = DbConnector.createConnection();
			ps = con.prepareStatement("select img1size,img2size,img3size from img where imgid="+imageid+"");
			rs = ps.executeQuery();
			if (rs.next()) {
			size1=rs.getString(1);
			size2=rs.getString(2);
			size3=rs.getString(3);
			}
	%>
	<img alt="hi" height="120 px" width="120 px"
		src="photo.jsp?id=<%=imageid%>&img=image1">
	<a href="downloadFileServlet?id=<%=imageid%>&img=image1">Download</a> <%=size1 %> <br>
	
	<% if(files.equals("all")){ %>
	<img alt="hi" height="120 px" width="120 px"
		src="photo.jsp?id=<%=imageid%>&img=image2">
	<a href="downloadFileServlet?id=<%=imageid%>&img=image2">Download</a> <%=size2 %> <br>
	<img alt="hi" height="120 px" width="120 px"
		src="photo.jsp?id=<%=imageid%>&img=image3">
	<a href="downloadFileServlet?id=<%=imageid%>&img=image3">Download</a> <%=size3 %>
	
	<%
	}
		} catch (Exception e) {
			System.out.println(e);
		}
	%>

</body>
</html>