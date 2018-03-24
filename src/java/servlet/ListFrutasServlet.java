/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ice
 */
@WebServlet(name = "ListFrutasServlet", urlPatterns = {"/listafrutas.html"})
public class ListFrutasServlet extends HttpServlet {

    List<String> frutas;

    public ListFrutasServlet() {
        frutas = new ArrayList<>();
        frutas.add("damasco");
        frutas.add("gravi");
        frutas.add("melancias");
        frutas.add("jenipapo");
        frutas.add("uva");
        frutas.add("maça");

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Lista de Frutas</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Frutas</h1>");
            out.println("<ul>");
            String ordenacao = request.getParameter("ordenacao");
            LengthComparator length = new LengthComparator();
            switch (ordenacao) {
                case "ran":
                    Collections.shuffle(frutas);
                    break;
                case "tam":
                    Collections.sort(frutas, length);
                    break;
                case "alfa":
                    Collections.sort(frutas);
                    break;

            }
            for (String fruta : frutas) {
                out.println("<li>" + fruta + "</li>");
            }
            out.println("<a href='listafrutas.html?ordenacao=alfa'>Ordem Alfabética</a> /");
            out.println("<a href='listafrutas.html?ordenacao=ran'>Ordem Randômica</a> /");
            out.println("<a href='listafrutas.html?ordenacao=tam'>Ordem por Tamanho</a>)</li>");
            out.println("</ul>");
            out.println("</body>");
            out.println("</html>");
        }
    }

}
