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
      <% for (Novel novel : novels) { %>
        <div style="width: 25%; display: block" id="novelCard<%= novel.getNovel_id() %>">
          <h2><%= novel.getNovel_title() %></h2>
          <p><%= novel.getNovel_content() %></p>
          <a href="#" onclick="renderForm(<%= novel.getNovel_id() %>)">Edit</a>
        </div>
        <div id="novelEditForm<%= novel.getNovel_id() %>" style="display: none"><%@ include file="edit_novel_form.jsp" %></div>
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
<script>
  function renderForm(novelId) {
    const formSelector = '#novelEditForm' + novelId;
    const cardSelector = '#novelCard' + novelId;
    document.querySelector(formSelector).style.display = 'block';
    document.querySelector(cardSelector).style.display = 'none';
  }
</script>
