<%@ page import="java.util.List" %>
<%@ page import="com.noveldao.novel.Novel" %>
<head>
<div style="display: flex; gap: 5px; justify-content: end; align-items: center; background: skyblue; height: 50px; padding: 0px 40px">
  <% if(session.getAttribute("session_user") == null){ %>
    <a href="login.jsp" class="actionButtons"><i class="fa fa-plus"></i>Login</a>
  <% }else { %>
    <a href="logout" class="actionButtons">Logout</a>
    <a href="addnovel" class="actionButtons">Add Novel</a>
  <% } %>
</div>
<style>
   .actionButtons{
      text-decoration: none;
      padding: 5px 10px;
      background: #f5f5f5eb;
   }
   .actionButtons:active{
      text-decoration: none;
      color: black;
      border: solid 1px black;
   }
</style>
<script></script>