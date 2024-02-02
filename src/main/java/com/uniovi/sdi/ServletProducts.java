package com.uniovi.sdi;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ServletProducts", value = "/products")
public class ServletProducts extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        ProductsService productService = new ProductsService();

        List<Product> productsDB =  productService.getProducts();
        request.setAttribute("storedProducts", productsDB);

        getServletContext().getRequestDispatcher("/products-view.jsp").forward(request, response);
    }
}
