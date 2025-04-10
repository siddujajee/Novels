<%@ page import="java.util.List" %>
<%@ page import="com.noveldao.novel.Novel" %>
<head>
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<%@ include file="/header.jsp" %>
<body>
<div class="pageContent">
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
</div>
</body>
