package controller;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import model.*;
import java.util.*;

public class ChangePassword extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter pr = response.getWriter();
        int idLogin = Integer.parseInt(request.getParameter("idLogin"));
        String password = request.getParameter("password");
        String repassword = request.getParameter("repassword");
        if (password == null || password.trim().length() == 0||repassword == null || repassword.trim().length() == 0) {
            pr.println("Password or repassword can't empty");
            request.getRequestDispatcher("Information.jsp").include(request, response);
        }else if(!password.equals(repassword)){
                pr.println("Password and repassword not same!");
            request.getRequestDispatcher("Information.jsp").include(request, response);
        }else {
            ContactDAO c = new ContactDAO();
            c.changePassword(idLogin, password);
            User u = c.getUser(idLogin);
            request.setAttribute("u", u);
            request.getRequestDispatcher("Useruse.jsp").forward(request, response);
        }
    }
}
