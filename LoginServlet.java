package control;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Operation;

 // ログイン処理を行うサーブレット
@WebServlet("/login-servlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		String userId = request.getParameter("userId");
		String password = request.getParameter("password");

		
		String url = "select.jsp";		
		try {
			
			HttpSession session = request.getSession();	
			Operation op = new Operation();
			boolean result = op.loginProc(userId, password, session);

			if (!result) {					
				request.setAttribute("errorMsg", "ユーザID または パスワードに 誤りがあります。");	
				url = "login.jsp";
			}
		} catch (Exception e) {				
			request.setAttribute("errorMsg", "ログイン時にエラーが発生しました。");	
			url = "login.jsp";
		}
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
}
