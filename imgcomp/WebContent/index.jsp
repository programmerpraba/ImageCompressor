<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Image Compressor</title>
</head>
<body>
<form action="Compress" method="post" enctype="multipart/form-data">
<input type="file" name="fileFldImage" id="fileFldImage"><br>
<input type="radio" name="quality" value="originalSize" ><label>Original Pixel(Only Compress)</label><br>
<input type="radio" name="quality" value="halfSize" ><label>50% Pixel</label><br>
<input type="radio" name="quality" value="quarterSize" ><label>25% Pixel</label><br>
<input type="radio" name="quality" value="all" ><label>All quality</label><br>
<input type="radio" name="quality" value="customSize" ><label>Custom</label><br>
<input type="number" name="customHeight" value="" id="customHeight" placeholder="Height"><br>
<input type="number" name="customWidth" value="" id="customWidth" placeholder="Width"><br>
<br>

<input type="submit" value="Compress">
</form>
</body>
</html>