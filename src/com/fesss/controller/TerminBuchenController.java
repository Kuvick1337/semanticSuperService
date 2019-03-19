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
        name = "TerminBuchenServlet",
        urlPatterns = "/termin_buchen")
public class TerminBuchenController extends HttpServlet {

    private void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Integer saalId;
        String eventName;
        String datumVon;
        String datumBis;
        Integer participants;
        Boolean needFood;

        try {
            saalId = Integer.parseInt(request.getParameter("saal"));
            eventName = request.getParameter("name");
            datumVon = request.getParameter("date_from");
            datumBis = request.getParameter("date_to");
            participants = Integer.parseInt(request.getParameter("participants"));
            needFood = "on".equals(request.getParameter("food"));

            // date fields are always set, but "" if empty
            ControllerUtil.validateTimestampParameter(datumVon);
            ControllerUtil.validateTimestampParameter(datumBis);

            if (TerminService.isSaalAvailable(saalId, datumVon, datumBis)) {
                if (TerminService.addTermin(saalId, eventName, datumVon, datumBis, participants, needFood)) {
                    request.setAttribute("added", "true");
                } else {
                    request.setAttribute("added", "false");
                }
            } else {
                request.setAttribute("isfrei", "false");
            }
        } catch (IllegalArgumentException e) {
            request.setAttribute("incomplete", "true");
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("termin_buchen.jsp");
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
