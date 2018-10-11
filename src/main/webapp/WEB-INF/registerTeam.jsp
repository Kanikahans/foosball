<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<html>

<head>
<title>First Web Application</title>
</head>

<body>
    <font color="red">${errorMessage}</font>
    <h1>Welcome to foosball Doubles Register User Page</h1>
    <!--  <form onsubmit="alert('submit!');return false"> -->
    
    <form:form method="post" action="/registerTeam" modelAttribute="Team" onsubmit="return ValidationEvent()">
        TeamName : <input type="text" name="teamName"/>
        PlayerOne : <form:select path = "player1" id="player1">
                     <form:option value = "NONE" label = "Select"/>
                     <form:options items = "${player1}" />
                  </form:select>    
        PlayerTwo : <form:select path = "player2" id="player2">
                     <form:option value = "NONE" label = "Select"/>
                     <form:options items = "${player2}" />
                  </form:select>    
        <input type="submit" />
        </form:form>

    <script>
function ValidationEvent() {
	String player1=document.getElementById("player1").value;
	String player2=document.getElementById("player2").value;
	alert(player1.localeCompare(player2));
	
	if(player1.localeCompare(player2)==0)
		{
		alert(Player One and Player Two cannot be same);
		return false;
		}
	else
	return true;
}
</script>
</body>

</html>