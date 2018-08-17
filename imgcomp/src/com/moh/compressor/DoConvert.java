package com.moh.compressor;
import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.Iterator;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.stream.FileImageOutputStream;

import com.img.util.CommonFunctions;
import com.img.util.DbConnector;

import sun.security.acl.OwnerImpl;


public class DoConvert {
	/* */
	static int imageid=0;
     static void rescale(BufferedImage bi, int height, int width, String filetype) throws IOException, SQLException {
  
        int type = bi.getType() == 0? BufferedImage.SCALE_DEFAULT : bi.getType();   
        BufferedImage resizedImage = new BufferedImage(height, width,
                type);
            Graphics2D g = resizedImage.createGraphics();
            g.drawImage(bi, 0, 0, height, width, null);
            g.dispose();
            g.setComposite(AlphaComposite.Src);

            g.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
                RenderingHints.VALUE_INTERPOLATION_BILINEAR);
            g.setRenderingHint(RenderingHints.KEY_RENDERING,
                RenderingHints.VALUE_RENDER_QUALITY);
            g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        ByteArrayOutputStream out50 = new ByteArrayOutputStream();
        ImageIO.write(resizedImage,filetype.equals("image/jpeg")?"jpeg":"PNG",out50);
        byte[] buf50 = out50.toByteArray();
        
       
        // setup stream for blob
        ByteArrayInputStream inStream50 = new ByteArrayInputStream(buf50);
        System.out.println("File size=== "+out50.size()/1024);
        String img_size=out50.size()/1024+" Kb";
  int imgid=0;
    	 Connection con=null;
    	 PreparedStatement ps=null;
    	 ResultSet rs=null;
        try {
			con=DbConnector.createConnection();
			ps=con.prepareStatement("SELECT imgid FROM img ORDER BY imgid DESC LIMIT 1");
			rs=ps.executeQuery();
			if(!rs.next()){
				imgid=100000;
				
			}
			if(rs.absolute(1)) {
				imgid=rs.getInt(1)+1;
			}
			ps.close();
		imageid=imgid;
			System.out.println("Id created "+imgid);
			 ps=con.prepareStatement("insert into img values (?,?,?,?,?,?,?)");
			 ps.setInt(1, imgid);
			 ps.setBlob(2, inStream50);
			 ps.setString(3, img_size);
			 ps.setBlob(4, inStream50);
			 ps.setString(5, null);
			 ps.setBlob(6, inStream50);
			 ps.setString(7, null);
			 
			 int i=ps.executeUpdate();
			 if(i>0){
				 System.out.println("Upload success");
			 }
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        finally {
			rs.close();
			ps.close();
			con.close();
			
		}
        
        
    }
     public static void rescale(BufferedImage bi, String all, int height, int width,String filetype) throws IOException, SQLException{
    	 int type = bi.getType() == 0? BufferedImage.SCALE_DEFAULT : bi.getType();

     System.out.println("TYPE===============>"+bi.getType());
        	 BufferedImage resizedImage = new BufferedImage(height, width, type);
             Graphics2D g = resizedImage.createGraphics();
             g.drawImage(bi, 0, 0, height, width, null);
             g.dispose();
             g.setComposite(AlphaComposite.Src);
             g.setRenderingHint(RenderingHints.KEY_INTERPOLATION,RenderingHints.VALUE_INTERPOLATION_BILINEAR);
             g.setRenderingHint(RenderingHints.KEY_RENDERING,RenderingHints.VALUE_RENDER_QUALITY);
             g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
             ByteArrayOutputStream out = new ByteArrayOutputStream();
             ImageIO.write(resizedImage,filetype.equals("image/jpeg")?"jpeg":"PNG",out);
             byte[] buf = out.toByteArray();
             // setup stream for blob
             ByteArrayInputStream inStream = new ByteArrayInputStream(buf);
             
           

             
             BufferedImage resizedImage50 = new BufferedImage(height/2, width/2, type);
             Graphics2D g50 = resizedImage50.createGraphics();
             g50.drawImage(bi, 0, 0, height/2, width/2, null);
             g50.dispose();
             g50.setComposite(AlphaComposite.Src);
             g50.setRenderingHint(RenderingHints.KEY_INTERPOLATION,RenderingHints.VALUE_INTERPOLATION_BILINEAR);
             g50.setRenderingHint(RenderingHints.KEY_RENDERING,RenderingHints.VALUE_RENDER_QUALITY);
             g50.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
             ByteArrayOutputStream out50 = new ByteArrayOutputStream();
             ImageIO.write(resizedImage50,filetype.equals("image/jpeg")?"jpeg":"PNG",out50);
             byte[] buf50 = out50.toByteArray();
             // setup stream for blob
             ByteArrayInputStream inStream50 = new ByteArrayInputStream(buf50);
             
             

             
             BufferedImage resizedImage25 = new BufferedImage(height/4, width/4, type);
             Graphics2D g25 = resizedImage25.createGraphics();
             g25.drawImage(bi, 0, 0, height/4, width/4, null);
             g25.dispose();
             g25.setComposite(AlphaComposite.Src);
             g25.setRenderingHint(RenderingHints.KEY_INTERPOLATION,RenderingHints.VALUE_INTERPOLATION_BILINEAR);
             g25.setRenderingHint(RenderingHints.KEY_RENDERING,RenderingHints.VALUE_RENDER_QUALITY);
             g25.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
            
             ByteArrayOutputStream out25 = new ByteArrayOutputStream();
             ImageIO.write(resizedImage25,filetype.equals("image/jpeg")?"jpeg":"PNG",out25);
             byte[] buf25 = out25.toByteArray();
             ByteArrayInputStream inStream25= new ByteArrayInputStream(buf25);
		
             String img1_size=out.size()/1024+" Kb";
             String img2_size=out50.size()/1024+" Kb";
             String img3_size=out25.size()/1024+" Kb";
         int imgid=0;
    	 Connection con=null;
    	 PreparedStatement ps=null;
    	 ResultSet rs=null;
      
			try {
				con=DbConnector.createConnection();
				ps=con.prepareStatement("SELECT imgid FROM img ORDER BY imgid DESC LIMIT 1");
				rs=ps.executeQuery();
				if(!rs.next()){
					imgid=100000;
					
				}
				if(rs.absolute(1)) {
					imgid=rs.getInt(1)+1;
				}
				ps.close();
				imageid=imgid;
				System.out.println("Id created "+imgid);
				 ps=con.prepareStatement("insert into img values (?,?,?,?,?,?,?)");
				 ps.setInt(1, imgid);
				 ps.setBlob(2, inStream);
				 ps.setString(3, img1_size);
				 ps.setBlob(4, inStream50);
				 ps.setString(5, img2_size);
				 ps.setBlob(6, inStream25);
				 ps.setString(7, img3_size);
				 int i=ps.executeUpdate();
				 if(i>0){
					 System.out.println("Upload success");
				 }
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally {
				rs.close();
				ps.close();
				con.close();
				
			}
	
         // setup stream for blob
        
     }
/*
     static void compress(int compression, BufferedImage bi)
            throws FileNotFoundException, IOException {
        Iterator<ImageWriter> i = ImageIO.getImageWritersByFormatName("jpeg");
        ImageWriter jpegWriter = i.next();

        // Set the compression quality
        ImageWriteParam param = jpegWriter.getDefaultWriteParam();
        param.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
        param.setCompressionQuality(0.1f * compression);

        // Write the image to a file
        FileImageOutputStream out = new FileImageOutputStream(new File("Lenna"+compression+".jpg"));
        jpegWriter.setOutput(out);
        jpegWriter.write(null, new IIOImage(bi, null, null), param);
        jpegWriter.dispose();
        out.close();
    }*/
     

}