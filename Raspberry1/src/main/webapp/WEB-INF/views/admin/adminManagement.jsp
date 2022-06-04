<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>
<html>
<head>
<link href="${pageContext.request.contextPath}/css/bootstrap.min.css"
	rel="stylesheet">
<meta charset="UTF-8">
<title>관리자 페이지</title>
<style>
	h3{
		text-align : center;
	}
	tr{
		text-align : center;
	}
</style>
</head>
<body>
<h3></h3>
<h3>택배보관함 사용 목록</h3>
<br>
<table class="table table-hover">
        <thead>
            <tr class = "info">
                <th>이름</th>
                <th>전화번호</th>
                <th>송장번호</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${keepList}" var="keepList">
                <tr>
                    <td>${keepList.name}</td>
                    <td>${keepList.phone}</td>
                    <td>${keepList.code}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

</body>
</html>