/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Product.CartDTO;
import Product.ProductDAO;
import Product.ProductDTO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author lienm
 */
public class AddMobileToLoveListController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
   private static final String ERROR = "user.jsp";
    private static final String SUCCESS = "user.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        ProductDAO dao = new ProductDAO();
        try {
            String mobileID = request.getParameter("mobileID");
            String Description = request.getParameter("Description");
            String PriceSTR = request.getParameter("Price");
            String mobileName = request.getParameter("mobileName");
            String yearOfProductionSTR = request.getParameter("yearOfProduction");
            String notSaleSTR = request.getParameter("notSale");
            String QuantitySTR = request.getParameter("Quantity");
            int Quantity=Integer.parseInt(QuantitySTR);
            float Price = Float.parseFloat(PriceSTR);
            int yearOfProduction = Integer.parseInt(yearOfProductionSTR);
            int notSale = Integer.parseInt(notSaleSTR);
            HttpSession session = request.getSession();
            CartDTO cart = (CartDTO) session.getAttribute("LOVECART");
            if (cart == null) {
                cart = new CartDTO();
            }
            boolean check,check1,check2=true;
                 check= dao.checkDuplicate1(mobileID);
            if(check){
                 check1=dao.delete1(mobileID);
            } else {
                check2=dao.insertLIST(new ProductDTO(mobileID, Description, Price, mobileName, yearOfProduction, Quantity, notSale));
            }
            if (check2) {
                session.setAttribute("LOVECART", cart);
                session.setAttribute("MESSAGE", "You added successfully " + mobileName +" to Love Cart");
                url = SUCCESS;
            }
        } catch (Exception e) {
            log("Error at AddToCartController: " + e.toString());
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
