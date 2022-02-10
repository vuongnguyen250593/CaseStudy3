package control;

import dao.DAO;
import model.category;
import model.product;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "HomeControlServlet", urlPatterns = {"/home"})
public class HomeControlServlet extends HttpServlet {
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
        DAO dao = new DAO();
        List<product> list = dao.getAllProduct();
        List<category> categories = dao.getAllCategory();
        request.setAttribute("listProduct", list);
        request.setAttribute("categories", categories);
        request.getRequestDispatcher("view/index.jsp").forward(request, response);

    }
}
