package carrent.core.web.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.faces.bean.ManagedProperty;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import carrent.core.ejb.mail.service.AuthorizationService;



/**
 * Servlet implementation class Authorization
 */
@WebServlet("/token/tokenAuthorization")
public class Authorization extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	private AuthorizationService authorization;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Authorization() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doGet(HttpServletRequest request,
            HttpServletResponse response)    throws ServletException, IOException {
      PrintWriter out = response.getWriter();

      String authToken = request.getParameter("token");
      
      
      authorization.authorizeCustomer(authToken);
      
      response.setContentType("text/html");
      response.getWriter().println("Your account has been activated");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
