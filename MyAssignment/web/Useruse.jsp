<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "model.*" %>
<%@page import = "java.util.*" %>
<!DOCTYPE html>
<%
  User u = (User) request.getAttribute("u");
%>    
<html>
<head>
  <link rel="stylesheet" type="text/css" href="mystyle.css">
</head> 
<body>
 <!-- This is html comment block -->
  <style>
    .divMain {
      text-align: center;

    }
    .container_swap{
        width: 100%;
        text-align: center;
        float: right;
        margin-bottom: 40px;
                    }

        .div_child{
        float: right;
        text-align: center;
        margin-left: 10px
                  }

            img {
          display: block;
          margin-left: auto;
          margin-right: auto;
          margin-top: 45px;
          width: 15%;
          border-radius: 50%;
          border: 2px solid #017a4e;
        }
        .inputText1 {
          border: none;
          margin: 5px;
          font-size: 39px;
          text-align: center;
          margin-top: 20px;
        }
        .inputText2 {
          border: none;
          margin: 5px;
          font-size: 40px;
          text-align: center;
        }
        .inputSubmit{
          height: 45px;
          font-size: 20px;
          width: 120px;
          margin-top: 15px;
          border-radius: 20px;
          color: #ffffff; 
          border: none;
          background-color: #04aa6d;
        }
        .noneSize{
            height: 0;
            width: 0;
            size: 0;
            border: none;
            margin: 0;
            padding: 0;
        }

  </style> 
  
      <div class="container_swap">

        <div class="div_child">
            <form action="index.html">
                <input class="inputSubmit" type="submit" value="Log out">
            </form>
        </div>
        <div class="div_child">
            <form action="listUser">
                <input class="inputSubmit" type="submit" value="List User">
            </form>
        </div>
        <div class="div_child">
            <form action="list">
                <input class="noneSize" type="text" name="idLogin" value="<%= u.getIdLogin() %>">
                <input class="inputSubmit" type="submit" value="List Contact">
            </form>
        </div>
        <div class="div_child">
            <form action="Search.jsp">
                <input class="noneSize" type="text" name="idLogin" value="<%= u.getIdLogin() %>">
                <input class="inputSubmit" type="submit" value="Seach">
            </form>
        </div>
        <div class="div_child">
            <form action="Sort.jsp">
                <input class="noneSize" type="text" name="idLogin" value="<%= u.getIdLogin() %>">
                <input class="inputSubmit" type="submit" value="Sort">
            </form>
        </div>  
        <div class="div_child">
            <form action="Insert.jsp">
                <input class="noneSize" type="text" name="idLogin" value="<%= u.getIdLogin() %>">
                <input class="inputSubmit" type="submit" value="Insert">
            </form>
        </div>  
        <div class="div_child">
            <form action="Information.jsp">
                <input class="noneSize" type="text" name="idLogin" value="<%= u.getIdLogin() %>">
                <input class="inputSubmit" type="submit" value="changeInfo">
            </form>
        </div>  
        <div class="div_child">
            <form action="list">
                <input class="noneSize" type="text" name="idLogin" value="<%= u.getIdLogin() %>">
                <input class="inputSubmit" type="submit" value="HOA">
            </form>
        </div>
   </div>
  
<!-- div information -->
  <div class="divMain">
      <img src="<%= u.getImgUser()%>" alt="imgUser">
    
    
      <p class="inputText1"> <%= u.getPhoneNumberUser() %> </p>
    <p>
    <p class="inputText2" ><%= u.getNameUser() %></p>
    
</div> 
</body>
</html>

