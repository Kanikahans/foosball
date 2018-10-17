<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>

<head>
<title>First Web Application</title>
</head>

<body>
    <font color="red">${errorMessage}</font>
    <h1>Welcome to foosball Doubles </h1>
    <div>
    	<a href="registerUser">Register User</a><br/>
    	<a href="registerTeam">Register Team</a><br/>
    	<a href="playMatch">Play Match</a><br/>
    	<a href="leaderBoard">LeaderBoard</a><br/>
    </div>
    
    <%-- <form method="post">
        Name : <input type="text" name="name" />
        Password : <input type="password" name="password" /> 
        <input type="submit" />
    </form> --%>
</body>

</html>