<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.*" %>
<!DOCTYPE html>
<html>
  <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search result</title>
  </head>
  <body>
     <%
      Contact x = (Contact) request.getAttribute("x");
      if(x==null) return;
     %>    
     <h2> Update a Contact </h2>
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
     <form action="update" method="POST">
         <p><input class="noneSize" type="text" name="idContact" value="<%= x.getIdContacts()%>" readonly /> 
        <p><input type="text" name="nameContact" value="<%= x.getNameContact() %>"/> 
        <p><input type="text" name="phoneNumber" value="<%= x.getPhoneNumberContact() %>"/> 
        <p><input type="submit" value="Update"> 
     </form>  
     <p><button onclick='window.history.go(-1);'>Back to previous page</button>
     <p><a href="index.html">Back to homepage</a>
  </body>
</html>
