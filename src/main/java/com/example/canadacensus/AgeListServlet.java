package com.example.canadacensus;

import dao.AgeDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import models.AgeData;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "AgeListServlet", urlPatterns = "/age-list")
public class AgeListServlet extends HttpServlet {
    private AgeDAO ageDAO = new AgeDAO();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        String username = (String) session.getAttribute("username");
        String password = (String) session.getAttribute("password");

        if (username == null || password == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        int[] years = {2016, 2021};
        List<AgeData> ageData = ageDAO.getPopulationDataByYear(years, username, password);
        request.setAttribute("ageData", ageData);
        request.getRequestDispatcher("/age-list.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}