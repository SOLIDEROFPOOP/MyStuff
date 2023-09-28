package com.example.demo;

import com.example.demo2.DefinitelyNotADB;
import com.example.demo2.Footballer;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "fffServlet", value = "/fffServlet")
public class fffServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = (String) request.getParameter("f_name");
        Integer salsa = Integer.parseInt(request.getParameter("f_salary"));
        String club = (String) request.getParameter("f_club");
        Integer price = Integer.parseInt(request.getParameter("f_price"));
        Footballer footballer = new Footballer(0 , name , salsa , club , price);
        DefinitelyNotADB.addFootballer(footballer);
        response.sendRedirect("hello-servlet");
    }
}