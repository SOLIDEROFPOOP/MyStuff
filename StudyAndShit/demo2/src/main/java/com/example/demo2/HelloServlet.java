package com.example.demo2;

import java.io.*;
import java.util.ArrayList;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        ArrayList<Footballer> footballers = DefinitelyNotADB.getFootballers();
        request.setAttribute("footballers" , footballers);
        request.getRequestDispatcher("/index.jsp").forward(request,response);


    }
    public void doPost(HttpServletRequest request){
        Integer.parseInt(request.getParameter("f_id"));
        String name = (String) request.getParameter("f_name");
        Integer.parseInt(request.getParameter("f_salary"));
        String club = (String) request.getParameter("f_club");
        Integer.parseInt(request.getParameter("f_price"));
        Footballer footballer = new Footballer(DefinitelyNotADB.id++,name,Integer.parseInt(request.getParameter("f_salary")),club,Integer.parseInt(request.getParameter("f_price")));
        /*
        int id;
    String name;
    int salary;
    String club;
    int transferPrice;
         */
    }
    public void destroy() {
    }
}