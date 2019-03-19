package com.fesss.controller;

import com.fesss.service.TerminService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(
        name = "TerminAnfrageServlet",
        urlPatterns = "/termin_anfrage")
public class TerminAnfrageController extends HttpServlet {

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Integer saalId = Integer.parseInt(request.getParameter("saal"));
            String datumVon = request.getParameter("date_from");
            String datumBis = request.getParameter("date_to");

            // date fields are always set, but "" if empty
            ControllerUtil.validateTimestampParameter(datumVon);
            ControllerUtil.validateTimestampParameter(datumBis);

            if (TerminService.isSaalAvailable(saalId, datumVon, datumBis)) {
                request.setAttribute("isfrei", "true");
            } else {
                request.setAttribute("isfrei", "false");
            }
        } catch (IllegalArgumentException e){
            request.setAttribute("incomplete", "true");
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher(
                "termin_anfrage.jsp");
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
