package servlets;

import accounts.AccountService;
import accounts.UserProfile;
import dbService.dataSets.UsersDataSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SignInServlet extends HttpServlet {

    private final AccountService accountService;
    public SignInServlet(AccountService accountService){
        this.accountService = accountService;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");

        //todo check req parameters
        UsersDataSet userProfile = accountService.getUserByLogin(login);
        resp.setContentType("text/html;charset=utf-8");
        if (userProfile != null){
            resp.getWriter().println("Authorized: " + userProfile.getLogin());
            resp.setStatus(HttpServletResponse.SC_OK);

        } else {
            resp.getWriter().println("Unauthorized");
            resp.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        }

    }
}
