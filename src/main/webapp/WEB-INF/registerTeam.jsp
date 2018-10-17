<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<html>

<head>
<title>First Web Application</title>
</head>

<body>
    <font color="red">${errorMessage}</font>
    <h1>Welcome to foosball Doubles Register Team Page</h1>
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
        <table align="center">
                <tr>
                    <td style="font-style: italic; color: red;">${message}</td>
                </tr>
            </table>

    <script>

function ValidationEvent() {
	var player1=document.getElementById("player1").value;
	var player2=document.getElementById("player2").value;
	if(player1===player2)
		{
		alert("Player 1 and Player 2 cannot be same");
		return false;
		}
	else
	return true;
	
	return true;
}

</script>
</body>

</html>