<%-- 
    Document   : staff
    Created on : May 25, 2024, 11:47:35 PM
    Author     : lienm
--%>

<%@page import="java.util.List"%>
<%@page import="User.UserDTO"%>
<%@page import="Product.ProductDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>STAFF PAGE</title>
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
            .search-text{
                width: 41px;
                border-radius: 10px;
                transition:0.2s
            }
            .header-col .p p{
                color: white;
                font-size: large;
                padding: 11px;
                text-transform: uppercase;
            }
            .search-text:hover{
                width: 40%;
                border-radius: 10px;
            }
            .button{
                border-radius: 10px;
                background: transparent;
                margin-right: 5px;
                border: 1px solid white;
            }
            .button:hover{
                background: linear-gradient(to right,#007adf , #00ecbc);    
                border: 1px solid blue;
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
                border-radius: 5px;
                background: linear-gradient(to right,#30cfd0 ,#330867);
                color: white;
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
            .border{
                text-decoration: none;
                color: white;
                margin-left: 3px;
                border: 1px solid #48c6ef;
                border-radius: 10px;
                background: #48c6ef
            }
            .border:hover{
                color: black;
                background: linear-gradient(to right,#007adf , #00ecbc);    
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
            }
            .noti:hover{
                opacity: 1;
                color: crimson;
            }
        </style>
    </head>
    <body>
        <%
            UserDTO loginUser = (UserDTO) session.getAttribute("LOGIN_USER");
            if (loginUser == null || !(loginUser.getRole() == 2)) {
                response.sendRedirect("login.jsp");
                return;
            }
            String search = request.getParameter("search");
            if (search == null) {
                search = "";
            }
        %>
        <div class="header-col">
            <div class="flex p">
                <p>Welcome back Staff:</p>
                <h1><%= loginUser.getFullName()%></h1>
            </div>
            <form action="mainController">
                <div class="flex">
                    <input type="text" name="search" value="<%= search%>"  class="search-text" placeholder="Search"/>
                    <input type="submit" name="action" value="Search" class="button"/>
                </div>
            </form>
            <form action="mainController" method="POST">         
                <div class="flex ">
                    <input type="submit" name="action" value="Logout" class="button"/>
                </div>
                <div class="flex">
                    <p>Create new mobile<a href="insert.jsp" class="border"> Click here<a/></p>
                </div>
            </form> 
        </div>

        <%
            List<ProductDTO> listProduct = (List) request.getAttribute("LIST_PRODUCT");
            if (listProduct != null) {
                if (listProduct.size() > 0) {
        %>

        <div class="flex">
            <table border="1" class="table-box">
                <thead>
                    <tr>
                        <th>No</th>
                        <th>Mobile ID</th>
                        <th>Description</th>
                        <th>Price</th>
                        <th>Mobile Name</th>
                        <th>Year Of Production</th>
                        <th>Quantity</th>
                        <th>notSale</th>
                        <th>Delete</th>
                        <th>Update</th>

                    </tr>
                </thead>
                <tbody>
                    <%
                        int count = 1;
                        for (ProductDTO product : listProduct) {
                    %>
                <form action="mainController" method="POST">
                    <tr>
                        <td><%= count++%></td>
                        <td>
                            <input type="text" name="mobileID" value="<%= product.getMobileID()%>" readonly="" readonly=""/>
                        </td>
                        <td>
                            <input type="text" name="Description" value="<%= product.getDescription()%>" required=""/>
                        </td>
                        <td>
                            <input type="text" name="Price" value="<%= product.getPrice()%>" required=""/>
                        </td>
                        <td>
                            <input type="text" name="mobileName" value="<%= product.getMobileName()%>" required="" readonly=""/>
                        </td>
                        <td>
                            <input type="text" name="yearOfProduction" value="<%= product.getYearOfProduction()%>" required="" readonly=""/>
                        </td>
                        <td>
                            <input type="text" name="Quantity" value="<%= product.getQuantity()%>" required=""/>
                        </td>
                        <td>
                            <input type="text" name="notSale" value="<%= product.getNotSale()%>" required=""/>
                        </td>
                        <!--detele o day ne-->
                        <td>
                            <input type="submit" name="action" value="Delete"/>
                            <input type="hidden" name="search" value="<%= search%>"/>
                        </td>
                        <!--update i day ne-->  
                        <td>
                            <input type="submit" name="action" value="Update"/>
                            <input type="hidden" name="search" value="<%= search%>"/>
                        </td>
                    </tr>
                </form>
                <%
                    }
                %>

                </tbody>
            </table>

        </div>
        <div class="flex noti">
            <%
                String error = (String) session.getAttribute("ERROR");
                if (error == null) {
                    error = "";
                }
            %>
            <%= error%>
        </div>
        <%
                }
            }
        %>
    </body>
</html>
