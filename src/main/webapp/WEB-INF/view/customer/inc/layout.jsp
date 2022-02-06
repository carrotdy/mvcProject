<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="titles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title><titles:getAsString name="title" /></title>
    
    <link href="/css/customer/layout.css" type="text/css" rel="stylesheet" />
    <style>
    
        #visual .content-container{	
            height:inherit;
            display:flex; 
            align-items: center;
            
            background: url("../../images/customer/visual.png") no-repeat center;
        }
    </style>
</head>

<body>
    <!-- header 부분 -->
	<titles:insertAttribute name="header"/>

	<!-- --------------------------- <visual> --------------------------------------- -->
	<!-- visual 부분 -->
	<titles:insertAttribute name="visual"/>

	<!-- --------------------------- <body> --------------------------------------- -->
	<div id="body">
		<div class="content-container clearfix">

			<!-- --------------------------- aside --------------------------------------- -->
			<!-- aside 부분 -->
			<titles:insertAttribute name="aside"/>
			
			<!-- --------------------------- main --------------------------------------- -->
			<titles:insertAttribute name="body"/>
		
		</div>
	</div>

    <!-- ------------------- <footer> --------------------------------------- -->
	<titles:insertAttribute name="footer"/>

    </body>
    
    </html>