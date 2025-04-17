<head>
  <link rel="stylesheet" type="text/css" href="css/novelForm.css">
</head>
<%@ include file="/header.jsp" %>
<body style="margin: 0">
  <div class="pageContent">
    <form action="addnovel" method="post">
      <label for="novel_title">Title:</label>
      <input type="text" id="novel_title" name="novel_title">
      <div class="textarea-wrapper">
        <label for="novel_content">Content:</label>
        <textarea name="novel_content" id="novel_content" cols="30" rows="10"></textarea>
      </div>
      <input type="submit" value="Add Novel">
    </form>
  </div>
</body>