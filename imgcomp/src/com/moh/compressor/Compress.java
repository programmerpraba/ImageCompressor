package com.moh.compressor;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * Servlet implementation class Compress
 */
@MultipartConfig
@WebServlet("/Compress")
public class Compress extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		InputStream inputStream = null;
		Part filePart = request.getPart("fileFldImage");
		if (filePart != null) {
			inputStream = filePart.getInputStream();

		}
		BufferedImage bi = ImageIO.read(inputStream);
System.out.println("TYPE=====>"+filePart.getContentType());
		//System.out.println(new File("G:\\my\\kps.jpg").getName());
String filetype=filePart.getContentType();
		String quality = request.getParameter("quality");
		System.out.println(quality);
		int height=bi.getHeight(); int width=bi.getWidth();
	/*	if(quality.equals("originalSize")){
			height=bi.getHeight();
			width=bi.getWidth();			
		}*/
		if(quality.equals("halfSize")){
			height=height/2;
			width=width/2;
		}
		if(quality.equals("quarterSize")){
			height=height/4;
			width=width/4;
		}
		if(quality.equals("customSize")){
			height=Integer.parseInt(request.getParameter("customHeight"));
			width=Integer.parseInt(request.getParameter("customWidth")); 
		}
		if(quality.equals("all")){
			int imageid=0;
			try {
				DoConvert.rescale(bi, "a", width, height,filetype);
				imageid=DoConvert.imageid;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			response.sendRedirect("download.jsp?files=all&imageid="+imageid+"");
		}
		else {
			int imageid=0;
			try {
			
				System.out.println("Height= "+height+"width= "+width);
				DoConvert.rescale(bi,width,height,filetype);
				imageid=DoConvert.imageid;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			response.sendRedirect("download.jsp?files=single&imageid="+imageid+"");
		}
		

		
		/*
		 * for(int i=1;i<10;i++){ DoConvert.compress(i,bi); }
		 */

	}

}
