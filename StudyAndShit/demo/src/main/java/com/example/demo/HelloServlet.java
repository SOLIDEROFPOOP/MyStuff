package com.example.demo;

import java.io.*;
import java.util.ArrayList;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        ArrayList<Footballer> footballers = DefinetlyNotADB.getFootballers();
        request.setAttribute("footballers" , footballers);

        request.getRequestDispatcher("/index.jsp").forward(request,response);

    }
    public void doPost(HttpServletRequest request){
        request.getParameter("");
        Integer.parseInt(request.getParameter("f_price"));
    }
    public void destroy() {
    }
}