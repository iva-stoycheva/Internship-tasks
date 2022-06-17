package com.example.servlets;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Servlet", value = "/Servlet")
public class Servlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String exp = request.getParameter("expression");
        response.setContentType("text/plain");
        PrintWriter out = null;
        try {
            out=response.getWriter();
            double result = calculate(exp);
            out.println("RESULT: " + result);
            response.getStatus();
        } catch (Exception e){
            out.println(e.getMessage());
        }
    }

    private double calculate(String exp) {
        Expression expression = new ExpressionBuilder(exp).build();
        return expression.evaluate();
    }

    public void destroy() {
        super.destroy();
    }
}
