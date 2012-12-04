package com.sohu.wap.http;
/**
 *@version:2011-9-20-下午02:25:51
 *@author:jianjunwei
 *@date:下午02:25:51
 *
 */


import java.util.List;

import org.apache.http.cookie.Cookie;
import org.apache.http.impl.cookie.BasicClientCookie;




/**
 * 
 *HttpUtil4Exposer 暴露了 HttpUtil4的httpClient对象
 * @author jianjunwei
 *
 */
public class HttpUtil4Exposer extends HttpUtil4
{ 
    
    private HttpUtil4Exposer(boolean haveCookie)
    {
        super(haveCookie);
     
    }
    
    
    /**
     * 
     *工厂方法，产生httpClient实例 
     * 
     */
    public static HttpUtil4Exposer createHttpClient(){
        return  new HttpUtil4Exposer(true);
    }
    
    
    
    public void addCookie(String name, String value){
        BasicClientCookie cookie =null;
      
        List<Cookie> list = httpClient.getCookieStore().getCookies();
        for (Cookie ck : list){
            if (ck.getName().equals(name)){
                cookie =(BasicClientCookie) ck;
                break;
            }
        }
        
        if (cookie != null){
            cookie.setValue(value);
        }
        else{
            cookie = new BasicClientCookie(name, value);
            cookie.setPath("/");
            cookie.setVersion(0);
            cookie.setDomain("haijia.bjxueche.net");
        }
        
        httpClient.getCookieStore().addCookie(cookie);
        
    }
    
    
    public String getCookieValue(String name){
        
        BasicClientCookie cookie =null;
        List<Cookie> list = httpClient.getCookieStore().getCookies();
        for (Cookie ck : list){
            if (ck.getName().equals(name)){
                cookie =(BasicClientCookie) ck;
                break;
            }
        }
        
        if (cookie != null){
          return  cookie.getValue();
        }
        
        return null;
    }
    
}
