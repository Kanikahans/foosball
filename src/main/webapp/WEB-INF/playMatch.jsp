<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<html>

<head>
<title>First Web Application</title>
</head>

<body>
    <font color="red">${errorMessage}</font>
    <h1>Welcome to foosball Doubles Play Match </h1>
    <!--  <form onsubmit="alert('submit!');return false"> -->
    
    <form:form method="post" action="/playMatch" modelAttribute="Match">
        TeamOne : <form:select path = "teamA">
                     <form:option value = "NONE" label = "Select"/>
                     <form:options items = "${teamA}" />
                  </form:select>    
        TeamTwo : <form:select path = "teamB">
                     <form:option value = "NONE" label = "Select"/>
                     <form:options items = "${teamB}" />
                  </form:select>    
        <input type="submit" value="Play"/>
        </form:form>
         <table align="center">
                <tr>
                    <td style="font-style: italic; color: red;">${message}</td>
                </tr>
            </table>
</body>

</html>