<!DOCTYPE html>
<html>
<head>
  <link rel="stylesheet" type="text/css" href="mystyle.css">
</head> 
<body>
 <!-- This is html comment block -->
         <%
            int idLogin =Integer.parseInt(request.getParameter("idLogin"));
        %>
  <style>
    .divout{
      background-color: white;
      height: 700px;
      display: flex;
      justify-content: center;
      align-items: center;    
  }
    .LoginTable{
      background-color: rgb(255, 255, 255) ;
      width: 40%;
      height: 47%;
      border-radius: 15px;
      border:2px solid #017a4e ;
      padding-bottom: 20px;
    }
    .divMain{
      background-color: rgb(255, 255, 255)  ;
      margin-top: 12%;
      margin-left: 12%;
      margin-right: 12%;
      height: 80%;
    }
    .button 
    {
      border: none;
      border-radius: 20px;
      color: #ffffff;  
      padding: 15px 32px;
      text-align: center;  
      text-decoration: none;  
      display: inline-block;  
      font-size: 16px;
      width: 100%;
      margin-top: 31px;
    }
    .button:hover {  
      background-color: #04aa6d;  
      color: #017a4e;
    }
    .text{
      width: 98%;
      height: 29px;
      border: none;  
      border-bottom: 2px solid #017a4e;
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
  <div class="divout">
      <div class="LoginTable">
        <div class="divMain">
          <h2>Search By Name </h2>
          <form action="search1" method="POST">
              <p>Name: <input class="text" type="text" name="searchName" value="">
            <input class="noneSize" type="text" name="idLogin" value="<%= idLogin%>">
            <p>
            <input class="button" type="submit" value="SEARCH">
        </form>
          <p class="backtext"><button onclick='window.history.go(-1);'>Back</button>

        </div>
      </div>
  </div>

</body>
</html>
