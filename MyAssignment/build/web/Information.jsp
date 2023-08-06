
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
                width: 46%;
                height: 84%;
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
                width: 55%;
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
                    <h2>Change Your Information</h2>
                    <p>
                    <form action="changeName">
                        <input class="noneSize" type="text" name="idLogin" value="<%= idLogin %>">
                        Name        :<input class="text" type="text" name="name" value=""> <p>
                            <input type="Submit" value="Change">
                    </form>
                    <p>
                    <form action="changePhoneNumber">
                        <input class="noneSize" type="text" name="idLogin" value="<%= idLogin %>">
                        Phone Number:<input class="text" type="text" name="PhoneNumber" value=""> <p>
                            <input type="Submit" value="Change">
                    </form>
                    <p>
                    <form action="changeImg">
                        <input class="noneSize" type="text" name="idLogin" value="<%= idLogin %>">
                        URL Img     :<input class="text" type="text" name="changeImg" value=""> <p>
                            <input type="Submit" value="Change">
                    </form>
                    <p>
                    <form action="changePassword">
                        <input class="noneSize" type="text" name="idLogin" value="<%= idLogin %>">
                        Password    :<input class="text" type="password" name="password" value=""> <p>
                            Re-Password :<input class="text" type="password" name="repassword" value=""> <p>
                            <input type="Submit" value="Change">
                    </form>
                    <p class="backtext"><button onclick='window.history.go(-1);'>Back</button>

                </div>
            </div>
        </div>

    </body>
</html>
