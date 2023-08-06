package controller;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import model.*;
import java.util.*;

public class DeleteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
       PrintWriter pr = response.getWriter();
        int idContacts = Integer.parseInt(request.getParameter("idContacts"));
        ContactDAO c = new ContactDAO();
        c.delete(idContacts);
        int idlogin=(int)request.getSession().getAttribute("IdLogin");
        List<Contact> lst = c.getContacts(idlogin);
        request.setAttribute("lst", lst);
        request.getRequestDispatcher("list.jsp").forward(request, response);
        
    }
}

