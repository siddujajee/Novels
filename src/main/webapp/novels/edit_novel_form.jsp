<%@ page import="com.noveldao.novel.Novel" %>
<body>
  <div class="pageContent formContainer">
    <form action="updateNovel" method="post">
      <input type="hidden" name="novel_id" value="<%= novel.getNovel_id() %>">
      <label for="novel_title" class="novelLabel">
        Title:
      </label>
      <input
        type="text"
        id="novelTitle"
        name="novel_title"
        value="<%= novel.getNovel_title() %>">

      <div style="display: flex; flex-direction: column; gap: 5px; margin-bottom: 20px;">
        <label for="novel_content" class="novelLabel">
          Content:
        </label>
        <textarea
          name="novel_content"
          id="novelContent"
          cols="30"
          rows="5"><%= novel.getNovel_content() %></textarea>
      </div>

      <div style="display: flex; justify-content: flex-end; gap: 5px;">
        <input
          type="submit"
          class="editFormActionBtn"
          value="Save"
          style="background: #6af56a;">

        <button
          type="button"
          class="editFormActionBtn"
          style="background: #fd0519;"
          onclick="cancelEdit(<%= novel.getNovel_id() %>)">
          Cancel
        </button>
      </div>
    </form>
  </div>
</body>

<script>
  function cancelEdit(novelId){
    const formSelector = '#novelEditForm' + novelId;
    const cardSelector = '#novelCard' + novelId;
    document.querySelector(formSelector).style.display = 'none';
    document.querySelector(cardSelector).style.display = 'block';
  }
</script>
<style>
  .formContainer{
    background-color: #fff;
    border: 1px solid #ddd;
    border-radius: 10px;
    padding: 20px;
    max-width: 600px;
    box-shadow: 0 4px 10px rgba(0,0,0,0.1);
    font-family: Arial, sans-serif;
  }
  .formContainer .novelLabel {
    font-weight: bold;
    display: block;
    margin-bottom: 5px;
  }
  .formContainer #novelTitle {
    width: 100%;
    padding: 10px;
    border: 1px solid #ccc;
    border-radius: 5px;
    margin-bottom: 20px;
    font-size: 14px;
  }
  .formContainer #novelContent {
    width: 100%; padding: 10px; border: 1px solid #ccc; border-radius: 5px; font-size: 14px;
  }
  .editFormActionBtn {
    cursor: pointer;
    background: #6af56a;
    border: none;
    padding: 5px 8px;
    color: white;
    border-radius: 5px;
    font-weight: bold;
  }
</style>
