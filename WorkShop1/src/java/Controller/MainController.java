/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author lienm
 */
@WebServlet(name = "MainController", urlPatterns = {"mainController"})
public class MainController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private static final String ERROR = "error.jsp";
    private static final String LOGIN = "Login";
    private static final String LOGIN_CONTROLLER = "loginController";
    private static final String LOGOUT = "Logout";
    private static final String LOGOUT_CONTROLLER = "logoutController";
    private static final String SEARCH = "Search";
    private static final String SEARCH_CONTROLLER_STAFF = "searchControllerStaff";
    private static final String SEARCH_USER = "SearchProduct";
    private static final String SEARCH_CONTROLLER_USER = "searchControllerUser";
    private static final String DELETE = "Delete";
    private static final String DELETE_CONTROLLER = "deleteControllerStaff";
    private static final String UPDATE = "Update";
    private static final String UPDATE_CONTROLLER = "updateControllerStaff";
    private static final String AddMobileToCart = "AddMobileToCart";
    private static final String Add_to_cart_CONTROLLER = "addMobileToCartController";
    private static final String REMOVE = "RemoveProduct";
    private static final String REMOVE_CONTROLLER = "removeProductByUserController";
    private static final String REMOVE1 = "RemoveProductLove";
    private static final String REMOVE1_CONTROLLER = "removeProductLoveController";
    private static final String ViewCart = "ViewCart";
    private static final String ViewCart_CONTROLLER = "userCart.jsp";
    private static final String AddMobileToLoveCart = "AddMobileToLoveCart";
    private static final String Add_to_love_cart_CONTROLLER = "addMobileToLoveListController";
    private static final String ViewLoveCart = "ViewLoveCart";
    private static final String ViewLoveCart_CONTROLLER = "loveCart.jsp";
    private static final String INSERT = "Add New Mobile";
    private static final String INSERT_CONTROLLER = "insertProductController";
    private static final String REGISTER = "Register";
    private static final String Register_CONTROLLER = "registerController";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            String action = request.getParameter("action");
            if (LOGIN.equals(action)) {
                url = LOGIN_CONTROLLER;
            } else if (LOGOUT.equals(action)) {
                url = LOGOUT_CONTROLLER;
            } else if (SEARCH.equals(action)) {
                url = SEARCH_CONTROLLER_STAFF;
            } else if (DELETE.equals(action)) {
                url = DELETE_CONTROLLER;
            } else if (UPDATE.equals(action)) {
                url = UPDATE_CONTROLLER;
            } else if (SEARCH_USER.equals(action)) {
                url = SEARCH_CONTROLLER_USER;
            } else if (AddMobileToCart.equals(action)) {
                url = Add_to_cart_CONTROLLER;
            } else if (REMOVE.equals(action)) {
                url = REMOVE_CONTROLLER;
            } else if (ViewCart.equals(action)) {
                url = ViewCart_CONTROLLER;
            } else if (INSERT.equals(action)) {
                url = INSERT_CONTROLLER;
            } else if (REGISTER.equals(action)) {
                url = Register_CONTROLLER;
            } else if (AddMobileToLoveCart.equals(action)) {
                url = Add_to_love_cart_CONTROLLER;
            } else if (ViewLoveCart.equals(action)) {
                url = ViewLoveCart_CONTROLLER;
            }else if(REMOVE1.equals(action)){
                url = REMOVE1_CONTROLLER;
            }
            else {
                request.setAttribute("ERROR", "Your action not support");
            }
        } catch (Exception e) {
            log("Error at MainController: " + e.toString());
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
