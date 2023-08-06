package controller;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import model.*;
import java.util.*;

public class Delete2Servlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
       PrintWriter pr = response.getWriter();
        int idLogin = Integer.parseInt(request.getParameter("idLogin"));
        ContactDAO c = new ContactDAO();
        c.deleteUser(idLogin);
        c.deleteAccount(idLogin);
        List<User> lst = c.getListUser();
        request.setAttribute("lst", lst);
        request.getRequestDispatcher("ListUser.jsp").forward(request, response);
        
    }
}

