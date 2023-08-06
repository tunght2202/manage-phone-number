package controller;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import model.*;
import java.util.*;

public class SortServlet extends HttpServlet {



    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter pr = response.getWriter();
        String xColName,xSortType;
        int xidLogin;
        xColName = request.getParameter("colName").trim();
        xSortType = request.getParameter("sortType");
        xidLogin = Integer.parseInt(request.getParameter("idLogin"));
        if(xSortType==null) {
           pr.print("<h3> The sort type cannot be empty!");
           request.getRequestDispatcher("list.jsp").include(request, response);
           return;
        }
        ContactDAO cd = new ContactDAO();
        List<Contact> lst = cd.getContacts(xidLogin,xColName,xSortType);
        if(lst == null){
            pr.print("Don't have contact, you should add first!");
            request.getRequestDispatcher("Useruse.jsp").include(request, response);
            return;
        }
        request.setAttribute("lst", lst);
        request.getRequestDispatcher("list.jsp").forward(request, response);

    }
}

