<<<<<<< HEAD
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>My Tasks</title> 
<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
<form action="task_select_servlet"  method="post">
  <div class="container">
    <h1>My Tasks</h1>
   <table>
	   <tr >
	   	<th>Titre</th>
	    <th>Description</th>	   	
	    <th>Statut</th>
	    <th>Date</th>
	    <th>Caregorie</th>

	  </tr>
	  <c:forEach begin="1" end= "${ no }" step="1" varStatus="loopCounter" items="${listTask}" var="tache">
	  <tr>
	  	<td><c:out value="${tache.titre}" /></td>
	  	<td><c:out value="${tache.description}" /></td>
	  	<td><c:out value="${tache.statut}" /></td>
	  	<td><c:out value="${tache.deadline}" /></td>
	  	<td><c:out value="${tache.nom_category}" /></td>
	
	  </tr>
	  </c:forEach>
   </table>
    <div class="clearfix">
      <button type="button" class="cancelbtn"><a href="signin_view.jsp">Log out</a></button>
      <button type="button" class="insertbtn"><a href="task.jsp">ADD task</a></button>
      <button type="button" class="updatebtn"><a href="update_task.jsp">UPDATE task</a></button>
      <button type="button" class="deletebtn"><a href="delete_task.jsp">DELETE task</a></button>
    </div>
  </div>
</form>
</body>
</html>
=======
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>My Tasks</title> 
<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
<form action="task_select_servlet"  method="post">
  <div class="container">
    <h1>My Tasks</h1>
   <table>
	   <tr >
	   	<th>Titre</th>
	    <th>Description</th>	   	
	    <th>Statut</th>
	    <th>Date</th>
	    <th>Caregorie</th>

	  </tr>
	  <c:forEach begin="1" end= "${ no }" step="1" varStatus="loopCounter" items="${listTask}" var="tache">
	  <tr>
	  	<td><c:out value="${tache.titre}" /></td>
	  	<td><c:out value="${tache.description}" /></td>
	  	<td><c:out value="${tache.statut}" /></td>
	  	<td><c:out value="${tache.deadline}" /></td>
	  	<td><c:out value="${tache.nom_category}" /></td>
	
	  </tr>
	  </c:forEach>
   </table>
    <div class="clearfix">
      <button type="button" class="cancelbtn"><a href="signin_view.jsp">Log out</a></button>
      <button type="button" class="insertbtn"><a href="task.jsp">ADD task</a></button>
      <button type="button" class="updatebtn"><a href="update_task.jsp">UPDATE task</a></button>
      <button type="button" class="deletebtn"><a href="delete_task.jsp">DELETE task</a></button>
    </div>
  </div>
</form>
</body>
</html>
>>>>>>> fbf558e1d5a02f2cb34c27c924b1e54a4f44962a
