
package servlret;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Services.ProductDao;

@WebServlet(name = "HomeController", urlPatterns = {"/Home"})
public class HomeController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        ProductDao pd = new ProductDao();
        pd.CreateConnection();
        
        System.err.println("ejemplo por aqui");
       request.getRequestDispatcher("index.jsp").include(request, response);
       
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
