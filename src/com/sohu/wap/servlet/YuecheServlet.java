package com.sohu.wap.servlet;

import java.io.IOException;
import javax.servlet.http.*;

import com.sohu.wap.HaijiaMain;
import com.sohu.wap.ImageCodeHelper;
import com.sohu.wap.bo.VerifyCode;
import com.sohu.wap.http.HttpUtil4;

@SuppressWarnings("serial")
public class YuecheServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		resp.setContentType("text/html");
		
		resp.getWriter().println("Yueche");
		resp.getWriter().println("<form method='post'>");
		resp.getWriter().println("start:<input type='text' size='4' name='start' ><br/>");
		
		resp.getWriter().println("<input type='submit' value='submit' ><br/>");
		resp.getWriter().println("</form>");
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		
		 String start = req.getParameter("start");
		 if (start.equals("yes")){
			 try {
				HaijiaMain.main(null);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 }
	        
		resp.setContentType("text/plain");
		resp.getWriter().println("SetImgCodeServlet OK");
	}
}
