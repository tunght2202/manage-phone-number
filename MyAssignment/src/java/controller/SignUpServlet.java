package controller;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import model.*;

public class SignUpServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        ContactDAO c = new ContactDAO();
        String nameAccountSigUp = request.getParameter("NameAccountSigUp");
        String passwordSigUp = request.getParameter("PasswordSigUp");
        String userNameSigUp = request.getParameter("UserNameSigUp");
        String phoneNumberSigUp = request.getParameter("PhoneNumberSigUp");
        String avatarSigUp = request.getParameter("AvatarSigUp");
//        out.println("Exit Phone Number ! Enter Again !");
//        out.print(phoneNumberSigUp.equals(c.getUser(nameAccountSigUp).getPhoneNumberUser()));
//            request.getRequestDispatcher("signin.html").include(request, response);
        if (nameAccountSigUp.trim().isEmpty()) {
            out.println("You must enter your name Account!");
            request.getRequestDispatcher("sigup.html").include(request, response);
        } else if (nameAccountSigUp.equals(c.getLoginAccount(nameAccountSigUp).getLoginName())) {
            out.println("Exit Account ! Enter Again !");
            request.getRequestDispatcher("sigup.html").include(request, response);
        } else if (passwordSigUp.trim().isEmpty()) {
            out.println("You must enter your Password!");
            request.getRequestDispatcher("sigup.html").include(request, response);
        } else if (userNameSigUp.trim().isEmpty()) {
            out.println("You must enter your Name!");
            request.getRequestDispatcher("sigup.html").include(request, response);
        } else if (phoneNumberSigUp.trim().isEmpty()) {
            out.println("You must enter your Phone Number!");
            request.getRequestDispatcher("sigup.html").include(request, response);
        } else if (phoneNumberSigUp.equals(c.getUserByPhone(phoneNumberSigUp).getPhoneNumberUser())) {
            out.println("Exit Phone Number ! Enter Again !");
            request.getRequestDispatcher("sigup.html").include(request, response);
        } else if (avatarSigUp.trim().isEmpty()) {
            avatarSigUp = "https://gocbao.net/wp-content/uploads/2020/10/avatar-trang-4.jpg";
            User u = new User(userNameSigUp, phoneNumberSigUp, avatarSigUp);
            c.insertAccount(nameAccountSigUp, passwordSigUp);
            int xIdUser = c.getMaxIdUser() + 1;
            c.insertUser(c.getMaxIdLogin(), xIdUser, u);
            out.println("Create Account Succesfull!");
            request.getRequestDispatcher("signin.html").include(request, response);
        } else {
            User u = new User(userNameSigUp, phoneNumberSigUp, avatarSigUp);
            c.insertAccount(nameAccountSigUp, passwordSigUp);
            int xIdUser = c.getMaxIdUser() + 1;
            c.insertUser(c.getMaxIdLogin(), xIdUser, u);
            out.println("Create Account Succesfull!");
            request.getRequestDispatcher("signin.html").include(request, response);
        }
    }
}
