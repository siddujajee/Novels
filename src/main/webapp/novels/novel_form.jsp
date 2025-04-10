<head>
  <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<%@ include file="/header.jsp" %>
<body>
  <div class="pageContent">
    <form action="addnovel" method="post">
      <label for="novel_title">
        Title:
      </label>
      <input type="text" id="novel_title" name="novel_title">
      <br><br>
      <div style="display: flex; gap: 5px">
        <label for="novel_content">
          Content:
        </label>
        <textarea name="novel_content" id="novel_content" cols="30" rows="10"></textarea>
      </div>
      <br>
      <input type="submit">
    </form>
  </div>
</body>