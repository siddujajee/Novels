<%@ page import="java.util.List" %>
<%@ page import="com.noveldao.novel.Novel" %>
<% if(request.getAttribute("session_user") == null){ %>
not logged in
<a href="login.html">Login</a>
<% }else { %>
logged in
<a href="addnovel">Add Novel</a>
<% } %>
<% List<Novel> novels = (List<Novel>) request.getAttribute("novels");
  if (novels != null) {
    for (Novel n : novels) {
%>
  <h2><%= n.getNovel_title() %></h2>
  <p><%= n.getNovel_content() %></p>
<%
  }
  } else {
%>
  <p>No novels available.</p>
<%
  }
%>
<a href='addemp'>Add employee</a>
