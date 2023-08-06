package controller;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import model.*;
import java.util.*;

public class ChangePhoneNumber extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter pr = response.getWriter();
        int idLogin = Integer.parseInt(request.getParameter("idLogin"));
        String PhoneNumber = request.getParameter("PhoneNumber");
        if (PhoneNumber == null || PhoneNumber.trim().length() == 0) {
            pr.println("Phone number can't empty");
            request.getRequestDispatcher("Information.jsp").include(request, response);
        } else {
            ContactDAO c = new ContactDAO();
            c.changePhoneNumber(idLogin, PhoneNumber);
            User u = c.getUser(idLogin);
            request.setAttribute("u", u);
            request.getRequestDispatcher("Useruse.jsp").forward(request, response);
        }
    }
}
