<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "model.Contact" %>
<%@page import = "java.util.*" %>
<!DOCTYPE html>
<%
  List<Contact> lst = (List<Contact>) request.getAttribute("lst");
%>    
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>List of Contact</title>
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

        <h2> List of Contact </h2>
        <table border="1"><!-- table of list -->
            <tr>
                <td> NameContact </td>
                <td> PhoneNumber </td>
                <td colspan="2" align="center"> Fix </td>
            </tr>
            <%
              for(Contact x: lst) {
            %>
            <tr>
                <td><%= x.getNameContact() %> </td>
                <td><%= x.getPhoneNumberContact() %> </td>
                <td><a href="update?idContacts=<%=x.getIdContacts()%>">  Edit </a> </td>
                <td><a href="delete1?idContacts=<%=x.getIdContacts() %>">  Delete </a> </td>
            </tr>  
            <% } %>  
        </table>     
        <p><button onclick='window.history.go(-1);'>Back</button>
    </body>
</html>
