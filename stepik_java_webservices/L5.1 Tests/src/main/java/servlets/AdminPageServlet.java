package servlets;

import accountServer.AccountServerI;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AdminPageServlet extends HttpServlet {

    public static final String ADMIN_URL = "/admin";
    private final AccountServerI accountServer;

    public AdminPageServlet(AccountServerI accountServer) {
        this.accountServer = accountServer;
    }

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response) throws  IOException {

        response.setContentType("text/html;charset=utf-8");
        int limit = accountServer.getUsersLimit();
        response.getWriter().println(limit);
        response.setStatus(HttpServletResponse.SC_OK);

    }

}
