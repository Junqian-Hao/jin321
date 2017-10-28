<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<h2>Hello World!</h2>
<%
    String path = request.getContextPath()+"/"+"rollingpick/1.png";
    String repath = request.getServletContext().getRealPath("/");
%>
<img src="<%=path%>">
<%=repath%>
</body>
</html>
