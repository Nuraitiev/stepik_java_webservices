package servlets;

import accountServer.ResourceServerI;
import resources.TestResource;
import sax.ReadXMLFileSAX;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ResourcePageServlet extends HttpServlet {

    public static final String RESOURCE_URL = "/resources";
    private final  ResourceServerI resourceServer;

    public ResourcePageServlet(ResourceServerI resourceServer) {
        this.resourceServer = resourceServer;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String path = req.getParameter("path");

        TestResource resource = (TestResource) ReadXMLFileSAX.readXML(path);
        resourceServer.setTestResource(resource);
        resp.setContentType("text/html;charset=utf-8");
        resp.getWriter().println(path);
        resp.setStatus(HttpServletResponse.SC_OK);

    }
}
