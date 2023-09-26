package com.lab.web.lab_02;

import java.io.*;
import com.lab.web.lab_02.lib.CalculationResult;
import com.lab.web.lab_02.lib.FunCalculator;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "calculateServlet", value = "")
public class CalculateServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        request.getRequestDispatcher("/calc.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        double a;
        double min_x;
        double max_x;
        double step;
        double breakline;

        try {
            a = Double.parseDouble(request.getParameter("src_a"));
            request.setAttribute("src_a", a);
            min_x = Double.parseDouble(request.getParameter("src_x_min"));
            request.setAttribute("src_x_min", min_x);
            max_x = Double.parseDouble(request.getParameter("src_x_max"));
            request.setAttribute("src_x_max", max_x);
            step = Double.parseDouble(request.getParameter("src_step"));
            request.setAttribute("src_step", step);
            breakline = Double.parseDouble(request.getParameter("src_breakline"));
            request.setAttribute("src_breakline", breakline);
        } catch (NumberFormatException e) {
            request.setAttribute("error", "Invalid value");
            request.setAttribute("error_details", e.toString());
            request.getRequestDispatcher("/calc.jsp").forward(request, response);
            return;
        }

        FunCalculator calc = new FunCalculator(a, min_x, max_x, step, breakline);
        CalculationResult res = calc.compute();
        request.setAttribute("result", res);
        request.getRequestDispatcher("/calc.jsp").forward(request, response);
    }
}