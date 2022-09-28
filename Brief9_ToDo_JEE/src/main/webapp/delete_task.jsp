<<<<<<< HEAD
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Delete Task</title> 
<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
<form action="task_delete_servlet"  method="post">
  <div class="container">
    <h1>Delete Task</h1>
    
    <label for="name"><b>Title</b></label>
    <input type="text" placeholder="Enter title" name="title" required minlength="3">

    <div class="clearfix">
      <button type="button" class="cancelbtn"><a href="signin_view.jsp">Log out</button>
      <button type="submit" class="signupbtn">Delete</button>
      <button type="button" class="taskbtn"><a href="task_List.jsp">My task</button>
    </div>
  </div>
</form>
</body>
</html>
=======
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Delete Task</title> 
<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
<form action="task_delete_servlet"  method="post">
  <div class="container">
    <h1>Delete Task</h1>
    
    <label for="name"><b>Title</b></label>
    <input type="text" placeholder="Enter title" name="title" required minlength="3">

    <div class="clearfix">
      <button type="button" class="cancelbtn"><a href="signin_view.jsp">Log out</button>
      <button type="submit" class="signupbtn">Delete</button>
      <button type="button" class="taskbtn"><a href="task_List.jsp">My task</button>
    </div>
  </div>
</form>
</body>
</html>
>>>>>>> fbf558e1d5a02f2cb34c27c924b1e54a4f44962a
