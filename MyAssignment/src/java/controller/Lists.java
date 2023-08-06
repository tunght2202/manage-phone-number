package controller;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import model.*;
import java.util.*;

public class Lists extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        ContactDAO c = new ContactDAO();
        int idLogin = (Integer.parseInt(request.getParameter("idLogin")));
        List<Contact> lst = c.getContacts(idLogin);
        if(lst == null){
            out.print("Don't have contact, you should add first!");
            request.getRequestDispatcher("Useruse.jsp").include(request, response);
            return;
        }
        request.setAttribute("lst", lst);
        request.setAttribute("idlogin", idLogin);
        request.getRequestDispatcher("list.jsp").forward(request, response);

    }
}

