<%-- 
    Document   : register
    Created on : May 27, 2024, 11:50:23 PM
    Author     : lienm
--%>

<%@page import="User.UserError"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>REGISTER PAGE</title>
        <style>
            @import url('https://fonts.googleapis.com/css2?family=Poppins:wght@500&display=swap');
            *{
                margin: 0;
                padding: 0;
                font-family: 'poppins',sans-serif;
            }
            section{
                display: flex;
                justify-content: center;
                align-items: center;
                min-height: 100vh;
                width: 100%;

                background: url('img/login.jpg')no-repeat;
                background-position: center;
                background-size: cover;
            }
            .form-box{
                position: relative;
                width: 500px;
                height: 800px;
                background: transparent;
                border: 2px solid rgba(255,255,255,0.5);
                border-radius: 20px;
                backdrop-filter: blur(15px);
                display: flex;
                justify-content: center;
                align-items: center;

            }
            h2{
                font-size: 2em;
                color: #fff;
                text-align: center;
            }
            .inputbox{
                position: relative;
                margin: 30px 0;
                width: 410px;
                border-bottom: 2px solid #fff;
            }
            .inputbox label{
                position: absolute;
                top: 50%;
                left: 5px;
                transform: translateY(-50%);
                color: #fff;
                font-size: 1em;
                pointer-events: none;
                transition: .5s;
            }
            input:focus ~ label,
            input:valid ~ label{
                top: -5px;
            }
            .inputbox input {
                width: 100%;
                height: 50px;
                background: transparent;
                border: none;
                outline: none;
                font-size: 1em;
                padding:0 35px 0 5px;
                color: #fff;
            }
            .inputbox ion-icon{
                position: absolute;
                right: 8px;
                color: #fff;
                font-size: 1.2em;
                top: 20px;
            }
            .forget{
                margin: -15px 0 15px ;
                font-size: .9em;
                color: #fff;
                display: flex;
                justify-content: space-between;  
            }

            .forget label input{
                margin-right: 3px;

            }
            .forget label a{
                color: #fff;
                text-decoration: none;
            }
            .forget label a:hover{
                text-decoration: underline;
            }
            .button{
                width: 100%;
                height: 40px;
                border-radius: 40px;
                background: #fff;
                border: none;
                outline: none;
                cursor: pointer;
                font-size: 1em;
                font-weight: 600;
            }
            .register{
                display: flex;
                font-size: .9em;
                color: #fff;
                text-align: center;
                margin: 25px 0 10px;
            }
            .register input:hover{
                background: linear-gradient(to right,#30cfd0 ,#330867);
            }
            .red{
                color: red;
            }
            .noti{
                background-color: transparent;
                color: white;
                margin-top: 100px;
                font-size: large;
                font-weight: bold;
                text-transform: uppercase;
                opacity: 0.7;
                transition: 0.5s;
                text-align: center;
            }
            .noti:hover{
                opacity: 1;
                color: blue;
            }
        </style>
    </head>
    <body>
        <%
            UserError userError = (UserError) session.getAttribute("USER_ERROR");
            if (userError == null) {
                userError = new UserError();
            }
        %>
        <form action="mainController" method="post">
            <section>
                <div class="form-box">
                    <div class="form-value">
                        <form action="">
                            <h2>REGISTER</h2>
                            <div class="inputbox">
                                <ion-icon name="person-circle-outline"></ion-icon>
                                <input type="text" name="userID" id="userID" autocomplete="off" required=""/>
                                <label for="userID">User ID</label>
                            </div>
                            <div class="red">
                                <%= userError.getUserID()%>                                
                            </div>
                            <div class="inputbox">
                                <ion-icon name="mail-outline"></ion-icon>
                                <input type="text" name="fullName" id="fullName" autocomplete="off" required=""/>
                                <label for="fullName">Full Name</label>
                            </div>
                            <div class="red">
                                <%= userError.getFullName()%>
                            </div>
                            <div class="inputbox">
                                <ion-icon name="id-card-outline"></ion-icon>
                                <input type="text" name="role" id="role" autocomplete="off" required=""/>
                                <label for="role">Role</label>
                            </div>
                            <div class="red">
                                <%= userError.getRole()%>
                            </div>
                            <div class="inputbox">
                                <ion-icon name="lock-closed-outline"></ion-icon>
                                <input type="password" name="password" id="pass" required=""/>
                                <label for="pass">Password</label>
                            </div>
                            <div class="inputbox">
                                <ion-icon name="bag-check-outline"></ion-icon>
                                <input type="password" name="confirm" id="confirm" required=""/>
                                <label for="confirm">Confirm</label>
                            </div>
                            <div class="red">
                                <%= userError.getConfirm()%>
                            </div>
                            <div class="register">
                                <form action="mainController" method="post">
                                    <input type="submit" name="action" value="Register" class="button"/>
                                    <input type="reset"  value="Reset" class="button"/>

                                </form>
                                <form action="mainController">
                                    <button name="action" value="Logout" class="button">Back</button>
                                </form>
                            </div>
                        </form>
                        <div class="noti">
                            <%
                                String message = (String) session.getAttribute("MESSAGE");
                                if (message == null) {
                                    message = "";
                                }
                            %>
                            <%= message%>  
                        </div>
                    </div>
                </div>
            </section>
            <script type="module" src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
            <script nomodule src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"></script>
        </form>
    </body>
</html>
