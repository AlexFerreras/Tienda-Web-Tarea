package servlet;

import DAO.Impl.ProductDaoImpl;
import Models.Product;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "HomeController", urlPatterns = {"/Home/*"})
public class HomeController extends HttpServlet {
    
    ProductDaoImpl productContext = new ProductDaoImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int totalInvestedWithITB =0;
        int totalProducts =0;
                
        List<Product> products = productContext.getAll();
        
        for (Product product: products){
        
            totalProducts =+ totalProducts +1;
                   

            //aplying the ITB
            totalInvestedWithITB += (product.getPrice() + (product.getPrice()*0.018));
        }
        
        request.setAttribute("totalProducts", totalProducts);
        request.setAttribute("totalInvestedWithITB", totalInvestedWithITB);

       
        request.getRequestDispatcher("index.jsp").include(request, response);

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
