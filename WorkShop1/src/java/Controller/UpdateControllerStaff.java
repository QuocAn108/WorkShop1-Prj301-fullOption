/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Product.ProductDAO;
import Product.ProductDTO;
import User.UserDAO;
import User.UserDTO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author lienm
 */
@WebServlet(name = "UpdateControllerStaff", urlPatterns = {"/updateControllerStaff"})
public class UpdateControllerStaff extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private static final String ERROR = "searchControllerStaff";
    private static final String SUCCESS = "searchControllerStaff";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        ProductDAO dao = new ProductDAO();
        try {
            String mobileID = request.getParameter("mobileID");
            String PriceSTR = request.getParameter("Price");
            String Description = request.getParameter("Description");
            String QuantitySTR = request.getParameter("Quantity");
            String notSaleSTR = request.getParameter("notSale");
            HttpSession session = request.getSession();
            float Price = 0;
            int Quantity = 0;
            int notSale = 0;
            boolean checkValidation = true;
            boolean check2 = true;
            if (!PriceSTR.matches("\\d+(\\.\\d+)?$")) {
                session.setAttribute("ERROR", "Invalid Price format!");
                checkValidation = false;
            }
            if (!QuantitySTR.matches("\\d+$")) {
                session.setAttribute("ERROR", "Invalid Quantity format!");
                checkValidation = false;
            }
            if (!notSaleSTR.matches("[0-1]+$")) {
                session.setAttribute("ERROR", "Invalid notSale format!");
                checkValidation = false;
            }
            if (Description.length() > 100 || Description.length() < 2) {
                session.setAttribute("ERROR", "Description length must be between 2 and 100 characters!");
                checkValidation = false;
            }
            if (checkValidation) {
                Price = Float.parseFloat(PriceSTR);
                Quantity = Integer.parseInt(QuantitySTR);
                notSale = Integer.parseInt(notSaleSTR);
                if (Price <= 0 ||Price >10000) {
                    session.setAttribute("ERROR", "Price must be between 0 and 10000!");
                    check2 = false;
                }
                if (Quantity <= 0) {
                    session.setAttribute("ERROR", "Quantity must be greater than 0!");
                    check2 = false;
                }
            }
            if (checkValidation && check2) {
                boolean checkUpdate = dao.update(new ProductDTO(mobileID, Description, Price, "", 0, Quantity, notSale));
                if (checkUpdate) {
                    url = SUCCESS;
                    session.setAttribute("ERROR", "Update successfully!");
                } else {
                    session.setAttribute("ERROR", "Update fail!");
                }
            } else {
                session.setAttribute("ERROR", "Update fail!");
            }

        } catch (Exception e) {
            log("Error at UpdateController: " + e.toString());
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
