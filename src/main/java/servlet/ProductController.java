/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import Models.Product;
import DAO.Impl.ProductDaoImpl;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ALEX FERRERAS
 */
@WebServlet(name = "ProductController", urlPatterns = {"/Product/*"})
public class ProductController extends HttpServlet {

    ProductDaoImpl productContext = new ProductDaoImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            if ((String) request.getParameter("id") != null) {
                int id = Integer.parseInt((String) request.getParameter("id"));
                productContext.delete(id);
                response.sendRedirect("Product");
                return;
            }

            List<Product> products = productContext.getAll();
            request.setAttribute("products", products);
            RequestDispatcher rd = request.getRequestDispatcher("index.jsp?page=listProduct");
            rd.forward(request, response);

        } catch (Exception e) {
            System.err.println("Excepcion " + e.getMessage());
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {

            String name = request.getParameter("name");
            int quantity = Integer.parseInt((String) request.getParameter("quantity"));
            double price = Double.parseDouble((String) request.getParameter("price"));
            String category = request.getParameter("category");
            String suplier = request.getParameter("suplier");
            String description = request.getParameter("description");
            Date date = Calendar.getInstance().getTime();
            DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
            String strDate = dateFormat.format(date);
            if ((String) request.getParameter("id") != null) {
                System.err.println("ESTOY EN EL EDITAR");
                int id = Integer.parseInt((String) request.getParameter("id"));
                System.err.println("ESTOY EN EL EDITAR");
                productContext.update(new Product(name, price, quantity, category, suplier, description, strDate), id);
            } else {
                productContext.create(new Product(name, price, quantity, category, suplier, description, strDate));
            }
        } catch (Exception e) {

            System.err.println(e.getMessage());
        } finally {
            response.sendRedirect("Product");
        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
