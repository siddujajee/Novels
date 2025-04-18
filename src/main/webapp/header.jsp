<%@ page import="java.util.List" %>
<%@ page import="com.noveldao.novel.Novel" %>
<head>
  <link rel="stylesheet" type="text/css" href="css/header.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/webjars/font-awesome/6.5.1/css/all.min.css">
</head>
<div style="display: flex; gap: 5px; justify-content: end; align-items: center; background: skyblue; height: 50px; padding: 0px 40px">
  <% if(session.getAttribute("session_user") == null){ %>
    <a href="login.jsp" class="actionButtons"><i class="fa fa-user"></i>Login</a>
  <% }else { %>
    <a href="logout" class="actionButtons"><i class="fa fa-sign-out-alt"></i>Logout</a>
    <a href="addnovel" class="actionButtons"><i class="fa fa-file-circle-plus"></i>
Add Novel</a>
  <% } %>
</div>
<style>
  body{
    margin: 0;
  }
</style>