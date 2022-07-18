
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <jsp:include page="/WEB-INF/partials/head.jsp">
    <jsp:param name="title" value="Quotes"/>
  </jsp:include>
</head>
<body>
  <jsp:include page="/WEB-INF/partials/navbar.jsp"/>
<c:forEach var="quote" items="${quotes}">
    <duv>
<%--      this is an object within and object--%>
      <p>${quote.author.author_name} said: ${quote.content}</p>
    </duv>
</c:forEach>
</body>
</html>
