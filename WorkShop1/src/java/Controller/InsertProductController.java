/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Product.ProductDAO;
import Product.ProductDTO;
import Product.ProductError;
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
@WebServlet(name = "InsertProductController", urlPatterns = {"insertProductController"})
public class InsertProductController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private static final String ERROR = "insertProductController";
    private static final String SUCCESS = "insertProductController";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        ProductDAO dao = new ProductDAO();
        ProductError productError = new ProductError();
        try {
            String mobileID = request.getParameter("mobileID");
            String Description = request.getParameter("Description");
            String PriceSTR = request.getParameter("Price");
            String mobileName = request.getParameter("mobileName");
            String yearOfProductionSTR = request.getParameter("yearOfProduction");
            String QuantitySTR = request.getParameter("Quantity");
            String notSaleSTR = request.getParameter("notSale");
            float Price = 0;
            int Quantity = 0;
            int yearOfProduction = 0;
            int notSale = 0;
            HttpSession session = request.getSession();
            boolean checkValidation = true;
            boolean check2 = true;
            if (!PriceSTR.matches("\\d+$"))
            {
                productError.setPrice("Price must be digit");
                checkValidation = false;
            }
            if (!yearOfProductionSTR.matches("\\d+$"))
            {
                productError.setYearOfProduction("YearOfProduction must be digit");
                checkValidation = false;
            }
            if (!QuantitySTR.matches("\\d+$"))
            {
                productError.setQuantity("Quantity must be digit");
                checkValidation = false;
            }
            if (!notSaleSTR.matches("[0-1]+$"))
            {
                productError.setNotSale("NotSale must be from 0 to 1");
                checkValidation = false;
            }

            if (mobileID.length() > 50 || mobileID.length() < 2) {
                productError.setMobileID("Mobile ID must have length [2,50]");
                checkValidation = false;
            }
            if (!mobileID.matches("^M\\d{3}$")) {
                productError.setMobileID("Mobile ID must have form [Mxxx]");
                checkValidation = false;
            }
            boolean checkDuplicate = dao.checkDuplicate(mobileID);
            if (checkDuplicate) {
                productError.setMobileID("Duplicate mobileID!");
                checkValidation = false;
            }
            if (Description.length() > 100 || Description.length() < 2) {
                productError.setDescription("Description must have length [2,100]");
                checkValidation = false;
            }
            if (mobileName.length() > 100 || mobileName.length() < 5) {
                productError.setMobileName("Mobile Name  must [5,100]");
                checkValidation = false;
            }
            if (checkValidation) {
                Price = Float.parseFloat(PriceSTR);
                yearOfProduction = Integer.parseInt(yearOfProductionSTR);
                Quantity = Integer.parseInt(QuantitySTR);
                notSale = Integer.parseInt(notSaleSTR);
                if (Price <= 0) {
                    productError.setPrice("Price must positive!!!");
                    check2 = false;
                }
                if (yearOfProduction <= 0) {
                    productError.setYearOfProduction("YearOfProduction must positive!!!");
                    check2 = false;
                }
                if (Quantity <= 0) {
                    productError.setQuantity("Quantity must positive!!!");
                    check2 = false;
                }
            }
            if (checkValidation && check2) {
                boolean checkInsert = dao.insert(new ProductDTO(mobileID, Description, Price, mobileName, yearOfProduction, Quantity, notSale));
                if (checkInsert) {
                    url = SUCCESS;
                    session.setAttribute("MESSAGE", "You added successfully " + mobileName);
                }
            } else {
                request.setAttribute("PRODUCT_ERROR", productError);
            }

        } catch (Exception e) {
            log("Error at InsertProductController: " + e.toString());
        } finally {
            request.getRequestDispatcher("./insert.jsp").forward(request, response);
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
