package nz.ac.vuw.swen301.tuts.service.server;

import java.io.*;
import java.util.Optional;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class OddServiceServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String numberStr = request.getParameter("number");
        if (numberStr == null) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Missing parameter 'number'");
            return;
        }
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        Optional<String> output = oddOrNot(numberStr);
        if(output.isEmpty()) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid input");
            return;
        }
        else
            out.printf("number = %s", output.get());
        out.close();
    }

    private Optional<String> oddOrNot(String input) {
        try  {
            double d = Double.parseDouble(input);
            return Optional.of(Math.round(d) % 2 == 0 ? "Yes" : "No");
        } catch (NumberFormatException e) {
            return Optional.empty();
        }
    }
}
