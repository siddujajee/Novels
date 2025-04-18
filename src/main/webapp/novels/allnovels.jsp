<%@ page import="java.util.List" %>
<%@ page import="com.noveldao.novel.Novel" %>
<%@ include file="/header.jsp" %>
<body>
<div class="pageContent">
  <% List<Novel> novels = (List<Novel>) request.getAttribute("novels");
    if (novels != null && !novels.isEmpty()) { %>
    <div class="novel-container">
      <% for (Novel novel : novels) { %>
        <%@ include file="novel.jsp" %>
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
