package controller;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import model.*;

public class SignIn extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String xNameAccount = request.getParameter("NameAccount");
        String xPassword = request.getParameter("Password");
        ContactDAO c = new ContactDAO();
        int check = c.checkNameAccount(xNameAccount, xPassword);
        switch (check) {
            case 1:
                User u = c.getUser(xNameAccount);
                request.getSession().setAttribute("Role", u.getRole());
                request.getSession().setAttribute("IdLogin", u.getIdLogin());
                request.setAttribute("u", u);
                request.getRequestDispatcher("Useruse.jsp").forward(request, response);
                break;
            case 2:
                out.print("not exit account!");
                request.getRequestDispatcher("signin.html").include(request, response);
                break;
            default:
                out.print("sai password!");
                request.getRequestDispatcher("signin.html").include(request, response);
                break;
        }

    }
}

