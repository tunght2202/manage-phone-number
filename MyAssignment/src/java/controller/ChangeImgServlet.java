package controller;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import model.*;
import java.util.*;

public class ChangeImgServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter pr = response.getWriter();
        int idLogin = Integer.parseInt(request.getParameter("idLogin"));
        String changeImg = request.getParameter("changeImg");
        if (changeImg == null || changeImg.trim().length() == 0) {
            pr.println("Img can't empty");
            request.getRequestDispatcher("Information.jsp").include(request, response);
        } else {
            ContactDAO c = new ContactDAO();
            c.changeImg(idLogin, changeImg);
            User u = c.getUser(idLogin);
            request.setAttribute("u", u);
            request.getRequestDispatcher("Useruse.jsp").forward(request, response);
        }
    }
}
