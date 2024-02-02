package com.uniovi.sdi;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.HashMap;

@WebServlet(name = "ServletDeleteFromShoppingCart", value = "/ServletDeleteFromShoppingCart")
public class ServletDeleteFromShoppingCart extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        HashMap<String, Integer> cart = (HashMap<String, Integer>) session.getAttribute("cart");

        String product = request.getParameter("product");
        removeOneUnit(cart, product);

        request.setAttribute("selectedItems", cart);
        getServletContext().getRequestDispatcher("/cart.jsp").forward(request, response);
    }

    private void removeOneUnit(HashMap<String, Integer> cart, String productKey) {

        int valorActual = cart.get(productKey);
        if (valorActual == 1) {
            cart.remove(productKey);
        } else {
            cart.put(productKey, valorActual - 1);
        }
    }
}
