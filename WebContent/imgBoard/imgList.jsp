<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

[
<c:forEach var="i" items="${imgs }" varStatus="status">
	<c:if test="${not status.first }">
		,
	</c:if>
	{ "num":"${i.num }", "writer":"${i.writer }", "pwd":"${i.pwd }", "title":"${i.title }", "path":"${i.path }", "u_date":"${i.u_date }" }
</c:forEach>
]