<%-- 
    Document   : user
    Created on : May 25, 2024, 11:47:42 PM
    Author     : lienm
--%>

<%@page import="java.util.List"%>
<%@page import="Product.ProductDTO"%>
<%@page import="User.UserDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>USER PAGE</title>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" />
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
            .search-text:hover{
                width: 10%;
                border-radius: 10px;
            }
            .header-col .p p{
                color: white;
                font-size: large;
                padding: 11px;
                text-transform: uppercase;
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
                cursor: pointer;
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
            td i{
                font-size: 30px; 
            }
            .btn{
                background: white;
                color: black;
                outline: none;
            }
            .colorClick{
                background: linear-gradient(to right,#ff9a9e , #fecfef,#fecfef);
            }
            .btn:hover{
                background:linear-gradient(to right,#007adf , #00ecbc);
            }
        </style>
    </head>
    <body>

        <%
            UserDTO loginUser = (UserDTO) session.getAttribute("LOGIN_USER");
            if (loginUser == null || !(loginUser.getRole() == 0)) {
                response.sendRedirect("login.jsp");
                return;
            }
            String MIN = request.getParameter("MIN");
            if (MIN == null) {
                MIN = "";
            }
            String MAX = request.getParameter("MAX");
            if (MAX == null) {
                MAX = "";
            }
        %>
        <div class="header-col">
            <div class="flex p">
                <p>Welcome back User:</p>
                <h1><%= loginUser.getFullName()%></h1>
            </div>
        </div>
        <form action="mainController" method="POST">
            <div class="header-col">
                <div class="flex">
                    <input type="number" name="MIN" value="<%= MIN%>" placeholder="MIN" min="1" max="9999" class="search-text"/>
                    <input type="number" name="MAX" value="<%= MAX%>" placeholder="MAX" min="1" max="9999" class="search-text"/>
                </div>
                <div class="flex">
                    <input type="submit" name="action" value="SearchProduct" class="button"/>
                    <input type="submit" name="action" value="ViewCart" id="viewcart" class="button"/>     
                </div>
                <div class="flex">
                    <input type="submit" name="action" value="Logout" class="button"/>
                </div>

            </div>
            <%
                List<ProductDTO> listProduct = (List) session.getAttribute("LIST_PRODUCT");
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
                            <th></th>
                            <th></th>

                        </tr>
                    </thead>
                    <tbody>
                        <%
                            int count = 1;
                            for (ProductDTO product : listProduct) {
                                if (product.getNotSale() == 0) {
                        %>
                    <form action="mainController" method="POST">
                        <tr>
                            <td><%= count++%></td>
                            <td>
                                <input type="text" name="mobileID" value="<%= product.getMobileID()%>" readonly=""/>
                            </td>
                            <td>
                                <input type="text" name="Description" value="<%= product.getDescription()%>" required="" readonly=""/>
                            </td>
                            <td>
                                <input type="number" name="Price" value="<%= product.getPrice()%>" required="" readonly=""/>
                            </td>
                            <td>
                                <input type="text" name="mobileName" value="<%= product.getMobileName()%>" required="" readonly=""/>
                            </td>
                            <td>
                                <input type="number" name="yearOfProduction" value="<%= product.getYearOfProduction()%>" required="" readonly=""/>
                            </td>
                            <td>
                                <input type="number" name="Quantity" value="<%= product.getQuantity()%>" required="" readonly=""/>
                            </td>
                            <td>
                                <input type="text" name="notSale" value="<%= product.getNotSale()%>" required="" readonly=""/>
                            </td>
                            <td>
                                <input type="submit" value="AddMobileToCart" name="action"/>                              
                            </td>
                            <td>
                                <button value="AddMobileToLoveCart" name="action" class="btn" id="addMobileToLoveCart_<%= product.getMobileID()%>"><i class="far fa-heart"></i></button>
                            </td>
                        </tr>
                    </form>

                    <%
                            }
                        }
                    %>


                    </tbody>
                </table>
            </div>


            <%
                    }
                }
            %>

            <div class="flex noti">
                <%
                    String message = (String) session.getAttribute("MESSAGE");
                    if (message == null) {
                        message = "";
                    }
                %>
                <%= message%>  
            </div>
        </form>
        <script>
            document.addEventListener('DOMContentLoaded', () => {
                const btnList = document.querySelectorAll('.btn');

                // Apply the colorClick class from localStorage
                btnList.forEach(btn => {
                    const btnId = btn.getAttribute('id');
                    if (localStorage.getItem(btnId) === 'clicked') {
                        btn.classList.add('colorClick');
                    }
                });

                // Add click event listeners
                btnList.forEach(btn => {
                    btn.addEventListener('click', () => {
                        const btnId = btn.getAttribute('id');
                        if (btn.classList.contains('colorClick')) {
                            // If the button is already clicked, remove the colorClick class and clear from localStorage
                            btn.classList.remove('colorClick');
                            localStorage.removeItem(btnId);
                        } else {
                            // If the button is not clicked, add the colorClick class and set in localStorage
                            btn.classList.add('colorClick');
                            localStorage.setItem(btnId, 'clicked');
                        }
                    });
                });

                // Handle logout and clear localStorage
                const logoutBtn = document.querySelector('input[name="action"][value="Logout"]');
                if (logoutBtn) {
                    logoutBtn.addEventListener('click', () => {
                        localStorage.clear();
                    });
                }
            });

        </script>

    </body>
</html>
