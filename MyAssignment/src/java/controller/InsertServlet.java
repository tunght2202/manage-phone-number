package controller;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import model.*;
import java.util.*;

public class InsertServlet extends HttpServlet {

    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter pr = response.getWriter();
        String xNameContact,xPhoneNumber;
        int xlogin;
        xNameContact = request.getParameter("NameContact");
        xPhoneNumber = request.getParameter("PhoneNumber");
        xlogin = Integer.parseInt(request.getParameter("idLogin"));
        ContactDAO cd = new ContactDAO();
        Contact c = cd.getContactByName(xlogin, xNameContact);
        if(xNameContact==null || xNameContact.trim().length()==0) {
           pr.print("The name must not be empty!");
           request.getRequestDispatcher("Insert.jsp").include(request, response);
           return;
         }
        if(xPhoneNumber==null || xNameContact.trim().length()==0) {
           pr.print("The phone number must not be empty!");
           request.getRequestDispatcher("Insert.jsp").include(request, response);
           return;
         }
        if(xPhoneNumber.length() >11 || xPhoneNumber.length()<8) {
           pr.print("The phone number must be between 8 and 11!");
           request.getRequestDispatcher("Insert.jsp").include(request, response);
           return;
         }
        if(c.getNameContact() != null) {
           pr.print("The Name " + xNameContact + " already exists!");
           request.getRequestDispatcher("Insert.jsp").include(request, response);
           return;
        }
        c = cd.getContactByPhoneNumber(xlogin, xPhoneNumber);
        if(c != null) {
           pr.print("The phone number " + xPhoneNumber + " already exists!");
           request.getRequestDispatcher("Insert.jsp").include(request, response);
           return;
        }
        cd.inserContact(xlogin,cd.getMaxIdContacts()+1, xNameContact, xPhoneNumber);
        List<Contact> lst = cd.getContacts(xlogin);
        request.setAttribute("lst", lst);
        request.getRequestDispatcher("list.jsp").forward(request, response);
    }
}

