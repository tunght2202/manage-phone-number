/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import model.*;
import java.util.*;

/**
 *
 * @author Thanh Tung
 */
public class UpdateSrvlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter pr = response.getWriter();
        int idContacts = Integer.parseInt(request.getParameter("idContacts"));
        ContactDAO c = new ContactDAO();
        Contact x = c.getContactByIdContacts(idContacts);
        request.setAttribute("x", x);
        request.getRequestDispatcher("update.jsp").forward(request, response);

    }
    
    @Override
       protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter pr = response.getWriter();
        String xName, xPhoneNumber, sIdContact;int xIdContact;
        xName = request.getParameter("nameContact");
        xPhoneNumber = request.getParameter("phoneNumber");
        sIdContact = request.getParameter("idContact");
        xIdContact = Integer.parseInt(sIdContact);
        boolean isOk = true;
        if(xName==null || xName.trim().length()==0 || xName.trim().equals("Invalid name!")) {
           xName = "Invalid name!"; 
           isOk = false;
        }
        if(xPhoneNumber==null || xPhoneNumber.trim().length()==0 || xPhoneNumber.trim().equals("Invalid name!")) {
           xPhoneNumber = "Invalid name!"; 
           isOk = false;
        }
        Contact x = new Contact(xName, xPhoneNumber, xIdContact);
        if(!isOk) {
          request.setAttribute("x", x);
          request.getRequestDispatcher("update.jsp").forward(request, response);
          return;
        }
        ContactDAO c = new ContactDAO();
        c.update(xIdContact, x);
        int idlogin=(int)request.getSession().getAttribute("IdLogin");
        List<Contact> lst = c.getContacts(idlogin);
        request.setAttribute("lst", lst);
        request.getRequestDispatcher("list.jsp").forward(request, response);
    }
}
