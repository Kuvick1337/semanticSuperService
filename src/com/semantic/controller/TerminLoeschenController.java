package com.semantic.controller;

import com.semantic.service.TerminService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(
        name = "TerminLoeschenServlet",
        urlPatterns = "/termin_loeschen")
public class TerminLoeschenController extends HttpServlet {


    private void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Integer saalId;
        String eventName;
        String datumVon;

        try {
            saalId = Integer.parseInt(request.getParameter("saal"));
            eventName = request.getParameter("name");
            datumVon = request.getParameter("date_from");

            // date fields are always set, but "" if empty
            ControllerUtil.validateTimestampParameter(datumVon);

            if (TerminService.deleteTermin(saalId, eventName, datumVon)) {
                request.setAttribute("deleted", "true");
            } else {
                request.setAttribute("deleted", "false");
            }
        } catch (IllegalArgumentException e) {
            request.setAttribute("incomplete", "true");
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("termin_loeschen.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doGet(
            HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        processRequest(request, response);
    }

    @Override
    protected void doPost(
            HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        processRequest(request, response);
    }
}
