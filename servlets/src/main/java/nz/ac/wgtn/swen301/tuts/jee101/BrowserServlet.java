package nz.ac.wgtn.swen301.tuts.jee101;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

//@WebServlet("/whatsyourbrowser")
public class BrowserServlet extends HttpServlet{
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.printf("""
            <html>
                <body>
                    <p>Test - %s</p>
                </body>
            </html>
            """, request.getHeader("User-Agent"));
        out.close();
    }
}
