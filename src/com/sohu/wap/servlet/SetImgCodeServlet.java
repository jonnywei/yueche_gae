package com.sohu.wap.servlet;

import java.io.IOException;
import javax.servlet.http.*;

import com.sohu.wap.ImageCodeHelper;
import com.sohu.wap.bo.VerifyCode;
import com.sohu.wap.http.HttpUtil4;

@SuppressWarnings("serial")
public class SetImgCodeServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		
		resp.setContentType("text/html");
		
		resp.getWriter().println("SetImgCodeServlet");
		resp.getWriter().println("<form method='post'>");
		resp.getWriter().println("loginImgCode:<input type='text' size='4' name='loginImgCode' ><br/>");
		resp.getWriter().println("loginCookieValue:<input type='text' size='50' name='loginCookieValue' ><br/>");
		resp.getWriter().println("bookImgCode:<input type='text' size='4' name='bookImgCode' ><br/>");
		resp.getWriter().println("bookCookieValue:<input type='text' size='50' name='bookCookieValue' ><br/>");
		resp.getWriter().println("<input type='submit' value='submit' ><br/>");
		resp.getWriter().println("</form>");
		
		
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		
		 String imageCode = req.getParameter("loginImgCode");
		 String cookieValue = req.getParameter("loginCookieValue");
		 
		 String bimageCode = req.getParameter("bookImgCode");
		 String bcookieValue = req.getParameter("bookCookieValue");
		 
		 VerifyCode vc = new  VerifyCode(imageCode, cookieValue);
	        
	     ImageCodeHelper.IMAGE_CODE_COOKIE.put(ImageCodeHelper.LOGIN_IMG_CODE, vc);
	     
	    
	     VerifyCode bcookie = new  VerifyCode(bimageCode, bcookieValue);
	        
	     ImageCodeHelper.IMAGE_CODE_COOKIE.put(ImageCodeHelper.BOOKING_IMG_CODE, bcookie);
	        
	        
		resp.setContentType("text/plain");
		resp.getWriter().println("SetImgCodeServlet OK");
	}
}
