<%-- 
    Document   : userCart
    Created on : May 27, 2024, 5:41:22 PM
    Author     : lienm
--%>

<%@page import="java.text.DecimalFormat"%>
<%@page import="Product.ProductDTO"%>
<%@page import="Product.CartDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>USER CART PAGE</title>
        <style>
            *{
                margin: 0;
                padding: 0;
                font-family: 'poppins',sans-serif;
            }
            body{
                /*                display: flex;
                                justify-content: center;
                                align-items: center;*/
                min-height: 100vh;
                width: 100%;
                background: linear-gradient(to right,#48c6ef,#6f86d6);
                background-position: center;
                background-size: cover;

            }
            .flex{
                display: flex;  
                justify-content: center;
            }
            .header-col{
                flex-direction: column;
            }
            .header-col h1{
                color: white;
            }
            .header-col a{
                text-decoration: none;
                color: greenyellow;
                font-weight: bold;
            }
            .button{
                border-radius: 10px;
                background: lightskyblue;
                margin-right: 5px;
            }
            .button:hover{
                background: linear-gradient(to right,#007adf , #00ecbc);    
            }
            .table-box{
                box-shadow: 0 0 5px darkblue;
                color: white;
                margin-top: 200px;
            }
            th{
                border-radius: 5px;
                background: linear-gradient(to right,#30cfd0 ,#330867);
            }
            th:hover{
                background: linear-gradient(to right,#007adf , #00ecbc);
            }
            td{
                background: white;
                color: black;
                border-radius: 5px;
                opacity: 0.9;
            }
            td:hover{
                background: linear-gradient(to right,#007adf , #00ecbc);
                opacity: 1;
            }
            td input{
                background: white;
                color: black;
                padding: 5px;
                border-radius: 5px;
                opacity: 0.9;
            }
            td input:hover{
                background: linear-gradient(to right,#007adf , #00ecbc);
                opacity: 1;
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
            }
            .noti:hover{
                opacity: 1;
                color: blue;
            }
        </style>
    </head>
    <body>
        <div class="header-col">
            <div class="flex">
                <h1>Your Cart:</h1>
            </div>
            <div class="flex">
                <a href="user.jsp" class="button">Add more</a>
            </div>
        </div>
        <%
            CartDTO cart = (CartDTO) session.getAttribute("CART");
            if (cart != null) {
        %>
        <div class="flex">
            <table border="1" class="table-box">
                <thead>
                    <tr>
                        <th>Mobile ID</th>
                        <th>Description</th>
                        <th>Price</th>
                        <th>Mobile Name</th>
                        <th>Year Of Production</th>
                        <th>Quantity</th>
                        <th>notSale</th>
                        <th>Total</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        double total = 0;
                        for (ProductDTO p : cart.getCart().values()) {
                            total += p.getPrice() * p.getQuantity();
                    %>
                <form action="mainController" method="POST">
                    <tr>
                        <td> 
                            <input type="text" name="mobileID" value="<%= p.getMobileID()%>" readonly=""/>
                        </td>
                        <td> 
                            <input type="text" name="Description" value="<%= p.getDescription()%>" readonly=""/>
                        </td>
                        <td><%= p.getPrice()%>$</td>
                        <td> 
                            <input type="text" name="mobileName" value="<%= p.getMobileName()%>" readonly=""/>
                        </td>
                        <td> 
                            <input type="text" name="yearOfProduction" value="<%= p.getYearOfProduction()%>" readonly=""/>
                        </td>

                        <td>
                            <input type="number" min="1" name="quantity" value="<%= p.getQuantity()%>" required=""/>
                        </td>
                        <td>
                            <input type="number" min="0" max="1" name="notSale" value="<%= p.getNotSale()%>" required=""/>
                        </td>
                        <td><%= p.getPrice() * p.getQuantity()%>$</td>
                        <td>
                            <input type="submit" name="action" value="RemoveProduct" />
                        </td>
                    </tr>
                </form>

                <%
                    }
                %>

                </tbody>
            </table>
        </div>
        <%
            DecimalFormat df = new DecimalFormat("0.00");
            String formattedTotal = df.format(total);
        %>  
        <div class="flex noti">
            <h1>Total: <%= formattedTotal%> $  </h1>    
        </div>  
        <%
            }
        %>

    </body>
</html>
