<head>
  <link rel="stylesheet" type="text/css" href="css/application.css">
  <title>Login</title>
</head>
<body>
  <div class="pageContent">
    <% if (request.getAttribute("errorMessage") != null) { %>
      <span style="color:red"><%= request.getAttribute("errorMessage") %></span>
    <% } %>
    <form action="login" method="post" class="login-form">
        <h2>Login</h2>
        <span class="invalidLoginError" style="color:red; display: none">Invalid User Name/Password</span>
        <label for="user_name">User Name</label>
        <input type="text" id="user_name" name="user_name">
        <span id="usernameError" style="display: none; color: red">username can't be empty</span>

        <label for="password">Password</label>
        <input type="password" id="password" name="password">
        <span id="passwordError" style="display: none; color: red">password can't be empty</span>

        <input type="submit" value="Log In">
    </form>
  </div>
</body>
<script>
  function validateForm(event) {
      var userName = document.getElementById("user_name");
      var password = document.getElementById("password");
      var userNameError = document.getElementById("usernameError");
      var passwordError = document.getElementById("passwordError");

      var userNameValue = userName.value.trim();
      var passwordValue = password.value.trim();
      if (userNameValue === "" && passwordValue === "") {
        userNameError.style.display = "block"
        passwordError.style.display = "block"
        event.preventDefault(); // Prevent form submission
        return false; // Stop form submission
      } else {
        userNameError.style.display = "none"
        passwordError.style.display = "none"
      }

      if (userNameValue === "") {
        userName.focus();
        userNameError.style.display = "block"
        event.preventDefault(); // Prevent form submission
        return false; // Stop form submission
      } else {
         userNameError.style.display = "none"
      }

      if (passwordValue === "") {
        userName.focus();
        passwordError.style.display = "block"
        event.preventDefault(); // Prevent form submission
        return false; // Stop form submission
      } else {
        passwordError.style.display = "none"
      }

      // If all checks pass, allow form submission
      return true;
    }

    document.addEventListener("DOMContentLoaded", function() {
      var form = document.querySelector(".login-form");
      form.addEventListener("submit", function(event) {
        if (!validateForm(event)) {
          event.preventDefault();
        }
      });
    });
</script>