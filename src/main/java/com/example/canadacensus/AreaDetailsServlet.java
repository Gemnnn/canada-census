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
import java.util.Optional;

@WebServlet(name = "AreaDetailsServlet", urlPatterns = "/area-details")
public class AreaDetailsServlet extends HttpServlet {
    private GeographicAreaDAO dao = new GeographicAreaDAO();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        String username = (String) session.getAttribute("username");
        String password = (String) session.getAttribute("password");
        List<GeographicAreaBean> areas = dao.findAllGeographicAreas(username, password);
        request.setAttribute("areas", areas);

        request.getRequestDispatcher("/area-details.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        String username = (String) session.getAttribute("username");
        String password = (String) session.getAttribute("password");

        if (username == null || password == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        int geographicAreaID = Integer.parseInt(request.getParameter("areaCode"));
        Optional<GeographicAreaBean> areaDetail = dao.findAreaDetailsByGeographicAreaID(geographicAreaID, username, password);

        request.setAttribute("selectedAreaDetail", areaDetail.orElse(null)); // For displaying the selected area details
        List<GeographicAreaBean> areas = dao.findAllGeographicAreas(username, password);
        request.setAttribute("areas", areas);

        request.getRequestDispatcher("/area-details.jsp").forward(request, response);
    }
}