package com.sohu.wap.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Enumeration;

import javax.servlet.http.Cookie;
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
		resp.setContentType("application/json");
		JSONObject json = new JSONObject();
		Cookie[] cookies =req.getCookies();
		if (cookies != null){
			for (Cookie cookie : cookies){
				try {
					json.put(cookie.getName(), cookie.getValue());
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	
		
		JSONObject jh = new JSONObject();
		Enumeration header =req.getHeaderNames();
		
		while (header.hasMoreElements()){
			String name = (String)header.nextElement();
			try {
				jh.put(name, req.getHeader(name));
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		JSONObject result = new JSONObject();
		
		try {
			result.put("cookie", json);
			result.put("header", jh);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		resp.getWriter().println(result.toString());
		 
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
