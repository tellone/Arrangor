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

@WebServlet("/arrangers/*")
public class ArrangerServlet extends HttpServlet {
   
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

   protected void doGet (HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
      List<Arrangor> arrangorer = connManager.getAllArrangers();
      req.setAttribute("Arrangorer", arrangorer);
      req.getRequestDispatcher("/WEB-INF/show.jsp").forward(req, res);
   }
   protected void doPost (HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
   
   }

}

