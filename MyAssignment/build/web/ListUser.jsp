<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "model.*" %>
<%@page import = "java.util.*" %>
<!DOCTYPE html>
<%
  List<User> lst = (List<User>) request.getAttribute("lst");
%>    
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>List of User</title>
    </head>
    <body>

        <style>
            .noneSize{
                height: 0;
                width: 0;
                size: 0;
                border: none;
                margin: 0;
                padding: 0;
            }
        </style>

        <h2> List of User </h2>
        <table border="1"><!-- table of list -->
            <tr>
                <td> Account </td>
                <td> Name Of user </td>
                <td> Phone number </td>
                <td> Role </td>
                <td colspan="3" align="center"> Delete </td>
            </tr>
            <%
              for(User x: lst) {
            %>
            <tr>
                <td><%= x.getLogginName() %> </td>
                <td><%= x.getNameUser() %> </td>
                <td><%= x.getPhoneNumberUser() %> </td>
                <td><%= x.getRole() %> </td>
                <td><a href="admin?idLogin=<%=x.getIdLogin() %>">  Become admin </a> </td>
                <td><a href="deleAdmin?idLogin=<%=x.getIdLogin() %>">  Delete admin  </a> </td>
                <td><a href="delete2?idLogin=<%=x.getIdLogin() %>">  Delete </a> </td>

            </tr>  
            <% } %>  
        </table>     
        <p><button onclick='window.history.go(-1);'>Back </button>
    </body>
</html>
