<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<html>

<head>
<title>First Web Application</title>
</head>

<body>
    <font color="red">${errorMessage}</font>
    <h1>Team's LeaderBoard</h1>
    <!--  <form onsubmit="alert('submit!');return false"> -->
    
   <table border="2" width="70%" cellpadding="2">  
<tr><th>TeamName</th><th>Player1</th><th>Player2</th><th>Team Score</th></tr>  
   <c:forEach var="team" items="${Team}">   
   <tr>  
   <td>${team.teamName}</td>  
   <td>${team.player1}</td>  
   <td>${team.player2}</td>  
   <td>${team.team_score}</td>   
   </tr>  
   </c:forEach>  
   </table>  
</body>

</html>