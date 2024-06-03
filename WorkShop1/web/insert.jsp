<%-- 
    Document   : insert
    Created on : May 27, 2024, 7:09:01 PM
    Author     : lienm
--%>

<%@page import="Product.ProductError"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>INSERT PAGE</title>
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
                height: 900px;
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
                margin: 20px 0;
                width: 310px;
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
            .button{
                width: 50%;
                height: 40px;
                border-radius: 40px;
                background: #fff;
                border: none;
                outline: none;
                cursor: pointer;
                font-size: 1em;
                font-weight: 600;
            }
            .button:hover{
                background: linear-gradient(to right,#48c6ef,#6f86d6);
            }
            .flex{
                display: flex;
            }
            .text-decoration{
                text-decoration: none;
                color: white;
            }
            .text-decoration:hover{
                color:#48c6ef;
            }
            .error-message{
                color: red;
            }
            .noti{
                background-color: transparent;
                color: red;
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
                color: crimson;
            }
        </style>
    </head>
    <body>
        <%
            ProductError productError = (ProductError) request.getAttribute("PRODUCT_ERROR");
            if (productError == null) {
                productError = new ProductError();
            }
        %>
        <form action="mainController">
            <section>
                <div class="form-box">
                    <div class="form-value">
                        <<form action="">
                            <h2>ADD NEW PRODUCT</h2>
                            <div class="inputbox">
                                <input type="text" name="mobileID" id="mobileID" autocomplete="off" required=""/>
                                <label for="mobileID">Mobile ID</label>

                            </div>
                            <div class="error-message">
                                <%= productError.getMobileID()%>
                            </div>

                            <div class="inputbox">
                                <input type="text" name="Description" id="Description" autocomplete="off" required=""/>
                                <label for="Description">Description</label>
                            </div> 

                            <div class="error-message">
                                <%= productError.getDescription()%> 
                            </div>

                            <div class="inputbox">
                                <input type="text" name="Price" id="Price" autocomplete="off" required=""/>
                                <label for="Price">Price</label>
                            </div> 

                            <div class="error-message">
                                <%= productError.getPrice()%> 
                            </div>

                            <div class="inputbox">
                                <input type="text" name="mobileName" id="mobileName" autocomplete="off" required=""/>
                                <label for="mobileName">Mobile Name</label>
                            </div> 

                            <div class="error-message">
                                <%= productError.getMobileName()%>
                            </div>

                            <div class="inputbox">                            
                                <input type="text" name="yearOfProduction" id="yearOfProduction" autocomplete="off" required=""/>
                                <label for="yearOfProduction">Year of Production</label>
                            </div> 

                            <div class="error-message">
                                <%= productError.getYearOfProduction()%> 
                            </div>

                            <div class="inputbox">
                                <input type="text" name="Quantity" id="Quantity" autocomplete="off" required=""/>
                                <label for="Quantity">Quantity</label>
                            </div> 
                            <div class="error-message">
                                <%= productError.getQuantity()%> 
                            </div>

                            <div class="inputbox">
                                <input type="text" name="notSale" id="notSale" autocomplete="off" required=""/>
                                <label for="notSale">notSale</label>
                            </div> 
                            <div class="error-message">
                                <%= productError.getNotSale()%>  
                            </div>

                            <div class="flex ">
                                <input type="submit" name="action" value="Add New Mobile" class="button"/>
                                <input type="reset"  value="Reset" class="button"/>
                                <a href="staff.jsp" class="text-decoration">Back to Staff Management</a>
                            </div>
                            <%
                                String message = (String) session.getAttribute("MESSAGE");
                                if (message == null) {
                                    message = "";
                                }
                            %>
                            <div class="noti">
                                <%= message%>  
                            </div>

                        </form>
                    </div>
                </div>
            </section>
            <!--            <script>
                            const errorMessage = document.getElementById("error-message");
                            if (errorMessage.textContent.trim() !== "") {
                                // Show the error message using your preferred method (e.g., alert, modal)
                                alert(errorMessage.textContent); // Example using an alert
                            }
                        </script>-->
        </form>
    </body>
</html>
