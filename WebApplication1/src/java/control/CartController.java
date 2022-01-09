/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import dao.DAO;
import entity.Account;
import entity.Cart;
import entity.Product;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.jasper.tagplugins.jstl.core.ForEach;

/**
 *
 * @author TRONG NGHIA
 */
@WebServlet(name = "CartController", urlPatterns = {"/cart"})
public class CartController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        HttpSession  session = request.getSession();
        Account acc =(Account) session.getAttribute("acc");
        String idPro = request.getParameter("pid");
        DAO dao = new DAO();
        Product product = dao.getProductByid(idPro);
        int amount =1;
        int size =0;
        if(product != null){
            if(session.getAttribute("lstcart") == null){
                List<Cart> cart = new ArrayList<Cart>();
                Cart item = new Cart();
                
                item.setIdUser(acc.id);
                item.setIdProduct(product.getId());
                item.setNameProduct(product.getName());
                item.setImage(product.getImage());
                item.setPrice(product.getPrice());
                item.setAmount(amount);
                item.setDateBuy(LocalDate.now());
                cart.add(item);
                session.setAttribute("lstcart", cart);
                size = cart.size();
            }
            else{
                List<Cart> cart = (List<Cart>) session.getAttribute("lstcart") ;
                boolean check = false;
                for (Cart item : cart) {
                    if(item.getIdProduct() == product.getId()){
                        item.setAmount(item.getAmount() + amount);
                        check =true;
                    }
                }
                if(!check){
                    Cart item = new Cart();
                    item.setIdUser(acc.id);
                    item.setIdProduct(product.getId());
                    item.setNameProduct(product.getName());
                    item.setImage(product.getImage());
                    item.setPrice(product.getPrice());
                    item.setAmount(amount);
                    item.setDateBuy(LocalDate.now());
                    cart.add(item);
                }
                session.setAttribute("lstcart", cart);
                size = cart.size();
            }
            session.setAttribute("size", size);
           // response.sendRedirect("home");
            request.getRequestDispatcher("home");
        }
        response.sendRedirect("home");
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
