<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>

<head>
<title>First Web Application</title>
</head>

<body>
    <font color="red">${errorMessage}</font>
    <h1>Welcome to foosball Doubles Register User Page</h1>
    <!--  <form onsubmit="alert('submit!');return false"> -->
    
    <form method="post" action="/registerUser">
        FirstName : <input type="text" name="firstName"/>
        LastName : <input type="text" name="lastName" /> 
        UserName : <input type="text" name="userName" /> 
        <input type="submit" />
<!--      <from name="UserForm" action="/registerUser" method="post" id="UserForm"> -->
<!--     	<div> -->
<!--     		FirstName : -->
<!--     		<input type='text' name='firstName' value=''>  -->
<!--     	</div> -->
<!--     	<div> -->
<!--     		LastName : -->
<!--     		<input type='text' name='lastName' value=''>  -->
<!--     	</div> -->
<!--     	<div> -->
<!--     		UserName : -->
<!--     		<input type='text' name='userName' value=''>  -->
<!--     	</div> -->
<!--     	<div> -->
<!--     		<input type="button" onclick="myFunction()" value="Register User"> -->
<!--     	</div> -->
    	
<!--     </from> -->
    <script>
function myFunction() {
	console.log("HELLLLLLLLLLLLLLLOOOOOOOOOOOOOOO");
	console.log(document.getElementById("UserForm"));
	
    document.getElementById("UserForm").submit();
}
</script>
</body>

</html>