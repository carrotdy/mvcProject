<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="titles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html>
<html>
	<head>
	    <title>코딩 전문가를 만들기 위한 온라인 강의 시스템</title>
	    <meta charset="UTF-8">
	    <title>공지사항목록</title>
	
	    <link href="/css/layout.css" type="text/css" rel="stylesheet" />
	    <link href="/css/index.css" type="text/css" rel="stylesheet" />
	</head>
	
	<body>
	    <!-- header 부분 -->
		<titles:insertAttribute name="header"/>
	
	    <!-- --------------------------- <body> --------------------------------------- -->
		<titles:insertAttribute name="body"/>  
	
	    <!-- ------------------- <footer> --------------------------------------- -->
		<titles:insertAttribute name="footer"/>
	</body>
</html>