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
     </form>
<table align="center">
                <tr>
                    <td style="font-style: italic; color: red;">${message}</td>
                </tr>
            </table>
</body>

</html>