package servlets;

import accounts.AccountService;
import accounts.UserProfile;
import dbService.dataSets.UsersDataSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SignUpServlet extends HttpServlet {

    private final AccountService accountService;
    public SignUpServlet(AccountService accountService){
        this.accountService = accountService;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException {

        String login = req.getParameter("login");
        String password = req.getParameter("password");

        //todo check req parameters
        accountService.addNewUser(login, password);

        resp.setContentType("text/html;charset=utf-8");
        resp.setStatus(HttpServletResponse.SC_OK);
    }
}
