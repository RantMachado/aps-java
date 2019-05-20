/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pacote;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import static javax.ws.rs.core.HttpHeaders.USER_AGENT;

/**
 *
 * @ Randolfo Gama
 */
public class conversorIp extends HttpServlet {

    private String apiGetDataIpUrl = "http://subnet.im/%s";
    private String apiMethod = "GET";
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String ip = request.getParameter("conversor");
        String dataIp = getDataIp(ip);
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Obter informações IP</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println(dataIp);
            out.println("</body>");
            out.println("</html>");
        }
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    private String getDataIp(String ip) throws ServletException, IOException {
        String inputLine;
        StringBuilder response = new StringBuilder();
        URL obj = new URL(String.format(apiGetDataIpUrl,ip));
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod(apiMethod);
        con.setRequestProperty("User-Agent", USER_AGENT);
        try (BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()))) {
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
        }
        return response.toString();
    }
}
