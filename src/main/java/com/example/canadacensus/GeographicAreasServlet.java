package com.example.canadacensus;

import dao.GeographicAreaDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import beans.GeographicAreaBean;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet(name = "GeographicAreasServlet", urlPatterns = "/geographic-areas")
public class GeographicAreasServlet extends HttpServlet {
    private GeographicAreaDAO dao = new GeographicAreaDAO();
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        String username = (String) session.getAttribute("username");
        String password = (String) session.getAttribute("password");

        if (username == null || password == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        Map<Integer, List<GeographicAreaBean>> areasByLevel = dao.findAllAreasGroupedByLevel(username, password);
        request.setAttribute("areasByLevel", areasByLevel);
        request.getRequestDispatcher("/geographic-areas.jsp").forward(request, response);

    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}