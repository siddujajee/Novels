<%@ page import="java.util.List" %>
<%@ page import="com.noveldao.novel.Novel" %>
<head>
  <link rel="stylesheet" type="text/css" href="css/novelCard.css">
</head>
<%@ include file="/header.jsp" %>
<body>
<div class="pageContent">
  <% List<Novel> novels = (List<Novel>) request.getAttribute("novels");
    if (novels != null && !novels.isEmpty()) { %>
    <div class="novel-container">
      <% for (Novel novel : novels) { %>
        <div class="novel-card" id="novelCard<%= novel.getNovel_id() %>">
          <h2><%= novel.getNovel_title() %></h2>
          <p><%= novel.getNovel_content() %></p>
          <% if(session.getAttribute("session_user") != null){ %>
            <a href="#" id="editNovel" onclick="renderForm(<%= novel.getNovel_id() %>)">Edit</a>
            <a href="#" id="deleteNovel" onclick="deleteConfirmation(<%= novel.getNovel_id() %>)">Delete</a>
          <% } %>
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

  function deleteConfirmation(novelId){
    if(confirm("Are you sure you want to delete this Novel?")){
      fetch("/employeemanagementsoftware/delete_novel?id=" + novelId, {
        method: 'POST'
      }).then(response =>
        response.text()
      ).then(result => {
        if(result != null){
          location.reload();
        }
      }).catch(error => {
        console.log(error);
      })
    } else {
      console.log("deletion cancelled")
    }
  }
</script>
