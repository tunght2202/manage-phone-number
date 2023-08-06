package controller;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import model.*;
import java.util.*;

public class ListUser extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ListUser</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>You can't use this function</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int role = (int)request.getSession().getAttribute("Role");
        if (role == 0) {
            processRequest(request, response);
        } else {
            response.setContentType("text/html;charset=UTF-8");
            ContactDAO c = new ContactDAO();
            List<User> lst = c.getListUser();
            request.setAttribute("lst", lst);
            request.getRequestDispatcher("ListUser.jsp").forward(request, response);

        }

    }
}
