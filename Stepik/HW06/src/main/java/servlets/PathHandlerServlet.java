package servlets;

import org.xml.sax.SAXException;
import resources.ResourceServer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class PathHandlerServlet extends HttpServlet {
    public static final String PAGE_URL = "/resources";
    private ResourceServer resourceServer;
    public PathHandlerServlet(ResourceServer resourceServer) {
        this.resourceServer = resourceServer;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getParameter("path");
        try {
            resourceServer.setInstanceFromXml(path);
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}
