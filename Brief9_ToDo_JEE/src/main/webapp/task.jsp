<<<<<<< HEAD
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Task</title> 
<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
<form action="task_insert_servlet"  method="post">
  <div class="container">
    <h1>Task</h1>
    
	<hr>
    <label for="titre"><b>Title</b></label>
    <input type="text" placeholder="Enter title" name="titre" required minlength="3">
	<hr>
	<label for="description"><b>Description</b></label>
    <input type="text" placeholder="Enter description" name="description" required minlength="3">
    <hr>
	<select name="statut" id=""><br/>
	    <option value="" disabled selected>status</option>
	    <option value="pas encore">pas encore</option>
	    <option value="en cours">en cours</option>
	    <option value="terminée">terminée</option>
  	</select>
	<hr>
    <label for="deadline"><b>Date</b></label>
    <input type="date" placeholder="Enter Date" name="deadline" required>
	<hr>
  	<select name="nom_category" id="">
	  	<option value="" disabled selected>nom_categorie</option>
	    <option value="pésentation">pésentation</option>
	    <option value="veille">veille</option>
	    <option value="recherche">recherche</option>
	</select><br />

    <div class="clearfix">
      <button type="button" class="cancelbtn"><a href = "signin_view.jsp">Log out</a></button>
      <button type="submit" class="signupbtn">Submit</button>
      <button type="button" class="taskbtn"><a href = "task_List.jsp">My task</a></button>
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
<title>Task</title> 
<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
<form action="task_insert_servlet"  method="post">
  <div class="container">
    <h1>Task</h1>
    
	<hr>
    <label for="titre"><b>Title</b></label>
    <input type="text" placeholder="Enter title" name="titre" required minlength="3">
	<hr>
	<label for="description"><b>Description</b></label>
    <input type="text" placeholder="Enter description" name="description" required minlength="3">
    <hr>
	<select name="statut" id=""><br/>
	    <option value="" disabled selected>status</option>
	    <option value="pas encore">pas encore</option>
	    <option value="en cours">en cours</option>
	    <option value="terminée">terminée</option>
  	</select>
	<hr>
    <label for="deadline"><b>Date</b></label>
    <input type="date" placeholder="Enter Date" name="deadline" required>
	<hr>
  	<select name="nom_category" id="">
	  	<option value="" disabled selected>nom_categorie</option>
	    <option value="pésentation">pésentation</option>
	    <option value="veille">veille</option>
	    <option value="recherche">recherche</option>
	</select><br />

    <div class="clearfix">
      <button type="button" class="cancelbtn"><a href = "signin_view.jsp">Log out</a></button>
      <button type="submit" class="signupbtn">Submit</button>
      <button type="button" class="taskbtn"><a href = "task_List.jsp">My task</a></button>
    </div>
  </div>
</form>
</body>
</html>
>>>>>>> fbf558e1d5a02f2cb34c27c924b1e54a4f44962a
