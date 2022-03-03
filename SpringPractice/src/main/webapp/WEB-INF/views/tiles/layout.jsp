<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>CSS Template</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>
  <tiles:insertAttribute name="header" />
    <!--  컨텐츠 (내용) -->
    
    <tiles:insertAttribute name="content" />

<footer>
   <tiles:insertAttribute name="footer" />
</footer>

</body>
</html>
