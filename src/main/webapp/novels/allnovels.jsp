<%@ page import="java.util.List" %>
<%@ page import="com.noveldao.novel.Novel" %>
<% if(request.getAttribute("session_user") == null){ %>
<a href="login.html">Login</a>
<% }else { %>
<a href="logout">Logout</a>
<a href="addnovel">Add Novel</a>
<% } %>
<% List<Novel> novels = (List<Novel>) request.getAttribute("novels");
  if (novels != null) { %>
  <div style="display: flex; flex-wrap: wrap;">
    <% for (Novel n : novels) { %>
      <div style="width: 25%">
        <h2><%= n.getNovel_title() %></h2>
        <p><%= n.getNovel_content() %></p>
      </div>
  <%} %>
  </div>
  <% } else {
%>
  <p>No novels available.</p>
<%
  }
%>
