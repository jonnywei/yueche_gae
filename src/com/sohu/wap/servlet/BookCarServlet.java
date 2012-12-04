package com.sohu.wap.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

import com.sohu.wap.HaijiaMain;

@SuppressWarnings("serial")
public class BookCarServlet extends HttpServlet {
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
		
		req.getContentType().indexOf("application/json");
		
		BufferedReader   reader =new BufferedReader (new InputStreamReader ( req.getInputStream()));
		String line = null;
        StringBuilder sb = new StringBuilder();
		
		while((line =reader.readLine() ) !=null){
			sb.append(line);
		 }
		System.out.println(sb.toString());
		 resp.setContentType("text/plain");
		JSONObject json = null;
		try {
			 json = new JSONObject(sb.toString());
		
			 resp.getWriter().println(""+json.toString(1)+"");
		} catch (JSONException e) {
			 resp.getWriter().println(""+"error");
			e.printStackTrace();
		}
		 
		resp.getWriter().println(""+"over");
		
	}
}
