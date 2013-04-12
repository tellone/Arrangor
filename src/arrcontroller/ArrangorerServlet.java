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
import java.util.ArrayList;
import java.util.Collections;
import src.dbhandler.*;
import src.arrangor.*;

@WebServlet("/")
public class ArrangorerServlet extends HttpServlet {
   
   protected String dbURL = null;
   protected String dbUser = null;
   protected String dbPassword = null;
   private CompareArrangor cmp = null;

   protected ConnectionManager connManager;

   public void init(ServletConfig conf) throws ServletException {
      super.init(conf);
      dbURL = getInitParameter("dbURL");
      dbUser = getInitParameter("dbUserName");
      dbPassword = getInitParameter("dbPassword");
      connManager = new ConnectionManager(dbURL, dbUser, dbPassword);

   }
   
   @Override
   protected void doGet (HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
      String address = "/index.jsp";

      cmp = new CompareArrangor();
      ArrayList<Arrangor> arrangorer = connManager.getAllArrangers();
      req.setAttribute("arrangorer", arrangorer);
      req.getRequestDispatcher(address).forward(req, res);
   }
   
   @Override
   protected void doPost (HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
      
      String name = req.getParameter("name");
      String number = req.getParameter("number");
      String email = req.getParameter("email1");

      connManager.addArranger(name, number, email);
      
      doGet(req, res);
     }

}

