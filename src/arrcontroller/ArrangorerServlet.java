package src.arrcontroller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;
import java.util.List;
import src.dbhandler.*;
import src.arrangor.*;

@WebServlet("/arrangorer")
public class ArrangorerServlet extends HttpServlet {
   
   protected String dbURL = null;
   protected String dbUser = null;
   protected String dbPassword = null;
   protected ConnectionManager connManager = null;

   public void init(ServletConfig conf) throws ServletException {
      super.init(conf);
      dbURL = getInitParameter("dbURL");
      dbUser = getInitParameter("dbUser");
      dbPassword = getInitParameter("dbPassword");
      connManager = new ConnectionManager(dbURL, dbUser, dbPassword);

   }
   
   @Override
   protected void doGet (HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
      String view = req.getPathInfo().substring(1);
      String address = null;
      if (view.equals("show")) {
         address = "/WEB-INF/show.jsp";
         List<Arrangor> arrangorer = connManager.getAllArrangers();
         req.setAttribute("Arrangorer", arrangorer);
         req.getRequestDispatcher(address).forward(req, res);
      } else if (view.equals("add")) {
      
         address = "/WEB-INF/add.jsp";
         req.getRequestDispatcher(address).forward(req, res);
      } else {
         
         address = "/arrangorer/index.jsp";
         res.sendRedirect(address);
      }
   }
   
   @Override
   protected void doPost (HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
      doGet(req, res); 
   }

}

