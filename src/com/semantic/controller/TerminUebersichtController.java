package com.semantic.controller;

import com.semantic.model.Termin;
import com.semantic.repository.TerminRepository;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(
        name = "TerminUebersichtServlet",
        urlPatterns = "/termin_uebersicht")
public class TerminUebersichtController extends HttpServlet {

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Termin> terminList1 = TerminRepository.getTermineForSaal(1);
        List<Termin> terminList2 = TerminRepository.getTermineForSaal(2);

        request.setAttribute("terminList1", terminList1);
        request.setAttribute("terminList2", terminList2);

        RequestDispatcher dispatcher = request.getRequestDispatcher("termin_uebersicht.jsp");
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

