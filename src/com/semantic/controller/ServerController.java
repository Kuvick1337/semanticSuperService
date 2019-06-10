package com.semantic.controller;

import com.semantic.sparql.ServerList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ServerServlet", urlPatterns = "/server")
public class ServerController extends HttpServlet {

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if (request.getParameter("add") != null) {
            request.setAttribute("add", ServerList.getInstance().add(request.getParameter("server")));
        } else if (request.getParameter("delete") != null) {
            request.setAttribute("remove", ServerList.getInstance().remove(request.getParameter("server")));
        } else {
            System.out.println("unknown Param");
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("servers.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }
}
