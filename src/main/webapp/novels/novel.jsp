
<head>
  <link rel="stylesheet" type="text/css" href="css/novelcard.css">
</head>
<div class="novel-card" id="novelCard<%= novel.getNovel_id() %>">
  <% if(session.getAttribute("session_user") != null){ %>
    <div class="novel-actions" style="float: right">
      <a href="#" class="fas fa-pen" id="editNovel" onclick="renderForm(<%= novel.getNovel_id() %>)" title="Edit"></a>
      <a href="#" class="fas fa-trash" id="deleteNovel" onclick="deleteConfirmation(<%= novel.getNovel_id() %>)" title="Delete"></a>
    </div>
  <% } %>
  <h2><%= novel.getNovel_title() %></h2>
  <p><%= novel.getNovel_content() %></p>
</div>
<div id="novelEditForm<%= novel.getNovel_id() %>" style="display: none"><%@ include file="edit_novel_form.jsp" %></div>