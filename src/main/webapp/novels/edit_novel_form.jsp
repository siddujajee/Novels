<%@ page import="com.noveldao.novel.Novel" %>
<head>
  <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
  <div class="pageContent">
    <form action="updateNovel" method="post">
      <input type="hidden" name="novel_id" value="<%= novel.getNovel_id() %>">
      <label for="novel_title">
        Title:
      </label>
      <input type="text" id="novel_title" name="novel_title" value="<%= novel.getNovel_title() %>">
      <br><br>
      <div style="display: flex; gap: 5px">
        <label for="novel_content">
          Content:
        </label>
        <textarea name="novel_content" id="novel_content" cols="30" rows="10"><%= novel.getNovel_content() %></textarea>
      </div>
      <br>
      <input type="submit">
      <button type="button" onclick="cancelEdit(<%= novel.getNovel_id() %>)">Cancel</button>
    </form>
  </div>
</body>
<script>
  function cancelEdit(novelId){
    const formSelector ='#novelEditForm' + novelId;
    const cardSelector = '#novelCard' + novelId;
    document.querySelector(formSelector).style.display = 'none';
    document.querySelector(cardSelector).style.display = 'block';
  }
</script>