package control;

import dao.DAO;
import model.category;
import model.product;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "DetailControlServlet", value = "/detail")
public class DetailControlServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request,response);
    }
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        response.setContentType("text/html;charset=UTF-8");
        String productID = request.getParameter("productID");
        DAO dao = new DAO();
        product pr = dao.getProductByID(productID);
        List<category> categories = dao.getAllCategory();
        request.setAttribute("productDetail", pr);
        request.setAttribute("categories", categories);
        request.getRequestDispatcher("view/single-product-details.jsp").forward(request, response);
    }
}
